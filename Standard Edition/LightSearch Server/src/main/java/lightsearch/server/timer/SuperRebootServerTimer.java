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
package lightsearch.server.timer;

import lightsearch.server.log.LoggerServer;
import lightsearch.server.thread.ThreadManager;
import lightsearch.server.time.CurrentDateTime;

import java.time.LocalDateTime;

/**
 * Абстрактный класс таймера перезагрузки LightSearch Server.
 * <p>
 * Если необходимо создать таймер перезагрузки LightSearch Server, то надо наследоваться от данного класса.
 * @author ViiSE
 * @since 2.0.0
 */
public abstract class SuperRebootServerTimer extends SuperTimer {
    
    private final LocalDateTime rebootDateTime;
    private final String currentDirectory;
    
    public SuperRebootServerTimer(LocalDateTime rebootDateTime, String currentDirectory,
            LoggerServer loggerServer, CurrentDateTime currentDateTime,
            ThreadManager threadManager, TimersIDEnum id) {
        super(loggerServer, currentDateTime, threadManager, id);
        this.rebootDateTime = rebootDateTime;
        this.currentDirectory = currentDirectory;
    }
    
    public String currentDirectory() {
        return currentDirectory;
    }
    
    public LocalDateTime rebootDateTime() {
        return rebootDateTime;
    }
}
