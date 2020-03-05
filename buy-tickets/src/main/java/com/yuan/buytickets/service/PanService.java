package com.yuan.buytickets.service;

import com.yuan.buytickets.pojo.Pan;

import java.util.List;

/**
 * @author Yuan-9826
 */
public interface PanService {

    /**
     * 根据url查找网盘
     * @return
     */
    List<Pan> fiandPanByUrl();

    /**
     * 根据url爬取页面网盘到数据库
     * @param url
     */
    void sprider(String url);
}
