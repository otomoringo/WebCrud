package jp.co.sss.crud.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author otomorikazuki ログインするためのFormをまとめるためのクラス
 */
public class LoginForm extends ValidatorForm {

    /**
     * クラスのバージョンを識別するための番号
     */
    private static final long serialVersionUID = 1L;

    private String systemId = null;
    private String systemPassword = null;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }

}
