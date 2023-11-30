package bookApi.demo.controller;

import bookApi.demo.model.Book;
import bookApi.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{sku}")
    public ResponseEntity<Book> getBookBySku(@PathVariable Long sku) {
        Optional<Book> bookOptional = bookService.getBookBySku(sku);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

@DeleteMapping("/{sku}")
    public ResponseEntity<String> deleteBook(@PathVariable Long sku){
        bookService.deleteBook(sku);
        return new ResponseEntity<>("Book was deleted", HttpStatus.OK);
}


}


