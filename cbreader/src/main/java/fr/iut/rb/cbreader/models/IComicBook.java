package fr.iut.rb.cbreader.models;

public interface IComicBook {

    /**
     * @return the title of the comic
     */
    public String getTitle();
    
    /**
     * @return the fileName of the comic
     */
    public String getFileName();

    /**
     * @return the series of the comic
     */
    public String getSeries();

    /**
     * @return the number of the comic
     */
    public int getNumber();

}
