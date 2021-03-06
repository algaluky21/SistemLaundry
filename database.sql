SQL> CREATE TABLESPACE alga_06991
  2  datafile 'D:\KULIAH\Semester 4\Basis Data\Praktikum\Modul 1\sisteminformasi_laundry.dbf'
  3  size 30M;

SQL> CREATE USER algaluky_06991
  2  IDENTIFIED BY algaluky
  3  DEFAULT TABLESPACE alga_06991
  4  QUOTA 30m ON alga_06991;

SQL> GRANT ALL PRIVILEGES TO algaluky_06991;

SQL> create table t_jenis_cucian
  2  (
  3  id_jenis_cucian 	INTEGER not null,
  4  jenis_cucian	VARVHAR(20),
  5  harga_perkilo,	NUMBER(7),
  6  constraint PK_jenis_cucian primary key (id_jenis_cucian)
  7  );

SQL> create table t_pelanggan
  2  (
  3  id_pelanggan 	INTEGER not null,
  4  nama pelanggan	VARVHAR2(15),
  5  alamat		VARVHAR2(30),
  6  no_hp		NUMBER(12),
  7  constraint PK_pelanggan primary key (id_pelanggan)
  8  );

SQL> create table t_transaksi
  2  (
  3  id_transaksi 	INTEGER 	not null,
  4  id_pelanggan	INTEGER,
  5  id_jenis_cucian	INTEGER,
  6  tgl_transaksi	DATE,
  7  berat_cucian	VARVHAR2(30),
  8  total_harga	NUMBER(10),
  9  bayar		NUMBER(10),
  10 kembali		NUMBER(10),
  11 constraint PK_transaksi primary key (id_transaksi)
  10  );

SQL> alter table t_transaksi
  2 add constraint FK_id_pelanggan FOREIGN KEY (id_pelanggan)
  3 references t_pelanggan(id_pelanggan)
  4 add constraint FK_id_jenis_cucian FOREIGN KEY (id_jenis_cucian)
  5 references t_jenis_cucian(id_jenis_cucian);

--------------------------------------------------------
--  File created - Thursday-July-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ID_JENIS_CUCIAN
--------------------------------------------------------

   CREATE SEQUENCE  "ALGALUKY_06991"."ID_JENIS_CUCIAN"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 6 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence ID_TRANSAKSI
--------------------------------------------------------

   CREATE SEQUENCE  "ALGALUKY_06991"."ID_TRANSAKSI"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 26 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table T_JENIS_CUCIAN
--------------------------------------------------------

  CREATE TABLE "ALGALUKY_06991"."T_JENIS_CUCIAN" 
   (	"ID_JENIS_CUCIAN" NUMBER(*,0), 
	"JENIS_CUCIAN" VARCHAR2(20 BYTE), 
	"HARGA_PERKILO" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991" ;
--------------------------------------------------------
--  DDL for Table T_PELANGGAN
--------------------------------------------------------

  CREATE TABLE "ALGALUKY_06991"."T_PELANGGAN" 
   (	"ID_PELANGGAN" NUMBER(*,0), 
	"NAMA_PELANGGAN" VARCHAR2(15 BYTE), 
	"ALAMAT" VARCHAR2(30 BYTE), 
	"NO_HP" NUMBER(12,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991" ;
--------------------------------------------------------
--  DDL for Table T_TRANSAKSI
--------------------------------------------------------

  CREATE TABLE "ALGALUKY_06991"."T_TRANSAKSI" 
   (	"ID_TRANSAKSI" NUMBER(*,0), 
	"ID_PELANGGAN" NUMBER(*,0), 
	"ID_JENIS_CUCIAN" NUMBER(*,0), 
	"TGL_TRANSAKSI" DATE, 
	"BERAT_CUCIAN" NUMBER(10,0), 
	"TOTAL_HARGA" NUMBER(10,0), 
	"BAYAR" NUMBER(10,0), 
	"KEMBALI" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991" ;
--------------------------------------------------------
--  DDL for View LIST_JENIS_CUCIAN
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "ALGALUKY_06991"."LIST_JENIS_CUCIAN" ("ID_JENIS_CUCIAN", "JENIS_CUCIAN", "HARGA_PERKILO") AS 
  select "ID_JENIS_CUCIAN","JENIS_CUCIAN","HARGA_PERKILO" from t_jenis_cucian
;
--------------------------------------------------------
--  DDL for View LIST_PELANGGAN
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "ALGALUKY_06991"."LIST_PELANGGAN" ("NAMA_PELANGGAN", "ALAMAT", "TOTAL_HARGA", "BAYAR") AS 
  select b.nama_pelanggan, b.alamat, a.total_harga, a.bayar
from t_transaksi a join
t_pelanggan b on
a.id_pelanggan = b.id_pelanggan
;
--------------------------------------------------------
--  DDL for View LIST_TRANSAKSI
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "ALGALUKY_06991"."LIST_TRANSAKSI" ("TGL_TRANSAKSI", "JENIS_CUCIAN", "NAMA_PELANGGAN", "TOTAL_HARGA") AS 
  select c.tgl_transaksi,a.jenis_cucian, b.nama_pelanggan, c.total_harga
from t_jenis_cucian a left join t_pelanggan b
on a.id_jenis_cucian = b.id_pelanggan
left join t_transaksi c
on a.id_jenis_cucian = c.id_jenis_cucian
where id_transaksi <= (select avg(total_harga) from t_transaksi)
;
--------------------------------------------------------
--  DDL for View LIST_TRANSAKSI2
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "ALGALUKY_06991"."LIST_TRANSAKSI2" ("JENIS_CUCIAN", "NAMA_PELANGGAN", "ID_TRANSAKSI", "TGL_TRANSAKSI", "TOTAL_HARGA") AS 
  select a.jenis_cucian, b.nama_pelanggan, c.id_transaksi, c. tgl_transaksi, c.total_harga
 from t_jenis_cucian a right join t_pelanggan b
 on a.id_jenis_cucian = b.id_pelanggan
 right join t_transaksi c
 on a.id_jenis_cucian = c.id_jenis_cucian
 where id_transaksi <= (select count(id_transaksi) from t_transaksi
 where id_transaksi < (select max(id_transaksi) from t_transaksi)
 and id_transaksi > (select min(id_transaksi) from t_transaksi))
;
REM INSERTING into ALGALUKY_06991.T_JENIS_CUCIAN
SET DEFINE OFF;
Insert into ALGALUKY_06991.T_JENIS_CUCIAN (ID_JENIS_CUCIAN,JENIS_CUCIAN,HARGA_PERKILO) values (1,'cuci basah',2500);
Insert into ALGALUKY_06991.T_JENIS_CUCIAN (ID_JENIS_CUCIAN,JENIS_CUCIAN,HARGA_PERKILO) values (2,'cuci kering',3000);
Insert into ALGALUKY_06991.T_JENIS_CUCIAN (ID_JENIS_CUCIAN,JENIS_CUCIAN,HARGA_PERKILO) values (3,'cuci setrika',3500);
Insert into ALGALUKY_06991.T_JENIS_CUCIAN (ID_JENIS_CUCIAN,JENIS_CUCIAN,HARGA_PERKILO) values (4,'cuci setrika plus',4500);
Insert into ALGALUKY_06991.T_JENIS_CUCIAN (ID_JENIS_CUCIAN,JENIS_CUCIAN,HARGA_PERKILO) values (5,'cuci setrika cepat',5500);
REM INSERTING into ALGALUKY_06991.T_PELANGGAN
SET DEFINE OFF;
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (10,'bayu','jalan',123213231);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (11,'rafa','surabaya',123123321);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (6,'budi setyawan','klampis',666666666);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (8,'alisya','blitar',888888889);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (7,'budi doremi','gunungsar',777777777);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (9,'reza','wonokitri',999999999);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (1,'budi','Sememi',111111111);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (2,'dina','Kepatihan',222222222);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (3,'Alif','Benowo',333333333);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (4,'Krisna','Bandarejo',444444444);
Insert into ALGALUKY_06991.T_PELANGGAN (ID_PELANGGAN,NAMA_PELANGGAN,ALAMAT,NO_HP) values (5,'Rafli','Karah',555555555);
REM INSERTING into ALGALUKY_06991.T_TRANSAKSI
SET DEFINE OFF;
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (6,8,2,to_date('30-JUN-20','DD-MON-RR'),1,3000,5000,2000);
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (7,5,2,to_date('12-DEC-19','DD-MON-RR'),2,6000,10000,4000);
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (1,1,1,to_date('04-MAY-20','DD-MON-RR'),3,7500,10000,2500);
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (2,2,2,to_date('05-MAY-20','DD-MON-RR'),2,6000,10000,4000);
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (3,3,3,to_date('06-MAY-20','DD-MON-RR'),1,3500,5000,1500);
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (4,4,4,to_date('07-MAY-20','DD-MON-RR'),1,4500,5000,500);
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (5,5,5,to_date('08-MAY-20','DD-MON-RR'),2,11000,15000,4000);
Insert into ALGALUKY_06991.T_TRANSAKSI (ID_TRANSAKSI,ID_PELANGGAN,ID_JENIS_CUCIAN,TGL_TRANSAKSI,BERAT_CUCIAN,TOTAL_HARGA,BAYAR,KEMBALI) values (8,9,1,to_date('12-JUL-20','DD-MON-RR'),2,5000,10000,5000);
--------------------------------------------------------
--  DDL for Index PK_JENIS_CUCIAN
--------------------------------------------------------

  CREATE UNIQUE INDEX "ALGALUKY_06991"."PK_JENIS_CUCIAN" ON "ALGALUKY_06991"."T_JENIS_CUCIAN" ("ID_JENIS_CUCIAN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991" ;
--------------------------------------------------------
--  DDL for Index PK_TRANSAKSI
--------------------------------------------------------

  CREATE UNIQUE INDEX "ALGALUKY_06991"."PK_TRANSAKSI" ON "ALGALUKY_06991"."T_TRANSAKSI" ("ID_TRANSAKSI") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991" ;
--------------------------------------------------------
--  DDL for Index PK_PELANGGAN
--------------------------------------------------------

  CREATE UNIQUE INDEX "ALGALUKY_06991"."PK_PELANGGAN" ON "ALGALUKY_06991"."T_PELANGGAN" ("ID_PELANGGAN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991" ;
--------------------------------------------------------
--  Constraints for Table T_PELANGGAN
--------------------------------------------------------

  ALTER TABLE "ALGALUKY_06991"."T_PELANGGAN" ADD CONSTRAINT "PK_PELANGGAN" PRIMARY KEY ("ID_PELANGGAN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991"  ENABLE;
  ALTER TABLE "ALGALUKY_06991"."T_PELANGGAN" MODIFY ("ID_PELANGGAN" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table T_TRANSAKSI
--------------------------------------------------------

  ALTER TABLE "ALGALUKY_06991"."T_TRANSAKSI" ADD CONSTRAINT "PK_TRANSAKSI" PRIMARY KEY ("ID_TRANSAKSI")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991"  ENABLE;
  ALTER TABLE "ALGALUKY_06991"."T_TRANSAKSI" MODIFY ("ID_TRANSAKSI" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table T_JENIS_CUCIAN
--------------------------------------------------------

  ALTER TABLE "ALGALUKY_06991"."T_JENIS_CUCIAN" ADD CONSTRAINT "PK_JENIS_CUCIAN" PRIMARY KEY ("ID_JENIS_CUCIAN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ALGA_06991"  ENABLE;
  ALTER TABLE "ALGALUKY_06991"."T_JENIS_CUCIAN" MODIFY ("ID_JENIS_CUCIAN" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table T_TRANSAKSI
--------------------------------------------------------

  ALTER TABLE "ALGALUKY_06991"."T_TRANSAKSI" ADD CONSTRAINT "FK_ID_JENIS_CUCIAN" FOREIGN KEY ("ID_JENIS_CUCIAN")
	  REFERENCES "ALGALUKY_06991"."T_JENIS_CUCIAN" ("ID_JENIS_CUCIAN") ENABLE;
  ALTER TABLE "ALGALUKY_06991"."T_TRANSAKSI" ADD CONSTRAINT "FK_ID_PELANGGAN" FOREIGN KEY ("ID_PELANGGAN")
	  REFERENCES "ALGALUKY_06991"."T_PELANGGAN" ("ID_PELANGGAN") ENABLE;
