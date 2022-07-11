package cn.lofalt.myblog.utils;

public class Utils {

    public static final String TOKENS = "tokens";
    public static final String TOKEN_MAP = "tokenMap";

    public static String deleteHtml(String content){
        return content.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "").replaceAll("\\s","");
    }
}
