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

import lightsearch.admin.panel.menu.AdminPanelMenu;
import lightsearch.admin.panel.print.AdminPanelPrinter;
import lightsearch.admin.panel.scanner.ScannerChooserCommand;

import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author ViiSE
 */
public class AdminPanelSessionDTOInit {
    
    public static AdminPanelSessionDTO adminPanelDTO(AdminPanelMenu menu, 
            AdminPanelDTO adminPanelDTO, Map<String, Function<AdminPanelDTO, String>> commandHolder,
            AdminPanelPrinter printer, ScannerChooserCommand scannerCmd) {
        return new AdminPanelSessionDTODefaultImpl(menu, adminPanelDTO, commandHolder, printer, scannerCmd);
    }
}
