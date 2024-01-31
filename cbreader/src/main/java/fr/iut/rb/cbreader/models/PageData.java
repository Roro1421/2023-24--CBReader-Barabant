package fr.iut.rb.cbreader.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Page")
@TypeAlias("Page")
public class PageData implements IObjectId{

    @Id
    private ObjectId id;
    private int number;
    private String fileName;
    private ObjectId IdReading;
    
    /**
     * @param id
     * @param number
     * @param fileName
     * @param idReading
     */
    public PageData( int number, String fileName, ObjectId idReading) {
        this.number = number;
        this.fileName = fileName;
        IdReading = idReading;
    }

    /***
     * @return the page number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /***
     * @return the id 
     */
    public ObjectId getIdReading() {
        return IdReading;
    }

    @Override
    public ObjectId getId() {
        return id;
    }
    
}
