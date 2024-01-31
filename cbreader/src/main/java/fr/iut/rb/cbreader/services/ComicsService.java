package fr.iut.rb.cbreader.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.lang.NonNull;

import fr.iut.rb.cbreader.models.ComicBook;
import fr.iut.rb.cbreader.models.ComicBookData;
import fr.iut.rb.cbreader.models.ComicsBookInfo;
import fr.iut.rb.cbreader.models.PageData;
import fr.iut.rb.cbreader.models.ReadingData;
import fr.iut.rb.cbreader.repositories.CBZManager;
import fr.iut.rb.cbreader.repositories.FileManager;
import fr.iut.rb.cbreader.repositories.IComicsRepository;
import fr.iut.rb.cbreader.repositories.IPagesRepository;
import fr.iut.rb.cbreader.repositories.IReadingRepository;

@Service
public class ComicsService {
    private IComicsRepository repository;
    private IReadingRepository readingRepository;
    private IPagesRepository pagesRepository;
    private FileManager fileUploader;
    private CBZManager cbzManager;

    /**
     * @param repository
     * @param filePath
     */
    public ComicsService(IComicsRepository repository,IReadingRepository readingRepository,IPagesRepository pagesRepository, @Value("${filePath}") String filePath) {
        this.repository = repository;
        this.pagesRepository = pagesRepository;
        this.readingRepository = readingRepository;
        this.fileUploader = new FileManager(filePath);
        this.cbzManager = new CBZManager(filePath, filePath);
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

    public ReadingData OpenCB(ObjectId id) throws IOException {
        ComicBookData book = repository.findById(id).orElse(null);
        if (book == null){
            throw new IOException("book is null");
        }
        cbzManager.OpenAndExtract(book.getFileName());
        String[] listPages = cbzManager.listPagesNames();
        ReadingData reading = new ReadingData(listPages.length, book.getId());
        readingRepository.insert(reading);
        for (String elmt : listPages) {
            PageData page = new PageData( reading.getCurrentPage(),elmt, reading.getId());
            pagesRepository.insert(page);
        }
        return reading;
    }
}
