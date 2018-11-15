<%@include file="./taglib_includes.jsp" %>
<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/addCompanieInfo.js"></script>
		<script type="text/javascript">
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
			function mailChk(obj,div){
				var mailReg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
				if(!mailReg.test(obj.value)) {
					displayalertmsginfone("Please give valid E-mail Id ",div);
					document.getElementById(obj.id).focus();
					return false;
				}
				else
					displayalertmsginfone("",div);
	    	}
			function txtChk(obj,div){
				var str =/[0-9]/;
				if(str.test(obj.value)){
					displayalertmsginfone("Please provide information with alphabates",div);
					document.getElementById(obj.id).focus();
				}
				else
					displayalertmsginfone("",div);
			}
			function numChk(obj,div){
				var str =/[A-Za-z]/;
				if(str.test(obj.value)){
					displayalertmsginfone("Please provide inormation with numeric",div);
					document.getElementById(obj.id).focus();return false;
				}
				else
					displayalertmsginfone("",div);
			}
			function displayalertmsginfone(msg,div){
				if($( "#"+div ).length>0)
					$( "#"+div ).html(msg);
			}
			function dispduration(){
				var selval = document.getElementById("appt").value;
				if(selval=="ratification"){ 
					document.getElementById("appt_period").readOnly = true;
					document.getElementById("appt_period").value = "";
				}
				else
					document.getElementById("appt_period").readOnly = false;
			}
			function showsecDiv(type){
				if(type=="yes") 
					document.getElementById("secretryinfo_div").style.display="inline";
				else
					document.getElementById("secretryinfo_div").style.display="none";
			}
			function addRow(tableID,mode){
				var eleArr;
				if(mode=="direct")
					eleArr = ['','d_dirname_','d_gender_','d_din_','d_desig_','d_addr_','d_mail_'];
				else if(mode=="adddirect")
					eleArr = ['','a_dirname_','a_gender_','a_din_','a_desig_','a_addr_','a_mail_'];
				else if(mode=="newProDirTab")
					eleArr = ['','n_dirname_','n_gender_','n_din_','n_desig_','n_addr_','n_mail_'];
				else
					eleArr = ['','st_audname_','st_audregnum_','st_audmail_','st_audtype_'];
				var table=document.getElementById(tableID);
				var rowCount=table.rows.length;
				var row=table.insertRow(rowCount);//console.log(rowCount);
				var colCount=table.rows[0].cells.length;
				for(var i=0;i<colCount;i++){
					var newcell=row.insertCell(i);
					newcell.innerHTML=table.rows[1].cells[i].innerHTML;
					newcell.childNodes[0].id = eleArr[i]+rowCount;
					switch(newcell.childNodes[0].type){
						case"text":newcell.childNodes[0].value="";break;
						case"checkbox":newcell.childNodes[0].checked=false;break;
						case"select-one":newcell.childNodes[0].selectedIndex=0;break;
					}
					table.rows[rowCount].cells[0].innerHTML = rowCount+".";
				}
				if(rowCount%2==0)
					document.getElementById(tableID).rows[rowCount].style.fontWeight="bold";
				if(mode=="direct")
					{
					document.getElementById("nod").innerHTML = rowCount;
				document.getElementById("nodCnt").value = rowCount;}
				else if(mode=="adddirect")
					{
					document.getElementById("adno").innerHTML = rowCount;
					document.getElementById("adnoCnt").value = rowCount;}
				else if(mode=="newProDirTab")
				{
					document.getElementById("newno").innerHTML = rowCount;
					document.getElementById("newnoCnt").value = rowCount;
				}
				/* else{
					document.getElementById("statno").innerHTML = rowCount;
					document.getElementById("statnoCnt").value = rowCount;
				} */
					
			}
			
			function autoRetirDir(obj){
				var str =/[0-9]/;
				if(str.test(obj.value)){
					displayalertmsginfone("Please give valid company name","dir_errdiv");
					document.getElementById(obj.id).focus();return false;
				}
				else{
					displayalertmsginfone("","dir_errdiv");
					var rcnt = document.getElementById('addDirTab').rows.length;
					var appData = "<select multiple size='3' name='retiredDirectors'><option value=''>-------Select Director(s)-------</option>";
					var val ="", id="";
					for(var i=1;i<rcnt+1;i++){
						id="d_dirname_"+i;
						if(document.getElementById(id) != null){
							val = document.getElementById(id).value;
							appData += "<option value="+val+">"+val+"</option>";
						}
					}
					document.getElementById("retirDirDiv").innerHTML = appData;
					document.getElementById("retiredDirectors").value = appData;
					
				}
			}
			function removeMess()
			{
				if(document.getElementById("st_audname_1").value!="")
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audname_1").length>4)
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audregnum_1").value!="")
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audregnum_1").length>4)
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audname_2").value!="")
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audname_2").length>4)
				{
				$('#stat_aud_errdiv').html("");
				}
				
				if(document.getElementById("st_audregnum_2").value!="")
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audregnum_2").length>4)
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audmail_1").length>4)
				{
				$('#stat_aud_errdiv').html("");
				}
				if(document.getElementById("st_audmail_2").length>4)
				{
				$('#stat_aud_errdiv').html("");
				}
				
				}
			
			</script>
			<script type="text/javascript">
			$(document).ready(function(){ 
			$("#brd_met_tim").keydown(function(event) {
			    if (event.keyCode == 32) {
			        event.preventDefault();
			    }
			});
			$("#agm_met_tim").keydown(function(event) {
			    if (event.keyCode == 32) {
			        event.preventDefault();
			    }
			});
			});
			$(document).ready(function(){
				$('.rmove').click(function() {
								       if($("#addDirTab tr").length != 2)
								         {
								            $("#addDirTab tr:last-child").remove();
								         }
								      else
								         {
								            alert("You cannot delete first row");
								         }
								    });	
				$('.AddDirrmove').click(function() {
				       if($("#additDirTab tr").length != 2)
				         {
				            $("#additDirTab tr:last-child").remove();
				         }
				      else
				         {
				            alert("You cannot delete first row");
				         }
				    });	
				$('.proposedDirrmove').click(function() {
				       if($("#newProDirTab tr").length != 2)
				         {
				            $("#newProDirTab tr:last-child").remove();
				         }
				      else
				         {
				            alert("You cannot delete first row");
				         }
				    });	
				
				});
			</script>
	</head>
	<body>
	<form:form name="addcompany" commandName="addComInfo">
	<div><font color="red"><strong>${error}</strong></font></div>
	<div class="wrapper" id="addcompanyinfodiv">
		<div class="main_content">
<%-- 			<jsp:include page="header.jsp" /> --%>
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
					<div style="background-color:#F8F8F8;">
						<div align= "center" class="font-head" width="80%"> Add Information </div><br/>
						<div align="center" class="font-head" width="80%"> Select company 
						<select id="company_list" name="company_list">
						<option value="sel">----Select Company Name----</option>
						<c:forEach var="comList" items="${commonVo}">
						<option value="${comList.companyName}-${comList.companyId}">${comList.companyName}</option>
						</c:forEach>
						</select>&nbsp;&nbsp;<span id="error"></span></div>
						<div id="main">
						<div id="venue_errdiv" class="errortext"></div>
						<div align= "center" class="font-head" width="80%">
							<table height="20%" width="100%" align="center">
								<tr><td class="font-head" colspan="4"><div width="100%" class="sideheadtext" align="left">Board Meeting</div><br/></td></tr>
								<tr class="font-head_tr"><td width="50%" align="center"><b>venue:</b> <input type="text" id="brd_met_ven" size="20" name="boardVenue"/></td> <td width="50%"  align="center"><b>Time:</b> <input type="text" id="brd_met_tim" size="8" name="boardTime" onblur="chkTimeformat(this,'venue_errdiv');"/>&nbsp;&nbsp;&nbsp;<font size="1">(<b>Note</b>: Time should be in 24 hrs and HH:MM format.)</font></td></tr>
								<tr><th></th></tr>
								<tr><th></th></tr>
								<tr><th></th></tr><tr><th></th></tr><tr><th></th></tr>
								<tr><td class="font-head" colspan="4"><div width="100%" class="sideheadtext" align="left">Annual General Meeting</div><br/></td></tr>
								<tr class="font-head_tr"><td width="50%"  align="center"><b>venue:</b> <input type="text" id="agm_met_ven" size="20" name="agmVenue"/></td> <td width="50%"  align="center"><b>Time:</b> <input type="text" id="agm_met_tim" size="8" name="agmTime" onblur="chkTimeformat(this,'venue_errdiv');"/>&nbsp;&nbsp;&nbsp;<font size="1">(<b>Note</b>: Time should be in 24 hrs and HH:MM format.)</font></td></tr>
							</table> 
						</div><br/>
						<div height="20%" width="100%" align="left">
							<div width="100%" class="sideheadtext" align="left">Board of Directors</div><br/>
							<div class="font-head_tr">Number of Directors on board: <span id="nod">1</span><input type="hidden" id="nodCnt" value="1"></div><br/>
							<div class="font-head">Details of directors
							<span class="font-head" style="padding-left:82%;"><a href="#" class="myButton" onclick="addRow('addDirTab','direct')">add</a>&nbsp;&nbsp;<input type="button" value="Remove" class="rmove" /></span></div>
						</div>
						<div id="dir_errdiv" class="errortext"></div>
						<div id="dispdirId" style="background-color:#F8F8F8;" height="90%">
							<div style="background-color:#F8F8F8;padding:3px;" height="95%">
								<table width="100%" class="tabcss_main" id="addDirTab">
									<tr>
										<th>Sr.No</th>
										<th>Director Name</th>
										<th>Gender</th>
										<th>DIN</th>
										<th>Designation</th>
										<th>Address</th>
										<th>E-mail Id</th>
									</tr>
									<tr>
										<td id="srno_1">1.</td>
										<td><input type="text" id="d_dirname_1" value="" onblur="autoRetirDir(this);"></input></td>
										<td><select id="d_gender_1" name="d_gender_1"><option value="">-----select-----</option><option value="male">Male</option>
														 <option value="female">Female</option></select></td>
										<td><input type="text" id="d_din_1" name="compname_1" size="10"  maxlength="10" onblur="numChk(this,'dir_errdiv')"></input></td>
										<td><input type="text" id="d_desig_1" value=""></input></td>
										<td><input type="text" id="d_addr_1" value=""></input></td>
										<td><input type="text" id="d_mail_1" value=""  size="20" onblur="mailChk(this,'dir_errdiv')"></input></td>
									</tr>
								</table>
							</div><br/>
							<!-- <div align="right" id="proceeddirbut" class="font-head"><a href="#" class="myButton" onclick="addRow('addDirTab','direct')">Proceed</a></div><br/> -->
						</div>
						<div id="retire_dir_errdiv" class="errortext"></div>
						<div width="100%" align="left" class="font-head">Directors retiring by rotation at the ensuing Annual General Meeting:</div>
						<div width="100%" align="center" class="font-head_tr" id="retirDirDiv"><select multiple size="3" name="retiredDirectors" id="retiredDirectors"><option value="">-------Select Director(s)-------</option></select></div> 
						<div height="20%" width="100%" align="left">
							<div class="font-head_tr">Number of Additional Directors in the board: <span id="adno">1</span><input type="hidden" id="adnoCnt" value="1"></div><br/>
							<div class="font-head"><span>Details of Additional Directors</span><span class="font-head" style="padding-left:65%;"><a href="#" class="myButton" onclick="addRow('additDirTab','adddirect')">add</a>&nbsp;<input type="button" value="Remove" class="AddDirrmove" /></span></div>
							<!-- <div class="font-head" align="right"><input type="button" value="Add Dircetor" onclick="addRow('additDirTab','adddirect')"/></div> -->
						</div>
						<div id="add_dir_errdiv" class="errortext"></div>
						<div id="dispdirId" style="background-color:#F8F8F8;" height="90%">
							<div style="background-color:#F8F8F8;padding:3px;" height="95%">
								<table width="100%" class="tabcss_main" id="additDirTab">
									<tr>
										<th>Sr.No</th>
										<th>Director Name</th>
										<th>Gender</th>
										<th>DIN</th>
										<th>Designation</th>
										<th>Address</th>
										<th>E-mail Id</th>
									</tr>
									<tr>
										<td id="srno_1">1.</td>
										<td><input type="text" id="a_dirname_1" value="" onblur="txtChk(this,'add_dir_errdiv')"></input></td>
										<td><!--input type="text" id="a_gender_1" value="" size="4" onblur="txtChk(this)"></input-->
										<select id="a_gender_1" name="a_gender_1"><option value="">-----select-----</option><option value="male">Male</option>
														 <option value="female">Female</option></select></td>
										<td><input type="text" id="a_din_1" name="compname_1" size="10" maxlength="10" onblur="numChk(this,'add_dir_errdiv')"></input></td>
										<td><input type="text" id="a_desig_1" value=""></input></td>
										<td><input type="text" id="a_addr_1" value=""></input></td>
										<td><input type="text" id="a_mail_1" value="" size="20" onblur="mailChk(this,'add_dir_errdiv')"></input></td>
									</tr>
								</table>
							</div><br/>
							<!-- <div align="right"><img src="views/images/proceed1.jpg" alt="proceed" border="0" width="125" height="25"/></div><br/> -->
						</div>
						
						<div height="20%" width="100%" align="left">
							<div class="font-head_tr">Number of New Directors Proposed to be appointmented: <span id="newno">1</span><input type="hidden" id="newnoCnt" value="1"></div><br/>
							<div class="font-head">Details of Proposed new Directors<span class="font-head" style="padding-left:40%"><a href="#" class="myButton" onclick="addRow('newProDirTab','newdirect')">add</a>&nbsp;&nbsp;<input type="button" value="Remove" class="proposedDirrmove" /></span></div>
							<!-- <div class="font-head" align="right"><input type="button" value="Add Dircetor" onclick="addRow('newDirTab','newdirect')"/></div> -->
						</div>
						<div id="new_dir_errdiv" class="errortext"></div>
						<div id="dispdirId" style="background-color:#F8F8F8;" height="90%">
							<div style="background-color:#F8F8F8;padding:3px;" height="95%">
								<table width="100%" class="tabcss_main" id="newProDirTab">
									<tr>
										<th>Sr.No</th>
										<th>Director Name</th>
										<th>Gender</th>
										<th>DIN</th>
										<th>Designation</th>
										<th>Address</th>
										<th>E-mail Id</th>
									</tr>
									<tr>
										<td id="srno_1">1.</td>
										<td><input type="text" id="n_dirname_1" value=""  onblur="txtChk(this,'new_dir_errdiv')"></input></td>
										<td><!--input type="text" id="n_gender_1" value="" size="6" onblur="txtChk(this)"></input--><select id="n_gender_1" name="n_gender_1"><option value="">-----select-----</option><option value="male">Male</option>
														 <option value="female">Female</option></select></td>
										<td><input type="text" id="n_din_1" name="compname_1" size="10" maxlength="10" onblur="numChk(this,'new_dir_errdiv')"></input></td>
										<td><input type="text" id="n_desig_1" value=""></input></td>
										<td><input type="text" id="n_addr_1" value=""></input></td>
										<td><input type="text" id="n_mail_1" value="" size="20" onblur="mailChk(this,'new_dir_errdiv')"></input></td>
									</tr>
								</table>
							</div><br/>
							
						</div>
						<div id="stat_dir_errdiv" class="errortext"></div>
						<div>
							<div width="100%" class="sideheadtext" align="left">Statutory Auditors</div><br/>
							<div width="100%" align="left" class="font-head_tr">1.Select period and type of appointment of Statutory Auditors in the ensuing Annual General Meeting:</div><br/>
							<table width="52%" style="border:1;" class="tabcss_main" id="newDirTab" align="center">
								<tr>
									<th>Nature</th>
									<th>Period</th>
								</tr>
								<tr><td  align="left">
									<select id="appt" name="appt" onchange="dispduration()">
										<option value="appointment">Appointment</option>
								 		<option value="reappointment">Reappointment</option>
								  		<option value="ratification">Ratification of Appointment (Existing Auditors)</option>
								  	</select></td>
									<td><input type="textbox" size="10" id="appt_period" name="period"></td></tr>
							</table>
							<br/><div width="100%" align="left" class="font-head_tr">2. Select the type of Statutory Auditor<span style="margin-left:35px;"><select id="nature_sauditor" name="nature_sauditor"><option value="">-----select-----</option><option value="firm">Firm</option>
														 <option value="individual">Individual</option></select></span></div>							
						</div>
						<div height="20%" width="100%" align="left">
							<div class="font-head">Details of Statutory Auditors <span id="statno"></span><!-- span class="font-head" style="padding-left:75%;"><a href="#" class="myButton" onclick="addRow('stTab','staud')">Add </a></span--></div>
						</div>
						<div id="stat_aud_errdiv" class="errortext"></div>
						<div id="statId" style="background-color:#F8F8F8;" height="90%">
							<div style="background-color:#F8F8F8;padding:3px;" height="95%">
								<table width="100%" class="tabcss_main" >
									<tr>
										<th>Sr.No</th>
										<th>Name</th>
										<th>Registration Number</th>
										<th>E-mail Id</th>
										<th>Type of Auditor</th>
									</tr>
									<tr>
										<td id="srno_1">1.</td>
										<td><input type="text" id="st_audname_1"  name="st_audname_1" onkeyup="removeMess()"></input></td>
										<td><input type="text" id="st_audregnum_1" name="st_audregnum_1" onkeyup="removeMess()"></input></td>
										<td><input type="text" id="st_audmail_1"  name="st_audmail_1" onkeyup="removeMess()"></input></td>
										<td><input type="text" id="st_audtype_1"  name="st_audtype_1" value="Existing Auditor" readonly/></td>
									</tr>
									<tr id="reapp">
										<td id="srno_2">2.</td>
										<td><input type="text" id="st_audname_2" name="st_audname_2" onkeyup="removeMess()"></input></td>
										<td><input type="text" id="st_audregnum_2"  name="st_audregnum_2" onkeyup="removeMess()"></input></td>
										<td><input type="text" id="st_audmail_2" name="st_audmail_2" onkeyup="removeMess()"></input></td>
										<td><input type="text" id="st_audtype_2"  name="st_audtype_2" value="Proposed Auditor" readonly/></td>
									</tr>
								</table>
							</div><br/>
							
						</div>
						<div width="100%" class="sideheadtext" align="left">Company Secretry Details</div>
						<div class="tabcss_main" align="left">Whether the company has whole time company secretry <input type="radio" name="secretry" value="yes" onClick="showsecDiv('yes')"> Yes <input type="radio" name="secretry" value="No" onClick="showsecDiv('No')" checked> No</div>
						<div id="secretryinfo_div" style="display:none;">
							<div class="font-head">Provide the details of Whole Time Company Secretary</div>
							<div id="sec_errdiv" class="errortext"></div>
							<table width="100%" class="tabcss_main" id="newDirTab">
								<tr>
									<th>Sr.No</th>
									<th>Name</th>
									<th>MemberShip No</th>
									<th>PAN Number</th>
									<th>E-mail Id</th>
								</tr>
								<tr>
									<td id="srno_1">1.</td>
									<td><input type="text" id="secnam" name="secnam" onblur="txtChk(this,'sec_errdiv')"></input></td>
<!-- 									<td><input type="text" id="secmemno" name="secmemno" onblur="numChk(this,'sec_errdiv')"></input></td> -->
								<td><input type="text" id="secmemno" name="secmemno" ></input></td>
									<td><input type="text" id="secpan" name="secpan"></input></td>
									<td><input type="text" id="secmail" name="secmail"  onblur="mailChk(this,'sec_errdiv')"></input></td>
								</tr>
							</table>
						</div></div><br/>
						<div align="right"><img src="views/images/proceed1.jpg" id="addCompanyInfo" alt="proceed" border="0" width="125" height="25"/></div>
					</div>
				</div>
				</div>
						<input type="hidden" id="director" name="director">
            <input type="hidden" id="adddirector" name="adddirector">
             <input type="hidden" id="newdirector" name="newdirector">
            <!--  <input type="hidden" id="staAuditors" name="staAuditors"> -->
             
             <input type="hidden" name="hdName" value="${hdName}" >
              <input type="hidden" name="userId" value="${userId}" >
              <input type="hidden" name="hdComId" id="hdComId">
			</form:form>
		
	</body>
</html>
