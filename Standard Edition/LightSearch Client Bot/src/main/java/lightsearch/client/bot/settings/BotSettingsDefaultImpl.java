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

import lightsearch.client.bot.TestCycle;

/**
 *
 * @author ViiSE
 */
public class BotSettingsDefaultImpl implements BotSettings {

    private final long delay;
    private final int cycleAmount;
    private TestCycle testCycle;
    
    public BotSettingsDefaultImpl(long delay, int cycleAmount) {
        this.delay = delay;
        this.cycleAmount = cycleAmount;
    }

    @Override
    public long delayBeforeSendingMessage() {
        return delay;
    }

    @Override
    public int cycleAmount() {
        return cycleAmount;
    }

    @Override
    public void setTestCycle(TestCycle testCycle) {
        this.testCycle = testCycle;
    }

    @Override
    public TestCycle testCycle() {
        return testCycle;
    }
    
}
