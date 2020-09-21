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

package lightsearch.client.bot.producer;

import lightsearch.client.bot.message.MessageRecipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.DataInputStream;

@Service("messageRecipientProducerDefault")
public class MessageRecipientProducerDefaultImpl implements MessageRecipientProducer {

    private final String MESSAGE_RECIPIENT_DEFAULT = "messageRecipientDefault";
    private final String MESSAGE_RECIPIENT_DEBUG   = "messageRecipientDebug";

    @Autowired
    private ApplicationContext ctx;

    @Override
    public MessageRecipient getMessageRecipientDefaultInstance(DataInputStream dataInputStream) {
        return (MessageRecipient) ctx.getBean(MESSAGE_RECIPIENT_DEFAULT, dataInputStream);
    }

    @Override
    public MessageRecipient getMessageRecipientDebugInstance(DataInputStream dataInputStream) {
        return (MessageRecipient) ctx.getBean(MESSAGE_RECIPIENT_DEBUG, dataInputStream);
    }
}
