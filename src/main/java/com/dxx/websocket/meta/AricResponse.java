package com.dxx.websocket.meta;

/**
 * @Auther duxingxing
 * @Date 2018/5/16 16:41
 * 服务端向浏览器发送的消息
 */
public class AricResponse {

    private String serverMessage;

    public AricResponse(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
