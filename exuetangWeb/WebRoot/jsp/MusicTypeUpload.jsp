<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�����ϴ�ҳ��</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
</head>
  
  <body style="text-align: center">
  <h1>���ֶ���ͼƬ�ϴ�</h1>
  <form action="musicfileservlet?action=typephoto" method="post" enctype="multipart/form-data">
    <table class="table table-striped" border="0"
			style="text-align: center;" >
  <thead>
				<tr>
					<th style="text-align: center">������</th>
					<th style="text-align: center">���˵��</th>
					<th style="text-align: center">�����Ϣ</th>
				</tr>
			</thead>
			<tbody style="text-align: center">
				<tr>
					<td>������������</td>
					<td>(����)</td>
					<td><input type="text" name="music_type2"></td>
				</tr>
				<tr>
					<td>ͼƬ�ļ�</td>
					<td>�ڱ���ѡ���ļ�(720dp*350dp)(����)</td>
					<td align="center"><input type="file" name="music_type2_path" id="music_type2_path"></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="ȷ��" class="btn btn-primary">
		<input type="reset" value="����" class="btn btn-danger">
    </form>
  </body>
</html>
