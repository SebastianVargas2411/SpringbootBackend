/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.backend.controladores;

import co.edu.utp.isc.gia.backend.entidades.Examen;
import co.edu.utp.isc.gia.backend.interfaces.ExamenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johan
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)//url de angular
@RestController
@RequestMapping({"/examenes"})
public class ExamenControlador {
    
    @Autowired
    ExamenService examenService;
    
    @GetMapping
    public List<Examen>listar(){
        return examenService.listar();
    }
    @GetMapping(path = "/{id}")//id del examen
    public Examen listarExmaenId(@PathVariable("id") int id){
        return examenService.listarId(id);
    }
    @PostMapping
    public Examen agregar(@RequestBody Examen examen){
        return examenService.crear(examen);
    }
    @DeleteMapping(path = {"/{id}"})
    public Examen eliminar(@PathVariable("id") int id){
        return examenService.eliminar(id);
    }
    
    
}