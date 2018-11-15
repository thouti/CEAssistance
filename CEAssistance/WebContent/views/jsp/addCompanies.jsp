 <%@include file="./taglib_includes.jsp" %>
 <html>
	<head>
		<link href="./views/css/style_css18.css" type="text/css" rel="stylesheet"/>
		<link href="./views/js/ui.datepicker.css" type="text/css" rel="stylesheet"/>
		<script src="./views/js/jquery-1.6.4.js"></script>
<!-- 		<script src="./views/js/jquery-ui.js"></script> -->
		<script type="text/javascript" src="./views/js/addCompanies.js"></script>
		<script type="text/javascript" src="./views/js/jq.date.js"></script>
		
		<script language="javascript">
		function allowNum(e){
			var unicode=e.charCode? e.charCode : e.keyCode
			if (unicode!=8){ //if the key isn't the backspace key (which we should allow)
				if (unicode<48||unicode>57) //if not a number
					return false; //disable key press
			}
		}
		
		/*function displayalertmsgcomp(msg,div){
			if(document.getElementById(div))
	    		document.getElementById(div).innerHTML = msg;
		}*/
		function addRow(tableID){ 
			var toTComp = document.getElementById("totComp").value;
			if(toTComp>0) {
				var table=document.getElementById(tableID);
				var rowCount;
				var row;
				var colCount=table.rows[0].cells.length;
				var eleArr = ['','compname_','address_','type_','finyear_','agmduedate_','agmdate_','agmno_','site_','reminder_'];
				for( var j=0;j<toTComp-1;j++) {			
					rowCount=table.rows.length;
					row=table.insertRow(rowCount);
					for(var i=0;i<colCount;i++){
						var newcell=row.insertCell(i);
						newcell.innerHTML=table.rows[1].cells[i].innerHTML;
						newcell.childNodes[0].id = eleArr[i]+rowCount;
						switch(newcell.childNodes[0].type){
							case"text":newcell.childNodes[0].value="";break;
							case"checkbox":newcell.childNodes[0].checked=false;break;
							case"select-one":newcell.childNodes[0].selectedIndex=0;break;
						}
					}
					table.rows[rowCount].cells[0].innerHTML = rowCount+".";
				}
				document.getElementById("addCompTab").style.display ="block";
				document.getElementById("addCom").style.display ="block";
			}
			else
				document.getElementById("dispCompId").innerHTML = "<center><font size='4px' color='#000000' face='Arial, Verdana Helvetica, sans-serif'>Please Register companies</font></center>" ;
		}
		setTimeout("addRow('addCompTab')",100);
	</script>
	<script type="text/javascript">
      $(document).ready(function() {
                       //$(".datepick").datepicker({dateFormat: 'mm-dd-yy', minDate: 0, showOn: 'button', buttonImage:  value="./views/images/calendar01.gif", buttonImageOnly: true});
    	  $(".datepick").datepicker();
	  });
      </script> 
	</head>
	<body>
		<div class="wrapper">
			<div class="header">
				<div class="head_left" align="center" valign="middile"><img src="views/images/cea-logo.png" alt="logo" border="0" width="161" height="67"></div>
				<div class="head_mid"></div>
				
				<div class="head_right">
					<div align="left" width="100px;" style="padding:18px 0px 0px 0px;">Hello,<b> <%=session.getAttribute("uName").toString()%></b></div>
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
							<li class='last'><a href="userRegisterAgmdate.html?userId=${userId}&userType=${userType}&hdName=${userName}">AGM</a></li>
						</ul>
					  </li>
					  <li><a href="partnerWithUs.html"><span>Partner with Us</span></a></li>
					  <li><a href="aboutUs.html" ><span>About Us</span></a></li>
					  <li class='last'><a href="contactUs.html" ><span>Contact Us</span></a></li>
					</ul>
				</div>
			</div> 
			<div class="main_content1">
				<form name="addcompany">
					<div align= "center" style="font-family:Arial, Verdana Helvetica, sans-serif;font-size:14px;color:#000000;font-weight:bold;">Company Details </div><br/><input type="hidden" id="totComp" value="${noCommp}"/>
					<div style="font-family:Arial, Verdana Helvetica, sans-serif;font-size:14px;color:#000000;font-weight:bold;">Registered Number of Companies<span id="comp_size" style="padding-left:20px;">${noCommp}</span></div><br/>
					<div id="comp_errdiv" class="errortext"></div>
					<div id="dispCompId" style="background-color:#F8F8F8;" height="90%"><br/>
						<div style="background-color:#F8F8F8;overflow:auto;" height="90%"><br/>			
							<table width="100%" class="tabcss_main" id="addCompTab" style="display:none;">
								<tr>
									<th>Sr.No</th>
									<th>Company Name</th>
									<th>Address</th>
									<th>Company Type</th>
									<th>Financial Year</th>
									<th>AGM due date</th>
									<th>AGM date</th>
									<th>AGM No</th>
									<th>Services required</th>
									<th>Reminder days before Task</th>
								</tr>
								<tr id="addrow_1">
									<td id="srno_1">1.</td>
									<td><input type="text" id="compname_1" name="compname_1" value="" onblur="txtChkcomp(this,'comp_errdiv')"></input></td>
									<td><input type="text" id="address_1" value=""></input></td>
									<td><select name="type_1" id="type_1">
											<option value=""></option>
											<option value="public">public</option>
											<option value="private">private</option>
										</select></td>
									<td><select id="finyear_1" name="finyear_1"><option value="">---select---</option><option value="2011-2012">2011-2012</option><option value="2012-2013">2012-2013</option><option value="2013-2014">2013-2014</option><option value="2014-2015">2014-2015</option><option value="2015-2016">2015-2016</option><option value="2016-2017">2016-2017</option><option value="2017-2018">2017-2018</option><option value="2018-2019">2018-2019</option><option value="2019-2020">2019-2020</option><option value="2020-2021">2020-2021</option><option value="2021-2022">2021-2022</option><option value="2022-2023">2022-2023</option><option value="2023-2024">2023-2024</option><option value="2024-2025">2024-2025</option></select></td>
									<td><input type="text" class="datepick" id="agmduedate_1" value="" maxlength="10" size="10" onblur="chkDateFormat(this)"></input></td>
									<td><input type="text" class="datepick" id="agmdate_1" value="" maxlength="10" size="10" onblur="chkDateFormat(this)"></td>
									<td><input type="text" id="agmno_1" onkeypress="return allowNum(event)" value="" maxlength="10" size="10"></td>
									<td><select name="site_1" id="site_1">
											<option value=""></option>
											<option value="Send Alerts">Send Alerts</option>
											<option value="Share Documents">Share Documents</option>
										</select></td>
									<td><input type="text" onkeypress="return allowNum(event)" id="reminder_1" value="" maxlength="2" size="2"></td>
								</tr>
							</table>
						</div>
						<br/>
                        <!-- <div><input type="submit" name="addCom" id="addCom" value="Add Companies" ></div> -->
						<div align="right" id="addCom" style="display:none;"><img src="views/images/proceed1.jpg" alt="proceed" border="0" width="125" height="25" title="proceed"/></div><br/>
					</div>
					<br/><br/>
					<div style="font-family:Arial, Verdana Helvetica, sans-serif;font-size:14px;color:#000000;background-color:#F8F8F8;"><b>Note:</b> Annual General Meeting shall be held on a day which is not a National Holiday as per Section 96(2).As per the definition given under SS 2, ?National Holiday? includes Republic Day, i.e., 26th January,Independence Day, i.e., 15th August, Gandhi Jayanti, i.e., 2nd Octoberand such other day as may be declared as National Holiday by theCentral Government.</div>
                      <input type="hidden" name="finalData" id="finalData" >
                       <input type="hidden" name="hdName" value="${hdName}" >
                       <input type="hidden" name="userId" value="${userId}" >
                    </form>
				</div>
			</div>
		
	</body>
</html>
 