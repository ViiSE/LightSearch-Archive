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
package lightsearch.server.exception;

/**
 * Исключение, возникающее при считывании результата команды из таблицы базы данных.
 * @author ViiSE
 * @see lightsearch.server.database.DatabaseReader
 * @since 2.0.0
 */
public class DatabaseReaderException extends Exception {
    
    private final String messageRU;
    
    public DatabaseReaderException(String message, String messageRU) {
        super(message);
        this.messageRU = messageRU;
    }
    
    public String getMessageRU() {
        return messageRU;
    }
}