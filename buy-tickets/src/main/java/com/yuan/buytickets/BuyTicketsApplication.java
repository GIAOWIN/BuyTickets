package com.yuan.buytickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Yuan-9826
 */
@SpringBootApplication
@MapperScan(value = {"com.yuan.buytickets.mapper"})
public class BuyTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyTicketsApplication.class, args);
    }

}
