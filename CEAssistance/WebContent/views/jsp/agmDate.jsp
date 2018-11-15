<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/register.js"></script>
		<script language="javascript">
		$(document).ready(function(){
			$('#no_comp').keypress(
		    	function(event) {
		        	//Allow only backspace and delete
			        if (event.keyCode != 46 && event.keyCode != 8) {
			            if (!parseInt(String.fromCharCode(event.which))) {
			                event.preventDefault();
			            }
			        }
			});	
		});
		function removeMess()
		{
			if(document.getElementById("no_comp").value!="")
				{
				$("#errNoComp").html("");
				}
		}
		</script>
	</head>
	<body onload="">
		<div class="wrapper">
			<div class="header">
				<div class="head_left" align="center" valign="middile"><img src="views/images/cea-logo.png" alt="logo" border="0" width="161" height="67"></div>
				<div class="head_mid"></div>
				<div class="head_right">
					<div align="left" width="100px;" style="padding:18px 0px 0px 0px;">Hello,<b><%=session.getAttribute("uName").toString()%></b></div>
					<div align="left" width="100px;" style="padding:8px 0px 0px 0px;">Account Type:<b> ${userType }</b></div>
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
							<li class='last'><a href="userRegisterAgmdate.html?userId=${userId}&userType=${userType}&hdName=${userName}">AGM</a></li>
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
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">Download Check lists </a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="right">
					<div style="width:10%;height:470px;float:left;margin:5px;background-color:#FFFFFF;" align="center">
						<img src="views/images/workImg.jpg" width="105px" height="395px"/>
					</div>
					<div  style="width:80%;height:400px;margin:5px;background-color:#FFFFFF;font-family:Arial,Verdana Helvetica,sans-serif;
						font-size:14px; color:#000000;">
						<br/>Dear &nbsp;&nbsp;<b> <%=session.getAttribute("uName").toString()%>,</b><br/>
						<p style="line-height:170%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome to AGM E - Assistant Tool and we thank you for visiting our website for using the unique facility.<br>
						If your requirement is for a private company limited by shares or closely held public company limited by shares<br/>
						then our Tool will be great help to You. Otherwise, you have to customize the Calendar and create documents.<br/>
						We may help you in sharing the documents as required on the task dates as desired by you.Provided below is <br/>
						the "Process flow with AGM E- Assistant" Tool to give a brief about the entire procedure. Also you may view the<br/> 
						status of each Company at "Company Status".After completion of work under each Company, request You <br/> 
						to give your valuable feedback on using our services. It will be very useful for us to incorporate such suggestions <br/>
						and reach You with more facilities and Tools in  the days to come. Learn back to your chair and feel the work of <br/> 
						 AGM E- Assistant from our end.<br></p>
						<p align="right">Thanks and regards,<br>
						Corporate E- Assistance Team</p>
						<br/>
						<form name="userform">
							<input type="hidden" name="hdName" value="${userName}">
							<table >
								<tr><td> Number of companies AGM Should be required <input type="text" id="no_comp" name="noOfCompanies" maxlength="3" size="3" onkeyup="removeMess()" /><span id="errNoComp"></span></td><td align="right"><span id="proceed"><input type="button" name="proceed" value="proceed" id="payPal"/></span></td></tr>
							</table>
							<div id="amt">Total Amount: <span id="totAmt"></span><input type="hidden" name="totAmt" id="tAmt"><input type="hidden" name="userId" id="userId" value="${userId}"></div>
							<div id="emptydiv" class="errortext"></div>
						</form>
					</div>
				</div>
				
			</div>
			</div>
		</div>
	</body>
</html>
