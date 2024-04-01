package scraper;

public class BookScrapper {
    public static void main(String[] args) {
        DnR dnr = new DnR();
        BkmKitap bkmKitap = new BkmKitap();
        KitapYurdu kitapYurdu = new KitapYurdu();

        dnr.dnrData();
        bkmKitap.bkmData();
        kitapYurdu.kitapYurduData();
    }

}
