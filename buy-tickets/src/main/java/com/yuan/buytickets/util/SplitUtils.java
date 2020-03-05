package com.yuan.buytickets.util;

import com.yuan.buytickets.pojo.Pan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitUtils {
    /**
     * 根据标签添加到数组中
     *
     * @param article
     * @param left
     * @param right
     * @return
     */
    public static String[] splitLabel(String article, String left, String right) {
        String[] temp = article.split(left);
        String[] strings = new String[temp.length - 1];
        for (int i = 1; i < temp.length - 1; i++) {

            strings[i - 1] = temp[i].substring(0, temp[i].indexOf(right) - 1);
        }
        return strings;
    }

    /**
     * 传入数组 写入到文件中
     *
     * @param target
     * @throws IOException
     */
    public static void writeToLocal(String[] target, String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName, true);
        for (String str : target) {
            out.write((str + "\r\n").getBytes());
        }
    }

    /**
     * 去除空格并以关键字分割 -网盘
     *
     * @param targets
     * @throws IOException
     */
    public static ArrayList splidPan(String[] targets) throws IOException {
        ArrayList<Pan> pans = new ArrayList<>();
        for (String target : targets) {
            //去除空格
            if (null != target) {
                System.out.println("target = " + target);
                String replace = target.replace(" ", "");
                String[] split = replace.split("链接:");
                String describe = split[0];

                for (int i = 1; i < split.length; i++) {
                    if (0 != split[i].length()) {
                        String[] urlPassword = split[i].split("提取码:");

                        String url = urlPassword[0];
                        String password = urlPassword[1];
                        Pan pan = new Pan();
                        pan.setDescribe(describe);
                        pan.setUrl(url);
                        pan.setPassword(password);
                        pans.add(pan);
                    }
                }

            }
        }
        return pans;
    }


}

