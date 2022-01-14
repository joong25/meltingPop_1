import pymysql
from crawling.crawling_music_database2 import song_list, singer_list

conn = pymysql.connect(host='localhost', user='root',
                       password='1234', db='meltingpop_db_1', charset='utf8mb4')

cursor = conn.cursor()

try:

    cursor.execute("set foreign_key_checks = 0")
    cursor.execute("drop table if exists client cascade")
    cursor.execute("drop table if exists song cascade")
    cursor.execute("drop table if exists song_info cascade")
    cursor.execute("set foreign_key_checks = 1")
    cursor.execute("""create table client(
                        CID varchar(20) not null,
                        CPW varchar(20) not null,
                        CEmail varchar(20) not null,
                        primary key(CID))""")
    cursor.execute("""create table song_info(
                        song varchar(50),
                        singer varchar(50), 
                        lyric varchar(5000))""")
    conn.commit()
except:
    conn.rollback()
for i in song_list:
    cursor.execute('insert into song_info(song) values("'+i+'")')
for i in singer_list:
    cursor.execute("insert into song_info(singer) values('"+i+"')")
conn.commit()

conn.close()
