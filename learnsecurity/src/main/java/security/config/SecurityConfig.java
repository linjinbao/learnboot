package security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

/**
 * @author linjinbao66@gmail.com
 * @date 2020/4/15
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index").hasRole("ADMIN")
                .antMatchers("/","/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/home")
                .usernameParameter("username")
                .passwordParameter("passwd")
                .failureHandler((req, res, ex)->{
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter printWriter = res.getWriter();
                    printWriter.write("登录失败");
                    printWriter.flush();
                })
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler((req, res, ex)->{
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter printWriter = res.getWriter();
                    printWriter.write("注销成功");
                    printWriter.flush();
                })
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/getUserInfo");
        web.ignoring().antMatchers("/css/**", "/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIIN")
                .and()
                .withUser("test").password(passwordEncoder().encode("123456")).roles("USER");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
