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

package lightsearch.client.bot.producer;

import lightsearch.client.bot.TestCycleCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("testCycleCreatorProducerDefault")
public class TestCycleCreatorProducerDefaultImpl implements TestCycleCreatorProducer {

    private final String TEST_CYCLE_CREATOR = "testCycleCreatorJSON";

    @Autowired
    private ApplicationContext ctx;

    @Override
    public TestCycleCreator getTestCycleCreatorJSONInstance(Object cycleContent) {
        return (TestCycleCreator) ctx.getBean(TEST_CYCLE_CREATOR, cycleContent);
    }
}
