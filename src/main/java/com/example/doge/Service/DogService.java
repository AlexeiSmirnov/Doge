package com.example.doge.Service;

import com.example.doge.DTO.DogDTO;
import com.example.doge.DTO.HumanDTO;
import com.example.doge.Model.Dog;
import com.example.doge.Model.Human;
import com.example.doge.Repository.DogRepo;
import com.example.doge.Utils.DogMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    private final DogRepo dogRepo;
    private final DogMapper dogMapper;

    public DogService(DogRepo dogRepo, DogMapper dogMapper) {
        this.dogRepo = dogRepo;
        this.dogMapper = dogMapper;
    }

    public List<DogDTO> getAllDogs() {
        Iterable<Dog> dogIterable  = dogRepo.findAll();
        ArrayList<DogDTO> dogs = new ArrayList<>();
        for (Dog dog : dogIterable) {
            dogs.add(dogMapper.mapToDogDTO(dog));
        }
        return dogs;
    }

    public int addDog (Dog dog) {
        Dog newDog = dogRepo.save(dog);
        return newDog.getId();
    }

    public ResponseEntity<DogDTO> get(int id) {
        Optional<Dog> optionalDog = dogRepo.findById(id);
        if (optionalDog.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(dogMapper.mapToDogDTO(optionalDog.get()), HttpStatus.OK);
    }

    public ResponseEntity<DogDTO> delete(int id) {
        Optional<Dog> optionalDog = dogRepo.findById(id);
        if (optionalDog.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        dogRepo.delete(optionalDog.get());
        return new ResponseEntity<>(dogMapper.mapToDogDTO(optionalDog.get()), HttpStatus.OK);
    }

    public ResponseEntity<DogDTO> update(int id, String name, int age, double weight, Human owner) {
        Optional<Dog> optionalDog = dogRepo.findById(id);

        if (optionalDog.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        optionalDog.get().setName(name);
        optionalDog.get().setAge(age);
        optionalDog.get().setWeight(weight);
        optionalDog.get().setOwner(owner);
        dogRepo.save(optionalDog.get());
        return new ResponseEntity<>(dogMapper.mapToDogDTO(optionalDog.get()), HttpStatus.OK);
    }


}
