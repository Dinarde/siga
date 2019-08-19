-------------------------------------------------------------
--	SCRIPT: DDL da senha dos documentos e movimentacoes 		 
-------------------------------------------------------------

ALTER TABLE	SIGA.EX_DOCUMENTO ADD (SENHA_DOC VARCHAR2(10));


ALTER TABLE	SIGA.EX_MOVIMENTACAO ADD (SENHA_MOV VARCHAR2(10));