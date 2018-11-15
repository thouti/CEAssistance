$(document).ready(function()
{
	var flag=true;
	var emailRegex =/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	$('#emailId').focus();
	$('#emailId').blur(function(e)
			{	
		     if($("#emailId").val() == ""  )
				{
					$('#erEmail').show();
					$('#erEmail').html("Should not empty").css('color', 'red');
					$('#email').focus();
					return false;	
				}
		     if(emailRegex.test($("#emailId").val()) == false)
		 	{
		 	$('#erEmail').html("Not a valid email adrress").css('color', 'red');
		 	$('#emailId').focus();
		 	return false;
		 	}
		     
				
				 else {
						  var queryString ="emailId="+$('#emailId').val();
					 $.ajax({  
						 type: "GET", 
						 url: "./chkRegisteredEmailId.html", 
						 data: queryString, 
						 cache: false,
						 success: function(response){ 
							 if(response!="")
							 {
								// alert("response==="+response); 
								 var result=response.split("#");
								 if(result[0]==0)
									 {
									
									 $('#erEmail').show();
									$('#erEmail').html($('#emailId').val()+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+result[1]).css('color','red');
									flag=false;
									}
								 else if(result[0]==1)
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

	$('#submit').click(function(e)
	{

		document.forgotPwd.action="sendPassword.html";
	 	document.forgotPwd.method="POST";
	 	document.forgotPwd.submit();

		
	});
	
});

