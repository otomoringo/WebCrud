<%@page import="jp.co.sss.crud.form.LoginForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ログイン画面</title>
</head>
<body>
  <html:form action="login.do" method="post">
    <p>
      社員ID：
      <html:text property="systemId" maxlength="5"></html:text>
      <html:errors property="systemId" />
    </p>
    <p>
      パスワード：
      <html:password property="systemPassword" maxlength="15"></html:password>
      <html:errors property="systemPassword" />
    </p>
    <p>
      <html:submit>ログイン</html:submit>
    </p>
    <bean:write name="errorMessage" ignore="true" />

  </html:form>
</body>
</html>
