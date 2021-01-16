package boot.sample.service;

import boot.sample.mapper.LifeQuoteMapper;
import boot.sample.pojo.LifeQuote;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/23
 */
@Service
@CacheConfig
public class LifeQuoteServiceCached {

    @Resource
    LifeQuoteMapper lifeQuoteMapper;

    @CachePut
    public void insert(LifeQuote lifeQuote){
        lifeQuoteMapper.insert(lifeQuote);
    }

    public void update(LifeQuote lifeQuote){
        lifeQuoteMapper.updateById(lifeQuote);
    }

    public void delete(Integer id){
        lifeQuoteMapper.deleteById(id);
    }

    public void select(Integer id){
        lifeQuoteMapper.selectById(id);
    }
}
