package security3;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("javaboy.org")
                .password("123")
                .roles("admin");

        //多个用户配置
//        auth.inMemoryAuthentication()
//                .withUser("javaboy.org")
//                .password("123")
//                .roles("admin")
//                .and().
//                withUser("windeaker").
//                password("qaz").
//                roles("admin");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                //form action /doLogin
//                .loginProcessingUrl("/doLogin")
                //设置input.name userName
                .usernameParameter("userName")
                //setup input.name password
                .passwordParameter("password")
                .defaultSuccessUrl("/index")
                //登录成功后一定要跳转到/index

//                .defaultSuccessUrl("/index",true)
                .successForwardUrl("/hello")
                //登录失败转发
                .failureForwardUrl("/index")
                //登录失败重定向和转发选择一个就可以了
//                .failureUrl("/index")
                .permitAll()
                .and()
                .logout()
//                注销路径
                .logoutUrl("/logout")
//                设置注销登录的请求匹配器,可以修改请求方式，和logouturl选择一个就可以了
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
//                注销成功跳转的页面
                .logoutSuccessUrl("/index")
                //清除cookie 这个要手动设置
                .deleteCookies()
                //清除认证信息 默认会清除
                .clearAuthentication(true)
//                清除session 默认会清除
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }
}
