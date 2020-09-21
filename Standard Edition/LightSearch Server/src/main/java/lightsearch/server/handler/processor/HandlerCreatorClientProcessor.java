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
package lightsearch.server.handler.processor;

import lightsearch.server.cmd.client.ClientCommand;
import lightsearch.server.cmd.client.ClientCommandCreator;
import lightsearch.server.cmd.client.ClientCommandCreatorInit;
import lightsearch.server.cmd.result.CommandResult;
import lightsearch.server.data.*;
import lightsearch.server.handler.Handler;
import lightsearch.server.handler.client.ClientHandlerInit;
import lightsearch.server.identifier.ConnectionIdentifierResult;
import lightsearch.server.identifier.HandlerIdentifier;
import lightsearch.server.log.LoggerServer;
import lightsearch.server.thread.LightSearchThreadID;

import java.util.Map;
import java.util.function.Function;

/**
 * Обработчик команды создания обработчика клиента LightSearch Server.
 * <p>
 * @author ViiSE
 * @see lightsearch.server.listener.LightSearchServerListener
 * @see lightsearch.server.handler.HandlerCreator
 * @since 2.0.0
 */
public class HandlerCreatorClientProcessor extends SuperHandlerCreatorProcessor {
    
    public HandlerCreatorClientProcessor(ConnectionIdentifierResult identifierResult, 
            LightSearchServerDTO serverDTO, LightSearchListenerDTO listenerDTO, 
            LoggerServer loggerServer, HandlerIdentifier handlerIdentifier) {
        super(identifierResult, serverDTO, listenerDTO, loggerServer, handlerIdentifier);
    }
    
    @Override
    public Handler apply(Void ignore) {
        ClientDAO clientDAO = ClientDAOInit.clientDAO();
            
        ClientCommandCreator clientCmdCreator = ClientCommandCreatorInit.clientCommandCreator(
                super.serverDTO(), super.listenerDTO(), clientDAO);
        Map<String, Function<ClientCommand, CommandResult>> commandHolder = clientCmdCreator.createCommandHolder();

        String id = LightSearchThreadID.createID(super.identifierResult().identifier(), super.handlerIdentifier().next());
        ThreadParametersHolder threadParametersHolder = ThreadParametersHolderInit.threadParametersHolder(id);

        ClientParametersHolder clientParamHolder = ClientParametersHolderInit.clientParametersHolder(
            super.identifierResult().clientSocket(), super.identifierResult().dataStream(), commandHolder);

        ClientHandlerDTO clientHandlerDTO = ClientHandlerDTOInit.clientHandlerDTO(clientParamHolder,
                threadParametersHolder, super.listenerDTO().currentDateTime(), 
                super.listenerDTO().threadManager(), clientDAO);

        return ClientHandlerInit.clientHandler(clientHandlerDTO, super.serverDTO(), super.loggerServer());
    }
}
