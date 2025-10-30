package com.gc_dojo.demo.controllers;

import com.gc_dojo.demo.dtos.UpdatePirateDTO;
import com.gc_dojo.demo.enums.Raca;
import com.gc_dojo.demo.models.Pirata;
import com.gc_dojo.demo.repositories.PiratesRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// gente vamos criar o createPirate

// eu preciso desse pc
// igor abre no outro pc pedrosouza458 repositorio tasky ele tá publico.
@RestController
@RequestMapping("/pirate")
// olha na classe o que tem encima
public class PirateController {
    private final PiratesRepositories piratesRepositories;

    public PirateController(PiratesRepositories piratesRepositories) {
        this.piratesRepositories = piratesRepositories;
    }

    // me mostra o createTask vamos deixar pro final melhor se todo o resto tiver pronto
    // é que os metodos é o mais chato de fazer
    // vamos terminar esse primeiro
    @PostMapping("/")
    public ResponseEntity<Object> CreatePirate(@RequestBody Pirata pirate) {
        // tem o {id}
        try {
            piratesRepositories.save(pirate);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Pirate created succesfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePirate(@PathVariable Integer id, @RequestBody UpdatePirateDTO) {
        Optional<Pirata> result = piratesRepositories.findById(id);
        if (result.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Pirate not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        try {
            Pirata pirataToUpdate = result.get();
            pirataToUpdate.

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePirate(@PathVariable Integer id) {
       Optional<Pirata> result = piratesRepositories.findById(id);

       if(result.isPresent()) {
         return ResponseEntity.ok(result.get());
       }

       try{
           piratesRepositories.deleteById(id);
       } catch(Exception e){
           //  dai o codigo nao roda pq precisa do response entity
           Map<String, String> response = new HashMap<>();
           response.put("message", "Pirates not found");
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
       }
    }

    @GetMapping("/{race}")
    public ResponseEntity<Object> getPiratesByRace(@PathVariable Raca race) {
        Optional<Pirata> result = piratesRepositories.findByRace(race);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Pirates not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Pirata>> getPirates() {
        List<Pirata> pirates = piratesRepositories.findAll();
        return ResponseEntity.ok(pirates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPirateById(@RequestParam Integer id) {

        Optional<Pirata> result = piratesRepositories.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Pirate not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    // getById
}









}
