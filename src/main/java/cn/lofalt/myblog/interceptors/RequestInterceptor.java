package cn.lofalt.myblog.interceptors;

import cn.lofalt.myblog.utils.HttpRequestHelper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpRequestHelper.setReq(request);
        return true;
    }
}
