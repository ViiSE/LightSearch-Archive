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
package lightsearch.admin.panel.data;

import org.testng.annotations.BeforeClass;
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
public class ConnectionDTOTestNG {

    private ConnectionDTO connectionDTO;

    @BeforeClass
    @Parameters({"ip", "port"})
    public void setUpClass(String ip, int port) {
        assertNotNull(ip, "IP is null!");
        assertFalse(ip.isEmpty(), "IP is null!");
        assertFalse(port < 1023 || port > 65535, "Wrong port number!");

        connectionDTO = ConnectionDTOInit.connectionDTO(ip, port);
        assertNotNull(connectionDTO, "ConnectionDTO is null!");
    }

    @Test
    public void ip() {
        testBegin("ConnectionDTO", "ip()");
        
        System.out.println("ip: "  + connectionDTO.ip());
        
        testEnd("ConnectionDTO", "ip()");
    }
    
    @Test
    public void port() {
        testBegin("ConnectionDTO", "port()");
        
        System.out.println("port: " + connectionDTO.port());
        
        testEnd("ConnectionDTO", "port()");
    }
}
