package com.danielo.web.DAW1_CL1_Callata.controllers;

import com.danielo.web.DAW1_CL1_Callata.models.Trabajador;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/cl1")
public class CallataController  {
    @GetMapping("/calcularPregunta1")
    public String formPregunta1(Model model){
        model.addAttribute("trabajador",new Trabajador());
        model.addAttribute("resultado",false);

        return "formPregunta1";
    }
    @PostMapping("/calcularPregunta1")
    public String calcular1(@ModelAttribute("trabajado") Trabajador trabajadorr,Model model ){

        String genero=trabajadorr.getSexo();
        Integer edadd=trabajadorr.getEdad();
        String jubilacion="";
        if ( genero=="Hombre" && edadd>=60 ){
            jubilacion="ya puede jubilarse";
        } else if (genero=="Mujer" && edadd>=54) {
            jubilacion="ya puede jubilarse";
        } else {
            jubilacion="aun no puede jubilarse";
        }
        model.addAttribute("verresultado",true);
        model.addAttribute("resultado","Usted "+jubilacion);
        return "formPregunta1";
    }




}
