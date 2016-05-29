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
<title>社員登録画面</title>
</head>
<body>
	<html:form action="registConfirm.do" method="post">
		<p>
			パスワード：
			<html:password property="empPass" maxlength="15"></html:password>
			<html:errors property="empPass" />
		</p>
		<p>
			社員名：
			<html:text property="empName" maxlength="30"></html:text>
			<html:errors property="empName" />
		</p>
		<p>
			性別：
			<html:radio property="gender" value="1"></html:radio>
			男性
			<html:radio property="gender" value="2"></html:radio>
			女性
		</p>
		<p>
			住所：
			<html:text property="address" maxlength="30"></html:text>
		</p>
		<p>
			生年月日：
			<html:text property="birthday"></html:text>
			※yyyy/MM/dd形式
			<html:errors property="birthday" />
		</p>
		<p>
			権限：
			<html:radio property="authority" value="1"></html:radio>
			一般
			<html:radio property="authority" value="2"></html:radio>
			管理
		</p>
		<p>
			部署名：
			<html:select property="deptId">
				<html:option value="0">&nbsp;</html:option>
				<html:option value="1">営業部</html:option>
				<html:option value="2">経理部</html:option>
				<html:option value="3">総務部</html:option>
			</html:select>
		</p>
		<html:submit>確認</html:submit>
	</html:form>
	<html:form action="showAll.do" method="post">
		<html:submit>一覧表示に戻る</html:submit>
	</html:form>

</body>
</html>
