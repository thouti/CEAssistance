package com.cea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cea.bo.CompaniesBo;
import com.cea.form.CompanyInfoTwo;
import com.cea.form.UserForm;
import com.cea.services.CompaniesService;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;
@Service(value="CompaniesServiceImpl")
public class CompaniesServiceImpl implements CompaniesService{
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Autowired
	private CompaniesBo companiesBo;
	@Override
	@Transactional
	public int addCompnayDetails(String companyDtls, String userName)
			throws Exception {
		final String METHOD_NAME="addCompnayDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.addCompnayDetails(companyDtls,  userName);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public List<CommonVo> retriveCompanyDetails(String userId) throws Exception {
		final String METHOD_NAME="addCompnayDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		List<CommonVo> result=companiesBo.retriveCompanyDetails(userId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	@Transactional
	public int addComponyInfoDtls(UserForm userForm) throws Exception {
		final String METHOD_NAME="addComponyInfoDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.addComponyInfoDtls(userForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int addComponyBmPostBmDtls(CompanyInfoTwo companyInfoTwo)
			throws Exception {
		final String METHOD_NAME="addComponyBmPostBmDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.addComponyBmPostBmDtls(companyInfoTwo);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	@Transactional
	public String retriveDirectorLst(String companyname) throws Exception {
		final String METHOD_NAME="retriveDirectorLst";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=companiesBo.retriveDirectorLst(companyname);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public String checkDirectorsList(String companyId) throws Exception {
		final String METHOD_NAME="checkDirectorsList";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=companiesBo.checkDirectorsList(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	//This Method retriveAllDirectorLst Used For Get All The Director Details
	@Override
	@Transactional
	public String retriveAllDirectorLst(String companyId, String userId)
			throws Exception {
		final String METHOD_NAME="retriveAllDirectorLst";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return companiesBo.retriveAllDirectorLst(companyId,userId);
	}
	@Override
	@Transactional
	public int setRemaindermails(UserForm viewForm) throws Exception {
		final String METHOD_NAME="setRemaindermails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return companiesBo.setRemaindermails(viewForm);
	}
	@Override
	public String downloadWordDocument(String userid, String dirID,
			String compId, String statutaryDirec,String hda2,String hdstaType, String hdnature,
			String hdFirmRegNo,String hda3,String hda8,String hda6,String date) throws Exception {
		final String METHOD_NAME="downloadWordDocument";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return companiesBo.downloadWordDocument(userid,dirID,compId,statutaryDirec, hda2,hdstaType,hdnature,hdFirmRegNo,hda3,hda8,hda6,date);
		
	}
	@Override
	public String getDirectorData(String directorId) throws Exception {
		final String METHOD_NAME="getDirectorData";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return companiesBo.getDirectorData(directorId);
	}
	@Override
	public CommonVo retriveAllCompanyDetails(String companyId) throws Exception {
		final String METHOD_NAME="retriveAllCompanyDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo response=companiesBo.retriveAllCompanyDetails(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	
	@Override
	public List<CommonVo> getCompanyDirectorDetails(String companyId) throws Exception{
		final String METHOD_NAME="getCompanyDirectorDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		List<CommonVo> response=companiesBo.getCompanyDirectorDetails(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public CommonVo getCompanyInfoOne(String companyId) throws Exception {
		final String METHOD_NAME="getCompanyInfoOne";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo response=companiesBo.getCompanyInfoOne(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public CommonVo getCompanyInfoSecond(String companyId) throws Exception {
		final String METHOD_NAME="getCompanyInfoSecond";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo response=companiesBo.getCompanyInfoSecond(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public int updateProfile(UserForm companyDtls) throws Exception {
		final String METHOD_NAME="updateProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.updateProfile(companyDtls);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public String retriveDirDetails(String dirID) throws Exception {
		final String METHOD_NAME="retriveDirDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=companiesBo.retriveDirDetails(dirID);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public int updateDirectorProfile(UserForm diretcrListForm) throws Exception {
		final String METHOD_NAME="updateDirectorProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.updateDirectorProfile(diretcrListForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int deleteDirDtls(String dirID) throws Exception {
		final String METHOD_NAME="deleteDirDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.deleteDirDtls(dirID);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int updateCompanyInfoProfile(UserForm companyInfoOneForm)
			throws Exception {
		final String METHOD_NAME="updateCompanyInfoProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.updateCompanyInfoProfile(companyInfoOneForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int updateCompanyInfoProfileBMPM(CompanyInfoTwo companyinfoSecond)
			throws Exception {
		final String METHOD_NAME="updateCompanyInfoProfileBMPM";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.updateCompanyInfoProfileBMPM(companyinfoSecond);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int deleteCompanyProfile(String companyid) throws Exception {
		final String METHOD_NAME="deleteCompanyProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesBo.deleteCompanyProfile(companyid);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}


}
