<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

    String reportType ="doc";
String temName=session.getAttribute("templateName").toString()+".";
    if (reportType.equalsIgnoreCase("doc")) {
       response.reset();
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename= \"" +temName+reportType + "\"");
        response.setHeader("Pragma", "cache");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-control", "private");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    } else if (reportType.equalsIgnoreCase("xls")) {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename= \"" + "PolicyContent." + reportType + "\"");
    }
    
    
%>
${response}
</body>
</html>