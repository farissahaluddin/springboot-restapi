package com.kelaskoding.models.repos;

import com.kelaskoding.models.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
