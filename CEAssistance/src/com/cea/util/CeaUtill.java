package com.cea.util;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cea.vo.CommonVo;
@Component
public class CeaUtill
{

	public String convertToString(List<CommonVo> commonVos)
	{
		StringBuffer stringBuffer=new StringBuffer();
		if(commonVos.size()!=0)
		{
			
		for (Iterator iterator = commonVos.iterator(); iterator.hasNext();) 
		{
			CommonVo commonVo = (CommonVo) iterator.next();
			if(Integer.parseInt(commonVo.getErrorCode())==1){
			stringBuffer.append(commonVo.getDirName()+"$"+commonVo.getDirId()+"#");
			}
			else if(Integer.parseInt(commonVo.getErrorCode())==2){
				stringBuffer.append(commonVo.getErrorCode()+"$"+commonVo.getEmailContent());
				}
			else if(Integer.parseInt(commonVo.getErrorCode())!=1)
			{
				stringBuffer.append("0"+"$"+"No Directors Found Given Company");	
			}
		}
		}
		return stringBuffer.toString();
	}

	public String convertDirListToString(List<CommonVo> list) 
	{
		CommonVo commonVo =null;
		StringBuffer stringBuffer=new StringBuffer();
		StringBuffer directorLst=new StringBuffer();
		StringBuffer addDirectorLst=new StringBuffer();
		StringBuffer proposedDirectorLst=new StringBuffer();
		StringBuffer statutaryAuditors=new StringBuffer();
		StringBuffer companySecretary=new StringBuffer();
		String retiredDir="";
		for (Iterator iterator = list.iterator(); iterator.hasNext();) 
		{
			 commonVo = (CommonVo) iterator.next();
			if(commonVo.getDirType().equalsIgnoreCase("Director"))
			{
				directorLst.append(commonVo.getDirName()+"$"+commonVo.getDirEmail()+"$"+commonVo.getDirectorId()+"%");	
				retiredDir=commonVo.getRetiredDirectors();
			}
			if(commonVo.getDirType().equalsIgnoreCase("AdditionalDirector"))
			{
				addDirectorLst.append(commonVo.getDirName()+"$"+commonVo.getDirEmail()+"$"+commonVo.getDirectorId()+"%");	
			}
			else
			if(!commonVo.getDirType().equalsIgnoreCase("AdditionalDirector"))
			{
				addDirectorLst.append("");	
			}
			
			if(commonVo.getDirType().equalsIgnoreCase("PropossedNewDirector"))
			{
				proposedDirectorLst.append(commonVo.getDirName()+"$"+commonVo.getDirEmail()+"$"+commonVo.getDirectorId()+"%");	
			}
			else
			if(!commonVo.getDirType().equalsIgnoreCase("PropossedNewDirector"))
			{
				proposedDirectorLst.append("");	
			}
			if(commonVo.getDirType().equalsIgnoreCase("StatutaryAuditors"))
			{
				statutaryAuditors.append(commonVo.getDirName()+"$"+commonVo.getDirEmail()+"$"+commonVo.getDirectorId()+"%");	
			}
			if(commonVo.getDirType().equalsIgnoreCase("CompanySecretary"))
			{
				companySecretary.append(commonVo.getDirName()+"$"+commonVo.getDirEmail()+"$"+commonVo.getDirectorId()+"%");	
			}
			} 
		stringBuffer.append(commonVo.getEmail()+"~"+commonVo.getAgmDate()+"~"+commonVo.getNoOfDays()+"~"+directorLst+"~"+addDirectorLst+"~"+proposedDirectorLst+"~"+statutaryAuditors+"~"+companySecretary+"~"+commonVo.getAgmDueDate()+"~"+commonVo.getBoardTime()+"~"+commonVo.getBoardVenue()+"~"+commonVo.getAgmTime()+"~"+commonVo.getAgmVenue()+"~"+commonVo.getDirectorId()+"~"+retiredDir+"~"+commonVo.getStatutaryType()+"~"+commonVo.getNature()+"~"+commonVo.getFirmRegNo()+"&&");
		return stringBuffer+"";
	}

	

}
