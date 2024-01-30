package fr.iut.rb.cbreader.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.iut.rb.cbreader.models.ComicBook;
import fr.iut.rb.cbreader.services.ComicsService;

@RestController
public class ComicsController {

    private ComicsService service;

    /**
     * @param service
     */
    public ComicsController(ComicsService service) {
        this.service = service;
    }

    @PostMapping("book/add")
    @CrossOrigin
    public ResponseEntity<ComicBook> AddNewBook(@RequestParam(value = "book") String str,
            @RequestParam(value = "file") MultipartFile file) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ComicBook book = mapper.readValue(str, ComicBook.class);
        return ResponseEntity.ok(book);
    }
}