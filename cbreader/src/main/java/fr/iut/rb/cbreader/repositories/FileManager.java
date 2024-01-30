package fr.iut.rb.cbreader.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
    private String booksLocation;

    /**
     * @param booksLocation
     */
    public FileManager(String booksLocation) {
        this.booksLocation = booksLocation;
    }

    /**
     * store a file send by form
     * 
     * @param file     the file to store
     * @param fileName the name of the file (simple filename, no path)
     * @throws IOException if the file can not be written
     */
    public void uploadFile(MultipartFile file, String fileName) throws IOException {
        if (fileName == "" || fileName == null) {
            fileName = file.getOriginalFilename();
        }
        Path destinationPath = Paths.get(booksLocation, fileName);
        destinationPath = destinationPath.normalize().toAbsolutePath();
        try (InputStream stream = file.getInputStream()) {
            Files.copy(stream, destinationPath,
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
