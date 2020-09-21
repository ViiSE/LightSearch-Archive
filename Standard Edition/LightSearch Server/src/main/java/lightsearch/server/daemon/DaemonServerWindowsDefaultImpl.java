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
package lightsearch.server.daemon;

import java.io.IOException;

/**
 * Реализация интерфейса {@link lightsearch.server.daemon.DaemonServer} по умолчанию.
 * <p>
 * Запускает демона LightSearch Daemon под операционной системой Microsoft Windows.
 * @author ViiSE
 * @since 1.0.0
 */
public class DaemonServerWindowsDefaultImpl implements DaemonServer {

    private final String currentDirectory;
    
    public DaemonServerWindowsDefaultImpl(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    @Override
    public void exec() {
        try {
            Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c", "cd", "C:\\Windows\\system32\\", "&", "start", 
                "cmd.exe", "/c", "java", "-jar", currentDirectory + "LightSearch_Daemon.jar", currentDirectory + "LightSearch_Server.jar"});
            System.exit(0);
        } catch (IOException ignored) { }
    }
    
}
