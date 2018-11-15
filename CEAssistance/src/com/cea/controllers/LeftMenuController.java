package com.cea.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cea.form.UserForm;
import com.cea.services.CompaniesService;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;

@Controller
public class LeftMenuController {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	
	@Autowired
	private CompaniesService companiesService;
	
	@RequestMapping(value="/viewCalendar", method = RequestMethod.GET)
	public String  viewCalendar(HttpServletRequest request) throws Exception
		{
		ModelAndView modelAndView=null;
			final String METHOD_NAME = "viewcalendar";
			ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
			List<CommonVo> commonVo=companiesService.retriveCompanyDetails(request.getParameter("userId"));
	        request.setAttribute("commonVo", commonVo);
	        modelAndView=new ModelAndView();
	        modelAndView.addObject("userId",request.getParameter("userId"));
			ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		    return "jsp/viewcalendar";	
		}
	//This Method retriveAllDirectorLst Used For Get All The Director Details
	@RequestMapping(value="/retriveAllDirectorLst", method = RequestMethod.GET)
	public @ResponseBody String retriveAllDirectorLst(@RequestParam("companyId") String companyId,@RequestParam("userId") String userId) throws Exception
	{
		final String METHOD_NAME = "retriveAllDirectorLst";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		
		String response=companiesService.retriveAllDirectorLst(companyId,userId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		return response;
	}
	@RequestMapping(value="/setRemaindermails", method = RequestMethod.POST)
	public String setRemaindermails(@ModelAttribute(value="viewCalander") UserForm viewForm,HttpServletRequest request) throws Exception
	{
		final String METHOD_NAME = "setRemaindermails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int response=companiesService.setRemaindermails(viewForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		return "redirect:/viewCalendar.html?userId="+request.getParameter("userId");
	}
	@RequestMapping(value="/addDirectorInfosec", method = RequestMethod.GET)
	public String  addDirectorsInfosec(HttpServletRequest request) throws Exception
		{
			final String METHOD_NAME = "addCompaniesSec";
			ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
			request.setAttribute("noCommp", request.getParameter("NoCom"));
			request.setAttribute("hdName", request.getParameter("hdName"));
			ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		    return "jsp/AddCompInfo2";	
		}
	@RequestMapping(value="/leftPaneladdCompaniesDtls",method=RequestMethod.GET)
	public ModelAndView addCompaniesDtls(HttpServletRequest request) throws Exception
	{
		final String METHOD_NAME = "leftPaneladdCompaniesDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 List<CommonVo> commonVo=companiesService.retriveCompanyDetails(request.getParameter("userId"));
	    ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	     if(commonVo.size()!=0)
	    {
	   
	    request.setAttribute("commonVo", commonVo);
	    request.setAttribute("hdName", request.getParameter("hdName"));
	    request.setAttribute("userId", request.getParameter("userId"));
	    
	   	return new ModelAndView("jsp/addCompanyInfo");
	    }
	    else
	    {
	    	request.setAttribute("error", "No Companies Added With Login UserName");
	    return new ModelAndView("jsp/agmDate");
	    }
	}
	@RequestMapping(value="/leftAddComponyInfoDtls",method=RequestMethod.GET)
	public ModelAndView leftPanelAddComponyInfoDtls(@ModelAttribute(value="addComInfo") UserForm userForm,HttpServletRequest request) throws Exception
	{
		final String METHOD_NAME = "leftPanelAddComponyInfoDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 List<CommonVo> commonVo=companiesService.retriveCompanyDetails(request.getParameter("userId"));
	    ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	    if(commonVo.size()!=0)
	    {
	    request.setAttribute("commonVo", commonVo);
	   	return new ModelAndView("jsp/AddCompInfo2");
	    }
	    else
	    {
	    	request.setAttribute("error", "Add All Director Detials with company name");
	    return new ModelAndView("jsp/addCompanyInfo");
	    }
	}
	@RequestMapping(value="/updateDeleteCompanyDtls",method=RequestMethod.GET)
	public ModelAndView updateDeleteCompanyDtls(HttpServletRequest request) throws Exception
	{
		
		final String METHOD_NAME = "updateDeleteCompanyDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		List<CommonVo> commonVo=companiesService.retriveCompanyDetails(request.getParameter("userId"));
		request.setAttribute("commonVo", commonVo);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	    return new ModelAndView("jsp/editDeleteCompanyDtls");		
	}
	
		}


