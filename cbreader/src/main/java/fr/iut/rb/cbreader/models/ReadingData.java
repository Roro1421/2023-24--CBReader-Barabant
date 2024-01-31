package fr.iut.rb.cbreader.models;

import java.time.Instant;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Reading")
@TypeAlias("Reading")
public class ReadingData implements IObjectId{

    @Id
    private ObjectId id;
    private Date dateStartReading;
    private int currentPage;
    private int numberOfPages;
    private ObjectId idComicBook;

    
    /**
     * @param id
     * @param currentPage
     * @param numberOfPages
     * @param idComicBook
     */
    public ReadingData(int numberOfPages, ObjectId idComicBook) {
        this.currentPage = 1;
        this.numberOfPages = numberOfPages;
        this.idComicBook = idComicBook;
        this.dateStartReading = Date.from(Instant.now());
    }

    /***
     * @return the date of the starting of reading
     */
    public Date getDateStartReading() {
        return dateStartReading;
    }

    /***
     * @return the current page
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /***
     * @return the number of pages
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /***
     * @return the id of the book
     */
    public ObjectId getIdComicBook() {
        return idComicBook;
    }

    @Override
    public ObjectId getId() {
        return id;
    }
    
}
