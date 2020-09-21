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

public class CommandCheckBindDTODefaultImpl implements CommandCheckBindDTO {

    private final String input;
    private final int selected;
    private final String factoryBarcode;
    private final boolean isCheckEan13;

    public CommandCheckBindDTODefaultImpl(String input, int selected, String factoryBarcode, boolean isCheckEan13) {
        this.input = input;
        this.selected = selected;
        this.factoryBarcode = factoryBarcode;
        this.isCheckEan13 = isCheckEan13;
    }

    @Override
    public String input() {
        return input;
    }

    @Override
    public int selected() {
        return selected;
    }

    @Override
    public String factoryBarcode() {
        return factoryBarcode;
    }

    @Override
    public boolean isCheckEan13() {
        return isCheckEan13;
    }
}
