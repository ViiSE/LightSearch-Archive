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

public class CommandCancelSoftCheckDTODefaultImpl implements CommandCancelSoftCheckDTO {

    private final String userIdent;
    private final String cardCode;
    private final boolean isCart;

    public CommandCancelSoftCheckDTODefaultImpl(String userIdent, String cardCode, boolean isCart) {
        this.userIdent = userIdent;
        this.cardCode = cardCode;
        this.isCart = isCart;
    }

    @Override
    public String userIdentifier() {
        return userIdent;
    }

    @Override
    public String cardCode() {
        return cardCode;
    }

    @Override
    public boolean isCart() {
        return isCart;
    }
}
