create table user(
	user_id        int PRIMARY KEY AUTO_INCREMENT,
	user_phone     varchar(15) UNIQUE,   ##(用户手机号，唯一)
	user_password  varchar(50),          ##(用户密码)
	user_nickname  varchar(20),          ##(用户昵称)
	user_token     varchar(200),         ##(短信验证token)
	user_openid    varchar(200),         ##(第三方登录token)
	user_realname  varchar(20),          ##(用户的真实姓名)
	user_sex       char(2),              ##(用户性别)
	user_type      int,                  ##(是否为会员)
	user_remarks   varchar(100)          ##(备注)
)AUTO_INCREMENT=10000;
##学习币表：coins asas
CREATE table coins(
	coins_id            int PRIMARY KEY AUTO_INCREMENT,
	user_id             int,           ##(用户ID，外键)
	coins_num           int,           ##(学习币数)
	coins_remarks       varchar(100)); ##(备注)

##用户小孩信息表：child
CREATE table child(
	child_id               int PRIMARY KEY AUTO_INCREMENT,
	user_id                int,              ##(外键)
	child_birthday         date,             ##(宝宝生日)
	child_name             varchar(20),      ##(姓名)
	child_photo            varchar(100),     ##(头像)
	child_sex              char(2),          ##(性别)
	child_school_province  varchar(20),      ##(学校省份)
	child_school_city      varchar(20),      ##(学校城市)
	child_school_county    varchar(20),      ##(学校区)
	child_school_town      varchar(20),      ##(学校镇)
	child_school_name      varchar(100),     ##(学校名称)
	child_school_class     varchar(50),      ##(字符串)小班 中班 大班..
	child_home_province    varchar(20),      ##(家庭住址省)
	child_home_city        varchar(20),      ##(家庭住址市)
	child_home_county      varchar(20),      ##(家庭住址区)
	child_home_address     varchar(100),     ##(家庭住址)
	child_hobby            varchar(20),      ##(宝宝爱好)
	child_remarks          varchar(100)      ##（备注）
);

##音乐表：music
create TABLE music(
	music_id                     int PRIMARY KEY AUTO_INCREMENT,
	music_name                   varchar(200),  ##音乐名称      
	music_path_mp3               varchar(300),  ##音乐文件路径
	music_path_lrc               varchar(300),  ##歌词文件路径
	music_type1                  varchar(20),   ##音乐一级类型
	music_type2                  varchar(20),   ##音乐二级类型
	music_audition_sum_number    int,           ##在线播放总量
	music_audition_month_number  int,           ##月在线播放总量
	music_audition_week_number   int,           ##周在线播放总量
	music_audition_day_number    int,           ##天在线播放总量
	music_download_sum_number    int,           ##总下载量
	music_download_month_number  int,           ##月下载量
	music_download_week_number   int,           ##周下载量
	music_download_day_number    int,           ##天下载量
	music_type_photo             varchar(300),  ##音乐二级类型图片
	music_photo                  varchar(300),  ##音乐图片地址
	music_coins    				 int,           ##(下载所需金币)
	music_upload_time			 datetime       ##音乐上传时间
	music_remarks                varchar(100)   ##备注
);  

##视频表：video
create TABLE video(
	video_id                     int PRIMARY KEY AUTO_INCREMENT,
	video_name                   varchar(200), ##视频名称         
	video_path                   varchar(300), ##视频文件地址
	video_type1                  varchar(20),  ##视频一级类型
	video_type2                  varchar(20),  ##视频二级类型
	video_audition_sum_number    int,          ##在线观看总量
	video_audition_month_number  int,          ##月在线观看量
	video_audition_week_number   int,          ##周在线观看量
	video_audition_day_number    int,          ##日在线观看量
	video_download_sum_number    int,          ##总下载量
	video_download_month_number  int,          ##月下载量
	video_download_week_number   int,          ##周下载量
	video_download_day_number    int,          ##天下载量
	video_type_photo             varchar(300), ##视频二级类型图片
	video_photo                  varchar(300), ##视频图片
	video_coins    				 int,          ##(下载所需金币)
	video_upload_time			 datetime       ##音乐上传时间
	video_remarks         		 varchar(100)  ##(备注)
);   

##music评论表：musiccomment
create TABLE musiccomment(
	comment_id       int PRIMARY KEY AUTO_INCREMENT,
	music_id         int,                      ##音乐ID
	user_id          int,                      ##评论用户ID
	comment_content  varchar(200),             ##评论内容
	comment_time     varchar(50)               ##评论时间精确到秒
);
##video评论表：videocomment
create TABLE videocomment(
comment_id      int PRIMARY KEY AUTO_INCREMENT,
video_id        int,                           ##视频ID
user_id         int,                           ##评论用户ID
comment_content varchar(200),                  ##评论内容
comment_time    varchar(50)                    ##评论时间
);
##competition报名表：competition
create TABLE competition(
	competition_id             int PRIMARY KEY AUTO_INCREMENT,
	competition_name           VARCHAR(20),    ##报名人的姓名
	competition_sex            CHAR(2),        ##性别
	competition_birthday       date,           ##生日
	competition_mail_address   varchar(300),   ##邮寄地址
	competition_phone          varchar(15),    ##电话
	competition_schoolname     VARCHAR(100),   ##学校名称
	competition_weixin         VARCHAR(30),    ##微信号
	competition_group          VARCHAR(200),   ##参赛组别 （托班，小班，中班，大班，一年级。。）
	competition_grading        VARCHAR(200),   ##考级考证（多选）最多设置5个
	competition_project        VARCHAR(50),    ##参赛项目
	competition_way            VARCHAR(50)     ##哪种途径知晓
);
##contestinfo比赛信息表：contestinfo
create TABLE contestinfo(
	contestinfo_id            int PRIMARY KEY AUTO_INCREMENT,
	contestinfo_name          VARCHAR(40),     ##比赛名称
	contestinfo_endtime       date,            ##比赛截止日期
	contestinfo_smallphoto    VARCHAR(300),    ##比赛小图
	contestinfo_largephoto    VARCHAR(300)     ##比赛详情大图
);
##插入数据
insert into user(user_phone,user_password,user_nickname,user_token,user_openid,user_realname,user_sex,user_type,user_remarks)
 values(13613656,'123456','little girl','token','','大妹子','女',1,'');
insert into coins(user_id,coins_num,coins_remarks) values(10000,100,'');
insert into child(user_id,child_birthday,child_name,child_photo,child_sex,child_school_province,child_school_city,child_school_county,child_school_town,
child_school_name,child_school_class,child_home_province,child_home_city,child_home_county,child_home_address,child_hobby,child_remarks)
values('10000','2015-11-09','大宝','http://img4.imgtn.bdimg.com/it/u=2521110427,1309412397&fm=21&gp=0.jpg','男','浙江省','杭州市','拱墅区','','杭州实验幼儿园',
'大班','浙江省','杭州市','拱墅区','浙江省杭州市拱墅区祥茂路36号','唱歌,街舞','');
insert into music(music_name,music_path_mp3,music_path_lrc,music_type1,music_type2,music_audition_sum_number,music_audition_month_number,music_audition_week_number,
music_audition_day_number,music_download_sum_number,music_download_month_number,music_download_week_number,music_download_day_number,music_type_photo,
music_photo,music_coins,music_remarks) values('两只老虎','两只老虎MP3文件路径','两只老虎歌词文件路径','儿歌','经典儿歌',1,1,1,1,1,1,1,1,'','',5,'备注');
insert into video(video_name,video_path,video_type1,video_type2,video_audition_sum_number,video_audition_month_number,video_audition_week_number,
video_audition_day_number,video_download_sum_number,video_download_month_number,video_download_week_number,video_download_day_number,video_type_photo,
video_photo,video_coins,video_remarks) values('两只老虎','两只老虎视频文件路径','儿歌','经典儿歌',1,1,1,1,1,1,1,1,'','',5,'备注');
insert into musiccomment(music_id,user_id,comment_content,comment_time) values(1,10000,'这首歌音质高，不错','2016-07-07 12:00');
insert into videocomment(video_id,user_id,comment_content,comment_time) values(1,10000,'这视频高清，不错','2016-07-07 12:00');


