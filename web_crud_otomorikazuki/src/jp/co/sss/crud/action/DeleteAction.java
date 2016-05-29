package jp.co.sss.crud.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.dao.EmployeeDao;
import jp.co.sss.crud.form.EmployeeForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author otomorikazuki 削除の確認をするActionクラス
 */
public class DeleteAction extends Action {
    /**
     * 検索結果を保持し、struts-configファイルのcompleteに遷移する。 そうでなければエラーメッセージを表示するfailedに遷移する
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            EmployeeForm employeeForm = (EmployeeForm) form;
            int userId = Integer.parseInt(employeeForm.getEmpId());
            EmployeeBean employeeBean = EmployeeDao.findEmployeeById(userId);

            List<EmployeeBean> list = new ArrayList<EmployeeBean>();
            list.add(employeeBean);
            request.setAttribute("employeeList", list);

            return mapping.findForward("delete");

        } catch (Exception e) {
            return mapping.findForward("failed");
        }
    }
}
