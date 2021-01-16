package jsoup.sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/24
 */
public class SampleA {
    @Test
    public void testA(){
        try {
            Document doc= Jsoup.connect("https://wuhan.newhouse.fang.com").get();
//            Elements links = doc.select("a[href]");
//            for (Element link : links) {
//                System.out.println("\nlink : " + link.attr("href"));
//                System.out.println("text : " + link.text());
//            }
            Elements pageElem = doc.getElementsByClass("page");
            Elements pages=pageElem.select("a[href]");
            String nextPageUrl=null;
            for (Element page : pages) {
                if ("下一页".equals(page.text())) {
                    nextPageUrl=page.attr("href");
                }
            }
            Document nextDoc= Jsoup.connect("https://wuhan.newhouse.fang.com"+nextPageUrl).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
