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

import lightsearch.admin.panel.data.ScannerChooserCommandDTO;
import lightsearch.admin.panel.data.creator.ScannerChooserCommandDTOCreator;
import lightsearch.admin.panel.data.creator.ScannerChooserCommandDTOCreatorInit;
import lightsearch.admin.panel.exception.ScannerException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.*;

/**
 *
 * @author ViiSE
 */
public class ScannerChooserCommandTestNG {
    
    private ScannerChooserCommandDTO scannerChooserCommandDTO;
    
    @BeforeClass
    public void setUpMethod() {
        ScannerChooserCommandDTOCreator scChCmdCreator =
                ScannerChooserCommandDTOCreatorInit.scannerChooserCommandDTOCreator();
        assertNotNull(scChCmdCreator, "ScannerChooserCommandDTOCreator is null!");
        
        scannerChooserCommandDTO = scChCmdCreator.createScannerChooserCommandDTO();
        assertNotNull(scChCmdCreator, "ScannerChooserCommandDTO is null!");
    }
    
    @Test
    public void scanCommand() {
        testBegin("ScannerChooserCommand", "scanCommand()");

        try {
            ScannerChooserCommand scChCmd = ScannerChooserCommandInit.scannerChooserCommand(scannerChooserCommandDTO);
            assertNotNull(scChCmd, "ScannerChooserCommand is null!");

            System.out.print("Input command number: ");
            String command = scChCmd.scanCommand();
            System.out.println("Command scan: " + command);
        } catch (ScannerException ex) {
            catchMessage(ex);
        }

        testEnd("ScannerChooserCommand", "scanCommand()");
    }
}
