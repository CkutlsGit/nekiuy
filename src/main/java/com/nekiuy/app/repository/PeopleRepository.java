package com.nekiuy.app.repository;

import com.nekiuy.app.model.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Long> {
}
