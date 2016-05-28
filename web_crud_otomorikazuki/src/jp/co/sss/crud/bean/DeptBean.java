package jp.co.sss.crud.bean;

/**
 * @author otomorikazuki 部署情報のBeanをまとめるためのクラス
 * 
 */
public class DeptBean {
    int deptId;
    String deptName;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
