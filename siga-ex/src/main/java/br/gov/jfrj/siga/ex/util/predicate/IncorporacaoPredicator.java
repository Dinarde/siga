package br.gov.jfrj.siga.ex.util.predicate;

import br.gov.jfrj.siga.ex.ExTipoMovimentacao;

public class IncorporacaoPredicator implements TpMovimentacaoPredicator {
	
	@Override
	public boolean accept(long value) {
		return value == ExTipoMovimentacao.TIPO_MOVIMENTACAO_INCORPORACAO;
	};
	
	@Override
	public boolean notAccept(long value) {
		return value == ExTipoMovimentacao.TIPO_MOVIMENTACAO_CANCELAMENTO_INCORPORACAO;
	}
	
}