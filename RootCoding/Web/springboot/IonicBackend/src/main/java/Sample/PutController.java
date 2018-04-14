package Sample;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.UnsupportedEncodingException;

/**
 * Created by asus on 2017/12/6.
 */

@RestController
@EnableWebMvc
@EnableAutoConfiguration
@CrossOrigin
public class PutController {

    /*
    * 1 使用PUT 方法，只有在url后面的参数key用@RequestParam来接收， 其他的都用@RequestBody接收
    * 2 multipart_Form_data的方式，文件会读取内容， 格式如下
    *           ----------------------------567115806951446299325377
             Content-Disposition: form-data; name="id"

             wwww
                ----------------------------567115806951446299325377
              Content-Disposition: form-data; name=""; filename="account.txt"
              Content-Type: text/plain
              csdn�˻�:wujianfeirun
                ----------------------------567115806951446299325377
    *  3 x-www-的方式key/value的中文会进行encode，
    *     password=123456中文 --->
    *     password=123456%E4%B8%AD%E6%96%87
    *  4. raw的方式用@RequestBody 可以完美接收。
    *
    * */


    @PutMapping(value = "/multipart/put")
    public String multipart_Form_data_put(@RequestParam("name") String name,@RequestBody String body ) throws Exception {

        System.out.println("name:"+name);
        //BookMark
/*
        file and key/value will parse to
                ----------------------------567115806951446299325377
        Content-Disposition: form-data; name=""; filename="account.txt"
        Content-Type: text/plain

        csdn�˻�:wujianfeirun
                ----------------------------567115806951446299325377--
*/
        System.out.println(body);
        return "success multipart-form-data-put";

    }
    @PutMapping(value = "/x-www-form-urlencoded/put")
    public String x_www_form_urlencoded_put(@RequestParam("aaa" )String aaa,@RequestParam("bbb" )String bbb,@RequestBody String body) {
        System.out.println(aaa);
        System.out.println(bbb);
        System.out.println(body);
        return "success x-www-form";
    }

    @PutMapping(value = "/raw/put")
    public String raw_put(@RequestBody String postText) {
        //Content-Type:text/plain               --> text
        //Content-Type:application/json         --> json
        //Content-Type:application/javascript   --> js
        //Content-Type:application/xml          --> xml
        //Content-Type:text/html                --> html
        //BookMark  whatever you send
        System.out.println(postText);
        return "success raw!";
    }

    @PutMapping(value = "/binary/put")
    public String binary_put(@RequestBody byte[] bytes) throws UnsupportedEncodingException {
        //TODO 1 中文乱码
        System.out.println(new String(bytes,"utf-8"));
        return "success binary!";
    }

}

