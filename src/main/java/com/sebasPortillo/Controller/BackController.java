package com.sebasPortillo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BackController {

    @GetMapping("back")
    private String index(){

        return "indexBack";
    }
}
