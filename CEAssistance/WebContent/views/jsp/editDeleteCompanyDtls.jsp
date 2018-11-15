<%@include file="./taglib_includes.jsp"%>
<html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
		
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/editDelete.js"></script>
		<script type="text/javascript">
		function remove()
		{
			if(document.getElementById("companyId").value!="sel")
			{
			$('#errcname').html("");
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
							<li class='last'>AGM</li>
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
				<form name="editDeleteForm">
				<div class="right">
					<div style="background-color:#F8F8F8;">
						<br/><br/>
						<c:if test="${!empty(commonVo)}">
						<div align= "center" style="font-family:Arial, Verdana Helvetica, sans-serif;font-size:14px;color:#000000; font-weight:bold;">
						<dl>
						<dt>Company Name:<select id="companyId" name="companyName">
										<option value="sel">-Please Select Company Name-</option>
										<c:forEach var="comList" items="${commonVo}">
											<option value="${comList.companyName}-${comList.companyId}">${comList.companyName}</option>
										</c:forEach>
								</select><span id="errcname"></span>
								<img src="views/images/proceed1.jpg" id="getdetails" border="0" width="125" height="20" title="getdetails"/><br/>
						</dl>
						 </div>
						 </c:if>
						 <c:if test="${empty(commonVo)}">
			<div align="center"><font color="red">No Companies are found </font> for Add Companyies <a href="userRegisterAgmdate.html">Add Companies</a></div>
			</c:if>
						 <br/><br/>	
						
					</div>
				</div>
				</form>
			</div>
			<div id="data">
			
			</div>
			</div>
		
	</body>
</html>
