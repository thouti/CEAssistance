$(document).ready(function()
{
	
	var flag=true;
	$('#firstName').focus();
	$('#logout').click(function(e)
	{
		document.logOutForm.action="logOut.html";
	 	document.logOutForm.method="POST";
	 	document.logOutForm.submit();	
	});
	
	$('#email').blur(function(e)
			{	
		       	
				if($("#email").val() == ""  )
				{
					$('#erEmail').show();
					$('#erEmail').html("Should not empty").css('color', 'white');
					$('#email').focus();
					return false;	
				}
				
				 else {
						  var queryString ="email="+$('#email').val();
					 $.ajax({  
						 type: "GET", 
						 url: "./chkEmailId.html", 
						 data: queryString, 
						 cache: false,
						 success: function(response){ 
							 if(response!="")
							 {
								 //alert("response==="+response); 
								 var result=response.split("#");
								 if(result[0]==0)
									 {
									
									 $('#erEmail').show();
									$('#erEmail').html($('#email').val()+result[1]).css('color','red');
									flag=false;
									}
								 else
									 {
									 $('#erEmail').show();
									$('#erEmail').html("");
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

	$('#register').click(function(e)
	{
	if($('#firstName').val()=="")
	{
		$('#errorFirstname').show();
		$('#errorFirstname').html("First Name Should not empty").css('color', 'red');
		$('#firstName').focus();
		return false;
	}
	else if($('#firstName').val().length<4)
	{
		$('#errorFirstname').show();
		$('#errorFirstname').html("First Name Not Less Than 4 charcters").css('color', 'red');
		$('#firstName').focus();
		return false;
	}
	else if($('#lastName').val()=="")
	{
		$('#errorLastname').show();
		$('#errorLastname').html("Last Name Should not empty").css('color', 'red');
		$('#lastName').focus();
		return false;
	}
	else if($('#lastName').val().length<4)
	{
		$('#errorLastname').show();
		$('#errorLastname').html("Last Name Not Less Than 4 charcters").css('color', 'red');
		$('#lastName').focus();
		return false;
	}
	else if($('#password').val()=="")
	{
		$('#erPswd').show();
		$('#erPswd').html("Password Should not empty").css('color', 'red');
		$('#password').focus();
		return false;
	}
	else if($('#password').val().length<4)
	{
		$('#erPswd').show();
		$('#erPswd').html("Password Not Less Than 4 charcters").css('color', 'red');
		$('#password').focus();
		return false;
	}
	else if($('#mobile').val()=="")
		{
		$('#erPhone').show();
		$('#erPhone').html('Mobile Number Not Empty').css('color', 'red');
		return false;
		}
	else if($('#datepicker').val()=="")
	{
	$('#errDt').show();
	$('#errDt').html('Date Of Birth  Not Empty').css('color', 'red');
	$('#datepicker').focus();
	return false;
	}
	else if($('#mobile').val()=="")
	{
			 $('#erPhone').show();
			$('#erPhone').html('Mobile Number not empty').css('color', 'red');
			$('#mobile').focus();
			return false;
	 }
	else if($('#email').val()=="")
		{
		 $('#erEmail').show();
		   $('#erEmail').html('Email not Empty').css('color', 'red');;
		   $('#emailid').focus();
	     return false;
		}
	
	else if(flag==true)
		{
		document.userform.action="register.html";
	 	document.userform.method="POST";
	 	document.userform.submit();
		}
		
	});
	
	$(".number").keypress(function(e) {
		if (e.which != 8 && e.which != 0
		&& (e.which < 48 || e.which > 57)) 
		{
			$('#erPhone').show();
			$('#erPhone').html('allow numbers').css('color', 'red');
		return false;
		}
		});
	$('#email').blur(function(e) {
	 var primaryemail = document.getElementById("email").value;
	 var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if(primaryemail=="")
	{
	$('#erEmail').show();
	$('#erEmail').html("Email Should not empty").css('color', 'red');
	$('#email').focus();
	return false;
   }
  if(reg.test(primaryemail) == false) {
	   $('#erEmail').show();
	   $('#erEmail').html('Invalid Email Address').css('color', 'red');;
	   $('#email').focus();
     return false;
  }else {
	  $('#erEmail').show();
	  $('#erEmail').html("");
  		emailavalability();
  		return true;
       }
		});
$('#mobile').blur(function(e) {
		var mobileno=$("#mobile").val();
		//alert("mobileno==="+mobileno);
		if(mobileno!=""){
		if (mobileno.length>10 || mobileno.length<10){
			$('#erPhone').show();
			$('#erPhone').html("Mobile No. Should Be 10 Digit").css('color', 'red');
		$("#mobile").val("");
		$("#mobile").focus();
		return false;
		}
		if (!(mobileno.charAt(0)=="9" || mobileno.charAt(0)=="8" || mobileno.charAt(0)=="7")){
			$('#erPhone').show();
			$('#erPhone').html("Mobile No. Should Start With 9 or 8 or 7").css('color', 'red');
		$("#mobile").val("");
		$("#mobile").focus();

		return false;
		}
		}else{
			$('#erPhone').hide();
		return true;
		}
		});
$('#no_comp').keyup(function(e) 
		{
			$('#tAmt').val($('#no_comp').val()*100);
			$('#totAmt').html($('#no_comp').val()*100);
		});
$('#payPal').click(function(e){
	if($('#no_comp').val()=='')
		{
		$('#errNoComp').show();
		$('#errNoComp').html("Please Enter No Of Companies").css('color', 'red');
		$('#no_comp').focus();
		return false;
		}
	else
		{
	document.userform.action="bankPayment.html";
 	document.userform.method="POST";
 	document.userform.submit();
		}
});

$('#afterPayment').click(function(e){
	document.addComp.action="addCompaniesFront.html";
 	document.addComp.method="POST";
 	document.addComp.submit();
});
$('#datepicker').blur(function(e)
		 {
			if($('#datepicker').val()!="")
		     {
		       var dateval=$('#datepicker').val();
		       dateval=dateval.replace('-','');
		       dateval=dateval.replace('-','');
		       len=dateval;
		      
		       if(isNaN(len))
		       {
		    	   
		    	   $('#errDt').show();
					$('#errDt').html("Enter Valid Date").css('color', 'red');
		       $('#datepicker').focus();
		       $('#datepicker').select();
		       }
		       else if(len.length!=8)
		       {	
		    	   $('#errDt').show();
					$('#errDt').html("Enter Valid Date").css('color', 'red');
				$('#datepicker').focus();
				$('#datepicker').select();
		        }	     
		        else
		        {	        	
		        	
		             dd=len.substring(0,2);
		             dd=dd+'-';
		             mm=len.substring(2,4);
		             mm=mm+'-';
		             yy=len.substring(4,8);
		             date1=dd+mm+yy;
		             noDays=getDays((len.substring(2,4)-1),yy);
		            if((len.substring(0,2)>31)||(len.substring(2,4)>12))
			          {	          	 
		            	$('#errDt').show();
						$('#errDt').html("Enter Date In DDMMYYYY Format Only").css('color', 'red');
		            	
					   	$('#datepicker').focus();
					   	$('#datepicker').select();
		             }
		             else if((len.substring(0,2)<1)||(len.substring(2,4)<1)||(len.substring(4,8)<1900))
		             {	           	
		            	 $('#errDt').show();
							$('#errDt').html("Enter Date In DDMMYYYY Format Only").css('color', 'red');
						 $('#datepicker').focus();
						 $('#datepicker').select();
		             }
		             else
			          {
			        	 $('#datepicker').val(date1);
					}
      }
		   }
 });

$('#loignEmail').blur(function(e) {
	 var primaryemail = document.getElementById("loignEmail").value;
	 var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if(primaryemail=="")
	{
	$('#erLEmail').show();
	$('#erLEmail').html("Email Should not empty").css('color', 'red');
	$('#loignEmail').focus();
	return false;
  }
 if(reg.test(primaryemail) == false) {
	   $('#erLEmail').show();
	   $('#erLEmail').html('Invalid Email Address').css('color', 'red');;
	   $('#loignEmail').focus();
    return false;
 }else {
	  $('#erLEmail').show();
	  $('#erLEmail').html("");
 		emailavalability();
 		return true;
      }
		});
});

function getDays(month,year)
{
      var monarr=new Array(12);
      monarr[0]=31;
      monarr[1]=(leapYear(year))?29:28;
      monarr[2]=31;
      monarr[3]=30;
      monarr[4]=31;
      monarr[5]=30;
      monarr[6]=31;
      monarr[7]=31;
      monarr[8]=30;
      monarr[9]=31;
      monarr[10]=30;
      monarr[11]=31;
      return monarr[month];
}

function leapYear(year)
{
 if(((year%4==0)&&(year%100!=0))||((year%100==0)&&(year%400==0)))
  {
    return true;
   }
 else
  {
     return false;
   }
}

