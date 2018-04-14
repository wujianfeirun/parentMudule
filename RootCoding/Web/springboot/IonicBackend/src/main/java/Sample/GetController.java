package Sample;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by asus on 2017/12/6.
 */

@RestController
@EnableWebMvc
@EnableAutoConfiguration
@CrossOrigin
public class GetController {

    //@RequestMapping(value = "/url/get",method = RequestMethod.GET)
    @GetMapping(value = "/url/get")
    public String url_get(@RequestParam("name") String name,@RequestParam("password")String password) {
        System.out.println(name);
        System.out.println(password);
        return "success x-www-form-get";
    }

}

