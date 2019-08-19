package br.gov.jfrj.siga.ex.util.predicate;

/**
 * 	Esta classe nao usa generics para evitar o autoboxing e unboxing
 */
public interface TpMovimentacaoPredicator {
	
	/**
	 * 
	 * @param value
	 * @return true se o valor da movimentacao e aceito
	 */
	public boolean accept(long value);
	
	/**
	 * 
	 * @param value
	 * @return true se o valor da movimentacao nao e aceito
	 */
	public boolean notAccept(long value);
	
}