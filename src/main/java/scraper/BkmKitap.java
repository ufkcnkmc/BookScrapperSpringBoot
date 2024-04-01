package scraper;

import entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class BkmKitap {


    Document doc = null;

    public List<Book> bkmData() {
        List<Book> books = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("https://www.bkmkitap.com/").get();
            Elements elements = doc.select(".swiper-slide.productItem");
            for (Element element : elements) {
                String title = element.select(".text-description").text();
                String price = element.select(".currentPrice").text();
                String author = element.select("#productModelText").text();
                String publisher = element.select(".text-title").last().text();

                System.out.println("Kitap ismi : " + title);
                System.out.println("Fiyat : " + price);
                System.out.println("Yazar : " + author);
                System.out.println("Yayın evi : " + publisher);
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}
