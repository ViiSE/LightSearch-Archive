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
package lightsearch.server.cmd.admin.processor;

import lightsearch.server.checker.LightSearchChecker;
import lightsearch.server.cmd.admin.AdminCommand;
import lightsearch.server.cmd.result.CommandResult;
import lightsearch.server.data.AdminDAO;
import lightsearch.server.data.LightSearchServerDTO;
import lightsearch.server.log.LogMessageTypeEnum;
import lightsearch.server.message.result.ResultTypeMessageEnum;

/**
 * Обработчик команды авторизации администратора в LightSearch Server.
 * @author ViiSE
 * @since 1.0.0
 */
public class AuthenticationProcessor extends AbstractProcessorAdmin {

    private final AdminDAO adminDAO;
    
    public AuthenticationProcessor(LightSearchServerDTO serverDTO, LightSearchChecker checker, 
            AdminDAO adminDAO) {
        super(serverDTO, checker);
        this.adminDAO = adminDAO;
    }
    
    @Override
    public CommandResult apply(AdminCommand admCommand) {
        if(!super.checker.isNull(admCommand.name(), admCommand.password())) {
            if(!super.serverDTO.blacklist().contains(admCommand.name()) &&
                    super.serverDTO.admins().containsKey(admCommand.name()) &&
                    super.serverDTO.admins().containsValue(admCommand.password())) {
                adminDAO.setName(admCommand.name());
                adminDAO.setIsFirst(false);
                return super.commandResult(admCommand.name(), LogMessageTypeEnum.INFO, ResultTypeMessageEnum.TRUE,
                        "Administrator " + admCommand.name() + " connected.", "Administrator " + admCommand.name() + " connected");
            } else
                if(adminDAO.tryNumber() == adminDAO.maxTryNumber())
                    return super.commandResult(admCommand.name(), LogMessageTypeEnum.ERROR, ResultTypeMessageEnum.FALSE, 
                            "Administrator " + admCommand.name() + " - invalid login and/or password, or this user in the blacklist. Disconnect to server.", 
                            null);
                else {
                    adminDAO.incrementTryNumber();
                    return super.commandResult(admCommand.name(), LogMessageTypeEnum.ERROR, ResultTypeMessageEnum.FALSE, 
                            "Administrator " + admCommand.name() + " - invalid login and/or password, or this user in the blacklist. " + 
                            (adminDAO.maxTryNumber() - adminDAO.tryNumber()) + " tries left.", 
                            "Administrator " + admCommand.name() + " - invalid login and/or password, or this user in the blacklist. " + 
                            (adminDAO.maxTryNumber() - adminDAO.tryNumber()) + " tries left");
                }
        } else
            return super.commandResult("Unknown", LogMessageTypeEnum.ERROR, ResultTypeMessageEnum.FALSE, 
                    "Wrong command format. You are disconnected.", null);
    }
}
