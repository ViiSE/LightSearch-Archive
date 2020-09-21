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
public class MessageCreateAdminTestNG {

    @Test
    @Parameters({"name", "adminName", "password"})
    public void message(String name, String adminName, String password) {
        testBegin("MessageCreateAdmin", "message()");
        
        assertNotNull(name, "Name is null!");
        assertFalse(name.isEmpty(), "Name is null!");

        assertNotNull(adminName, "Admin name is null!");
        assertFalse(adminName.isEmpty(), "Admin name is null!");
        
        assertNotNull(password, "Password is null!");
        assertFalse(password.isEmpty(), "Password is null!");
        
        MessageCreateAdmin msgCrAdmin = MessageCreateAdminInit.messageCreateAdmin(name, adminName, password);
        assertNotNull(msgCrAdmin, "MessageCreateAdmin is null!");
        
        String message = msgCrAdmin.message();
        assertNotNull(message, "Message is null!");
        assertFalse(message.isEmpty(), "Message is null!");
        
        System.out.println("Message: " + message);
        
        testEnd("MessageCreateAdmin", "message()");
    }
}
