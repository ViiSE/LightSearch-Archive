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

package ru.viise.lightsearch.cmd.processor;

import java.util.function.Function;

import ru.viise.lightsearch.cmd.CommandTypeEnum;
import ru.viise.lightsearch.cmd.result.CommandResult;
import ru.viise.lightsearch.cmd.result.creator.CommandResultCreator;
import ru.viise.lightsearch.cmd.result.creator.CommandResultCreatorInit;
import ru.viise.lightsearch.data.ClientCommandDTO;
import ru.viise.lightsearch.data.CommandCancelSoftCheckDTO;
import ru.viise.lightsearch.data.CommandDTO;
import ru.viise.lightsearch.data.ReconnectDTO;
import ru.viise.lightsearch.data.ReconnectDTOInit;
import ru.viise.lightsearch.exception.CommandResultCreatorException;
import ru.viise.lightsearch.exception.MessageRecipientException;
import ru.viise.lightsearch.exception.MessageSenderException;
import ru.viise.lightsearch.message.MessageRecipient;
import ru.viise.lightsearch.message.MessageSender;
import ru.viise.lightsearch.message.type.MessageCancelSoftCheck;
import ru.viise.lightsearch.message.type.MessageCancelSoftCheckInit;

public class CancelSoftCheckProcessor implements Function<CommandDTO, CommandResult> {

    private final String IMEI;
    private final MessageSender msgSender;
    private final MessageRecipient msgRecipient;

    public CancelSoftCheckProcessor(ClientCommandDTO clCmdDTO) {
        IMEI = clCmdDTO.IMEI();
        msgSender = clCmdDTO.messageSender();
        msgRecipient = clCmdDTO.messageRecipient();
    }

    @Override
    public CommandResult apply(CommandDTO commandDTO) {
        CommandCancelSoftCheckDTO cmdCancelSCDTO = (CommandCancelSoftCheckDTO) commandDTO;
        try {
            MessageCancelSoftCheck msgCancelSC = MessageCancelSoftCheckInit.messageCancelSoftCheck(
                    IMEI, cmdCancelSCDTO);
            String message = msgCancelSC.message();
            msgSender.sendMessage(message);
            String rawMessage = msgRecipient.acceptMessage();
            CommandResultCreator cmdResCr =
                    CommandResultCreatorInit.commandResultCancelSoftCheckCreator(rawMessage, IMEI,
                            cmdCancelSCDTO.isCart());
            return cmdResCr.createCommandResult();
        } catch(CommandResultCreatorException ex) {
            return errorCommandResult(ex.getMessageRU(), null);
        } catch(MessageSenderException | MessageRecipientException ex) {
            ReconnectDTO recDTO = ReconnectDTOInit.reconnectDTO(cmdCancelSCDTO, CommandTypeEnum.CANCEL_SOFT_CHECK);
            return errorCommandResult(ex.getMessageRU(), recDTO);
        }
    }

    private CommandResult errorCommandResult(String message, ReconnectDTO reconnectDTO) {
        try {
            CommandResultCreator cmdResCr =
                    CommandResultCreatorInit.commandResultCancelSoftCheckCreator(false, message,
                            reconnectDTO, false);
            return cmdResCr.createCommandResult();
        }
        catch(CommandResultCreatorException ignore) { return null; /* never happen */ }
    }
}
