import pymysql
from crawling_music_database2 import song_list, singer_list
from crawling_music_database3 import lyric_list

length = len(song_list)
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
                        lyric varchar(12000))""")
    conn.commit()
except:
    conn.rollback()
# insert into song_info (song, singer, lyric) values ("hi","bye","hello")
for i in range(0, length):
    # cursor.execute('insert into song_info (song, singer, lyric) values ("' +
    #               song_list[i]+'","'+singer_list[i]+'","'+lyric_list[i]+'")')
    cursor.execute('insert into song_info (song, singer, lyric) values (%s,%s,%s)',
                   (song_list[i], singer_list[i], lyric_list[i]))
conn.commit()

conn.close()
