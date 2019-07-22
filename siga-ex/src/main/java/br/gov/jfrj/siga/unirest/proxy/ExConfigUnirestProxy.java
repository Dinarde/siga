package br.gov.jfrj.siga.unirest.proxy;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.http.HttpHost;

import br.gov.jfrj.siga.ex.SigaExProperties;

import com.mashape.unirest.http.Unirest;

@Startup
@Singleton
public class ExConfigUnirestProxy {
	
	@PostConstruct
	public void configProxyUnirest() {
		try {
			String host = SigaExProperties.getHostProxy();
			String sPort = SigaExProperties.getPortProxy();
			
			if (host != null && sPort != null && sPort.matches("([0-9]){1,}")) {
				int port = Integer.parseInt(sPort);
			
				HttpHost proxy = new HttpHost(host, port);
				Unirest.setProxy(proxy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}