<!DOCTYPE1 HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	buffer="64kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://localhost/customtag" prefix="tags"%>
<%@ taglib uri="http://localhost/jeetags" prefix="siga"%>

<siga:pagina titulo="Incorporar Documento">
	<c:if test="${not mob.doc.eletronico}">
		<script type="text/javascript">$("html").addClass("fisico");$("body").addClass("fisico");</script>
	</c:if>
	<script> 
		function confirmarIncorporacao() {
			return confirm('Deseja realmente incorporar este documento ?');
		}
	</script>
	<div class="container-fluid">
	    <div class="card bg-light mb-3">
	        <div class="card-header">
	            <h2>Incorporação de Documento - ${mob.siglaEDescricaoCompleta}</h2>
	        </div>
	        <div class="card-body">
	            <form action="incorporar_gravar" enctype="multipart/form-data" cssClass="form" method="POST" onsubmit="return confirmarIncorporacao()">
	                <input type="hidden" name="postback" value="1" />
	                <input type="hidden" name="sigla" value="${sigla}" />
	                <c:choose>
	                    <c:when test="${!doc.eletronico}">
	                        <div class="row">
	                            <div class="col-sm-2">
									<div class="form-group">
										<label>Data</label>
										<input type="text" name="dtMovString" value="${dtMovString}" onblur="javascript:verifica_data(this, true);" class="form-control" />
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>Responsável</label>
										<siga:selecao tema="simple" propriedade="subscritor" modulo="siga" />
									</div>
								</div>
								<div class="col-sm-2">
									<div class="form-group">
										<div class="form-check form-check-inline mt-4">
											<input type="checkbox" theme="simple" name="substituicao" value="${substituicao}" onclick="javascript:displayTitular(this);" />
											<label class="form-check-label" for="substituicao">Substituto</label>
										</div>
									</div>
								</div>
							</div>
							<div class="row" id="tr_titular" style="display:${substituicao? '': 'none'}">
								<div class="col-sm-6">
									<div class="form-group">
										<label>Titular</label>
										<input type="hidden" name="campos" value="titularSel.id" />
										<siga:selecao propriedade="titular" tema="simple" modulo="siga" />
									</div>
								</div>
							</div>
	                    </c:when>
	                </c:choose>
					<div class="row">
	                    <div class="col-sm-6">
	                        <div class="form-group">
	                            <label>Documento</label>
	                            <siga:escolha id="idDocumentoEscolha" var="idDocumentoEscolha">
	                                <siga:opcao id='1' texto="Documento Interno">
	                                    <p></p>
	                                    <siga:selecao tema='simple' titulo="Documento Pai:" propriedade="documentoRef" urlAcao="buscar" urlSelecionar="selecionar" modulo="sigaex" paramList="tipo_operacao=incorporacao;primeiraVez=sim" />
	                                </siga:opcao>
	                            </siga:escolha>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="col-sm-2">
	                        <div class="form-group">
	                            <input type='submit' value="Ok" class="btn btn-primary" />
	                            <input type="button" value="Cancela" onclick="javascript:history.back();" class="btn btn-default" />
	                        </div>
	                    </div>
	                </div>
				</form>
			</div>
		</div>
	</div>
</siga:pagina>
