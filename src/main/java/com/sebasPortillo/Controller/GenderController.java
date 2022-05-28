package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Gender;
import com.sebasPortillo.Service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("back/")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping("genderCrud/{mode}")
    public String genderCrud(@PathVariable(name = "mode") String mode, Model model){
        model.addAttribute("mode",mode);

        if(mode.equals("insertar")){
            return "back/genderInsert";
        }

        model.addAttribute("genders",genderService.findAll());
        if(mode.equals("ver")){
            return "back/genderVer";
        }
        return "back/genderDelete";
    }

    @GetMapping("gender/delete/{idGender}")
    public String genderDelete(@PathVariable(name = "idGender")String idGender){
        long id = Long.parseLong(idGender);
        genderService.deleteById(id);

        return "redirect:/back/genderCrud/borrar";
    }

    @PostMapping("gender/insert")
    public String genderInsert(@ModelAttribute(value = "gender") String gender){
        Gender genderEntity = new Gender();
        genderEntity.setId(0);
        genderEntity.setNombre(gender);
        genderService.save(genderEntity);

        return "redirect:/back/genderCrud/insertar";
    }
}
