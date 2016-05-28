package jp.co.sss.crud.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author otomorikazuki 社員情報のFormをまとめるためのクラス
 */
public class EmployeeForm extends ValidatorForm {

    /**
     * クラスのバージョンを識別するための番号
     */
    private static final long serialVersionUID = 1L;

    private String empId = null;
    private String empPass = null;
    private String empName = null;
    private String gender = null;
    private String address = null;
    private String birthday = null;
    private String authority = null;
    private String deptId = null;
    private String select = null;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpPass() {
        return empPass;
    }

    public void setEmpPass(String empPass) {
        this.empPass = empPass;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    /*
     * (非 Javadoc) ラジオボタンの初期値を設定する関数reset
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        setSelect("1");
    }
}
