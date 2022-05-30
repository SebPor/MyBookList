package com.sebasPortillo.Controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListAPIController {

    @GetMapping("get/list/{idUser}")
    public String getListbyUserId(@PathVariable(name = "idUser") String idUser){

        return "";
    }

}
