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

import java.util.List;

import ru.viise.lightsearch.data.CommandConfirmSoftCheckRecordsDTO;
import ru.viise.lightsearch.data.CommandConfirmSoftCheckRecordsDTOInit;
import ru.viise.lightsearch.data.SoftCheckRecord;

public class CreateCommandConfirmSoftCheckRecordsDTORule implements TestRule {

    private final List<SoftCheckRecord> records;

    private String IMEI;
    private CommandConfirmSoftCheckRecordsDTO cmdConfirmSCRDTO;

    public CreateCommandConfirmSoftCheckRecordsDTORule(List<SoftCheckRecord> records) {
        this.records = records;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                IMEI = "123456789123456";
                String userIdent = "007";
                String cardCode = "777";

                cmdConfirmSCRDTO =
                        CommandConfirmSoftCheckRecordsDTOInit.commandConfirmSoftCheckRecordsDTO(
                                userIdent, cardCode, records);
                base.evaluate();
            }
        };
    }

    public String getIMEI() {
        return IMEI;
    }

    public CommandConfirmSoftCheckRecordsDTO getCommandConfirmSoftCheckRecordsDTO() {
        return cmdConfirmSCRDTO;
    }
}