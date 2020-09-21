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

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class MessageChangeDatabaseTestNG {
    
    @Test
    @Parameters({"name", "dbName", "ip", "port"})
    public void message(String name, String dbName, String ip, String port) {
        testBegin("MessageChangeDatabase", "message()");
        
        assertNotNull(name, "Name is null!");
        assertFalse(name.isEmpty(), "Name is null!");
        
        assertNotNull(dbName, "Database name is null!");
        assertFalse(dbName.isEmpty(), "Database name is null!");
        
        assertNotNull(ip, "IP is null!");
        assertFalse(ip.isEmpty(), "IP is null!");
        
        assertNotNull(port, "Port is null!");
        assertFalse(port.isEmpty(), "Port is null!");
        
        MessageChangeDatabase msgChDb = MessageChangeDatabaseInit.messageChangeDatabase(name, dbName, ip, port);
        assertNotNull(msgChDb, "MessageChangeDatabase is null!");
        
        String message = msgChDb.message();
        assertNotNull(message, "Message is null!");
        assertFalse(message.isEmpty(), "Message is null!");
        
        System.out.println("Message: " + message);
        
        testEnd("MessageChangeDatabase", "message()");
    }
}
