package com.example.Nutritional_Science.Repository;


import com.example.Nutritional_Science.Entity.FoodMenu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMenuRepository extends CrudRepository<FoodMenu, Long> {
}
