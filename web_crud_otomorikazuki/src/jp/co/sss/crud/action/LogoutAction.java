package jp.co.sss.crud.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author otomorikazuki ログアウトするときのActionクラス
 *
 */
public class LogoutAction extends Action {
    /**
     * セッションを破棄し、struts-configファイルのlogoutに遷移する
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return mapping.findForward("logout");
    }
}
