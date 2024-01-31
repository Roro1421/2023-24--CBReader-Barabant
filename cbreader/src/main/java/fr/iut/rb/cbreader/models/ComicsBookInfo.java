package fr.iut.rb.cbreader.models;

public class ComicsBookInfo implements IComicBook{

    public ComicBookData data;

    private int fileSize;

    /**
     * @param data
     * @param fileSize
     */
    public ComicsBookInfo(ComicBookData data, int fileSize) {
        this.data = data;
        this.fileSize = fileSize;
    }

    /**
     * @return the file size
     */
    public int getFileSize() {
        return fileSize;
    }

    @Override
    public String getTitle() {
        return data.getTitle();
    }

    @Override
    public String getFileName() {
        return data.getFileName();
    }

    @Override
    public String getSeries() {
        return data.getSeries();
    }

    @Override
    public int getNumber() {
        return data.getNumber();
    }   

    public String getStrId(){
        return data.getId().toString();
    }
}
