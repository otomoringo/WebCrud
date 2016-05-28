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
 * @author otomorikazuki 検索方法から検索結果を返すActionクラス
 */
public class FindAction extends Action {
    /**
     * 検索結果を保持し、struts-configファイルのcompleteに遷移する。そうでなければエラーメッセージを表示するfailedに遷移する
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        try {
            List<EmployeeBean> list = new ArrayList<EmployeeBean>();
            EmployeeForm employeeForm = (EmployeeForm) form;

            switch (Integer.parseInt(employeeForm.getSelect())) {
            case 1:
                // 社員ID検索
                int userId = Integer.parseInt(employeeForm.getEmpId());
                EmployeeBean employeeBean = EmployeeDao
                        .findEmployeeById(userId);
                if (employeeBean.equals(null)) {
                    throw new Exception();
                }
                list.add(employeeBean);
                break;

            case 2:
                // 社員名検索
                String empName = employeeForm.getEmpName();
                list = EmployeeDao.findEmployeeByNameContains(empName);
                break;

            case 3:
                // 部署ID検索
                int deptId = Integer.parseInt(employeeForm.getDeptId());
                list = EmployeeDao.findEmployeeByDeptId(deptId);
                break;

            default:
                throw new Exception();
            }

            if (!list.isEmpty()) {
                request.setAttribute("employeeList", list);
                return mapping.findForward("complete");
            } else {
                String errorMessage = "該当する社員が存在しません。";
                request.setAttribute("errorMessage", errorMessage);
                return mapping.findForward("failed");
            }
        } catch (Exception e) {
            String errorMessage = "該当する社員が存在しません。";
            request.setAttribute("errorMessage", errorMessage);
            return mapping.findForward("failed");
        }
    }
}
