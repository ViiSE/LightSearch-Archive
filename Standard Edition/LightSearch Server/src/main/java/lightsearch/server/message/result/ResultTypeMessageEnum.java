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
package lightsearch.server.message.result;

/**
 * Константы для результирующего поля "is_done" сообщения клиента.
 * @author ViiSE
 * @since 1.0.0
 */
public enum ResultTypeMessageEnum {
    TRUE {
        @Override
        public String stringValue() {return "True";}
    },
    FALSE {
        @Override
        public String stringValue() {return "False";}
    };
    
    public abstract String stringValue();
}
