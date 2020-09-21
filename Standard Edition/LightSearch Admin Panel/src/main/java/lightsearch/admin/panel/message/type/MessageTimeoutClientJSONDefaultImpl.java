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
package lightsearch.admin.panel.message.type;

import lightsearch.admin.panel.cmd.message.MessageCommandContentEnum;
import lightsearch.admin.panel.cmd.message.MessageCommandEnum;
import org.json.simple.JSONObject;

/**
 *
 * @author ViiSE
 */
public class MessageTimeoutClientJSONDefaultImpl implements MessageTimeoutClient {
    
    private final String TIMEOUT_CLIENT = MessageCommandEnum.TIMEOUT_CLIENT.stringValue();
    private final String COMMAND        = MessageCommandContentEnum.COMMAND.stringValue();
    private final String NAME           = MessageCommandContentEnum.ADMIN_NAME.stringValue();
    private final String CLIENT_TIMEOUT = MessageCommandContentEnum.CLIENT_TIMEOUT.stringValue();
    
    private final String name;
    private final String clientTimeout;

    public MessageTimeoutClientJSONDefaultImpl(String name, String clientTimeout) {
        this.name = name;
        this.clientTimeout = clientTimeout;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String message() {
        JSONObject msgToutClientObj = new JSONObject();
        msgToutClientObj.put(COMMAND, TIMEOUT_CLIENT);
        msgToutClientObj.put(NAME, name);
        msgToutClientObj.put(CLIENT_TIMEOUT, clientTimeout);
        return msgToutClientObj.toJSONString();
    }
}
