package com.example.doge.Utils;

import com.example.doge.DTO.DogDTO;
import com.example.doge.Model.Dog;
import org.springframework.stereotype.Service;

@Service
public class DogMapper {
    public DogDTO mapToDogDTO(Dog dog) {
        DogDTO dto = new DogDTO();
        dto.setAge(dog.getAge());
        dto.setId(dog.getId());
        dto.setName(dog.getName());
        dto.setWeight(dog.getWeight());
        return dto;
    }

    public Dog mapToDog (DogDTO DogDTO) {
        Dog dog = new Dog();
        dog.setAge(DogDTO.getAge());
        dog.setId(DogDTO.getId());
        dog.setName(DogDTO.getName());
        dog.setWeight(DogDTO.getWeight());
        return dog;
    }

}
