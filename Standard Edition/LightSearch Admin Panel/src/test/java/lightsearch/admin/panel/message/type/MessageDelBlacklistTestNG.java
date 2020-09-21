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
public class MessageDelBlacklistTestNG {
    
    @Test
    @Parameters({"name", "IMEI"})
    public void message(String name, String IMEI) {
        testBegin("MessageDelBlacklist", "message()");

        assertNotNull(name, "Name is null!");
        assertFalse(name.isEmpty(), "Name is null!");
        
        assertNotNull(IMEI, "IMEI is null!");
        assertFalse(IMEI.isEmpty(), "IMEI is null!");
        
        MessageDelBlacklist msgDelBl = MessageDelBlacklistInit.messageDelBlacklist(name, IMEI);
        assertNotNull(msgDelBl, "MessageDelBlacklist is null!");
        
        String message = msgDelBl.message();
        assertNotNull(message, "Message is null!");
        assertFalse(message.isEmpty(), "Message is null!");
        
        System.out.println("Message: " + message);
        
        testEnd("MessageDelBlacklist", "message()");
    }
}
