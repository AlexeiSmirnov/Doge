package com.example.doge.Service;

import com.example.doge.DTO.HumanDTO;
import com.example.doge.Model.Dog;
import com.example.doge.Model.Human;
import com.example.doge.Repository.HumanRepo;
import com.example.doge.Utils.HumanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HumanService {
    private final HumanRepo humanRepo;
    private final HumanMapper humanMapper;

    public HumanService(HumanRepo humanRepo, HumanMapper humanMapper) {
        this.humanRepo = humanRepo;
        this.humanMapper = humanMapper;
    }

    public List<HumanDTO> getAllHuman() {
        Iterable<Human> humanIterable  = humanRepo.findAll();
        ArrayList<HumanDTO> humans = new ArrayList<>();
        double summaryDogsAge = 0;
        for (Human human : humanIterable) {
            humans.add(humanMapper.mapToHumanDTO(human));
        }
        return humans;
    }

    public int addHuman (Human human) {
        Human newHuman = humanRepo.save(human);
        return newHuman.getId();
    }

    public ResponseEntity<HumanDTO> get(int id) {
        Optional<Human> optionalHuman = humanRepo.findById(id);
        if (optionalHuman.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(humanMapper.mapToHumanDTO(optionalHuman.get()), HttpStatus.OK);
    }

    public ResponseEntity<HumanDTO> delete(int id) {

        Optional<Human> optionalHuman = humanRepo.findById(id);

        if (optionalHuman.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        humanRepo.delete(optionalHuman.get());
        return new ResponseEntity<>(humanMapper.mapToHumanDTO(optionalHuman.get()), HttpStatus.OK);

    }

    public ResponseEntity<HumanDTO> update(int id, String name, int age) {
        Optional<Human> optionalHuman = humanRepo.findById(id);

        if (optionalHuman.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        optionalHuman.get().setName(name);
        optionalHuman.get().setAge(age);
        humanRepo.save(optionalHuman.get());
        return new ResponseEntity<>(humanMapper.mapToHumanDTO(optionalHuman.get()), HttpStatus.OK);
    }

}
