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
package lightsearch.client.bot.data;

import lightsearch.client.bot.settings.BotSettingsEnum;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class BotDAOCreatorSimple {
    
    private final String IMPLEMENTATION = BotSettingsEnum.IMPLEMENTATION.toString();
    
    private BotDAOCreator botDAOCr;
    
    @BeforeClass
    public void setUpClass() {
        JSONObject data = getData();
        botDAOCr = BotDAOCreatorInit.botDAOCreatorSimple(data);
    }
    
    @Test
    @Parameters({"impl"})
    public void createBotDAO() {
        testBegin("BotDAOCreator", "createBotDAO()");
        
        BotDAO botDAO = botDAOCr.createBotDAO();
        assertNotNull(botDAO, "BotDAO is null!");
        System.out.println("BotDAO: " + botDAO);
        
        System.out.println("BotDAO.botName(): " + botDAO.botName());
        System.out.println("BotDAO.username(): " + botDAO.username());
        System.out.println("BotDAO.password(): " + botDAO.password());
        System.out.println("BotDAO.IMEI(): " + botDAO.IMEI());
        System.out.println("BotDAO.cardCode(): " + botDAO.cardCode());
        System.out.println("BotDAO.userIdent(): " + botDAO.userIdent());
        
        testEnd("BotDAOCreator", "createBotDAO()");
    }
    
    @SuppressWarnings("unchecked")
    private JSONObject getData() {
        JSONObject data = new JSONObject();
        data.put(IMPLEMENTATION, "lightsearch.client.bot.data.BotDAODefaultImpl");
        
        return data;
    }
}
