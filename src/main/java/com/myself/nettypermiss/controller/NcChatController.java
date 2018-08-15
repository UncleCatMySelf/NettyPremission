package com.myself.nettypermiss.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:32 2018\8\14 0014
 */
@Controller
@RequestMapping("/chat")
public class NcChatController {


    @GetMapping("/netty")
    public ModelAndView netty(Map<String,Object> map){
        return new ModelAndView("h5",map);
    }

}
