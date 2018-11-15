package com.cea.util;

import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Srinivas
 *
 */
@Component
public class CeaLogMgr {
	@Autowired
	CeaLogUtil util;
	
	public void writeToLog(String type,String className,String methodName,String message){
		if(util.LOGGER.isInfoEnabled()){
			util.LOGGER.info(className+" : "+methodName+" : "+message);
		}
	}
	public void writeToError(String type,String className,String methodName,String message){
		if(util.LOGGER.isEnabledFor(Level.ERROR)){
			util.LOGGER.info(className+" : "+methodName+" : "+message);
		}
	}
}
