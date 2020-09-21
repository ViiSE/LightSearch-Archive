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
package lightsearch.admin.panel.scanner;

import lightsearch.admin.panel.data.ScannerDatabaseDTO;
import lightsearch.admin.panel.data.creator.ScannerDatabaseDTOCreator;
import lightsearch.admin.panel.data.creator.ScannerDatabaseDTOCreatorInit;
import lightsearch.admin.panel.exception.ScannerException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.*;

/**
 *
 * @author ViiSE
 */
public class ScannerDatabaseTestNG {

    private ScannerDatabase scanner;
    
    @BeforeClass
    public void setUpMethod() {
        ScannerDatabaseDTOCreator scDbDTOCreator = ScannerDatabaseDTOCreatorInit.scannerDatabaseDTOCreator();
        assertNotNull(scDbDTOCreator, "ScannerDatabaseDTOCreator is null!");
        
        ScannerDatabaseDTO scannerDatabaseDTO = scDbDTOCreator.createScannerDatabaseDTO();
        scanner = ScannerDatabaseInit.scannerDatabase(scannerDatabaseDTO);
        assertNotNull(scanner, "ScannerDatabase is null!");
    }
    
    @Test
    public void scanIP() {
        testBegin("ScannerDatabase", "scanIP()");
        
        try {
            System.out.print("Input database IP: ");
            String ip = scanner.scanIP();
            System.out.println("Scan ip: " + ip);
        } catch(ScannerException ex) {
            catchMessage(ex);
        }
        
        testEnd("ScannerDatabase", "scanIP()");
    }
    
    @Test
    public void scanPort() {
        testBegin("ScannerDatabase", "scanPort()");
        
        try {
            System.out.print("Input database port: ");
            String port = scanner.scanPort();
            System.out.println("Scan port: " + port);
        } catch(ScannerException ex) {
            catchMessage(ex);
        }
        
        testEnd("ScannerDatabase", "scanPort()");
    }
    
    @Test
    public void scanDBName() {
        testBegin("ScannerDatabase", "scanDBName()");
        
        try {
            System.out.print("Input database name: ");
            String dbName = scanner.scanDBName();
            System.out.println("Scan ip: " + dbName);
        } catch(ScannerException ex) {
            catchMessage(ex);
        }
        
        testEnd("ScannerDatabase", "scanDBName()");
    }
}
