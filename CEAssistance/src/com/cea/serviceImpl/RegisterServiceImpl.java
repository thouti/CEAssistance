package com.cea.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cea.bo.RegisterBo;
import com.cea.form.UserForm;
import com.cea.services.RegisterService;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;
@Service(value="RegisterServiceImpl")
public class RegisterServiceImpl implements RegisterService{
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Autowired
	private RegisterBo regbo;
	@Override
	public int userRegister(UserForm userForm) throws Exception {
		final String METHOD_NAME="userRegister";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=regbo.userRegister(userForm);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public String chkMailID(String email) throws Exception {
		final String METHOD_NAME="chkMailID";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String result=regbo.chkMailID(email);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public CommonVo retriveUserDtls(String userId) throws Exception {
		final String METHOD_NAME="retriveUserDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return regbo.retriveUserDtls(userId);
	}
	@Override
	public String getUserId(String email) throws Exception {
		final String METHOD_NAME="retriveUserDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return regbo.getUserId(email);
	}
	@Override
	public String chkRegisteredEmailId(String emailId) throws Exception {
		final String METHOD_NAME="chkRegisteredEmailId";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		String result=regbo.chkRegisteredEmailId(emailId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}
	@Override
	public int sendPassword(String emailId) throws Exception {
		final String METHOD_NAME="sendPassword";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=regbo.sendPassword(emailId);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}

}
