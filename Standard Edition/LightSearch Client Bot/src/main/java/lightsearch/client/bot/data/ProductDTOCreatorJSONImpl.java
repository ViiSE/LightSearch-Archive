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
package lightsearch.client.bot.data;

import lightsearch.client.bot.settings.BotSettingsEnum;
import org.json.simple.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author ViiSE
 */
public class ProductDTOCreatorJSONImpl implements ProductDTOCreator {

    private final String ID     = BotSettingsEnum.ID.toString();
    private final String AMOUNT = BotSettingsEnum.AMOUNT.toString();
    
    private final String impl;
    private final JSONObject data;
    
    public ProductDTOCreatorJSONImpl(String impl, Object data) {
        this.impl = impl;
        this.data = (JSONObject) data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ProductDTO createProductDTO() {
        try {
            String id = data.get(ID).toString();
            String amount = data.get(AMOUNT).toString();
            
            Class clazz = Class.forName(impl);
            Constructor constructor = clazz.getConstructor(String.class, String.class);
            
            return (ProductDTO) constructor.newInstance(id, amount);
        } catch (ClassNotFoundException | InstantiationException   |
                IllegalAccessException  | NoSuchMethodException    |
                SecurityException       | IllegalArgumentException |
                InvocationTargetException ex) {
            throw new RuntimeException(ex.getClass() + ":" + ex.getMessage());
        }
    }   
}
