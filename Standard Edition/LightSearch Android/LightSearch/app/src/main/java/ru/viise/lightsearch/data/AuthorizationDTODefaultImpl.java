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

package ru.viise.lightsearch.data;

public class AuthorizationDTODefaultImpl implements AuthorizationDTO {

    private final String username;
    private final String password;
    private final String userIdent;

    public AuthorizationDTODefaultImpl(String username, String password, String userIdent) {
        this.username = username;
        this.password = password;
        this.userIdent = userIdent;
    }

    @Override
    public String username() {
        return username;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String userIdent() {
        return userIdent;
    }
}
