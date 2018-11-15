$(document).ready(function()
{
	var emailRegex =/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	$('#alldir').hide();
	$('#directorListDat').hide();
	$('#staAuditor').hide();
	$('#companySecratary').hide();
	$('#logout').click(function(e)
			{
				document.logOutForm.action="logOut.html";
			 	document.logOutForm.method="POST";
			 	document.logOutForm.submit();	
			});
	$(".number").keypress(function(e) {
		 if( e.which!=8 && e.which!=0 && (e.which<48 || e.which>57)) {
			return false;
	      }	
	});

$('#getdetails').click(function(e)
{
	if($('#companyId').val()=="sel")
		{
		
		$('#errcname').show();
		$('#errcname').html("Should not empty").css('color', 'red');
		$('#companyId').focus();
		return false;
		}
	else
		{
	    document.editDeleteForm.action="retriveAllCompanyDetails.html";
	 	document.editDeleteForm.method="POST";
	 	document.editDeleteForm.submit();
}
});
$('#directorName').change(function(e)
		{
			if($('#directorName').val()=="sel")
				{
				/*$('#alldir').hide();
				$('#directorListDat').hide();
				$('#staAuditor').hide();
				$('#companySecratary').hide();*/
				$('#errDirName').show();
				$('#errDirName').html("Select Director Name").css('color', 'red');
				$('#directorName').focus();
				return false;
				}
			else
				{
			  var queryString ="directorId="+$('#directorName').val().split("-")[0];
			 $.ajax({  
				 type: "GET", 
				 url: "./retriveDirDetails.html", 
				 data: queryString, 
				 cache: false,
				 success: function(response){ 
					 if(response!="")
					 {
						 $('#hdDirId').val($('#directorName').val().split("-")[0]);
						// alert("response==="+response); 
						 var result=response.split("&");
						 if(result[0]=="Director"||result[0]=="AdditionalDirector"||result[0]=="PropossedNewDirector")
							 {
							    $('#alldir').show();
								$('#directorListDat').show();
								$('#staAuditor').hide();
								$('#companySecratary').hide();
								$('#director').val(result[1]);
								$('#gender').val(result[2]);
								$('#din').val(result[3]);
								$('#designation').val(result[4]);
								$('#diraddress').val(result[5]);
								$('#email').val(result[6]);
								$('#hdDirType').val(result[0]);
							}
						 
						 if(result[0]=="StatutaryAuditors")
						 {
							 $('#alldir').show();
								$('#directorListDat').hide();
								$('#staAuditor').show();
								$('#companySecratary').hide();
								$('#StadirectorName').val(result[1]);
								$('#Staemail').val(result[2]);
								$('#registrationNumber').val(result[3]);
								$('#typeOfAuditor').val(result[4]);
								$('#hdDirType').val(result[0]);
								
						 }
						 if(result[0]=="CompanySecretary")
							 {
							 $('#alldir').show();
								$('#directorListDat').hide();
								$('#staAuditor').hide();
								$('#companySecratary').show();
								$('#SecdirectorName').val(result[1]);
								$('#Secemail').val(result[2]);
								$('#memberShipNo').val(result[3]);
								$('#panNumber').val(result[4]);
								$('#hdDirType').val(result[0]);
							 }
						 else
							 {
							
							 }
					 }else {
						 
						// alert("No Data Found with The Given Details..");
					 }
				 },
				 error: function(e){ 
					
				 },
			     failure: function(e){ 
					 alert('Error: ' + e); 
				 }						 
			 });  
		
		}
		});


$('#update').click(function(e)
		{
	if($('#companyName').val()=="")
		{
		$('#errorcompanyName').show();
		$('#errorcompanyName').html("CompanyName Should not empty").css('color', 'red');
		$('#companyName').focus();
		return false;
		}
	else if($('#companyName').val().length<4)
	{
		$('#errorcompanyName').show();
		$('#errorcompanyName').html("companyName Not Less Than 4 charcters").css('color', 'red');
		$('#companyName').focus();
		return false;
	}
	if($('#address').val()=="")
	{
	$('#errAddress').show();
	$('#errAddress').html("Address Should not empty").css('color', 'red');
	$('#address').focus();
	return false;
	}
else if($('#address').val().length<4)
{
	$('#errAddress').show();
	$('#errAddress').html("Adress Not Less Than 4 charcters").css('color', 'red');
	$('#address').focus();
	return false;
}
	if($('#companyType').val()=="sel")
		{
		$('#errCompanyType').show();
		$('#errCompanyType').html("Select Type").css('color', 'red');
		$('#companyType').focus();
		return false;
		}
	if($('#financialYear').val()=="")
	{
	$('#errfinancialYear').show();
	$('#errfinancialYear').html("FinancialYear should not empty").css('color', 'red');
	$('#financialYear').focus();
	return false;
	}
	if($('#agmDueDate').val()=="")
	{
	$('#erragmDueDate').show();
	$('#erragmDueDate').html("AgmDueDate should not empty").css('color', 'red');
	$('#agmDueDate').focus();
	return false;
	}
	if($('#agmDate').val()=="")
	{
	$('#erragmDate').show();
	$('#erragmDate').html("AgmDate should not empty").css('color', 'red');
	$('#agmDate').focus();
	return false;
	}
	
	if($('#agmNo').val()=="")
	{
	$('#erragmNo').show();
	$('#erragmNo').html("Agm No  should not empty").css('color', 'red');
	$('#agmNo').focus();
	return false;
	}
	if($('#serviceRequired').val()=="sel")
		{
		$('#errserviceRequired').show();
		$('#errserviceRequired').html("Select Service Required ").css('color', 'red');
		$('#serviceRequired').focus();
		return false;
		}
		if($('#noOfBeforeTask').val()==""||$('#noOfBeforeTask').val()=="0")
	{
	$('#errnoOfBeforeTask').show();
	$('#errnoOfBeforeTask').html("should not empty or Not Allow 0 ").css('color', 'red');
	$('#noOfBeforeTask').focus();
	return false;
	}
	
	if(confirm("Do You Want Update Company Information"))
	{
	document.companyDtls.action="updateProfile.html";
 	document.companyDtls.method="POST";
 	document.companyDtls.submit();
	}
	});
$('#delete').click(function(e)
		{
	
	if(confirm("Do You Want Delete Complete Company Information"))
		{
	document.companyDtls.action="deleteCompanyProfile.html";
 	document.companyDtls.method="POST";
 	document.companyDtls.submit();
		}
	});

$('#updateOne').click(function(e)
		{
	if($('#director').val()=="")
	{
	$('#errdirectorName').show();
	$('#errdirectorName').html("Director Name  should not empty").css('color', 'red');
	$('#director').focus();
	return false;
	}
	else if($('#director').val().length<4)
{
	$('#errdirectorName').show();
	$('#errdirectorName').html("Director Name Not Less Than 4 charcters").css('color', 'red');
	$('#director').focus();
	return false;
}	
if($('#gender').val()=="sel")
	{
	$('#errgender').show();
	$('#errgender').html("Select Gender Type").css('color', 'red');
	$('#gender').focus();
	return false;
	}	
	if($('#din').val()=="")
	{
	$('#errdin').show();
	$('#errdin').html("Din should not empty").css('color', 'red');
	$('#din').focus();
	return false;
	}
else if($('#din').val().length<4)
{
	$('#errdin').show();
	$('#errdin').html("Din Number Not Less Than 4 charcters").css('color', 'red');
	$('#din').focus();
	return false;
}
if($('#designation').val()=="")
	{
	$('#errdesignation').show();
	$('#errdesignation').html("Designation should not empty").css('color', 'red');
	$('#designation').focus();
	return false;
	}
else if($('#designation').val().length<4)
{
	$('#errdesignation').show();
	$('#errdesignation').html("Designation Not Less Than 4 charcters").css('color', 'red');
	$('#designation').focus();
	return false;
}	
if($('#diraddress').val()=="")
	{
	$('#errAddress1').show();
	$('#errAddress1').html(" Address Should not empty").css('color', 'red');
	$('#diraddress').focus();
	return false;
	}
else if($('#diraddress').val().length<4)
{
	$('#errAddress1').show();
	$('#errAddress1').html("Adress Not Less Than 4 charcters").css('color', 'red');
	$('#diraddress').focus();
	return false;
}
       if($('#email').val()=="")
    		{
    	   $('#erremail').show();
    		$('#erremail').html("Does Not Allow Empty email Id").css('color', 'red');
    		$('#email').focus();
    		return false;
    		}
       	 if(emailRegex.test($('#email').val()) == false)
		{
       	$('#erremail').show();
    	$('#erremail').html("Not a valid email adrress").css('color', 'red');
		$('#email').focus();
		return false;
		}
if(confirm("Do You Want Update Director Information"))
		{
	document.diretcrListForm.action="updateDirectorProfile.html";
 	document.diretcrListForm.method="POST";
 	document.diretcrListForm.submit();
		}});

$('#StaAuditorupdateOne').click(function(e)
		{
			if($('#StadirectorName').val()=="")
	{
	$('#errStadirectorName').show();
	$('#errStadirectorName').html("Statutary Director Name  should not empty").css('color', 'red');
	$('#StadirectorName').focus();
	return false;
	}
	else if($('#StadirectorName').val().length<4)
{
	$('#errStadirectorName').show();
	$('#errStadirectorName').html(" Statutary Director Name Not Less Than 4 charcters").css('color', 'red');
	$('#StadirectorName').focus();
	return false;
}	
if($('#Staemail').val()=="")
    		{
    		$('#errStaemail').html("Does Not Allow Empty email Id");
    		$('#Staemail').focus();
    		return false;
    		}
       	 if(emailRegex.test($('#Staemail').val()) == false)
		{
    	$('#errStaemail').html("Not a valid email adrress");
		$('#Staemail').focus();
		return false;
		}
		if($('#registrationNumber').val()=="")
	{
	$('#errRegNO').show();
	$('#errRegNO').html("Statutary Director Name  should not empty").css('color', 'red');
	$('#registrationNumber').focus();
	return false;
	}
	else if($('#registrationNumber').val().length<4)
{
	$('#errRegNO').show();
	$('#errRegNO').html(" Statutary Director Name Not Less Than 4 charcters").css('color', 'red');
	$('#registrationNumber').focus();
	return false;
}	
if($('#typeOfAuditor').val()=="")
	{
	$('#errAuditor').show();
	$('#errAuditor').html("Auditor Name  should not empty").css('color', 'red');
	$('#typeOfAuditor').focus();
	return false;
	}
	else if($('#typeOfAuditor').val().length<4)
{
	$('#errAuditor').show();
	$('#errAuditor').html(" Auditor Director Name Not Less Than 4 charcters").css('color', 'red');
	$('#typeOfAuditor').focus();
	return false;
}	
if(confirm("Do You Want Update Director Information"))
		{
	document.diretcrListForm.action="updateDirectorProfile.html";
 	document.diretcrListForm.method="POST";
 	document.diretcrListForm.submit();
		}});
$('#ComSecupdateOne').click(function(e)
		{
			if($('#SecdirectorName').val()=="")
	{
	$('#errSecdirectorName').show();
	$('#errSecdirectorName').html("Secretary Name  should not empty").css('color', 'red');
	$('#SecdirectorName').focus();
	return false;
	}
	else if($('#SecdirectorName').val().length<4)
{
	$('#errSecdirectorName').show();
	$('#errSecdirectorName').html("Secretary Name Not Less Than 4 charcters").css('color', 'red');
	$('#SecdirectorName').focus();
	return false;
}	
if($('#Secemail').val()=="")
    		{
    		$('#errSecemail').html("Does Not Allow Empty email Id");
    		$('#Secemail').focus();
    		return false;
    		}
       	 if(emailRegex.test($('#Secemail').val()) == false)
		{
    	$('#errSecemail').html("Not a valid email adrress");
		$('#Secemail').focus();
		return false;
		}
	if($('#memberShipNo').val()=="")
	{
	$('#errmemberShipNo').show();
	$('#errmemberShipNo').html("MemberShip  should not empty").css('color', 'red');
	$('#memberShipNo').focus();
	return false;
	}
	else if($('#memberShipNo').val().length<4)
{
	$('#errmemberShipNo').show();
	$('#errmemberShipNo').html("MemberShip Not Less Than 4 charcters").css('color', 'red');
	$('#memberShipNo').focus();
	return false;
}	
if($('#panNumber').val()=="")
	{
	$('#errpanNumber').show();
	$('#errpanNumber').html("Pan Number  should not empty").css('color', 'red');
	$('#panNumber').focus();
	return false;
	}
	else if($('#panNumber').val().length>11)
{
	$('#errpanNumber').show();
	$('#errpanNumber').html("Pan Number  Must Be 10 charcters").css('color', 'red');
	$('#panNumber').focus();
	return false;
}

if(confirm("Do You Want Update Director Information"))
		{
	document.diretcrListForm.action="updateDirectorProfile.html";
 	document.diretcrListForm.method="POST";
 	document.diretcrListForm.submit();
		}});
$('#updateTwo').click(function(e)
		{
	if($('#boardVenue').val()=="")
	{
	$('#errboardVenue').show();
	$('#errboardVenue').html("Board Venue should not empty").css('color', 'red');
	$('#boardVenue').focus();
	return false;
	}
	else if($('#boardVenue').val().length<4)
{
	$('#errboardVenue').show();
	$('#errboardVenue').html("Board Venue  Not Less Than 4 charcters").css('color', 'red');
	$('#boardVenue').focus();
	return false;
}
	
if($('#boardTime').val()=="")
	{
	$('#errboardTime').show();
	$('#errboardTime').html("Board Time should not empty").css('color', 'red');
	$('#boardTime').focus();
	return false;
	}
	/*else if($('#boardTime').val().length>4)
{
	$('#errboardTime').show();
	$('#errboardTime').html("Board Time  Not Greater Than 5 charcters").css('color', 'red');
	$('#boardTime').focus();
	return false;
}*/
if($('#agmVenue').val()=="")
	{
	$('#erragmVenue').show();
	$('#erragmVenue').html("Board Venue should not empty").css('color', 'red');
	$('#agmVenue').focus();
	return false;
	}
	else if($('#agmVenue').val().length<5)
{
	$('#erragmVenue').show();
	$('#erragmVenue').html("Board Venue  Not Less Than 5 charcters").css('color', 'red');
	$('#agmVenue').focus();
	return false;
}
if($('#nature_sauditor').val()=="")
{
$('#errnature_sauditor').show();
$('#errnature_sauditor').html("Board Venue should not empty").css('color', 'red');
$('#nature_sauditor').focus();
return false;
}
else if($('#nature_sauditor').val().length<4)
{
$('#errnature_sauditor').show();
$('#errnature_sauditor').html("Board Venue  Not Less Than 4 charcters").css('color', 'red');
$('#nature_sauditor').focus();
return false;
}
/*
if($('#agmTime').val()=="")
	{
	$('#erragmTime').show();
	$('#erragmTime').html("Board Venue should not empty").css('color', 'red');
	$('#agmTime').focus();
	return false;
	}
	else if($('#agmTime').val().length>6)
{
	$('#erragmTime').show();
	$('#erragmTime').html("Agm time  should not empty").css('color', 'red');
	$('#agmTime').focus();
	return false;
}

if($('#sdPeriod').val()=="")
	{
	$('#errsdPeriod').show();
	$('#errsdPeriod').html("Sd Period should not empty").css('color', 'red');
	$('#sdPeriod').focus();
	return false;
	}
	else if($('#sdPeriod').val().length<4)
{
	$('#errsdPeriod').show();
	$('#errsdPeriod').html("Sd Period Not Less Than 4 charcters").css('color', 'red');
	$('#sdPeriod').focus();
	return false;
}*/
if(confirm("Do You Want Update Director Information"))
		{
	document.companyInfoOneForm.action="updateCompanyInfoProfile.html";
 	document.companyInfoOneForm.method="POST";
 	document.companyInfoOneForm.submit();
		}});
$('#updateThree').click(function(e)
		{
	if($('#dividend_proposed_paid').val()=="sel")
	{
	$('#errdividend_proposed_paid').show();
	$('#errdividend_proposed_paid').html("Select Dividend proposed paid").css('color', 'red');
	$('#dividend_proposed_paid').focus();
	return false;
	}
	
if($('#yes_dividend_proposed_paid').val()=="")
	{
	$('#erryes_dividend_proposed_paid').show();
	$('#erryes_dividend_proposed_paid').html(" Dividend proposed paid should not empty").css('color', 'red');
	$('#yes_dividend_proposed_paid').focus();
	return false;
	}
	/*else if($('#yes_dividend_proposed_paid').val().length<2)
{
	$('#erryes_dividend_proposed_paid').show();
	$('#erryes_dividend_proposed_paid').html("Dividend proposed paid Not Less Than 2 charcters").css('color', 'red');
	$('#yes_dividend_proposed_paid').focus();
	return false;
}*/
if($('#dividend_paid_out').val()=="sel")
	{
	$('#errdividend_paid_out').show();
	$('#errdividend_paid_out').html("Select  Dividend paid should ").css('color', 'red');
	$('#dividend_paid_out').focus();
	return false;
	}
	
if($('#no_fully_paid').val()=="")
	{
	$('#errno_fully_paid').show();
	$('#errno_fully_paid').html("No fully paid should not empty").css('color', 'red');
	$('#no_fully_paid').focus();
	return false;
	}
	/*else if($('#no_fully_paid').val().length<4)
{
	$('#errno_fully_paid').show();
	$('#errno_fully_paid').html("No fully paid Not Less Than 4 charcters").css('color', 'red');
	$('#no_fully_paid').focus();
	return false;
}*/
if($('#face_value_Eshare').val()=="")
	{
	$('#errface_value_Eshare').show();
	$('#errface_value_Eshare').html("Face value Eshare should not empty").css('color', 'red');
	$('#face_value_Eshare').focus();
	return false;
	}
	/*else if($('#face_value_Eshare').val().length>3)
{
	$('#errface_value_Eshare').show();
	$('#errface_value_Eshare').html("Face value Eshare Not Greater Than 3 charcters").css('color', 'red');
	$('#face_value_Eshare').focus();
	return false;
}*/
if($('#record_date').val()=="")
	{
	$('#errrecord_date').show();
	$('#errrecord_date').html("Record Date should not empty").css('color', 'red');
	$('#record_date').focus();
	return false;
	}
	if($('#dividend_amounts').val()=="")
	{
	$('#errdividend_amounts').show();
	$('#errdividend_amounts').html("Dividend Amounts should not empty").css('color', 'red');
	$('#dividend_amounts').focus();
	return false;
	}
	if($('#bank_account').val()=="")
	{
	$('#errbank_account').show();
	$('#errbank_account').html("Bank Account should not empty").css('color', 'red');
	$('#bank_account').focus();
	return false;
	}
	if($('#secretarial_auditors').val()=="")
	{
	$('#errsecretarial_auditors').show();
	$('#errsecretarial_auditors').html("Secretarial Auditors should not empty").css('color', 'red');
	$('#secretarial_auditors').focus();
	return false;
	}
	else if($('#secretarial_auditors').val().length<4)
{
	$('#errsecretarial_auditors').show();
	$('#errsecretarial_auditors').html("Secretarial Auditors Not Less Than 4 charcters").css('color', 'red');
	$('#secretarial_auditors').focus();
	return false;
}
	if($('#audit_reporterName').val()=="")
	{
	$('#erraudit_reporterName').show();
	$('#erraudit_reporterName').html("Audit Reporter Name should not empty").css('color', 'red');
	$('#audit_reporterName').focus();
	return false;
	}
	else if($('#audit_reporterName').val().length<4)
{
	$('#erraudit_reporterName').show();
	$('#erraudit_reporterName').html("Audit Reporter Name Not Less Than 4 charcters").css('color', 'red');
	$('#audit_reporterName').focus();
	return false;
}
if($('#firmRegNo').val()=="")
	{
	$('#errfirmRegNo').show();
	$('#errfirmRegNo').html("Firm RegNo should not empty").css('color', 'red');
	$('#firmRegNo').focus();
	return false;
	}
	else if($('#firmRegNo').val().length<4)
{
	$('#errfirmRegNo').show();
	$('#errfirmRegNo').html("Firm RegNo Not Less Than 4 charcters").css('color', 'red');
	$('#firmRegNo').focus();
	return false;
}
if($('#firmRegNo').val()=="")
	{
	$('#erraudit_name').show();
	$('#erraudit_name').html("Audit Name should not empty").css('color', 'red');
	$('#audit_name').focus();
	return false;
	}
	else if($('#audit_name').val().length<4)
{
	$('#erraudit_name').show();
	$('#erraudit_name').html("Audit Name Not Less Than 4 charcters").css('color', 'red');
	$('#audit_name').focus();
	return false;
}
			
	if(confirm("Do You Want Update Director Information"))
		{
	document.companyinfoSecond.action="updateCompanyInfoProfileBMPM.html";
 	document.companyinfoSecond.method="POST";
 	document.companyinfoSecond.submit();
		}});
$('#deleteDir').click(function(e)
		{
	document.diretcrListForm.action="deleteDirDtls.html";
 	document.diretcrListForm.method="POST";
 	document.diretcrListForm.submit();
		});
$('#StaAuditordelete').click(function(e)
		{
	document.diretcrListForm.action="deleteDirDtls.html";
 	document.diretcrListForm.method="POST";
 	document.diretcrListForm.submit();
		});
$('#ComSecdelete').click(function(e)
		{
	document.diretcrListForm.action="deleteDirDtls.html";
 	document.diretcrListForm.method="POST";
 	document.diretcrListForm.submit();
		});
});
