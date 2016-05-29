package jp.co.sss.crud.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.bean.DeptBean;
import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.dao.EmployeeDao;
import jp.co.sss.crud.form.EmployeeForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author otomorikazuki ログインするときのActionクラス
 * 
 */
public class RegistCompleteAction extends Action {
    /**
     * ユーザIDとパスワードが一致したら、struts-configファイルのsuccessに遷移する
     * そうでなければ、エラーメッセージを表示するfailedに遷移する
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeForm employeeForm = (EmployeeForm) form;

        EmployeeBean employeeBean = new EmployeeBean();
        DeptBean deptBean = new DeptBean();

        employeeBean.setEmpPass(employeeForm.getEmpPass());
        employeeBean.setEmpName(employeeForm.getEmpName());
        employeeBean.setGender(Integer.parseInt(employeeForm.getGender()));
        employeeBean.setAddress(employeeForm.getAddress());
        employeeBean.setBirthday(employeeForm.getBirthday());
        employeeBean
                .setAuthority(Integer.parseInt(employeeForm.getAuthority()));
        deptBean.setDeptId(Integer.parseInt(employeeForm.getDeptId()));
        employeeBean.setDeptBean(deptBean);

        EmployeeDao.registEmployee(employeeBean);

        return mapping.findForward("registComplete");

    }
}
