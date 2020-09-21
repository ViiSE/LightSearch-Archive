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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.data.DataProviderCreator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class BotSettingsDTOTestNG {
    
    private BotSettingsDTO botSettingsDTO;
    
    @BeforeClass
    @Parameters({"cycleAmount", "delayBeforeSendingMessage"})
    public void setUpClass(int cycleAmount, long delayBeforeSendingMessage) {
        botSettingsDTO =
                DataProviderCreator.createDataProvider(BotSettingsDTO.class, cycleAmount, delayBeforeSendingMessage);
    }
    
    @Test
    public void testCycle() {
        testBegin("BotSettingsDTO", "testCycle()");
        
        assertNotNull(botSettingsDTO.testCycle(), "TestCycle is null!");
        System.out.println("TestCycle: " + botSettingsDTO.testCycle());
        
        testEnd("BotSettingsDTO", "testCycle()");
    }
    
    @Test
    public void cycleAmount() {
        testBegin("BotSettingsDTO", "cycleAmount()");
        
        assertFalse(botSettingsDTO.cycleAmount() < 0, "CycleAmount value is less than 0!");
        System.out.println("CycleAmount: " + botSettingsDTO.cycleAmount());
        
        testEnd("BotSettingsDTO", "cycleAmount()");
    }
    
    @Test
    public void delayBeforeSendingMessage() {
        testBegin("BotSettingsDTO", "delayBeforeSendingMessage()");
        
        assertFalse(botSettingsDTO.delayBeforeSendingMessage() < 0, "DelayBeforeSendingMessage value is less than 0!");
        System.out.println("DelayBeforeSendingMessage: " + botSettingsDTO.delayBeforeSendingMessage());
        
        testEnd("BotSettingsDTO", "delayBeforeSendingMessage()");
    }
}
