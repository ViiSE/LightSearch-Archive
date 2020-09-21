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

import lightsearch.client.bot.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;

@Service("messageSenderProducerDefault")
public class MessageSenderProducerDefaultImpl implements MessageSenderProducer {

    private final String MESSAGE_SENDER = "messageSenderDefault";

    @Autowired
    private ApplicationContext ctx;

    @Override
    public MessageSender getMessageSenderDefaultInstance(DataOutputStream dataOutputStream) {
        return (MessageSender) ctx.getBean(MESSAGE_SENDER, dataOutputStream);
    }
}
