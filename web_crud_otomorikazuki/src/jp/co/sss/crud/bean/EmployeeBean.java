package jp.co.sss.crud.bean;

/**
 * @author otomorikazuki 社員情報のBeanをまとめるためのクラス
 */
public class EmployeeBean {
    int empId;
    String empPass;
    String empName;
    int gender;
    String address;
    String birthday;
    int authority;
    DeptBean deptBean;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
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

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public DeptBean getDeptBean() {
        return deptBean;
    }

    public void setDeptBean(DeptBean deptBean) {
        this.deptBean = deptBean;
    }
}
