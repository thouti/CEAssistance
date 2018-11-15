package com.cea.util;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Srinivas
 *
 */
@Component
public class CeaLogUtil {

	static Logger LOGGER = null;
	static {
		LOGGER  = Logger.getLogger("com.cea");
	}
	public static Logger getLOGGER() {
		return LOGGER;
	}
	public static void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	}
	
}
