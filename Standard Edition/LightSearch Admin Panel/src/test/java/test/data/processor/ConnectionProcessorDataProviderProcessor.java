package test.data.processor;

import lightsearch.admin.panel.connect.processor.ConnectionProcessorInit;
import lightsearch.admin.panel.data.ConnectionDTO;
import lightsearch.admin.panel.data.creator.ConnectionDTOCreator;
import lightsearch.admin.panel.data.creator.ConnectionDTOCreatorInit;
import lightsearch.admin.panel.data.stream.DataStream;
import lightsearch.admin.panel.data.stream.DataStreamCreator;
import lightsearch.admin.panel.data.stream.DataStreamCreatorInit;
import lightsearch.admin.panel.data.stream.DataStreamInit;
import lightsearch.admin.panel.exception.DataStreamCreatorException;
import lightsearch.admin.panel.exception.SocketException;
import lightsearch.admin.panel.message.MessageRecipient;
import lightsearch.admin.panel.message.MessageRecipientInit;
import lightsearch.admin.panel.message.MessageSender;
import lightsearch.admin.panel.message.MessageSenderInit;
import lightsearch.admin.panel.socket.SocketCreator;
import lightsearch.admin.panel.socket.SocketCreatorInit;

import java.net.Socket;

import static test.message.TestMessage.catchMessage;

public class ConnectionProcessorDataProviderProcessor implements DataProviderProcessor {

    @Override
    public Object apply(Object... args) {
        String ip = (String) args[0];
        int port =  (Integer) args[1];

        ConnectionDTOCreator connDTOCreator = ConnectionDTOCreatorInit.connectionDTOCreatorTest(ip, port);
        ConnectionDTO connDTO = connDTOCreator.createConnectionDTO();

        SocketCreator admSocketCreator = SocketCreatorInit.socketCreator(connDTO);

        try {
            Socket adminSocket = admSocketCreator.createSocket();
            DataStreamCreator dsCreator = DataStreamCreatorInit.dataStreamCreator(adminSocket);
            dsCreator.createDataStream();

            DataStream ds = DataStreamInit.dataStream(dsCreator);

            MessageSender msgSender = MessageSenderInit.messageSender(ds.dataOutputStream());
            MessageRecipient msgRecipient = MessageRecipientInit.messageRecipient(ds.dataInputStream());

            return ConnectionProcessorInit.connectionProcessor(msgSender, msgRecipient);
        } catch(SocketException | DataStreamCreatorException ex) {
            catchMessage(ex);
            return null;
        }
    }
}
