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

package ru.viise.lightsearch.cmd.result.creator;

import org.junit.Before;
import org.junit.Test;

import ru.viise.lightsearch.cmd.result.CancelSoftCheckCommandResult;
import ru.viise.lightsearch.exception.CommandResultCreatorException;

import static com.google.common.truth.Truth.assertThat;
import static test.TestMessage.catchMessage;
import static test.TestMessage.testBegin;
import static test.TestMessage.testEnd;

public class CommandResultCancelSoftCheckCreatorJSONJUnitTest {

    private CommandResultCreator cmdResCr;

    @Before
    public void setUp() {
        String IMEI = "123456789123456";
        String rawMessage = "{" +
                "\"IMEI\":\"123456789123456\"," +
                "\"is_done\":\"true\"," +
                "\"message\":\"Cancel success!\"" +
                "}";
        cmdResCr = CommandResultCreatorInit.commandResultCancelSoftCheckCreator(rawMessage, IMEI, false);
    }

    @Test
    public void createCommandResult() {
        testBegin("CommandResultCancelSoftCheckCreatorJSON", "createCommandResult()");

        try {
            CancelSoftCheckCommandResult result =
                    (CancelSoftCheckCommandResult) cmdResCr.createCommandResult();
            assertThat(result).isNotNull();
            assertThat(result.isDone()).isTrue();
            assertThat(result.message()).isNotNull();
            assertThat(result.isCart()).isFalse();

            System.out.println("Result:");
            System.out.println("isDone: " + result.isDone());
            System.out.println("message: " + result.message());
        } catch (CommandResultCreatorException ex) {
            catchMessage(ex);
        }

        testEnd("CommandResultCancelSoftCheckCreatorJSON", "createCommandResult()");
    }
}
