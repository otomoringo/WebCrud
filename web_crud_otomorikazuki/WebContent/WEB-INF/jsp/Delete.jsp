<%@page import="jp.co.sss.crud.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>社員削除確認画面</title>
</head>
<body>
  <p>以下の社員情報を削除します。</p>

  <table border="1" cellpadding="3"
    style="border-collapse: collapse; text-align: center;">
    <logic:iterate id="employee" name="employeeList">
      <tr>
        <td>パスワード：</td>
        <td>※非表示</td>
      </tr>
      <tr>
        <td>社員名：</td>
        <td><bean:write name="employee" property="empName" /></td>
      </tr>
      <tr>
        <td>性別：</td>
        <td><logic:equal name="employee" property="gender" value="1">男性</logic:equal>
          <logic:equal name="employee" property="gender" value="2">女性</logic:equal></td>
      </tr>
      <tr>
        <td>住所：</td>
        <td><bean:write name="employee" property="address" /></td>
      </tr>
      <tr>
        <td>生年月日：</td>
        <td><bean:write name="employee" property="birthday" /></td>
      </tr>
      <tr>
        <td>権限：</td>
        <td><logic:equal name="employee" property="authority" value="1">一般</logic:equal>
          <logic:equal name="employee" property="authority" value="2">管理</logic:equal></td>
      </tr>
      <tr>
        <td>部署名：</td>
        <td><bean:write name="employee" property="deptBean.deptName" /></td>
      </tr>
    </logic:iterate>
  </table>

  <html:form action="showAll.do" method="post">
    <html:submit>一覧表示に戻る</html:submit>
  </html:form>
  <html:form action="deleteComplete.do" method="post">
    <logic:iterate id="employee" name="employeeList">
      <html:hidden property="" />
    </logic:iterate>
    <html:submit>確認</html:submit>
  </html:form>
</body>
</html>