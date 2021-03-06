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
package lightsearch.admin.panel.data;

import lightsearch.admin.panel.validate.RestartValidator;

import java.util.Scanner;

/**
 *
 * @author ViiSE
 */
public class ScannerRestartDTODefaultImpl implements ScannerRestartDTO {
    
    private final Scanner scanner;
    private final RestartValidator restartValidator;

    public ScannerRestartDTODefaultImpl(Scanner scanner, RestartValidator restartValidator) {
        this.scanner = scanner;
        this.restartValidator = restartValidator;
    }

    @Override
    public Scanner scanner() {
        return scanner;
    }

    @Override
    public RestartValidator restartValidator() {
        return restartValidator;
    }
}
