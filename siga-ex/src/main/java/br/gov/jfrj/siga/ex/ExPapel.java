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
package br.gov.jfrj.siga.ex;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import br.gov.jfrj.siga.base.Texto;

@Entity
@BatchSize(size = 500)
@Table(name = "EX_PAPEL", catalog = "SIGA")
public class ExPapel extends AbstractExPapel {
	
	private static final long serialVersionUID = 2096492527289909346L;

	final static public long PAPEL_GESTOR = 1;

	final static public long PAPEL_INTERESSADO = 2;
	
	final static public long PAPEL_FISCAL_ADMINISTRATIVO = 3;
	
	final static public long PAPEL_FISCAL_TECNICO = 4;
	
	final static public long PAPEL_LIQUIDANTE = 5;
	
	final static public long PAPEL_AUTORIZADOR = 6;

	final static public long PAPEL_REVISOR = 7;

	public String getComoNomeDeVariavel() {
		String s = getDescPapel().trim().toLowerCase();
		s = Texto.removeAcento(s);
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch >='a' && ch <='z') {
				sb.append(ch);
			} else if (ch == ' ' || ch == '-' || ch == '/'){
				sb.append('_');
			}
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		if (getDescPapel() == null)
			return null;
		return getComoNomeDeVariavel();
	}
}
