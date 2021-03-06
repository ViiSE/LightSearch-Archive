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

import lightsearch.client.bot.BotEntity;

import java.util.List;
import java.util.function.Function;

public abstract class BotEntityProcessor implements Function<Object, List<BotEntity>> {
    
    private final int botAmount;
    private final String ip;
    private final int port;
    private final long delayMessageDisplay;

    public BotEntityProcessor(int botAmount, String ip, int port, long delayMessageDisplay) {
        this.botAmount = botAmount;
        this.ip = ip;
        this.port = port;
        this.delayMessageDisplay = delayMessageDisplay;
    }
    
    public int botAmount() {
        return botAmount;
    }
    
    public String ip() {
        return ip;
    }
    
    public int port() {
        return port;
    }
    
    public long delayMessageDisplay() {
        return delayMessageDisplay;
    }
}