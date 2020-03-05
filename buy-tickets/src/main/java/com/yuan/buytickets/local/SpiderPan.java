package com.yuan.buytickets.local;

import com.yuan.buytickets.mapper.PanMapper;
import com.yuan.buytickets.pojo.Pan;
import com.yuan.buytickets.util.SplitUtils;
import com.yuan.buytickets.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 网页爬虫程序-网盘
 *
 * @author Yuan-9826
 */
public class SpiderPan {

    @Autowired
    private static PanMapper panMapper;

    public static void main(String[] args) {
        String url = "https://www.bilibili.com/read/cv4852097/?spm_id_from=333.788.b_636f6d6d656e74.61";
        String fileName = "wubo.html";
        panDownload(url,fileName);
    }
    public static void panDownload(String url,String fileName) {
        try {
            //下载好页面
            String filePath = Utils.downloadPage(url, fileName);
            //得到页面中的正文，得到正文中的网盘
            String[] targets = Utils.extractArticle(filePath);
            //去除空格并以关键字分割
            ArrayList arrayList = SplitUtils.splidPan(targets);
            //添加到数据库中
            Iterator iterator = arrayList.iterator();

            while(iterator.hasNext()){
                Pan next = (Pan)iterator.next();
                panMapper.insert(next);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
