package com.cea.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cea.form.CompanyInfoTwo;
import com.cea.form.UserForm;
import com.cea.services.CompaniesService;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.util.CommonUtill;
import com.cea.vo.CommonVo;



@Controller
public class AddCompaniesController {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	
	@Autowired
	private CompaniesService companiesService;
	@Autowired
	private CeaLogMgr ceaLogMgr;
	
	@Autowired
	private CommonUtill utill;
	
@RequestMapping(value="/addCompaniesFront", method = RequestMethod.POST)
public String  addCompaniesFront(HttpServletRequest request) throws Exception
	{
		final String METHOD_NAME = "addCompaniesFront";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		request.setAttribute("noCommp", request.getParameter("NoCom"));
		request.setAttribute("hdName", request.getParameter("hdName"));
		request.setAttribute("userId", request.getParameter("userId"));
		
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	    return "jsp/addCompanies";	
	}


@RequestMapping(value="/addCompaniesDtls",method=RequestMethod.POST)
public ModelAndView addCompaniesDtls(HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "addCompaniesDtlsOne";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	    int result=companiesService.addCompnayDetails(request.getParameter("finalData"),request.getParameter("userId"));
    ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
    
    if(result!=0)
    {
    List<CommonVo> commonVo=companiesService.retriveCompanyDetails(request.getParameter("userId"));
    request.setAttribute("commonVo", commonVo);
    request.setAttribute("hdName", request.getParameter("hdName"));
    request.setAttribute("userId", request.getParameter("userId"));
    
   	return new ModelAndView("jsp/addCompanyInfo");
    }
    else
    {
    return new ModelAndView("jsp/addCompanies");
    }
}
@RequestMapping(value="/checkDirectorsList",method=RequestMethod.GET)
public @ResponseBody String checkDirectorsList(@RequestParam("companyId") String companyId) throws Exception
{
final String METHOD_NAME = "checkDirectorsList";
ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
String result=companiesService.checkDirectorsList(companyId);
ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
return result;
}
@RequestMapping(value="/addComponyInfoDtls",method=RequestMethod.POST)
public ModelAndView addComponyInfoDtls(@ModelAttribute(value="addComInfo") UserForm userForm,HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "addComponyInfoDtls";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result=companiesService.addComponyInfoDtls(userForm);
    ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
    if(result!=0)
    {
    	
        request.setAttribute("hdName", request.getParameter("hdName"));
        request.setAttribute("userId", request.getParameter("userId"));
        List<CommonVo> commonVo=companiesService.retriveCompanyDetails(request.getParameter("userId"));
        request.setAttribute("commonVo", commonVo);
   	return new ModelAndView("jsp/AddCompInfo2");
    }
    else
    {
    return new ModelAndView("jsp/addCompanyInfo");
    }
}
@RequestMapping(value="/retriveDirectorLst",method=RequestMethod.GET)
public @ResponseBody String retriveDirectorLst(@RequestParam("companyId") String companyId,HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "retriveDirectorLst";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	String result=companiesService.retriveDirectorLst(companyId);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
return result;
}
@RequestMapping(value="/getDirectorData",method=RequestMethod.GET)
public @ResponseBody String getDirectorData(@RequestParam("directorId") String directorId,HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "retriveDirectorLst";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	String result=companiesService.getDirectorData(directorId);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
return result;
}

@RequestMapping(value="/addComponyBmPostBmDtls",method=RequestMethod.POST)
public ModelAndView addComponyBmPostBmDtls(@ModelAttribute(value="addinfotwo") CompanyInfoTwo companyInfoTwo,HttpServletRequest request) throws Exception
{
	
	request.setAttribute("hdComId", request.getParameter("hdComId"));
	final String METHOD_NAME = "addComponyBmPostBmDtls";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result=companiesService.addComponyBmPostBmDtls(companyInfoTwo);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	if(result!=0)
	{
		
		request.setAttribute("userId", request.getParameter("userId"));
		return new ModelAndView("jsp/successAddComInfo");	
	}
	 else
	    {
			return new ModelAndView("jsp/AddCompInfo2");
	    }
}

//return new ModelAndView("jsp/successAddComInfo");
@RequestMapping(value="/addAnotherComponyInfoDtls",method=RequestMethod.GET)
public ModelAndView addCompanyInfoFrontPage(HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "addCompanyInfoFrontPage";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	List<CommonVo> commonVo=companiesService.retriveCompanyDetails(request.getParameter("userId"));
	request.setAttribute("commonVo", commonVo);	
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	 return new ModelAndView("jsp/addCompanyInfo");
}
@RequestMapping(value="/downloadWordDocument",method=RequestMethod.GET)
public ModelAndView downloadWordDocument(HttpServletRequest request,HttpSession session) throws Exception
{
	final String METHOD_NAME = "downloadWordDocument";
	ModelAndView modelAndView=new ModelAndView();
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	String userid=request.getParameter("userId");
	String dirID=request.getParameter("retiredDirName");
	String compId=request.getParameter("compId");
	String statutaryDirec=request.getParameter("statutaryDirec");
	String hda2=request.getParameter("hda2");
	String hda3=request.getParameter("hda3");
	String hda8=request.getParameter("hda8");
	String hda6=request.getParameter("hda6");
	String date=request.getParameter("date");
	String hdstaType=request.getParameter("hdstaType");
	String hdnature=request.getParameter("hdnature");
	String hdFirmRegNo=request.getParameter("hdFirmRegNo");
	
    String response=companiesService.downloadWordDocument(userid,dirID,compId,statutaryDirec,hda2,hdstaType,hdnature,hdFirmRegNo,hda3,hda8,hda6,date);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	if(response!=null)
	{
		request.setAttribute("response", response);
		session.setAttribute("templateName", request.getParameter("templateName"));
		modelAndView.setViewName("jsp/msword");	
	}
	
	return modelAndView;
}
@RequestMapping(value="/retriveAllCompanyDetails")
public ModelAndView  retriveAllCompanyDetails(HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "retriveAllCompanyDetails";
	ModelAndView modelAndView=new ModelAndView();
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	String cid=request.getParameter("companyName").split("-")[1];
	CommonVo commonVo=companiesService.retriveAllCompanyDetails(cid);
	request.setAttribute("userCompanyDetails", commonVo);
	List<CommonVo> commonVoList=companiesService.getCompanyDirectorDetails(cid);
	request.setAttribute("directorDtls", commonVoList);
	CommonVo compnayInfoOne=companiesService.getCompanyInfoOne(cid);
	request.setAttribute("companyInfoDtls", compnayInfoOne);
	CommonVo compnayInfoSecond=companiesService.getCompanyInfoSecond(cid);
	request.setAttribute("companyInfoDtlsTwo", compnayInfoSecond);
	request.setAttribute("companyName", request.getParameter("companyName"));
	if(request.getParameter("result")!=null)
	{
		modelAndView.addObject("successMessage", "Company Information Deleted/Updated Successfully");	
	}
	modelAndView.setViewName("jsp/companyAllDetails");
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
return modelAndView;	
}
@RequestMapping(value="/updateProfile",method=RequestMethod.POST)
public ModelAndView updateProfile(@ModelAttribute(value="companyDtls") UserForm companyDtls,HttpServletRequest request,HttpSession session) throws Exception
{
	final String METHOD_NAME = "updateProfile";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result12=companiesService.updateProfile(companyDtls);
	
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return new ModelAndView("redirect:/retriveAllCompanyDetails.html?result="+result12+"&companyName="+request.getParameter("cName"));
}
@RequestMapping(value="/updateDirectorProfile",method=RequestMethod.POST)
public ModelAndView updateDirectorProfile(@ModelAttribute(value="diretcrListForm") UserForm diretcrListForm,HttpServletRequest request,HttpSession session) throws Exception
{
	final String METHOD_NAME = "updateDirectorProfile";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result12=companiesService.updateDirectorProfile(diretcrListForm);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return new ModelAndView("redirect:/retriveAllCompanyDetails.html?result="+result12+"&companyName="+request.getParameter("cName"));	
}
@RequestMapping(value="/updateCompanyInfoProfile",method=RequestMethod.POST)
public ModelAndView updateCompanyInfoProfile(@ModelAttribute(value="companyInfoOneForm") UserForm companyInfoOneForm,HttpServletRequest request,HttpSession session) throws Exception
{
	final String METHOD_NAME = "updateCompanyInfoProfile";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result12=companiesService.updateCompanyInfoProfile(companyInfoOneForm);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return new ModelAndView("redirect:/retriveAllCompanyDetails.html?result="+result12+"&companyName="+request.getParameter("cName"));	
}
@RequestMapping(value="/updateCompanyInfoProfileBMPM",method=RequestMethod.POST)
public ModelAndView updateCompanyInfoProfileBMPM(@ModelAttribute(value="companyinfoSecond") CompanyInfoTwo companyinfoSecond,HttpServletRequest request,HttpSession session) throws Exception
{
	final String METHOD_NAME = "updateCompanyInfoProfileBMPM";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result12=companiesService.updateCompanyInfoProfileBMPM(companyinfoSecond);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return new ModelAndView("redirect:/retriveAllCompanyDetails.html?result="+result12+"&companyName="+request.getParameter("cName"));	
}
@RequestMapping(value="/deleteDirDtls",method=RequestMethod.POST)
public ModelAndView deleteDirDtls(HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "deleteDirDtls";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result12=companiesService.deleteDirDtls(request.getParameter("hdDirId"));
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return new ModelAndView("redirect:/retriveAllCompanyDetails.html?result="+result12+"&companyName="+request.getParameter("cName"));		
}
@RequestMapping(value="/retriveDirDetails",method=RequestMethod.GET)
public @ResponseBody String retriveDirDetails(@RequestParam("directorId") String dirID) throws Exception
{
	final String METHOD_NAME = "retriveDirDetails";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	String response=companiesService.retriveDirDetails(dirID);
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return response;
}
@RequestMapping(value="/deleteCompanyProfile",method=RequestMethod.POST)
public ModelAndView  deleteCompanyProfile(HttpServletRequest request) throws Exception
{
	final String METHOD_NAME = "deleteCompanyProfile";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	int result12=companiesService.deleteCompanyProfile(request.getParameter("companyId"));
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return new ModelAndView("redirect:/retriveAllCompanyDetails.html?result="+result12+"&companyName="+request.getParameter("cName"));
}

}
