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
package lightsearch.server.message;

import lightsearch.server.exception.MessageSenderException;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Реализация интерфейса {@link lightsearch.server.message.MessageSender} по умолчанию.
 * <p>
 * Отправка сообщения происходит через {@link java.io.DataOutputStream}. Записываются UTF символы.
 * @author ViiSE
 * @since 1.0.0
 */
public class MessageSenderDefaultImpl implements MessageSender {

    private final DataOutputStream dataOutputStream;
    
    public MessageSenderDefaultImpl(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void sendMessage(String message) throws MessageSenderException {
        try {
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        }
        catch(IOException ex) {
            throw new MessageSenderException(ex.getMessage());
        }
    }
    
}
