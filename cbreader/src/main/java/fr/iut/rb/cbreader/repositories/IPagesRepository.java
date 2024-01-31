package fr.iut.rb.cbreader.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import fr.iut.rb.cbreader.models.PageData;

public interface IPagesRepository extends MongoRepository<PageData,ObjectId>{
    
}
