package com.itswael;

public class HtmlTools {
    public static String fixUrl(String inUrl, Domain domain){
        String url = "";

        // remove trailing "/"
        if(inUrl.endsWith("/")){
            inUrl = inUrl.substring(inUrl.length()-1);
        }
        // add http and "/" if missing
        if(!inUrl.startsWith(domain.getDomainUrl())){
            if(!inUrl.startsWith("http")){
                if(inUrl.startsWith("/")){
                    url = domain.getDomainUrl().concat(inUrl);
                }else{
                    url = domain.getDomainUrl().concat("/" + inUrl);
                }
            }
        }else{
            url = inUrl;
        }

        // remove bookmarks #
        if(url.contains("#")){
            url = url.split("#")[0];
        }

        return url;
    }
}
