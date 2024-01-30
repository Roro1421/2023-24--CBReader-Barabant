package fr.iut.rb.cbreader.models;

public interface IComicBook {

    /**
     * @return the title of the comic
     */
    public String getTitle();
    /**
     * @param title
     */
    public void setTitle(String title);
    /**
     * @return the fileName of the comic
     */
    public String getFileName();
    /**
     * @param fileName
     */
    public void setFileName(String fileName);
    /**
     * @return the series of the comic
     */
    public String getSeries();
    /**
     * @param series
     */
    public void setSeries(String series);
    /**
     * @return the number of the comic
     */
    public int getNumber();
    /**
     * @param number
     */
    public void setNumber(int number);
}
