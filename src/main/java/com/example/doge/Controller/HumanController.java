package com.example.doge.Controller;

import com.example.doge.DTO.HumanDTO;
import com.example.doge.Model.Human;
import com.example.doge.Service.HumanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HumanController {

    private final HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }


    @GetMapping("/humans")
    public List<HumanDTO> getAllHumans() {
        return humanService.getAllHuman();
    }

    @PostMapping("/humans")
    public int addHuman(@Valid @RequestBody Human human) {
        return humanService.addHuman(human);
    }

    @GetMapping("/humans/{id}")
    public ResponseEntity<HumanDTO> get(@PathVariable int id) {
        return humanService.get(id);
    }

    @DeleteMapping("/humans/{id}")
    public ResponseEntity<HumanDTO> delete(@PathVariable int id) {
        return humanService.delete(id);
    }
//    @PutMapping("/humans/{id}")
    public ResponseEntity<HumanDTO> update(@PathVariable int id, @RequestBody Human human) {
        return humanService.update(id, human.getName(), human.getAge());
    }
}
