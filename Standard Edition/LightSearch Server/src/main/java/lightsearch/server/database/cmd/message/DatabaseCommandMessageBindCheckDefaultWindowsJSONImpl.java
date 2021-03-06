/*
 * Copyright @today.year ViiSE.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package lightsearch.server.database.cmd.message;

/**
 * Сообщение в формате JSON команды поиска товара для СУБД, работающих под управлением операционной системы
 * Microsoft Windows.
 * <p>
 * Для записи JSON сообщения в формате pretty в поле типа BLOB в сообщении необходимо добавлять после каждой строки
 * помимо символа переноса новой строки {@code \n} символ возврата каретки {@code \r}.
 * @author ViiSE
 * @since 2.0.0
 */
public class DatabaseCommandMessageBindCheckDefaultWindowsJSONImpl implements DatabaseCommandMessage {

    private final String CMD_FIELD = DatabaseCommandMessageEnum.COMMAND.stringValue();
    private final String IMEI_FIELD = DatabaseCommandMessageEnum.IMEI.stringValue();
    private final String FACTORY_BARCODE_FIELD = DatabaseCommandMessageEnum.FACTORY_BARCODE.stringValue();

    private final String command;
    private final String IMEI;
    private final String factory_barcode;

    public DatabaseCommandMessageBindCheckDefaultWindowsJSONImpl(String command, String IMEI, String factory_barcode) {
        this.command = command;
        this.IMEI = IMEI;
        this.factory_barcode = factory_barcode;
    }
    
    @Override
    public String message() {
        return "{\r\n"
                + "\"" + CMD_FIELD + "\":\""  + command + "\",\r\n"
                + "\"" + IMEI_FIELD + "\":\"" + IMEI + "\",\r\n"
                + "\"" + FACTORY_BARCODE_FIELD + "\":\"" + factory_barcode + "\"\r\n"
                + "}";
    }
}
