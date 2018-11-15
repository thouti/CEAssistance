package com.cea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;

@Controller
public class HomePageController {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
public String homePage()
	{
		final String METHOD_NAME="homePage";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/home";
	}
	
	@RequestMapping(value="/partnerWithUs",method=RequestMethod.GET)
	public String partnerWithUs()
	{
		final String METHOD_NAME="partnerWithUs";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/partnerWithUs";
	}
	@RequestMapping(value="/aboutUs",method=RequestMethod.GET)
	public String aboutUs()
	{
		final String METHOD_NAME="aboutUs";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/aboutUs";
	}
	@RequestMapping(value="/contactUs",method=RequestMethod.GET)
	public String contactUs()
	{
		final String METHOD_NAME="contactUs";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/contactUs";
	}
	@RequestMapping(value="/howItWorks",method=RequestMethod.GET)
	public String howItWorks()
	{
		final String METHOD_NAME="howItWorks";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/howItWorks";
	}
	
}
