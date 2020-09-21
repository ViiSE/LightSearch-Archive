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
package lightsearch.server.cmd.client;

import lightsearch.server.exception.CommandConverterException;
import lightsearch.server.exception.MessageParserException;
import lightsearch.server.message.parser.MessageParser;
import lightsearch.server.message.parser.MessageParserInit;

/**
 * Реализация интерфейса {@link lightsearch.server.cmd.client.ClientCommandConverter} по умолчанию.
 * @author ViiSE
 * @since 1.0.0
 */
public class ClientCommandConverterDefaultImpl implements ClientCommandConverter {
    
    @Override
    public ClientCommand convertToClientCommand(String message) throws CommandConverterException {
        if(message != null) {
            try {
                MessageParser parser = MessageParserInit.messageParser();
                Object clientInfo = parser.parse(message);

                return ClientCommandInit.clientCommand(clientInfo);
            } catch(MessageParserException ex) {
                throw new CommandConverterException(ex.getMessage());
            }
        } else throw new CommandConverterException("Message is null");
    }
    
}
