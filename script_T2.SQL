/*
Created: 13/9/2019
Modified: 13/9/2019
Model: administracionProyectos
Database: Oracle 11g Release 1
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE UNA.Adm_Proyecto_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE UNA.Adm_Administrador_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE UNA.Adm_Seguimiento_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE UNA.Adm_Actividad_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table UNA.Adm_Proyecto

CREATE TABLE UNA.Adm_Proyecto(
  pro_id Number NOT NULL,
  pro_patrocinador Varchar2(50 ),
  pro_lusuario Number NOT NULL,
  pro_ltecnico Varchar2(50 ),
  pro_fp_inicio Varchar2(30 ) NOT NULL,
  pro_fp_final Varchar2(30 ) NOT NULL,
  pro_fr_inicio Varchar2(30 ),
  pro_fr_final Varchar2(30 ),
  pro_estado Varchar2(1 ) NOT NULL,
  pro_version Number DEFAULT 1,
  pro_nombre Varchar2(30 ) NOT NULL,
  adm_id Number NOT NULL,
  CONSTRAINT pro_ck_estado CHECK (pro_estado in ('P', 'C', 'S', 'F'))
)
;

-- Add keys for table UNA.Adm_Proyecto

ALTER TABLE UNA.Adm_Proyecto ADD CONSTRAINT PK_Adm_Proyecto PRIMARY KEY (pro_id)
;

-- Table UNA.Adm_Administrador

CREATE TABLE UNA.Adm_Administrador(
  adm_id Number NOT NULL,
  adm_usuario Varchar2(30 ) NOT NULL,
  adm_contrasena Varchar2(30 ) NOT NULL,
  adm_nombre Varchar2(30 ),
  adm_apellidos Varchar2(30 ),
  adm_cedula Varchar2(30 ) NOT NULL,
  adm_correo Varchar2(50 ),
  adm_estado Varchar2(1 ) NOT NULL,
  adm_version Number DEFAULT 1,
  CONSTRAINT adm_ck_estado CHECK (adm_estado in ('A', 'I'))
)
;

-- Add keys for table UNA.Adm_Administrador

ALTER TABLE UNA.Adm_Administrador ADD CONSTRAINT PK_Adm_Administrador PRIMARY KEY (adm_id)
;

-- Table UNA.Adm_Actividad

CREATE TABLE UNA.Adm_Actividad(
  act_id Number NOT NULL,
  act_encargado Varchar2(50 ) NOT NULL,
  act_fp_inicio Varchar2(30 ) NOT NULL,
  act_fp_final Varchar2(30 ) NOT NULL,
  act_fr_inicio Varchar2(30 ),
  act_fr_final Varchar2(30 ),
  act_orden Number NOT NULL,
  act_descripcion Varchar2(100 ),
  act_estado Varchar2(1 ) NOT NULL,
  act_nombre Varchar2(30 ) NOT NULL,
  act_version Number DEFAULT 1,
  pro_id Number,
  CONSTRAINT act_ck_estado CHECK (act_estado in ('1', '2', '3', '4'))
)
;

-- Create indexes for table UNA.Adm_Actividad

CREATE INDEX UNA.Adm_rel_pro_act ON UNA.Adm_Actividad (pro_id)
;

-- Add keys for table UNA.Adm_Actividad

ALTER TABLE UNA.Adm_Actividad ADD CONSTRAINT PK_Adm_Actividad PRIMARY KEY (act_id)
;

-- Table UNA.Adm_Seguimiento

CREATE TABLE UNA.Adm_Seguimiento(
  seg_id Number NOT NULL,
  seg_detalle Varchar2(100 ) NOT NULL,
  seg_fecha Varchar2(30 ) NOT NULL,
  seg_porcentaje Number NOT NULL,
  seg_version Number DEFAULT 1,
  pro_id Number
)
;

-- Create indexes for table UNA.Adm_Seguimiento

CREATE INDEX UNA.Adm_rel_pro_seg ON UNA.Adm_Seguimiento (pro_id)
;

-- Add keys for table UNA.Adm_Seguimiento

ALTER TABLE UNA.Adm_Seguimiento ADD CONSTRAINT PK_Adm_Seguimiento PRIMARY KEY (seg_id)
;

-- Trigger for sequence UNA.Adm_Proyecto_seq01 for column pro_id in table UNA.Adm_Proyecto ---------
CREATE OR REPLACE TRIGGER UNA.ts_Adm_Proyecto_Adm_Proyecto_0 BEFORE INSERT
ON UNA.Adm_Proyecto FOR EACH ROW
BEGIN
	if :new.pro_id is null or :new.pro_id = 0 then
		:new.pro_id := UNA.Adm_Proyecto_seq01.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER UNA.tsu_Adm_Proyecto_Adm_Proyect_0 AFTER UPDATE OF pro_id
ON UNA.Adm_Proyecto FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column pro_id in table UNA.Adm_Proyecto as it uses sequence.');
END;
/
-- Trigger for sequence UNA.Adm_Administrador_seq01 for column adm_id in table UNA.Adm_Administrador ---------
CREATE OR REPLACE TRIGGER UNA.ts_Adm_Administrador_Adm_Adm_0 BEFORE INSERT
ON UNA.Adm_Administrador FOR EACH ROW
BEGIN
	if :new.adm_id is null or :new.adm_id = 0 then
		:new.adm_id := UNA.Adm_Administrador_seq01.nextval;
	end if;		
END;
/
CREATE OR REPLACE TRIGGER UNA.tsu_Adm_Administrador_Adm_Ad_0 AFTER UPDATE OF adm_id
ON UNA.Adm_Administrador FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column adm_id in table UNA.Adm_Administrador as it uses sequence.');
END;
/
-- Trigger for sequence UNA.Adm_Actividad_seq01 for column act_id in table UNA.Adm_Actividad ---------
CREATE OR REPLACE TRIGGER UNA.ts_Adm_Actividad_Adm_Activid_0 BEFORE INSERT
ON UNA.Adm_Actividad FOR EACH ROW
BEGIN
	if :new.act_id is null or :new.act_id = 0 then
		:new.act_id := UNA.Adm_Actividad_seq01.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER UNA.tsu_Adm_Actividad_Adm_Activi_0 AFTER UPDATE OF act_id
ON UNA.Adm_Actividad FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column act_id in table UNA.Adm_Actividad as it uses sequence.');
END;
/
-- Trigger for sequence UNA.Adm_Seguimiento_seq01 for column seg_id in table UNA.Adm_Seguimiento ---------
CREATE OR REPLACE TRIGGER UNA.ts_Adm_Seguimiento_Adm_Segui_0 BEFORE INSERT
ON UNA.Adm_Seguimiento FOR EACH ROW
BEGIN
	if :new.seg_id is null or :new.seg_id = 0 then
		:new.seg_id := UNA.Adm_Seguimiento_seq01.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER UNA.tsu_Adm_Seguimiento_Adm_Segu_0 AFTER UPDATE OF seg_id
ON UNA.Adm_Seguimiento FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column seg_id in table UNA.Adm_Seguimiento as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE UNA.Adm_Seguimiento ADD CONSTRAINT Adm_rel_pro_seg FOREIGN KEY (pro_id) REFERENCES UNA.Adm_Proyecto (pro_id)
;


ALTER TABLE UNA.Adm_Actividad ADD CONSTRAINT adm_rel_pro_act FOREIGN KEY (pro_id) REFERENCES UNA.Adm_Proyecto (pro_id)
;

ALTER TABLE UNA.Adm_Proyecto ADD CONSTRAINT Adm_Pro_Adm FOREIGN KEY (adm_id) REFERENCES UNA.Adm_Administrador (adm_id)
;


-- Grant permissions section -------------------------------------------------


