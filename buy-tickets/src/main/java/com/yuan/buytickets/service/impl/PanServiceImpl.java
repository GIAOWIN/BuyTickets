package com.yuan.buytickets.service.impl;

import com.yuan.buytickets.mapper.PanMapper;
import com.yuan.buytickets.pojo.Pan;
import com.yuan.buytickets.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Yuan-9826
 */
@Service
public class PanServiceImpl implements PanService {

    @Autowired
    private PanMapper panMapper;

    /**
     * 自定义条件搜索
     *
     * @param pan
     * @return
     */
    public List<Pan> findList(Pan pan) {
        //搜索器对象
        Example example = new Example(Pan.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        //条件1：根据作用模糊查询
        if (null != pan) {
            if (null != pan.getDescribe()) {
                criteria.andLike("describe", "%" + pan.getDescribe() + "%");
            }
        }
        return panMapper.selectByExample(example);
    }


    @Override
    public List<Pan> fiandPanByUrl() {
        return null;
    }

    @Override
    public void sprider(String url) {

    }
}
