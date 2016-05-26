<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>社員一覧表示画面</title>
</head>
<body>
  <h2>社員一覧表示画面</h2>
  <p>
    検索条件
    <html:form action="find.do" method="post">
      <html:radio property="select" value="1"></html:radio>
      ID：
      <html:text property="empId" maxlength="5"></html:text>
      <html:radio property="select" value="2"></html:radio>
      社員名：
      <html:text property="empName" maxlength="30"></html:text>
      <html:radio property="select" value="3"></html:radio>
      部署名：
      <html:select property="deptId">
        <html:option value="1">営業部</html:option>
        <html:option value="2">経理部</html:option>
        <html:option value="3">総務部</html:option>
      </html:select>
      <html:submit>検索</html:submit>
    </html:form>
  </p>

  <p>該当する社員は存在しません。</p>
      <html:form action="login.do" method="post">
        <html:submit>一覧表示に戻る</html:submit>
      </html:form>


</body>
</html>