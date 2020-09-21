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

package ru.viise.lightsearch.fragment;

import ru.viise.lightsearch.data.SoftCheckRecord;
import ru.viise.lightsearch.find.Findable;

public interface IContainerFragment extends Findable {
    void setSearchBarcode(String barcode);
    void setCardCode(String cardCode);
    void setSoftCheckBarcode(String barcode);
    void switchToSoftCheckFragment();
    void switchToOpenSoftCheckFragment();
    void addSoftCheckRecord(SoftCheckRecord record);
}
