package com.itswael;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Consumer {
    public void start(){
        crawl();
    }

    private void crawl(){
        Document doc = null;
        String url = this.getCrawlUrl();
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href"));
        }
    }

    private static void log(String msg, String... vals) {
        System.out.printf((msg) + "%n", (Object[]) vals);
    }

    private String getCrawlUrl() {
        return "https://en.wikipedia.org/";
    }
}
