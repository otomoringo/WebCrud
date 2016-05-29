<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<div id=logout>
  <html:form action="regist.do" method="post">
      <html:submit>登録</html:submit>
  </html:form>

  <html:form action="logout.do" method="post">
      <html:submit>ログアウト</html:submit>
  </html:form>
</div>
