package service;

import dao.BookDAO;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import scraper.BkmKitap;
import scraper.DnR;
import scraper.KitapYurdu;

import java.util.List;

@Service
public class BookService {
    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
    public void scrapeAndSaveBooks() {
        KitapYurdu kitapYurdu = new KitapYurdu();
        BkmKitap bkmKitap = new BkmKitap();
        DnR dnR = new DnR();

        List<Book> booksFromKitapYurdu = kitapYurdu.kitapYurduData();
        List<Book> booksFromBkmKitap = bkmKitap.bkmData();
        List<Book> booksFromDnR = dnR.dnrData();

        try {
            for (Book book : booksFromKitapYurdu) {
                bookDAO.save(book);
            }
            for (Book book : booksFromBkmKitap) {
                bookDAO.save(book);
            }
            for (Book book : booksFromDnR) {
                bookDAO.save(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}


    /*public void scrapeAndSaveBooks() {
        KitapYurdu kitapYurdu = new KitapYurdu();
        BkmKitap bkmKitap = new BkmKitap();
        DnR dnR = new DnR();

        List<Book> booksFromKitapYurdu = kitapYurdu.kitapYurduData();
        List<Book> booksFromBkmKitap = bkmKitap.bkmData();
        List<Book> booksFromDnR = dnR.dnrData();

        for (Book book : booksFromKitapYurdu) {
            bookDAO.save(book);
        }
        for (Book book : booksFromBkmKitap) {
            bookDAO.save(book);
        }
        for (Book book : booksFromDnR) {
            bookDAO.save(book);
        }
    }*/
