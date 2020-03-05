package com.yuan.buytickets.controller.bilibili;

import com.yuan.buytickets.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yuan-9826
 */
@RestController("blbl")
public class PanController {

@Autowired
private PanService panService;

    @PostMapping("load")
    public ResponseEntity<String> panDownload(String url) {
        //爬取网盘到数据库
        panService.sprider(url);
        System.out.println("url = " + url);

        return ResponseEntity.ok(url);
    }

}
