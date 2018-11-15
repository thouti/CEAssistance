<%@include file="./taglib_includes.jsp" %>
<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<link href="./views/js/ui.datepicker.css" type="text/css" rel="stylesheet"/>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/jq.date.js"></script>
		<script type="text/javascript" src="./views/js/addCompanieInfoTwo.js"></script>
		<!-- <script type="text/javascript">
	      $(document).ready(function() {
	      		$("#record_date").datepicker();
		  });
      	</script> -->
      	<script type="text/javascript">
      $(document).ready(function() {
                    $("#record_date").datepicker({dateFormat: 'mm-dd-yy', minDate: 0, showOn: 'button', buttonImage:  value="./views/images/calendar01.gif", buttonImageOnly: true});
    	 	  });
      </script> 
		<style type="text/css">
			hr {
			    margin: 5px 0;
			    border: 1px solid #F8F8F8;
			}
			table, th, td {
				border: 1px solid #c3dde0;
				border-collapse: collapse;
				/*background-color:#E6E6E6;*/
			}
			th, td {
				padding: 10px;
			}
		</style>
		<script type="text/javascript">
			function mailChk(obj,div){
				var mailReg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
				if(!mailReg.test(obj.value)) 
					displayalertmsgtwo("Please give valid E-mail Id ",div);
				else
					displayalertmsgtwo("",div);
	    	}
			function displayalertmsgtwo(msg,div){
				if(document.getElementById(div))
		    		document.getElementById(div).innerHTML = msg;
			}
		
			function showfinDiv(type){
				if(type=="yes") 
					document.getElementById("financeinfo_div").style.display="block";
				else
					document.getElementById("financeinfo_div").style.display="none";
			}
			function showOther(val){
			    if (document.getElementById(val).value == 'other')
			    	document.getElementById(val+"td").innerHTML = "<input type='text' id='"+val+"'>";
			}
			function showReq(val,obj){
				var idv=obj.name;
				if(val)
					document.getElementById("dividend_opt").style.display="block";
				else{
					document.getElementById("dividend_opt").style.display="none";
				}
			}
		</script>
		
		<script type="text/javascript">
		function removeMessage()
		{
			
			/* if(document.getElementById("designation").value!="")
				{
				$('#errdesignation').html("");
				}
			if(document.getElementById("designation").value.length>4)
			{
			$('#errdesignation').html("");
			}
			if(document.getElementById("dinPin").value!="")
			{
			$('#errdinPin').html("");
			}
			if(document.getElementById("d_designation").value!="")
			{
			$('#errd_designation').html("");
			}
			if(document.getElementById("d_designation").value.length>4)
		{
		$('#errd_designation').html("");
		}
			if(document.getElementById("d_dinPin").value!="")
			{
			$('#errd_dinPin').html("");
			} */
			if(document.getElementById("yes_dividend_proposed_paid").value!="")
			{
			$('#errproposedPaid').html("");
			}
			if(document.getElementById("no_fully_paid").value!="")
			{
			$('#errfullyPaid').html("");
			}
			if(document.getElementById("face_value_Eshare").value!="")
			{
			$('#errvalueShare').html("");
			}
			
			if(document.getElementById("authorised_dir_designation").value!="")
			{
			$('#authDesignation').html("");
			}
			if(document.getElementById("authorised_dir_din").value!="")
			{
			$('#errAuthoDir').html("");
			}
			if(document.getElementById("dividend_amounts").value!="")
			{
			$('#errDividendAmt').html("");
			}
			if(document.getElementById("dividend_amounts").value!="")
			{
			$('#errBankAcc').html("");
			}
			if(document.getElementById("unpaid_unclaimed").value!="")
			{
			$('#errUnpaid').html("");
			}
			if(document.getElementById("audit_reporterName").value!="")
			{
			$('#errAuditorName').html("");
			}
		if(document.getElementById("audit_reporterName").value.length>4)
		{
		$('#errAuditorName').html("");
		}
		if(document.getElementById("firmRegNo").value!="")
			{
			$('#errfirmRegNo').html("");
			}
		if(document.getElementById("firmRegNo").value.length>4)
		{
		$('#errfirmRegNo').html("");
		}
		if(document.getElementById("audit_name").value!="")
			{
			$('#erraudit_name').html("");
			}
		if(document.getElementById("audit_name").value.length>4)
		{
		$('#erraudit_name').html("");
		}
		if(document.getElementById("record_date").value!="")
		{
		$('#errDatepick').html("");
		}
		}
		function removeselectMess()
		{
			if(document.getElementById("dividend_paid_out").value!="sel")
			{
			$('#errpaidOut').html("");
			}
			if(document.getElementById("divpaid").value!="sel")
			{
			$('#errDivpaid').html("");
			}
			
		}
		</script>
		
		
	</head>
	<body onload="">
	
		<div class="wrapper">
			<div class="header">
			
				<div class="head_left" align="center" valign="middile"><img src="views/images/cea-logo.png" alt="logo" border="0"   width="161" height="67"></div>
				<div class="head_mid"></div>
				<div class="head_right">
					<div align="left" width="100px;" style="padding:18px 0px 0px 0px;">Hello, <%=session.getAttribute("uName").toString()%></div>
					<div align="left" width="100px;" style="padding:8px 0px 0px 0px;">Account Type:${userType}</div>
				</div>
				 <form name="logOutForm">
				<div >
				<div align="right" id="addCom" ><img src="views/images/logout.png" alt="proceed" border="0" width="40" height="40" id="logout" title="logout"/></div><br/>
				</div></form>
			</div>
			<div class="main_content">
				<div class="menu_content"> 
				<div id='cssmenu'>
				   <ul>
					  <li><a href='#'><span>Home</span></a></li>
					  <li><a href="howItWorks.html"><span>How it works</span></a></li>
					  <li class='active has-sub'><a href="#" ><span>Products</span></a>
						<ul>
							<li class='last'><a href="userRegisterAgmdate.html?userId=${userId}&userType=${userType}&hdName=<%=session.getAttribute("uName").toString()%>&userId=${userId}&userType=${userType}">AGM</a></li>
						</ul>
					  </li>
					  <li><a href="partnerWithUs.html"><span>Partner with Us</span></a></li>
					  <li><a href="aboutUs.html" ><span>About Us</span></a></li>
					  <li class='last'><a href="contactUs.html" ><span>Contact Us</span></a></li>
					</ul>
				</div>
			</div>
				<div class="left">
					<div class="glossymenu">
						<ul>
								<li><a href="retriveUserDetails.html?userId=<%=session.getAttribute("userId").toString()%>" style="text-decoration:none" >View Profile</a></li>
								<li><a href="#" style="text-decoration:none" >Company Status</a></li>
								<li><a href="userRegisterAgmdate.html?userId=${userId}&userType=${userType}" style="text-decoration:none">Add Companies</a></li>
								<li><a href="leftPaneladdCompaniesDtls.html?userId=${userId}" style="text-decoration:none">Add Information </a></li>
								<li><a href="leftAddComponyInfoDtls.html?userId=${userId}" style="text-decoration:none">Add Information more</a></li>
								<li><a href="viewCalendar.html?userId=${userId}" style="text-decoration:none">View Calendar and customize</a></li>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">Download Check lists </a></li>
							</ul>
					</div>
				</div>
				<div class="right">
					<div style="background-color:#F8F8F8;overflow:auto;">
					
						<div width="100%" class="headtext" align="center">Add information (BM and PostBM)</div>
						<hr/>
						
						<form:form name="addinfotwo" commandName="addinfotwo">
						<div align="center" class="normtextfir">Company Name:
							<select id="companyname" name="company_name">
							<option value="sel">------------Please Select Company Name------------</option>
							<c:forEach var="comList" items="${commonVo}">
						<option value="${comList.companyName}-${comList.companyId}">${comList.companyName}</option>
						</c:forEach> </select><span id="errcname"></span></div>
<!-- 						<div width="100%" class="sideheadtext" align="left">Financial Statements</div> -->
						<div id="main">
						<div width="100%" class="sideheadtext" align="left">Financial Statements</div>
							<div class="normtextfir" align="left">Whether consolidated statements are required to be placed before the Board. <input type="radio" name="finance"> Yes <input type="radio" name="finance" checked> No</div>
							<div id="financeinfo_div" style="display:block;"><br/>
							<div id="financeinfo_errdiv" class="errortext"></div>
								<div class="sideheadtext">Signatories of Financial Statements</div><br/>
								<!-- <table width="90%" class="tabcss_main1" id="finTab" align="center">
									<tr>
										<th>Name</th>
										<th>Designation</th>
										<th>DIN/PAN</th>
									</tr>
									</table>
									 -->
									<table width="100%" class="tabcss_main1" id="finTab" align="center">
									<tr id="fintr">
										<td><select id="final_stmt_diretcor"  name="final_stmt_diretcor" multiple="multiple" onchange="show()"></select><span id="errfinalstmtdirector1"></span></td>
										<td><input id="btnAdd" type="button" value="Add" />
<div id="TextBoxContainer">
    <!--Textboxes will be added here -->
</div></td>
									</tr></table>
									
								
								
								<div class="normtext"><b><u>Note</u>: </b><br/>Section 134(1) of Companies Act, 2013 provides that a Financial Statements shall be signed by :<br/>                                       
								a. Chairperson of the Company where he is authorised by the Board or by two Directors (out of which one shall be MD, if any)  <br/>                                                                               
								b. Chief Executive Officer, if he is a director of the Company  <br/>                                                                  
								c. Chief Financial Officer, if any     <br/>                                    
								d. Company Secretary, if any<br/>
								</div>
							</div>
							<div width="100%" class="headtext" align="center">Directors Report</div>
							<div class="sideheadtext">Signatories of Director's Statements</div><br/>
							<div id="signat_errdiv" class="errortext"></div>
							<table width="100%" class="tabcss_main1" id="sigTab" align="center">
								<tr>
										<td><select id="final_stmt_diretcor2"  name="final_stmt_diretcor2" multiple="multiple" onchange="show1()"></select><span id="errfinal_stmt_diretcor2"></span></td>
										<td><input id="btnAdd2" type="button" value="Add" />
<div id="TextBoxContainer1">
    <!--Textboxes will be added here -->
</div></td>
									</tr></table>
								
							<div class="normtext"><b><u>Note</u>:</b><br/> Section 134(6) of Companies Act, 2013 provides that a Dorector's Report shall be signed by :<br/>                                       
								a. Chairperson of the Company where he is authorised by the Board or  <br/>                                                                               
								b. by two Directors (out of which one shall be MD, if any)   <br/>                                                                  
							</div>
							<div class="sideheadtext">Dividend</div>
							<div class="normtext" align="left">1. Whether any dividend is proposed to be paid out of the profits or accumulated profits to the members of the Company. <input type="radio" name="dividend_proposed_paid" onClick="showReq(true,this)" value="yes"> Yes <input type="radio" name="dividend_proposed_paid" value="no" onClick="showReq(false,this)" checked> No<br/><br/></div>
							<div class="normtext" align="left" id="dividend_opt" style="display:none;">
							<div id="divid_errdiv" class="errortext"></div>
								2. Percentage of dividend proposed to be paid: <input type="text" id="yes_dividend_proposed_paid" name="yes_dividend_proposed_paid" maxlength=3 size=3 onkeyup="removeMessage()"/> %<span id="errproposedPaid"></span><br/><br/>
								3. Dividend is paid out of :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="dividend_paid_out" name="dividend_paid_out" onchange="removeselectMess()"><option value="sel">----Select----</option><option value="current year profits">Current year profits</option><option value="previous year profits">Previous year profits</option><option value="current year and previous year profits">current year and previous year profits</option></select><span id="errpaidOut"></span><br/><br/> 
								4. Number of Fully paid up Equity Shares:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="no_fully_paid" name="no_fully_paid" maxlength=3 size=3 onkeyup="removeMessage()"/> %<span id="errfullyPaid"></span><br/><br/>
								5. Face value of each Equity Share(in Rupees): <input type="text" id="face_value_Eshare" name="face_value_Eshare" maxlength=8 size=3 onkeyup="removeMessage()" onblur="chkDateFormat()"/><span id="errvalueShare"></span><br/><br/>
								6. Record Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="record_date" name="record_date"  size=10 onkeyup="removeMessage()"/><span id="errDatepick"></span><br/><br/>
								7. State who shall be authorised to take actions relating to Dividend:<br/>
								<div id="divid_sub_errdiv" class="errortext"></div>
								 <!-- <table width="90%" class="tabcss_main1" id="sigTab" align="center">
									<tr>
										<th>Name</th>
										<th>Designation</th>
										<th>DIN/PAN</th>
									</tr>
									<tr>
										<td><select id="authorised_dir_name" name="authorised_dir_name" onchange="onchange()"></select><div id="others3"><input type="text" name="authorised_dir_name1"></div><span id="errAuthorisedDirName"></span></td>
										<td><input type="text" id="authorised_dir_designation" name="authorised_dir_designation" onkeyup="removeMessage()"></input><span id="authDesignation"></span></td>
										<td><input type="text" id="authorised_dir_din" name="authorised_dir_din" onkeyup="removeMessage()"></input><span id="errAuthoDir"></span></td>
									</tr>
								</table>  -->
								 <table width="100%" class="tabcss_main1" id="sigTab" align="center">
								<tr>
										<td><select id="authorised_dir_name"  name="authorised_dir_name" multiple="multiple" onchange="show2()"></select><span id="authorised_dir_name1"></span></td>
										<td><input id="btnAdd3" type="button" value="Add" />
<div id="TextBoxContainer2">
    
</div></td>
									</tr></table> 
								<br/>
								8. In which name a separate bank account be opened in order to transfer the dividend amounts: <input type="text" id="dividend_amounts" name="dividend_amounts" onkeyup="removeMessage()"/><span id="errDividendAmt"></span><br/><br/>
								9. Bank and Branch name to open a separate bank account: <input type="text" id="acct_bank" name="bank_account" onkeyup="removeMessage()"/><span id="errBankAcc"></span><br/><br/>
								10. In which name a bank account be named to transfer unpaid / unclaimed dividend amounts: <input type="text" id="unpaid_unclaimed" name="Unpaid_Unclaimed" onkeyup="removeMessage()"/><span id="errUnpaid"></span><br/><br/>
								<b><u>Note</u>:</b><br/>
									a. Dividend shall be deposited in a scheduled bank and transfer the amount in 5 days after declaration in the AGM. <br/>
									b. Dividend shall be paid within 30 days of declaration of dividend.<br/>  
									c. within 7 days after 30 days from the date of declaration of dividend, unpaid and unclaimed amounts shall be transferred to special bank account in the name of Unpaid Dividend Account with Schedule bank.
								
							</div>
							
							<div class="sideheadtext">Secretarial Audit</div>
							<div class="normtext">State whether Secretarial Audit is required for the Company: <input type="radio" name="audit_required" onClick="document.getElementById('secaudTab').style.display='block';" value="yes"> Yes <input type="radio" name="audit_required" onClick="document.getElementById('secaudTab').style.display='none';" value="no" checked> No<br/><br/>
							    <div id="secaudTab" style="display:none;"> Select the nature of Secretarial Auditor:
							    <select id="divpaid" name="secretarial_auditors" onchange="removeselectMess()">
							    <option value="sel">----Select----</option>
							    <option value="firm">Firm</option>
							    <option value="individual">Individual</option></select><span id="errDivpaid"></span><br/><br/> 
								 Details of the Secretarial Auditors who gave the Audit Report:<br/>
							
									<table width="90%" class="tabcss_main1">
									<div id="Secretarial_errdiv" class="errortext"></div>
										<tr>
											<th>Name</th>
											<th>Firm Regn. / Membership no.</th>
											<th>Address</th>
											<th>E-mail id</th>
										</tr>
										<tr>
											<td><input type="text" id="audit_reporterName"  name="audit_reporterName" onkeyup="removeMessage()"></input><span id="errAuditorName"></span></td>
											<td><input type="text" id="firmRegNo" name="firmRegNo" onkeyup="removeMessage()"></input><span id="errfirmRegNo"></span></td>
											<td><input type="text" id="audit_name" name="audit_name" onkeyup="removeMessage()"></input><span id="erraudit_name"></span></td>
											<td><input type="text" id="audit_email" name="audit_email"></input><span id="erraudit_email"></span></td>
										</tr>
									</table><br/>
								</div>
							</div>
							</div>
							<input type="hidden" name="userId" value="${userId}">
						<input type="hidden" id="fetchData" name="fetchData">
						<input type="hidden" id="directorStmtData" name="directorStmtData">
						<input type="hidden" id="devidendDir" name="devidendDir">
							<div align="right"><img src="views/images/proceed1.jpg" id="addcomInfotwo" alt="proceed" border="0" width="125" height="25"/></div><br/>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
