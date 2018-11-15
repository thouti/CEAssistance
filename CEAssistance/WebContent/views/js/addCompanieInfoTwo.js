$(document).ready(function()
{
	var emailRegex =/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	$('#main').hide();
	$('#btnAdd').hide();
	/*$('#others').hide();
	$('#others1').hide();
	$('#others2').hide();
	$('#others3').hide();*/
	$('#logout').click(function(e)
			{
				document.logOutForm.action="logOut.html";
			 	document.logOutForm.method="POST";
			 	document.logOutForm.submit();	
			});
	
	/*$('#final_stmt_diretcor').change(function(e){
		if($('#final_stmt_diretcor').val()=="other")
			{
			$('#others').show();
			 $('#designation').val("");
			  $('#dinPin').val("");
			}
		else
			{
			$('#others').hide();
			var queryString ="directorId="+$('#final_stmt_diretcor').val();
			$.ajax({  
			 Stype: "GET", 
			 url: "./getDirectorData.html", 
			 data: queryString, 
			 cache: false,
			 success: function(response){ 
			 if(response!=""){
				 $('#errcname').html("");
				 var result=response.split("$");
				  if(result[0]!=0)
					 {
					  $('#designation').val(result[0]);
					  $('#dinPin').val(result[1]);
					 }
				 else
					 {
					  //$('#main').hide();
					 //	$('#errcname').show();
						//$('#errcname').html("No Director Are Found").css('color', 'red');
					 }
			 }else {
				 
				// $('#errcname').show();
					//$('#errcname').html("No Director Are Found").css('color', 'red');
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
	$('#final_stmt_diretcor2').change(function(e){
		if($('#final_stmt_diretcor2').val()=="other")
			{
			$('#others1').show();
			 $('#d_designation').val("");
			  $('#d_dinPin').val("");
			}
		else
			{
			$('#others1').hide();
			var queryString ="directorId="+$('#final_stmt_diretcor2').val();
			$.ajax({  
			 Stype: "GET", 
			 url: "./getDirectorData.html", 
			 data: queryString, 
			 cache: false,
			 success: function(response){ 
			 if(response!=""){
				 //alert("response===="+response);
				 $('#errcname').html("");
				 var result=response.split("$");
				  if(result[0]!=0)
					 {
					  $('#d_designation').val(result[0]);
					  $('#d_dinPin').val(result[1]);
					 }
				 else
					 {
					 //$('#main').hide();
					 //	$('#errcname').show();
						//$('#errcname').html("No Director Are Found").css('color', 'red');
					 }
			 }else {
				 
				// $('#errcname').show();
					//$('#errcname').html("No Director Are Found").css('color', 'red');
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
	$('#authorised_dir_name').change(function(e){
		if($('#authorised_dir_name').val()=="other")
			{
			$('#others3').show();
			 $('#authorised_dir_designation').val("");
			  $('#authorised_dir_din').val("");
			}
		else
			{
			$('#others3').hide();
			var queryString ="directorId="+$('#authorised_dir_name').val();
			$.ajax({  
			 Stype: "GET", 
			 url: "./getDirectorData.html", 
			 data: queryString, 
			 cache: false,
			 success: function(response){ 
			 if(response!=""){
				// alert("response===="+response);
				 $('#errcname').html("");
				 var result=response.split("$");
				  if(result[0]!=0)
					 {
					  $('#authorised_dir_designation').val(result[0]);
					  $('#authorised_dir_din').val(result[1]);
					 }
				 else
					 {
					 //$('#main').hide();
					 //	$('#errcname').show();
						//$('#errcname').html("No Director Are Found").css('color', 'red');
					 }
			 }else {
				 
				// $('#errcname').show();
					//$('#errcname').html("No Director Are Found").css('color', 'red');
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
	*/
	$("#dinPin").keyup(function(event) {//console.log("in if::: it is::"+event.keyCode);
		if ((event.keyCode >= 96 && event.keyCode <= 105) || (event.keyCode >= 65 && event.keyCode <= 90)) {
		}
		});
	
	$('#companyname').change(function(e){
		if($('#companyname').val()=="sel"){
			$('#errcname').show();
			$('#main').hide();
			$('#errcname').html("Slect Company Name").css('color', 'red');
			$('#errcname').focus();
			return flase();
		}
		else {
			var queryString ="companyId="+$('#companyname').val().split("-")[1];
			$.ajax({  
			 Stype: "GET", 
			 url: "./retriveDirectorLst.html", 
			 data: queryString, 
			 cache: false,
			 success: function(response){ 
			 if(response!=""){
				 var res;
				// alert("response===="+response);
				 $('#errcname').html("");
				 var result=response.split("#");
				  if(result[0]!=0)
					 {
					 $('#main').show();
					 var optval = "<option value='sel'>----Select Director Name----</option>";
					 	for(var i=0;i<result.length-1;i++)
						 {
					 		 res=result[i].split("$");
					 		optval += "<option value="+ res[1]+">"+res[0]+"</option>";
					 	  }
					 	optval +="'<option value='other'>----other----</option>";
					$("select#final_stmt_diretcor").html(optval);
					$("select#final_stmt_diretcor2").html(optval);
					$("select#authorised_dir_name").html(optval);
					}
				 
				   res=response.split("$");
				    if(res[0]==2)
					 {
					   $('#main').hide();
					 	$('#errcname').show();
						$('#errcname').html(res[1]).css('color', 'red');
					}
				  else if(res[0]==0)
					 {
					   $('#main').hide();
					 	$('#errcname').show();
						$('#errcname').html(res[1]).css('color', 'red');
					}
				/* else if(res[0]!=0||res[0]!=1||res[0]!=2)
					 {
					 $('#main').hide();
					 	$('#errcname').show();
						$('#errcname').html("9949No Director Are Found").css('color', 'red');
					 }*/
			 }else {
				 
				 $('#errcname').show();
					$('#errcname').html("No Director Are Found").css('color', 'red');
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
$('#addcomInfotwo').click(function(e){
	
	 if($('#companyname').val()=='sel')
		{
		$('#errcname').show();
		$('#errcname').html("Select Company  Name").css('color', 'red');
		$('#companyname').focus();
		return false;
		}
	
	else if($('#final_stmt_diretcor').val()=='sel')
		{
		$('#errfinalstmtdirector1').show();
		$('#errfinalstmtdirector1').html("Select Director Name").css('color', 'red');
		$('#final_stmt_diretcor').focus();
		return false;
		}
	/*
		{
		$('#errfinalstmtdirector1').html("");
		}
	 if($('#designation').val()=='' || $('#final_stmt_diretcor').val()=='')
		{
		$('#errdesignation').show();
		$('#errdesignation').html("Designation Does Not empty").css('color', 'red');
		$('#designation').focus();
		return false;
		}
	 if($('#designation').val().length<2)
	{
	$('#errdesignation').show();
	$('#errdesignation').html("Designation Not lessthan 2 letters").css('color', 'red');
	$('#designation').focus();
	return false;
	}
	 if($('#dinPin').val()=='')
		{
		$('#errdinPin').show();
		$('#errdinPin').html("dinPin Not empty").css('color', 'red');
		$('#dinPin').focus();
		return false;
		}*/
	else if($('#final_stmt_diretcor2').val()=='sel')
	{
	$('#errfinal_stmt_diretcor2').show();
	$('#errfinal_stmt_diretcor2').html("Select Director Name").css('color', 'red');
	$('#final_stmt_diretcor2').focus();
	return false;
	}

	/*else if($('#d_designation').val()=='')
	{
	$('#errd_designation').show();
	$('#errd_designation').html("Designation Name Does Not empty").css('color', 'red');
	$('#d_designation').focus();
	return false;
	}
	else if($('#d_designation').val().length<2)
{
$('#errd_designation').show();
$('#errd_designation').html("Designation Name Not lessthan 2 letters").css('color', 'red');
$('#d_designation').focus();
return false;
}
	else if($('#d_dinPin').val()=='')
	{
	$('#errd_dinPin').show();
	$('#errd_dinPin').html("DinPin Not empty").css('color', 'red');
	$('#d_dinPin').focus();
	return false;
	}*/
	var selected1 = $("input[type='radio'][name='audit_required']:checked");
	if(selected1.val()!='no')
		{
		if($('#divpaid').val()=='sel')
		{
		$('#errDivpaid').show();
		$('#errDivpaid').html("Select the nature of Secretarial Auditor").css('color', 'red');
		$('#divpaid').focus();
		return false;
		}
		
		if($('#audit_reporterName').val()=='')
		{
		$('#errAuditorName').show();
		$('#errAuditorName').html("Auditor Name  Not empty").css('color', 'red');
		$('#audit_reporterName').focus();
		return false;
		}
		 if($('#audit_reporterName').val().length<2)
		{
		$('#errAuditorName').show();
		$('#errAuditorName').html("Auditor Name Not lessthan 2 letters").css('color', 'red');
		$('#audit_reporterName').focus();
		return false;
		}
		 if($('#firmRegNo').val()=='')
		{
		$('#errfirmRegNo').show();
		$('#errfirmRegNo').html("Firm RegNo  Not empty").css('color', 'red');
		$('#firmRegNo').focus();
		return false;
		}
		 if($('#firmRegNo').val().length<2)
		{
			$('#errfirmRegNo').show();
			$('#errfirmRegNo').html("Firm RegNo Not Lessthan 2 letters").css('color', 'red');
			$('#firmRegNo').focus();
			return false;
			}
		 if($('#audit_name').val()=='')
		{
		$('#erraudit_name').show();
		$('#erraudit_name').html("Audit Name Not empty").css('color', 'red');
		$('#audit_name').focus();
		return false;
		}
		 if($('#audit_name').val().length<2)
		{
			$('#erraudit_name').show();
			$('#erraudit_name').html("Audit Name Not Lessthan 2 letters").css('color', 'red');
			$('#audit_name').focus();
			return false;
		}
		if($('#audit_email').val()=="")
		{
		$('#erraudit_email').html("Does Not Allow Empty value").css('color', 'red');
		$('#audit_email').focus();
		return false;
		}
		if(emailRegex.test($('#audit_email').val()) == false)
		{
		$('#erraudit_email').html("Not a valid email adrress").css('color', 'red');
		$('#audit_email').focus();
		return false;
		}
		}
var selected = $("input[type='radio'][name='dividend_proposed_paid']:checked");
 if(selected.val()=='yes')
{
 if($('#yes_dividend_proposed_paid').val()=='')
{
$('#errproposedPaid').show();
$('#errproposedPaid').html("Dividend proposed paid Not empty").css('color', 'red');
$('#yes_dividend_proposed_paid').focus();
return false;
}
 if($('#dividend_paid_out').val()=='sel')
{
$('#errpaidOut').show();
$('#errpaidOut').html("Select paid out of").css('color', 'red');
$('#dividend_paid_out').focus();
return false;
}
 if($('#no_fully_paid').val()=='')
{
$('#errfullyPaid').show();
$('#errfullyPaid').html("Fully Paid Not empty").css('color', 'red');
$('#no_fully_paid').focus();
return false;
}
 if($('#face_value_Eshare').val()=='')
{
$('#errvalueShare').show();
$('#errvalueShare').html("Value Share Not empty").css('color', 'red');
$('#face_value_Eshare').focus();
return false;
}
 if($('#record_date').val()=='')
{
$('#errDatepick').show();
$('#errDatepick').html("Record Date Not empty").css('color', 'red');
$('#record_date').focus();
return false;
}
 
 
 if($('#authorised_dir_name').val()=='sel')
{
$('#errAuthorisedDirName').show();
$('#errAuthorisedDirName').html("Select Director Name").css('color', 'red');
$('#authorised_dir_name').focus();
return false;
}
 
/*if($('#authorised_dir_designation').val()=='')
{
$('#authDesignation').show();
$('#authDesignation').html("Designation Not empty").css('color', 'red');
$('#authorised_dir_designation').focus();
return false;
}
 if($('#authorised_dir_designation').val().length<2)
{
$('#authDesignation').show();
$('#authDesignation').html("Designation Not lessthan 2 letters").css('color', 'red');
$('#authorised_dir_designation').focus();
return false;
}
 if($('#authorised_dir_din').val()=='')
{
$('#errAuthoDir').show();
$('#errAuthoDir').html("DinPin Not empty").css('color', 'red');
$('#authorised_dir_din').focus();
return false;
}
 
 //Upto Here
 */
 
 
 if($('#dividend_amounts').val()=='')
{
$('#errDividendAmt').show();
$('#errDividendAmt').html("Dividend Amt Not empty").css('color', 'red');
$('#dividend_amounts').focus();
return false;
}
 if($('#acct_bank').val()=='')
{
$('#errBankAcc').show();
$('#errBankAcc').html("Bank Account Not empty").css('color', 'red');
$('#acct_bank').focus();
return false;
}
 if($('#unpaid_unclaimed').val()=='')
{
$('#errUnpaid').show();
$('#errUnpaid').html("Unpaid  Not empty").css('color', 'red');
$('#unpaid_unclaimed').focus();
return false;
}
 /*if($('#divpaid').val()=='sel')
{
$('#errDivpaid').show();
$('#errDivpaid').html("Select The Nature of Secretarial Auditor").css('color', 'red');
$('#divpaid').focus();
return false;
}*/
}
 if($('#fetchData').val()=="")
	{
	datafetch();
	}
if($('#directorStmtData').val()=="")
{
	directorStmtData();
}
if($('#devidendDir').val()=="")
{
	DevidendData();
}

if (confirm("Please Confirm This Details ")){
			document.addinfotwo.action="addComponyBmPostBmDtls.html";
		 	document.addinfotwo.method="POST";
		 	document.addinfotwo.submit();
	}
		
});
$('#yes_dividend_proposed_paid').keypress(
    function(event) {
        //Allow only backspace and delete
        if (event.keyCode != 46 && event.keyCode != 8) {
            if (!parseInt(String.fromCharCode(event.which))) {
                event.preventDefault();
            }
        }
});
$('#no_fully_paid').keypress(
	    function(event) {
	        //Allow only backspace and delete
	        if (event.keyCode != 46 && event.keyCode != 8) {
	            if (!parseInt(String.fromCharCode(event.which))) {
	                event.preventDefault();
	            }
	        }
	});
$('#face_value_Eshare').keypress(
	    function(event) {
	        //Allow only backspace and delete
	        if (event.keyCode != 46 && event.keyCode != 8) {
	            if (!parseInt(String.fromCharCode(event.which))) {
	                event.preventDefault();
	            }
	        }
	});
$('#btnAdd').hide();
$('#btnAdd2').hide();
$('#btnAdd3').hide();
$("#btnAdd").bind("click", function () {
	var div = $("<div />");
    div.html(GetDynamicTextBox(""));
    $("#TextBoxContainer").append(div);
 });
$("#btnAdd2").bind("click", function () {
	var div = $("<div />");
    div.html(GetDynamicTextBox1(""));
    $("#TextBoxContainer1").append(div);
   
});
$("#btnAdd3").bind("click", function () {
	var div = $("<div />");
    div.html(GetDynamicTextBox2(""));
    $("#TextBoxContainer2").append(div);
   
});
$("body").on("click", ".remove", function () {
    $(this).closest("div").remove();
   // $('#fetchData').val("");
});
});
function GetDynamicTextBox(value) {
    return 'Name<input name = "DynamicTextBox" type="text"  width="20%" value = "' + value + '" />&nbsp;' +
            'Designation<input name = "DynamicTextBox" type="text" width="20%" value = "' + value + '" />&nbsp;' +
             'Din/Pan<input name = "DynamicTextBox" type="text" width="20%" value = "' + value + '"/>&nbsp;' +
            '<input type="button" value="Remove" class="remove" />';
}
function GetDynamicTextBox1(value) {
    return 'Name<input name = "DynamicTextBox1" type="text"  width="20%" value = "' + value + '" />&nbsp;' +
            'Designation<input name = "DynamicTextBox1" type="text" width="20%" value = "' + value + '" />&nbsp;' +
             'Din/Pan<input name = "DynamicTextBox1" type="text" width="20%" value = "' + value + '"/>&nbsp;' +
            '<input type="button" value="Remove" class="remove" />';
}
function GetDynamicTextBox2(value) {
    return 'Name<input name = "DynamicTextBox2" type="text"  width="20%" value = "' + value + '" />&nbsp;' +
            'Designation<input name = "DynamicTextBox2" type="text" width="20%" value = "' + value + '" />&nbsp;' +
             'Din/Pan<input name = "DynamicTextBox2" type="text" width="20%" value = "' + value + '"/>&nbsp;' +
            '<input type="button" value="Remove" class="remove" />';
}
function show()
{
  if($('#final_stmt_diretcor').val()=="other")
  {
	 
     $('#btnAdd').show(); 
     $('#TextBoxContainer').show();
     
  }
  else if($('#final_stmt_diretcor').val()!="other") {
	 
      $('#btnAdd').hide();
      $('#TextBoxContainer').hide();
       $('#fetchData').val("");
  }
}
function show1()
{
  if($('#final_stmt_diretcor2').val()=="other")
  {
	 
     $('#btnAdd2').show(); 
     $('#TextBoxContainer1').show();
     
  }
  else if($('#final_stmt_diretcor2').val()!="other") {
	 
      $('#btnAdd2').hide();
      $('#TextBoxContainer1').hide();
       $('#directorStmtData').val("");
  }
}
function show2()
{
  if($('#authorised_dir_name').val()=="other")
  {
	 
     $('#btnAdd3').show(); 
     $('#TextBoxContainer2').show();
     
  }
  else if($('#authorised_dir_name').val()!="other") {
	 
      $('#btnAdd3').hide();
      $('#TextBoxContainer2').hide();
       $('#devidendDir').val("");
  }
}
function datafetch()
{
 
        var values = "";
        var count=0;
        $("input[name=DynamicTextBox]").each(function () {
            if($(this).val()=="")
            {
                alert('not allow');
                $(this).focus();
                return false;
            }
            else{
              
            values += $(this).val() + "@";
            count++;
        
            if(count==3)
            {
              values+="&";  
              $('#fetchData').val(values);
              count=0;
            }
        } 
        });
          
      //  alert(values);
        
    
}
function directorStmtData()
{
 
        var values = "";
        var count=0;
        $("input[name=DynamicTextBox1]").each(function () {
            if($(this).val()=="")
            {
                alert('not allow');
                $(this).focus();
                return false;
            }
            else{
              
            values += $(this).val() + "@";
            count++;
        
            if(count==3)
            {
              values+="&";  
              $('#directorStmtData').val(values);
              count=0;
            }
        } 
        });
          
     //  alert(values);
}
function DevidendData()
{
 
        var values = "";
        var count=0;
        $("input[name=DynamicTextBox2]").each(function () {
            if($(this).val()=="")
            {
                alert('not allow');
                $(this).focus();
                return false;
            }
            else{
              
            values += $(this).val() + "@";
            count++;
        
            if(count==3)
            {
              values+="&";  
              $('#devidendDir').val(values);
              count=0;
            }
        } 
        });
          
      // alert(values);
}
/*function chkArr(arr,div){//console.log("--@ chkArr()---"+div);
	var txtVal = "";
	var len = arr.length;
	for(var i=0;i<len;i++){
		txtVal = $("#"+arr[i]).val();
		if( txtVal == "" || txtVal == undefined){
			if(document.getElementById(div))
	    		document.getElementById(div).innerHTML = "<font color='red'>Please give full information</font>";
	    	return false;
		}
	}
	return true;
}
function ChkAGMFields(){
	makeAERRempty();var gflag = true;
	//console.log("--@ ChkAGMFields()---");
	chkELE = ['final_stmt_diretcor','f_designation','f_dinPin'];
	gflag = chkArr(chkELE,"financeinfo_errdiv");
	if(!gflag) return false;
	chkELE = ['final_stmt_diretcor2','d_designation','d_dinPin'];
	gflag = chkArr(chkELE,"signat_errdiv");
	if(!gflag) return false;
	var chkRad = "";
	chkRad = $("input[name='dividend_proposed_paid']").filter(":checked").val();
	if(chkRad == "yes"){
		chkELE = ['yes_dividend_proposed_paid','dividend_paid_out','no_fully_paid','face_value_Eshare','record_date','dividend_amounts','unpaid_unclaimed','unpaid_unclaimed'];
		gflag = chkArr(chkELE,"divid_errdiv");
		if(!gflag) return false;
		chkELE = ['authorised_dir_name','authorised_dir_designation','authorised_dir_din'];
		gflag = chkArr(chkELE,"divid_sub_errdiv");
		if(!gflag) return false;
	}
	chkRad = $("input[name='audit_required']").filter(":checked").val();
	if(chkRad == "yes"){
		chkElE= ['audit_reporterName','firmRegNo','audit_name','audit_email'];
		gflag = chkArr(chkELE,"Secretarial_errdiv");
		if(!gflag) return false;
	}
	return true;
}
function makeAERRempty(){
	var errdiv = ['financeinfo_errdiv','signat_errdiv','divid_errdiv','divid_sub_errdiv','Secretarial_errdiv'];
	for(var i=0;i<errdiv.length;i++){
		if(document.getElementById(errdiv[i]))
			document.getElementById(errdiv[i]).innerHTML = "";
	}
}*/
function chkDateFormat(obj){
	var validformat=/^\d{2}\/\d{2}\/\d{4}$/;
	if(!validformat.test(obj.value)){
		displayalertmessage("Please give valid date format(mm/dd/YYYY).","divid_errdiv");
		document.getElementById(obj.id).focus();
		return false;
	}
	else{
		displayalertmessage("","comp_errdiv");
		return true;
	}
}