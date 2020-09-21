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

import lightsearch.admin.panel.validate.CommandValidator;

import java.util.Scanner;

/**
 *
 * @author ViiSE
 */
public class ScannerChooserCommandDTODefaultImpl implements ScannerChooserCommandDTO {

    private final Scanner scanner;
    private final CommandValidator commandValidator;

    public ScannerChooserCommandDTODefaultImpl(Scanner scanner, CommandValidator commandValidator) {
        this.scanner = scanner;
        this.commandValidator = commandValidator;
    }

    @Override
    public Scanner scanner() {
        return scanner;
    }

    @Override
    public CommandValidator commandValidator() {
        return commandValidator;
    }
}