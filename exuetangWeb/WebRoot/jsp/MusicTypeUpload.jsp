<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>音乐上传页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
</head>
  
  <body style="text-align: center">
  <h1>音乐二级图片上传</h1>
  <form action="musicfileservlet?action=typephoto" method="post" enctype="multipart/form-data">
    <table class="table table-striped" border="0"
			style="text-align: center;" >
  <thead>
				<tr>
					<th style="text-align: center">属性名</th>
					<th style="text-align: center">添加说明</th>
					<th style="text-align: center">添加信息</th>
				</tr>
			</thead>
			<tbody style="text-align: center">
				<tr>
					<td>二级类型名称</td>
					<td>(必填)</td>
					<td><input type="text" name="music_type2"></td>
				</tr>
				<tr>
					<td>图片文件</td>
					<td>在本地选择文件(720dp*350dp)(必填)</td>
					<td align="center"><input type="file" name="music_type2_path" id="music_type2_path"></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="确定" class="btn btn-primary">
		<input type="reset" value="重置" class="btn btn-danger">
    </form>
  </body>
</html>
