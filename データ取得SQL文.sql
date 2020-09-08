select time, name, zaishitu from zaishitu as T1
inner join (
    select rfid_id as F1,max(time) as F2 from zaishitu group by rfid_id
) as T3
on T3.F1=T1.rfid_id and T3.F2=T1.time
inner join(
    select name,rfid_id from username
) as T2
on T1.rfid_id=T2.rfid_id;

--参考サイト
--GROUP BYとHAVINGで最新日付データを取得する
--https://lightgauge.net/database/sqlserver/1672/
--https://sites.google.com/site/nssvdabb/sql/join
