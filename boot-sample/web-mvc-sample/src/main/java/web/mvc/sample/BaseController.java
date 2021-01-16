package web.mvc.sample;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/1
 */
public class BaseController {

    protected HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    protected HttpSession getSession(){
        return getRequest().getSession();
    }

    protected HttpServletResponse getResponse(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected String getRequestHost(){
        HttpServletRequest request=getRequest();
        String host=request.getHeader("x-forwared-for");
        return host==null?request.getRemoteHost():host;
    }

    protected String getRequestAgent(){
        return getRequest().getHeader("User-Agent");
    }

    protected String getRequestUrl(){
        HttpServletRequest request=getRequest();
        return request.getRequestURI().substring(request.getContextPath().length());
    }

    protected Cookie[] getCookies(){
        HttpServletRequest request=getRequest();
        return request.getCookies();
    }

    protected Object getSessionAtrribute(String key) {
        if (key!=null&&!key.trim().isEmpty()) {
            HttpSession session=getSession();
            if (null!=session){
                return session.getAttribute(key);
            }
        }
        return null;
    }

    protected void setSessionAtrribute(String key,Object value){
        if (key!=null&&!key.trim().isEmpty()){
            HttpSession session=getSession();
            if (null!=session){
                session.setAttribute(key,value);
            }

        }
        return ;
    }

    protected void setSessionMaxInactiveInterval(int max){
        HttpSession session=getSession();
        session.setMaxInactiveInterval(max);
    }
    protected String getCookie(String key){
        if (key!=null&&!key.trim().isEmpty()){
            Cookie[] cookies=getCookies();
            for(Cookie cookie:cookies){
                if (key.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    protected void addCookie(HttpServletResponse response, String key, String value, int expiry){
        if ((key!=null&&!key.trim().isEmpty())&&(null==response)){
            Cookie cookie=new Cookie(key,value);
            cookie.setMaxAge(expiry);
            response.addCookie(cookie);
        }
    }
}
