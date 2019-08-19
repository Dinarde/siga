package br.gov.jfrj.siga.unirest.proxy;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.gov.jfrj.siga.ex.SigaExProperties;

@Startup
@Singleton
public class ExConfigUnirestProxy {
	
	@PostConstruct
	public void configProxyUnirest() {
		try {
			String host = SigaExProperties.getHostProxy();
			String sPort = SigaExProperties.getPortProxy();
			
			if (host != null && sPort != null && sPort.matches("([0-9]){1,}")) {
				/*	Se o proxy for configurado no Unirest ele será utilizado em todas as 
				 * requisições (até nas que não podem)
				 
					HttpHost proxy = new HttpHost(host, Integer.parseInt(sPort));
					Unirest.setProxy(proxy);
				*/
				GoogleRecaptcha.setProxyHost(host);
				GoogleRecaptcha.setProxyPort(Integer.parseInt(sPort));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}