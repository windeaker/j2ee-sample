package boot.shiro.sample;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/2
 */
public class SimpleHelloWorld {

    @Test
    public void testHelloWorld(){
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("zhang","123");
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            e.printStackTrace();
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }
}
