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
package lightsearch.server.cmd.admin;

import lightsearch.server.cmd.result.CommandResult;

import java.util.Map;
import java.util.function.Function;

/**
 * Создает обработчики команд администратора LightSearch Server.
 * <p>
 * Все команды администратора, которые должны обрабатываться LightSearch Server, помещаются в контейнер команд. Команды
 * из контейнера берутся по имени команды.
 * @author ViiSE
 * @see lightsearch.server.handler.processor
 * @since 1.0.0
 */
public interface AdminCommandCreator {
    Map<String, Function<AdminCommand, CommandResult>> createCommandHolder();
}
