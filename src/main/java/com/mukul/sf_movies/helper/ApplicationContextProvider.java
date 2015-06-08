package com.mukul.sf_movies.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
 
public class ApplicationContextProvider implements ApplicationContextAware{
 
    private static ApplicationContext context;
     
    public ApplicationContext getApplicationContext() {
        return context;
    }

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
			this.context = arg0;
		
	}
     
   
}
