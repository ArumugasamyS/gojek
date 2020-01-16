package com.midtrans.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MidTransLogger 

{	static Logger log = LogManager.getLogger();
	
	public static void info(String message) {
		log.info(message);		
	}

	public void error(String message) {
		log.info(message);		
	}

	public void fatal(String message) {

		log.info(message);		
	}
	public void error(String message, Throwable error) {

		log.error(message + " ErrorMessage=" + error.getMessage(), error);
	}

} 





