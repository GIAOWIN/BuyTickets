<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>index</title>
</head>
<body>
请输入你的地址：
<form action="/blbl/load" method="post">
    <input type="text" name="url"/>
    <input type="button" value="爬取"/>
</form>
</body>
</html>
