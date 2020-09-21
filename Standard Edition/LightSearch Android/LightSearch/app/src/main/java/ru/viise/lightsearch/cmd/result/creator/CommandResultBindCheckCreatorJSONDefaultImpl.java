/*
 * Copyright 2019 ViiSE.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.viise.lightsearch.cmd.result.creator;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.viise.lightsearch.cmd.ClientCommandContentEnum;
import ru.viise.lightsearch.cmd.result.BindCommandResultInit;
import ru.viise.lightsearch.cmd.result.CommandResult;
import ru.viise.lightsearch.cmd.result.verify.ResultCommandVerifier;
import ru.viise.lightsearch.cmd.result.verify.ResultCommandVerifierInit;
import ru.viise.lightsearch.data.BindRecord;
import ru.viise.lightsearch.data.ReconnectDTO;
import ru.viise.lightsearch.data.creator.BindRecordsCreator;
import ru.viise.lightsearch.data.creator.BindRecordsCreatorInit;
import ru.viise.lightsearch.exception.CommandResultCreatorException;
import ru.viise.lightsearch.exception.MessageParserException;
import ru.viise.lightsearch.message.parser.MessageParser;
import ru.viise.lightsearch.message.parser.MessageParserInit;

public class CommandResultBindCheckCreatorJSONDefaultImpl implements CommandResultCreator {

    private final String IS_DONE    = ClientCommandContentEnum.IS_DONE.stringValue();
    private final String IMEI_FIELD = ClientCommandContentEnum.IMEI.stringValue();
    private final String DATA       = ClientCommandContentEnum.DATA.stringValue();
    private final String MESSAGE    = ClientCommandContentEnum.MESSAGE.stringValue();

    private final String rawMessage;
    private final String IMEI;
    private final int selected;
    private final String factoryBarcode;

    public CommandResultBindCheckCreatorJSONDefaultImpl(
            String rawMessage,
            String IMEI,
            int selected,
            String factoryBarcode) {
        this.rawMessage = rawMessage;
        this.IMEI = IMEI;
        this.selected = selected;
        this.factoryBarcode = factoryBarcode;
    }

    @Override
    public CommandResult createCommandResult() throws CommandResultCreatorException {
        try {
            MessageParser msgParser = MessageParserInit.messageParser();
            JSONObject objMsg = (JSONObject)msgParser.parse(rawMessage);
            String incomingIMEI = Objects.requireNonNull(objMsg.get(IMEI_FIELD)).toString();

            String incomingIsDone = Objects.requireNonNull(objMsg.get(IS_DONE)).toString();
            ResultCommandVerifier resCmdVerifier =
                    ResultCommandVerifierInit.resultCommandVerifier(incomingIMEI, IMEI, incomingIsDone);

            boolean isDone = resCmdVerifier.verify();

            if(!isDone) {
                return BindCommandResultInit.bindCheckCommandResult(
                        false,
                        Objects.requireNonNull(objMsg.get(MESSAGE)).toString(),
                        new ArrayList<>(),
                        null,
                        selected,
                        factoryBarcode);
            } else {
                BindRecordsCreator bindRecsDTOCr =
                        BindRecordsCreatorInit.bindRecordsCreator(objMsg.get(DATA));
                List<BindRecord> bindRecords = bindRecsDTOCr.create();

                return BindCommandResultInit.bindCheckCommandResult(
                        true,
                        null,
                        bindRecords,
                        null,
                        selected,
                        factoryBarcode);
            }
        } catch(MessageParserException | NullPointerException ex) {
            throw new CommandResultCreatorException(ex.getMessage(), true);
        }
    }
}
