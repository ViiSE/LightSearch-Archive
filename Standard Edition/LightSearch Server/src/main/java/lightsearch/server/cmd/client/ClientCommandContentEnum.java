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
package lightsearch.server.cmd.client;

/**
 * Константы содержания команд клиента LightSearch Server согласно протоколу.
 * <p>
 * Ознакомиться с протоколом можно по
 * <a href="https://github.com/ViiSE/LightSearch/blob/master/Documents/Protocol/LightSearch%20Protocol.txt">ссылке</a>.
 * @author ViiSE
 * @since 1.0.0
 */
public enum ClientCommandContentEnum {
    COMMAND {
        @Override
        public String stringValue() {return "command";}
    },
    IMEI {
        @Override
        public String stringValue() {return "IMEI";}
    },
    IP {
        @Override
        public String stringValue() {return "ip";}
    },
    OS {
        @Override
        public String stringValue() {return "os";}
    },
    MODEL {
        @Override
        public String stringValue() {return "model";}
    },
    USERNAME {
        @Override
        public String stringValue() {return "username";}
    },
    PASSWORD {
        @Override
        public String stringValue() {return "password";}
    },
    BARCODE {
        @Override
        public String stringValue() {return "barcode";}
    },
    FACTORY_BARCODE {
        @Override
        public String stringValue() {return "factory_barcode";}
    },
    SKLAD {
        @Override
        public String stringValue() {return "sklad";}
    },
    TK {
        @Override
        public String stringValue() {return "TK";}
    },
    DATA {
        @Override
        public String stringValue() {return "data";}
    },
    USER_IDENT {
        @Override
        public String stringValue() {return "ident";}
    },
    DELIVERY {
        @Override
        public String stringValue() {return "delivery";}
    },
    CARD_CODE {
        @Override
        public String stringValue() {return "card_code";}
    };
    
    public abstract String stringValue();
}
