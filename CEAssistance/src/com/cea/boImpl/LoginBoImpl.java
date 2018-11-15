package com.cea.boImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cea.bo.LoginBo;
import com.cea.dao.LoginDao;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;
@Component
public class LoginBoImpl implements LoginBo{
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Autowired
	private LoginDao logDao;

	@Override
	public int userLogin(String uname, String upwd) throws Exception {
		final String METHOD_NAME="userLogin";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		int result=logDao.userLogin(uname,upwd);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}

	@Override
	public CommonVo retriveUserDtls(String uname) throws Exception {
		final String METHOD_NAME="userLogin";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo result=logDao.retriveUserDtls(uname);
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
		
	}

}
