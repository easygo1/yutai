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
  <h1>音乐信息上传</h1>
  <form action="musicfileservlet?action=musicfile" method="post" enctype="multipart/form-data">
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
					<td>音乐名称</td>
					<td>不能超过100字(必填)</td>
					<td><input type="text" name="music_name"></td>
				</tr>
				<tr>
					<td>音乐mp3文件</td>
					<td>在本地选择文件(必填)</td>
					<td align="center"><input type="file" name="music_path_mp3" id="music_path_mp3"></td>
				</tr>
				<tr>
					<td>音乐歌词文件</td>
					<td>在本地选择文件(必填)</td>
					<td align="center"><input type="file" name="music_path_lrc" id="music_path_lrc"></td>
				</tr>
				<tr>
					<td>音乐所属一级类型</td>
					<td>十字以内(必填)</td>
					<td><input type="text" name="music_type1"></td>
				</tr>
				<tr>
					<td>音乐所属二级类型</td>
					<td>十字以内(必填)</td>
					<td><input type="text" name="music_type2"></td>
				</tr>
				<tr>
					<td>在线量</td>
					<td>整数</td>
					<td>
					总<input type="text" style="width:60px;" name="music_audition_sum_number"/>
					&nbsp;月<input type="text" style="width:60px;" name="music_audition_month_number"/>
					&nbsp;周<input type="text" style="width:60px;" name="music_audition_week_number"/>
					&nbsp;日<input type="text" style="width:60px;" name="music_audition_day_number"/>
					</td>
				</tr>
				<tr>
					<td>下载量</td>
					<td>整数</td>
					<td>
					总<input type="text" style="width:60px;" name="music_download_sum_number"/>
					&nbsp;月<input type="text" style="width:60px;" name="music_download_month_number"/>
					&nbsp;周<input type="text" style="width:60px;" name="music_download_week_number"/>
					&nbsp;日<input type="text" style="width:60px;" name="music_download_day_number"/>
					</td>
					</tr>
				<tr>
					<td>音乐图片</td>
					<td>在本地选择文件(必填)</td>
					<td align="center"><input type="file"name="music_photo" id="music_photo"></td>
				</tr>
				<tr>
					<td>音乐背景图片</td>
					<td>(必填)</td>
					<td align="center"><input type="file" name="music_bg_photo" id="music_bg_photo"></td>
				</tr>
				<tr>
					<td>音乐主图图片</td>
					<td>(必填)</td>
					<td align="center"><input type="file" name="music_main_photo" id="music_main_photo"></td>
				</tr>
				<tr>
					<td>音乐简介</td>
					<td>(必填)</td>
					<td align="center"><input type="text" name="music_introduct"></td>
				</tr>
				<tr>
					<td>下载所需金币</td>
					<td>(必填)</td>
					<td align="center"><input type="text" name="music_coins"></td>
				</tr>
				<tr>
					<td>备注</td>
					<td></td>
					<td><input type="hidden" name="music_upload_time">
					<input type="text" name="music_remarks">
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="确定" class="btn btn-primary">
		<input type="reset" value="重置" class="btn btn-danger">
    </form>
  </body>
</html>
