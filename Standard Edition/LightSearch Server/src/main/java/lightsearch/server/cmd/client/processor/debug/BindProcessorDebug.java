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
package lightsearch.server.cmd.client.processor.debug;

import lightsearch.server.checker.LightSearchChecker;
import lightsearch.server.cmd.client.ClientCommand;
import lightsearch.server.cmd.client.processor.AbstractProcessorClient;
import lightsearch.server.cmd.result.CommandResult;
import lightsearch.server.data.LightSearchServerDTO;
import lightsearch.server.log.LogMessageTypeEnum;
import lightsearch.server.message.result.ResultTypeMessageEnum;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Обработчик команды привязки для отладки.
 * @author ViiSE
 * @since 2.8.1
 */
public class BindProcessorDebug extends AbstractProcessorClient {

    public BindProcessorDebug(LightSearchServerDTO serverDTO, LightSearchChecker checker) {
        super(serverDTO, checker);
    }
    
    @Override
    public CommandResult apply(ClientCommand clientCommand) {
        if(!super.checker.isNull(clientCommand.IMEI(), clientCommand.userIdentifier(),
                clientCommand.barcode(), clientCommand.factoryBarcode())) {
            if(!serverDTO.blacklist().contains(clientCommand.IMEI())) {       
                String logMessage =
                        "Client " + clientCommand.IMEI() +
                        " bind, userIdent - " + clientCommand.userIdentifier()
                        + ", factoryBarcode - " + clientCommand.factoryBarcode()
                        + ", barcode - " + clientCommand.barcode();

                String result =
                        "{\n"
                            + "\"IMEI\": \"" + clientCommand.IMEI() + "\",\n"
                            + "\"is_done\": \"True\",\n"
                            + "\"message\": \"Товар привязан!\"\n"
                        + "}";

                return super.commandResult(clientCommand.IMEI(), LogMessageTypeEnum.INFO, ResultTypeMessageEnum.TRUE,
                        result, logMessage);
            }
            else
                return super.commandResult(clientCommand.IMEI(), LogMessageTypeEnum.ERROR, ResultTypeMessageEnum.FALSE,
                        "Извините, но вы находитесь в черном списке. Отключение от сервера", null);
        }
        else
            return super.commandResult("Unknown", LogMessageTypeEnum.ERROR, ResultTypeMessageEnum.FALSE,
                    "Неверный формат команды. Обратитесь к администратору для устранения ошибки. Вы были отключены от сервера", null);
    }
}
