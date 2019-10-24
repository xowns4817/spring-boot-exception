package com.example.exception.test.demo.controller;

import Apps.ErrorConst;
import com.example.exception.test.demo.exception.ParameterException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApiController {


    // require = true 이면 이 parameter무조건 들어와야됨. default가 true
    // defaultValue 설정하면 만약, 없으면 그 값으로 초기화 하겠다.
    @GetMapping("/test")
    public void test(@RequestParam(value="ip", required = false, defaultValue = "") String ip,
                     @RequestParam(value="db_name", required = false, defaultValue = "") String db_name,
                     @RequestParam(value="lan_start", required = false, defaultValue = "") String lan_start,
                     @RequestParam(value="lan_end", required = false, defaultValue = "") String lan_end) {

        System.out.println("/test");

        if(ip.equals("")) throw new ParameterException(ErrorConst.NOT_FOUND_IP);
        if(db_name.equals("")) throw new ParameterException(ErrorConst.NOT_FOUND_DB);
        if(lan_start.equals("")) throw new ParameterException(ErrorConst.NOT_FOUND_LAN_START);
        if(lan_end.equals("")) throw new ParameterException(ErrorConst.NOT_FOUND_LAN_END);


        System.out.println("인자 모두 받음.");
    }
}
