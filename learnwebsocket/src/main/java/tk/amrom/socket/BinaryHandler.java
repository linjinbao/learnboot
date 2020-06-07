package tk.amrom.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.io.*;
import java.util.*;

/**
 * @author linjinbao66@gmail.com
 * @date 2020/6/7
 * 处理文件socket
 */
public class BinaryHandler extends BinaryWebSocketHandler {
    private static final Logger LOG = LoggerFactory.getLogger(BinaryHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        LOG.info("handleTextMessage");
        LOG.info(message.getPayload());
    }
    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        LOG.info("handleBinaryMessage");
        int payloadLength = message.getPayloadLength();
        session.sendMessage(new TextMessage("Receiving Data " + payloadLength));
        byte[] array = message.getPayload().array();
        String chunkName = "e:\\tmp\\" + UUID.randomUUID().toString();
        File file = new File(chunkName);
        FileOutputStream fou = new FileOutputStream(chunkName);
        LOG.info("chunkName = " + chunkName);
        fou.write(array);
        fou.flush();
        fou.close();
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> webSocketMessage) throws Exception {
        if (webSocketMessage instanceof TextMessage){
            handleTextMessage(session, (TextMessage)webSocketMessage);
        }else if (webSocketMessage instanceof BinaryMessage){
            handleBinaryMessage(session, (BinaryMessage)webSocketMessage);
        }else if (webSocketMessage instanceof PongMessage) {
            handlePongMessage(session, (PongMessage) webSocketMessage);
        }else {
            throw new IllegalStateException("Unexpected WebSocket message type: " + webSocketMessage);
        }
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        LOG.info("handlePongMessage");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        LOG.info("handleTransportError");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public BinaryHandler() {
        super();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOG.info("连接建立，开始通信");
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOG.info("连接关闭，，，");
        LOG.info("开始合并文件");
        File file = new File("e:\\tmp");
        File[] files = file.listFiles();
        LOG.info("files.length = " + files.length);
        BufferedOutputStream destOutputStream =
                new BufferedOutputStream(new FileOutputStream("e:\\tmpb\\b"));
        byte[] fileBuffer = new byte[1024];
        int readBytesLength = 0;
        for (int i=0; i<files.length; i++){
            File sourceFile = files[i];
            BufferedInputStream sourceInputStream =
                    new BufferedInputStream(new FileInputStream(sourceFile));
            while((readBytesLength=sourceInputStream.read(fileBuffer))!=-1){
                destOutputStream.write(fileBuffer, 0, readBytesLength);
            }
            sourceFile.delete();
        }
        destOutputStream.flush();
        destOutputStream.close();

        LOG.info("文件合并完成");
    }
}
