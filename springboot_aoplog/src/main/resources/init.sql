CREATE TABLE SYS_LOG (
   ID NUMBER(20) NOT NULL ,
   USERNAME VARCHAR2(50 BYTE) NULL ,
   OPERATION VARCHAR2(50 BYTE) NULL ,
   TIME NUMBER(11) NULL ,
   METHOD VARCHAR2(200 BYTE) NULL ,
   PARAMS VARCHAR2(500 BYTE) NULL ,
   IP VARCHAR2(64 BYTE) NULL ,
   CREATE_TIME DATE NULL
);
COMMENT ON COLUMN SYS_LOG.USERNAME IS '用户名';
COMMENT ON COLUMN SYS_LOG.OPERATION IS '用户操作';
COMMENT ON COLUMN SYS_LOG.TIME IS '响应时间';
COMMENT ON COLUMN SYS_LOG.METHOD IS '请求方法';
COMMENT ON COLUMN SYS_LOG.PARAMS IS '请求参数';
COMMENT ON COLUMN SYS_LOG.IP IS 'IP地址';
COMMENT ON COLUMN SYS_LOG.CREATE_TIME IS '创建时间';
CREATE SEQUENCE seq_sys_log START WITH 1 INCREMENT BY 1;