package UserMgmt;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import services.UserService;

import java.util.List;

/**
 * Created by asus on 2017/12/6.
 */

@RestController
@EnableWebMvc
@EnableAutoConfiguration
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/Xlogin/{var}",method = RequestMethod.POST)
    public String login(@PathVariable("var") String var, @RequestBody String postJson) {
        System.out.println(postJson);
        return "Hello My World!"+var;
    }

    @RequestMapping(value = "/Xget",method = RequestMethod.GET)
    public String getlogin(@RequestParam("name")String name,@RequestParam("passwd") String passwd) {
        System.out.println(name + "    " + passwd);
        return "Hello My !"+name;
    }

    @RequestMapping("/userlist")
    public List<User> getUserList() {
        return userService.getUserList();
    }


}

