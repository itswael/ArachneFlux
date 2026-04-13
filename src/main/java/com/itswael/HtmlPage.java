package com.itswael;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class HtmlPage {
    private int id;
    private byte[] compressedHtml;
    private DomainUrl domainUrl;
    private Date created;

    public HtmlPage(String html, DomainUrl domainUrl, Date created) throws UnsupportedEncodingException {
        this.compressedHtml = new CompressionUtils().Compress(html);
        this.domainUrl = domainUrl;
        this.created = created;
    }

    public void save(){

    }

    public int getId() {
        return id;
    }

    public byte[] getCompressedHtml() {
        return compressedHtml;
    }

    public DomainUrl getDomainUrl() {
        return domainUrl;
    }

    public Date getCreated() {
        return created;
    }
}
