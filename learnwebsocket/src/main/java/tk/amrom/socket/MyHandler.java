package tk.amrom.socket;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linjinbao66@gmail.com
 * @date 2020/6/7
 */
public class MyHandler extends TextWebSocketHandler {
    private static final Logger LOG = LoggerFactory.getLogger(MyHandler.class);
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String playload = message.getPayload();
        Map<String, String> map = JSONObject.parseObject(playload, HashMap.class);
        LOG.info("=====接受到的数据" + map);
        session.sendMessage(new TextMessage("服务器返回的消息, "+ playload));
    }
}
