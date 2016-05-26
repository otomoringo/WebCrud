package jp.co.sss.crud.form;

import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // リクエス卜パラメータ名と同じフィールド
    private String systemId = null;
    private String systemPassword = null;

    // getter/setter メソッド

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
