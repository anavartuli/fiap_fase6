INSERT INTO T_SEM_TIPO_SENSOR
(cd_tipo_sensor,
tx_descricao)
VALUES
(SQ_CD_TIPO_SENSOR.nextval,
'Sensor de Fluxo de Veiculo');

INSERT INTO T_SEM_TIPO_SENSOR
(cd_tipo_sensor,
tx_descricao)
VALUES
(SQ_CD_TIPO_SENSOR.nextval,
'Sensor de Dispositivo');

INSERT INTO T_SEM_TIPO_SENSOR
(cd_tipo_sensor,
tx_descricao)
VALUES
(SQ_CD_TIPO_SENSOR.nextval,
'Sensor Climatico');

COMMIT;

INSERT INTO T_SEM_DISPOSITIVO
(cd_dispositivo,
tx_descricao,
pr_prioridade_verde)
VALUES
(SQ_CD_DISPOSITIVO.nextval,
'Dispositivo de Pedestre Preferencial',
'N');

INSERT INTO T_SEM_DISPOSITIVO
(cd_dispositivo,
tx_descricao,
pr_prioridade_verde)
VALUES
(SQ_CD_DISPOSITIVO.nextval,
'Dispositivo de Veiculo Preferencial',
'Y');

COMMIT;

INSERT INTO T_SEM_SENSOR
(cd_sensor,
tx_descricao,
T_SEM_TIPO_SEN_cd_tipo_sen)
VALUES
(SQ_CD_SENSOR.nextval,
'Sensor de fluxo de veiculos Av. Paulista com Angelica',
'1');

INSERT INTO T_SEM_SENSOR
(cd_sensor,
tx_descricao,
T_SEM_TIPO_SEN_cd_tipo_sen)
VALUES
(SQ_CD_SENSOR.nextval,
'Sensor de dispositivo Av. Paulista com Angelica',
'2');

INSERT INTO T_SEM_SENSOR
(cd_sensor,
tx_descricao,
T_SEM_TIPO_SEN_cd_tipo_sen)
VALUES
(SQ_CD_SENSOR.nextval,
'Sensor de climatico Av. Paulista com Angelica',
'3');

COMMIT;

INSERT INTO T_SEM_SEMAFORO
(cd_semaforo,
lg_logradouro,
lg_numero,
lg_cidade,
lg_estado,
tm_tempo_verde,
tm_tempo_amarelo,
tm_tempo_vermelho)
VALUES
(SQ_CD_SEMAFORO.nextval,
'Avenida Paulista',
'2598',
'Sao Paulo',
'Sao Paulo',
120,
5,
60);

COMMIT;

--SELECT * FROM T_SEM_CONTROLADORA
--
--SELECT * FROM T_SEM_SENSOR
--
--SELECT * FROM T_SEM_SEMAFORO
--
--SELECT * FROM T_SEM_DISPOSITIVO

----========================================================
---- TESTES DE DISPARO DA TRIGGER
----========================================================
---- TESTE EVENTO DISPOSITIVO PEDESTRE
--INSERT INTO T_SEM_CONTROLADORA
--(CD_CONTROLADORA
--DT_MOMENTO_EVENTO,
--FX_FLUXO,
--T_SEM_SEMAFORO_CD_SEMAFORO,
--T_SEM_SENSOR_CD_SENSOR,
--T_SEM_DISP_ID_CD_DISP)
--VALUES
--(SQ_CD_CONTROLADORA.nextval
--SYSDATE,
--0, -- VALOR DO FLUXO 0 POIS Ã‰ O SENSOR DE DISPOSITIVO
--1, -- ID DO SEMÃ�FORO QUE PRECISA SER ATUALIZADO
--2, -- ID DO SENSOR QUE DISPAROU O EVENTO = 2 SENSOR DE DISPOSITIVO
--1) -- ID DO DISPOSITIVO QUE ALARMOU O SENSOR = 1 PEDESTRE PREFERENCIAL
--
---- TESTE EVENTO DISPOSITIVO VEICULO PREFERENCIAL
--INSERT INTO T_SEM_CONTROLADORA
--(CD_CONTROLADORA
--DT_MOMENTO_EVENTO,
--FX_FLUXO,
--T_SEM_SEMAFORO_CD_SEMAFORO,
--T_SEM_SENSOR_CD_SENSOR,
--T_SEM_DISP_ID_CD_DISP)
--VALUES
--(SQ_CD_CONTROLADORA.nextval
--SYSDATE,
--0, -- VALOR DO FLUXO 0 POIS Ã‰ O SENSOR DE DISPOSITIVO
--1, -- ID DO SEMÃ�FORO QUE PRECISA SER ATUALIZADO
--2, -- ID DO SENSOR QUE DISPAROU O EVENTO = 2 SENSOR DE DISPOSITIVO
--2) -- ID DO DISPOSITIVO QUE ALARMOU O SENSOR = 1 VEICULO PREFERENCIAL