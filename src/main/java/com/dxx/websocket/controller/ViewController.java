package com.dxx.websocket.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther duxingxing
 * @Date 2018/5/16 16:46
 * 配置viewController,为页面提供路径映射
 */
@Controller
public class ViewController{

    @Value("${aaa}")
    private String aaa;

    /**
     * 配置viewController,提供映射路径
     */
    @RequestMapping("/webSocket")
    public String webSocket() {
        return "webSocket";
    }

    @RequestMapping("/chat")
    public String chat() {
        System.out.println(aaa);
        return "chat";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
