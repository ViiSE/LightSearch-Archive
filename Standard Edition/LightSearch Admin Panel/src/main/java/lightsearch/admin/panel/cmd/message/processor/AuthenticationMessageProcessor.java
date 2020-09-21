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
package lightsearch.admin.panel.cmd.message.processor;

import lightsearch.admin.panel.cmd.result.CommandResult;
import lightsearch.admin.panel.data.AdminCommandDAO;
import lightsearch.admin.panel.data.MessageCommandDTO;
import lightsearch.admin.panel.exception.MessageRecipientException;
import lightsearch.admin.panel.exception.MessageSenderException;
import lightsearch.admin.panel.message.type.MessageAuthentication;
import lightsearch.admin.panel.message.type.MessageAuthenticationInit;

/**
 *
 * @author ViiSE
 */
public class AuthenticationMessageProcessor extends AbstractProcessorMessage {
    
    public AuthenticationMessageProcessor(MessageCommandDTO messageCommandDTO) {
        super(messageCommandDTO);
    }

    @Override
    public CommandResult apply(AdminCommandDAO admCmdDAO) {
        try {
            MessageAuthentication messageAuthentication =
                    MessageAuthenticationInit.messageAuthentication(admCmdDAO.name(), admCmdDAO.password());
            String messageAuth = messageAuthentication.message();
            super.messageCommandDTO().messageSender().sendMessage(messageAuth);
            
            String rawMessage = super.messageCommandDTO().messageRecipient().acceptMessage();
            
            return super.commandResult(rawMessage);
        } catch(MessageSenderException | MessageRecipientException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
