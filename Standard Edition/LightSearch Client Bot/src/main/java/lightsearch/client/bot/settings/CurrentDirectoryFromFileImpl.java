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
package lightsearch.client.bot.settings;

import lightsearch.client.bot.LightSearchClientBot;

import java.io.File;
import java.net.URISyntaxException;

/**
 *
 * @author ViiSE
 */
public class CurrentDirectoryFromFileImpl implements CurrentDirectory {

    private final OsDetector osDetector;
    
    public CurrentDirectoryFromFileImpl(OsDetector osDetector) {
        this.osDetector = osDetector;
    }
    
    @Override
    public String currentDirectory() {

        String currentDirectory;
        try {
            currentDirectory = new File(
                    LightSearchClientBot.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            currentDirectory = currentDirectory.replaceAll("LightSearch_Client_Bot.jar", "");
            currentDirectory = currentDirectory.substring(0, currentDirectory.length());

            if(osDetector.isWindows())
                currentDirectory = currentDirectory + "\\";

        } catch (URISyntaxException ex) {
            throw new RuntimeException("Error: " + ex.getMessage());
        }
        return currentDirectory;
    }
}
