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
        <html:option value="0">&nbsp;</html:option>
        <html:option value="1">営業部</html:option>
        <html:option value="2">経理部</html:option>
        <html:option value="3">総務部</html:option>
      </html:select>
      <html:submit>検索</html:submit>
    </html:form>
  </p>

  <table border="1" cellpadding="3"
    style="border-collapse: collapse; text-align: center;">
    <tr>
      <td>社員ID</td>
      <td>社員名</td>
      <td>性別</td>
      <td>住所</td>
      <td>生年月日</td>
      <td>権限</td>
      <td>部署名</td>
    </tr>
    <logic:iterate id="employee" name="employeeList">
      <tr>
        <td><bean:write name="employee" property="empId" /></td>
        <td><bean:write name="employee" property="empName" /></td>
        <td><logic:equal name="employee" property="gender" value="1">
        男性
        </logic:equal> <logic:equal name="employee" property="gender" value="2">
        女性
        </logic:equal></td>
        <td><bean:write name="employee" property="address" /></td>
        <td><bean:write name="employee" property="birthday" /></td>
        <td><logic:equal name="employee" property="authority" value="1">
        一般
        </logic:equal> <logic:equal name="employee" property="authority" value="2">
        管理
        </logic:equal></td>
        <td><bean:write name="employee" property="deptBean.deptName" /></td>
        <td><html:form action="delete.do" method="post">
            <html:hidden name="employee" property="empId" />
            <html:submit>削除</html:submit>
          </html:form></td>
      </tr>
    </logic:iterate>
  </table>

</body>
</html>