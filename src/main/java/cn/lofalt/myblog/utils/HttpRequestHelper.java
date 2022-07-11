package cn.lofalt.myblog.utils;


import javax.servlet.http.HttpServletRequest;

public class HttpRequestHelper {
    public static ThreadLocal<HttpServletRequest> req = new ThreadLocal<>();

    public static HttpServletRequest getReq(){
        return req.get();
    }

    public static void setReq(HttpServletRequest request){
        req.set(request);
    }

}
