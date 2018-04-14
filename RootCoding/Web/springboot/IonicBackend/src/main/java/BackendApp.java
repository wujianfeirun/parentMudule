import ErrorMgmt.ErrorController;
import Sample.GetController;
import Sample.PostController;
import Sample.PutController;
import UserMgmt.LoginController;
import config.ViewConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by asus on 2017/12/6.
 */
@SpringBootApplication
@EnableWebMvc
public class BackendApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(new Object[] {LoginController.class, PostController.class, GetController.class, PutController.class, ErrorController.class}, args);
    }
}
