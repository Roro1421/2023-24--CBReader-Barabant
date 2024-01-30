package fr.iut.rb.cbreader.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import fr.iut.rb.cbreader.models.ComicBookData;

public interface IComicsRepository extends MongoRepository<ComicBookData,ObjectId> {
    
}
