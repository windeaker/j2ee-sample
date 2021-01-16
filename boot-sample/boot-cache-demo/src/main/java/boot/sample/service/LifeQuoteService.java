package boot.sample.service;

import boot.sample.mapper.LifeQuoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/23
 */
@Service
public class LifeQuoteService {

    private LifeQuoteMapper lifeQuoteMapper;

    @Resource
    public void setLifeQuoteMapper(LifeQuoteMapper lifeQuoteMapper){
        this.lifeQuoteMapper=lifeQuoteMapper;
    }

    public Object selectAllLifeQuoteService(){
        return lifeQuoteMapper.selectList(null );
    }



}
