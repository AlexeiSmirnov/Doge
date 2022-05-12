package com.example.doge.Utils;

import com.example.doge.DTO.DogDTO;
import com.example.doge.DTO.HumanDTO;
import com.example.doge.Model.Dog;
import com.example.doge.Model.Human;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HumanMapper {
    private final DogMapper dogMapper;

    public HumanMapper(DogMapper dogMapper) {
        this.dogMapper = dogMapper;
    }

    public HumanDTO mapToHumanDTO(Human human) {
        HumanDTO dto = new HumanDTO();
//        Set<DogDTO> dogDTOs = dto.getDogs();
        dto.setAge(human.getAge());
        dto.setId(human.getId());
        dto.setName(human.getName());
        dto.setDogs(human.getDogs().stream().map(dogMapper::mapToDogDTO).collect(Collectors.toSet()));
        dto.setDogsCount(dto.getDogs().size());
        double summaryDogsAge = 0;
        if (dto.getDogsCount() > 0) {
            for (DogDTO dog : dto.getDogs()) {
                summaryDogsAge += dog.getAge();
            }
            dto.setAvarageDogsAge(summaryDogsAge / dto.getDogsCount());
        } else {
            dto.setAvarageDogsAge(0);
        }
        return dto;
    }

    public Human mapToHuman(HumanDTO humanDTO) {
        Set<Dog> dogs = null;
        Human human = new Human();
        human.setAge(humanDTO.getAge());
        human.setId(humanDTO.getId());
        human.setName(humanDTO.getName());
        for (DogDTO dogDTO : humanDTO.getDogs()) {
            dogs.add(dogMapper.mapToDog(dogDTO));
        }
        human.setDogs(dogs);
        return human;
    }
}
