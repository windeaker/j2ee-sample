package boot.sample.controller;

import boot.sample.service.LifeQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/23
 */
@RestController
public class LifeQuoteController {

    @Autowired
    LifeQuoteService lifeQuoteService;

    @GetMapping("selectAllLifeQuote")
    public Object selectAllLifeQuote(){
       return  lifeQuoteService.selectAllLifeQuoteService();
    }
}
