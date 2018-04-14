package Sample;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by asus on 2017/12/6.
 */

@RestController
@EnableWebMvc
@EnableAutoConfiguration
@CrossOrigin
public class PostController {

    @RequestMapping(value = "/multipart/post",method = RequestMethod.POST)
    public String multipart_Form_data_post(@RequestParam("name") String name,@RequestParam("id") String id, @RequestParam("file") List<MultipartFile> files ,@RequestParam("file1") List<MultipartFile> files1 ) throws Exception {
        //BookMark get Text from request
        System.out.println("name:"+name);
        System.out.println("id:"+id);
        //BookMark get File from request
        files.addAll(files1);
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            System.out.println("file name:"+file.getOriginalFilename());
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "success multipart-form-data";

    }
    @RequestMapping(value = "/multipart/post1",method = RequestMethod.POST)
    public String multipart_Form_data_post1(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        //BookMark get Text from request
        String name=params.getParameter("name");
        System.out.println("name:"+name);
        String id=params.getParameter("id");
        System.out.println("id:"+id);
        //BookMark get File from request
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        List<MultipartFile> files1 = ((MultipartHttpServletRequest) request).getFiles("file1");
        files.addAll(files1);
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            System.out.println("file name:"+file.getOriginalFilename());
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "success multipart-form-data";

    }

    @RequestMapping(value = "/x-www-form-urlencoded/post",method = RequestMethod.POST)
    public String x_www_form_urlencoded_post(@RequestParam("name") String name,@RequestParam("password")String password,@RequestParam("aaa" )String aaa) {
        System.out.println(name);
        System.out.println(aaa);
        System.out.println(password);
        return "success x-www-form";
    }

    @RequestMapping(value = "/raw/post",method = RequestMethod.POST)
    public String raw_post(@RequestBody String postText) {
        //Content-Type:text/plain               --> text
        //Content-Type:application/json         --> json
        //Content-Type:application/javascript   --> js
        //Content-Type:application/xml          --> xml
        //Content-Type:text/html                --> html
        //BookMark  whatever you send
        System.out.println(postText);
        return "success raw!";
    }

    @RequestMapping(value = "/binary/post",method = RequestMethod.POST)
    public String binary_post(@RequestBody byte[] bytes) throws UnsupportedEncodingException {
        //TODO 1 中文乱码
        System.out.println(new String(bytes,"utf-8"));
        return "success binary!";
    }

}

