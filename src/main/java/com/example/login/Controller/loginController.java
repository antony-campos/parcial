/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.login.Controller;

import com.example.login.Model.Registro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ANTONY
 */
@Controller
public class loginController {

    // Mostrar el formulario de login
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("registro", new Registro()); // Asegúrate de que el objeto tenga el mismo nombre que en la vista
        return "/login"; // Carga la vista de login
    }

    // Procesar el formulario de login
    @PostMapping("/login")
    public String loginPost(@ModelAttribute Registro registro, Model model) {
        if ("admin".equals(registro.getUsuario()) && "admin".equals(registro.getContraseña())) {
            return "redirect:/success"; // Redirige a la vista de éxito
        } else {
            model.addAttribute("error", true); // Añade un atributo para mostrar el error en la vista
            return "login"; // Retorna a la misma vista con un mensaje de error
        }
    }

    // Vista de éxito
    @GetMapping("/login")
    public String success() {
        return "login"; // Devuelve la vista de éxito
    }

   
}
