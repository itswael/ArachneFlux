package com.itswael;

public class DomainUrl {
    private String domainUrlHash;
    private String getDomainUrl;
    private Domain domain;

    public DomainUrl(String domainUrlHash, String getDomainUrl, Domain domain) {
        this.domainUrlHash = domainUrlHash;
        this.getDomainUrl = getDomainUrl;
        this.domain = domain;
    }

    public String getDomainUrlHash() {
        return domainUrlHash;
    }

    public String getGetDomainUrl() {
        return getDomainUrl;
    }

    public Domain getDomain() {
        return domain;
    }
}
