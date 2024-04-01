package scraper;

import entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class KitapYurdu {

    Document doc = null;
    public List<Book> kitapYurduData() {
        List<Book> books = new ArrayList<>();
        try {
            doc = Jsoup.connect("https://www.kitapyurdu.com/kategori/kitap/1.html").get();
            Elements elements = doc.select(".mg-b-10");
            for (Element element : elements) {
                String title = element.select(".name a").text();
                String author = element.select(".author a").text();
                String publisher = element.select(".prd-publisher").text();
                String price = element.select(".price-new ").text();

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
