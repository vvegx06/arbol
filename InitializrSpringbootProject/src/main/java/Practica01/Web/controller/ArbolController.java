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

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoArbol(Model model) {
        model.addAttribute("arbol", new Arbol()); // Crea un nuevo objeto Arbol
        return "nuevo_arbol"; // Nombre de la plantilla para crear un nuevo árbol
    }

    @PostMapping("/nuevo")
    public String agregarNuevoArbol(@ModelAttribute Arbol arbol) {
        arbolRepository.save(arbol); // Guarda el nuevo árbol en la base de datos
        return "redirect:/arboles"; // Redirige a la lista de árboles
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarArbol(@PathVariable Long id, Model model) {
        Arbol arbol = arbolRepository.findById(id).orElseThrow();
        model.addAttribute("arbol", arbol);
        return "editar_arbol"; // Nombre de la plantilla para editar
    }

    @PostMapping("/editar")
    public String actualizarArbol(@ModelAttribute Arbol arbol) {
        arbolRepository.save(arbol); // Guarda los cambios en la base de datos
        return "redirect:/arboles"; // Redirige a la lista de árboles
    }

    @GetMapping
    public String listarArboles(Model model) {
        model.addAttribute("arboles", arbolRepository.findAll()); // Obtiene todos los árboles
        return "arboles"; // Nombre de la plantilla para listar árboles
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable Long id) {
        arbolRepository.deleteById(id); // Elimina el árbol por ID
        return "redirect:/arboles"; // Redirige a la lista de árboles
    }
}
