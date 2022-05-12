package com.example.doge.Repository;

import com.example.doge.Model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends CrudRepository <Dog, Integer> {


}
