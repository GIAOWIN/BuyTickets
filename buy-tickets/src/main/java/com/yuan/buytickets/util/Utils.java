package com.yuan.buytickets.util;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * @author Yuan-9826
 */
public class Utils {

    public static void main(String[] args) {
        String url = "https://www.bilibili.com/read/cv4852097/?spm_id_from=333.788.b_636f6d6d656e74.61";
        String fileName = "wubo.html";
        try {
            //xiazaiyemian
            //   String s = downloadPage(url, fileName);

            //提取页面内容
            extractArticle(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * article-holder 内容
     * title-container 文章标题
     * "https://www.bilibili.com/read/cv4852097/?spm_id_from=333.788.b_636f6d6d656e74.61"
     *
     * @param url
     * @throws IOException
     */
    public static String downloadPage(String url, String fileName) throws IOException {
        //1.打开浏览器 创建Http对象
        CloseableHttpClient client = HttpClients.createDefault();
        //2.输入网址
        HttpGet httpGet = new HttpGet(url);
        //3.按回车 发起请求 返回响应
        CloseableHttpResponse response = client.execute(httpGet);
        //4.解析响应获取数据
        if (response.getStatusLine().getStatusCode() == 200) {
            //文件地址
            if (fileName.lastIndexOf(".html") == -1) {

                fileName = fileName + ".html";
            }

            String entity = EntityUtils.toString(response.getEntity(), "utf-8");
            //下载页面，获取页面名字

            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(entity);
            fileWriter.flush();
            fileWriter.close();


            //5.关闭response
            response.close();
            client.close();
        }
        return fileName;

    }

    /**
     * bilibili截取文章正文
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String[] extractArticle(String fileName) throws IOException {
        boolean flag = false;
        //读取文件，获取字符串
        String file = FileUtils.readFileToString(new File(fileName), "utf-8");
        //解析字符串
        Document document = Jsoup.parse(file);
        //从元素中获取classNames
        Elements classes = document.getElementsByClass("article-holder");

        String[] target = SplitUtils.splitLabel(classes.toString(), "<p>", "</p>");
        return target;
    }


}
