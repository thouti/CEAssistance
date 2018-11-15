package com.cea.boImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cea.bo.CompaniesBo;
import com.cea.dao.CompaniesDao;
import com.cea.form.CompanyInfoTwo;
import com.cea.form.UserForm;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.util.CeaUtill;
import com.cea.vo.CommonVo;
@Component(value="CompaniesBoImpl")
public class CompaniesBoImpl implements CompaniesBo {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Autowired
	private CompaniesDao companiesDao;
	
	@Autowired
	private CeaUtill ceaUtill;
	
	@Override
	public int addCompnayDetails(String companyDtls, String userName)
			throws Exception {
		final String METHOD_NAME="addCompnayDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.addCompnayDetails(companyDtls,userName);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public List<CommonVo> retriveCompanyDetails(String userId) throws Exception {
		final String METHOD_NAME="retriveCompanyDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		List<CommonVo> result=companiesDao.retriveCompanyDetails(userId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int addComponyInfoDtls(UserForm userForm) throws Exception {
		final String METHOD_NAME="addComponyInfoDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.addComponyInfoDtls(userForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int addComponyBmPostBmDtls(CompanyInfoTwo companyInfoTwo)
			throws Exception {
		final String METHOD_NAME="addComponyBmPostBmDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.addComponyBmPostBmDtls(companyInfoTwo);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public String retriveDirectorLst(String companyname) throws Exception {
		final String METHOD_NAME="retriveDirectorLst";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		List<CommonVo> commonVos=companiesDao.retriveDirectorLst(companyname);
		String response=ceaUtill.convertToString(commonVos);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public String checkDirectorsList(String companyId)throws Exception {
		final String METHOD_NAME="checkDirectorsList";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=companiesDao.checkDirectorsList(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public String retriveAllDirectorLst(String companyId, String userId)
			throws Exception {
		final String METHOD_NAME="retriveAllDirectorLst";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		List<CommonVo> list=companiesDao.retriveAllDirectorLst(companyId,userId);
		String response=ceaUtill.convertDirListToString(list);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public int setRemaindermails(UserForm viewForm) throws Exception {
		final String METHOD_NAME="setRemaindermails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		return companiesDao.setRemaindermails(viewForm);
	}
	@Override
	public String downloadWordDocument(String userid, String dirID,
			String compId, String statutaryDirec,String hda2,String hdstaType, String hdnature,
			String hdFirmRegNo,String hda3,String hda8,String hda6,String date) {
		final String METHOD_NAME="downloadWordDocument";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		return companiesDao.downloadWordDocument(userid,dirID,compId,statutaryDirec,hda2, hdstaType, hdnature,hdFirmRegNo,hda3,hda8,hda6,date);
	}
	@Override
	public String getDirectorData(String directorId) throws Exception {
		final String METHOD_NAME="getDirectorData";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=companiesDao.getDirectorData(directorId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public CommonVo retriveAllCompanyDetails(String companyId) throws Exception {
		final String METHOD_NAME="retriveAllCompanyDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo commonVo=companiesDao.retriveAllCompanyDetails(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return commonVo;
	}
	@Override
	public List<CommonVo> getCompanyDirectorDetails(String companyId)
			throws Exception {
		final String METHOD_NAME="retriveAllCompanyDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		List<CommonVo> result=companiesDao.getCompanyDirectorDetails(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public CommonVo getCompanyInfoOne(String companyId) throws Exception {
		final String METHOD_NAME="getCompanyInfoOne";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo commonVo=companiesDao.getCompanyInfoOne(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return commonVo;
	}
	@Override
	public CommonVo getCompanyInfoSecond(String companyId) throws Exception {
		final String METHOD_NAME="getCompanyInfoSecond";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo commonVo=companiesDao.getCompanyInfoSecond(companyId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return commonVo;
	}
	@Override
	public int updateProfile(UserForm companyDtls) throws Exception {
		final String METHOD_NAME="updateProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.updateProfile(companyDtls);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public String retriveDirDetails(String dirID) throws Exception {
		final String METHOD_NAME="retriveDirDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String response=companiesDao.retriveDirDetails(dirID);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return response;
	}
	@Override
	public int updateDirectorProfile(UserForm diretcrListForm) throws Exception {
		final String METHOD_NAME="updateDirectorProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.updateDirectorProfile(diretcrListForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int deleteDirDtls(String dirID) throws Exception {
		final String METHOD_NAME="deleteDirDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.deleteDirDtls(dirID);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int updateCompanyInfoProfile(UserForm companyInfoOneForm)
			throws Exception {
		final String METHOD_NAME="updateCompanyInfoProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.updateCompanyInfoProfile(companyInfoOneForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int updateCompanyInfoProfileBMPM(CompanyInfoTwo companyinfoSecond) throws Exception{
		final String METHOD_NAME="updateCompanyInfoProfileBMPM";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.updateCompanyInfoProfileBMPM(companyinfoSecond);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int deleteCompanyProfile(String companyid) throws Exception {
		final String METHOD_NAME="deleteCompanyProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=companiesDao.deleteCompanyProfile(companyid);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	
	
}
