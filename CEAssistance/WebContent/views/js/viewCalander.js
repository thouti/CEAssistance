$(document).ready(function()
{
	$('#addDir').hide();
	var dirLst1;
$('#sel1').change(function(e){
	
	if($('#sel1').val()=="sel")
		{
		$('#errcname').show();
		$('#errcname').html("Slect Company Name").css('color', 'red');
		$('#errcname').focus();
		return flase();
		}
	else
		{
		var queryString ="companyId="+$('#sel1').val().split("-")[1]+"&userId="+$('#userId').val();
		 $.ajax({  
		 Stype: "GET", 
		 url: "./retriveAllDirectorLst.html", 
		 data: queryString, 
		 cache: false,
		 success: function(response){ 
			 if(response!="")
			 {
				 $('#errcname').html("");
				 $('#compId').val($('#sel1').val().split("-")[1]);
				 var dirNames="",addDir="",addNewDir="",statutaryDir4="",statutaryDir="",dirEmail="",adddirEmail="",newdirEmail="",stadirEmail="",agendaDirectors="";
				 var hddirEmail="",hdadddirEmail="",hdnewdirEmail="",hdstdirEmail="",hddirNames="",hdaddDirNames="",hdaddNewDirNames="",hdstatutaryDirNames="";
				 var result=response.split("&&");
				
				    var optval = "<option value='sel'>-Select-</option>";
				    var optvalAdditinalDir = "<option value='sel1'>-Select-</option>";
				    var optvalNewlyDir = "<option value='sel2'>-Select-</option>";
				    var optval1 = "<option value='sel3'>-Select-</option>";
				    var statutaryDir2= "<option value='sel4'>-Select-</option>";
				    var reaapointment= "<option value='sel6'>-Select-</option>";
				    
				    //Download Drop Down
				    var optvalDirector = "<option value='sel'>Select</option>"; 
				    var optvalAddDirector = "<option value='sel1'>Select</option>"; 
				    var optvalNewDirector = "<option value='sel2'>Select</option>";
				    var optvalstatutaryAudtor = "<option value='sel3'>Select</option>";
				    var directorsOne= "<option value='sel'>Select</option>";
				    var optvalnoticeBoard = "<option value='sel4'>Select</option>";
				  var statutaryAudtor1= "<option value='sel6'>Select</option>";
				    var optvalsec139 = "<option value='sel5'>Select</option>";
				    var optvalsec1392 = "<option value='sel5'>Select</option>";
				    var reaapointment1 = "<option value='sel5'>Select</option>";
				    
					 	for(var i=0;i<result.length-1;i++)
						 {
					 		var res=result[i].split("~");
					 		$('#hduserEmail').val(res[0]);
					 		$('#registredEmail').html(res[0]);
					 		$('#registredEmailOne').html(res[0]);
					 		$('#registredEmailTwo').html(res[0]);
					 		$('#registredEmailThree').html(res[0]);
					 		$('#registredEmailFour').html(res[0]);
					 		$('#hdAgmDate').val(res[1]);
					 		$('#hdagmDueDate').val(res[8]);
					 		$('#hdboardTime').val(res[9]);
					 		$('#hdboardVenue').val(res[10]);
					 		$('#hdagmVenue').val(res[12]);
					 		$('#hdagmTime').val(res[11]);
					 		//$('#hdstaType').val(res[13]);
					 		$('#hdnature').val(res[16]);
					 		$('#hdFirmRegNo').val(res[17]);
					 		loadReqInfo(res[1]);
					 		
					 		
					 		var dirLst=res[3].split("%");
					 		for(var i=0;i<dirLst.length-1;i++)
				 			{
				 			 dirLst1=dirLst[i].split("$");
				 			
				 			// dirNames=dirNames+dirLst1[0]+",";
					 			//hddirNames=hddirNames+dirLst1[0]+"@";
					 			dirEmail=dirEmail+dirLst1[1]+",";
					 			hddirEmail=hddirEmail+dirLst1[1]+"##";
					 			//$('#dirNames').html(dirNames);
					 			//$('#dirEmail').html(dirEmail);
					 			$('#hddirEmail').val(hddirEmail);
					 			$('#hddirNames').val(hddirNames);
					 			optval += "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
					 			directorsOne += "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
					 			optvalAdditinalDir+= "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
					 			optvalNewDirector+= "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
					 			optval1+= "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
					 			statutaryDir2+= "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
					 			reaapointment+= "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
					 			
				 			optvalnoticeBoard+= "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
				 			optvalsec139+= "<option value="+dirLst1[2]+">"+dirLst1[0]+"</option>";
				 			}
					 		//Here Retired Directors added
					 							 		$('#dirNames').html(res[14]);
//					 		//Here Retired Directors added
//						  	for(var i=0;i<=res[14].split(",").length-1;i++)
//				 				{
//				 				var res12=res[14].split(",");
//				 				optvalDirector+= "<option value="+res[11]+">"+res12[i]+"</option>";
//				 				}
				 			//Additional Directors Split
				 			var adddir;
				 			if(res[4]=="")
				 				{
				 				$('#hdaddDir').hide();
				 				$('#hdaddDir1').hide();
				 				$('.hdaddDir2').hide();
				 				$('#hdaddDir3').hide();
				 				$('#hdaddDir4').hide();
				 				}
				 			else
				 				{
				 				$('#hdaddDir').show();
				 				$('#hdaddDir1').show();
				 				$('.hdaddDir2').show();
				 				$('#hdaddDir3').show();
				 				$('#hdaddDir4').show();
				 			var adddirLst=res[4].split("%");
						    for(var i=0;i<adddirLst.length-1;i++)
				 			{
						    	adddir=adddirLst[i].split("$");
						    	adddirEmail=adddirEmail+adddir[1]+",";
					 			hdadddirEmail=hdadddirEmail+adddir[1]+"##";
					 			addDir=addDir+adddir[0]+",";
					 			hdaddDirNames=hdaddDirNames+adddir[0]+"@";
					 			$('#aditionalDir').html(addDir);
					 			//$('#adddirEmail').html(adddirEmail);
					 			$('#hdaddDirNames').val(hdaddDirNames);
					 			$('#hdadddirEmail').val(hdadddirEmail);
					 			optval += "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			optvalAddDirector+= "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			optvalNewDirector+= "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			optvalAdditinalDir += "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			statutaryDir2+= "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			reaapointment+= "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			optval1+= "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			optvalnoticeBoard+= "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 			optvalsec139+= "<option value="+adddir[2]+">"+adddir[0]+"</option>";
					 		}
				 				}
				 			if(res[5]=="")
				 				{
				 				$('#hdSeekingApp').hide();
				 				$('#hdSeekingApp1').hide();
				 				$('#hdSeekingApp2').hide();
				 				$('#hdSeekingApp3').hide();
				 				$('#hdSeekingApp4').hide();
				 				}
				 			else
				 				{
				 				$('#hdSeekingApp').show();
				 				$('#hdSeekingApp1').show();
				 				$('#hdSeekingApp2').show();
				 				$('#hdSeekingApp3').show();
				 				$('#hdSeekingApp4').show();
				 				var proposedDir;
				 			var proposedDirLst=res[5].split("%");
						    for(var i=0;i<proposedDirLst.length-1;i++)
				 			{
						    	proposedDir=proposedDirLst[i].split("$");
						    	newdirEmail=newdirEmail+proposedDir[1]+",";
					 			hdnewdirEmail=hdnewdirEmail+proposedDir[1]+"##";
					 			addNewDir=addNewDir+proposedDir[0]+",";
					 			hdaddNewDirNames=hdaddNewDirNames+proposedDir[0]+"@";
					 			$('#newDirector').html(addNewDir);
					 			//$('#newdirEmail').html(newdirEmail);
					 			$('#hdaddNewDirNames').val(hdaddNewDirNames);
					 			$('#hdnewdirEmail').val(hdnewdirEmail);
					 			
					 			//optvalNewDirector+= "<option value="+proposedDir[2]+">"+proposedDir[0]+"</option>";
					 			optvalNewlyDir += "<option value="+proposedDir[2]+">"+proposedDir[0]+"</option>";
					 			optvalnoticeBoard+= "<option value="+proposedDir[2]+">"+proposedDir[0]+"</option>";
					 			optvalsec139+= "<option value="+proposedDir[2]+">"+proposedDir[0]+"</option>";
				 			}
				 			}
				 				if(res[16]!="appointment")
				 				{
				 				$('#hdnature').hide();
				 				$('#hdnature1').hide();
				 				$('#hdnature2').hide();
				 				$('.hdnature3').hide();
				 				$('#hdnature4').hide();
				 				}
				 			if(res[16]!="reappointment")
				 					{
				 					$('#hdreappt').hide();
					 				$('#hdreappt1').hide();
					 				$('#hdreappt2').hide();
					 				$('#hdreappt3').hide();
					 				$('#hdreappt4').hide();
				 					
				 					}
				 			 if(res[16]=="appointment" || res[16]=="reappointment"){ 
				 				if(res[16]=="appointment")
				 					{
				 				$('#hdnature').show();
				 				$('#hdnature1').show();
				 				$('#hdnature2').show();
				 				$('.hdnature3').show();
				 				$('#hdnature4').show();
				 					}
				 				if(res[16]=="reappointment")
			 					{
				 					$('#hdreappt').show();
					 				$('#hdreappt1').show();
					 				$('#hdreappt2').show();
					 				$('#hdreappt3').show();
					 				$('#hdreappt4').show();
			 					}
				 				
					 		var staAuditor;
				 			var staAuditorLst=res[6].split("%");
						    for(var i=0;i<staAuditorLst.length-1;i++)
				 			{
						    	
						    	staAuditor=staAuditorLst[i].split("$");
						    	stadirEmail=stadirEmail+staAuditor[1]+",";
					 			hdstadirEmail=hdstadirEmail+staAuditor[1]+"##";
					 			statutaryDir=statutaryDir+staAuditor[0]+",";
					 			statutaryDir4=statutaryDir4+staAuditor[0]+",";
					 			hdstatutaryDirNames=hdstatutaryDirNames+staAuditor[0]+"@";
					 			if(res[16]=="appointment"){
					 			$('#statutaryDir').html(statutaryDir);}
					 			$('#statutaryReAppDir').html(statutaryDir4);
					 			
					 			//$('#stadirEmail').html(stadirEmail);
					 			$('#hdstadirEmail').val(hdstadirEmail);
					 			$('#hdstatutaryDirNames').val(hdstatutaryDirNames);
					 			optvalstatutaryAudtor+= "<option value="+staAuditor[2]+">"+staAuditor[0]+"</option>";
					 			statutaryAudtor1+= "<option value="+staAuditor[2]+">"+staAuditor[0]+"</option>";
					 			//optval1+= "<option value="+staAuditor[2]+">"+staAuditor[0]+"</option>";
					 			optvalnoticeBoard+= "<option value="+staAuditor[2]+">"+staAuditor[0]+"</option>";
					 			optvalsec1392+= "<option value="+staAuditor[2]+">"+staAuditor[0]+"</option>";
					 			reaapointment1+= "<option value="+staAuditor[2]+">"+staAuditor[0]+"</option>";
					 			}
				 			}
					 		  var comSecratary;
				 			var comSecrataryLst=res[7].split("%");
						    for(var i=0;i<comSecrataryLst.length-1;i++)
				 			{
						    	comSecratary=comSecrataryLst[i].split("$");
						    	
						    	optval += "<option value="+comSecratary[2]+">"+comSecratary[0]+"</option>";
					 			optvalAdditinalDir += "<option value="+comSecratary[2]+">"+comSecratary[0]+"</option>";
					 			optvalNewDirector += "<option value="+comSecratary[2]+">"+comSecratary[0]+"</option>";
					 			optval1+= "<option value="+comSecratary[2]+">"+comSecratary[0]+"</option>";
					 			statutaryDir2+= "<option value="+comSecratary[2]+">"+comSecratary[0]+"</option>";
					 			reaapointment+= "<option value="+comSecratary[2]+">"+comSecratary[0]+"</option>";
					 			optvalsec139+= "<option value="+comSecratary[2]+">"+comSecratary[0]+"</option>";
				 			}
					 		
					 	  }
					 //Below select boxes are download template	
					 	
					$("select#directorsOne").html(directorsOne);
				//	$("select#directorsOne").html(optvalDirector);
					$("select#AdddirectorsOne").html(optvalAddDirector);
					$("select#appointedDirector").html(optvalNewlyDir);
					$("select#statutaryAudtor").html(optvalstatutaryAudtor);
					$("select#statutaryAudtor1").html(statutaryAudtor1);
					$("select#reaapointment1").html(reaapointment1);
					
					$("select#noticeBoard").html(optvalnoticeBoard);
					$("select#sec139").html(optvalsec1392);
					$("select#sec139-1").html(optvalsec139);
					//Signatory Dropdowns
					$("select#directors").html(optval);
					$("select#additinalDir").html(optvalAdditinalDir);
					$("select#newlyAppDir").html(optvalNewDirector);
					$("select#statutaryDir1").html(optval1);
					$("select#statutaryDir2").html(statutaryDir2);
					$("select#reaapointment").html(reaapointment);
					
					$("select#statutaryDir").html(optval);
					$("select#statutaryAuditor").html(optval);
					$("select#boardDir").html(optval);
					$("select#genaralMeetingDir").html(optval);
					$("select#selDir").html(optval);
					}
				 else
					 {
					    $('#main').hide();
					 	$('#errcname').show();
						$('#errcname').html("No Company Details  Are Found").css('color', 'red');
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
	
		document.addinfotwo.action="addComponyBmPostBmDtls.html";
	 	document.addinfotwo.method="POST";
	 	document.addinfotwo.submit();
	
});
$('#updateCalander').click(function(e){
	
	document.viewCalander.action="setRemaindermails.html";
 	document.viewCalander.method="POST";
 	document.viewCalander.submit();
});
$('#downloadDoc').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	
	if($("#directors").val()=='sel' || $("directors").val()=="")
	{
	$("#errdirectors").show();
	$("#errdirectors").html("Please Select Signtary Type").css('color', 'red');
	$("#directors").focus();
	return false;	
	}
	else
		{
		$("#errdirectors").hide();
		$("#errdirectors").html("");
		}
	if($("#directorsOne").val()=='sel' || $("#directorsOne").val()=='')
	{
	$("#errdirectorsOne").show();
	$("#errdirectorsOne").html("Please Select Director Name ").css('color', 'red');
	$("#directorsOne").focus();
	return false;	
	}
	else
		{
		$("#errdirectorsOne").hide();
		$("#errdirectorsOne").html("");
		}
	if($("#directors").val()==$("#directorsOne").val())
	{
		$("#errdirectors").show();
	$("#errdirectors").html("Not allow The same Director names").css('color', 'red');
	$("#directors").focus();
	return false;
	}else{
		$('#hdstaType').val("");
		$('#date').val($('#hda1').val());
		$('#directorsOne12').val($('#directorsOne').val());
		$('#statutaryDirec').val($('#directors').val());
		$('#templateName').val("Letter to Directors retiring by rotation");
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();
	}
});
$('#downloadDoc1').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	if($("#AdddirectorsOne").val()=='sel1' || $("#AdddirectorsOne").val()=="")
	{
	$("#errAdddirectorsOne").show();
	$("#errAdddirectorsOne").html("Please Select Director Name").css('color', 'red');
	$("#AdddirectorsOne").focus();
	return false;	
	}
	else
		{
		$("#errAdddirectorsOne").hide();
		$("#errAdddirectorsOne").html("");
		}
	if($("#additinalDir").val()=='sel1' || $("#additinalDir").val()=='')
	{
	$("#erradditinalDir").show();
	$("#erradditinalDir").html("Please Select Signtary Type").css('color', 'red');
	$("#additinalDir").focus();
	return false;	
	}
	else
		{
		$("#erradditinalDir").hide();
		$("#erradditinalDir").html("");
		}
	if($("#AdddirectorsOne").val()==$("#additinalDir").val())
	{
		$("#errAdddirectorsOne").show();
	$("#errAdddirectorsOne").html("Not allow The same Director names").css('color', 'red');
	$("#AdddirectorsOne").focus();
	return false;
	}
else{
	$('#date').val($('#hda1').val());
	$('#directorsOne12').val($('#AdddirectorsOne').val());
	$('#statutaryDirec').val($('#additinalDir').val());
	$('#templateName').val("Letter to the Additional Director for his consent");
	$('#hdstaType').val("");
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();
}
});
$('#downloadDoc2').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	$('#date').val($('#hda1').val());
	if($("#newlyAppDir").val() == "sel2" || $("#newlyAppDir").val()=='')
	{
		$("#errnewlyAppDir").show();
		$("#errnewlyAppDir").html("Please Select New Director Name").css('color', 'red');
		$("#newlyAppDir").focus();
		return false;	
		}
		else
			{
			$("#errnewlyAppDir").hide();
			$("#errnewlyAppDir").html("");
			}
	if($("#appointedDirector").val() == "sel2" || $("#appointedDirector").val()=='')
	{
		
		$("#errappointedDirector").show();
		$("#errappointedDirector").html("Please Select Statutary New Director Name").css('color', 'red');
		$("#newlyAppDir").focus();
		return false;	
		}
	if($("#appointedDirector").val()==$("#newlyAppDir").val())
	{
		
	$("#errnewlyAppDir").show();
	$("#errnewlyAppDir").html("Not allow The same Director names").css('color', 'red');
	$("#newlyAppDir").focus();
	return false;
	}
	else{
		$('#directorsOne12').val($('#appointedDirector').val());
		$('#statutaryDirec').val($('#newlyAppDir').val());
		$('#templateName').val("Letter to the New Director for his consent");
		$('#hdstaType').val("");
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();}
});
$('#downloadDoc3').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	$('#date').val($('#hda1').val());
	if($("#statutaryDir1").val() == "sel3" || $("#statutaryDir1").val()=='')
	{
		$("#errstatutaryDir").show();
		$("#errstatutaryDir").html("Please Select Statutary Director Name").css('color', 'red');
		$("#statutaryDir1").focus();
		return false;	
		}
		else
			{
			$("#errstatutaryDir").hide();
			$("#errstatutaryDir").html("");
			}
	if($("#statutaryAudtor").val() == "sel3" || $("#statutaryAudtor").val()=='')
	{
		
		$("#errstatutaryAudtor").show();
		$("#errstatutaryAudtor").html("Please Select Statutary  Director Name").css('color', 'red');
		$("#statutaryAudtor").focus();
		return false;	
		}
	if($("#statutaryDir1").val()==$("#statutaryAudtor").val())
	{
		
	$("#errstatutaryDir").show();
	$("#errstatutaryDir").html("Not allow The same statutary Director names").css('color', 'red');
	$("#statutaryDir1").focus();
	return false;
	}
	else
		{
		$('#directorsOne12').val($('#statutaryAudtor').val());
		$('#statutaryDirec').val($('#statutaryDir1').val());
		$('#hdstaType').val("");
		$('#templateName').val("Letter to New Auditors for appointment- Firm/Individual");
		document.viewCalander.action="downloadWordDocument.html";
	 	document.viewCalander.method="GET";
	 	document.viewCalander.submit();
		}
	
});
$('#downloadDoc4').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	$('#date').val($('#hda2').val());
	if($("#noticeBoard").val() == "sel4" || $("#noticeBoard").val()=='')
	{
		$("#errnoticeBoard").show();
		$("#errnoticeBoard").html("Please Select  Director Name").css('color', 'red');
		$("#noticeBoard").focus();
		return false;	
		}
		else
			{
			$("#errnoticeBoard").hide();
			$("#errnoticeBoard").html("");
			}
	if($("#boardDir").val() == "sel4" || $("#boardDir").val()=='')
	{
		
		$("#errboardDir").show();
		$("#errboardDir").html("Please Select Statutary  Director Name").css('color', 'red');
		$("#statutaryAudtor").focus();
		return false;	
		}
	if($("#noticeBoard").val()==$("#boardDir").val())
	{
		
	$("#errboardDir").show();
	$("#errboardDir").html("Not allow The same statutary Director names").css('color', 'red');
	$("#boardDir").focus();
	return false;
	}
else{
   $('#hdstaType').val("NBM");
	$('#directorsOne12').val($('#noticeBoard').val());
	$('#statutaryDirec').val($('#boardDir').val());
	$('#templateName').val("BM NOTICE PHYSICAL MEETING");
	
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();
}
});
$('#downloadDoc8').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	//alert('hello');
	$('#date').val($('#hda1').val());
	if($("#reaapointment").val() == "sel6" || $("#reaapointment").val()=='')
	{
		$("#errreaapointment").show();
		$("#errreaapointment").html("Please Select Statutary Director Name").css('color', 'red');
		$("#reaapointment").focus();
		return false;	
		}
		else
			{
			$("#errreaapointment").hide();
			$("#errreaapointment").html("");
			}
	if($("#reaapointment1").val() == "sel5" || $("#reaapointment1").val()=='')
	{
		
		$("#errreaapointment1").show();
		$("#errreaapointment1").html("Please Select Director Name").css('color', 'red');
		$("#reaapointment1").focus();
		return false;	
		}
	if($("#reaapointment").val()==$("#reaapointment1").val())
	{
		
	$("#errreaapointment").show();
	$("#errreaapointment").html("Not allow The same statutary Director names").css('color', 'red');
	$("#reaapointment").focus();
	return false;
	}
	else
		{
		$('#hdstaType').val("");
		$('#directorsOne12').val($('#reaapointment').val());
		$('#statutaryDirec').val($('#reaapointment1').val());
		$('#templateName').val("Letter to Existing Auditors for re appointment- Firm/Individual");
		document.viewCalander.action="downloadWordDocument.html";
	 	document.viewCalander.method="GET";
	 	document.viewCalander.submit();
		}
	
});
$('#downloadDoc5').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	$('#hdstaType').val("ALLDIR");
	$('#hda3').val($('#hda3').val());
	$('#date').val($('#hda3').val());
	$('#templateName').val("BM ATTENDANCE REGISTER");
	
	$('#directorsOne12').val("");
	$('#statutaryDirec').val("");
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();
});
$('#downloadDoc6').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	$('#hda3').val($('#hda6').val());
	$('#date').val($('#hda6').val());
	$('#hdstaType').val("ALLDIR2");
	$('#templateName').val("AGM-ATTENDANCE");
	$('#directorsOne12').val("");
	$('#statutaryDirec').val("");
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();
});
$('#downloadDoc7').click(function(e){
	if($('#sel1').val()=="sel")
	{
	$('#errcname').show();
	$('#errcname').html("Slect Company Name").css('color', 'red');
	$('#errcname').focus();
	return flase();
	}
	$('#date').val($('#hda8').val());
	
	if($("#sec139-1").val() == "sel" || $("#sec139-1").val()=='')
	{
		$("#errsec139-1").show();
		$("#errsec139-1").html("Please Select  Director Name").css('color', 'red');
		$("#sec139-1").focus();
		return false;	
		}
		else
			{
			$("#errsec139-1").hide();
			$("#errsec139-1").html("");
			}
	if($("#sec139").val() == "sel4" || $("#sec139").val()=='')
	{
		
		$("#errsec139").show();
		$("#errsec139").html("Please Select Statutary  Director Name").css('color', 'red');
		$("#sec139").focus();
		return false;	
		}
	if($("#sec139-1").val()==$("#sec139").val())
	{
		
	$("#errsec139-1").show();
	$("#errsec139-1").html("Not allow The same statutary Director names").css('color', 'red');
	$("#errsec139-1").focus();
	return false;
	}
	else
		{
		$('#directorsOne12').val($('#sec139').val());
		$('#statutaryDirec').val($('#sec139-1').val());
		$('#hdstaType').val("");
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();
		}
});
/*$('#downloadDoc8').click(function(e){
	$('#date').val($('#hda1').val());
	document.viewCalander.action="downloadWordDocument.html";
 	document.viewCalander.method="GET";
 	document.viewCalander.submit();
});*/
});
function adjDate(num,typ){
	var agmdat = $("#a7").val();
	//alert('agmdat==='+agmdat);
	if(agmdat != "" ) {
		var datsplit=agmdat.split("-");
		 var mm22=parseInt(datsplit[1],10);
         var dd22=parseInt(datsplit[0],10);
 		var yy22=parseInt(datsplit[2],10);
		var d= new Date();d.setFullYear(yy22, mm22-1, dd22);
		if(typ=="rem")
			d.setDate(d.getDate()-num);
		else
			d.setDate(d.getDate()+num);
		var m = d.getMonth()+1;
		var dt = d.getDate();
		var dd = (dt<10)?"0"+dt:dt;
		var mm = (m<10)?"0"+m:m;
		return dd+"-"+mm+"-"+d.getFullYear();
	}
	else
		return "-N/A-";
}
function setcalendardates(no){
	var n = parseInt(no);//console.log(no);
	var bval=0,l=0;
	for(var i=n;i<7;i++){
		l = ($("#b"+i).val()=="")?0:$("#b"+i).val();
		bval += (l==0)?0:parseInt(l);
		//console.log(i+"-----"+bval);
	}
	var reqdate = adjDate(bval,"rem");
	$("#c"+no).html(bval);
	$("#a"+no).html(reqdate);
	$("#hda"+no).val(reqdate);
	setremcols(n);
}
function setremcols(n){
	var k=0,l=0,m=0,r=0;
	var update = "";
	for(var j=n;j>1;j--){
		update="";k=0;l=0;m=0;r=0;
		r=j-1;
		k=($("#c"+j).html()=="")?0:parseInt($("#c"+j).html());
		if(r>0)
			l=($("#b"+r).val()=="")?0:parseInt($("#b"+r).val());
		m=k+l;
		update = adjDate(m,"rem");//console.log(r+"---"+j+"-------"+k+"----"+l+"-===="+m+"---"+update);
		$("#a"+r).html(update);
		$("#hda"+r).val(update);
		$("#c"+r).html(m);
	}
}
function loadReqInfo(agmdat){
	//var agmdat = "01-08-2015";
	if(agmdat != ''){
		$("#a7").val(agmdat);//set agm date here
		for(var i=10;i>0;i--){
			k=($("#c"+i).html()=="")?0:parseInt($("#c"+i).html());
			if(i>6){
				$("#a"+i).html(adjDate(k,"add"));$("#hda"+i).val(adjDate(k,"add"));
			}
			else{
				$("#a"+i).html(adjDate(k,"rem"));$("#hda"+i).val(adjDate(k,"rem"));
			}
		}
	}
}
