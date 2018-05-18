package com.dxx.websocket.meta;

/**
 * @Auther duxingxing
 * @Date 2018/5/16 16:40
 * 浏览器向服务端发送的消息
 */
public class AricMessage {

    private String clientMessage;

    public String getClientMessage() {
        return clientMessage;
    }

    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage;
    }
}
