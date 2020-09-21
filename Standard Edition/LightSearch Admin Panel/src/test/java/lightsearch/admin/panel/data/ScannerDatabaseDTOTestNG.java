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

import lightsearch.admin.panel.data.creator.ScannerDatabaseDTOCreatorInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class ScannerDatabaseDTOTestNG {
    
    private ScannerDatabaseDTO scDbDTO;
    
    @BeforeClass
    public void setUpMethod() {
        scDbDTO = ScannerDatabaseDTOCreatorInit.scannerDatabaseDTOCreator().createScannerDatabaseDTO();
        assertNotNull(scDbDTO, "ScannerDatabaseDTO is null!");
    }
    
    @Test
    public void scanner() {
        testBegin("ScannerDatabaseDTO", "scanner()");
        
        assertNotNull(scDbDTO.scanner(), "ScannerDatabaseDTO: scanner is null!");
        System.out.println("ScannerDatabaseDTO: scanner: " + scDbDTO.scanner());
        
        testEnd("ScannerDatabaseDTO", "scanner()");
    }
    
    @Test
    public void ipValidator() {
        testBegin("ScannerDatabaseDTO", "ipValidator()");
        
        assertNotNull(scDbDTO.ipValidator(), "ScannerDatabaseDTO: ipValidator is null!");
        System.out.println("ScannerDatabaseDTO: ipValidator: " + scDbDTO.ipValidator());
        
        testEnd("ScannerDatabaseDTO", "ipValidator()");
    }
    
    @Test
    public void portValidator() {
        testBegin("ScannerDatabaseDTO", "portValidator()");
        
        assertNotNull(scDbDTO.portValidator(), "ScannerDatabaseDTO: portValidator is null!");
        System.out.println("ScannerDatabaseDTO: portValidator: " + scDbDTO.portValidator());
        
        testEnd("ScannerDatabaseDTO", "portValidator()");
    }
    
    @Test
    public void dbNameValidator() {
        testBegin("ScannerDatabaseDTO", "dbNameValidator()");
        
        assertNotNull(scDbDTO.dbNameValidattor(), "ScannerDatabaseDTO: dbNameValidator is null!");
        System.out.println("ScannerDatabaseDTO: dbNameValidator: " + scDbDTO.dbNameValidattor());
        
        testEnd("ScannerDatabaseDTO", "dbNameValidator()");
    }
}
