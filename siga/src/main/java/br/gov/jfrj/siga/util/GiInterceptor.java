package br.gov.jfrj.siga.util;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.util.jpa.JPATransactionInterceptor;
import br.gov.jfrj.siga.cp.bl.Cp;
import br.gov.jfrj.siga.dp.dao.CpDao;
import br.gov.jfrj.siga.model.ContextoPersistencia;
import br.gov.jfrj.siga.model.dao.ModeloDao;

@Component
@Intercepts(before = JPATransactionInterceptor.class)
public class GiInterceptor implements Interceptor {

	private final EntityManager manager;
	private final Validator validator;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext context;

	public GiInterceptor(EntityManager manager, Validator validator,
			ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		this.manager = manager;
		this.validator = validator;
		this.request = request;
		this.response = response;
		this.context = context;
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object instance) {

		ContextoPersistencia.setEntityManager(this.manager);
		
		ModeloDao.freeInstance();
		CpDao.getInstance();
		try {
			Cp.getInstance().getConf().limparCacheSeNecessario();
		} catch (Exception e1) {
			throw new RuntimeException(
					"Não foi possível atualizar o cache de configurações", e1);
		}

		try {
			stack.next(method, instance);
		} finally {
			ContextoPersistencia.setEntityManager(null);
		}
	}

	public boolean accepts(ResourceMethod method) {
		return true; // Will intercept all requests
	}
}