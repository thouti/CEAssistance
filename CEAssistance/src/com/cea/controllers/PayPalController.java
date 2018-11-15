package com.cea.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;

@Controller
public class PayPalController {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	
@RequestMapping(value="/bankPayment",method=RequestMethod.POST)
public String bankPayment(ModelMap modelMap,HttpServletRequest req)
	{
		final String METHOD_NAME="bankPayment";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		req.setAttribute("hdName", req.getParameter("hdName"));
		if(req.getParameter("hdName").equalsIgnoreCase("Guest"))
		{
	    req.setAttribute("error", "Please Register or Login With Your Credintionls");
		return "jsp/home";	
		}
		else
		{
			modelMap.addAttribute("NoCom", req.getParameter("noOfCompanies"));
			modelMap.addAttribute("totalAmt", req.getParameter("totAmt"));
			modelMap.addAttribute("userId", req.getParameter("userId"));
			return "jsp/paymentAmt";
		}
		}
}
