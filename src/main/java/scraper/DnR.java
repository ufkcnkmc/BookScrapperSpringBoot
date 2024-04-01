package scraper;

import entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class DnR {
    Document doc = null;

    public List<Book> dnrData() {
        List<Book> books = new ArrayList<>();
        try {
            doc = Jsoup.connect("https://www.dr.com.tr/kategori/kitap").get();
            Elements elements = doc.select(".prd.js-prd-item");
            for (Element element : elements) {
                String title = element.select(".seo-heading a").text();
                String author = element.select(".who").text();
                String publisher = element.select(".prd-publisher").text();
                String price = element.select(".prd-price").text();

                System.out.println("Kitap : " + title);
                System.out.println("Yazar : " + author);
                System.out.println("Yayın Evi : " + publisher);
                System.out.println("Fiyat : " + price);
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
