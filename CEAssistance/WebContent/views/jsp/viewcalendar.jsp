<%@include file="./taglib_includes.jsp"%>
<html>
<head>
<link href="./views/css/style_css18.css" type="text/css"
	rel="stylesheet" />
<script src="./views/js/jquery-1.6.4.js"></script>
<!-- <script src="./views/js/jquery-ui.js"></script> -->
<script type="text/javascript" src="./views/js/viewCalander.js"></script>

<style>
.nonreqcel {
	background-color: #F0F0F0;
}

table,th,td {
	border: 1px solid #E6E0F8;
	border-collapse: collapse;
	/*background-color:#E6E6E6;*/
}

th,td {
	padding: 8px;
}

.hdfont {
	font-family: Arial, Verdana Helvetica, sans-serif;
	font-size: 14px;
	color: #000000;
}

.smfont {
	font-family: Arial, Verdana Helvetica, sans-serif;
	font-size: 12px;
	color: #000000;
}

.tdbgcolor {
	background-color: #0099ff;
	color: #F2F2F2;
	font-weight: bold;
}
</style>
<script language="javascript">
	function numvalidate(obj) {
		var str = /^[0-9]\d*$/;
		if (!str.test(obj.value) || $("#a7").val() == "")
			obj.value = "";
	}
</script>
<script type="text/javascript">
	/* function getDirName() {
		if ($("#directorsOne").val() != "sel") {
			//alert("in dir");
			var dirId = $("#directorsOne").val();
			document.getElementById("directorsOne12").value = dirId;
		} 
	} 
	 function getDirName1() {
	if ($("#AdddirectorsOne").val() != "sel1") {
			//alert("in adddir");
			var dirId = $("#AdddirectorsOne").val();
			document.getElementById("directorsOne12").value = dirId;
		} 
	}
	 
	function getDirName2() {
	if ($("#appointedDirector").val() != "sel2") {
		//alert("in propsed");
			var dirId = $("#appointedDirector").val();
			document.getElementById("directorsOne12").value = dirId;
		}
	}function getDirName3() {
		 if ($("#statutaryAudtor").val() != "sel3") {
			//alert("in stadir");
			var dirId = $("#statutaryAudtor").val();
			document.getElementById("directorsOne12").value = dirId;
		}
		 }
		 function getDirName4() {
	if ($("#noticeBoard").val() != "sel4") {
			//alert("in noticedir");
			var dirId = $("#noticeBoard").val();
			document.getElementById("directorsOne12").value = dirId;
			document.getElementById("hdstaType").value = "NBM";
		}
	}
		 function getDirName5() {
				if ($("#statutaryAudtor1").val() != "sel5") {
				//		alert("in statutaryAudtor1 2");
						var dirId = $("#statutaryAudtor1").val();
						document.getElementById("directorsOne12").value = dirId;
						document.getElementById("hdstaType").value = "NBM";
					}
				}
		 function getDirName6() {
				if ($("#sec139").val() != "sel1") {
						//alert("in sec139");
						var dirId = $("#sec139").val();
						document.getElementById("date").value = $("#hda8").val();
						document.getElementById("directorsOne12").value = dirId;
					} 
				}
	//Starts Here For Signatary drop down	 
	/* function getStatutaryDirName() {
		if ($("#directors").val() != "sel") {
			//alert("1==dir"+$("#directors").val());
			var dirId = $("#directors").val();
			//document.getElementById("date").value = $("#hda1").val();
			document.getElementById("statutaryDirec").value = dirId;
		}
	} */
	 /* function getStatutaryDirName1() { 
		if ($("#additinalDir").val() != "sel1") {
			//alert("2==adddir");
			//document.getElementById("date").value = $("#hda1").val();
			var dirId = $("#additinalDir").val();
			document.getElementById("statutaryDirec").value = dirId;
		}
	} 
	 
	function getStatutaryDirName2() {
		if ($("#newlyAppDir").val() != "sel2") {
			//alert("3==newdir");
			//document.getElementById("date").value = $("#hda1").val();
			var dirId = $("#newlyAppDir").val();
			document.getElementById("statutaryDirec").value = dirId;
		}
	}
	function getStatutaryDirName3() {
	
		if ($("#statutaryDir1").val() != "sel3") {
			//alert("4==stadir");
			//document.getElementById("date").value = $("#hda1").val();
			var dirId = $("#statutaryDir1").val();
			document.getElementById("statutaryDirec").value = dirId;
		}
	}
	function getStatutaryDirName4() {
		 if ($("#boardDir").val() != "sel") {
			//alert("5==boardDir");
			var dirId = $("#boardDir").val();
			//document.getElementById("date").value = $("#hda2").val();
			document.getElementById("statutaryDirec").value = dirId;
		}
	}
	function getStatutaryDirName5() {
		if ($("#statutaryDir2").val() != "sel") {
			//alert("1==dir"+$("#statutaryDir2").val());
			var dirId = $("#statutaryDir2").val();
			//document.getElementById("date").value = $("#hda1").val();
			document.getElementById("statutaryDirec").value = dirId;
		}
	}*/
</script>
</head>
<body onload="">
	<div class="wrapper">
		<jsp:include page="header.jsp" />
		<form:form name="viewCalander" commandName="viewCalander">
			<div class="main_content">

				<div class="calendarset">
					<div width="100%"
						style="font-family: Arial, Verdana Helvetica, sans-serif; color: #727272; font-weight: bold; padding: 8px;"
						align="left">
						<img src="views/images/schedul.png" alt="logo" border="0"
							width="18" height="18"> View Calendar
					</div>
					<div>
						<table width="100%" class="hdfont">
							<tr style="background-color: #0099ff; color: white;">
								<th width="8%">Schedule Date</th>
								<th width="7%">No.of days between 2 tasks</th>
								<th width="5%">No.of days</th>
								<th width="15%">Event perticulars</th>
								<th width="30%">Caution</th>
								<th width="10%">Signatory</th>
								<th width="20%">Mail Recipients</th>
								<th width="5%">Document Templates</th>
							</tr>
							<tr>
								<td class="tdbgcolor"></td>
								<td colspan="5" class="tdbgcolor"><b>Before BM Notice</b></td>
								<td colspan="2" class="tdbgcolor"><select id="sel1"
									name="companyName">
										<option value="sel">------------Please Select Company
											Name------------</option>
										<c:forEach var="comList" items="${commonVo}">
											<option value="${comList.companyName}-${comList.companyId}">${comList.companyName}</option>
										</c:forEach>
								</select><span id="errcname"></span></td>
							</tr>
							<tr>
								<td readonly id="a1" name="a1" rowspan=5 readonly>mm-dd-yy</td>
								<input type="hidden" id="hda1" name="hda1" />
								<input type="hidden" name="dirType" value="director" />
								<td rowspan=5><input type="text" id="b1"
									onchange="setcalendardates(1);" onkeyup="numvalidate(this);"
									size=2 value="5" maxlength=3></td>
								<td readonly rowspan=5 id="c1" readonly>35</td>
								<td>Letter addressing to <strong><span
										id="dirNames"></span></strong>directors who retire by rotation, seeking
									consent to continue as Directors of the Company.
								</td>
								<td>Alongwith Consent letter, DIR 8 shall be obtained from
									such directors.</td>
								<td><select id="directors" name="directors"	onchange="getStatutaryDirName()">
								</select><span id="errdirectors"></span></td>
								<td id="dirEmail"><input type="hidden" id="hddirEmail"	name="hddirEmail"></td>
								<td><select id="directorsOne" name="directorsOne"
									onchange="getDirName()"></select><a href="#" class="myButton"
									id="downloadDoc" onclick="">Download</a><span id="errdirectorsOne"></span></td>
							</tr>
							
							<tr >
								<td id="hdaddDir">Letter addressing to<strong> <span
										id="aditionalDir"></span></strong>Additional Directors seeking consent
									for appointment as Directors of the Company.
								</td>
								<td id="hdaddDir4">Alongwith Consent letter, DIR 8, Proposal for
									appointment and Deposit of Rs.1,00,000 (Rupees One Lakh) shall
									be obtained from such directors.</td>
								<td id="hdaddDir1"><select id="additinalDir" name="additinalDir"
									onchange="getStatutaryDirName1()"><option value=""></option></select><span id="erradditinalDir"></span></td>
								<td id="adddirEmail" class="hdaddDir2"><input type="hidden"
									id="hdadddirEmail" name="hdadddirEmail"></td>
								<td id="hdaddDir3"><select id="AdddirectorsOne" name="AdddirectorsOne"
									onchange="getDirName1()"><option value=""></option></select><a href="#" class="myButton"
									id="downloadDoc1" onclick="">Download</a><span id="errAdddirectorsOne"></span></td>
							</tr>
							
							<tr>
								<td id="hdSeekingApp">Letter addressing to<strong><span
										id="newDirector"></span> </strong>seeking consent for appointment as
									Directors of the Company.
								</td>
								<td id="hdSeekingApp1">Alongwith Consent letter, DIR 8, Proposal for
									appointment and Deposit of Rs.1,00,000 (Rupees One Lakh) shall
									be obtained from such directors.</td>
								<td id="hdSeekingApp2"><select id="newlyAppDir" name="newlyAppDir"
									onchange="getStatutaryDirName2()"><option value="">-----Select-----</option></select><span id="errnewlyAppDir"></span></td>
								<td id="hdSeekingApp3"><input type="hidden" id="hdnewdirEmail"
									name="hdnewdirEmail"></td>
								<td id="hdSeekingApp4"> <select id="appointedDirector"
									name="appointedDirector" onchange="getDirName2()"><option value="">-----Select-----</option></select><a
									href="#" class="myButton" id="downloadDoc2" onclick="">Download</a><span id="errappointedDirector"></span></td>
							</tr>
							<tr>
								<td id="hdnature">Letter addressing to <strong><span
										id="statutaryDir"></span></strong>seeking the consent, experience and
									certificate of eligibility to getting appointed as Statutory
									Auditors of the Company.
								</td>
								<td class="smfont" id="hdnature1">If the Company has Audit Committee as
									per the provisions of Companies Act, 2013, then Committee has
									to consider the qualifications, experience, order / pending
									proceeding relating to professional matters by ICAI, Competent
									Auithority or Court. On considering the same, Audit Committee
									shall recommend the consideration of Statutory Auditor to the
									Board. If the Company doesnot have Audit Committee, the Board
									shall consider the above points at their meeting.</td>
								<td id="hdnature2"><select id="statutaryDir1" name="statutaryDir"
									onchange="getStatutaryDirName3()"><option value="">--Select--</option></select><span id="errstatutaryDir"></span></td>
								<td id="stadirEmail" class="hdnature3"></td>
								<td id="hdnature4"><select id=statutaryAudtor name="noticeBoard"
									onchange="getDirName3()"><option value="">--Select--</option></select><a href="#" class="myButton"
									id="downloadDoc3" onclick="">Download</a><span id="errstatutaryAudtor"></span></td>
							</tr>
							  <tr>
								<td id="hdreappt">Letter addressing to <strong><span
										id="statutaryReAppDir"></span></strong>shall be sent to seek the consent, experience and certificate of  eligibility to get re- appointed as Statutory Auditors of the Company.</td>
								<td class="smfont" id="hdreappt1">If the Company has Audit Committee as per the provisions of Companies Act, 2013, then 
								                   Committee has to consider the qualifications, experience, order / pending proceeding 
								                   relating to professional matters by ICAI, Competent Auithority or Court. On considering 
								                   the same, Audit Committee shall recommend the consideration of Statutory Auditor to the 
								                   Board. If the Company doesnot have Audit Committee, the Board shall consider the above 
								                   points at their meeting.</td>
								<td id="hdreappt2"><select id="reaapointment" ><option value="">--select--</option></select><span id="errreaapointment"></span></td>
								<td id="hdreappt3"></td>
								<td id="hdreappt4"><select id="reaapointment1"><option value="">--Select--</option></select><a href="#" class="myButton" id="downloadDoc8" onclick="">Download</a><span id="errreaapointment1"></span></td>
							</tr> 
							<tr>
								<td readonly id="a2" readonly>mm-dd-yy</td>
								<input type='hidden' id="hda2" name="hda2" />
								<input type="hidden" name="boardMeeting" value="bordmeeting" />
								<td><input type="text" id="b2"	onchange="setcalendardates(2);" onkeyup="numvalidate(this);"
									size=2 maxlength=3 value="7"></td>
								<td readonly id="c2" >30</td>
								<td>Notice and agenda for the Board Meeting</td>
								<td class="smfont">(a). As per Secretarial Standard 1, para
									1.3.8, Each item of business requiring approval shall be
									supported by a note setting out the details of proposal,
									relevant material facts, that enable the directors to
									understand the meaning, scope, and implications of the proposal
									and the nature of interest and concern, if any of any director
									in the proposal, which the director has earlier disclosed shall
									either be set out in the note or placed before the meeting.<br />
									(b). In case the facility of participation through Electronic
									Mode is being made available , the Notice shall inform the
									Directors about the availability of such facility, and provide
									them necessary information to avail such facility.
								</td>
								<td><select id="boardDir" onchange="getStatutaryDirName4()"><option value="">--Select--</option></select><span id="errboardDir"></span></td>
								<td id="agendaDirectors"></td>
								<td><select id="noticeBoard" name="noticeBoard"	onchange="getDirName4()"><option value="">--Select--</option></select><a href="#" class="myButton"
									id="downloadDoc4" onclick="">Download</a><span id="errnoticeBoard"></span></td>
							</tr>
							<tr>
								<td class="tdbgcolor"></td>
								<td colspan="7" class="tdbgcolor">Conducting the Board Meeting</td>
							</tr>
							<tr>
<td readonly id="a3" >mm-dd-yy</td>
<input type='hidden' id="hda3" name="hda3" /><input type="hidden" name="attendenceRegister"	value="attendenceRegister" />
								<td><input type="text" id="b3"
									onchange="setcalendardates(3);" onkeyup="numvalidate(this);"
									size=2 maxlength=3 value="0"></td>
								<td readonly id="c3" readonly>23</td>
								<td>Board Meeting Attendance Register</td>
								<td>Requirement is as per Secretarial Standard 1 para 4.
									Ensure that these are serially numbered.</td>
								<td readonly class="nonreqcel"></td>
								<td id="registredEmail"></td>
								<td><a href="#" class="myButton" id="downloadDoc5" onclick="">Download</a></td>
							</tr>
							<tr>
								<td readonly id="a4">mm-dd-yy</td>
								<input type="hidden" id="hda4" name="hda4" />
								<td><input type="text" id="b4"
									onchange="setcalendardates(4);" onkeyup="numvalidate(this);"
									size=2 maxlength=3 value="0"></td>
								<td readonly id="c4" readonly>23</td>
								<td>Board Meeting</td>
								<td>Notice alongwith the route map shall be posted in the
									Company website, if any.</td>
								<td readonly class="nonreqcel"></td>
								<td readonly class="nonreqcel"></td>
								<td readonly class="nonreqcel"></td>
							</tr>
							<tr>
								<td readonly id="a5" >mm-dd-yy</td>
								<input type="hidden" id="hda5" name="hda5" />
								<input type="hidden" name="annuvalMeeting"
									value="annuvalMeeting" />
								<td><input type="text" id="b5"
									onchange="setcalendardates(5);" onkeyup="numvalidate(this);"
									size=2 maxlength=3 value="23"></td>
								<td readonly id="c5" readonly>23</td>
								<td>Notice of Annual General Meeting</td>
								<td class="smfont">Atleast 21 clear days the notice shall
									be given to:<br />(a). The members <br /> (b). Legal
									representatives of the deceased member<br /> (c). Assignee of
									an insolvent member<br /> (d). Audior or Auditors of the
									Company<br /> (e). Every director of the Company<br /> (f).
									Secretarial Auditor<br /> (g). Debenture Trustees through mail
									or in writing.
								</td>
								<td><select id="genaralMeetingDir"><option>-----Select-----</option></select></td>
								<td>&nbsp;</td>
								<td></td>
							</tr>
							<tr>
								<td class="tdbgcolor"></td>
								<td colspan="7" class="tdbgcolor">Conducting Annual General
									Meeting</td>
							</tr>
							<tr>
								<td readonly id="a6" readonly>mm-dd-yy</td>
								<input type="hidden" id="hda6" name="hda6" />
								<input type="hidden" name="annuvalMeeting2"
									value="annuvalMeeting2" />
								<td><input type="text" id="b6"
									onchange="setcalendardates(6);" onkeyup="numvalidate(this);"
									size="2" maxlength="3" value="0"></td>
								<td  id="c6" readonly>0</td>
								<td>Annual General Meeting Attendance Register</td>
								<td>Attendance slips made as part of Notice shall be
									obtained from the members attending the meeting.</td>
								<td readonly class="nonreqcel"></td>
								<td id="registredEmail"></td>
								<td><a href="#" class="myButton" id="downloadDoc6" onclick="">Download</a></td>
							</tr>
							<tr>
								<td id="a7"><font color="green">AGMDATE </font></td>
								<input type="hidden" id="hda7" name="hda7" />
								<td id="b7" readonly>0</td>
								<td id="c7" readonly>0</td>
								<td class="smfont">Annual General Meeting:<br /> (1).
									Adoption of Accounts.<br /> (2). Re-appointment of Auditor for
									a period of 5 years.<br /> (3). Regularization of Additional
									Director as Director of the Company<br /> (4). Reqularization
									of Additional Director as Independent Director of the Company
								</td>
								<td>This should be conducted at the registered office of
									the Company.</td>
								<td readonly class="nonreqcel"></td>
								<td readonly class="nonreqcel"></td>
								<td readonly class="nonreqcel"></td>
							</tr>
							<tr>
								<td class="tdbgcolor"></td>
								<td colspan="7" class="tdbgcolor">Post Annual General Meeting</td>
							</tr>
							<tr>
								<td rowspan="2" id="a8">mm-dd-yy</td>
								<input type="hidden" id="hda8" name="hda8" />
								<input type="hidden" name="intimationAuditor" value="intimationAuditor" />
								<td readonly rowspan="2" id="b8" class="nonreqcel"></td>
								<td rowspan="2" id="c8">15</td>
								<td>Intimation to the Auditor about their re-appointment.[Sec 139]</td>
								<td>Within 15 days from the date of Annual General Meeting,	Company has to intimate the Auditor about the appointment.</td>
								<td><select id="sec139-1"><option value="">--Select--</option></select><span id="errsec139-1"></span></td>
								<td id="registredEmailOne"></td>
								<td><select id="sec139" name="sec139"	onchange="getDirName6()"><option value="">--Select--</option></select><a href="#" class="myButton"
									id="downloadDoc7" onclick="">Download</a></td>
							</tr>
							<tr>
								<input type="hidden" name="fillingSec139" value="fillingSec139" />
								<td>Filing of Form ADT-1 for appointment of Auditor. [Sec
									139]</td>
								<td>Within 15 days from the date of Annual General Meeting,
									Company has to file Form ADT 1 regarding appointmen /
									reappointment of the Auditor.</td>
								<td readonly class="nonreqcel"></td>
								<td id="registredEmailTwo"></td>
								<td readonly class="nonreqcel"></td>
							</tr>
							<tr>
								<td id="a9" readonly>mm-dd-yy</td>
								<input type="hidden" id="hda9" name="hda9" />
								<input type="hidden" name="fillingReport" value="fillingReport" />
								<td readonly class="nonreqcel"></td>
								<td id="c9" readonly>30</td>
								<td>Filing of Annual Report. [Sec 137(1)]</td>
								<td>Within 30 days from the date of Annual General Meeting,
									Company has to File Annual Report with ROC.</td>
								<td readonly class="nonreqcel"></td>
								<td id="registredEmailThree"></td>
								<td readonly class="nonreqcel"></td>
							</tr>
							<tr>
								<td id="a10" readonly>mm-dd-yy</td>
								<input type="hidden" id="hda10" name="hda10" />
								<input type="hidden" name="return924" value="return924" />
								<td readonly rowspan="2" class="nonreqcel"></td>
								<td id="c10" readonly>60</td>
								<td>Filing of Annual Return [Sec 92(4)]</td>
								<td>Within 60 days from the date of Annual General Meeting,
									Company has to file Annual Return with ROC.</td>
								<td readonly class="nonreqcel"></td>
								<td id="registredEmailFour"></td>
								<td readonly class="nonreqcel"></td>
							</tr>
						</table>
						<br />
						<div align="center" style="padding-right: 30px;">
							<a href="#" class="myButton" id="updateCalander" onclick="">Update
								Calendar</a>
						</div>
						<br /> <input type="hidden" name="userId" id="userId"
							value="${userId}">
					</div>
				</div>
			</div>
			<input type="hidden" id="hddirNames" name="hddirNames">
			<input type="hidden" id="hddirEmail" name="hddirEmail">
			<input type="hidden" id="hdaddDirNames" name="hdaddDirNames">
			<input type="hidden" id="hdadddirEmail" name="hdadddirEmail">
			<input type="hidden" id="hdaddNewDirNames" name="hdaddNewDirNames">
			<input type="hidden" id="hdnewdirEmail" name="hdnewdirEmail">
			<input type="hidden" id="hdstadirEmail" name="hdstadirEmail">
			<input type="hidden" id="hdstatutaryDirNames"
				name="hdstatutaryDirNames">
			<input type="hidden" name="stadirType" value="staDirector" />
			<input type="hidden" name="newdirType" value="nDirector" />
			<input type="hidden" id="hdaddDir" name="hdaddDirNames">
			<input type="hidden" name="adddirType" value="addDirector" />
			<input type="hidden" name="hdAgmDate" id="hdAgmDate">
			<input type="hidden" name="email" id="hduserEmail">
			<input type="hidden" name="hdagmDueDate" id="hdagmDueDate">
			<input type="hidden" id="hdstadirEmail" name="hdstadirEmail">
			<input type="hidden" id="hdagendaDirectors" name="hdagendaDirectors">
			<input type="hidden" id="directorsOne12" name="retiredDirName">
			<input type="hidden" id="statutaryDirec" name="statutaryDirec">
			<input type="hidden" id="compId" name="compId">
			<input type="hidden" name="boardTime" id="hdboardTime">
			<input type="hidden" name="boardVenue" id="hdboardVenue">
			<input type="hidden" name="agmVenue" id="hdagmVenue">
			<input type="hidden" name="agmTime" id="hdagmTime">
			<input type="hidden" name="hdstaType" id="hdstaType">
			<input type="hidden" name="hdnature" id="hdnature">
			<input type="hidden" name="hdFirmRegNo" id="hdFirmRegNo">
			<input type="hidden" name="date" id="date">
			<input type="hidden" name="templateName" id="templateName">
			
			</form:form>
	</div>

</body>
</html>
