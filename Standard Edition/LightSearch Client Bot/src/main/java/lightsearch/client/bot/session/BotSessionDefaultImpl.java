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
package lightsearch.client.bot.session;

import lightsearch.client.bot.*;
import lightsearch.client.bot.data.ConnectionDTOInit;
import lightsearch.client.bot.settings.BotSettingsReader;
import lightsearch.client.bot.settings.BotSettingsReaderInit;
import lightsearch.client.bot.settings.GlobalSettings;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ViiSE
 */
public class BotSessionDefaultImpl implements BotSession {

    private final String botSettingsName;
    private final String serverIP;
    private final int serverPort;
    private final long delayMessageDisplay;
    private final boolean isPerformance;

    public BotSessionDefaultImpl(String botSettingsName, GlobalSettings globalSettings, 
            boolean isPerformance) {
        this.botSettingsName = botSettingsName;
        this.serverIP = globalSettings.serverIP();
        this.serverPort = globalSettings.serverPort();
        this.delayMessageDisplay = globalSettings.delayMessageDisplay();
        this.isPerformance = isPerformance;
    }
    
    @Override
    public void startSession() {
        List<BotThread> bots = new ArrayList<>();
        
        BotSettingsReader botSettingsReader = BotSettingsReaderInit.botSettingsReader(botSettingsName);
        BotEntityCreator botEntityCreator =
                BotEntityCreatorInit.botEntityCreator(botSettingsReader, serverIP, serverPort, delayMessageDisplay);
        
        List<BotEntity> botsEntities = botEntityCreator.botList();
        botsEntities.forEach(botEntity -> {
            BotThread bThread = BotThreadInit.botThread(botEntity);
            bots.add(bThread);
        });
        
        bots.forEach(BotThread::start);
        
        if(isPerformance) {
            BotsDoneSwitcher.addBots(bots.size());
            BotsChecker checker = BotsCheckerInit.botsChecker(ConnectionDTOInit.connectDTO(serverIP, serverPort));
            checker.start();
        }
    }
}
