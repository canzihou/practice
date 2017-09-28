package spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Get_Url("http://nanrenfuli.com/16500.html");
    }

    public static void Get_Url(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            //得到html的所有东西
            System.out.println(doc);
            Elements a = doc.getElementsByTag("a");

            //分离出html下<a>...</a>之间的所有东西
//            Elements links = content.getElementsByTag("a");
//            //Elements links = doc.select("a[href]");
//            // 扩展名为.png的图片
////            Elements pngs = doc.select("img[src$=.png]");
//            // class等于masthead的div标签
////            Element masthead = doc.select("div.masthead").first();
//
//            for (Element link : a) {
//                //得到<a>...</a>里面的网址
//                String linkHref = link.attr("href");
//                //得到<a>...</a>里面的汉字
//                String linkText = link.text();
//                System.out.println(linkText);
//                System.out.println(linkHref);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
