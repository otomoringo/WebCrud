package jp.co.sss.crud.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.dao.EmployeeDao;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author otomorikazuki 社員一覧画面に遷移するActionクラス
 */
public class ShowAllAction extends Action {
    /**
     * 登録されている全ての社員を保持し、struts-configファイルのshowAllに遷移する
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        List<EmployeeBean> list = EmployeeDao.findEmployeeAll();
        request.setAttribute("employeeList", list);

        return mapping.findForward("showAll");
    }
}
