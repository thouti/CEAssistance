package com.cea.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_company_details")
public class CompaneyDetailsDTO {
	@Id
	@Column(name = "CompanyName")
	private String CompanyName;
	
	@Column(name = "CompanyId")
	private String CompanyId;
	@Column(name = "UserId")
	private String UserId;
	
	@Column(name = "Address")
	private String Address;
	@Column(name = "CompanyType")
	private String CompanyType;
	@Column(name = "FinancialYear")
	private String FinancialYear;
	@Column(name = "AgmDueDate")
	private String AgmDueDate;
	@Column(name = "AgmDate")
	private String AgmDate;
	@Column(name = "AgmNo")
	private String AgmNo;
	@Column(name = "ServiceRequired")
	private String ServiceRequired;
	@Column(name = "NoOfBeforeTask")
	private String NoOfBeforeTask;
	
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAddress() {
		return Address;
	}
	public void setCompanyType(String companyType) {
		CompanyType = companyType;
	}
	public String getCompanyType() {
		return CompanyType;
	}
	public void setFinancialYear(String financialYear) {
		FinancialYear = financialYear;
	}
	public String getFinancialYear() {
		return FinancialYear;
	}
	public void setAgmDueDate(String agmDueDate) {
		AgmDueDate = agmDueDate;
	}
	public String getAgmDueDate() {
		return AgmDueDate;
	}
	public void setAgmDate(String agmDate) {
		AgmDate = agmDate;
	}
	public String getAgmDate() {
		return AgmDate;
	}
	public void setAgmNo(String agmNo) {
		AgmNo = agmNo;
	}
	public String getAgmNo() {
		return AgmNo;
	}
	public void setServiceRequired(String serviceRequired) {
		ServiceRequired = serviceRequired;
	}
	public String getServiceRequired() {
		return ServiceRequired;
	}
	public void setNoOfBeforeTask(String noOfBeforeTask) {
		NoOfBeforeTask = noOfBeforeTask;
	}
	public String getNoOfBeforeTask() {
		return NoOfBeforeTask;
	}
	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}
	public String getCompanyId() {
		return CompanyId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserId() {
		return UserId;
	}
	
	}
