package aop.sample.other.introduction_advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class LoveAdvice extends DelegatingIntroductionInterceptor implements Love {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    public void display(String msg) {
        System.out.println("dear "+msg);
    }
}
