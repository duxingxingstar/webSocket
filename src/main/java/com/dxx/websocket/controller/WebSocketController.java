package com.dxx.websocket.controller;

import com.dxx.websocket.meta.AricMessage;
import com.dxx.websocket.meta.AricResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @Auther duxingxing
 * @Date 2018/5/16 16:39
 */
@Controller
public class WebSocketController {

    //通过simpMessagingTemplate向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Value("${dxx.name}")
    private String name;

    @MessageMapping("/chat")
    //在springmvc中,可以直接在参数中获得principal,pinciple中包含当前用户信息
    public void handleChat(Principal principal, String msg){
        System.out.println("dxx.name = "+name);
        //向用户发送消息,第一个参数:接收消息的用户,第二个参数:浏览器订阅地址,第三个参数:消息
//        simpMessagingTemplate.convertAndSendToUser(principal.getName(),
//                "/queue/notifications", principal.getName() + "-send: " + msg);
        simpMessagingTemplate.convertAndSend("/topic/weChat", principal.getName() + "-say: " + msg);
    }

    /**
     * 当浏览器向服务端发送请求时,通过@MessageMapping映射/welcome这个地址,类似于@ResponseMapping
     * 当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
     * @param message
     * @return
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public AricResponse sya(AricMessage message){
        try {
            //睡眠1秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AricResponse("welcome," + message.getClientMessage() + "!");
    }
}
