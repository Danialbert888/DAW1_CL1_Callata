package com.danielo.web.DAW1_CL1_Callata.controllers;

import com.danielo.web.DAW1_CL1_Callata.models.Trabajador;
import com.danielo.web.DAW1_CL1_Callata.models.TrabajadorEjercicio4;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/cl1")
public class CallataController  {
    @GetMapping("/calcularEjercicio1")
    public String formPregunta1(Model model){
        model.addAttribute("trabajador",new Trabajador());
        model.addAttribute("resultado",false);

        return "formPregunta1";
    }
    @PostMapping("/calcularEjercicio1")
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

    @GetMapping("/calcularEjercicio4")
    public String formPregunta4(Model model){
        model.addAttribute("trabajador",new TrabajadorEjercicio4());
        model.addAttribute("resultado",false);

        return "formPregunta4";
    }
    @PostMapping("/calcularEjercicio4")
    public String calcular4(@ModelAttribute("trabaja")TrabajadorEjercicio4 trabajadorrr,Model model ){
        Integer salari=trabajadorrr.getSalariomensual();
        Integer tiempo=trabajadorrr.getTiempotrabajo();
        Double utilidadd=0.0;
        if ( tiempo<1 ){
            utilidadd=salari*0.05;
        } else if (tiempo>=1 && tiempo<2) {
            utilidadd=salari*0.07;
        } else if (tiempo>=2 && tiempo<5) {
            utilidadd=salari*0.1;
        } else if (tiempo>=5 && tiempo<10) {
            utilidadd=salari*0.15;
        } else {
            utilidadd=salari*0.2;
        }
        model.addAttribute("verresultadoo",true);

        model.addAttribute("resultado4","Su utilidad es "+utilidadd);

        return "formPregunta4";

    }







}
