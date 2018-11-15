<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/register.js"></script>
	</head>
	<body onload="">
		<div class="wrapper">
			<div class="header">
				<div class="head_left" align="center" valign="middile"><img src="views/images/cea-logo.png" alt="logo" border="0" width="161" height="67"></div>
				<div class="head_mid"></div>
				<div class="head_right">
					<div align="left" width="100px;" style="padding:18px 0px 0px 0px;">Mr. ${userName}</div>
					<div align="left" width="100px;" style="padding:8px 0px 0px 0px;">Account Type: Premium</div>
				</div>
				<div class="log_outright">.
					<span id="logout" align="left" width="50px;" style="top:10px;left:20px;position:relative;"><img src="views/images/logout.png" alt="log out" border="0" width="30" height="30"></span>
				</div>
			</div>
			<div class="menu_content"> 
				<div id='cssmenu'>
				   <ul>
					  <li><a href='#'><span>Home</span></a></li>
					  <li><a href="howItWorks.html"><span>How it works</span></a></li>
					  <li class='active has-sub'><a href="#" ><span>Products</span></a>
						<ul>
							<li class='last'><a href="userRegisterAgmdate.html?hdName=${userName}">AGM</a></li>
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
					<div style="background-color:#F8F8F8;">
						<br/><br/><br/><br/><br/><br/><br/>
						<div align= "center" style="font-family:Arial, Verdana Helvetica, sans-serif;font-size:14px;color:#000000; font-weight:bold;"><img src="views/images/progress.jpg" width="350px" height="264px"/> </div><br/><br/>	
						
					</div>
				</div>
				
			</div>
			</div>
		</div>
	</body>
</html>
