$(document).ready(function()
{
	$('#logout').click(function(e)
			{
		alert('logout');
			document.logOutForm.action="logOut.html";
			 	document.logOutForm.method="POST";
			 	document.logOutForm.submit();	
			});
	var emailRegex =/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	$('#appt').change(function(e)
	{
		if($('#appt').val()=="reappointment" || $('#appt').val()=="ratification")
		{
			$('#reapp').hide();	
		}
		else
			{
			$('#reapp').show();	
			}
	});
	var gflag=true;
	$('#main').hide();
	
    $('#addCompanyInfo').click(function(e){
	if($('#company_list').val()=='sel')
		{
	$('#error').show();
	$('#error').html("select company name").css('color', 'red');
		}
	else if($('#company_list').val()!='sel'){
		$('#error').show();
		$('#error').html("");
		var flagchk = ChkInfoFields();
		if(flagchk){
			directors();
		    addDirectors();
		    newDirectors();
		    if($('#appt').val()=="appointment")
		    	{
		    	if($('#st_audname_1').val()=="")
		    		{
		    		$('#stat_aud_errdiv').html("Director name not Empty");
		    		$('#st_audname_1').focus();
		    		return false;
		    		}
		    	if($('#st_audname_1').val().length<4)
	    		{
	    		$('#stat_aud_errdiv').html("Director Name Not Less Than 4 charcters");
	    		$('#st_audname_1').focus();
	    		return false;
	    		}
//		    	var intRegex = /[0-9 -()+]+$/;   
//		    	if(!intRegex.test($('#st_audregnum_1').val()))
//	    		{
//	    		$('#stat_aud_errdiv').html("Allow Only Numbers");
//	    		$('#st_audregnum_1').focus();
//	    		return false;
//	    		}
		    	if($('#st_audregnum_1').val()=="")
	    		{
	    		$('#stat_aud_errdiv').html("Registration number not Empty");
	    		$('#st_audregnum_1').focus();
	    		return false;
	    		}
	    	if($('#st_audregnum_1').val().length<4)
    		{
    		$('#stat_aud_errdiv').html("Registration number not Less Than 4 charcters");
    		$('#st_audregnum_1').focus();
    		return false;
    		}
	    	if($('#st_audmail_1').val()=="")
    		{
    		$('#stat_aud_errdiv').html("Does Not Allow Empty value");
    		$('#st_audmail_1').focus();
    		return false;
    		}
	    	if(emailRegex.test($('#st_audmail_1').val()) == false)
	    	{
	    	$('#stat_aud_errdiv').html("Not a valid email adrress");
	    	$('#st_audmail_1').focus();
	    	return false;
	    	}
	    	if($('#st_audname_2').val()=="")
    		{
    		$('#stat_aud_errdiv').html("Director name not Empty");
    		$('#st_audname_2').focus();
    		return false;
    		}
    	if($('#st_audname_2').val().length<4)
		{
		$('#stat_aud_errdiv').html("Director Name Not Less Than 4 charcters");
		$('#st_audname_2').focus();
		return false;
		}
//    	var intRegex = /[0-9 -()+]+$/;   
//    	if(!intRegex.test($('#st_audregnum_2').val()))
//		{
//		$('#stat_aud_errdiv').html("Allow Only Numbers");
//		$('#st_audregnum_2').focus();
//		return false;
//		}
    	if($('#st_audregnum_2').val()=="")
		{
		$('#stat_aud_errdiv').html("Registration number not Empty");
		$('#st_audregnum_2').focus();
		return false;
		}
	if($('#st_audregnum_2').val().length<4)
	{
	$('#stat_aud_errdiv').html("Registration number not Less Than 4 charcters");
	$('#st_audregnum_2').focus();
	return false;
	}
	if($('#st_audmail_2').val()=="")
	{
	$('#stat_aud_errdiv').html("does Not Allow Empty");
	$('#st_audmail_2').focus();
	return false;
	}
if(emailRegex.test($('#st_audmail_2').val()) == false)
{
$('#stat_aud_errdiv').html("Not a valid email adrress");
$('#st_audmail_2').focus();
return false;
}
	/*var emailRegex = '^[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}$';
	alert("1=="+$('#st_audmail_2').val());
	if(emailRegex.test($('#st_audmail_2').val()))
	{
	$('#stat_aud_errdiv').html("Not a valid email adrress");
	$('#st_audmail_2').focus();
	return false;
	}
	*/
	}
		     if($('#appt').val()=="reappointment" || $('#appt').val()=="ratification")
		    	{
		    	if($('#st_audname_1').val()=="")
	    		{
	    		$('#stat_aud_errdiv').html("Statutary Director name not Empty");
	    		$('#st_audname_1').focus();
	    		return false;
	    		}
	    	if($('#st_audname_1').val().length<4)
    		{
    		$('#stat_aud_errdiv').html(" Statutary SDirector Name Not Less Than 4 charcters");
    		$('#st_audname_1').focus();
    		return false;
    		}
//	    	var intRegex = /[0-9 -()+]+$/;   
//	    	if(!intRegex.test($('#st_audregnum_1').val()))
//    		{
//    		$('#stat_aud_errdiv').html("Allow Only Numbers");
//    		$('#st_audregnum_1').focus();
//    		return false;
//    		}
	    	if($('#st_audregnum_1').val()=="")
    		{
    		$('#stat_aud_errdiv').html("Registration number not Empty");
    		$('#st_audregnum_1').focus();
    		return false;
    		}
    	if($('#st_audregnum_1').val().length<4)
		{
		$('#stat_aud_errdiv').html("Registration number not Less Than 4 charcters");
		$('#st_audregnum_1').focus();
		return false;
		}
    	if($('#st_audmail_1').val()=="")
    		{
    		$('#stat_aud_errdiv').html("Does Not Allow Empty email Id");
    		$('#st_audmail_1').focus();
    		return false;
    		}
       	 if(emailRegex.test($('#st_audmail_1').val()) == false)
		{
    	$('#stat_aud_errdiv').html("Not a valid email adrress");
		$('#st_audmail_1').focus();
		return false;
		}
    	}
		   // staAuditors();
		if (confirm("Please Confirm This Details ")){
		   $('#hdComId').val($('#company_list').val());
		    document.addcompany.action="addComponyInfoDtls.html";
		 	document.addcompany.method="POST";
		 	document.addcompany.submit();
		 	return false;
		    }
		 }
	}
	
});
    
    
    function displayalertmessage(msg,div){
    	
    	if(document.getElementById(div)){
    		//div.style.display='inline';
    		document.getElementById(div).innerHTML = "<font color='red'>"+msg+"</font>";
    	}
    }
    function makeERRempty(){
    	var errdiv = ['venue_errdiv','dir_errdiv','retire_dir_errdiv','add_dir_errdiv','new_dir_errdiv','stat_dir_errdiv','stat_aud_errdiv','sec_errdiv'];
    	for(var i=0;i<errdiv.length;i++){
    		if(document.getElementById(errdiv[i]))
    			document.getElementById(errdiv[i]).innerHTML = "";
    	}
    }
	function chkArr(len,arr,subNam,div){
		var flag1=true;
		for(var i=1;i<=len;i++){
			if(flag1){
				for(var j=0;j<arr.length;j++){
					eleObj = document.getElementById(arr[j]+i);
					if(flag1 && eleObj != null ){
						if(eleObj.value == ""){
							displayalertmessage("Please fill data in "+subNam+".",div);flag1 = false;
						}
						else {
							if(j==5 || (j==2 && subNam == "Statutory Auditors")) {
								var mailReg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
								if(mailReg.test(eleObj.value) == false) {
									displayalertmessage("Please give valid E-mail Id in "+subNam+".",div);eleObj.focus();
									flag1 = false;
								}
							}
						}
					}
				}
			}
			else 
				return false;
		}
		return true;
	}
	function ChkInfoFields(){
		// alert("heeeeoooo6666ooo....");//console.log("@@@@@ 39 line...");displayalertmessage("hiii");
		makeERRempty();
		var chkELE = ['brd_met_ven','brd_met_tim','agm_met_ven','agm_met_tim'];
		var len=chkELE.length;
		var txtVal = "";var itrflag = true;
		for(var i=0;i<len;i++){
			txtVal = $("#"+chkELE[i]).val();//console.log("@ 45.. line txtVal is:::"+txtVal+"<------>"+i);
			if( txtVal == "" || txtVal == undefined){
				displayalertmessage("Please give venue information details","venue_errdiv");
				return false;
			}
		}
		var eleObj = null;
		len = document.getElementById('addDirTab').rows.length;
		chkELE = ['d_dirname_','d_gender_','d_din_','d_desig_','d_addr_','d_mail_'];
		gflag = chkArr(len,chkELE,'Directors',"dir_errdiv");
		if(!gflag)
			return false;
		/*
		if($("#retiredDirectors option:selected").length == 0){
			displayalertmessage("please select Retired Director","retire_dir_errdiv");
			return false;
		}
		
		len = document.getElementById('additDirTab').rows.length;
		chkELE = ['a_dirname_','a_gender_','a_din_','a_desig_','a_addr_','a_mail_'];
		gflag = chkArr(len,chkELE,'addtional Directors',"add_dir_errdiv");
		if(!gflag)
			return false;
		len = document.getElementById('newDirTab').rows.length;
		chkELE = ['n_dirname_','n_gender_','n_din_','n_desig_','n_addr_','n_mail_'];
		gflag = chkArr(len,chkELE,'New Directors',"new_dir_errdiv");
		if(!gflag)
			return false;*/
		/*len = document.getElementById('stTab').rows.length;
		chkELE = ['st_audname_','st_audregnum_','st_audmail_'];*/
		
		var nat = $( "#appt option:selected" ).val();
		if((nat == "appointment" || nat == "reappointment") && $( "#appt_period").val() == "") {
			displayalertmessage("Please give appointment period","stat_dir_errdiv");return false;
		}
		var natstataud = $( "#nature_sauditor option:selected" ).val();
		if(natstataud == ""){
			displayalertmessage("please select Nature of Statutory Auditor","stat_dir_errdiv");return false;}
		/*gflag = chkArr(len,chkELE,'Statutory Auditors',"stat_aud_errdiv");
		if(!gflag)
			return false;*/
		var chksecrtry = $("input[name='secretry']").filter(":checked").val();
		if(chksecrtry == "yes"){
			chkELE = ['secnam','secmemno','secpan','secmail'];
			len = chkELE.length;
			for(var i=0;i<len;i++){
				txtVal = $("#"+chkELE[i]).val();
				if(txtVal == ""){
					displayalertmessage("Please give Company secretry information","sec_errdiv");return false;
				}
			}
		}
		return true;
	}
	function directors()
	{
		
		var totCnt=$('#nodCnt').val();
		//alert(" director totCnt==="+totCnt);
		var finalComDtls1="";
		var 
		eleArr = ['d_dirname_','d_gender_','d_din_','d_desig_','d_addr_','d_mail_'];
		for(var t=1;t<=totCnt;t++) {
		     for(var j=0;j<eleArr.length;j++) {
		    	 
		    		 
		     finalComDtls1=finalComDtls1+document.getElementById(eleArr[j]+t).value+"~";
		    }
		     finalComDtls1=finalComDtls1+"&";
		    }
		    $('#director').val(finalComDtls1);
}
		 
	
	function addDirectors()
	{
		
		var totCnt=$('#adnoCnt').val();
		//alert("Add director totCnt==="+totCnt);
		var finalComDtls2="";
		eleArr = ['a_dirname_','a_gender_','a_din_','a_desig_','a_addr_','a_mail_'];
		for(var t=1;t<=totCnt;t++) {
		     for(var j=0;j<eleArr.length;j++) {
		     finalComDtls2=finalComDtls2+document.getElementById(eleArr[j]+t).value+"~";
           }
		     finalComDtls2=finalComDtls2+"&";
		     }
		    $('#adddirector').val(finalComDtls2);
		 
	}
	function newDirectors()
	{
		
		var totCnt=$('#newnoCnt').val();
		//alert("New director totCnt==="+totCnt);
		var finalComDtls3="";
		eleArr = ['n_dirname_','n_gender_','n_din_','n_desig_','n_addr_','n_mail_'];
		for(var t=1;t<=totCnt;t++) {
		     for(var j=0;j<eleArr.length;j++) {
		     finalComDtls3=finalComDtls3+document.getElementById(eleArr[j]+t).value+"~";
          }
		     finalComDtls3=finalComDtls3+"&";
		     }
		 $('#newdirector').val(finalComDtls3);
	}
	/*function staAuditors()
	{
		var totCnt=$('#statnoCnt').val();
		//alert("Auditor director totCnt==="+totCnt);
		var finalComDtls4="";
		eleArr = ['st_audname_','st_audregnum_','st_audmail_','st_audtype_'];
		for(var t=1;t<=totCnt;t++) {
		     for(var j=0;j<eleArr.length;j++) {
		     finalComDtls4=finalComDtls4+document.getElementById(eleArr[j]+t).value+"~";
         }
		     finalComDtls4=finalComDtls4+"&";
		    }
		 $('#staAuditors').val(finalComDtls4);
	}*/
	
	$('#company_list').change(function(e)
	{
	var queryString ="companyId="+$('#company_list').val().split("-")[1];
       $.ajax({  
		 Stype: "GET", 
		 url: "./checkDirectorsList.html", 
		 data: queryString, 
		 cache: false,
		 success: function(response){ 
			
			 if(response!="")
			 {
				var result=response.split("#");
				 if(result[0]==0)
					 {
					 $('#main').hide();
					 $('#error').show();
					$('#error').html(result[1]).css('color', 'red');

					 }
				 else {
					    $('#main').show();
					    $('#error').show();
						$('#error').html("");
					 
				 }
				  }
			 
		 },
		 error: function(e){ 
			
		 },
	     failure: function(e){ 
			 alert('Error: ' + e); 
		 }						 
	 });  

			
		
	});
	
});

