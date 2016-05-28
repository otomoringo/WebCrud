package jp.co.sss.crud.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.dao.EmployeeDao;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author otomorikazuki 削除の確認をするActionクラス
 */
public class DeleteCompleteAction extends Action {
    /**
     * 検索結果を保持し、struts-configファイルのcompleteに遷移する。 そうでなければエラーメッセージを表示するfailedに遷移する
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            System.out.println(request.getAttribute("empId"));

//            EmployeeDao.deleteEmployee();
            return mapping.findForward("deleteComplete");
        } catch (Exception e) {
            return mapping.findForward("failed");
        }
    }
}
