package fr.iut.rb.cbreader.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fr.iut.rb.cbreader.models.ComicBook;
import fr.iut.rb.cbreader.models.ComicBookData;
import fr.iut.rb.cbreader.models.ComicsBookInfo;
import fr.iut.rb.cbreader.repositories.FileManager;
import fr.iut.rb.cbreader.repositories.IComicsRepository;

@Service
public class ComicsService {
    public IComicsRepository repository;
    public FileManager fileUploader;

    /**
     * @param repository
     * @param filePath
     */
    public ComicsService(IComicsRepository repository, @Value("${filePath}") String filePath) {
        this.repository = repository;
        this.fileUploader = new FileManager(filePath);
    }

    /**
     * @param book
     * @param file
     * @throws IOException
     */
    public void AddComicBook(ComicBook book, MultipartFile file) throws IOException {
        fileUploader.uploadFile(file, book.getFileName());
        ComicBookData comicBookData = new ComicBookData(book);
        repository.insert(comicBookData);
    }

    // Exemple si findAll() renvoie une List
    public ComicsBookInfo[] GetAllCB() {
        ArrayList<ComicsBookInfo> comicsBookInfoList = new ArrayList<ComicsBookInfo>();
        List<ComicBookData> list = repository.findAll();
        for (ComicBookData comicBookData : list) {
            comicsBookInfoList.add(new ComicsBookInfo(comicBookData, fileUploader.GetFileSize(comicBookData.getFileName())));
        }
        ComicsBookInfo[] result = new ComicsBookInfo[comicsBookInfoList.size()];
        result = comicsBookInfoList.toArray(result);
        return result;
    }

}
