package com.cea.bo;

import com.cea.vo.CommonVo;

public interface LoginBo {

	int userLogin(String uname, String upwd)throws Exception;

	CommonVo retriveUserDtls(String uname)throws Exception;


}
