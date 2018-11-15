<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Profile Page</title>
		<style>
			.tabcss_main {
				background-color:#FFFFFF;
				border:2px solid #c3dde0;
				color:#000; 
				font-family:Arial, Verdana Helvetica, sans-serif;
				font-size:14px;color:#000000;
				text-align: center;	
				padding: 8px 0;
			}
		</style>
	</head>
	<body>
		<div style="background-color:#F8F8F8;">
			<div align= "center" style="font-family:Arial, Verdana Helvetica, sans-serif;font-size:14px;color:#000000;font-weight:bold;">Profile</div><br/><br/>	
			<table width="40%" class="tabcss_main" align="center">
				<tr><td align="left">User Name</td><td align="left">${userName}<input type="hidden" name="hdName" value="${userName}"></td></tr>
				<tr><td align="left">Registered on</td><td align="left">${date}</td></tr>
				<tr><td align="left">Registered mail id</td><td align="left">${mail}</td></tr>
				<tr><td align="left">Registered Mobile No</td><td align="left">${mobile}</td></tr>
			</table>
		</div>
	</body>
</html>