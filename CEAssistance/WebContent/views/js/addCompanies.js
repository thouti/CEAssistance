$(document).ready(function()
{
	
	$('#addCom').click(function(e){
	var flagchk = ChkallFields();
	if(flagchk){
		addComDtls();
		document.addcompany.action="addCompaniesDtls.html";
	 	document.addcompany.method="POST";
	 	document.addcompany.submit();
	}
});
	
	
});
function addComDtls()
{
	var totComp=$('#totComp').val();
	if(totComp!=0)
	{console.log("---->"+totComp);
	var finalComDtls="";
    var eleArr =
		  ['compname_','address_','type_','finyear_','agmduedate_','agmdate_','agmno_','site_','reminder_'];
		     for(var t=1;t<=totComp;t++) {
		     for(var j=0;j<eleArr.length;j++) {console.log(eleArr[j]+t+"---->"+j);
		     finalComDtls=finalComDtls+document.getElementById(eleArr[j]+t).value+"@";
             }
		     finalComDtls=finalComDtls+"&";
		     }
		    $('#finalData').val(finalComDtls);
}
}
function ChkallFields(){
	
	document.getElementById("comp_errdiv").innerHTML = "";
	var arr = ['compname_','address_','type_','finyear_','agmduedate_','agmdate_','agmno_','site_','reminder_'];
	var len = document.getElementById("totComp").value;
	var flag1=true;
	for(var i=1;i<=len;i++){
		if(flag1){
			for(var j=0;j<arr.length;j++){
				eleObj = document.getElementById(arr[j]+i);
				if(flag1 && eleObj != null && eleObj.value == ""){
						displayalertmessage("Please give full data.","comp_errdiv");
						flag1 = false;
						return false;
				}
			}
		}
		else 
			return false;
	}
	return true;
}
function displayalertmessage(msg,div) {
	if(document.getElementById(div))
		document.getElementById(div).innerHTML = "<font color='red'>"+msg+"</font>";
}