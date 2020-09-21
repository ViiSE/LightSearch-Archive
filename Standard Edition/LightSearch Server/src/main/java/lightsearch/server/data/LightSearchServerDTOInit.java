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
package lightsearch.server.data;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ViiSE
 */
public class LightSearchServerDTOInit {
    
    public static LightSearchServerDTO LightSearchServerDTO(Map<String, String> admins,
            Map<String, String> clients,
            List<String> blacklist,
            LightSearchServerDatabaseDTO databaseDTO,
            int serverPort,
            LightSearchServerSettingsDAO settingsDTO,
            String currentDirectory){
        return new LightSearchServerDTOImpl(
                admins, clients, blacklist, databaseDTO, serverPort, settingsDTO, currentDirectory);
    }
}
