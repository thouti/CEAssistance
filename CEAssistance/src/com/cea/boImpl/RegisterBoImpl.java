package com.cea.boImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cea.bo.RegisterBo;
import com.cea.dao.RegisterDao;
import com.cea.form.UserForm;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;
@Component(value="RegisterBoImpl")
public class RegisterBoImpl implements RegisterBo {
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Autowired
	private RegisterDao regDao;
	@Override
	public int userRegister(UserForm userForm) throws Exception {
		final String METHOD_NAME="userRegister";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=regDao.userRegister(userForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public String chkMailID(String email) throws Exception {
		final String METHOD_NAME="chkMailID";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String result=regDao.chkMailID(email);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
		
	}
	@Override
	public CommonVo retriveUserDtls(String userId) throws Exception {
		final String METHOD_NAME="retriveUserDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return regDao.retriveUserDtls(userId);
	}
	@Override
	public String getUserId(String email) throws Exception {
		final String METHOD_NAME="getUserId";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return regDao.getUserId(email);
	}
	@Override
	public String chkRegisteredEmailId(String emailId) throws Exception {
		final String METHOD_NAME="chkRegisteredEmailId";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String result=regDao.chkRegisteredEmailId(emailId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int sendPassword(String emailId) throws Exception {
		final String METHOD_NAME="sendPassword";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=regDao.sendPassword(emailId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}

}
