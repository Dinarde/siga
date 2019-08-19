package br.gov.jfrj.siga.ex.util.predicate;



public abstract class AbstractTpMovimentacaoPredicator implements TpMovimentacaoPredicator {
	
	public TpMovimentacaoPredicator and(final TpMovimentacaoPredicator otherPredicator) {
		return new TpMovimentacaoPredicator(){
			@Override
			public boolean accept(long value) {
				return AbstractTpMovimentacaoPredicator.this.accept(value) && otherPredicator.accept(value);
			}
			
			@Override
			public boolean notAccept(long value) {
				return AbstractTpMovimentacaoPredicator.this.notAccept(value) && otherPredicator.notAccept(value);
			}
		};
	}
	
	public TpMovimentacaoPredicator or(final TpMovimentacaoPredicator otherPredicator) {
		return new TpMovimentacaoPredicator(){
			@Override
			public boolean accept(long value) {
				return AbstractTpMovimentacaoPredicator.this.accept(value) || otherPredicator.accept(value);
			}
			
			@Override
			public boolean notAccept(long value) {
				return AbstractTpMovimentacaoPredicator.this.notAccept(value) || otherPredicator.notAccept(value);
			}
		};
	}

}