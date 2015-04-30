drop database if exists friend;

create database friend;

use friend;


create table client(
c_id int auto_increment,
c_name varchar(20) unique,
c_pass varchar(200),
c_sex boolean,
c_mail varchar(200),
c_qq varchar(200),
primary key(c_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



create table album_kind(
k_id int auto_increment,
k_name varchar(200),
k_desc varchar(200),
primary key(k_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



create table album(
a_id int auto_increment,
a_name varchar(200),
a_desc varchar(200),
a_create_date datetime,
a_times long,
c_id int,
k_id int,
primary key(a_id),
foreign key(c_id) references client(c_id) on delete cascade,
foreign key(k_id) references album_kind(k_id) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table album_word(
aw_id int auto_increment,
aw_title varchar(200),
aw_content long varchar,
commit_date datetime,
a_id int,
c_id int,
primary key(aw_id),
foreign key(a_id) references album(a_id) on delete cascade,
foreign key(c_id) references client(c_id) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table photo(
p_id int auto_increment,
p_title varchar(200),
p_desc varchar(200),
p_times long,
p_pic varchar(200),
p_big_pic varchar(200),
p_small_pic varchar(200),
p_up_date datetime,
p_cover boolean,
a_id int,
primary key(p_id),
foreign key(a_id) references album(a_id) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table photo_word(
pw_id int auto_increment,
pw_title varchar(200),
pw_content varchar(200),
commit_date datetime,
p_id int,
c_id int,
primary key(pw_id),
foreign key(p_id) references photo(p_id) on delete cascade,
foreign key(c_id) references client(c_id) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table admin(
ad_id int auto_increment,
ad_name varchar(200),
ad_pass varchar(200),
primary key(ad_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into admin values(null , 'admin','admin');