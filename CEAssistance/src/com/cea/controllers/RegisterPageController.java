 package com.cea.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cea.form.UserForm;
import com.cea.services.RegisterService;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.util.CommonUtill;
import com.cea.vo.CommonVo;



@Controller
public class RegisterPageController {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	
	@Autowired
	private RegisterService registerService;
	@Autowired
	private CeaLogMgr ceaLogMgr;
	
	@Autowired
	private CommonUtill utill;
	
	@RequestMapping(value="/chkEmailId", method = RequestMethod.GET)
	public @ResponseBody String chkEmailId(@RequestParam("email") String email) throws Exception
	{
		final String METHOD_NAME = "chkEmailId";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=registerService.chkMailID(email);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	    return response;	
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String userRegister(@ModelAttribute("userForm") UserForm userForm,HttpServletRequest req,Model map,HttpSession session) throws Exception
	{
		HttpSession session2=req.getSession();
		final String METHOD_NAME="userRegister";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=registerService.userRegister(userForm);
		String userid=registerService.getUserId(userForm.getEmail());
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		if(result!=0)
		{
			String date=utill.formatDDMMYYYY().replace("/","-");
			req.setAttribute("date", date);
			session2.setAttribute("uName", userForm.getFirstName()+"&nbsp;&nbsp;&nbsp;&nbsp;"+userForm.getLastName());
			req.setAttribute("mail", userForm.getEmail());
			req.setAttribute("mobile", userForm.getMobile());
			session.setAttribute("userId",userid);
			return "jsp/profileOne";
		}
		else{
			return "jsp/home";  }
		}
	@RequestMapping(value="/userAgmdate",method=RequestMethod.GET)
	public String userAgmdate(HttpSession session,HttpServletRequest request)
	{
		final String METHOD_NAME="userAgmDate";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		request.setAttribute("userName","Guest");
		session.setAttribute("uName", "Guest");
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/guestAgmDate";
	}
	@RequestMapping(value="/userRegisterAgmdate",method=RequestMethod.GET)
	public String userRegisterAgmdate(HttpServletRequest request)
	{
		final String METHOD_NAME="userRegisterAgmdate";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		request.setAttribute("userName",request.getParameter("hdName"));
		request.setAttribute("userId",request.getParameter("userId"));
		request.setAttribute("userType",request.getParameter("userType"));
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/agmDate";	
	}
	@RequestMapping(value="/retriveUserDetails",method=RequestMethod.GET)
	public String retriveUserDetails(HttpServletRequest request) throws Exception
	{
		CommonVo commonVo=null;
		final String METHOD_NAME="retriveUserDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		commonVo=registerService.retriveUserDtls(request.getParameter("userId"));
		request.setAttribute("userType",request.getParameter("userType"));
		request.setAttribute("commonVo", commonVo);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/userProfileDetails";
	}
	@RequestMapping(value="/loginForgotPassword",method=RequestMethod.GET)
	public ModelAndView forgotPassword(HttpServletRequest request) throws Exception
	{
		final String METHOD_NAME="forgotPassword";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return new ModelAndView("jsp/forgotPassword");
	}
	@RequestMapping(value="/chkRegisteredEmailId", method = RequestMethod.GET)
	public @ResponseBody String chkRegisteredEmailId(@RequestParam("emailId") String emailId) throws Exception
	{
		final String METHOD_NAME = "chkRegisteredEmailId";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=registerService.chkRegisteredEmailId(emailId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	    return response;	
	}
	@RequestMapping(value="/sendPassword", method = RequestMethod.POST)
	public String sendPassword(@RequestParam("emailId") String emailId) throws Exception
	{
		final String METHOD_NAME="sendPassword";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=registerService.sendPassword(emailId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		if(result!=0)
		{
			return "jsp/succesfullySentPassword";	
		}
		else
		{
			return "jsp/forgotPassword";	
		}
	}
	
	
}

