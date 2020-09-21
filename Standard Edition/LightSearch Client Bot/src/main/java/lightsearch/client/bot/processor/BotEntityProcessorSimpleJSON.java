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
package lightsearch.client.bot.processor;

import lightsearch.client.bot.*;
import lightsearch.client.bot.data.*;
import lightsearch.client.bot.exception.SocketException;
import lightsearch.client.bot.message.MessageRecipient;
import lightsearch.client.bot.message.MessageRecipientInit;
import lightsearch.client.bot.message.MessageSender;
import lightsearch.client.bot.message.MessageSenderInit;
import lightsearch.client.bot.settings.BotSettingsEnum;
import lightsearch.client.bot.socket.SocketCreatorInit;
import org.json.simple.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ViiSE
 */
public class BotEntityProcessorSimpleJSON extends BotEntityProcessor {

    private final String BOT_DAO                      = BotSettingsEnum.BOT_DAO.toString();
    private final String DELAY_BEFORE_SENDING_MESSAGE = BotSettingsEnum.DELAY_BEFORE_SENDING_MESSAGE.toString();
    private final String CYCLE_AMOUNT                 = BotSettingsEnum.CYCLE_AMOUNT.toString();
    private final String CYCLE_CONTENT                = BotSettingsEnum.CYCLE_CONTENT.toString();
    
    public BotEntityProcessorSimpleJSON(int botAmount, String ip, int port, long delayMessageDisplay) {
        super(botAmount, ip, port, delayMessageDisplay);
    }

    @Override
    public List<BotEntity> apply(Object data) {
        if(super.botAmount() <= 0)
            throw new RuntimeException("Bots amount is less or equals than 0.");
        
        JSONObject jSettings = (JSONObject) data;
        List<BotEntity> bots = new ArrayList<>();
        
        TestCycleCreator testCycleCreator = TestCycleCreatorInit.testCycleCreator(jSettings.get(CYCLE_CONTENT));
        int cycleAmount = Integer.parseInt(jSettings.get(CYCLE_AMOUNT).toString());

        BotDAOCreator botDAOCreator = BotDAOCreatorInit.botDAOCreatorSimple(jSettings.get(BOT_DAO));
        
        ConnectionDTO connDTO = ConnectionDTOInit.connectDTO(super.ip(), super.port());
        
        for(int i = 0; i < super.botAmount(); i++) {
            try {
                Socket socket = SocketCreatorInit.socketCreator(connDTO).createSocket();
                
                MessageSender msgSender =
                        MessageSenderInit.messageSender(new DataOutputStream(socket.getOutputStream()));
                MessageRecipient msgRecipient =
                        MessageRecipientInit.messageRecipient(new DataInputStream(socket.getInputStream()));
                
                TestCycle testCycle = testCycleCreator.createCycle();
                long delayBeforeSendingMessage = Integer.parseInt(jSettings.get(DELAY_BEFORE_SENDING_MESSAGE).toString());
                BotSettingsDTO botSettings = BotSettingsDTOInit.botSettingsDTO(testCycle, cycleAmount, delayBeforeSendingMessage);
                
                BotDAO botDAO = botDAOCreator.createBotDAO();
                
                BotEntityDTO botEntityDTO = BotEntityDTOInit.botEntityDTO(botDAO, 
                        socket, botSettings, msgSender, msgRecipient, super.delayMessageDisplay());
                
                bots.add(BotEntityInit.botEntity(botEntityDTO));
            } catch (SocketException | IOException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
        
        return bots;
    }
}
