package com.example.Nutritional_Science.Repository;

import com.example.Nutritional_Science.Entity.UserParameters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserParametersRepository extends CrudRepository<UserParameters, Long> {
    UserParameters findById(long id);
}
