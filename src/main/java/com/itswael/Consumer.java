package com.itswael;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

public class Consumer {
    public void start(){
        crawl();
    }

    private void crawl(){
        String url = "https://www.jsoup.org";
        String wikiUrl = "https://en.wikipedia.org/";
        Domain domain = new Domain(Hasher.toSha256(wikiUrl),wikiUrl);
        DomainUrl domainUrl = new DomainUrl(domain.getDomainHash(), domain.getDomainUrl(), domain);
        Document doc;
        HashSet<String> hrefs = new HashSet<>();
        try {
            doc = Jsoup.connect(domainUrl.getGetDomainUrl()).get();
            HtmlPage htmlPage = new HtmlPage(doc.html(), domainUrl, new Date());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements newsHeadlines = doc.select("#mp-itn b a");
        newsHeadlines.forEach(x ->{
            String href = x.absUrl("href");
            href = HtmlTools.fixUrl(href, domain);
            hrefs.add(href);
//            log("%s\n\t%s", x.attr("title"), href);
        });

        hrefs.forEach(System.out::println);
    }
}
