<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
<!--   <title>ResponsiveSlides.js &middot; Responsive jQuery slideshow</title> -->
<!--   <meta name="viewport" content="width=device-width,initial-scale=1"> -->
  <link rel="stylesheet" href="./views/css/responsiveslides.css">
  <link rel="stylesheet" href="./views/css/demo.css">
  
  <link rel="icon"  href="views/images/cea-logo.png"/><title>Corporate E-Assistance - India&#039;s Leading Corporate Services Provider</title>
	<link href="./views/css/ceastyle.css" type="text/css" rel="stylesheet" media="screen, projection" />
  <link href="./views/css/style_css18.css" type="text/css" rel="stylesheet" media="screen, projection" />
   <script src="./views/js/responsiveslides.min.js"></script>
  <script src="./views/js/responsiveslides.js"></script>
  <link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
  <script type="text/javascript" src="./views/js/register.js"></script>
  <script type="text/javascript">
function loginfunction()
{
	if(document.getElementById("loignEmail").value=="")
		{
		
		}
	document.loginForm.action="loginuser.html";
 	document.loginForm.method="POST";
 	document.loginForm.submit();
	}

</script>
  <script>
    // You can also use "$(window).load(function() {"
    $(function () {
      // Slideshow 1
      $("#slider1").responsiveSlides({
        maxwidth: 1024,
        speed: 800
      });
    
    });
  </script>
  
  <script type="text/javascript">
function removeMess()
{
	if(document.getElementById("firstName").value!="")
	{
	$('#errorFirstname').html("");
	}
	if(document.getElementById("lastName").value!="")
	{
	$('#errorLastname').html("");
	}
	if(document.getElementById("password").value.length>4)
	{
	$('#erPswd').html("");
	}
	if(document.getElementById("dob").value.length>1)
	{
	$('#erPswd').html("");
	}
}
</script>
  
</head>

<body class="home page page-id-7617 page-template page-template-home page-template-home-php">
	<div align="center">${error}</div>
	<div class="wrapper">
	<div align="center"> 
		<font color="red"><strong><marquee>Site under Development...&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Site under Development...&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Site under Development...</marquee></strong></font>
		</div>
		<div id="search_social">
		
			<div id="social">
				<ul>
				<li><a href="https://twitter.com/neohometuitions"><img src="./views/images/tw.png" /></a></li>
	        	<li><a href="https://plus.google.com/u/1/106054801941976563719/posts" target="_blank"><img src="./views/images/gp.png" /></a></li>
	        	<li><a href="https://www.facebook.com/neo.hometuitions"><img src="./views/images/fb.png" /></a></li>
			</ul>
			</div>
<!-- 			<div id="search_form"> -->
<!-- 				<gcse:searchbox-only resultsUrl="/search"></gcse:searchbox-only> -->
<!-- 			</div> -->
		</div>
		<div id="header">
			<div id="logo_contact">
				<div id="logo">
<!-- 					<a href="/">Corporate E-Assistance</a> -->
					<a href="home.html"><img src="./views/images/cealogo5.png" height="48" width="185" alt="CEA-Logo" class="Cealogo"/></a>
				</div>
				<div id="contact_details">
					<ul id="contact_info">
						<li id="icon-phone"><a href="tel:+65 6222 7445">09999999999</a></li>
						<li id="icon-email"><a href="mailto:info@guidemesingapore.com">info@corporateeassistance.com</a></li>
					</ul>
				</div>
			</div>	
			
			
<div class="menu_content"> 
<div id='cssmenu'>
<ul>
<li><a href='#'><span>Home</span></a></li>
<li><a href="howItWorks.html"><span>How it works</span></a></li>
<li class='active has-sub'><a href="#" ><span>Products</span></a>
<ul>
<li class='last'><a href="userAgmdate.html?hdName=${userName}&userId=${userId}">AGM</a></li>
</ul>
</li>
<li><a href="partnerWithUs.html"><span>Partner with Us</span></a></li>
<li><a href="aboutUs.html" ><span>About Us</span></a></li>
<li class='last'><a href="contactUs.html" ><span>Contact Us</span></a></li>
</ul>
</div>
</div>
			
			
		</div>
  
  
       <!-- Slideshow 1 -->
    <ul class="rslides" id="slider1">
      <li><img src="views/images/image1.jpg" alt=""></li>
      <li><img src="views/images/image2.jpg" alt=""></li>
      <li><img src="views/images/image3.jpg" alt=""></li>
    </ul>
    
    
  </div>
<!--   Register form starting -->
<div style="padding:5px 15px 15px 15px; border: 1px solid #e4e4e4; background-color:#fff;" class="ceasign">

			
			<form name="userform" >
				
				<h1 style="font-weight: normal; text-align:center; font-weight:300; color:#000080; width:100%; display: block; font-size:17px; margin-bottom:0px;" class="commonTitle">Create a
						Free Account</h1>
					<hr style="height:1px; border:0px; border-bottom:#FFC2C2 solid 1px !important; "/>
					<table cellspacing="10" cellpadding="0" border="0" style="width: 460px; padding:15px 0px 7px 0px; margin-left: -10px;" class=" ">
					<tbody>
													
<!-- 					<tr style="height: 35px;"> -->
<!-- 						<td style="width: 55px" class="label"><label for="userRealName">Name<span class="star">* </span></label></td> -->
<!-- 						<td class="value"> -->
<!-- 							<span id="name"> -->
<!-- 							<input type="text" style="height: 21px; width: 120px; border: 1px solid #5dd2ff;" placeholder="First Name" value="" name="firstName" id="firstName" onkeyup="removeMess()"/> -->
<!-- 							<input type="text" style="height: 21px; width: 121px; border: 1px solid #5dd2ff;" placeholder="Last Name" value="" name="lastName" id="lastName" onkeyup="removeMess()"/> -->
<!-- 							<span id="errorFirstname"></span>  -->
<!-- 							</span> -->
<!-- 						</td> -->

<!-- 					</tr> -->
					
					
					
					<tr style="height: 35px;">
						<td style="width: 55px" class="label"><label for="userRealName">First Name<span class="star">* </span></label></td>
						<td class="value">
							<span id="name">
							<input type="text" style="height: 21px; width: 155px; border: 1px solid #5dd2ff;" placeholder="First Name" value="" name="firstName" id="firstName" onkeyup="removeMess()"/>
							 
							</span>
							<span id="errorFirstname"></span>
						</td>

					</tr>
					
					<tr style="height: 35px;">
						<td style="width: 55px" class="label"><label for="userRealName">Last Name<span class="star">* </span></label></td>
						<td class="value">
							<span id="name">
							<input type="text" style="height: 21px; width: 155px; border: 1px solid #5dd2ff;" placeholder="Last Name" value="" name="lastName" id="lastName" onkeyup="removeMess()"/>
							<span id="errorLastname"></span> 
							</span>
						</td>

					</tr>
					
					

					<tr style="height: 35px;">
						<td class="label"><label for="username">Email<span class="star">* </span></label></td>
						<td class="value ">
							<input type="text" style="width: 155px; height: 21px; border: 1px solid #5dd2ff;" value="" placeholder="Your email id" name="email" id="email" /> 
						<span id="erEmail"></span>
						</td>
					</tr>

					<tr style="height: 35px;">
						<td style="width: 75px;" class="label"><label for="password">Password<span class="star">* </span>
						</label></td>
						<td class="value ">
							<input type="password" style="width: 155px; height: 21px; border: 1px solid #5dd2ff;" value="" name="password" placeholder="Password" id="password" onkeyup="removeMess()"/>
						<span id="erPswd"></span>
						</td>
					</tr>

					<tr class="provider" style="height: 35px;">
							<td class="label"><label for="enabled">Phone<span class="star">* </span></label></td>
							<td class="value">&nbsp;
								 <input type="text" style="width: 155px; height: 21px; float: left; border: 1px solid #5dd2ff;" title="" value="" placeholder="Your phone number" name="mobile" maxlength="10"  id="mobile" class="number" onkeyup="removeMess()"/>
							<span id="erPhone"></span>
							</td>
						</tr>
					<tr style="height: 35px;" id="cityField">
						<td class="label"><label for="enabled">Date Of Birth<span class="star">* </span></label></td>
						<td class="value ">
							<input type="text" style="width: 155px; height: 21px; border: 1px solid #5dd2ff;" title="" value="" name="dob" id="datepicker" maxlength="10" size="10" class="number" placeholder="Date of Birth" class="" maxlength="10"/>
							<span id="errDt"></span>
						</td>
						
					</tr>
					
					<!-- <tr style="height: 35px;">
						<td style="width: 107px;" class="label"><label for="password">
								Country<span class="star">* </span>
						</label></td>
						<td class="value ">
							<input type="text" style="width: 250px; height: 21px; padding: 2px; border: 1px solid #5dd2ff;" value="" name="country"  id="country" placeholder="Enter your Country" onkeyup="removeMess()"/>
							<span id="errCountry"></span>
						</td>
					</tr>
 -->
				</tbody></table>
				
				
<!-- 				<center> -->
					<div style="margin: 0px 0 0 0px;">

						<div style="float: left; margin: 0px 0px 16px 0px; width: 100%;">
							<div style="float: left;">
								<input type="submit" style=" background-color: #FF9934; width:155px; height:25px; border: 1px solid rgb(236, 162, 27);  border-radius:2px; margin-left:65px; color: white; font-size: 15px;" alt="Log In" value="Submit" id="register" >
							</div>
							

					<p style="margin-left: 0px; width: 100%; float: left; margin-top: 11px;" class="fontSize10">
							By signing up, you agree to our
							<a class="no-underline" target="_blank" href="/terms-of-use">Terms of Use</a>
							and
							<a class="no-underline" target="_blank" href="/privacy-policy">Privacy Policy</a></p>
							<p style="margin-left: 0px; width: 100%; float: left; margin-top: 11px;" class="fontSize10">Already a Member?<a class="no-underline" href="login.html">Login</a></p>


<!-- 							<div style="margin-top: 4px; margin-bottom: 10px; width: 290px; display:none;"> -->
								
<!-- 									<a onclick="JavaScript:fbLogin();return true;" href="#"><img style="margin-top: 9px;" src="./views/images/fb_new.png"></a> -->
<!-- 									<div id="fb-root"></div> -->
								
<!-- 							</div> -->
						</div>

<!-- 						<div style="margin: 8px 0 6px 0px;" class="loud"> -->
<!-- 							Already a Member? -->
<!-- 							<a class="no-underline" href="login.html">Login</a> -->
<!-- 							<span class="color336699">»</span> -->
<!-- 						</div> -->

					</div>
<!-- 				</center> -->
			</form>
		</div>
		
		<!-- 		Login form #ff9934-->

<div style="padding:3px 19px 29px; border: 1px solid #e4e4e4; background-color:#3a5795;" class="cealogin">
<form name="loginForm">
<table cellspacing="10" cellpadding="0" border="0" style="width: 375px; padding:15px 0px 7px 0px; margin-left: -10px;" class=" ">
<tbody><tr><td class="loginfield">
<label for="email">Email or Username</label></td>
<td class="loginfield"><label for="pass">Password</label></td></tr>
<tr><td>
<input type="text" tabindex="1" value="" id="loignEmail" name="j_username" class="inputtext"/><span id="erLEmail"></span></td>
<td><input type="password" tabindex="2" id="pwd" name="j_password" class="inputtext"/></td>
<td><label for="u_0_n" id="loginbutton" class="uiButton uiButtonConfirm">
<input type="submit" id="u_0_n" tabindex="4" value="Log In" onclick="loginfunction()"/></label></td></tr>
<tr>
<td class="login_form_label_field"><div><div class="">
<!-- <input type="checkbox" class="" tabindex="3" value="1" name="persistent" id="persist_box"/><label class="uiInputLabelLabel" for="persist_box">Keep me logged in</label></div> -->
<input type="hidden" value="0" name="default_persistent"/></div></td>
<td class="login_form_label_field">
<a href="loginForgotPassword.html">Forgot your password?</a></td></tr>
<tr><td></td></tr>
</tbody>
</table>
</form>
</div>
</body>
</html>