package fr.iut.rb.cbreader.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@TypeAlias(value = "ComicBook")
public class ComicBookData implements IComicBook, IObjectId {

    private ComicBook book;

    /**
     * @param book
     */
    public ComicBookData(ComicBook book) {
        this.book = book;
    }

    private ObjectId id;

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public String getFileName() {
        return book.getFileName();
    }

    @Override
    public String getSeries() {
        return book.getSeries();
    }

    @Override
    public int getNumber() {
        return book.getNumber();
    }

    @Override
    public ObjectId getId() {
        return id;
    }
}
