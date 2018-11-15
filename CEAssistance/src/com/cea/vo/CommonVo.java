package com.cea.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommonVo implements Serializable {
	private String fristName;
	private String lastName;
	private String email;
	private String mobile;
	private String dob;
	private String regDate;
	private String userId;
	private String paymentStatus;
	private String companyName;
	private String companyId;
	private String errorCode;
	private String dirName;
	private String dirType;
	private String agmDate;
	private String noOfDays;
	private String dirEmail;
	private String emailContent;
	private String subject;
	private String agmDueDate;
	private String agmVenue;
	private String agmTime;
	private String boardVenue;
	private String boardTime;
	private String directorId;
	private String retiredDirectors;
	private String statutaryType;
	private String nature;
	private String firmRegNo;
	private String dirId;
	
	private String address;
	private String companyType;
	private String financialYear;
	private String agmNo;
	private String serviceRequired;
	private String noOfBeforeTask;
	private String sdPeriod;
	
	private String dividend_proposed_paid;
	private String yes_dividend_proposed_paid;
	private String dividend_paid_out;
	private String no_fully_paid;
	private String face_value_Eshare;
	private String record_date;
	private String dividend_amounts;
	private String bank_account;
	private String unpaid_unclaimed;
	private String audit_required;
	private String secretarial_auditors;
	private String audit_reporterName;
	private String audit_name;
	private String audit_email;
	private String audit_address;
	
	public String getFirmRegNo() {
		return firmRegNo;
	}

	public void setFirmRegNo(String firmRegNo) {
		this.firmRegNo = firmRegNo;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getStatutaryType() {
		return statutaryType;
	}

	public void setStatutaryType(String statutaryType) {
		this.statutaryType = statutaryType;
	}

	public String getRetiredDirectors() {
		return retiredDirectors;
	}

	public void setRetiredDirectors(String retiredDirectors) {
		this.retiredDirectors = retiredDirectors;
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public String getDirType() {
		return dirType;
	}

	public void setDirType(String dirType) {
		this.dirType = dirType;
	}

	public String getAgmDate() {
		return agmDate;
	}

	public void setAgmDate(String agmDate) {
		this.agmDate = agmDate;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getDirEmail() {
		return dirEmail;
	}

	public void setDirEmail(String dirEmail) {
		this.dirEmail = dirEmail;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAgmDueDate() {
		return agmDueDate;
	}

	public void setAgmDueDate(String agmDueDate) {
		this.agmDueDate = agmDueDate;
	}

	public String getAgmVenue() {
		return agmVenue;
	}

	public void setAgmVenue(String agmVenue) {
		this.agmVenue = agmVenue;
	}

	public String getAgmTime() {
		return agmTime;
	}

	public void setAgmTime(String agmTime) {
		this.agmTime = agmTime;
	}

	public String getBoardVenue() {
		return boardVenue;
	}

	public void setBoardVenue(String boardVenue) {
		this.boardVenue = boardVenue;
	}

	public String getBoardTime() {
		return boardTime;
	}

	public void setBoardTime(String boardTime) {
		this.boardTime = boardTime;
	}

	public String getDirId() {
		return dirId;
	}

	public void setDirId(String dirId) {
		this.dirId = dirId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getAgmNo() {
		return agmNo;
	}

	public void setAgmNo(String agmNo) {
		this.agmNo = agmNo;
	}

	public String getServiceRequired() {
		return serviceRequired;
	}

	public void setServiceRequired(String serviceRequired) {
		this.serviceRequired = serviceRequired;
	}

	public String getNoOfBeforeTask() {
		return noOfBeforeTask;
	}

	public void setNoOfBeforeTask(String noOfBeforeTask) {
		this.noOfBeforeTask = noOfBeforeTask;
	}

	public String getSdPeriod() {
		return sdPeriod;
	}

	public void setSdPeriod(String sdPeriod) {
		this.sdPeriod = sdPeriod;
	}

	public String getDividend_proposed_paid() {
		return dividend_proposed_paid;
	}

	public void setDividend_proposed_paid(String dividend_proposed_paid) {
		this.dividend_proposed_paid = dividend_proposed_paid;
	}

	public String getYes_dividend_proposed_paid() {
		return yes_dividend_proposed_paid;
	}

	public void setYes_dividend_proposed_paid(String yes_dividend_proposed_paid) {
		this.yes_dividend_proposed_paid = yes_dividend_proposed_paid;
	}

	public String getDividend_paid_out() {
		return dividend_paid_out;
	}

	public void setDividend_paid_out(String dividend_paid_out) {
		this.dividend_paid_out = dividend_paid_out;
	}

	public String getNo_fully_paid() {
		return no_fully_paid;
	}

	public void setNo_fully_paid(String no_fully_paid) {
		this.no_fully_paid = no_fully_paid;
	}

	public String getFace_value_Eshare() {
		return face_value_Eshare;
	}

	public void setFace_value_Eshare(String face_value_Eshare) {
		this.face_value_Eshare = face_value_Eshare;
	}

	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}

	public String getDividend_amounts() {
		return dividend_amounts;
	}

	public void setDividend_amounts(String dividend_amounts) {
		this.dividend_amounts = dividend_amounts;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public String getUnpaid_unclaimed() {
		return unpaid_unclaimed;
	}

	public void setUnpaid_unclaimed(String unpaid_unclaimed) {
		this.unpaid_unclaimed = unpaid_unclaimed;
	}

	public String getAudit_required() {
		return audit_required;
	}

	public void setAudit_required(String audit_required) {
		this.audit_required = audit_required;
	}

	public String getSecretarial_auditors() {
		return secretarial_auditors;
	}

	public void setSecretarial_auditors(String secretarial_auditors) {
		this.secretarial_auditors = secretarial_auditors;
	}

	public String getAudit_reporterName() {
		return audit_reporterName;
	}

	public void setAudit_reporterName(String audit_reporterName) {
		this.audit_reporterName = audit_reporterName;
	}

	public String getAudit_name() {
		return audit_name;
	}

	public void setAudit_name(String audit_name) {
		this.audit_name = audit_name;
	}

	public String getAudit_email() {
		return audit_email;
	}

	public void setAudit_email(String audit_email) {
		this.audit_email = audit_email;
	}

	public String getAudit_address() {
		return audit_address;
	}

	public void setAudit_address(String audit_address) {
		this.audit_address = audit_address;
	}
 
}
