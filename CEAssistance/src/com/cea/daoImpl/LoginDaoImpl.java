package com.cea.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cea.dao.LoginDao;
import com.cea.util.CeaConstants;
import com.cea.util.CeaException;
import com.cea.util.CeaLogMgr;
import com.cea.vo.CommonVo;
@Repository
public class LoginDaoImpl implements LoginDao{
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public int userLogin(String uname, String upwd) throws Exception {
		final String METHOD_NAME="userLogin";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		String pwds="";
		int result=0;
		try
		{
			Query query=session.createSQLQuery("select password from user where email='"+uname+"'");
//			List list=query.list();
			List list= new ArrayList();
			list=query.list();
			for (Object object : list)
			{
				if(object.toString()!=null)
				{
					pwds=object.toString();
					if(pwds.equalsIgnoreCase(upwd))
					{
						result=1;
					break;
					}
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
		}
	@Override
	public CommonVo retriveUserDtls(String uname) throws CeaException {
		final String METHOD_NAME="retriveUserDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		CommonVo commonVo=null;
		try
		{
			Query query=session.createSQLQuery("select IFNULL(firstname,'-'),IFNULL(lastname,'-'),IFNULL(email,'---'),IFNULL(phone,'-'),IFNULL(dob,'-'),IFNULL(DATE_FORMAT(regdDate, '%Y-%m-%d'),'-'),ifnull(UserId,''),ifnull(paymentStatus,'') from user where email='"+uname+"'");
//			List list=query.list();
			List list= new ArrayList();
			list=query.list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				commonVo=new CommonVo();
				commonVo.setFristName(object[0].toString());
				commonVo.setLastName(object[1].toString());
				commonVo.setEmail(object[2].toString());
				commonVo.setMobile(object[3].toString());
				commonVo.setDob(object[4].toString());
				commonVo.setRegDate(object[5].toString());
				commonVo.setUserId(object[6].toString());
				if(!object[7].toString().equals("N"))
				commonVo.setPaymentStatus("PRIMIUM");
				else
				commonVo.setPaymentStatus("BASIC");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		return commonVo;
	}
	}

