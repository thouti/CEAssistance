package com.cea.services;

import com.cea.form.UserForm;
import com.cea.vo.CommonVo;

public interface RegisterService {
	int userRegister(UserForm userForm)throws Exception;

	String chkMailID(String email) throws Exception;

	CommonVo retriveUserDtls(String userId)throws Exception;

	String getUserId(String email)throws Exception;

	String chkRegisteredEmailId(String emailId)throws Exception;

	int sendPassword(String emailId)throws Exception;

}
