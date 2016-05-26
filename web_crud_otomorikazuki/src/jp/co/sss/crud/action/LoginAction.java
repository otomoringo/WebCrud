package jp.co.sss.crud.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.dao.EmployeeDao;
import jp.co.sss.crud.form.LoginForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LoginForm loginForm = (LoginForm) form;

        int userId = Integer.parseInt(loginForm.getSystemId());
        String password = loginForm.getSystemPassword();

        EmployeeBean employeeBean = EmployeeDao.findEmployeeById(userId);

        if (password.equals(employeeBean.getEmpPass())) {
            // セッションに登録しておく
            // session.setAttribute("id", userId);
            // session.setAttribute("password", password);

            List<EmployeeBean> list = EmployeeDao.findEmployeeAll();
            request.setAttribute("employeeList", list);

            return mapping.findForward("success");
        } else {
            String errorMessage = "ID、パスワードが違います。";
            request.setAttribute("errorMessage", errorMessage);
            return mapping.findForward("failed");
        }
    }
}
