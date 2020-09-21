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
package lightsearch.server.data.stream;

import lightsearch.server.exception.DataStreamCreatorException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Реализация интерфейса {@link lightsearch.server.data.stream.DataStreamCreator} по умолчанию.
 * <p>
 * Создает поток данных из сокета.
 * @author ViiSE
 * @see java.net.Socket
 * @see lightsearch.server.data.stream.DataStream
 * @since 2.0.0
 */
public class DataStreamCreatorDefaultImpl implements DataStreamCreator {

    private final Socket clientSocket;
    private DataOutputStream dataOutputStream;
    private DataInputStream  dataInputStream;
    
    public DataStreamCreatorDefaultImpl(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void createDataStream() throws DataStreamCreatorException {
        try {
            dataOutputStream  = new DataOutputStream(this.clientSocket.getOutputStream());
            dataInputStream   = new DataInputStream(this.clientSocket.getInputStream());
        } catch(IOException ex) {
            throw new DataStreamCreatorException(ex.getMessage());
        }
    }

    @Override
    public DataInputStream dataInputStream() {
        return dataInputStream;
    }

    @Override
    public DataOutputStream dataOutputStream() {
        return dataOutputStream;
    }
    
}
