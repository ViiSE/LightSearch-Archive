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

package test.data.processor;

import lightsearch.client.bot.settings.BotSettingsReaderInit;

import static test.ResourcesFilesPath.getResourcesFilesPath;

public class BotSettingsReaderDataProviderProcessor implements DataProviderProcessor {

    @Override
    public Object apply(Object... ignore) {
        String botSettingsFileName = getResourcesFilesPath() + "bot_settings_advanced_test.json";
        return BotSettingsReaderInit.botSettingsReader(botSettingsFileName);
    }
}
