package br.com.canalbrasil2.builder;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class WebClientBuilder {

	public static WebClient build()
	{
		WebClient instance = new WebClient(BrowserVersion.CHROME);
		instance.getOptions().setThrowExceptionOnFailingStatusCode(false);
		instance.getOptions().setThrowExceptionOnScriptError(false);
		instance.getOptions().setCssEnabled(false);
		instance.getOptions().setJavaScriptEnabled(false);
		
		return instance;
	}
}
