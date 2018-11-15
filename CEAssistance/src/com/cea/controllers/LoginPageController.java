package com.cea.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cea.services.LoginService;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;

@Controller

public class LoginPageController {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private LoginService logService;
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@RequestMapping(value="/loginuser",method=RequestMethod.POST)
	public String userLogin(@RequestParam("j_username") String uname,@RequestParam("j_password") String upwd,HttpServletRequest req,HttpSession session,Model model) throws Exception
	{
		final String METHOD_NAME="userLogin";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=logService.userLogin(uname,upwd);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		CommonVo commonVo=null;
		if(result!=0)
		{
			commonVo=new CommonVo();
			ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, "retriveUserDtls", CeaConstants.ENTRY);
			commonVo=logService.retriveUserDtls(uname);	
			req.setAttribute("date", commonVo.getRegDate());
			req.setAttribute("mail", commonVo.getEmail());
			req.setAttribute("mobile", commonVo.getMobile());
			//req.setAttribute("userType", commonVo.getPaymentStatus());
			session.setAttribute("userType",commonVo.getPaymentStatus());
			session.setAttribute("userId",commonVo.getUserId());
			session.setAttribute("uName", commonVo.getFristName()+"&nbsp;&nbsp;&nbsp;&nbsp;"+commonVo.getLastName());
			ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, "retriveUserDtls", CeaConstants.EXIT);
			req.setAttribute("error", "");
		return "jsp/profileOne";
		}
		else
		{
			req.setAttribute("error", "Email id or Password Was Wrong");
			/*session.setAttribute("userId","");
			session.setAttribute("uName", "");*/
			return "jsp/home";	
			
		}
	}
	@RequestMapping(value="/logOut",method=RequestMethod.POST)
	public String logOut(HttpServletRequest request)
	{
		final String METHOD_NAME="logOut";
		HttpSession session=request.getSession();
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		session.invalidate();
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return "jsp/home";
		
	}
	}
