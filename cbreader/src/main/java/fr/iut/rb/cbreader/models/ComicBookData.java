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
    private String title;
    private String fileName;
    private String series;
    private int number;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getSeries() {
        return series;
    }

    @Override
    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public ObjectId getId() {
        return id;
    }

    @Override
    public void setId(ObjectId id) {
        this.id = id;
    }

}
