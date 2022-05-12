package com.example.doge.Controller;

import com.example.doge.DTO.DogDTO;
import com.example.doge.DTO.HumanDTO;
import com.example.doge.Model.Dog;
import com.example.doge.Model.Human;
import com.example.doge.Service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DogController {

    private final DogService dogService;


    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public List<DogDTO> getAllDogs() {
        return dogService.getAllDogs();
    }

    @PostMapping("/dogs")
    public int addDog(@Valid @RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<DogDTO> get(@PathVariable int id) {
        return dogService.get(id);
    }

    @DeleteMapping("/dogs/{id}")
    public ResponseEntity<DogDTO> delete(@PathVariable int id) {
        return dogService.delete(id);
    }

    @PutMapping("/dogs/{id}")
    public ResponseEntity<DogDTO> update(@PathVariable int id, @RequestBody Dog dog) {
        return dogService.update(id, dog.getName(), dog.getAge(), dog.getWeight(), dog.getOwner());
    }
}
