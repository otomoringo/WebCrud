<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>社員削除完了画面</title>
</head>
<body>
  <p>社員削除処理が完了しました。</p>

    <html:form action="showAll.do" method="post">
      <html:submit>一覧表示に戻る</html:submit>
    </html:form>

</body>
</html>