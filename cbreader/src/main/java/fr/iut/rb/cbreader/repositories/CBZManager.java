package fr.iut.rb.cbreader.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/**
 * Class to manage CBZ
 */

public class CBZManager {
    private final int BUFFER_SIZE=4096;
    private String cbzFolder;
    private String jpegFolder;
    private List<String> files;

    /**
     * Initialize the manager
     * @param cbzFolder path to folder with CBZ
     * @param jpegFolder path to folder with pages (JPEG files)
     */
    public CBZManager(String cbzFolder, String jpegFolder){
        this.cbzFolder = cbzFolder;
        this.jpegFolder = jpegFolder;
        this.files = new ArrayList<String>();
    }

    /**
     * Open a CBZ and extract all the files in the jpeg Folder
     * @param fileName the relative path of the CBZ
     * @throws IOException if something bad happens
     */
    public void OpenAndExtract(String fileName) throws IOException{
        byte[] buffer = new byte[BUFFER_SIZE];
        String totalPath = cbzFolder+File.separator+fileName;
        files.clear();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(totalPath))) {
            
            ZipEntry entry = zis.getNextEntry();
            while(entry!=null){
                if(entry.isDirectory()){
                        throw new IOException("Unabled to deal with directories");                    
                }
                                                
                String name = entry.getName();
                try(FileOutputStream fos = new FileOutputStream(jpegFolder+File.separator+name))
                {
                    int len;
                    while((len=zis.read(buffer))>0){
                        fos.write(buffer,0,len);
                    }
                }
                files.add(name);                                            
                entry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }

    /**
     * Gets all the page names of the CBZ opened (call OpenAndExtract first)
     * @return the list of all pages names
     * @see OpenAndExtract
     */
    public String[] listPagesNames(){
        return files.toArray(new String[0]);
    }
}
