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
  <h1>������Ϣ�ϴ�</h1>
  <form action="musicfileservlet?action=musicfile" method="post" enctype="multipart/form-data">
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
					<td>��������</td>
					<td>���ܳ���100��(����)</td>
					<td><input type="text" name="music_name"></td>
				</tr>
				<tr>
					<td>����mp3�ļ�</td>
					<td>�ڱ���ѡ���ļ�(����)</td>
					<td align="center"><input type="file" name="music_path_mp3" id="music_path_mp3"></td>
				</tr>
				<tr>
					<td>���ָ���ļ�</td>
					<td>�ڱ���ѡ���ļ�(����)</td>
					<td align="center"><input type="file" name="music_path_lrc" id="music_path_lrc"></td>
				</tr>
				<tr>
					<td>��������һ������</td>
					<td>ʮ������(����)</td>
					<td><input type="text" name="music_type1"></td>
				</tr>
				<tr>
					<td>����������������</td>
					<td>ʮ������(����)</td>
					<td><input type="text" name="music_type2"></td>
				</tr>
				<tr>
					<td>������</td>
					<td>����</td>
					<td>
					��<input type="text" style="width:60px;" name="music_audition_sum_number"/>
					&nbsp;��<input type="text" style="width:60px;" name="music_audition_month_number"/>
					&nbsp;��<input type="text" style="width:60px;" name="music_audition_week_number"/>
					&nbsp;��<input type="text" style="width:60px;" name="music_audition_day_number"/>
					</td>
				</tr>
				<tr>
					<td>������</td>
					<td>����</td>
					<td>
					��<input type="text" style="width:60px;" name="music_download_sum_number"/>
					&nbsp;��<input type="text" style="width:60px;" name="music_download_month_number"/>
					&nbsp;��<input type="text" style="width:60px;" name="music_download_week_number"/>
					&nbsp;��<input type="text" style="width:60px;" name="music_download_day_number"/>
					</td>
					</tr>
				<tr>
					<td>����ͼƬ</td>
					<td>�ڱ���ѡ���ļ�(����)</td>
					<td align="center"><input type="file"name="music_photo" id="music_photo"></td>
				</tr>
				<tr>
					<td>���ֱ���ͼƬ</td>
					<td>(����)</td>
					<td align="center"><input type="file" name="music_bg_photo" id="music_bg_photo"></td>
				</tr>
				<tr>
					<td>������ͼͼƬ</td>
					<td>(����)</td>
					<td align="center"><input type="file" name="music_main_photo" id="music_main_photo"></td>
				</tr>
				<tr>
					<td>���ּ��</td>
					<td>(����)</td>
					<td align="center"><input type="text" name="music_introduct"></td>
				</tr>
				<tr>
					<td>����������</td>
					<td>(����)</td>
					<td align="center"><input type="text" name="music_coins"></td>
				</tr>
				<tr>
					<td>��ע</td>
					<td></td>
					<td><input type="hidden" name="music_upload_time">
					<input type="text" name="music_remarks">
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="ȷ��" class="btn btn-primary">
		<input type="reset" value="����" class="btn btn-danger">
    </form>
  </body>
</html>
