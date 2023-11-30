package bookApi.demo.repository;

import bookApi.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCase(String name);
    List<Book> findByCategoryName(String categoryName);
}
