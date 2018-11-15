<%@include file="./taglib_includes.jsp"%>
<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<link href="./views/js/ui.datepicker.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
		<script type="text/javascript" src="./views/js/editDelete.js"></script>
		<script type="text/javascript" src="./views/js/jq.date.js"></script>
		<script type="text/javascript">
      $(document).ready(function() {
    	  $("#datepick").datepicker({dateFormat: 'mm-dd-yy', minDate: 0, showOn: 'button', buttonImage:  value="./views/images/calendar01.gif", buttonImageOnly: true});
    	  $("#datepick1").datepicker({dateFormat: 'mm-dd-yy', minDate: 0, showOn: 'button', buttonImage:  value="./views/images/calendar01.gif", buttonImageOnly: true});
    	  $("#record_date").datepicker({dateFormat: 'mm-dd-yy', minDate: 0, showOn: 'button', buttonImage:  value="./views/images/calendar01.gif", buttonImageOnly: true});
	  });
      
      </script> 
     <!--  <script type="text/javascript">
			function chkTimeformat(obj,div){
				var tmReg = /^\d{2}\:\d{2}$/;
				if(!tmReg.test(obj.value)) {
					displayalertmsginfone("Please give Time in 24 hrs and HH:MM format",div);
					document.getElementById(obj.id).focus();return false;
				}
				else{
					var tim = obj.value;
					var hh = tim.substring(0,2), mm = tim.substring(3,5);
					if(hh>23){
						displayalertmsginfone("Please give valid Hour",div);
						document.getElementById(obj.id).focus();return false;
					}
					else if(mm>59){
						displayalertmsginfone("Please give valid Minutes",div);
						document.getElementById(obj.id).focus();return false;
					}
				}
				displayalertmsginfone("",div);
			}
			</script>  -->
      <script type="text/javascript">
function removeMess()
{
	if(document.getElementById("companyName").value!="")
	{
	$('#errorcompanyName').html("");
	}
	if(document.getElementById("companyName").value.length>4)
	{
	$('#errorcompanyName').html("");
	}
	if(document.getElementById("address").value!="")
	{
	$('#errAddress').html("");
	}
	if(document.getElementById("address").value.length>4)
	{
	$('#errAddress').html("");
	}
	if(document.getElementById("financialYear").value!="")
	{
	$('#errfinancialYear').html("");
	}
	if(document.getElementById("agmDueDate").value!="")
	{
	$('#erragmDueDate').html("");
	}
	if(document.getElementById("agmDate").value!="")
	{
	$('#erragmDate').html("");
	}
	if(document.getElementById("agmNo").value!="")
	{
	$('#erragmNo').html("");
	}
	if(document.getElementById("noOfBeforeTask").value!="")
	{
	$('#errnoOfBeforeTask').html("");
	}
}
function removeMessOne()
{
	if(document.getElementById("director").value!="")
	{
	$('#errdirectorName').html("");
	}
	if(document.getElementById("director").value.length>4)
	{
	$('#errdirectorName').html("");
	}
	if(document.getElementById("din").value!="")
	{
	$('#errdin').html("");
	}
	if(document.getElementById("din").value.length>4)
	{
	$('#errdin').html("");
	}
	if(document.getElementById("designation").value!="")
	{
	$('#errdesignation').html("");
	}
	if(document.getElementById("designation").value.length>4)
	{
	$('#errdesignation').html("");
	}
	if(document.getElementById("diraddress").value!="")
	{
	$('#errAddress1').html("");
	}
	if(document.getElementById("diraddress").value.length>4)
	{
	$('#errAddress1').html("");
	}
	if(document.getElementById("email").value!="")
	{
	$('#erremail').html("");
	}
}
function removeMess()
{
	if(document.getElementById("StadirectorName").value!="")
	{
	$('#errStadirectorName').html("");
	}
	if(document.getElementById("StadirectorName").value.length>4)
	{
	$('#errStadirectorName').html("");
	}
	if(document.getElementById("Staemail").value!="")
	{
	$('#errStaemail').html("");
	}
	if(document.getElementById("registrationNumber").value!="")
	{
	$('#errRegNO').html("");
	}
	if(document.getElementById("registrationNumber").value.length>4)
	{
	$('#errRegNO').html("");
	}
	if(document.getElementById("typeOfAuditor").value!="")
	{
	$('#errAuditor').html("");
	}
	if(document.getElementById("typeOfAuditor").value.length>4)
	{
	$('#errAuditor').html("");
	}
	if(document.getElementById("SecdirectorName").value!="")
	{
	$('#errSecdirectorName').html("");
	}
	if(document.getElementById("SecdirectorName").value.length>4)
	{
	$('#errSecdirectorName').html("");
	}
	if(document.getElementById("Secemail").value!="")
	{
	$('#errSecemail').html("");
	}
	if(document.getElementById("memberShipNo").value!="")
	{
	$('#errmemberShipNo').html("");
	}
	if(document.getElementById("memberShipNo").value.length>4)
	{
	$('#errmemberShipNo').html("");
	}
	if(document.getElementById("panNumber").value!="")
	{
	$('#errpanNumber').html("");
	}
	if(document.getElementById("panNumber").value.length<11)
	{
	$('#errpanNumber').html("");
	}
	if(document.getElementById("boardVenue").value!="")
	{
	$('#errboardVenue').html("");
	}
	if(document.getElementById("boardVenue").value.length>4)
	{
	$('#errboardVenue').html("");
	}
	if(document.getElementById("boardTime").value!="")
	{
	$('#errboardTime').html("");
	}
	if(document.getElementById("boardTime").value.length<7)
	{
	$('#errboardTime').html("");
	}
	if(document.getElementById("agmVenue").value!="")
	{
	$('#erragmVenue').html("");
	}
	if(document.getElementById("agmVenue").value.length>4)
	{
	$('#erragmVenue').html("");
	}
	if(document.getElementById("agmTime").value!="")
	{
	$('#erragmTime').html("");
	}
	if(document.getElementById("agmTime").value.length<7)
	{
	$('#erragmTime').html("");
	}
	if(document.getElementById("nature_sauditor").value!="")
	{
	$('#errnature_sauditor').html("");
	}
	if(document.getElementById("nature_sauditor").value.length>4)
	{
	$('#errnature_sauditor').html("");
	}
	if(document.getElementById("sdPeriod").value!="")
	{
	$('#errsdPeriod').html("");
	}
	if(document.getElementById("sdPeriod").value.length>4)
	{
	$('#errsdPeriod').html("");
	}
	if(document.getElementById("dividend_proposed_paid").value!="")
	{
	$('#errdividend_proposed_paid').html("");
	}
	if(document.getElementById("dividend_proposed_paid").value.length>4)
	{
	$('#errdividend_proposed_paid').html("");
	}
	if(document.getElementById("yes_dividend_proposed_paid").value!="")
	{
	$('#erryes_dividend_proposed_paid').html("");
	}
	if(document.getElementById("yes_dividend_proposed_paid").value.length>4)
	{
	$('#erryes_dividend_proposed_paid').html("");
	}
	if(document.getElementById("dividend_paid_out").value!="")
	{
	$('#errdividend_paid_out').html("");
	}
	if(document.getElementById("dividend_paid_out").value.length>4)
	{
	$('#errdividend_paid_out').html("");
	}
	if(document.getElementById("no_fully_paid").value!="")
	{
	$('#errno_fully_paid').html("");
	}
	/* if(document.getElementById("no_fully_paid").value.length>4)
	{
	$('#errno_fully_paid').html("");
	} */
	if(document.getElementById("face_value_Eshare").value!="")
	{
	$('#errface_value_Eshare').html("");
	}
	if(document.getElementById("face_value_Eshare").value.length>4)
	{
	$('#errface_value_Eshare').html("");
	}
	if(document.getElementById("record_date").value!="")
	{
	$('#errrecord_date').html("");
	}
	if(document.getElementById("dividend_amounts").value!="")
	{
	$('#errdividend_amounts').html("");
	}
	if(document.getElementById("bank_account").value!="")
	{
	$('#errbank_account').html("");
	}
	if(document.getElementById("secretarial_auditors").value!="")
	{
	$('#errsecretarial_auditors').html("");
	}
	if(document.getElementById("secretarial_auditors").value.length>4)
	{
	$('#errsecretarial_auditors').html("");
	}
	if(document.getElementById("audit_reporterName").value!="")
	{
	$('#erraudit_reporterName').html("");
	}
	if(document.getElementById("audit_reporterName").value.length>4)
	{
	$('#erraudit_reporterName').html("");
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
	
}
	</script>
	<script type="text/javascript">
	function removeMessSel()
	{
		
		if(document.getElementById("companyType").value!="sel")
		{
		$('#errCompanyType').html("");
		}
		
	if(document.getElementById("serviceRequired").value!="sel")
	{
	$('#errserviceRequired').html("");
	}
	if(document.getElementById("gender").value!="sel")
	{
	$('#errgender').html("");
	}
	if(document.getElementById("dividend_paid_out").value!="sel")
	{
	$('#errdividend_paid_out').html("");
	}
	if(document.getElementById("dividend_proposed_paid").value!="sel")
	{
	$('#errdividend_proposed_paid').html("");
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
					<div align="left" width="100px;" style="padding:18px 0px 0px 0px;">Hello,<%=session.getAttribute("uName").toString()%></div>
					<div align="left" width="100px;" style="padding:8px 0px 0px 0px;">Account Type: ${userType}</div>
				</div>
				 <form name="logOutForm">
				<div >
				<div align="right" id="addCom" ><img src="views/images/logout.png" alt="proceed" border="0" width="40" height="40" id="logout" title="logout"/></div><br/>
				</div></form>
			</div>
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
			<div class="main_content">
				<div class="left">
					<div class="glossymenu">
						<div class="submenu">
							<ul>
								<li><a href="retriveUserDetails.html?userId=<%=session.getAttribute("userId").toString()%>" style="text-decoration:none" >View Profile</a></li>
								<li><a href="#" style="text-decoration:none" >Company Status</a></li>
								<li><a href="userRegisterAgmdate.html?userId=${userId}&userType=${userType}" style="text-decoration:none">Add Companies</a></li>
								<li><a href="leftPaneladdCompaniesDtls.html?userId=${userId}" style="text-decoration:none">Add Information </a></li>
								<li><a href="leftAddComponyInfoDtls.html?userId=${userId}" style="text-decoration:none">Add Information more</a></li>
								<li><a href="viewCalendar.html?userId=${userId}" style="text-decoration:none">View Calendar and customize</a></li>
								<li><a href="updateDeleteCompanyDtls.html?userId=${userId}" style="text-decoration:none">Update Or Delete</a></li>
							</ul>
						</div>
					</div>
				</div> 
				</div>
				<c:if test="${successMessage!=null}">
				<div><font color="green">${successMessage}</font></div>
				</c:if>
				<div align="center" ><strong> ${userCompanyDetails.companyName}&nbsp;Company Details</strong></div>
			<form:form name="companyDtls" commandName="companyDtls">
			<input type="hidden" name="cName" value="${companyName}">
			<div>
	<table>
	
		<tr>
									<td>Company Name</td>
									<td><input type="text" value="${userCompanyDetails.companyName}" name="companyName" id="companyName" onkeyup="removeMess()" ><br/><span id="errorcompanyName"></span></td>
									<td>Address</td>
									<td><input type="text" value="${userCompanyDetails.address}" name="address" id="address" onkeyup="removeMess()"><span id="errAddress"></span></td>
									</tr>
									<tr>
									<td>Company Type</td>
									<td>
									<select name="companyType" onchange="removeMessSel()" id="companyType">
									<option value="sel">-select-</option>
									<c:choose>
									<c:when test="${userCompanyDetails.companyType=='private'}">
									<option selected="selected" value="${userCompanyDetails.companyType}">${userCompanyDetails.companyType}</option>
									</c:when>
									<c:otherwise>
									<option value="private">private</option>
									</c:otherwise>
									</c:choose>
									<c:choose>
									<c:when test="${userCompanyDetails.companyType=='public'}">
									<option selected="selected" value="${userCompanyDetails.companyType}">${userCompanyDetails.companyType}</option>
									</c:when>
									<c:otherwise>
									<option value="public">public</option>
									</c:otherwise>
									</c:choose>
									
									
									</select><span id="errCompanyType"></span>
									</td>
									<td>Financial Year</td>
									<td><input type="text" value="${userCompanyDetails.financialYear}" name="financialYear" id="financialYear" onkeyup="removeMess()"><span id="errfinancialYear"></span></td>
									</tr>
									<tr>
									<td>AGM due date</td>
									<td><input type="text"  id="datepick" value="${userCompanyDetails.agmDueDate}" name="agmDueDate"  id="agmDueDate" readonly="readonly" onkeyup="removeMess()"><span id="erragmDueDate"></span></td>
									<td>AGM date</td>
									<td><input type="text" id="datepick1" value="${userCompanyDetails.agmDate}" name="agmDate" id="agmDate" readonly="readonly" onkeyup="removeMess()"><br/><span id="erragmDate"></span></td>
									</tr>
									<tr>
									<td>AGM No</td>
									<td><input type="text" class="number" size="3" maxlength="3" value="${userCompanyDetails.agmNo}" name="agmNo" id="agmNo" onkeyup="removeMess()"><br/><span id="erragmNo"></span></td>
									<td>Services required</td>
									<td>
									<select name="serviceRequired" id="serviceRequired" onchange="removeMessSel()">
									<option value="sel">-select-</option>
									<c:choose>
									<c:when test="${userCompanyDetails.serviceRequired=='Send Alerts'}">
									<option selected="selected" value="${userCompanyDetails.serviceRequired}">${userCompanyDetails.serviceRequired}</option>
									</c:when>
									<c:otherwise>
									<option value="Send Alerts">Send Alerts</option>
									</c:otherwise>
									</c:choose>
									<c:choose>
									<c:when test="${userCompanyDetails.serviceRequired=='Share Documents'}">
									<option selected="selected" value="${userCompanyDetails.serviceRequired}">${userCompanyDetails.serviceRequired}</option>
									</c:when>
									<c:otherwise>
									<option value="Share Documents">Share Documents</option>
									</c:otherwise>
									</c:choose>
									
									
									</select><span id="errserviceRequired"></span>
									</td>
									</tr>
									<tr>
									<td>Reminder days before Task</td>
									<td><input type="text" class="number" size="3" maxlength="3" value="${userCompanyDetails.noOfBeforeTask}" name="noOfBeforeTask" id="noOfBeforeTask" onkeyup="removeMess()"><br/><span id="errnoOfBeforeTask"></span></td>
									<td>&nbsp;<input type="hidden" id="companyId" name="companyId" value="${userCompanyDetails.companyId}" ></td>
									<td>&nbsp;</td></tr>
									<tr>
									<td>&nbsp;</td>
									<td align="right"><div align="right" id="update" style="padding-top: 20px;"><img src="views/images/update.jpg" alt="update" border="0" width="85" height="25" title="update"/></div>&nbsp;&nbsp;&nbsp;</td>
									<td align="left"><div align="right" id="delete"><img src="views/images/delete.jpg" alt="delete" border="0" width="85" height="25" title="delete"/></div></td>
									<td>&nbsp;</td>
									</tr>
									
	</table>
	<div></div>
			</div>
			</form:form>
			<div  class="sideheadtext" align="center"><strong>${userCompanyDetails.companyName} &nbsp;&nbsp;&nbsp; Director List</strong></div>
			<div align="center">
			<c:if test="${!empty(directorDtls)}">
			Director Name:<select name="directorName" id="directorName" >
             <option value="sel">--Select--</option>
			<c:forEach items="${directorDtls}" var="directorDtls">
			<option value="${directorDtls.directorId}-${directorDtls.dirName}">${directorDtls.dirName}</option>
			</c:forEach>
			</select><span id="errDirName"></span>
			</c:if>
			<c:if test="${empty(directorDtls)}">
			<div><font color="red">No Director Are Found </font> for Add Directors <a href="leftPaneladdCompaniesDtls.html?userId=${userId}">Add Director Details</a></div>
			</c:if>
			</div>
			<br/>
			<div id="alldir">
			<div  class="sideheadtext" align="center"><strong>Director Details</strong></div>
			<form:form name="diretcrListForm" commandName="diretcrListForm">
			<input type="hidden" name="cName" value="${companyName}">
			<input type="hidden" name="hdDirId" id="hdDirId">
			<div id="directorListDat">
			
			<table>
			<tr>
			<td>Director Name:</td>
			<td><input type="text" id="director" name="directorName" onkeyup="removeMessOne()"><br/><span id="errdirectorName"></span></td>
			<td>Gender:</td>
			<td>
			<select name="gender" id="gender" onchange="removeMessSel()">
			<option value="sel">-select-</option>
			<option value="male">Male</option>
			<option value="female">female</option>
			</select><br/><span id="errgender"></span>
			</td>
			</tr>
			<tr>
			<td>Din:</td>
			<td><input type="text" id="din" name="dIN" onkeyup="removeMessOne()"><br/><span id="errdin"></span></td>
			<td>Designation:</td>
			<td><input type="text" id="designation" name="designation" onkeyup="removeMessOne()"><br/><span id="errdesignation"></span></td>
			</tr>
			<tr>
			<td>Address:</td>
			<td><input type="text" id="diraddress" name="address" onkeyup="removeMessOne()"><br/><span id="errAddress1"></span></td>
			<td>Email:</td>
			<td><input type="text" id="email" name="email" onkeyup="removeMessOne()"><br/><span id="erremail"></span></td>
			</tr>
			<tr>
		<td>&nbsp;</td>
		<td align="right"><div align="right" id="updateOne"><img src="views/images/update.jpg" alt="update" border="0" width="85" height="25" title="update"/></div></td>
		<td align="left"><div align="right" id="deleteDir"><img src="views/images/delete.jpg" alt="delete" border="0" width="85" height="25" title="delete"/></div></td>
		<td>&nbsp;</td>
		</tr>
			</table>
			</div>
			<%-- </form:form>
			<form:form name="staAuditorForm" commandName="staAuditorForm"> 
			<input type="hidden" name="cName" value="${companyName}">
			<input type="hidden" name="hdDirId" id="hdDirId">--%>
			
			<div id="staAuditor">
			<table>
			<tr>
			<td>Director Name:</td>
			<td><input type="text" id="StadirectorName" name="strdirectorName" onkeyup="removeMess()"><br/><span id="errStadirectorName"></span></td>
			<td>Email:</td>
			<td><input type="text" id="Staemail" name="staemail" onkeyup="removeMess()"><br/><span id="errStaemail"></span></td>
			</tr>
			<tr>
			<td>Registration Number:</td>
			<td><input type="text" id="registrationNumber" name="registrationNumber" onkeyup="removeMess()"><br/><span id="errRegNO"></span></td>
			<td>Type Of Auditor:</td>
			<td><input type="text" id="typeOfAuditor" name="typeOfAuditor" onkeyup="removeMess()"><br/><span id="errAuditor"></span></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
		<td align="right"><div align="right" id="StaAuditorupdateOne"><img src="views/images/update.jpg" alt="update" border="0" width="85" height="25" title="update"/></div>&nbsp;&nbsp;&nbsp;</td>
		<td align="left"> <div align="right" id="StaAuditordelete"><img src="views/images/delete.jpg" alt="delete" border="0" width="85" height="25" title="delete"/></div> </td>
		<td>&nbsp;</td>
		</tr>
			</table>
			</div>
			 <div id="companySecratary">
			<table>
			<tr>
			<td>Director Name:</td>
			<td><input type="text" id="SecdirectorName" name="secdirectorName" onkeyup="removeMess()"><br/><span id="errSecdirectorName"></span></td>
			<td>Email:</td>
			<td><input type="text" id="Secemail" name="secEmail" onkeyup="removeMess()"><br/><span id="errSecemail"></span></td>
			</tr>
			<tr>
			<td>MemberShip Number:</td>
			<td><input type="text" id="memberShipNo" name="memberShipNo" onkeyup="removeMess()"><br/><span id="errmemberShipNo"></span></td>
			<td>Pan Number:</td>
			<td><input type="text" id="panNumber" name="panNumber" onkeyup="removeMess()"><br/><span id="StadirectorName"></span></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
		<td align="right"><div align="right" id="ComSecupdateOne"><img src="views/images/update.jpg" alt="update" border="0" width="85" height="25" title="update"/></div>&nbsp;&nbsp;&nbsp;</td>
		<td align="left"><div align="right" id="ComSecdelete"><img src="views/images/delete.jpg" alt="delete" border="0" width="85" height="25" title="delete"/></div></td>
		<td>&nbsp;</td>
		</tr>
			</table>
			</div>
			
			<input type="hidden" name="hdDirType" id="hdDirType">
			
			</form:form>
			</div>
			</div>
		<div>
		<form:form name="companyInfoOneForm" commandName="companyInfoOneForm">
		<input type="hidden" name="cName" value="${companyName}">
		<c:choose>
		<c:when test="${companyInfoDtls.errorCode==1}">
		<div  class="sideheadtext" align="center"><strong>Company Common Information Details</strong></div>
		<div id="venue_errdiv" class="errortext"></div>
		<table>
		<tr>
		<td>Board Venue:</td>
		<td><input type="text" value="${companyInfoDtls.boardVenue}" name="boardVenue" id="boardVenue" onkeyup="removeMess()"><br/><span id="errboardVenue"></span></td>
		<td>Board Time:</td>
		<td><input type="text" value="${companyInfoDtls.boardTime}" name="boardTime" id="boardTime" onkeyup="removeMess()" ><br/><span id="errboardTime"></span></td>
		</tr>
		<tr>
		<td>Agm Venue:</td>
		<td><input type="text" value="${companyInfoDtls.agmVenue}" name="agmVenue" id="agmVenue" onkeyup="removeMess()"><br/><span id="erragmVenue"></span></td>
		<td>Agm Time:</td>
		<td><input type="text" value="${companyInfoDtls.agmTime}" name="agmTime" id="agmTime" onkeyup="removeMess()"><br/><span id="erragmTime"></span></td>
		</tr>
		<tr>
		<td>Nature:</td>
		<td><input type="text" value="${companyInfoDtls.nature}" name="nature_sauditor" id="nature_sauditor" onkeyup="removeMess()"><br/><span id="errnature_sauditor"></span></td>
		<td>SdPeriod:</td>
		<td><input type="text" value="${companyInfoDtls.sdPeriod}" name="sdPeriod" onkeyup="removeMess()"> <br/><span id="errsdPeriod"></span><input type="hidden" name="companyId" value="${companyInfoDtlsTwo.companyId}"></td>
		</tr>
		<tr>
		<td>&nbsp;</td>
		<td align="right"><div align="right" id="updateTwo"><img src="views/images/update.jpg" alt="update" border="0" width="85" height="25" title="update"/></div>&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;<!-- <div align="right" id="deleteTwo"><img src="views/images/delete.jpg" alt="delete" border="0" width="85" height="25" title="delete"/></div> --></td>
		<td>&nbsp;</td>
		</tr>
		</table>
		</c:when>
		<c:otherwise>
		
		<div><font color="red">Agm Details Are Not Found </font> For Add <a href="leftPaneladdCompaniesDtls.html?userId=${userId}"> Add Agm Details</a></div>
		</c:otherwise>
		</c:choose>
		</form:form>
		</div>
		
		<div width="100%" class="sideheadtext" align="center">Information (BM and PostBM)</div>
		<div>
		<form:form commandName="companyinfoSecond" name="companyinfoSecond">
		<input type="hidden" name="cName" value="${companyName}">
		<c:choose>
		<c:when test="${companyInfoDtlsTwo.errorCode==1}">
	<table>
	<tr>
									<td>Dividend Proposed Paid</td>
									<td>
									<select id="dividend_proposed_paid" name="dividend_proposed_paid" onchange="removeMessSel()">
									<option value="sel">----Select----</option>
									 <c:choose>
									<c:when test="${companyInfoDtlsTwo.dividend_proposed_paid=='yes'}">
									<option  selected="selected" value="${companyInfoDtlsTwo.dividend_proposed_paid}">${companyInfoDtlsTwo.dividend_proposed_paid}</option>
									</c:when>
									<c:otherwise>
									<option value="yes">yes</option>
									</c:otherwise>
									</c:choose>
									<c:choose>
									<c:when test="${companyInfoDtlsTwo.dividend_proposed_paid=='no'}">
									<option  selected="selected" value="${companyInfoDtlsTwo.dividend_proposed_paid}">${companyInfoDtlsTwo.dividend_proposed_paid}</option>
									</c:when>
									<c:otherwise>
									<option value="no">NO</option>
									</c:otherwise>
									</c:choose></select>
									<br/><span id="errdividend_proposed_paid"></span></td>
									<td>Dividend Proposed Paid</td>
									<td><input type="text" maxlength=3 size=3 class="number" value="${companyInfoDtlsTwo.yes_dividend_proposed_paid}" name="yes_dividend_proposed_paid" id="yes_dividend_proposed_paid" onkeyup="removeMess()"><br/><span id="erryes_dividend_proposed_paid"></span></td>
									</tr>
									<tr>
									<td>Dividend Paid Out off</td>
									<td>
									<select id="dividend_paid_out" name="dividend_paid_out" onchange="removeMessSel()">
									<option value="sel">----Select----</option>
									<c:choose>
									<c:when test="${companyInfoDtlsTwo.dividend_paid_out=='current year profits'}">
									<option  selected="selected" value="${companyInfoDtlsTwo.dividend_paid_out}">${companyInfoDtlsTwo.dividend_paid_out}</option>
									</c:when>
									<c:otherwise>
									<option value="current year profits">Current year profits</option>
									</c:otherwise>
									</c:choose>
									<c:choose>
									<c:when test="${companyInfoDtlsTwo.dividend_paid_out=='previous year profits'}">
									<option  selected="selected" value="${companyInfoDtlsTwo.dividend_paid_out}">${companyInfoDtlsTwo.dividend_paid_out}</option>
									</c:when>
									<c:otherwise>
									<option value="previous year profits">previous year profits</option>
									</c:otherwise>
									</c:choose>
									<c:choose>
									 <c:when test="${companyInfoDtlsTwo.dividend_paid_out=='current year and previous year profits'}">
									<option  selected="selected" value="${companyInfoDtlsTwo.dividend_paid_out}">${companyInfoDtlsTwo.dividend_paid_out}</option>
									</c:when>
									<c:otherwise>
									<option value="current year and previous year profits">current year and previous year profits</option>
									</c:otherwise>
									</c:choose>
									</select>
									<br/><span id="errdividend_paid_out"></span></td>
									<td>No Fully Paid</td>
									<td><input type="text" class="number" maxlength="3" size="3" value="${companyInfoDtlsTwo.no_fully_paid}" name="no_fully_paid" id="no_fully_paid" onkeyup="removeMess()"><br/><span id="errno_fully_paid"></span></td>
									</tr>
									<tr>
									<td>Face Value</td>
									<td><input type="text" class="number" maxlength="3" size="3" value="${companyInfoDtlsTwo.face_value_Eshare}" name="face_value_Eshare" id="face_value_Eshare" onkeyup="removeMess()"><br/><span id="errface_value_Eshare"></span></td>
									<td>Record Date</td>
									<td><input type="text" size=10 value="${companyInfoDtlsTwo.record_date}" name="record_date" id="record_date" onkeyup="removeMess()"><br/><span id="errrecord_date"></span></td>
									</tr>
									<tr>
									<td>Dividend Amounts</td>
									<td><input type="text" value="${companyInfoDtlsTwo.dividend_amounts}" name="dividend_amounts" id="dividend_amounts" onkeyup="removeMess()"><br/><span id="errdividend_amounts"></span></td>
									<td>Bank Account</td>
									<td><input type="text" value="${companyInfoDtlsTwo.bank_account}" name="bank_account" id="bank_account" onkeyup="removeMess()"><br/><span id="errbank_account"></span></td>
									</tr>
									<tr>
									<td>Audit Required</td>
									<td><input type="text" value="${companyInfoDtlsTwo.audit_required}" name="audit_required"></td>
									<td>Secretarial Auditor</td>
									<td><input type="text" value="${companyInfoDtlsTwo.secretarial_auditors}" name="secretarial_auditors" id="secretarial_auditors" onkeyup="removeMess()"><br/><span id="errsecretarial_auditors"></span></td>
									</tr>
									<tr>
									<td>Audit ReporterName</td>
									<td><input type="text" value="${companyInfoDtlsTwo.audit_reporterName}" name="audit_reporterName" id="audit_reporterName" onkeyup="removeMess()"><br/><span id="erraudit_reporterName"></span></td>
									<td>FirmRegNo</td>
									<td><input type="text" value="${companyInfoDtlsTwo.firmRegNo}" name="firmRegNo" id="firmRegNo" onkeyup="removeMess()"><br/><span id="errfirmRegNo"></span></td>
									</tr>
									<tr>
									<td>Audit Name</td>
									<td><input type="text" value="${companyInfoDtlsTwo.audit_name}" name="audit_name" id="audit_name" onkeyup="removeMess()"><br/><span id="erraudit_name"></span></td>
									<td>Audit Email</td>
									<td><input type="text" value="${companyInfoDtlsTwo.firmRegNo}" name="audit_email"><input type="hidden" name="companyId" value="${companyInfoDtlsTwo.companyId}"></td>
									</tr>
									
									<tr>
									<td>&nbsp;</td>
		<td align="right"><div align="right" id="updateThree"><img src="views/images/update.jpg" alt="update" border="0" width="85" height="25" title="update"/></div>&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;<!-- <div align="right" id="deleteThree"><img src="views/images/delete.jpg" alt="delete" border="0" width="85" height="25" title="delete"/></div> --></td>
		<td>&nbsp;</td>
		</tr>
	</table>
	</c:when>
	<c:otherwise>
	<%-- <c:if test="${companyInfoDtlsTwo.errorCode==0}"> --%>
		<div><font color="red">No Director Are Found </font> for Add Directors <a href="leftAddComponyInfoDtls.html?userId=${userId}">Add Company Bm Post  Details</a></div>
		</c:otherwise>
		</c:choose>
	</form:form>
	
			</div>
	</body>
</html>
