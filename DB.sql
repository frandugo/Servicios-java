--------------------------------------------------------
-- Archivo creado  - mi�rcoles-noviembre-25-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence EMPRESA_ID
--------------------------------------------------------

   CREATE SEQUENCE  "EMPRESA_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MANTENIMIENTO_ID
--------------------------------------------------------

   CREATE SEQUENCE  "MANTENIMIENTO_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SERVICIO_ID
--------------------------------------------------------

   CREATE SEQUENCE  "SERVICIO_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USUARIO_ID
--------------------------------------------------------

   CREATE SEQUENCE  "USUARIO_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table EMPRESA
--------------------------------------------------------

  CREATE TABLE "EMPRESA" 
   (	"EMPRID" NUMBER, 
	"EMPRNOMB" VARCHAR2(50 BYTE), 
	"EMPRDESC" VARCHAR2(100 BYTE), 
	"EMPRCIUD" VARCHAR2(50 BYTE), 
	"EMPRPAIS" VARCHAR2(50 BYTE), 
	"EMPRESTD" VARCHAR2(2 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FACTURA
--------------------------------------------------------

  CREATE TABLE "FACTURA" 
   (	"USUAID" NUMBER, 
	"EMPRID" NUMBER, 
	"FACTID" NUMBER, 
	"FACTFECH" DATE, 
	"FACTDESC" VARCHAR2(50 BYTE), 
	"FACTFEPA" DATE, 
	"FACTESTD" VARCHAR2(2 BYTE), 
	"FACTPERI" VARCHAR2(6 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FACTURA_DETALLE
--------------------------------------------------------

  CREATE TABLE "FACTURA_DETALLE" 
   (	"USUAID" NUMBER, 
	"EMPRID" NUMBER, 
	"FACTID" NUMBER, 
	"SERVID" NUMBER, 
	"SERVVLR" NUMBER(10,2), 
	"MANTID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table MANTENIMIENTO
--------------------------------------------------------

  CREATE TABLE "MANTENIMIENTO" 
   (	"USUAID" NUMBER, 
	"EMPRID" NUMBER, 
	"SERVID" NUMBER, 
	"MANTID" NUMBER, 
	"MANTFECH" DATE, 
	"MANTDESC" VARCHAR2(200 BYTE), 
	"MANTESTD" VARCHAR2(2 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SERVICIO
--------------------------------------------------------

  CREATE TABLE "SERVICIO" 
   (	"EMPRID" NUMBER, 
	"SERVID" NUMBER, 
	"SERVNOMB" VARCHAR2(30 BYTE), 
	"SERVDESC" VARCHAR2(30 BYTE), 
	"SERVESTD" VARCHAR2(2 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "USUARIO" 
   (	"USUAID" NUMBER, 
	"USUANOMB" VARCHAR2(50 BYTE), 
	"USUAAPELL" VARCHAR2(50 BYTE), 
	"USUADOCU" NUMBER, 
	"USUATIPO" VARCHAR2(30 BYTE), 
	"USUAEMAIL" VARCHAR2(30 BYTE), 
	"USUAPASS" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO_EMPRESA
--------------------------------------------------------

  CREATE TABLE "USUARIO_EMPRESA" 
   (	"USUAID" NUMBER, 
	"EMPRID" NUMBER, 
	"USUAESTD" VARCHAR2(2 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO_SERVICIO
--------------------------------------------------------

  CREATE TABLE "USUARIO_SERVICIO" 
   (	"USUAID" NUMBER, 
	"EMPRID" NUMBER, 
	"SERVID" NUMBER, 
	"USUAESTD" VARCHAR2(2 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into EMPRESA
SET DEFINE OFF;
Insert into EMPRESA (EMPRID,EMPRNOMB,EMPRDESC,EMPRCIUD,EMPRPAIS,EMPRESTD) values ('1','Claro','Empresa de Telecomunicaciones','Barranquilla','Colombia','A');
Insert into EMPRESA (EMPRID,EMPRNOMB,EMPRDESC,EMPRCIUD,EMPRPAIS,EMPRESTD) values ('2','Tigo','Empresa de Telecomunicaciones','Barranquilla','Colombia','A');
Insert into EMPRESA (EMPRID,EMPRNOMB,EMPRDESC,EMPRCIUD,EMPRPAIS,EMPRESTD) values ('21','Electricaribe','Empresa Electrica','Barranquilla','Colombia','E');
Insert into EMPRESA (EMPRID,EMPRNOMB,EMPRDESC,EMPRCIUD,EMPRPAIS,EMPRESTD) values ('23','Triple AAA','AAA','BQ','COL','E');
REM INSERTING into FACTURA
SET DEFINE OFF;
Insert into FACTURA (USUAID,EMPRID,FACTID,FACTFECH,FACTDESC,FACTFEPA,FACTESTD,FACTPERI) values ('41','1','1',to_date('23/10/15','DD/MM/RR'),'Factura Octubre',to_date('23/10/15','DD/MM/RR'),'A','201510');
Insert into FACTURA (USUAID,EMPRID,FACTID,FACTFECH,FACTDESC,FACTFEPA,FACTESTD,FACTPERI) values ('41','2','1',to_date('23/10/15','DD/MM/RR'),'Factura Octubre',to_date('23/10/15','DD/MM/RR'),'A','201510');
Insert into FACTURA (USUAID,EMPRID,FACTID,FACTFECH,FACTDESC,FACTFEPA,FACTESTD,FACTPERI) values ('41','1','2',to_date('23/11/15','DD/MM/RR'),'Factura Noviembre',to_date('24/11/15','DD/MM/RR'),'A','201511');
Insert into FACTURA (USUAID,EMPRID,FACTID,FACTFECH,FACTDESC,FACTFEPA,FACTESTD,FACTPERI) values ('41','2','2',to_date('23/11/15','DD/MM/RR'),'Factura Noviembre',null,'A','201511');
REM INSERTING into FACTURA_DETALLE
SET DEFINE OFF;
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','1','1','1','25000',null);
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','1','1','2','35000','20');
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','1','1','3','20000','19');
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','2','1','4','35000',null);
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','2','1','5','45000',null);
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','1','2','1','25000',null);
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','1','2','2','35000',null);
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','1','2','3','20000',null);
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','2','2','4','35000',null);
Insert into FACTURA_DETALLE (USUAID,EMPRID,FACTID,SERVID,SERVVLR,MANTID) values ('41','2','2','5','45000',null);
REM INSERTING into MANTENIMIENTO
SET DEFINE OFF;
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','1','1',to_date('21/11/15','DD/MM/RR'),'Descripcion..','A');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','2','2',to_date('21/11/15','DD/MM/RR'),'Descripcion..','A');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','3','3',to_date('21/11/15','DD/MM/RR'),'Descripcion..','P');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','1','15',to_date('23/11/15','DD/MM/RR'),'Mnto internet!!','P');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','2','16',to_date('23/11/15','DD/MM/RR'),'Mnto telefonia!!','P');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','2','17',to_date('23/11/15','DD/MM/RR'),'Mnto telefonia!!','P');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','3','18',to_date('23/11/15','DD/MM/RR'),'Test','P');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','3','19',to_date('20/11/15','DD/MM/RR'),'Mnto television digital','A');
Insert into MANTENIMIENTO (USUAID,EMPRID,SERVID,MANTID,MANTFECH,MANTDESC,MANTESTD) values ('41','1','2','20',to_date('25/11/15','DD/MM/RR'),'Mnto Tel Fija','A');
REM INSERTING into SERVICIO
SET DEFINE OFF;
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('1','1','Internet','Internet','A');
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('1','2','Telefonia Fija','Telefonia Fija','A');
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('1','3','Television Digital 2','Television Digital 2','E');
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('2','4','Internet Movil','Internet Movil','A');
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('2','5','Telefonia Movil','Telefonia Movil','A');
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('1','43','Testing...','Testing...','E');
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('2','44','Internet Movil 2Gb','Internet Movil 2Gb','E');
Insert into SERVICIO (EMPRID,SERVID,SERVNOMB,SERVDESC,SERVESTD) values ('1','45','Testing','Testing','A');
REM INSERTING into USUARIO
SET DEFINE OFF;
Insert into USUARIO (USUAID,USUANOMB,USUAAPELL,USUADOCU,USUATIPO,USUAEMAIL,USUAPASS) values ('41','Francisco','Duran','11000000','user','fduran','0');
Insert into USUARIO (USUAID,USUANOMB,USUAAPELL,USUADOCU,USUATIPO,USUAEMAIL,USUAPASS) values ('42','Administrador',null,'1','admin','admin','0');
REM INSERTING into USUARIO_EMPRESA
SET DEFINE OFF;
Insert into USUARIO_EMPRESA (USUAID,EMPRID,USUAESTD) values ('41','2','A');
Insert into USUARIO_EMPRESA (USUAID,EMPRID,USUAESTD) values ('41','1','A');
REM INSERTING into USUARIO_SERVICIO
SET DEFINE OFF;
Insert into USUARIO_SERVICIO (USUAID,EMPRID,SERVID,USUAESTD) values ('41','1','1','A');
Insert into USUARIO_SERVICIO (USUAID,EMPRID,SERVID,USUAESTD) values ('41','1','2','A');
Insert into USUARIO_SERVICIO (USUAID,EMPRID,SERVID,USUAESTD) values ('41','1','3','A');
Insert into USUARIO_SERVICIO (USUAID,EMPRID,SERVID,USUAESTD) values ('41','2','4','A');
Insert into USUARIO_SERVICIO (USUAID,EMPRID,SERVID,USUAESTD) values ('41','2','5','A');
--------------------------------------------------------
--  DDL for Index USUARIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USUARIO_PK" ON "USUARIO" ("USUAID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index FACTURA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURA_PK" ON "FACTURA" ("FACTID", "USUAID", "EMPRID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USUARIO_SERVICIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USUARIO_SERVICIO_PK" ON "USUARIO_SERVICIO" ("USUAID", "EMPRID", "SERVID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index FACTURA_DETALLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURA_DETALLE_PK" ON "FACTURA_DETALLE" ("USUAID", "EMPRID", "FACTID", "SERVID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USUARIO_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "USUARIO_UK1" ON "USUARIO" ("USUADOCU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SERVICIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SERVICIO_PK" ON "SERVICIO" ("EMPRID", "SERVID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index MANTENIMIENTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MANTENIMIENTO_PK" ON "MANTENIMIENTO" ("USUAID", "EMPRID", "SERVID", "MANTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USUARIO_UK2
--------------------------------------------------------

  CREATE UNIQUE INDEX "USUARIO_UK2" ON "USUARIO" ("USUAEMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index EMPRESA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EMPRESA_PK" ON "EMPRESA" ("EMPRID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USUARIO_EMPRESA_PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "USUARIO_EMPRESA_PK1" ON "USUARIO_EMPRESA" ("USUAID", "EMPRID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table MANTENIMIENTO
--------------------------------------------------------

  ALTER TABLE "MANTENIMIENTO" ADD CONSTRAINT "MANTENIMIENTO_PK" PRIMARY KEY ("USUAID", "EMPRID", "SERVID", "MANTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "MANTENIMIENTO" MODIFY ("MANTID" NOT NULL ENABLE);
  ALTER TABLE "MANTENIMIENTO" MODIFY ("SERVID" NOT NULL ENABLE);
  ALTER TABLE "MANTENIMIENTO" MODIFY ("EMPRID" NOT NULL ENABLE);
  ALTER TABLE "MANTENIMIENTO" MODIFY ("USUAID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO_EMPRESA
--------------------------------------------------------

  ALTER TABLE "USUARIO_EMPRESA" ADD CONSTRAINT "USUARIO_EMPRESA_PK" PRIMARY KEY ("USUAID", "EMPRID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "USUARIO_EMPRESA" MODIFY ("EMPRID" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_EMPRESA" MODIFY ("USUAID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "USUARIO" ADD CONSTRAINT "USUARIO_UK2" UNIQUE ("USUAEMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "USUARIO" ADD CONSTRAINT "USUARIO_UK1" UNIQUE ("USUADOCU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "USUARIO" ADD CONSTRAINT "USUARIO_PK" PRIMARY KEY ("USUAID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table FACTURA
--------------------------------------------------------

  ALTER TABLE "FACTURA" ADD CONSTRAINT "FACTURA_PK" PRIMARY KEY ("FACTID", "USUAID", "EMPRID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURA" MODIFY ("FACTID" NOT NULL ENABLE);
  ALTER TABLE "FACTURA" MODIFY ("EMPRID" NOT NULL ENABLE);
  ALTER TABLE "FACTURA" MODIFY ("USUAID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FACTURA_DETALLE
--------------------------------------------------------

  ALTER TABLE "FACTURA_DETALLE" ADD CONSTRAINT "FACTURA_DETALLE_PK" PRIMARY KEY ("USUAID", "EMPRID", "FACTID", "SERVID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURA_DETALLE" MODIFY ("SERVID" NOT NULL ENABLE);
  ALTER TABLE "FACTURA_DETALLE" MODIFY ("FACTID" NOT NULL ENABLE);
  ALTER TABLE "FACTURA_DETALLE" MODIFY ("EMPRID" NOT NULL ENABLE);
  ALTER TABLE "FACTURA_DETALLE" MODIFY ("USUAID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SERVICIO
--------------------------------------------------------

  ALTER TABLE "SERVICIO" ADD CONSTRAINT "SERVICIO_PK" PRIMARY KEY ("EMPRID", "SERVID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPRESA
--------------------------------------------------------

  ALTER TABLE "EMPRESA" ADD CONSTRAINT "EMPRESA_PK" PRIMARY KEY ("EMPRID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO_SERVICIO
--------------------------------------------------------

  ALTER TABLE "USUARIO_SERVICIO" ADD CONSTRAINT "USUARIO_SERVICIO_PK" PRIMARY KEY ("USUAID", "EMPRID", "SERVID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "USUARIO_SERVICIO" MODIFY ("SERVID" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_SERVICIO" MODIFY ("EMPRID" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_SERVICIO" MODIFY ("USUAID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table FACTURA
--------------------------------------------------------

  ALTER TABLE "FACTURA" ADD CONSTRAINT "FACTURA_FK1" FOREIGN KEY ("USUAID", "EMPRID")
	  REFERENCES "USUARIO_EMPRESA" ("USUAID", "EMPRID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FACTURA_DETALLE
--------------------------------------------------------

  ALTER TABLE "FACTURA_DETALLE" ADD CONSTRAINT "FACTURA_DETALLE_FK1" FOREIGN KEY ("FACTID", "USUAID", "EMPRID")
	  REFERENCES "FACTURA" ("FACTID", "USUAID", "EMPRID") ENABLE;
  ALTER TABLE "FACTURA_DETALLE" ADD CONSTRAINT "FACTURA_DETALLE_FK2" FOREIGN KEY ("USUAID", "EMPRID", "SERVID", "MANTID")
	  REFERENCES "MANTENIMIENTO" ("USUAID", "EMPRID", "SERVID", "MANTID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MANTENIMIENTO
--------------------------------------------------------

  ALTER TABLE "MANTENIMIENTO" ADD CONSTRAINT "MANTENIMIENTO_FK1" FOREIGN KEY ("USUAID", "EMPRID", "SERVID")
	  REFERENCES "USUARIO_SERVICIO" ("USUAID", "EMPRID", "SERVID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SERVICIO
--------------------------------------------------------

  ALTER TABLE "SERVICIO" ADD CONSTRAINT "SERVICIO_FK1" FOREIGN KEY ("EMPRID")
	  REFERENCES "EMPRESA" ("EMPRID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO_EMPRESA
--------------------------------------------------------

  ALTER TABLE "USUARIO_EMPRESA" ADD CONSTRAINT "USUARIO_EMPRESA_FK1" FOREIGN KEY ("USUAID")
	  REFERENCES "USUARIO" ("USUAID") ENABLE;
  ALTER TABLE "USUARIO_EMPRESA" ADD CONSTRAINT "USUARIO_EMPRESA_FK2" FOREIGN KEY ("EMPRID")
	  REFERENCES "EMPRESA" ("EMPRID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO_SERVICIO
--------------------------------------------------------

  ALTER TABLE "USUARIO_SERVICIO" ADD CONSTRAINT "USUARIO_SERVICIO_FK1" FOREIGN KEY ("USUAID", "EMPRID")
	  REFERENCES "USUARIO_EMPRESA" ("USUAID", "EMPRID") ENABLE;
