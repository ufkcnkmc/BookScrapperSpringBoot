package dao;

import entity.Book;

import java.util.List;

public interface BookDAO {
    void save(Book book);
    List<Book> getAllBooks();
}
