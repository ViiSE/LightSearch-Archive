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

package ru.viise.lightsearch.check;

import ru.viise.lightsearch.connect.processor.result.ConnectionProcessorResult;
import ru.viise.lightsearch.identifier.IdentifierEnum;

public class ConnectionProcessorResultCheckerDefaultImpl implements ConnectionProcessorResultChecker {

    private final String OK = IdentifierEnum.OK.stringValue();

    @Override
    public boolean check(ConnectionProcessorResult result) {
        return result.result().equals(OK);
    }
}
