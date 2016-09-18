package com.ian.onlinemall.test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试websocket, 一个基于websocket的服务端类
 * @author zhengnan
 *
 */

@ServerEndpoint(value="/websocket/chat")
public class ChatEndPoint {

	private static final String GUEST_PREFIX = "访客";
	private static final AtomicInteger connectionId = new AtomicInteger(0);
	
	private static final Set<ChatEndPoint> clientSet = new CopyOnWriteArraySet<ChatEndPoint>();
	
	private static final Logger logger = LoggerFactory.getLogger(ChatEndPoint.class);
	
	private String nickname;
	
	private Session session;
	
	public ChatEndPoint(){
		nickname = GUEST_PREFIX + connectionId.getAndIncrement();
	}
	
	@OnOpen
	public void start(Session session){
		this.session = session;
		clientSet.add(this);
		String message = String.format("［%s %s］", nickname, "加入了聊天室！");
		logger.error(message);
		broadcast(message);
	}
	
	@OnClose
	public void end(){
		clientSet.remove(this);
		String message = String.format("［%s %s］", nickname, "离开了聊天室！");
		logger.error(message);
		broadcast(message);
	}
	
	@OnMessage
	public void incoming(String message){
		String filteredMessage = String.format("%s: %s", nickname, filterMsg(message));
		logger.error(filteredMessage);
		broadcast(filteredMessage);
	}
	
	@OnError
	public void onError(Throwable t) throws Throwable{
		logger.error("WebSocket 服务端错误 " + t);
//		t.printStackTrace();
	}
	
	public static void broadcast(String msg){
		for (ChatEndPoint client : clientSet) {
			try {
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				logger.error("聊天错误，向客户端 " + client + " 发送消息出现错误。");
				clientSet.remove(client);
				try {
					client.session.close();
				} catch (IOException e1) {
					String message = String.format("［%s %s］", client.nickname, "已经被断开了连接。");
					logger.error(message);
					broadcast(message);
				}
			}
		}
	}
	
	public static String filterMsg(String msg){
		if (msg == null) {
			return null;
		}
		char content[] = new char[msg.length()];
		msg.getChars(0, msg.length(), content, 0);
		StringBuilder result = new StringBuilder(content.length + 50);
		
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
				break;
			}
		}
		
		return result.toString();
	}
}
