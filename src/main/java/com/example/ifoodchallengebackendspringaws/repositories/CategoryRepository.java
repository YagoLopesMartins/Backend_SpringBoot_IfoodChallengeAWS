package com.example.ifoodchallengebackendspringaws.repositories;

import com.example.ifoodchallengebackendspringaws.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
