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
package lightsearch.admin.panel.cmd.admin.processor;

import lightsearch.admin.panel.cmd.message.MessageCommandEnum;
import lightsearch.admin.panel.cmd.message.MessageCommandResultEnum;
import lightsearch.admin.panel.cmd.result.CommandResult;
import lightsearch.admin.panel.data.AdminCommandDAO;
import lightsearch.admin.panel.data.AdminCommandDAOInit;
import lightsearch.admin.panel.data.AdminDTO;
import lightsearch.admin.panel.data.AdminPanelDTO;
import lightsearch.admin.panel.exception.ScannerException;
import lightsearch.admin.panel.scanner.ScannerClientValue;
import lightsearch.admin.panel.util.MapRemover;

import java.util.function.Function;

/**
 *
 * @author ViiSE
 */
public class DelBlacklistProcessor extends AbstractProcessorAdmin {

    private final String COMMAND = MessageCommandEnum.DEL_BLACKLIST.stringValue();
    private final String TRUE    = MessageCommandResultEnum.TRUE.stringValue();
    
    private final ScannerClientValue scanner;
    private final MapRemover mapRemover;
    
    public DelBlacklistProcessor(AdminDTO adminDTO, ScannerClientValue scanner, MapRemover mapRemover) {
        super(adminDTO);
        this.scanner = scanner;
        this.mapRemover = mapRemover;
    }

    @Override
    public String apply(AdminPanelDTO admPanelDTO) {
        while(true) {
            try {
                super.adminDTO().printer().print("Input IMEI or number in table of blacklist: ");
                String value = scanner.scanValue();
                String IMEI = admPanelDTO.blacklist().containsKey(value) ? admPanelDTO.blacklist().get(value) : value;
                
                AdminCommandDAO admCmdDAO = AdminCommandDAOInit.adminCommandDAO();
                admCmdDAO.setName(super.adminDTO().adminDAO().name());
                admCmdDAO.setIMEI(IMEI);
                
                Function<AdminCommandDAO, CommandResult> processor = super.adminDTO().messageCommandHolder().get(COMMAND);
                
                if(processor != null) {
                    CommandResult cmdRes = processor.apply(admCmdDAO);
                    if(cmdRes.name().equals(super.adminDTO().adminDAO().name())) {
                        if(cmdRes.isDone().equals(TRUE)) {
                            mapRemover.removeFromMap(admPanelDTO.blacklist(), value);
                            return cmdRes.message();
                        } else
                            return cmdRes.message();
                    } else
                        throw new RuntimeException(cmdRes.message());
                }
            } catch(ScannerException ex) {
                super.adminDTO().printer().println(ex.getMessage());
            }
        }
    }
}
