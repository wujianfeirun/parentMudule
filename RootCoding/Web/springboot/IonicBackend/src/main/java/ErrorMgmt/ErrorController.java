package ErrorMgmt;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by asus on 2017/12/6.
 */

@RestController
//@EnableWebMvc
@EnableAutoConfiguration
@CrossOrigin
public class ErrorController {
    @RequestMapping(value = "/Xerror",method = RequestMethod.POST)
    public String error(@PathVariable("var") String var, @RequestBody String postJson) {
        System.out.println(postJson);
        return "Hello My World!"+var;
    }
}
