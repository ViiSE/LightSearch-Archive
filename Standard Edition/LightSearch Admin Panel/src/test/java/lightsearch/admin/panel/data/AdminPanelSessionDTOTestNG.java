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

import lightsearch.admin.panel.data.creator.ScannerChooserCommandDTOCreator;
import lightsearch.admin.panel.data.creator.ScannerChooserCommandDTOCreatorInit;
import lightsearch.admin.panel.menu.AdminPanelMenu;
import lightsearch.admin.panel.menu.AdminPanelMenuCreator;
import lightsearch.admin.panel.menu.AdminPanelMenuCreatorInit;
import lightsearch.admin.panel.print.AdminPanelPrinter;
import lightsearch.admin.panel.print.AdminPanelPrinterInit;
import lightsearch.admin.panel.scanner.ScannerChooserCommand;
import lightsearch.admin.panel.scanner.ScannerChooserCommandInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class AdminPanelSessionDTOTestNG {

    private AdminPanelSessionDTO admPanelSessionDTO;

    @BeforeClass
    public void setUpMethod() {
        AdminPanelMenuCreator menuCreator = AdminPanelMenuCreatorInit.adminMenuCreator();
        assertNotNull(menuCreator, "MenuCreator is null!");
        AdminPanelMenu menu = menuCreator.createAdminMenu();
        
        Map<String, String> clients = new HashMap<>();
        assertNotNull(clients, "Clients map is null!");
        Map<String, String> blacklist = new HashMap<>();
        assertNotNull(blacklist, "Blacklist map is null!");
        AdminPanelDTO adminPanelDTO = AdminPanelDTOInit.adminPanelDTO(clients, blacklist);
        
        AdminPanelPrinter printer = AdminPanelPrinterInit.adminPanelPrinter();

        Map<String, Function<AdminPanelDTO, String>> commandHolder = new HashMap<>();

        ScannerChooserCommandDTOCreator scChCmdDTOCreator =
                ScannerChooserCommandDTOCreatorInit.scannerChooserCommandDTOCreator();
        assertNotNull(scChCmdDTOCreator, "ScannerChooserCommandDTOCreator is null!");
        ScannerChooserCommandDTO scChCmdDTO = scChCmdDTOCreator.createScannerChooserCommandDTO();
        assertNotNull(scChCmdDTO, "ScannerChooserCommanDTO is null!");
        ScannerChooserCommand scannerChCmd = ScannerChooserCommandInit.scannerChooserCommand(scChCmdDTO);

        assertNotNull(menu, "AdminPanelMenu is null!");
        assertNotNull(adminPanelDTO, "AdminPanelDTO is null!");
        assertNotNull(commandHolder, "CommandHolder is null!");
        assertNotNull(printer, "AdminPanelPrinter is null!");
        assertNotNull(scannerChCmd, "ScannerChooserCommand is null!");

        admPanelSessionDTO =
                AdminPanelSessionDTOInit.adminPanelDTO(menu, adminPanelDTO, commandHolder, printer, scannerChCmd);
    }
    
    @Test
    public void menu() {
        testBegin("AdminPanelSessionDTO", "menu()");
        
        System.out.print("Get menu: ");
        System.out.println(admPanelSessionDTO.adminMenu());
        
        testEnd("AdminPanelSessionDTO", "menu()");
    }
    
    @Test
    public void adminPanelDTO() {
        testBegin("AdminPanelSessionDTO", "adminPanelDTO()");
        
        System.out.print("Get adminPanelDTO: ");
        System.out.println(admPanelSessionDTO.adminPanelDTO());
        
        testEnd("AdminPanelSessionDTO", "adminPanelDTO()");
    }
    
    @Test
    public void commandHolder() {
        testBegin("AdminPanelSessionDTO", "commandHolder()");
        
        System.out.print("Get commandHolder: ");
        System.out.println(admPanelSessionDTO.commandHolder().getClass());
        
        testEnd("AdminPanelSessionDTO", "commandHolder()");
    }
    
    @Test
    public void printer() {
        testBegin("AdminPanelSessionDTO", "printer()");
        
        System.out.print("Get printer: ");
        System.out.println(admPanelSessionDTO.printer());
        
        testEnd("AdminPanelSessionDTO", "printer()");
    }
    
    @Test
    public void scannerCommand() {
        testBegin("AdminPanelSessionDTO", "scannerCommand()");
        
        System.out.print("Get scannerCommand: ");
        System.out.println(admPanelSessionDTO.scannerCommand());
        
        testEnd("AdminPanelSessionDTO", "scannerCommand()");
    }
}
