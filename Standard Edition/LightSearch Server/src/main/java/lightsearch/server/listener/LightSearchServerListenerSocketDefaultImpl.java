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
package lightsearch.server.listener;

import lightsearch.server.data.LightSearchListenerDTO;
import lightsearch.server.data.LightSearchServerDTO;
import lightsearch.server.exception.ConnectionIdentifierException;
import lightsearch.server.handler.HandlerCreator;
import lightsearch.server.handler.HandlerCreatorInit;
import lightsearch.server.handler.HandlerExecutor;
import lightsearch.server.handler.HandlerExecutorInit;
import lightsearch.server.identifier.ConnectionIdentifier;
import lightsearch.server.identifier.ConnectionIdentifierInit;
import lightsearch.server.identifier.ConnectionIdentifierResult;
import lightsearch.server.log.LogMessageTypeEnum;
import lightsearch.server.log.LoggerServer;
import lightsearch.server.socket.ServerSocketCreator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Реализация интерфейса {@link lightsearch.server.listener.LightSearchServerListener} по умолчанию.
 * <p>
 * Прослушивает сокет на предмет новых соединений. После того, как к серверу присоединлся клиент, вызывает
 * {@link lightsearch.server.handler.HandlerCreator} для создания соответствующего обработчика.
 * @author ViiSE
 * @see lightsearch.server.handler.Handler
 * @see lightsearch.server.handler.client.ClientHandlerDefaultImpl
 * @see lightsearch.server.handler.admin.AdminHandlerDefaultImpl
 * @since 1.0.0
 */
public class LightSearchServerListenerSocketDefaultImpl implements LightSearchServerListener {

    private final LightSearchServerDTO serverDTO;
    private final LightSearchListenerDTO listenerDTO;
    private final LoggerServer loggerServer;
    
    public LightSearchServerListenerSocketDefaultImpl(LightSearchServerDTO serverDTO,
            LightSearchListenerDTO listenerDTO, LoggerServer loggerServer) {
        this.serverDTO = serverDTO;
        this.listenerDTO = listenerDTO;
        this.loggerServer = loggerServer;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void startServer() {
            ServerSocket serverSocket = ServerSocketCreator.createServerSocket(serverDTO.serverPort());
            
            loggerServer.log(LogMessageTypeEnum.INFO, listenerDTO.currentDateTime(), "Server started");
            
            ConnectionIdentifier connectionIdentifier = ConnectionIdentifierInit.connectionIdentifier();         
            HandlerExecutor handlerExecutor = HandlerExecutorInit.handlerExecutor(listenerDTO.threadManager());
            
            while(true) {
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                    clientSocket.setSoTimeout(serverDTO.settingsDAO().clientTimeoutValue());
                    ConnectionIdentifierResult connectionIdentifierResult = connectionIdentifier.identifyConnection(clientSocket);
                    
                    HandlerCreator handlerCreator = HandlerCreatorInit.handlerCreator(
                            connectionIdentifierResult, serverDTO, listenerDTO, loggerServer);
                    handlerExecutor.executeHandler(handlerCreator.getHandler());
                } catch(IOException ex) {
                    loggerServer.log(LogMessageTypeEnum.ERROR, listenerDTO.currentDateTime(), "StartServer, acceptSocket, message - " + ex.getMessage());
                    if(clientSocket != null)
                        try { clientSocket.close(); } catch (IOException ignore) {}
                } catch(ConnectionIdentifierException ex) {
                    if(ex.getMessage() != null)
                        loggerServer.log(LogMessageTypeEnum.ERROR, listenerDTO.currentDateTime(), "StartServer, connectionIdentifier, message - " + ex.getMessage());
                    try { clientSocket.close(); } catch (IOException ignore) {}
                }
            }
    }
}
