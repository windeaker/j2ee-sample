package web.mvc.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/22
 */
@Controller
public class SimpleHandlerController {

    @RequestMapping("/redirectToUrl")
    public ModelAndView redirectToUrl(){
        return new ModelAndView("redirect:/url");
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public String handleFileUpload(
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
        for (CommonsMultipartFile aFile : fileUpload){
            // 存储上传的文件
            aFile.transferTo(new File(aFile.getOriginalFilename()));
        }
        return "Success";
    }
}
