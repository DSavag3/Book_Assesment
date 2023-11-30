package bookApi.demo.service;

import bookApi.demo.model.Book;
import bookApi.demo.repository.BookRepository;
import bookApi.demo.repository.CategoryRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class BookService {

 @Autowired
 private BookRepository bookRepository;

 public List <Book> getAllBooks(){
   return bookRepository.findAll();
 }
public Optional <Book> getBookBySku(Long sku){
     return bookRepository.findById(sku);
}
public Book createBook (Book book){
     return bookRepository.save(book);
}
public Book updateBook(Long sku, Book updatedBook){
     getBookBySku(sku);
     updatedBook.setSku(sku);
     return bookRepository.save(updatedBook);
}
public void deleteBook(Long sku){
     getBookBySku(sku);
     bookRepository.deleteById(sku);
}
public List<Book> searchBooksByName(String name){
     return bookRepository.findByNameContainingIgnoreCase(name);
}
public List<Book> getBooksByCategoryName (String categoryName){
     return bookRepository.findByCategoryName(categoryName);
}
}
