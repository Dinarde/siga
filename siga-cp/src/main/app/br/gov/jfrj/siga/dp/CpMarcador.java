/*******************************************************************************
 * Copyright (c) 2006 - 2011 SJRJ.
 * 
 *     This file is part of SIGA.
 * 
 *     SIGA is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     SIGA is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with SIGA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
/*
 * Criado em  21/12/2005
 *
 */
package br.gov.jfrj.siga.dp;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.gov.jfrj.siga.model.ActiveRecord;

@Entity
@Table(name = "CP_MARCADOR", schema = "CORPORATIVO")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class CpMarcador extends AbstractCpMarcador {

	final static public long MARCADOR_EM_ELABORACAO = 1;

	final static public long MARCADOR_EM_ANDAMENTO = 2;

	final static public long MARCADOR_A_RECEBER = 3;

	final static public long MARCADOR_EXTRAVIADO = 4;

	final static public long MARCADOR_A_ARQUIVAR = 5;

	final static public long MARCADOR_ARQUIVADO_CORRENTE = 6;

	final static public long MARCADOR_A_ELIMINAR = 7;

	final static public long MARCADOR_ELIMINADO = 8;

	final static public long MARCADOR_JUNTADO = 9;

	final static public long MARCADOR_JUNTADO_EXTERNO = 16;

	final static public long MARCADOR_CANCELADO = 10;

	final static public long MARCADOR_TRANSFERIDO_A_ORGAO_EXTERNO = 11;

	final static public long MARCADOR_ARQUIVADO_INTERMEDIARIO = 12;

	final static public long MARCADOR_CAIXA_DE_ENTRADA = 14;

	final static public long MARCADOR_ARQUIVADO_PERMANENTE = 13;

	final static public long MARCADOR_PENDENTE_DE_ASSINATURA = 15;

	final static public long MARCADOR_JUNTADO_A_DOCUMENTO_EXTERNO = 16;

	final static public long MARCADOR_A_REMETER_PARA_PUBLICACAO = 17;

	final static public long MARCADOR_REMETIDO_PARA_PUBLICACAO = 18;

	final static public long MARCADOR_A_REMETER_MANUALMENTE = 19;

	final static public long MARCADOR_PUBLICADO = 20;

	final static public long MARCADOR_PUBLICACAO_SOLICITADA = 21;

	final static public long MARCADOR_DISPONIBILIZADO = 22;

	final static public long MARCADOR_EM_TRANSITO = 23;

	final static public long MARCADOR_EM_TRANSITO_ELETRONICO = 24;

	final static public long MARCADOR_COMO_SUBSCRITOR = 25;

	final static public long MARCADOR_APENSADO = 26;

	public static final long MARCADOR_COMO_GESTOR = 27;

	public static final long MARCADOR_COMO_INTERESSADO = 28;

	final static public long MARCADOR_DESPACHO_PENDENTE_DE_ASSINATURA = 29;

	final static public long MARCADOR_ANEXO_PENDENTE_DE_ASSINATURA = 30;

	final static public long MARCADOR_SOBRESTADO = 31;

	final static public long MARCADOR_SEM_EFEITO = 32;

	final static public long MARCADOR_ATIVO = 36;

	final static public long MARCADOR_NOVO = 37;

	final static public long MARCADOR_POPULAR = 38;

	final static public long MARCADOR_REVISAR = 39;

	final static public long MARCADOR_TOMAR_CIENCIA = 40;

	final static public long MARCADOR_SOLICITACAO_A_RECEBER = 41;

	final static public long MARCADOR_SOLICITACAO_EM_ANDAMENTO = 42;

	final static public long MARCADOR_SOLICITACAO_FECHADO = 43;

	final static public long MARCADOR_SOLICITACAO_PENDENTE = 44;

	final static public long MARCADOR_SOLICITACAO_CANCELADO = 45;

	final static public long MARCADOR_SOLICITACAO_PRE_ATENDIMENTO = 46;

	final static public long MARCADOR_SOLICITACAO_POS_ATENDIMENTO = 47;

	final static public long MARCADOR_SOLICITACAO_COMO_CADASTRANTE = 48;

	final static public long MARCADOR_SOLICITACAO_COMO_SOLICITANTE = 49;

	final static public long MARCADOR_RECOLHER_PARA_ARQUIVO_PERMANENTE = 50;

	final static public long MARCADOR_TRANSFERIR_PARA_ARQUIVO_INTERMEDIARIO = 51;

	final static public long MARCADOR_EM_EDITAL_DE_ELIMINACAO = 52;

	final static public long MARCADOR_SOLICITACAO_FECHADO_PARCIAL = 53;

	final static public long MARCADOR_SOLICITACAO_EM_CONTROLE_QUALIDADE = 54;

	final static public long MARCADOR_A_DEVOLVER = 56;

	final static public long MARCADOR_AGUARDANDO = 57;

	final static public long MARCADOR_A_DEVOLVER_FORA_DO_PRAZO = 58;

	final static public long MARCADOR_AGUARDANDO_DEVOLUCAO_FORA_DO_PRAZO = 59;

	final static public long MARCADOR_PENDENTE_DE_ANEXACAO = 60;

	final static public long MARCADOR_SOLICITACAO_EM_ELABORACAO = 61;

	final static public long MARCADOR_DOCUMENTO_ASSINADO_COM_SENHA = 62;

	final static public long MARCADOR_MOVIMENTACAO_ASSINADA_COM_SENHA = 63;

	final static public long MARCADOR_MOVIMENTACAO_CONFERIDA_COM_SENHA = 64;

	final static public long MARCADOR_SOLICITACAO_FORA_DO_PRAZO = 65;

	final static public long MARCADOR_SOLICITACAO_ATIVO = 66;

	final static public long MARCADOR_PENDENTE_DE_COLABORACAO = 67;

	final static public long MARCADOR_FINALIZAR_DOCUMENTO_COLABORATIVO = 68;

	final static public long MARCADOR_SOLICITACAO_NECESSITA_PROVIDENCIA = 69;

	final static public long MARCADOR_COMO_EXECUTOR = 70;

	final static public long MARCADOR_PRONTO_PARA_ASSINAR = 71;

	public static final long MARCADOR_COMO_REVISOR = 72;
	
	final static public long MARCADOR_URGENTE = 1000;

	final static public long MARCADOR_IDOSO = 1001;

	final static public long MARCADOR_RETENCAO_INSS = 1002;

	public static ActiveRecord<CpMarcador> AR = new ActiveRecord<>(CpMarcador.class);

	public CpMarcador() {
		super();
	}
}