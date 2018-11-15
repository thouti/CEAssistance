package com.cea.dao;

import com.cea.vo.CommonVo;

public interface LoginDao {

	int userLogin(String uname, String upwd) throws Exception;

	CommonVo retriveUserDtls(String uname) throws Exception;

}
