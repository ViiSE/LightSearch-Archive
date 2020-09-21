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

package test.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import ru.viise.lightsearch.data.ConnectionDTO;
import ru.viise.lightsearch.data.ConnectionDTOInit;

public class CreateConnectionDTOTestRule implements TestRule {

    private ConnectionDTO connectionDTO;

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String ip = "127.0.0.1";
                String port = "50000";

                connectionDTO = ConnectionDTOInit.connectionDTO(ip, port);

                base.evaluate();
            }
        };
    }

    public ConnectionDTO getConnectionDTO() {
        return connectionDTO;
    }
}
