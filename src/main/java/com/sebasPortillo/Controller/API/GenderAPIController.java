package com.sebasPortillo.Controller.API;

import com.sebasPortillo.Service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderAPIController {

    @Autowired
    private GenderService genderService;
}
