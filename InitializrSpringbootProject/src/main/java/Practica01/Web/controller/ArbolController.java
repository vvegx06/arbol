/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica01.Web.controller;

import Practica01.Web.model.Arbol;
import Practica01.Web.repository.ArbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/arboles")
public class ArbolController {

    @Autowired
    private ArbolRepository arbolRepository;

    @GetMapping
    public String listarArboles(Model model) {
        List<Arbol> arboles = arbolRepository.findAll();
        model.addAttribute("arboles", arboles);
        return "arboles";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoArbol(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "nuevo_arbol";
    }

    @PostMapping
    public String guardarArbol(@ModelAttribute Arbol arbol) {
        arbolRepository.save(arbol);
        return "redirect:/arboles";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarArbol(@PathVariable Long id, Model model) {
        Arbol arbol = arbolRepository.findById(id).orElseThrow();
        model.addAttribute("arbol", arbol);
        return "editar_arbol";
    }

    @PostMapping("/editar")
    public String actualizarArbol(@ModelAttribute Arbol arbol) {
        arbolRepository.save(arbol); 
        return "redirect:/arboles"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable Long id) {
        arbolRepository.deleteById(id);
        return "redirect:/arboles";
    }
}
