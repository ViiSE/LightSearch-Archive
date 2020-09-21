/*
 *  Copyright 2020 ViiSE.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package ru.viise.lightsearch.message.type;

import org.json.simple.JSONObject;

import ru.viise.lightsearch.cmd.ClientCommandContentEnum;
import ru.viise.lightsearch.cmd.ClientCommandEnum;
import ru.viise.lightsearch.data.CommandBindDTO;

public class MessageBindJSONDefaultImpl implements MessageBind {

    private final String BIND            = ClientCommandEnum.BIND.stringValue();
    private final String COMMAND         = ClientCommandContentEnum.COMMAND.stringValue();
    private final String IMEI_FIELD      = ClientCommandContentEnum.IMEI.stringValue();
    private final String BARCODE         = ClientCommandContentEnum.BARCODE.stringValue();
    private final String FACTORY_BARCODE = ClientCommandContentEnum.FACTORY_BARCODE.stringValue();
    private final String USER_IDENT      = ClientCommandContentEnum.USER_IDENT.stringValue();

    private final String IMEI;
    private final CommandBindDTO cmdCheckBindingDTO;

    public MessageBindJSONDefaultImpl(String IMEI, CommandBindDTO cmdCheckBindingDTO) {
        this.IMEI = IMEI;
        this.cmdCheckBindingDTO = cmdCheckBindingDTO;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String message() {
        JSONObject msgSearchObj = new JSONObject();
        msgSearchObj.put(COMMAND, BIND);
        msgSearchObj.put(IMEI_FIELD, IMEI);
        msgSearchObj.put(BARCODE, cmdCheckBindingDTO.barcode());
        msgSearchObj.put(FACTORY_BARCODE, cmdCheckBindingDTO.factoryBarcode());
        msgSearchObj.put(USER_IDENT, cmdCheckBindingDTO.userIdent());
        return msgSearchObj.toJSONString();
    }
}
