<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
  href="<html:rewrite page="/css/style.css"/>" />
<title><tiles:getAsString name="title" /></title>
</head>
<body>
  <div id="header">
    <tiles:getAsString name="title" />
    <tiles:insert attribute="header" />
  </div>
  <div id="main">
    <tiles:insert attribute="main" />
  </div>
  <div id="footer">
    <tiles:insert attribute="footer" />
  </div>
</body>
</html>
