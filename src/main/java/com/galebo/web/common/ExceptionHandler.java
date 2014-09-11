package com.galebo.web.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;


public class ExceptionHandler {
	
	public static List<Class<?>> knows=new ArrayList<Class<?>>();
	
	public static class KnowException extends RuntimeException {

		public KnowException(String string) {
			super(string);
		}
		private static final long serialVersionUID = 1437550483598552765L;
	}
	static{
		knows.add(KnowException.class);
	}
	private static final Logger exceptionLog=Logger.getLogger(ExceptionHandler.class);
	private static final Logger knowExceptionLog=Logger.getLogger(KnowException.class);
	private Log log  ;
	
	public ExceptionHandler(Log log) {
		super();
		this.log = log;
	}

	public void handleNoThrowNew(Exception e) {
		handle(e, false/* ifThrowNew */, true/* save2DB */);
	}

	public void handle(Exception e) {
		handle(e, true/* ifThrowNew */, true/* save2DB */);
	}
	
	private void handle(Exception e,boolean ifThrowNew,boolean save2DB) {
		boolean isKonw=false;
		for ( Class<?> _class: knows) {
			if(e.getClass().equals(_class)){
				log.warn("busiLog Trace:"+e.getMessage());
				knowExceptionLog.warn("busiLog Trace:"+e.getMessage());
				isKonw=true;
				break;
			}
		}
		if(!isKonw){
			log.info("busiLog Trace:",e);
			exceptionLog.info("exceptionLog Trace:", e);
		}
		
		if (ifThrowNew) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
