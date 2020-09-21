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

import lightsearch.admin.panel.data.creator.ScannerRegistrationDTOCreatorInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class ScannerRegistrationDTOTestNG {
    
    private ScannerRegistrationDTO scRegDTO;
    
    @BeforeClass
    public void setUpMethod() {
        scRegDTO = ScannerRegistrationDTOCreatorInit.scannerRegistrationDTOCreator().createScannerRegistrationDTO();
        assertNotNull(scRegDTO, "ScannerRegistrationDTO is null!");
    }
    
    @Test
    public void scanner() {
        testBegin("ScannerRegistrationDTO", "scanner()");
        
        assertNotNull(scRegDTO.scanner(), "ScannerRegistrationDTO: scanner is null!");
        System.out.println("ScannerRegistrationDTO: scanner: " + scRegDTO.scanner());
        
        testEnd("ScannerRegistrationDTO", "scanner()");
    }
    
    @Test
    public void adminNameValidator() {
        testBegin("ScannerRegistrationDTO", "adminNameValidator()");
        
        assertNotNull(scRegDTO.adminNameValidator(), "ScannerRegistrationDTO: adminNameValidator is null!");
        System.out.println("ScannerRegistrationDTO: adminNameValidator: " + scRegDTO.adminNameValidator());
        
        testEnd("ScannerRegistrationDTO", "adminNameValidator()");
    }
    
    @Test
    public void hashAlgorithms() {
        testBegin("ScannerRegistrationDTO", "hashAlgorithms()");
        
        assertNotNull(scRegDTO.hashAlgorithms(), "ScannerRegistrationDTO: hashAlgorithms is null!");
        System.out.println("ScannerRegistrationDTO: hashAlgorithms: " + scRegDTO.hashAlgorithms());
        
        testEnd("ScannerRegistrationDTO", "hashAlgorithms()");
    }
}
