package operateingSystem.filemanage.core.web;

import lombok.Data;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/5 10:50
 */
@ServerEndpoint("/fileManage/{account}")
@Data
public class WebSocketServlet {
  ConcurrentHashMap<String, Session> userMap = new ConcurrentHashMap<>();

  @OnOpen
  public void onOpen(Session session, @PathParam("account") String account) {

  }

  @OnMessage
  public void onMessage(String message, Session session) {

  }

  @OnClose
  public void onClose() {
    System.out.println("用户已经关闭WebSocket连接");
  }
}
