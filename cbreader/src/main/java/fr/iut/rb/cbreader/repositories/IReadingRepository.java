package fr.iut.rb.cbreader.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import fr.iut.rb.cbreader.models.ReadingData;

public interface IReadingRepository extends MongoRepository<ReadingData,ObjectId> {
    
}
