package jp.co.sss.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sss.crud.bean.DeptBean;
import jp.co.sss.crud.common.DBManager;

public class DeptDao {
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM post WHERE dept_id = ?";

    public static DeptBean findEmployeeById(int deptId) throws SQLException,
            ClassNotFoundException {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        connection = DBManager.getConnection();
        prepareStatement = connection.prepareStatement(SQL_SELECT_BY_ID);

        prepareStatement.setInt(1, deptId);

        resultSet = prepareStatement.executeQuery();

        if (resultSet.next()) {
            DeptBean deptBean = new DeptBean();

            deptBean.setDeptId(resultSet.getInt("dept_id"));
            deptBean.setDeptName(resultSet.getString("dept_name"));

            return deptBean;
        } else {
            return null;
        }
    }
}
