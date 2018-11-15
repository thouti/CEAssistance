package com.cea.dao;

import java.util.List;

import com.cea.form.CompanyInfoTwo;
import com.cea.form.UserForm;
import com.cea.vo.CommonVo;


public interface CompaniesDao 
{

	int addCompnayDetails(String companyDtls, String userName) throws Exception;

	List<CommonVo> retriveCompanyDetails(String userId) throws Exception;

	int addComponyInfoDtls(UserForm userForm)throws Exception;

	int addComponyBmPostBmDtls(CompanyInfoTwo companyInfoTwo)throws Exception;

	List<CommonVo> retriveDirectorLst(String companyname)throws Exception;

	String checkDirectorsList(String companyId)throws Exception;

	List<CommonVo> retriveAllDirectorLst(String companyId, String userId) throws Exception;

	int setRemaindermails(UserForm viewForm)throws Exception;

	String downloadWordDocument(String userid, String dirID, String compId,
			String statutaryDirec, String hda2, String hdstaType, String hdnature, String hdFirmRegNo, String hda3, String hda8, String hda6, String date);

	String getDirectorData(String directorId)throws Exception;

	CommonVo retriveAllCompanyDetails(String companyId)throws Exception;

	List<CommonVo> getCompanyDirectorDetails(String companyId)throws Exception;

	CommonVo getCompanyInfoOne(String companyId)throws Exception;

	CommonVo getCompanyInfoSecond(String companyId)throws Exception;

	int updateProfile(UserForm companyDtls)throws Exception;

	String retriveDirDetails(String dirID)throws Exception;

	int updateDirectorProfile(UserForm diretcrListForm)throws Exception;

	int deleteDirDtls(String dirID)throws Exception;

	int updateCompanyInfoProfile(UserForm companyInfoOneForm)throws Exception;

	int updateCompanyInfoProfileBMPM(CompanyInfoTwo companyinfoSecond)throws Exception;

	int deleteCompanyProfile(String companyid)throws Exception;
	
}
