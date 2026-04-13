package com.itswael;

public class HtmlTools {
    public static String fixUrl(String inUrl, Domain domain){
        String url = "";
        if(!inUrl.startsWith(domain.getDomainUrl())){
            if(!inUrl.startsWith("http")){
                url = domain.getDomainUrl().concat(inUrl);
            }
        }else{
            url = inUrl;
        }

        return url;
    }
}
