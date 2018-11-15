package com.cea.services;

import com.cea.vo.CommonVo;

public interface LoginService {

	int userLogin(String uname, String upwd)throws Exception;

	CommonVo retriveUserDtls(String uname) throws Exception;

}
