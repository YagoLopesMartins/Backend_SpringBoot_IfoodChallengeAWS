package com.example.ifoodchallengebackendspringaws.domain.product;

import com.example.ifoodchallengebackendspringaws.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;

    private  String title;

    private  String description;

    private  String ownerId;
    private  Integer price;

    //private String category;

    public Product(ProductDTO data){
        this.title = data.title();
        this.description = data.description();
        this.ownerId = data.ownerId();
        this.price = data.price();
       // this.category = data.categoryId();
    }

//    @Override
//    public String toString(){
//        JSONObject json = new JSONObject();
//        json.put("id", id);
//        json.put("title", title);
//        json.put("description", description);
//        json.put("ownerId", ownerId);
//        json.put("price", price);
//        json.put("category", category);
//        json.put("type", "produto");
//
//        return json.toString();
//    }
}
