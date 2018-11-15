package com.cea.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cea.dao.RegisterDao;
import com.cea.form.UserForm;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.util.MailSendUtil;
import com.cea.vo.CommonVo;
@Repository
public class RegisterDaoImpl implements RegisterDao{
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Autowired
	private MailSendUtil mailsendUtil;
	
		@Override
	public int userRegister(UserForm userForm) {
		final String METHOD_NAME="userRegister";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int result=0;
		String seqNo="",userId="";
		try
		{
			Query querySequence=session.createSQLQuery("select UserId+1 from cea_id_sequence");
			seqNo=querySequence.list().get(0).toString();
			if(seqNo.length()==1){
				seqNo="000000"+seqNo;	
			}else if(seqNo.length()==2){
				seqNo="00000"+seqNo;	
			}else if(seqNo.length()==3){
				seqNo="0000"+seqNo;	
			}else if(seqNo.length()==4){
				seqNo="000"+seqNo;	
			}else if(seqNo.length()==5){
				seqNo="00"+seqNo;	
			}else if(seqNo.length()==6){
				seqNo="0"+seqNo;	
			}
			userId="CEA_"+seqNo;
		Query query=session.createSQLQuery("insert into user(firstname,lastname,email,password,phone,dob,regdDate,UserId)" +
		            "values('"+userForm.getFirstName()+"','"+userForm.getLastName()+"','"+userForm.getEmail()+"','"+userForm.getPassword()+"','"+userForm.getMobile()+"','"+userForm.getDob()+"',DATE_FORMAT(sysdate(),'%Y-%m-%d'),'"+userId+"')");
		query.executeUpdate();
		transaction.commit();
			result=1;
		if(result!=0)
		{
			Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set UserId='"+seqNo+"' where admin='CEA'");
			int res=queryUpdate.executeUpdate();
			mailsendUtil.sendMail(userForm.getEmail(), "Thanks For Registration with Corporate Eassistance", "Registration")	;
			
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
		return result;
	}

	@Override
	public String chkMailID(String email) throws Exception {
		final String METHOD_NAME="chkMailID";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		StringBuffer result=new StringBuffer();
		
		try
		{
			
			Query query=session.createSQLQuery("select IFNULL(firstname,'-'),IFNULL(lastname,'-'),IFNULL(email,'---'),IFNULL(phone,'-'),IFNULL(dob,'-'),IFNULL(DATE_FORMAT(regdDate, '%Y-%m-%d'),'-') from user where email='"+email+"'");
//			List list=query.list();
			List list= new ArrayList();
			list=query.list();
			if(list.size()!=0)
			{
				result.append("0"+"#"+"This Email Id Already Existed");	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	return result.toString();	
	}

	@Override
	public CommonVo retriveUserDtls(String userId) throws Exception {
		final String METHOD_NAME="retriveUserDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		CommonVo commonVo=null;
		try
		{
			Query query=session.createSQLQuery("select IFNULL(firstname,'-'),IFNULL(lastname,'-'),IFNULL(email,'---'),IFNULL(phone,'-'),IFNULL(dob,'-'),IFNULL(DATE_FORMAT(regdDate, '%Y-%m-%d'),'-'),ifnull(UserId,''),ifnull(paymentStatus,'') from user where UserId='"+userId+"'");
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
				if(object[7].toString().equals("N"))
				commonVo.setPaymentStatus("BASIC");
				else
				commonVo.setPaymentStatus("PRIMIUM");
			
		}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return commonVo;
	}

	@Override
	public String getUserId(String email) throws Exception {
		final String METHOD_NAME="getUserId";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		String userID="";
		try
		{
		Query query=session.createSQLQuery("select UserId from user where email='"+email+"'");	
		userID=query.list().get(0)+"";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		return userID;
	}

	@Override
	public String chkRegisteredEmailId(String emailId) throws Exception {
		final String METHOD_NAME="chkMailID";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		StringBuffer result=new StringBuffer();
		
		try
		{
			
			Query query=session.createSQLQuery("select IFNULL(email,'---') from user where email='"+emailId+"'");
//			List list=query.list();
			List list= new ArrayList();
			list=query.list();
			if(list.size()==0)
			{
				result.append("0"+"#"+"Not A Regitered Email Id");	
			}
			else
			{
				result.append("1"+"#"+"Regitered Email Id");		
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	return result.toString();	
	}

	@Override
	public int sendPassword(String emailId) throws Exception {
		int result=0;
		final String METHOD_NAME="sendPassword";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session=sessionFactory.openSession();
		List list=new ArrayList();
		String password="";
		try
		{
			Query query=session.createSQLQuery("select password from user where email='"+emailId+"'");	
			list=query.list();
			if(list.size()!=0)
			{
				password=query.list().get(0)+"";	
				result=1;
				mailsendUtil.forgotPwdMail(emailId,password, "<a href='http://www.corporateeassistance.com/'>Please click here to Login now...CorporateEAssistance</a>", "Password ");
			}
			else
			{
				result=0;	
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();		
		}
		
		return result;
	}

}
