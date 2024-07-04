package org.jaax.fase1.controller;

import org.jaax.fase1.entity.Local;
import org.jaax.fase1.error.LocalNotFoundException;
import org.jaax.fase1.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    LocalService localService;

    @GetMapping("/findAllLocals")
    public List<Local> findAllLocals(){
        return localService.findAllLocals();
    }

    @GetMapping("/findById/{id}")
    public Local findById(@PathVariable Long id) throws LocalNotFoundException {
        return localService.findById(id);
    }
    @GetMapping("/findByNameJPQL/{name}")
    public Optional<Local> findByNameJPQL(@PathVariable String name){
        return localService.findLocalByNameJPQL(name);
    }
    @GetMapping("/findByName/{name}")
    public Optional<Local> findByName(@PathVariable String name){
        return localService.findByName(name);
    }
    @GetMapping("/findByNameIgnoreCase/{name}")
    public Optional<Local> findByNameIgnoreCase(@PathVariable String name){
        return localService.findByNameIgnoreCase(name);
    }

    @PostMapping("/createLocal")
    public Local createLocal(@RequestBody Local local){
        return localService.saveLocal(local);
    }

    @PutMapping("/updateLocal/{id}")
    public Local updateLocal(@RequestBody Local local, @PathVariable Long id){
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/deleteLocal/{id}")
    public String deleteLocal(@PathVariable Long id){
        localService.deleteLocal(id);
        return "Succesfully deleted";
    }
}
