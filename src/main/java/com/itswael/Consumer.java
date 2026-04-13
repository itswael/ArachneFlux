package com.itswael;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Consumer {
    public void start(){

        crawl();
    }

    private void crawl(){
        Domain domain = new Domain("","https://en.wikipedia.org/");
        Document doc = null;
        String url = this.getCrawlUrl();
        HashSet<String> hrefs = new HashSet<String>();
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");

        newsHeadlines.forEach(x ->{
            String href = x.absUrl("href");
            href = HtmlTools.fixUrl(href, domain);
            hrefs.add(href);
            log("%s\n\t%s", x.attr("title"), href);
        });
    }

    private static void log(String msg, String... vals) {
        System.out.printf((msg) + "%n", (Object[]) vals);
    }

    private String getCrawlUrl() {
        return "https://en.wikipedia.org/";
    }
}
