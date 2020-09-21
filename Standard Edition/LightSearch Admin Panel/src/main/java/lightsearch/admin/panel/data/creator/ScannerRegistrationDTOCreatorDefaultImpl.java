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
package lightsearch.admin.panel.data.creator;

import lightsearch.admin.panel.data.ScannerRegistrationDTO;
import lightsearch.admin.panel.data.ScannerRegistrationDTOInit;
import lightsearch.admin.panel.security.HashAlgorithms;
import lightsearch.admin.panel.security.HashAlgorithmsInit;
import lightsearch.admin.panel.validate.AdminNameValidator;
import lightsearch.admin.panel.validate.AdminNameValidatorInit;

import java.util.Scanner;

/**
 *
 * @author ViiSE
 */
public class ScannerRegistrationDTOCreatorDefaultImpl implements ScannerRegistrationDTOCreator {

    @Override
    public ScannerRegistrationDTO createScannerRegistrationDTO() {
        Scanner scanner = new Scanner(System.in);
        AdminNameValidator adminNameValidator = AdminNameValidatorInit.adminNameValidator();
        HashAlgorithms hashAlgorithms = HashAlgorithmsInit.hashAlgorithms();

        return ScannerRegistrationDTOInit.scannerAuthenticationDTO(scanner, adminNameValidator, hashAlgorithms);
    }
}
