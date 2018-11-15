
 <html>
	<head>
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
			.wrapper{
				width:1004px;
				height:604px;
				margin-left:auto;
				margin-right:auto;
				/*border:1px solid #ecebeb;*/
			}
			.header{
				width:990px;
				height:104px;
				margin:5px;
				/*border:1px solid green;*/
			}
			.menu_content{
				width:990px;
				height:40px;
				margin:5px;
				/*border:1px solid blue;
				background-color:#c3dde0;*/
			}	
			.main_content{
				width:990px;
				height:430px;
				margin:5px;
				/*border:1px solid red;
				box-shadow: 1px 1px 1px 1px  black;*/
			}
			.logo_menupart{
				width:204px;
				height:90px;
				margin:5px;
				border:1px solid yellow;
			}
			.logo{
				width:161px;
				height:67px;
				margin:2px 0px 0px 0px;
				float:left;
			}
			.menu_mainpart{
				width:843px;
				height:67px;
				float:left;
			}
			.left{
				width:200px;
				height:410px;
				float:left;
				margin:5px;
				border:1px solid #ecebeb;
			}
			.right{
				width:759px;
				height:410px;
				float:left;
				margin:5px;
				border:1px solid #c3dde0;
				background-color:#FFFFFF;
			}
			.head_left{
				width:200px;
				height:90px;
				float:left;
				margin:5px;
				
			}
			.head_mid{
				width:350px;
				height:90px;
				float:left;
				margin:5px;
				/*border:1px solid green;*/
			}
			.head_right{
				width:300px;
				height:90px;
				float:left;
				margin:5px;
				font-family:Arial, Helvetica, sans-serif;
				font-size:14px;
				font-weight:normal;
				/*border:1px solid green;*/
			}
			.log_outright{
				width:94px;
				height:90px;
				float:left;
				margin:5px;
				/*border:1px solid green;*/
			}
			.menu_fontstyle{
				font-family:Arial, Helvetica, sans-serif;
				font-size:13px;
				font-weight:normal;
				color:white;
				
			}
			.menu_fontstyle a{
				margin:0px;
				width:auto;
				padding:0px;
				text-decoration: underline;
				font-family:'daxpro-regular', sans-serif;
				font-size:1.2em;
				color:#5f5f5f;
			}
			.glossymenu{
				margin: 0px 0;
				padding: 0;
				width:100%;
				border-bottom-width: 0;
			}
			.glossymenu a{
				margin: 0px 0 0;
				padding: 0;
			}
			.glossymenu a.menuitem{
				background: black url(images/glossyback2.gif) repeat-x top left;
				font: normal 14px Arial, Helvetica, sans-serif;
				color: white;
				display: block;
				position: relative; /*To help in the anchoring of the ".statusicon" icon image*/
				width: auto;
				border:1px solid #236fbb;
				height:18px;
				padding: 5px 0px 0px 0;
				padding-left: 10px;
				text-decoration: none;
			}
			.glossymenu a.menuitem:visited, .glossymenu .menuitem:active{
				color: white;
			}
			.glossymenu a.menuitem .statusicon{ /*CSS for icon image that gets dynamically added to headers*/
				position: absolute;
				top: 5px;
				right: 5px;
				border: none;
			}
			.glossymenu a.menuitem:hover{
				background-image: url(images/glossyback2.gif);
			}
			.glossymenu div.submenu{ 
				background: #fff;
				padding:5px;
			}
			.glossymenu div.submenu ul{ /*UL of each sub menu*/
				list-style-type: none;
				margin: 0;
				background:#fff;
				border-bottom: 1px solid #ccc;
				padding: 0;
			}
			.glossymenu div.submenu ul li{
				/*border-bottom: 1px solid blue;*/
			}
			.glossymenu div.submenu ul li a{
				display: block;
				font: normal 13px Arial, Helvetica, sans-serif;
				color: #003ea8;
				text-decoration: none;
				padding: 5px 0;
				text-decoration:underline;
				padding-left: 10px;
			}
			.glossymenu div.submenu ul li a:hover{
				background: #cef5b3;
				text-decoration:none;
				color: white;
			}
			.down-arrow {
				display: inline-block;
				position: relative;
				background: darkcyan;
				padding: 15px 0;
				width: 200px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div class="wrapper">
			<div class="header">
				<div class="head_left" align="center" valign="middile"><img src="views/images/cea-logo.png" alt="logo" border="0" width="161" height="67"></div>
				<div class="head_mid"></div>
				<div class="head_right">
					<div align="left" width="100px;" style="padding:18px 0px 0px 0px;"><b>Welcome Mr.${userName}</b></div>
					<div align="left" width="100px;" style="padding:8px 0px 0px 0px;">Account Type: <b>${userType}</b></div>
				</div>
				<div class="log_outright">.
					<div align="left" width="50px;" style="top:10px;left:20px;position:relative;"><a href="userLogOut.html"><img src="views/images/logout.png" alt="log out" border="0" width="30" height="30"></a></div>
				</div>
			</div>
			<div class="menu_content"> 
				<table width="928" border="0" cellspacing="0" cellpadding="0" align="center">
					<tbody><tr>
						<td width="105" height="38" align="center" valign="middle" class="menu_fontstyle"><a href="#" >My Home</a></td>
						<td width="105" height="38" align="center" valign="middle" class="menu_fontstyle"><a href="#">How it works</a> </td>
						<td width="115" height="38" align="center" valign="middle" class="menu_fontstyle"><a href="#">Products</a>
						<span width="20" height="38"><a href="#" onclick="document.getElementById('drop_menu').style.display='block';" onblur="document.getElementById('drop_menu').style.display='none';"><img src="views/images/arrow-down.png" alt="arrow" border="0" width="25" height="25"></span></td>
						<td width="105" height="38" align="center" valign="middle" class="menu_fontstyle"><a href="#">Partner with Us</a></td>
						<td width="105" height="38" align="center" valign="middle" class="menu_fontstyle"><a href="userRegisterAgmdate.html?hdName=${userName}&userId=${userId}">About Us</a></td>
						<td width="105" height="38" align="center" valign="middle" class="menu_fontstyle"><a href="#">Contact Us</a></td>
					</tr>
				</table>
			</div>
			<div id='drop_menu' style='border:1px solid #82CAFA; height:80px;width:80px;z-index:10;font-family:verdana;font-size:9pt; background-color:#FFFFFF; top:160px;left:550px;position:absolute;display:none;'><div align="center" valign="bottom" style=""><a href="userRegisterAgmdate.html?hdName=${userName}">AGM</a></div></div>
			<div class="main_content">
				<div class="left">
					<div class="glossymenu">
						<div class="submenu">
							<ul>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">View Profile</a></li>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">Company Status</a></li>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">Add Companies</a></li>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">Add Information </a></li>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">View Calendar and customize</a></li>
								<li><a href="#" style="text-decoration:none" onclick="setLinksColor_dash(this)" target="right_body">Download Check lists </a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="right">
					<div style="background-color:#F8F8F8;">
						<div align= "center" style="font-family:Arial, Verdana Helvetica, sans-serif;font-size:14px;color:#000000; font-weight:bold;"> Profile </div><br/><br/>	
						<table width="100%" class="tabcss_main" align="center">
							<tr><td align="left"><b>Successfully Added Company Details<br>If You Want Add Another Company Info click below link<br><a href="">Add Company Info</a></b></td></tr>
							<tr><td align="left"></td></tr>
							<tr><td align="left"></td></tr>
							<tr><td align="left"></td></tr>
						
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
 