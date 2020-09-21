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
package lightsearch.client.bot.processor;

import lightsearch.client.bot.data.BotDAO;
import lightsearch.client.bot.message.MessageRecipient;
import lightsearch.client.bot.message.MessageSender;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.data.DataProviderCreator;

import java.net.Socket;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class ProcessorCancelSoftCheckDefaultImplTestNG {
    
    private BotDAO botDAO;
    private MessageSender msgSender;
    private MessageRecipient msgRecipient;

    @BeforeClass
    @Parameters({"ip", "port", "answerCancelSC"})
    public void setUpClass(String ip, int port, String answerMessage) {
        Thread serverThread = new Thread(new TestProcessorServer(port, answerMessage));
        serverThread.start();
        
        botDAO = DataProviderCreator.createDataProvider(BotDAO.class);
        Socket socket = DataProviderCreator.createDataProvider(Socket.class, ip, port);
        msgSender = DataProviderCreator.createDataProvider(MessageSender.class, socket);
        msgRecipient = DataProviderCreator.createDataProvider(MessageRecipient.class, socket);
    }
    
    @Test
    @Parameters("delayMessageDisplay")
    public void apply(long delayMessageDisplay) {
        testBegin("ProcessorCancelSoftCheckDefaultImpl", "apply()");
        
        assertNotNull(botDAO, "BotDAO is null!");
        assertNotNull(msgSender, "MessageSender is null!");
        assertNotNull(msgRecipient, "MessageRecipient is null!");
        assertFalse(delayMessageDisplay < 0, "DelayMessageDisplay is less than 0!");
        Processor proc = new ProcessorCancelSoftCheckDefaultImpl();
        proc.apply(botDAO, msgSender, msgRecipient, delayMessageDisplay);
        
        testEnd("ProcessorCancelSoftCheckDefaultImpl", "apply()");
    }
}
