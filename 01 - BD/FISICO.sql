-- Gera��o de Modelo f�sico
-- Sql ANSI 2003 - brModelo.

DROP DATABASE mktstu21_breno;

USE mktstu21_breno;

CREATE TABLE AMBIENTES (
AMB_ID INTEGER AUTO_INCREMENT,
AMB_NOME VARCHAR(100),
AMB_PORTA_ARDUINO VARCHAR(5),
CAS_ID INTEGER,
PRIMARY KEY (AMB_ID, CAS_ID)
);

CREATE TABLE SOS (
SOS_ID INTEGER AUTO_INCREMENT,
SOS_MENSAGEM VARCHAR(250),
SOS_CEL2 VARCHAR(20),
SOS_CEL1 VARCHAR(20),
SOS_CEL3 VARCHAR(20),
USU_ID INTEGER,
PRIMARY KEY (SOS_ID, USU_ID)
);

CREATE TABLE DETECCOES_MOVIMENTO (
MOV_ID INTEGER AUTO_INCREMENT,
MOV_ULTIMA_DETECCAO TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
AMB_ID INTEGER,
PRIMARY KEY (MOV_ID, AMB_ID),
FOREIGN KEY(AMB_ID) REFERENCES AMBIENTES (AMB_ID)
);

CREATE TABLE CASA (
CAS_ID INTEGER AUTO_INCREMENT,
CAS_SENSOR_LIGADO CHAR(1),
CAS_MODO_MONITORAMENTO CHAR(1),
USU_ID INTEGER,
PRIMARY KEY (CAS_ID, USU_ID)
);

CREATE TABLE USUARIOS (
USU_ID INTEGER AUTO_INCREMENT,
USU_NOME_USUARIO VARCHAR(50),
USU_NOME VARCHAR(100),
USU_SENHA VARCHAR(50),
USU_SOBRENOME VARCHAR(100),
USU_CELULAR VARCHAR(20),
PRIMARY KEY (USU_ID)
);

ALTER TABLE AMBIENTES ADD FOREIGN KEY(CAS_ID) REFERENCES CASA (CAS_ID);
ALTER TABLE SOS ADD FOREIGN KEY(USU_ID) REFERENCES USUARIOS (USU_ID);
ALTER TABLE CASA ADD FOREIGN KEY(USU_ID) REFERENCES USUARIOS (USU_ID);