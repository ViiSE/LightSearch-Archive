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

import lightsearch.admin.panel.cmd.message.MessageCommandCreator;
import lightsearch.admin.panel.cmd.message.MessageCommandEnum;
import lightsearch.admin.panel.cmd.result.CommandResult;
import lightsearch.admin.panel.data.AdminCommandDAO;
import lightsearch.admin.panel.data.AdminCommandDAOInit;
import org.testng.annotations.*;
import test.TestServer;
import test.data.DataProviderCreator;

import java.util.Map;
import java.util.function.Function;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class TimeoutClientMessageProcessorTestNG {
    
    private final String TIMEOUT_CLIENT = MessageCommandEnum.TIMEOUT_CLIENT.stringValue();
    
    private Map<String, Function<AdminCommandDAO, CommandResult>> msgCmdHolder;

    @BeforeTest
    @Parameters({"ip", "port"})
    public void setUpTest(String ip, int port) {
        if(!TestServer.serverOn) {
            Thread testServerTh = new Thread(new TestServer(port));
            testServerTh.start();
        }
    }

    @BeforeClass
    @Parameters({"ip", "port", "toutClMessage"})
    public void setUpMethod(String ip, int port, String answerMessage) {
        TestServer.closeClient = false;
        TestServer.setAnswerMessage(answerMessage);

        MessageCommandCreator msgCmdCreator = DataProviderCreator.createDataProvider(MessageCommandCreator.class, ip, port);
        assertNotNull(msgCmdCreator, "MessageCommandCreator is null!");

        msgCmdHolder = msgCmdCreator.createMessageCommandHolder();
        assertNotNull(msgCmdHolder, "MessageCommandHolder is null!");
    }
    
    @Test
    @Parameters({"adminName", "clientTimeout"})
    public void apply(String adminName, String clientTimeout) {
        testBegin("TimeoutClientMessageProcessor", "apply()");
        
        assertNotNull(adminName, "Name is null!");
        assertFalse(adminName.isEmpty(), "Name is null!");
        
        assertNotNull(clientTimeout, "ClientTimeout name is null!");
        assertFalse(clientTimeout.isEmpty(), "ClientTimeout name is null!");
        
        Function<AdminCommandDAO, CommandResult> processor = msgCmdHolder.get(TIMEOUT_CLIENT);
        assertNotNull(processor, "TimeoutClientMessageProcessor is null!");
        
        AdminCommandDAO admCmdDAO = AdminCommandDAOInit.adminCommandDAO();
        assertNotNull(admCmdDAO, "AdminCommandDAO is null!");
        admCmdDAO.setName(adminName);
        assertNotNull(admCmdDAO.name(), "AdminCommandDAO: name is null!");
                
        admCmdDAO.setClientTimeout(clientTimeout);
        assertNotNull(admCmdDAO.clientTimeout(), "AdminCommandDAO: clientTimeout is null!");
        
        CommandResult cmdRes = processor.apply(admCmdDAO);
        assertNotNull(cmdRes, "CommandResult is null!");
        
        String nameRes = cmdRes.name();
        assertNotNull(nameRes, "CommandResult: name is null!");
        assertFalse(nameRes.isEmpty(), "CommandResult: name is null!");
        
        String isDone = cmdRes.isDone();
        assertNotNull(isDone, "CommandResult: isDone is null!");
        assertFalse(isDone.isEmpty(), "CommandResult: isDone is null!");
        
        String message = cmdRes.message();
        assertNotNull(message, "CommandResult: message is null!");
        assertFalse(message.isEmpty(), "CommandResult: message is null!");
        
        System.out.println("CommandResult: name " + nameRes);
        System.out.println("CommandResult: isDone " + isDone);
        System.out.println("CommandResult: message " + message);
        
        testEnd("TimeoutClientMessageProcessor", "apply()");
    }
    
    @AfterClass
    public void closeMethod() {
        TestServer.closeClient = true;
    }
}
