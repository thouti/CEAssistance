<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/register.js"></script>
		</head>
<div class="header">
	<div class="head_left" align="center" valign="middile"><img src="views/images/cea-logo.png" alt="logo" border="0" width="161" height="67"></div>
	<div class="head_mid"></div>
	<div class="head_right">
		<div align="left" width="100px;" style="padding:18px 0px 0px 0px;">Hello, <b><%=session.getAttribute("uName").toString()%></b></div>
		<div align="left" width="100px;" style="padding:8px 0px 0px 0px;">Account Type: Premium</div>
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
				<li class='last'><a href="userRegisterAgmdate.html?userId=${userId}&userType=${userType}">AGM</a></li>
			</ul>
		  </li>
		  <li><a href="partnerWithUs.html"><span>Partner with Us</span></a></li>
		  <li><a href="aboutUs.html" ><span>About Us</span></a></li>
		  <li class='last'><a href="contactUs.html" ><span>Contact Us</span></a></li>
		</ul>
	</div>
</div></html>