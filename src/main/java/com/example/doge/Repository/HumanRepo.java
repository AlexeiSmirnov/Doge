package com.example.doge.Repository;

import com.example.doge.Model.Human;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepo extends CrudRepository<Human, Integer> {
}
