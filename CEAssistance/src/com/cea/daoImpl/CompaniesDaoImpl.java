package com.cea.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cea.dao.CompaniesDao;
import com.cea.form.CompanyInfoTwo;
import com.cea.form.UserForm;
import com.cea.util.CeaConstants;
import com.cea.util.CeaLogMgr;
import com.cea.util.CommonUtill;
import com.cea.vo.CommonVo;
@Repository
public class CompaniesDaoImpl implements CompaniesDao{
	private final String CLASS_NAME=this.getClass().getCanonicalName();
	@Autowired
	private CeaLogMgr ceaLogMgr;
	
	@Autowired
	CommonUtill util;
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public int addCompnayDetails(String companyDtls, String userName) throws Exception {
	final String METHOD_NAME="addCompnayDetails";
	ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
	 Session session = sessionFactory.openSession() ;
	 Transaction transaction = session.beginTransaction();
		int result=0;
	try
	{
		String companyName="",Address="",CompanyType="",FinancialYear="",AgmDueDate="",AgmDate="",AgmDate1="",AgmDueDate1="";
		String ServiceRequired="",NoOfBeforeTask="",CompanyId="" ,AgmNo="";
		StringTokenizer stnArrear=new StringTokenizer(companyDtls,"&");
		Query querySequence=session.createSQLQuery("select CompanyId+1 from cea_id_sequence");
	   
		while(stnArrear.hasMoreTokens())

		{
		   StringTokenizer subCompanyDtls=new StringTokenizer(stnArrear.nextToken(),"@");
			while(subCompanyDtls.hasMoreTokens())
			{
				companyName=subCompanyDtls.nextToken();
				Address=subCompanyDtls.nextToken();
				CompanyType=subCompanyDtls.nextToken();
				FinancialYear=subCompanyDtls.nextToken();
				AgmDueDate=subCompanyDtls.nextToken();
				AgmDueDate1=AgmDueDate.split("/")[0]+"-"+AgmDueDate.split("/")[1]+"-"+AgmDueDate.split("/")[2];
				AgmDate=subCompanyDtls.nextToken();
				AgmDate1=AgmDate.split("/")[0]+"-"+AgmDate.split("/")[1]+"-"+AgmDate.split("/")[2];
				AgmNo=subCompanyDtls.nextToken();
				ServiceRequired=subCompanyDtls.nextToken();
				NoOfBeforeTask=subCompanyDtls.nextToken();
				String	seqNo=querySequence.list().get(0).toString();
					
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
					CompanyId=companyName.substring(0, 3)+"_"+seqNo;
				Query query=session.createSQLQuery("insert into user_company_details(CompanyName,Address,CompanyType,FinancialYear,AgmDueDate,AgmDate,AgmNo,ServiceRequired,NoOfBeforeTask,CompanyId,UserId,CompanyDtlsStatus)" +
                         "values('"+companyName+"','"+Address+"','"+CompanyType+"','"+FinancialYear+"','"+AgmDueDate1+"','"+AgmDate1+"','"+AgmNo+"','"+ServiceRequired+"','"+NoOfBeforeTask+"','"+CompanyId+"','"+userName+"','N')");
                     query.executeUpdate();
                     if(!transaction.wasCommitted())
                     transaction.commit();
                     result=1;
                     Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set CompanyId='"+seqNo+"' where admin='CEA'");
                     int res=queryUpdate.executeUpdate();
			}
			
			}
		
	}
	catch(Exception e)
	{
		//transaction.rollback();
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
	@Transactional
	public List<CommonVo> retriveCompanyDetails(String userId) throws Exception {
		final String METHOD_NAME="retriveCompanyDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession() ;
		 CommonVo commonVo=null;
		 List<CommonVo> commonVos=new ArrayList<CommonVo>();
		 try
		 {
			Query query=session.createSQLQuery("select CompanyName,CompanyId from user_company_details where UserId='"+userId+"' and CompanyDtlsStatus='N'") ;
			List list=query.list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				commonVo=new CommonVo(); 
				commonVo.setCompanyName(object[0].toString());
				commonVo.setCompanyId(object[1].toString());
				commonVos.add(commonVo);
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
		return commonVos;
	}

	@Override
	public int addComponyInfoDtls(UserForm userForm) throws Exception {
		final String METHOD_NAME="addComponyInfoDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session = sessionFactory.openSession() ;
		 Transaction transaction = session.beginTransaction();
		 String directorName="",gender="",din="",designation="",address="",email="",regNO="",typeOfAuditor="", seqNo="",dirId="";
			int result=0;
			String companyName=userForm.getCompany_list().split("-")[0];
			String companyId=userForm.getCompany_list().split("-")[1];
			try
			{
				 Query query=session.createSQLQuery("insert into add_company_info(CompanyName,CompanyId,BoardVenue,BoardTime,AGMVenue,AGMTime,Nature,SDPeriod,StaturyAuditorNature,HaveSecretry)" +
					 		"values('"+companyName+"','"+companyId+"','"+userForm.getBoardVenue()+"','"+userForm.getBoardTime()+"','"+userForm.getAgmVenue()+"','"+userForm.getAgmTime()+"','"+userForm.getAppt()+"','"+userForm.getPeriod()+"','"+userForm.getNature_sauditor()+"','"+userForm.getSecretry()+"')");
				 result= query.executeUpdate();
				 if(!transaction.wasCommitted())
                     transaction.commit();
				//For Directors
				if(!userForm.getDirector().equals(""))
				{ 
					
				StringTokenizer director=new StringTokenizer(userForm.getDirector(),"&");
				while(director.hasMoreTokens())
				{
				   StringTokenizer subdirectorDtls=new StringTokenizer(director.nextToken(),"~");
				   Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
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
					dirId="Dir_"+seqNo;
					while(subdirectorDtls.hasMoreTokens())
					{
						directorName=subdirectorDtls.nextToken();
						gender=subdirectorDtls.nextToken();
						din=subdirectorDtls.nextToken();
						designation=subdirectorDtls.nextToken();
						address=subdirectorDtls.nextToken();
						email=subdirectorDtls.nextToken();
						 Query query1=session.createSQLQuery("insert into add_company_directors_info(CompanyName,CompanyId,DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors,RegistrationNumber,TypeOfAuditor,MemberShipNo,PanNumber,Dir_ID)" +
							 		"values('"+companyName+"','"+companyId+"','Director','"+directorName+"','"+gender+"','"+din+"','"+designation+"','"+address+"','"+email+"','"+userForm.getRetiredDirectors()+"','','','','','"+dirId+"')");
						 result= query1.executeUpdate();
						 if(result!=0)
						 {
							 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
								int res=queryUpdate.executeUpdate();
						 }
						 if(!transaction.wasCommitted())
		                     transaction.commit();
					}
				}
				}
				//Additional Directors
				if(!userForm.getAdddirector().equalsIgnoreCase(""))
				{
				StringTokenizer aditionalDirector=new StringTokenizer(userForm.getAdddirector(),"&");
				while(aditionalDirector.hasMoreTokens())
			{
					 Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
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
						dirId="AddDir_"+seqNo;
				   StringTokenizer subAddDirectorDtls=new StringTokenizer(aditionalDirector.nextToken(),"~");
					while(subAddDirectorDtls.hasMoreTokens())
					{
						
						directorName=subAddDirectorDtls.nextToken();
						gender=subAddDirectorDtls.nextToken();
						din=subAddDirectorDtls.nextToken();
						designation=subAddDirectorDtls.nextToken();
						address=subAddDirectorDtls.nextToken();
						email=subAddDirectorDtls.nextToken();
						 Query query2=session.createSQLQuery("insert into add_company_directors_info(CompanyName,CompanyId,DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors,RegistrationNumber,TypeOfAuditor,MemberShipNo,PanNumber,Dir_ID)" +
							 		"values('"+companyName+"','"+companyId+"','AdditionalDirector','"+directorName+"','"+gender+"','"+din+"','"+designation+"','"+address+"','"+email+"','','','','','','"+dirId+"')");
						 result= query2.executeUpdate();
						 if(result!=0)
						 {
							 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
								int res=queryUpdate.executeUpdate();
						 }
						 
						 if(!transaction.wasCommitted())
		                     transaction.commit();
					}
				}
			}
				//Propossed New Directors
				if(!userForm.getNewdirector().equalsIgnoreCase(""))
				{
					
				StringTokenizer newDirector=new StringTokenizer(userForm.getNewdirector(),"&");
				while(newDirector.hasMoreTokens())

				{
					
				   StringTokenizer subNewDirectorDtls=new StringTokenizer(newDirector.nextToken(),"~");
					while(subNewDirectorDtls.hasMoreTokens())
					{
						 Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
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
							dirId="NewDir_"+seqNo;
						directorName=subNewDirectorDtls.nextToken();
						gender=subNewDirectorDtls.nextToken();
						din=subNewDirectorDtls.nextToken();
						designation=subNewDirectorDtls.nextToken();
						address=subNewDirectorDtls.nextToken();
						email=subNewDirectorDtls.nextToken();
						 Query query3=session.createSQLQuery("insert into add_company_directors_info(CompanyName,CompanyId,DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors,RegistrationNumber,TypeOfAuditor,MemberShipNo,PanNumber,Dir_ID)" +
							 		"values('"+companyName+"','"+companyId+"','PropossedNewDirector','"+directorName+"','"+gender+"','"+din+"','"+designation+"','"+address+"','"+email+"','','','','','','"+dirId+"')");
						 result= query3.executeUpdate();
						 if(result!=0)
						 {
							 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
								int res=queryUpdate.executeUpdate();
						 }
						 
						 if(!transaction.wasCommitted())
		                     transaction.commit();
					}
				}
				}
				////Statutary Directors 
				if(userForm.getAppt().equalsIgnoreCase("appointment"))
				{
					Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
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
					dirId="StaDir_"+seqNo;
					Query query4=session.createSQLQuery("insert into add_company_directors_info(CompanyName,CompanyId,DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors,RegistrationNumber,TypeOfAuditor,MemberShipNo,PanNumber,Dir_ID)" +
					 		"values('"+companyName+"','"+companyId+"','StatutaryAuditors','"+userForm.getSt_audname_1()+"','','','','','"+userForm.getSt_audmail_1()+"','','"+userForm.getSt_audregnum_1()+"','"+userForm.getSt_audtype_1()+"','','','"+dirId+"')");
				 result= query4.executeUpdate();
				 if(!transaction.wasCommitted())
                     transaction.commit();
				 if(result!=0)
				 {
					 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
						int res=queryUpdate.executeUpdate();
				 }
				 Query querySequenceOne=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
					seqNo=querySequenceOne.list().get(0).toString();
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
					dirId="StaDir_"+seqNo;
					Query queryFour=session.createSQLQuery("insert into add_company_directors_info(CompanyName,CompanyId,DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors,RegistrationNumber,TypeOfAuditor,MemberShipNo,PanNumber,Dir_ID)" +
					 		"values('"+companyName+"','"+companyId+"','StatutaryAuditors','"+userForm.getSt_audname_2()+"','','','','','"+userForm.getSt_audmail_2()+"','','"+userForm.getSt_audregnum_2()+"','"+userForm.getSt_audtype_2()+"','','','"+dirId+"')");
				 result= queryFour.executeUpdate();
				 if(!transaction.wasCommitted())
                  transaction.commit();
				 if(result!=0)
				 {
					 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
						int res=queryUpdate.executeUpdate();
				 }
				}
				else if(!userForm.getAppt().equalsIgnoreCase("appointment"))
				{
					Query querySequenceOne=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
					seqNo=querySequenceOne.list().get(0).toString();
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
					dirId="StaDir_"+seqNo;
					Query queryFive=session.createSQLQuery("insert into add_company_directors_info(CompanyName,CompanyId,DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors,RegistrationNumber,TypeOfAuditor,MemberShipNo,PanNumber,Dir_ID)" +
					 		"values('"+companyName+"','"+companyId+"','StatutaryAuditors','"+userForm.getSt_audname_1()+"','','','','','"+userForm.getSt_audmail_1()+"','','"+userForm.getSt_audregnum_1()+"','"+userForm.getSt_audtype_1()+"','','','"+dirId+"')");
				 result= queryFive.executeUpdate();
				 if(!transaction.wasCommitted())
                  transaction.commit();
				 if(result!=0)
				 {
					 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
						int res=queryUpdate.executeUpdate();
				 }	
				}
				if(userForm.getSecretry().equalsIgnoreCase("yes"))
				{
					 Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
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
						dirId="secretory_"+seqNo;
					Query query5=session.createSQLQuery("insert into add_company_directors_info(CompanyName,CompanyId,DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors,RegistrationNumber,TypeOfAuditor,MemberShipNo,PanNumber,Dir_ID)" +
					 		"values('"+companyName+"','"+companyId+"','CompanySecretary','"+userForm.getSecnam()+"','','','','','"+userForm.getSecmail()+"','','','','"+userForm.getSecmemno()+"','"+userForm.getSecpan()+"','"+dirId+"')");
				 result= query5.executeUpdate();
				 if(!transaction.wasCommitted())
                     transaction.commit();
				 if(result!=0)
				 {
					 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
						int res=queryUpdate.executeUpdate();
				 }
				 
				 
				}
				if(!transaction.wasCommitted())
                    transaction.commit();
				/*if(result!=0)
				{
					int res=0;
				Query queryUpdate=session.createSQLQuery("Update user_company_details set CompanyDtlsStatus='Y' where UserId='"+userForm.getUserId()+"'");
                 res=queryUpdate.executeUpdate();
				}*/
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
		return result;
	}

	@Override
	public int addComponyBmPostBmDtls(CompanyInfoTwo companyInfoTwo)
			throws Exception {
		final String METHOD_NAME="addComponyBmPostBmDtls";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session = sessionFactory.openSession() ;
		 Transaction transaction = session.beginTransaction();
		 int result=0;
		 String audit_reporterName="",firmRegNo="",audit_name="",audit_email="",final_stmt_diretcor="",final_stmt_diretcor1="",Authorised_dir_name="";
		 if(companyInfoTwo.getAudit_required().equalsIgnoreCase("Yes"))
		 {
			 audit_reporterName= companyInfoTwo.getAudit_reporterName();
			 firmRegNo=companyInfoTwo.getFirmRegNo();
			 audit_name= companyInfoTwo.getAudit_name();
			 audit_email=companyInfoTwo.getAudit_email();
		 }
		 try
		 {
			 String name="",disignation="",dinPan="",dirId;
			 if(!companyInfoTwo.getFinal_stmt_diretcor().equals("other"))
			 {
				 name=companyInfoTwo.getFinal_stmt_diretcor(); 
				 Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
					String seqNo=querySequence.list().get(0).toString();
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
					dirId="FinalStmt_"+seqNo;
					 Query query12=session.createSQLQuery("insert into add_other_director_info(FinalStmt_Diretcor_Name,FinalStmt_Diretcor_Designation,FinalStmt_Diretcor_DinPan,DirStmt_Diretcor_Name,DirStmt_Diretcor_Designation,DirStmt_Diretcor_DinPan,Dividend_Diretcor_Name,Dividend_Diretcor_Designation,Dividend_Diretcor_DinPan,DirectorType,DirectorId,CompanyId,UserID)" +
							 " values('"+name+"','"+disignation+"','"+dinPan+"','','','','','','','FinalStmt','"+dirId+"','"+companyInfoTwo.getCompany_name().split("-")[1]+"','"+companyInfoTwo.getUserId()+"')");
					 result= query12.executeUpdate();
					 if(!transaction.wasCommitted())
	                  transaction.commit();
					 if(result!=0)
					 {
						 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
							int res=queryUpdate.executeUpdate();
					 }
			 }else
			if(companyInfoTwo.getFetchData()!="")
			{
				StringTokenizer directorNameStr=new StringTokenizer(companyInfoTwo.getFetchData(),"&");
				while(directorNameStr.hasMoreTokens())

				{
					
				   StringTokenizer subSTRDtls=new StringTokenizer(directorNameStr.nextToken(),"@");
					while(subSTRDtls.hasMoreTokens())
					{	
						name=subSTRDtls.nextToken();
						disignation=subSTRDtls.nextToken();
						dinPan=subSTRDtls.nextToken();
						Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
						String seqNo=querySequence.list().get(0).toString();
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
						dirId="FinalStmt_"+seqNo;
						 Query query12=session.createSQLQuery("insert into add_other_director_info(FinalStmt_Diretcor_Name,FinalStmt_Diretcor_Designation,FinalStmt_Diretcor_DinPan,DirStmt_Diretcor_Name,DirStmt_Diretcor_Designation,DirStmt_Diretcor_DinPan,Dividend_Diretcor_Name,Dividend_Diretcor_Designation,Dividend_Diretcor_DinPan,DirectorType,DirectorId,CompanyId,UserID)" +
								 " values('"+name+"','"+disignation+"','"+dinPan+"','','','','','','','FinalStmt','"+dirId+"','"+companyInfoTwo.getCompany_name().split("-")[1]+"','"+companyInfoTwo.getUserId()+"')");
						 result= query12.executeUpdate();
						 if(!transaction.wasCommitted())
		                  transaction.commit();
						 if(result!=0)
						 {
							 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
								int res=queryUpdate.executeUpdate();
						 }	
					}
				}
			}
			//======
			 if(!companyInfoTwo.getFinal_stmt_diretcor2().equals("other"))
			 {
				 name=companyInfoTwo.getFinal_stmt_diretcor2(); 
				 Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
					String seqNo=querySequence.list().get(0).toString();
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
					dirId="FinalStmt_"+seqNo;
					 Query query12=session.createSQLQuery("insert into add_other_director_info(FinalStmt_Diretcor_Name,FinalStmt_Diretcor_Designation,FinalStmt_Diretcor_DinPan,DirStmt_Diretcor_Name,DirStmt_Diretcor_Designation,DirStmt_Diretcor_DinPan,Dividend_Diretcor_Name,Dividend_Diretcor_Designation,Dividend_Diretcor_DinPan,DirectorType,DirectorId,CompanyId,UserID)" +
							 " values('','','','"+name+"','','','','','','DirStmt','"+dirId+"','"+companyInfoTwo.getCompany_name().split("-")[1]+"','"+companyInfoTwo.getUserId()+"')");
					 result= query12.executeUpdate();
					 if(!transaction.wasCommitted())
	                  transaction.commit();
					 if(result!=0)
					 {
						 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
							int res=queryUpdate.executeUpdate();
					 }
			 }else
			if(companyInfoTwo.getDirectorStmtData()!="")
			{
				StringTokenizer directorNameStr=new StringTokenizer(companyInfoTwo.getDirectorStmtData(),"&");
				while(directorNameStr.hasMoreTokens())

				{
					
				   StringTokenizer subSTRDtls=new StringTokenizer(directorNameStr.nextToken(),"@");
					while(subSTRDtls.hasMoreTokens())
					{	
						name=subSTRDtls.nextToken();
						disignation=subSTRDtls.nextToken();
						dinPan=subSTRDtls.nextToken();
						Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
						String seqNo=querySequence.list().get(0).toString();
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
						dirId="DirStmt_"+seqNo;
						 Query query12=session.createSQLQuery("insert into add_other_director_info(FinalStmt_Diretcor_Name,FinalStmt_Diretcor_Designation,FinalStmt_Diretcor_DinPan,DirStmt_Diretcor_Name,DirStmt_Diretcor_Designation,DirStmt_Diretcor_DinPan,Dividend_Diretcor_Name,Dividend_Diretcor_Designation,Dividend_Diretcor_DinPan,DirectorType,DirectorId,CompanyId,UserID)" +
								 " values('','','','"+name+"','"+disignation+"','"+dinPan+"','','','','DirStmt','"+dirId+"','"+companyInfoTwo.getCompany_name().split("-")[1]+"','"+companyInfoTwo.getUserId()+"')");
						 result= query12.executeUpdate();
						 if(!transaction.wasCommitted())
		                  transaction.commit();
						 if(result!=0)
						 {
							 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
								int res=queryUpdate.executeUpdate();
						 }	
					}
				}
			}
			//====================
			 if(companyInfoTwo.getDividend_proposed_paid().equalsIgnoreCase("yes")){
			 if(!companyInfoTwo.getAuthorised_dir_name().equals("other"))
			 {
				 name=companyInfoTwo.getAuthorised_dir_name(); 
				 Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
					String seqNo=querySequence.list().get(0).toString();
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
					dirId="FinalStmt_"+seqNo;
					 Query query12=session.createSQLQuery("insert into add_other_director_info(FinalStmt_Diretcor_Name,FinalStmt_Diretcor_Designation,FinalStmt_Diretcor_DinPan,DirStmt_Diretcor_Name,DirStmt_Diretcor_Designation,DirStmt_Diretcor_DinPan,Dividend_Diretcor_Name,Dividend_Diretcor_Designation,Dividend_Diretcor_DinPan,DirectorType,DirectorId,CompanyId,UserID)" +
							 " values('','','','','','','"+name+"','"+disignation+"','"+dinPan+"','DevidendStmt','"+dirId+"','"+companyInfoTwo.getCompany_name().split("-")[1]+"','"+companyInfoTwo.getUserId()+"')");
					 result= query12.executeUpdate();
					 if(!transaction.wasCommitted())
	                  transaction.commit();
					 if(result!=0)
					 {
						 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
							int res=queryUpdate.executeUpdate();
					 }
			 }else
			if(companyInfoTwo.getDevidendDir()!="")
			{
				StringTokenizer directorNameStr=new StringTokenizer(companyInfoTwo.getFetchData(),"&");
				while(directorNameStr.hasMoreTokens())

				{
					
				   StringTokenizer subSTRDtls=new StringTokenizer(directorNameStr.nextToken(),"@");
					while(subSTRDtls.hasMoreTokens())
					{	
						name=subSTRDtls.nextToken();
						disignation=subSTRDtls.nextToken();
						dinPan=subSTRDtls.nextToken();
						Query querySequence=session.createSQLQuery("select Dir_ID+1 from cea_id_sequence");
						String seqNo=querySequence.list().get(0).toString();
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
						dirId="FinalStmt_"+seqNo;
						 Query query12=session.createSQLQuery("insert into add_other_director_info(FinalStmt_Diretcor_Name,FinalStmt_Diretcor_Designation,FinalStmt_Diretcor_DinPan,DirStmt_Diretcor_Name,DirStmt_Diretcor_Designation,DirStmt_Diretcor_DinPan,Dividend_Diretcor_Name,Dividend_Diretcor_Designation,Dividend_Diretcor_DinPan,DirectorType,DirectorId,CompanyId,UserID)" +
								 " values('','','','','','','"+name+"','"+disignation+"','"+dinPan+"','DevidendStmt','"+dirId+"','"+companyInfoTwo.getCompany_name().split("-")[1]+"','"+companyInfoTwo.getUserId()+"')");
						 result= query12.executeUpdate();
						 if(!transaction.wasCommitted())
		                  transaction.commit();
						 if(result!=0)
						 {
							 Query queryUpdate=session.createSQLQuery("Update cea_id_sequence set Dir_ID='"+seqNo+"' where admin='CEA'");
								int res=queryUpdate.executeUpdate();
						 }	
					}
				}
			}
			 }
		 Query query=session.createSQLQuery("insert into add_company_info_second(Company_Id,User_Id,FinalStmt_Diretcor,Designation,DinPin,Dividend_Proposed_Paid,Yes_Dividend_Proposed_Paid,Dividend_Paid_Out,No_Fully_Paid,Face_Value,Record_Date,Dividend_Amounts,Bank_Account,Audit_Required,Secretarial_Auditors,Audit_ReporterName,FirmRegNo,Audit_Name,Audit_Email,FinalStmt_Diretcor2,Director_Name1,Designation1,Authorised_dir_name,Authorised_dir_designation,Authorised_dir_din)" +
		 		                                                        " values('"+companyInfoTwo.getCompany_name().split("-")[1]+"','"+companyInfoTwo.getUserId()+"','"+final_stmt_diretcor+"','"+companyInfoTwo.getDesignation()+"','"+companyInfoTwo.getDinPin()+"','"+companyInfoTwo.getDividend_proposed_paid()+"','"+companyInfoTwo.getYes_dividend_proposed_paid()+"','"+companyInfoTwo.getDividend_paid_out()+"','"+companyInfoTwo.getNo_fully_paid()+"','"+companyInfoTwo.getFace_value_Eshare()+"','"+companyInfoTwo.getRecord_date()+"','"+companyInfoTwo.getDividend_amounts()+"','"+companyInfoTwo.getBank_account()+"','"+companyInfoTwo.getAudit_required()+"','"+companyInfoTwo.getSecretarial_auditors()+"','"+audit_reporterName+"','"+firmRegNo+"','"+audit_name+"','"+audit_email+"','"+final_stmt_diretcor1+"','"+companyInfoTwo.getDirector_name1()+"','"+companyInfoTwo.getD_dinPin()+"','"+Authorised_dir_name+"','"+companyInfoTwo.getAuthorised_dir_designation()+"','"+companyInfoTwo.getAuthorised_dir_din()+"')");
		 query.executeUpdate();
		 result=1;
		 if(!transaction.wasCommitted())
             transaction.commit();
			if(result!=0)
			{
				int res=0;
			Query queryUpdate=session.createSQLQuery("Update user_company_details set CompanyDtlsStatus='Y' where UserId='"+companyInfoTwo.getCompany_name().split("-")[1]+"'");
          res=queryUpdate.executeUpdate();
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
	public List<CommonVo> retriveDirectorLst(String companyname) throws Exception {
		final String METHOD_NAME="retriveDirectorLst";
		Session session=sessionFactory.openSession();
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		CommonVo commonVo=null;
		List<CommonVo> commonVos=new ArrayList<CommonVo>();
		 try
		 {
			 Query query1=session.createSQLQuery("select * from add_company_info_second where Company_Id='"+companyname+"' ");
			 List list2=query1.list();
			 if(list2.size()==0){
		 Query query=session.createSQLQuery("select DirectorName,Dir_ID from add_company_directors_info where CompanyId='"+companyname+"' and DirectorType='Director'");
		 List list=query.list();
		 if(list.size()!=0)
		 {
			 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				 commonVo=new CommonVo();
				 commonVo.setErrorCode("1");
				 commonVo.setDirName(object[0].toString());
				 commonVo.setDirId(object[1].toString());
				 commonVos.add(commonVo);
				
			}
		}
		 else
		 {
			 commonVo=new CommonVo();
			 commonVo.setErrorCode("0");
			 commonVo.setDirName("No Deirectors Found With Company");
			 commonVos.add(commonVo);
			  
		 }
		
		 }
			 else
			 {
				 commonVo=new CommonVo();
				 commonVo.setErrorCode("2");
				 commonVo.setEmailContent("Already Company Details Added Successfully");
				 commonVos.add(commonVo);
				   
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
		return commonVos;
	}

	@Override
	public String checkDirectorsList(String companyId) throws Exception {
		final String METHOD_NAME="checkDirectorsList";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session = sessionFactory.openSession();
		StringBuffer stringBuffer=new StringBuffer();
		
		try
		{
			Query query=session.createSQLQuery("select * from add_company_directors_info where CompanyId='"+companyId+"'");
			List list=query.list();
			if(list.size()!=0)
			{
				stringBuffer.append("0"+"#"+"Already Company Director Details Added ");
			}
			else
			{
				stringBuffer.append("1"+"#"+"");	
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
		return stringBuffer.toString();
	}
	//This Method retriveAllDirectorLst Used For Get All The Director Details
	@Override
	public List<CommonVo> retriveAllDirectorLst(String companyId, String userId)
			throws Exception {
		final String METHOD_NAME="retriveAllDirectorLst";
		
		Session session = sessionFactory.openSession();
		CommonVo commonVo=null;
		List<CommonVo> commonVos=new ArrayList<CommonVo>();
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);

		try
		{
		Query query=session.createSQLQuery("SELECT D.email,C.AgmDate,C.NoOfBeforeTask,A.DirectorType,A.DirectorName,A.DirEmail,c.AgmDueDate,B.BoardVenue,B.BoardTime,B.AGMVenue,B.`AGMTime`,A.`Dir_ID`,A.RetiredDirectors,E.StaturyAuditorNature, E.Nature,F.`FirmRegNo` FROM add_company_directors_info A JOIN add_company_info  B  ON  A.CompanyId= B.CompanyId JOIN user_company_details  C  ON C.CompanyId = B.CompanyId JOIN `user` D ON D.UserId = C.UserId JOIN `add_company_info` E  ON A.CompanyId = E.CompanyId JOIN `add_company_info_second` F ON A.CompanyId = F.Company_Id   WHERE  D.UserId ='"+userId+"' AND A.CompanyId='"+companyId+"'");
		List list=query.list(); 
		for (Iterator iterator = list.iterator(); iterator.hasNext();) 
		{
		Object[] object = (Object[]) iterator.next();
		commonVo=new CommonVo();
		commonVo.setEmail(object[0]+"");
		commonVo.setAgmDate(object[1]+"");
		commonVo.setNoOfDays(object[2]+"");
		commonVo.setDirType(object[3]+"");
		commonVo.setDirName(object[4]+"");
		commonVo.setDirEmail(object[5]+"");
		commonVo.setAgmDueDate(object[6]+"");
		commonVo.setBoardVenue(object[7]+"");
		commonVo.setBoardTime(object[8]+"");
		commonVo.setAgmVenue(object[9]+"");
		commonVo.setAgmTime(object[10]+"");
		commonVo.setDirectorId(object[11]+"");
		commonVo.setRetiredDirectors(object[12]+"");
		commonVo.setStatutaryType(object[13]+"");
		commonVo.setNature(object[14]+"");
		commonVo.setFirmRegNo(object[15]+"");
		commonVos.add(commonVo);
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
		return commonVos;
	}

	@Override
	public int setRemaindermails(UserForm viewForm) throws Exception {
		
		final String METHOD_NAME="setRemaindermails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session = sessionFactory.openSession() ;
		 Transaction transaction = session.beginTransaction();
		 int result=0;
		 try{
			 
			 if(viewForm.getDirType().equalsIgnoreCase("director")){
				 
			 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
				 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getHddirEmail()+"','"+viewForm.getHddirNames()+"','','"+viewForm.getHdagmDueDate()+"','Director','"+viewForm.getHda1()+"')");
				 query.executeUpdate();
				 result=1;
				 if(!transaction.wasCommitted())
		             transaction.commit();
		 }
			 
			 if(viewForm.getAdddirType().equalsIgnoreCase("addDirector")){
				 
				 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
					 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getHdadddirEmail()+"','"+viewForm.getHdaddDirNames()+"','','"+viewForm.getHdagmDueDate()+"','AdditionalDirector','"+viewForm.getHda1()+"')");
					 query.executeUpdate();
					 result=1;
					 if(!transaction.wasCommitted())
			             transaction.commit();
			 }
			 
			 	if(viewForm.getNewdirType().equalsIgnoreCase("nDirector")){
				 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						" values('"+viewForm.getEmail()+"','','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getHdnewdirEmail()+"','"+viewForm.getHdaddNewDirNames()+"','','"+viewForm.getHdagmDueDate()+"','NewDirector','"+viewForm.getHda1()+"')");
					 query.executeUpdate();
					 result=1;
					 if(!transaction.wasCommitted())
			             transaction.commit();
			 }
			 
			 	if(viewForm.getStadirType().equalsIgnoreCase("staDirector")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getHdstadirEmail()+"','"+viewForm.getHdstatutaryDirNames()+"','','"+viewForm.getHdagmDueDate()+"','StaDirector','"+viewForm.getHda1()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	if(viewForm.getBoardMeeting().equalsIgnoreCase("bordmeeting")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getHdagendaDirectors()+"','','','"+viewForm.getHdagmDueDate()+"','','"+viewForm.getHda2()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	if(viewForm.getAttendenceRegister().equalsIgnoreCase("attendenceRegister")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getEmail()+"','','','"+viewForm.getHdagmDueDate()+"','','"+viewForm.getHda3()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	
			 	if(viewForm.getAttendenceRegister().equalsIgnoreCase("attendenceRegister")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getEmail()+"','','','"+viewForm.getHdagmDueDate()+"','attendenceRegister','"+viewForm.getHda3()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	if(viewForm.getAnnuvalMeeting2().equalsIgnoreCase("annuvalMeeting2")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getEmail()+"','','','"+viewForm.getHdagmDueDate()+"','annuvalMeeting2','"+viewForm.getHda6()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	if(viewForm.getIntimationAuditor().equalsIgnoreCase("intimationAuditor")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getEmail()+"','','','"+viewForm.getHdagmDueDate()+"','intimationAuditor','"+viewForm.getHda8()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	if(viewForm.getFillingSec139().equalsIgnoreCase("fillingSec139")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getEmail()+"##"+"','','','"+viewForm.getHdagmDueDate()+"','','"+viewForm.getHda8()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	if(viewForm.getFillingReport().equalsIgnoreCase("fillingReport")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getEmail()+"##"+"','','','"+viewForm.getHdagmDueDate()+"','','"+viewForm.getHda9()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
				 }
			 	if(viewForm.getReturn924().equalsIgnoreCase("return924")){
					 
			 		 Query query=session.createSQLQuery("insert into viewcalanderdatastore(UserMailId,AlertMessage,AgmDate,BoardMeeting,BoardVenue,DirectorEmail,DirectorNames,SigntaryDirector,AgmDueDate,DirectorType,SentAgmDate)" +
						 		" values('"+viewForm.getEmail()+"',' ','"+viewForm.getHdAgmDate()+"','"+viewForm.getBoardMeeting()+"','"+viewForm.getBoardVenue()+"','"+viewForm.getEmail()+"##"+"','','','"+viewForm.getHdagmDueDate()+"','return924','"+viewForm.getHda10()+"')");
						 query.executeUpdate();
						 result=1;
						 if(!transaction.wasCommitted())
				             transaction.commit();
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
		return 0;
	}

	@Override
	public String downloadWordDocument(String userid, String dirID,
			String compId, String statutaryDirec,String hda2,String hdstaType, String hdnature,
			String hdFirmRegNo,String hda3,String hda8,String hda6,String date) {
          final String METHOD_NAME="downloadWordDocument";
          ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
          String mailContent="",staType="",nature="",hdstaType1="";
          Query query2 = null,query=null;
          
		Session session = sessionFactory.openSession();
		try
		{
			if(!dirID.equalsIgnoreCase(""))
			{
		      query=session.createSQLQuery("SELECT  IFNULL(A.DirectorType,'-'), IFNULL(A.`DirectorName`,'-'),IFNULL(A.`DIN`,'-'),IFNULL(A.Address,'-'),IFNULL(C.AgmNo,'0'),IFNULL(C.AgmDueDate,'-'),IFNULL(C.`AgmDate`,'-'),IFNULL(C.`CompanyName`,'-'),IFNULL(D.`AGMVenue`, '-'),IFNULL(D.`AGMTime`, '0:00'),IFNULL(A.`Designation`, '-'),IFNULL(D.`StaturyAuditorNature`, '-'),IFNULL(D.`Nature`,'-')    FROM add_company_directors_info A JOIN user_company_details C  ON  C.CompanyId = A.CompanyId JOIN `add_company_info` D  ON C.CompanyId = D.CompanyId JOIN `add_company_info_second` E  ON E.Company_Id = D.CompanyId WHERE C.UserId = '"+userid+"' AND A.CompanyId = '"+compId+"' AND A.Dir_ID = '"+dirID+"' ");
	        }
			else
			{
				 query=session.createSQLQuery("SELECT  IFNULL(A.DirectorType,'-'), IFNULL(A.`DirectorName`,'-'),IFNULL(A.`DIN`,'-'),IFNULL(A.Address,'-'),IFNULL(C.AgmNo,'0'),IFNULL(C.AgmDueDate,'-'),IFNULL(C.`AgmDate`,'-'),IFNULL(C.`CompanyName`,'-'),IFNULL(D.`AGMVenue`, '-'),IFNULL(D.`AGMTime`, '0:00'),IFNULL(A.`Designation`, '-'),IFNULL(D.`StaturyAuditorNature`, '-'),IFNULL(D.`Nature`,'-')    FROM add_company_directors_info A JOIN user_company_details C  ON  C.CompanyId = A.CompanyId JOIN `add_company_info` D  ON C.CompanyId = D.CompanyId JOIN `add_company_info_second` E  ON E.Company_Id = D.CompanyId WHERE C.UserId = '"+userid+"' AND A.CompanyId = '"+compId+"'");
			}
			List list=query.list();
	    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] object1 = (Object[]) iterator.next();
			 if(!object1[11].toString().equalsIgnoreCase("")&&object1[0].toString().equalsIgnoreCase("StatutaryAuditors"))
	          {
	        	  staType=object1[11].toString(); 
	        	  nature=object1[12].toString();
	          }
			 // Appointed Template
			 if(nature.equalsIgnoreCase("appointment")&&object1[0].toString().equalsIgnoreCase("StatutaryAuditors")&&staType.equals("firm"))
	          {
	        	   query2=session.createSQLQuery("select Content from directorstemplates where DirecterType='"+object1[0].toString()+"' and  Type2='"+staType+"' and TypeOfAppointment='"+nature+"'");
	          }
			 if(nature.equalsIgnoreCase("appointment")&&object1[0].toString().equalsIgnoreCase("StatutaryAuditors")&&staType.equals("individual"))
	          {
	        	   query2=session.createSQLQuery("select Content from directorstemplates where DirecterType='"+object1[0].toString()+"' and  Type2='"+staType+"' and TypeOfAppointment='"+nature+"'");
	          }
			// Re-appointed Template
			 if(nature.equalsIgnoreCase("reappointment")&&object1[0].toString().equalsIgnoreCase("StatutaryAuditors")&&staType.equals("firm"))
	          {
	        	 // staType=hdstaType; 
	        	  query2=session.createSQLQuery("select Content from directorstemplates where DirecterType='"+object1[0].toString()+"' and  Type2='"+staType+"' and TypeOfAppointment='"+nature+"'");
	          }
			 if(nature.equalsIgnoreCase("reappointment")&&object1[0].toString().equalsIgnoreCase("StatutaryAuditors")&&staType.equals("individual"))
	          {
	        	 // staType=hdstaType; 
	        	  query2=session.createSQLQuery("select Content from directorstemplates where DirecterType='"+object1[0].toString()+"' and  Type2='"+staType+"' and TypeOfAppointment='"+nature+"'");
	          }
			 if(!hdstaType.equalsIgnoreCase(""))
	          {
	        	  staType=hdstaType; 
	        	  query2=session.createSQLQuery("select Content from directorstemplates where  Type2='"+staType+"'");
	          }
			 else if(dirID.equalsIgnoreCase(""))
			{
				 if(object1[12].toString().equalsIgnoreCase("appointment")||object1[12].toString().equalsIgnoreCase("reappointment")||object1[12].toString().equalsIgnoreCase("ratification"))
	          {
	        	  query2=session.createSQLQuery("select Content from directorstemplates where  Type2='"+object1[12].toString()+"'");
	          }
			}
			 else if(!object1[0].toString().equals("") &&staType.equals("") )
			 {
			 query2=session.createSQLQuery("select Content from directorstemplates where DirecterType='"+object1[0].toString()+"' and Type2='"+staType+"'");
			 }
			mailContent=query2.list().get(0)+"";
			 String directorList="",directorList1="",srno="";
			 int sno=1;
			 if(hdstaType.equalsIgnoreCase("ALLDIR"))
			 {
			 for (Iterator iterator1 = list.iterator(); iterator.hasNext();) 
			 {
					Object[] object2 = (Object[]) iterator.next();
					directorList=directorList+object2[1]+""+"<br>";
					srno=srno+sno+++"<br>";
			 }
			 mailContent=mailContent.replace("$Name of the Director$", directorList);
			 mailContent=mailContent.replace("$SNO$", srno);
			 }
			 if(hdstaType.equalsIgnoreCase("ALLDIR2"))
			 {
				 for (Iterator iterator1 = list.iterator(); iterator.hasNext();) {
						Object[] object2 = (Object[]) iterator.next();
						if(object2[0].toString().equalsIgnoreCase("Director")||object2[0].toString().equalsIgnoreCase("AdditionalDirector")||object2[0].toString().equalsIgnoreCase("PropossedNewDirector")||object2[0].toString().equalsIgnoreCase("StatutaryAuditors")){
						directorList=directorList+object2[1]+""+"<br>";
						srno=srno+sno+++"<br>";}
						if(object2[0].toString().equalsIgnoreCase("CompanySecretary")){
							directorList1=directorList1+object2[1]+""+"<br>";
							srno=srno+sno+++"<br>";}
			}
				 mailContent=mailContent.replace("$Name of the Director$", directorList);
				 mailContent=mailContent.replace("$SNO$", srno);
				 mailContent=mailContent.replace("$comsec", directorList1);
				 mailContent=mailContent.replace("$sno", "1");
				 }
			 if(!hdstaType.equalsIgnoreCase("") && object1[0].toString().equalsIgnoreCase("StatutaryAuditors"))
	          {
				 int conclution=Integer.parseInt(object1[4].toString()+"")+5;
				 mailContent=mailContent.replace("$statutaryname$$", object1[1].toString());
				 mailContent=mailContent.replace("$$firmreg$$", hdFirmRegNo);
				 mailContent=mailContent.replace("$$AGM+5$$", conclution+"");
				 
			  }
			 if(object1[0].toString().equalsIgnoreCase("StatutaryAuditors"))
	          {
				 int conclution=Integer.parseInt(object1[4].toString()+"")+5;
				 mailContent=mailContent.replace("$statutaryname$$", object1[1].toString());
				 mailContent=mailContent.replace("$$firmreg$$", hdFirmRegNo);
				 mailContent=mailContent.replace("$$AGM+5$$", conclution+"");
				 
			  }
			 else if(hdstaType.equalsIgnoreCase("NBM")|| hdstaType.equalsIgnoreCase("ALLDIR2"))
	          {
				 mailContent=mailContent.replace("$$Designation$$", object1[10].toString());
				 mailContent=mailContent.replace("$statutaryname$$", object1[1].toString());
				 mailContent=mailContent.replace("$$date1$$", util.getDateformatDD_MON_YYYY(hda2)); 
				 mailContent=mailContent.replace("$$Day$$", util.getDateformatDD_MON_YYYY(hda2).split("-")[0]);
				 mailContent=mailContent.replace("$$month$$", util.getDateformatDD_MON_YYYY(hda2).split("-")[1]);
				 mailContent=mailContent.replace("$$year$$", util.getDateformatDD_MON_YYYY(hda2).split("-")[2]);
				 mailContent=mailContent.replace("$$Venue$$", object1[8]+"");
				 mailContent=mailContent.replace("$$time$$", object1[9]+"");
			  }
			 else if(hdstaType.equalsIgnoreCase("ALLDIR"))
	          {
				 mailContent=mailContent.replace("$$Designation$$", object1[10].toString());
				// mailContent=mailContent.replace("$statutaryname$$", object1[1].toString());
				 mailContent=mailContent.replace("$$date1$$", util.getDateformatDD_MON_YYYY(hda3)); 
				 mailContent=mailContent.replace("$$Day$$", util.getDateformatDD_MON_YYYY(hda3).split("-")[0]);
				 mailContent=mailContent.replace("$$month$$", util.getDateformatDD_MON_YYYY(hda3).split("-")[1]);
				 mailContent=mailContent.replace("$$year$$", util.getDateformatDD_MON_YYYY(hda3).split("-")[2]);
				 mailContent=mailContent.replace("$$Venue$$", object1[8]+"");
				 mailContent=mailContent.replace("$$time$$", object1[9]+"");
			  }
			 else if(object1[12].toString().equalsIgnoreCase("")&&(object1[12].toString().equalsIgnoreCase("appointment")||object1[12].toString().equalsIgnoreCase("reappointment")||object1[12].toString().equalsIgnoreCase("ratification")))
	          {
				 mailContent=mailContent.replace("$statutaryname$$", object1[1].toString());
				 mailContent=mailContent.replace("$$date1$$", util.getDateformatDD_MON_YYYY(hda8)); 
				 mailContent=mailContent.replace("$$Day$$", util.getDateformatDD_MON_YYYY(hda8).split("-")[0]);
				 mailContent=mailContent.replace("$$month$$", util.getDateformatDD_MON_YYYY(hda8).split("-")[1]);
				 mailContent=mailContent.replace("$$year$$", util.getDateformatDD_MON_YYYY(hda8).split("-")[2]);
				 mailContent=mailContent.replace("$$Venue$$", object1[8]+"");
				 mailContent=mailContent.replace("$$time$$", object1[9]+"");
				 int conclution=Integer.parseInt(object1[4].toString()+"")+5;
				 mailContent=mailContent.replace("$$AGM+5$$", conclution+"");
			  }
			 
			mailContent=mailContent.replace("$$date$$", util.getDateformatDD_MON_YYYY(date)+"");
			mailContent=mailContent.replace("$$who is going to retire$$", object1[1].toString());
			mailContent=mailContent.replace("$$din$$", object1[2].toString());
			mailContent=mailContent.replace("$$Address$$", object1[3].toString());
			mailContent=mailContent.replace("$$no1$$", object1[4].toString());
			mailContent=mailContent.replace("$$due date$$", util.getDateformatDD_MON_YYYY(object1[5].toString()));
			mailContent=mailContent.replace("$$AGM$$", util.getDateformatDD_MON_YYYY(object1[6].toString()));
			mailContent=mailContent.replace("$$noticeofBM$$", util.getDateformatDD_MON_YYYY(hda2));
			mailContent=mailContent.replace("$$NameoftheCompany$$", object1[7].toString());
		}
	    Query query3=session.createSQLQuery("select IFNULL(DirectorName,'-'),IFNULL(DIN,'-'),IFNULL(PanNumber,'-'),IFNULL(Address,'-') from add_company_directors_info where Dir_ID='"+statutaryDirec+"'");
	    List list2=query3.list();
	    for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			mailContent=mailContent.replace("$$CompanySecretary$$", object[0].toString());
			mailContent=mailContent.replace("$$DIN/PAN$$", object[1].toString()+"/"+object[2].toString());
			mailContent=mailContent.replace("$$Address1$$", object[3].toString());
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
	    return mailContent;
	}

	@Override
	public String getDirectorData(String directorId) throws Exception {
		final String METHOD_NAME="retriveCompanyDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession() ;
		 StringBuffer stringBuffer=new StringBuffer();
		 try
		 {
			
			 Query query=session.createSQLQuery("select Designation,DIN from add_company_directors_info where Dir_ID='"+directorId+"'");	
			 List list=query.list();
			 if(list.size()!=0)
			 {
			 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object[] = (Object[]) iterator.next();
				stringBuffer.append(object[0].toString()+"$"+object[1].toString());
			}
			 }
			 else
			 {
				 
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
		return stringBuffer.toString();
	}

	@Override
	public CommonVo retriveAllCompanyDetails(String companyId)
			throws Exception {
		final String METHOD_NAME="retriveAllCompanyDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession() ;
		 CommonVo commonVo=null;
		 try
		 {
		commonVo=new CommonVo();
		 Query query=session.createSQLQuery("select * from user_company_details where CompanyId='"+companyId+"'");
		 List list=query.list();
		 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object[] = (Object[]) iterator.next();
				commonVo.setCompanyName(object[0].toString());
				commonVo.setAddress(object[1].toString());
				commonVo.setCompanyType(object[2].toString());
				commonVo.setFinancialYear(object[3].toString());
				commonVo.setAgmDueDate(object[4].toString());
				commonVo.setAgmDate(object[5].toString());
				commonVo.setAgmNo(object[6].toString());
				commonVo.setServiceRequired(object[7].toString());
				commonVo.setNoOfBeforeTask(object[8].toString());
				commonVo.setCompanyId(object[9].toString());
				}
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return commonVo;
	}

	@Override
	public List<CommonVo> getCompanyDirectorDetails(String companyId)
			throws Exception {
		final String METHOD_NAME="getCompanyDirectorDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession() ;
		 CommonVo commonVo=null;
		 List<CommonVo> commonVos=new ArrayList<CommonVo>();
		 try
		 {
			 Query query=session.createSQLQuery("select Dir_ID,DirectorName from add_company_directors_info where CompanyId='"+companyId+"'");
			 List listOne=query.list();
			 for (Iterator iterator = listOne.iterator(); iterator.hasNext();) 
			 {
				Object object[] = (Object[]) iterator.next();
				commonVo=new CommonVo();
				commonVo.setDirectorId(object[0].toString());
				commonVo.setDirName(object[1].toString());
				commonVos.add(commonVo);
			}
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return commonVos;
	}

	@Override
	public CommonVo getCompanyInfoOne(String companyId) throws Exception {
		final String METHOD_NAME="getCompanyInfoOne";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession() ;
		 CommonVo commonVo=null;
		 try
		 {
			 commonVo=new CommonVo();
			 Query query=session.createSQLQuery("select ifnull(BoardVenue,'-'),ifnull(BoardTime,'00:00'),ifnull(AGMVenue,'-'),ifnull(AGMTime,'00:00'),ifnull(Nature,''),ifnull(SDPeriod,''),ifnull('CompanyId','') from add_company_info where CompanyId='"+companyId+"'");
			 List list=query.list();
			 if(list.size()!=0)
			 {
		 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object[] = (Object[]) iterator.next();
				commonVo.setBoardVenue(object[0].toString());
				commonVo.setBoardTime(object[1].toString());
				commonVo.setAgmVenue(object[2].toString());
				commonVo.setAgmTime(object[3].toString());
				commonVo.setNature(object[4].toString());
				commonVo.setSdPeriod(object[5].toString());
				commonVo.setCompanyId(object[6].toString());
				commonVo.setErrorCode("1");
				}
			 }
			 else
			 {
				 commonVo.setErrorCode("0"); 
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return commonVo;
	}

	@Override
	public CommonVo getCompanyInfoSecond(String companyId) throws Exception {
		final String METHOD_NAME="getCompanyInfoOne";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession() ;
		 CommonVo commonVo=null;
		 try
		 {
			 commonVo=new CommonVo();
			 Query query=session.createSQLQuery("select Company_Id,Dividend_Proposed_Paid,Yes_Dividend_Proposed_Paid,Dividend_Paid_Out,No_Fully_Paid,Face_Value,Record_Date,Dividend_Amounts,Bank_Account,Audit_Required,Secretarial_Auditors,Audit_ReporterName,FirmRegNo,Audit_Name,Audit_Email from add_company_info_second where Company_Id='"+companyId+"'");
			 List list=query.list();
			 if(list.size()!=0){
		 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object[] = (Object[]) iterator.next();
				commonVo.setCompanyId(object[0].toString());
				commonVo.setDividend_proposed_paid(object[1].toString());
				commonVo.setYes_dividend_proposed_paid(object[2].toString());
				commonVo.setDividend_paid_out(object[3].toString());
				commonVo.setNo_fully_paid(object[4].toString());
				commonVo.setFace_value_Eshare(object[5].toString());
				commonVo.setRecord_date(object[6].toString());
				commonVo.setDividend_amounts(object[7].toString());
				commonVo.setBank_account(object[8].toString());
				commonVo.setAudit_required(object[9].toString());
				commonVo.setSecretarial_auditors(object[10].toString());
				commonVo.setAudit_reporterName(object[11].toString());
				commonVo.setFirmRegNo(object[12].toString());
				commonVo.setAudit_name(object[13].toString());
				commonVo.setAudit_email(object[14].toString());
				commonVo.setErrorCode("1");
				}
			 }
			 else
			 {
				 commonVo.setErrorCode("0"); 
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return commonVo;
	}

	@Override
	public int updateProfile(UserForm companyDtls) throws Exception {
		final String METHOD_NAME="updateProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 int result=0;
		try
		{
		Query query=session.createSQLQuery("update  user_company_details set CompanyName='"+companyDtls.getCompanyName()+"',Address='"+companyDtls.getAddress()+"',CompanyType='"+companyDtls.getCompanyType()+"',FinancialYear='"+companyDtls.getFinancialYear()+"',AgmDueDate='"+companyDtls.getAgmDueDate()+"',AgmDate='"+companyDtls.getAgmDate()+"',AgmNo='"+companyDtls.getAgmNo()+"',ServiceRequired='"+companyDtls.getServiceRequired()+"',NoOfBeforeTask='"+companyDtls.getNoOfBeforeTask()+"' where CompanyId='"+companyDtls.getCompanyId()+"'");	
		result=query.executeUpdate();
		Query queryOne=session.createSQLQuery("update  add_company_directors_info set CompanyName='"+companyDtls.getCompanyName()+"' where CompanyId='"+companyDtls.getCompanyId()+"'");
		queryOne.executeUpdate();
		Query querytwo=session.createSQLQuery("update  add_company_info set CompanyName='"+companyDtls.getCompanyName()+"' where CompanyId='"+companyDtls.getCompanyId()+"'");
		querytwo.executeUpdate();
		result=1;
		transaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.EXIT);
	return result;
	}

	@Override
	public String retriveDirDetails(String dirID) throws Exception {
		StringBuffer stringBuffer=new StringBuffer();
        final String METHOD_NAME="retriveDirDetails";
        ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		Session session = sessionFactory.openSession();
		try
		{
		Query query=session.createSQLQuery("select DirectorType from add_company_directors_info where Dir_ID='"+dirID+"'");	
		String dirtype=query.list().get(0)+""; 
		if(dirtype.equalsIgnoreCase("Director")||dirtype.equalsIgnoreCase("AdditionalDirector")||dirtype.equalsIgnoreCase("PropossedNewDirector"))
		{
		Query query2=session.createSQLQuery("select DirectorType,DirectorName,Gender,DIN,Designation,Address,DirEmail,RetiredDirectors from add_company_directors_info where Dir_ID='"+dirID+"'");
		List list=query2.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object object[] = (Object[]) iterator.next();
			stringBuffer.append(object[0].toString()+"&"+object[1].toString()+"&"+object[2].toString()+"&"+object[3].toString()+"&"+object[4].toString()+"&"+object[5].toString()+"&"+object[6].toString()+"&"+object[7].toString());
		}
		}
		if(dirtype.equalsIgnoreCase("StatutaryAuditors"))
		{
			Query query2=session.createSQLQuery("select DirectorType,DirectorName,DirEmail,RegistrationNumber,TypeOfAuditor from add_company_directors_info where Dir_ID='"+dirID+"'");
			List list=query2.list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object[] = (Object[]) iterator.next();
				stringBuffer.append(object[0].toString()+"&"+object[1].toString()+"&"+object[2].toString()+"&"+object[3].toString()+"&"+object[4].toString());
			}
		}
		if(dirtype.equalsIgnoreCase("CompanySecretary"))
		{
			Query query2=session.createSQLQuery("select DirectorType,DirectorName,DirEmail,MemberShipNo,PanNumber from add_company_directors_info where Dir_ID='"+dirID+"'");
			List list=query2.list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object[] = (Object[]) iterator.next();
				stringBuffer.append(object[0].toString()+"&"+object[1].toString()+"&"+object[2].toString()+"&"+object[3].toString()+"&"+object[4].toString());
			}
			
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
		return stringBuffer+"";
	}

	@Override
	public int updateDirectorProfile(UserForm companyDtls) throws Exception {
		final String METHOD_NAME="updateProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 int result=0;
		 Query query = null;
		 try
		 {
			 if(companyDtls.getHdDirType().equalsIgnoreCase("Director")||companyDtls.getHdDirType().equalsIgnoreCase("AdditionalDirector")||companyDtls.getHdDirType().equalsIgnoreCase("PropossedNewDirector"))
		 {
			query=session.createSQLQuery("update  add_company_directors_info set DirectorName='"+companyDtls.getDirectorName()+"',Gender='"+companyDtls.getGender()+"',DIN='"+companyDtls.getdIN()+"',Designation='"+companyDtls.getDesignation()+"',DirEmail='"+companyDtls.getEmail()+"',Address='"+companyDtls.getAddress()+"' where Dir_ID='"+companyDtls.getHdDirId()+"'");
		 }
		if(companyDtls.getHdDirType().equalsIgnoreCase("StatutaryAuditors"))
			 {
			query=session.createSQLQuery("update  add_company_directors_info set DirectorName='"+companyDtls.getStrdirectorName()+"',DirEmail='"+companyDtls.getStaemail()+"',RegistrationNumber='"+companyDtls.getRegistrationNumber()+"',TypeOfAuditor='"+companyDtls.getTypeOfAuditor()+"' where Dir_ID='"+companyDtls.getHdDirId()+"'"); 
			 }
		if(companyDtls.getHdDirType().equalsIgnoreCase("CompanySecretary"))
			 {
			query=session.createSQLQuery("update  add_company_directors_info set DirectorName='"+companyDtls.getSecdirectorName()+"',DirEmail='"+companyDtls.getSecEmail()+"',MemberShipNo='"+companyDtls.getMemberShipNo()+"',PanNumber='"+companyDtls.getPanNumber()+"' where Dir_ID='"+companyDtls.getHdDirId()+"'"); 
			 }
				
			 result=query.executeUpdate(); 
			 transaction.commit();
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
	public int deleteDirDtls(String dirID) throws Exception {
		final String METHOD_NAME="addCompnayDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 int res=0;
		 try
		 {
		Query query=session.createSQLQuery("delete  from add_company_directors_info where Dir_ID='"+dirID+"'");	
		res=query.executeUpdate();
		res=3;
		transaction.commit();
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
		 return res;
	}

	@Override
	public int updateCompanyInfoProfile(UserForm companyInfoOneForm)
			throws Exception {
		final String METHOD_NAME="updateCompanyInfoProfile";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 int res=0;
		 try
		 {
		Query query=session.createSQLQuery("update add_company_info set BoardVenue='"+companyInfoOneForm.getBoardVenue()+"',BoardTime='"+companyInfoOneForm.getBoardTime()+"',AGMVenue='"+companyInfoOneForm.getAgmVenue()+"',AGMTime='"+companyInfoOneForm.getAgmTime()+"',Nature='"+companyInfoOneForm.getNature_sauditor()+"',SDPeriod='"+companyInfoOneForm.getSdPeriod()+"' where CompanyId='"+companyInfoOneForm.getCompanyId()+"'");	
		res=query.executeUpdate();
		transaction.commit();
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
		 return res;
	}

	@Override
	public int updateCompanyInfoProfileBMPM(CompanyInfoTwo companyinfoSecond)
			throws Exception {
		final String METHOD_NAME="updateCompanyInfoProfileBMPM";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 int res=0;
		 try
		 {
		Query query=session.createSQLQuery("update add_company_info_second set Dividend_Proposed_Paid='"+companyinfoSecond.getDividend_paid_out()+"',Yes_Dividend_Proposed_Paid='"+companyinfoSecond.getYes_dividend_proposed_paid()+"',Dividend_Paid_Out='"+companyinfoSecond.getDividend_paid_out()+"',No_Fully_Paid='"+companyinfoSecond.getNo_fully_paid()+"',Face_Value='"+companyinfoSecond.getFace_value_Eshare()+"',Record_Date='"+companyinfoSecond.getRecord_date()+"',Dividend_Amounts='"+companyinfoSecond.getDividend_amounts()+"',Bank_Account='"+companyinfoSecond.getBank_account()+"',Audit_Required='"+companyinfoSecond.getAudit_required()+"',Secretarial_Auditors='"+companyinfoSecond.getSecretarial_auditors()+"',Audit_ReporterName='"+companyinfoSecond.getAudit_reporterName()+"',FirmRegNo='"+companyinfoSecond.getFirmRegNo()+"',Audit_Name='"+companyinfoSecond.getAudit_name()+"',Audit_Email='"+companyinfoSecond.getAudit_email()+"' where Company_Id='"+companyinfoSecond.getCompanyId()+"'");	
		res=query.executeUpdate();
		transaction.commit();
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
		 return res;
	}

	@Override
	public int deleteCompanyProfile(String companyid) throws Exception {
		final String METHOD_NAME="addCompnayDetails";
		ceaLogMgr.writeToError(CeaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME, CeaConstants.ENTRY);
		 Session session = sessionFactory.openSession();
		 Transaction transaction=session.beginTransaction();
		 int res=0;
		 try
		 {
		Query query=session.createSQLQuery("delete  from user_company_details where CompanyId='"+companyid+"'");	
		res=query.executeUpdate();
		Query queryOne=session.createSQLQuery("delete  from add_company_directors_info where CompanyId='"+companyid+"'");	
		res=queryOne.executeUpdate();
		Query queryTwo=session.createSQLQuery("delete  from add_company_info_second where Company_Id='"+companyid+"'");	
		res=queryTwo.executeUpdate();
		Query queryThree=session.createSQLQuery("delete  from add_company_info where CompanyId='"+companyid+"'");	
		res=queryThree.executeUpdate();
		Query queryFour=session.createSQLQuery("delete  from add_other_director_info where CompanyId='"+companyid+"'");	
		res=queryFour.executeUpdate();
		res=2;
		transaction.commit();
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
		 return res;
	}
	
	
}
