<%@ page language="java" contentType="text/html; charset=UTF-8"
	buffer="64kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://localhost/jeetags" prefix="siga"%>


<siga:pagina titulo="Cadastro de Lota&ccedil;&atilde;o">

<script type="text/javascript">
	function validar() {
		var nmLotacao = document.getElementsByName('nmLotacao')[0].value;
		var siglaLotacao = document.getElementsByName('siglaLotacao')[0].value;		
		var id = document.getElementsByName('id')[0].value;
		var idLocalidade = document.getElementsByName('idLocalidade')[0].value;		
		if (nmLotacao==null || nmLotacao=="") {			
			alert("Preencha o nome da Lotação.");
			document.getElementById('nmLotacao').focus();		
		}else {
			if(siglaLotacao==null || siglaLotacao=="") {
				alert("Preencha a sigla da Lotação.");
			} else {
				if(idLocalidade == 0) {
					alert("Preencha a localidade da Lotação.");	
				} else {
					frm.submit();
				}
			}
		}			
	}

	function removerEspacoEmBranco(vlr) {
		while(vlr.indexOf(" ") != -1)
			vlr = vlr.replace(" ", "");
		return vlr;
	}

	function carregarExcel() {
		document.form.action =  "carregarExcel";
		document.form.submit();
	}
</script>

<body>

<div class="gt-bd clearfix">
	<div class="gt-content clearfix">		
		<form name="frm" action="${request.contextPath}/app/lotacao/gravar" method="POST">
			<input type="hidden" name="postback" value="1" />
			<input type="hidden" name="id" value="${id}" />
			<h1>Cadastro de Lota&ccedil;&atilde;o</h1>
			<div class="gt-content-box gt-for-table">
				<table class="gt-form-table" width="100%">
					<tr class="header">
						<td colspan="2">Dados da Lota&ccedil;&atilde;o</td>
					</tr>
					<tr><td></td></tr>
					
					<tr><td></td></tr>
					<tr>
						<td><label>&Oacute;rg&atilde;o:</label></td>
						<td>
							<c:choose>
								<c:when test="${empty id || podeAlterarOrgao}">
									<select name="idOrgaoUsu" value="${idOrgaoUsu}">
										<c:forEach items="${orgaosUsu}" var="item">
											<option value="${item.idOrgaoUsu}"
												${item.idOrgaoUsu == idOrgaoUsu ? 'selected' : ''}>
												${item.nmOrgaoUsu}</option>
										</c:forEach>
									</select>
								</c:when>
								<c:otherwise>
									${nmOrgaousu}
									<input type="hidden" name="idOrgaoUsu" value="${idOrgaoUsu}" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>				
						<td>
							<label>Nome:</label>
						</td>
						<td>
							<input type="text" id="nmLotacao" name="nmLotacao" value="${nmLotacao}" maxlength="100" size="100" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<label><font color="#9f9f9f">(Inserir nome oficial, conforme legislação. Não abreviar. Iniciar cada palavra com letra maiúscula, exceto para palavras tais como: "de", "para", etc. Exemplo: Unidade do Arquivo Público do Estado)</font></label>
						</td>
					</tr>
					<tr>				
						<td>
							<label>Sigla:</label>
						</td>
						<td>
							<input type="text" id="siglaLotacao" name="siglaLotacao" value="${siglaLotacao}" maxlength="20" size="20"  style="text-transform:uppercase" onkeyup="this.value = removerEspacoEmBranco(this.value)"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<label><font color="#9f9f9f">(Sigla: Letras maiúsculas)</font></label>
						</td>
					</tr>
					<tr>
						<td>
							Localidade:
						</td>
						<td>
							<select name="idLocalidade" value="${idLocalidade}">
								<option value="0">Selecione</option>
								<c:forEach items="${listaLocalidades}" var="item">
									<option value="${item.id}"
										${item.id == idLocalidade ? 'selected' : ''}>
										${item.descricao}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							Situa&ccedil;&atilde;o:
						</td>
						<td>
							<input type="radio" name="situacao" value="true" id="situacaoAtivo" ${empty dtFimLotacao ? 'checked' : ''}/>Ativo
							<input type="radio" name="situacao" value="false" id="situacaoInativo" ${not empty dtFimLotacao ? 'checked' : ''}/>Inativo
						</td>
					</tr>
					<c:if test="${empty id}">
						<tr class="button">
							<td>Carregar planilha para inserir múltiplos registros:</td>
							<td><input type="button" value="Carregar planilha" onclick="javascript:location.href='/siga/app/lotacao/carregarExcel';" class="gt-btn-medium gt-btn-left" /></td>
						</tr>
					</c:if>
					<tr class="button">
						<td>
							<input type="button" value="Ok" onclick="javascript: validar();" class="gt-btn-large gt-btn-left" /> 
							<input type="button" value="Cancela" onclick="javascript:location.href='/siga/app/lotacao/listar';" class="gt-btn-medium gt-btn-left" />
						</td>
					</tr>
				</table>
			</div>
			<br />
		</form>
	</div>
</div>

</body>

</siga:pagina>