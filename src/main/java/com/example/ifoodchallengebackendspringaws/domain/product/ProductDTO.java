package com.example.ifoodchallengebackendspringaws.domain.product;

public record ProductDTO (String title, String description, String ownerId, Integer price, String categoryId) {
}
