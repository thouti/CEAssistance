<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/register.js"></script>
		<script language="javascript">
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
			else if(mode=="newdirect")
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
				document.getElementById("nod").innerHTML = rowCount;
			else if(mode=="adddirect")
				document.getElementById("adno").innerHTML = rowCount;
			else
				document.getElementById("newno").innerHTML = rowCount;
		}
	</script>
	</head>
	<body onload="">
		<div class="wrapper">
			<jsp:include page="header.jsp" />
			<div class="main_content">
				<div class="left">
					<div class="glossymenu">
						<div class="submenu">
							<ul>
								<li><a href="retriveUserDetails.html?userId=<%=session.getAttribute("userId").toString()%>" style="text-decoration:none" >View Profile</a></li>
								<li><a href="#" style="text-decoration:none" >Company Status</a></li>
								<li><a href="userAgmdate.html" style="text-decoration:none">Add Companies</a></li>
								<li><a href="#" style="text-decoration:none">Add Information </a></li>
								<li><a href="leftAddComponyInfoDtls.html?userId=${userId}" style="text-decoration:none">Add Information more</a></li>
								<li><a href="viewCalendar.html?userId=${userId}" style="text-decoration:none">View Calendar and customize</a></li>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">Download Check lists </a></li>
							</ul>
						</div>
					</div>
				</div> 
				<div class="right">
					<div style="background-color:#F8F8F8;overflow:auto;">
						<div align= "left" class="font-head" width="80%"> Add Information </div><br/>
						<div align= "left" class="font-head" width="80%"> Select company <select id="company_list"><option value="Select Company Name">----Select Company Name----</option></select> </div>
						<div align= "center" class="font-head" width="80%">
							<table height="20%" width="100%" align="center">
								<tr><td class="font-head" colspan="4" align="center">Board Meeting</td></tr>
								<tr class="font-head_tr"><td width="50%" align="center"><b>venue:</b> <input type="text" id="brd_met_ven" size="20"/></td> <td width="50%"  align="center"><b>Time:</b> <input type="text" id="brd_met_tim" size="20"/></td></tr>
								<tr><th></th></tr>
								<tr><th></th></tr>
								<tr><th></th></tr><tr><th></th></tr><tr><th></th></tr>
								<tr><td class="font-head" colspan="4" align="center">Annual General Meeting</td></tr>
								<tr class="font-head_tr"><td width="50%"  align="center"><b>venue:</b> <input type="text" id="agm_met_ven" size="20"/></td> <td width="50%"  align="center"><b>Time:</b><input type="text" id="agm_met_tim" size="20"/></td></tr>
							</table> 
						</div><br/>
						<div height="20%" width="100%" align="left">
							<div class="font-head" colspan="4" align="center">Board of Directors</div>
							<div class="font-head_tr">Number of Directors on board: <span id="nod">1</span></div><br/>
							<div class="font-head">Details of directors
							<span class="font-head" style="padding-left:695px;"><a href="#" class="myButton" onclick="addRow('addDirTab','direct')">add</a></span></div>
						</div>
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
										<td><input type="text" id="d_dirname_1" value=""></input></td>
										<td><input type="text" id="d_gender_1" value="" size="4"></input></td>
										<td><input type="text" id="d_din_1" name="compname_1" size="10"></input></td>
										<td><input type="text" id="d_desig_1" value=""></input></td>
										<td><input type="text" id="d_addr_1" value=""></input></td>
										<td><input type="text" id="d_mail_1" value=""  size="20"></input></td>
									</tr>
								</table>
							</div><br/>
							<!-- <div align="right" id="proceeddirbut" class="font-head"><a href="#" class="myButton" onclick="addRow('addDirTab','direct')">Proceed</a></div><br/> -->
						</div>
						<div width="100%" align="left" class="font-head">Directors retiring by rotation at the ensuing Annual General Meeting:</div>
						<div width="100%" align="center" class="font-head_tr"><select id="" multiple size="3"><option value="">-------Select Director(s)-------</option><option value="">Director1</option><option value="">Director2</option><option value="">Director3</option></select></div> 
						<div height="20%" width="100%" align="left">
							<div class="font-head_tr">Number of Additional Directors in the board: <span id="adno">1</span></div><br/>
							<div class="font-head">Details of Additional Directors<span class="font-head" style="padding-left:625px;"><a href="#" class="myButton" onclick="addRow('additDirTab','adddirect')">add</a></span></div></div>
							<!-- <div class="font-head" align="right"><input type="button" value="Add Dircetor" onclick="addRow('additDirTab','adddirect')"/></div> -->
						</div>
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
										<td><input type="text" id="a_dirname_1" value=""></input></td>
										<td><input type="text" id="a_gender_1" value="" size="4"></input></td>
										<td><input type="text" id="a_din_1" name="compname_1" size="10"></input></td>
										<td><input type="text" id="a_desig_1" value=""></input></td>
										<td><input type="text" id="a_addr_1" value=""></input></td>
										<td><input type="text" id="a_mail_1" value="" size="20"></input></td>
									</tr>
								</table>
							</div><br/>
							<!-- <div align="right"><img src="views/images/proceed1.jpg" alt="proceed" border="0" width="125" height="25"/></div><br/> -->
						</div>
						<div height="20%" width="100%" align="left">
							<div class="font-head_tr">Number of New Directors Proposed to be appointmented: <span id="newno">1</span></div><br/>
							<div class="font-head">Details of Proposed new Directors<span class="font-head" style="padding-left:605px;"><a href="#" class="myButton" onclick="addRow('newDirTab','newdirect')">add</a></span></div>
							<!-- <div class="font-head" align="right"><input type="button" value="Add Dircetor" onclick="addRow('newDirTab','newdirect')"/></div> -->
						</div>
						<div id="dispdirId" style="background-color:#F8F8F8;" height="90%">
							<div style="background-color:#F8F8F8;padding:3px;" height="95%">
								<table width="100%" class="tabcss_main" id="newDirTab">
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
										<td><input type="text" id="n_dirname_1" value=""></input></td>
										<td><input type="text" id="n_gender_1" value="" size="6"></input></td>
										<td><input type="text" id="n_din_1" name="compname_1" size="10"></input></td>
										<td><input type="text" id="n_desig_1" value=""></input></td>
										<td><input type="text" id="n_addr_1" value=""></input></td>
										<td><input type="text" id="n_mail_1" value="" size="20"></input></td>
									</tr>
								</table>
							</div><br/>
							
						</div>
						<div>
							<div class="font-head" align="center">Statutory Directors</div>
							<table width="52%" style="border:1;" class="tabcss_main" id="newDirTab" align="center">
								<tr>
									<th>Nature</th>
									<th>Period</th>
								</tr>
								<tr><td  align="left"><select id="appt" onchange="dispduration()"><option value="appointment">Appointment</option>
														 <option value="reappointment">Reappointment</option> <option value="ratification">Ratification of Appointment (Existing Auditors)</option></select></td>
									<td><input type="textbox" size="10" id="appt_period"></td></tr>
								
								<tr><td align="left">Nature of Statutory Auditor</td><td>  <select id="nature_sauditor"><option value="firm">-----select-----</option><option value="firm">Firm</option>
														 <option value="individual">Individual</option></select></td></tr>
							</table>							
						</div>
						<div height="20%" width="100%" align="left">
							<div class="font-head">Details of Statutory Auditors <span id="statno" style="display:none;">1 </span><span class="font-head" style="padding-left:675px;"><a href="#" class="myButton" onclick="addRow('stTab','staud')">Add </a></span></div>
						</div>
						<div id="statId" style="background-color:#F8F8F8;" height="90%">
							<div style="background-color:#F8F8F8;padding:3px;" height="95%">
								<table width="100%" class="tabcss_main" id="stTab">
									<tr>
										<th>Sr.No</th>
										<th>Name</th>
										<th>Registration Number</th>
										<th>E-mail Id</th>
										<th>Type of Auditor</th>
									</tr>
									<tr>
										<td id="srno_1">1.</td>
										<td><input type="text" id="st_audname_1"></input></td>
										<td><input type="text" id="st_audregnum_1"></input></td>
										<td><input type="text" id="st_audmail_1"></input></td>
										<td><input type="text" id="st_audtype_1"></input></td>
									</tr>
								</table>
							</div><br/>
							
						</div>
						<div class="font-head">Company Secretry Details</div>
						<div class="tabcss_main" align="left">Whether the company has whole time company secretry <input type="radio" name="secretry" onClick="showsecDiv('yes')"> Yes <input type="radio" name="secretry" onClick="showsecDiv('No')"> No</div>
						<div id="secretryinfo_div" style="display:none;">
							<div class="font-head">Provide the details of Whole Time Company Secretary</div>
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
									<td><input type="text" id="secnam"></input></td>
									<td><input type="text" id="secmemno"></input></td>
									<td><input type="text" id="secpan"></input></td>
									<td><input type="text" id="secmail"></input></td>
								</tr>
							</table>
						</div><br/>
						<div align="right"><img src="views/images/proceed1.jpg" alt="proceed" border="0" width="125" height="25"/></div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
