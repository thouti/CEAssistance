package com.cea.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cea.bo.LoginBo;
import com.cea.services.LoginService;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;

@Service
public class LoginServiceImpl implements LoginService{
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Autowired
	private LoginBo logBo;

	@Override
	public int userLogin(String uname, String upwd) throws Exception {
		final String METHOD_NAME="userLogin";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=logBo.userLogin(uname,upwd);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}

	@Override
	public CommonVo retriveUserDtls(String uname) throws Exception {
		final String METHOD_NAME="retriveUserDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo result=logBo.retriveUserDtls(uname);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}

}
