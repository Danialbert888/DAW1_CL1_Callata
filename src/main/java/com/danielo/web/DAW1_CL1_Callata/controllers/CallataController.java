package com.danielo.web.DAW1_CL1_Callata.controllers;

import com.danielo.web.DAW1_CL1_Callata.models.Trabajador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CallataController {
    @GetMapping("/calcularPregunta1")
    public String formPregunta1(Model model){
        model.addAttribute("trabajador",new Trabajador());

        return "formPregunta1";
    }
    @PostMapping("/calcularPregunta1")
    public String calcular1(@ModelAttribute("trabajado") Trabajador trabajadorr,Model model ){


        String jubilacion="";


        return "formPregunta1";
    }




}
