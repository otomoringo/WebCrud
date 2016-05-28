package jp.co.sss.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.bean.DeptBean;
import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.common.DBManager;
import jp.co.sss.crud.common.Format;

/**
 * @author otomorikazuki データベースのemployeeテーブルと接続するための関数をまとめたクラス
 *
 */
public class EmployeeDao {
    /**
     * 登録されている全ての社員を検索するSQL文
     */
    private static final String SQL_SELECT_ALL
        = "SELECT emp_id, emp_pass, emp_name, gender, address, birthday, authority, dept_name "
        + "FROM employee et INNER JOIN department dt ON et.dept_id = dt.dept_id";
    /**
     * 社員IDから社員を検索するSQL文
     */
    private static final String SQL_SELECT_BY_ID
        = "SELECT emp_id, emp_pass, emp_name, gender, address, birthday, authority, dept_name "
        + "FROM employee et INNER JOIN department dt ON et.dept_id = dt.dept_id WHERE emp_id = ?";
    /**
     * 名前の部分一致から社員を検索するSQL文
     */
    private static final String SQL_SELECT_BY_NAME_CONTAINS
        = "SELECT emp_id, emp_pass, emp_name, gender, address, birthday, authority, dept_name "
        + "FROM employee et INNER JOIN department dt ON et.dept_id = dt.dept_id WHERE emp_name LIKE ?";
    /**
     * 部署IDから社員を検索するSQL文
     */
    private static final String SQL_SELECT_BY_DEPT_ID
        = "SELECT emp_id, emp_pass, emp_name, gender, address, birthday, authority, dept_name "
        + "FROM employee et INNER JOIN department dt ON et.dept_id = dt.dept_id WHERE et.dept_id = ?";
    /**
     * 社員を登録するためのSQL文
     */
    private static final String SQL_INSERT
        = "INSERT INTO employee VALUES(emp_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE
    = "DELETE FROM employee WHERE emp_id = ?";

    /**
     * @return 結果のリスト
     * @throws SQLException
     *             SQLの例外を投げる
     * @throws ClassNotFoundException
     *             クラスが見つからないときの例外を投げる
     */
    public static List<EmployeeBean> findEmployeeAll() throws SQLException,
            ClassNotFoundException {
        List<EmployeeBean> list = new ArrayList<EmployeeBean>();
        Connection connection = null;
        PreparedStatement prepareStatement = null;

        connection = DBManager.getConnection();
        prepareStatement = connection.prepareStatement(SQL_SELECT_ALL);
        ResultSet resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            EmployeeBean employeeBean = new EmployeeBean();
            DeptBean deptBean = new DeptBean();

            employeeBean.setEmpId(resultSet.getInt("emp_id"));
            employeeBean.setEmpPass(resultSet.getString("emp_pass"));
            employeeBean.setEmpName(resultSet.getString("emp_name"));
            employeeBean.setGender(resultSet.getInt("gender"));
            employeeBean.setAddress(resultSet.getString("address"));
            employeeBean.setBirthday(Format.modifyDate(resultSet
                    .getString("birthday")));
            employeeBean.setAuthority(resultSet.getInt("authority"));
            deptBean.setDeptName(resultSet.getString("dept_name"));
            employeeBean.setDeptBean(deptBean);

            list.add(employeeBean);
        }
        return list;
    }

    /**
     * @param userId
     *            ユーザID
     * @return 結果のリストを返す
     * @throws SQLException
     *             SQLの例外を投げる
     * @throws ClassNotFoundException
     *             クラスが見つからないときの例外を投げる
     */
    public static EmployeeBean findEmployeeById(int userId)
        throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        connection = DBManager.getConnection();
        prepareStatement = connection.prepareStatement(SQL_SELECT_BY_ID);

        prepareStatement.setInt(1, userId);
        resultSet = prepareStatement.executeQuery();

        if (resultSet.next()) {
            EmployeeBean employeeBean = new EmployeeBean();
            DeptBean deptBean = new DeptBean();

            employeeBean.setEmpId(resultSet.getInt("emp_id"));
            employeeBean.setEmpPass(resultSet.getString("emp_pass"));
            employeeBean.setEmpName(resultSet.getString("emp_name"));
            employeeBean.setGender(resultSet.getInt("gender"));
            employeeBean.setAddress(resultSet.getString("address"));
            employeeBean.setBirthday(Format.modifyDate(resultSet
                    .getString("birthday")));
            employeeBean.setAuthority(resultSet.getInt("authority"));
            deptBean.setDeptName(resultSet.getString("dept_name"));
            employeeBean.setDeptBean(deptBean);

            return employeeBean;
        } else {
            return null;
        }
    }

    /**
     * @param empName
     *            社員名
     * @return 結果のリストを返す
     * @throws SQLException
     *             SQLの例外を投げる
     * @throws ClassNotFoundException
     *             クラスが見つからないときの例外を投げる
     */
    public static List<EmployeeBean> findEmployeeByNameContains(String empName)
        throws ClassNotFoundException, SQLException {

        List<EmployeeBean> list = new ArrayList<EmployeeBean>();
        Connection connection = null;
        PreparedStatement prepareStatement = null;

        connection = DBManager.getConnection();
        prepareStatement = connection
                .prepareStatement(SQL_SELECT_BY_NAME_CONTAINS);

        StringBuilder sb = new StringBuilder();
        sb.append("%");
        sb.append(empName);
        sb.append("%");
        prepareStatement.setString(1, sb.toString());

        ResultSet resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            EmployeeBean employeeBean = new EmployeeBean();
            DeptBean deptBean = new DeptBean();

            employeeBean.setEmpId(resultSet.getInt("emp_id"));
            employeeBean.setEmpPass(resultSet.getString("emp_pass"));
            employeeBean.setEmpName(resultSet.getString("emp_name"));
            employeeBean.setGender(resultSet.getInt("gender"));
            employeeBean.setAddress(resultSet.getString("address"));
            employeeBean.setBirthday(Format.modifyDate(resultSet
                    .getString("birthday")));
            employeeBean.setAuthority(resultSet.getInt("authority"));
            deptBean.setDeptName(resultSet.getString("dept_name"));
            employeeBean.setDeptBean(deptBean);

            list.add(employeeBean);
        }

        return list;
    }

    /**
     * @param deptId
     *            部署ID
     * @return 結果のリストを返す
     * @throws SQLException
     *             SQLの例外を投げる
     * @throws ClassNotFoundException
     *             クラスが見つからないときの例外を投げる
     */
    public static List<EmployeeBean> findEmployeeByDeptId(int deptId)
        throws SQLException, ClassNotFoundException {
        List<EmployeeBean> list = new ArrayList<EmployeeBean>();
        Connection connection = null;
        PreparedStatement prepareStatement = null;

        connection = DBManager.getConnection();
        prepareStatement = connection.prepareStatement(SQL_SELECT_BY_DEPT_ID);
        prepareStatement.setInt(1, deptId);
        ResultSet resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            EmployeeBean employeeBean = new EmployeeBean();
            DeptBean deptBean = new DeptBean();

            employeeBean.setEmpId(resultSet.getInt("emp_id"));
            employeeBean.setEmpPass(resultSet.getString("emp_pass"));
            employeeBean.setEmpName(resultSet.getString("emp_name"));
            employeeBean.setGender(resultSet.getInt("gender"));
            employeeBean.setAddress(resultSet.getString("address"));
            employeeBean.setBirthday(Format.modifyDate(resultSet
                    .getString("birthday")));
            employeeBean.setAuthority(resultSet.getInt("authority"));
            deptBean.setDeptName(resultSet.getString("dept_name"));
            employeeBean.setDeptBean(deptBean);

            list.add(employeeBean);
        }
        return list;
    }

    /**
     * @param employeeBean
     *            社員情報のbeanを返す
     * @return 結果のリストを返す
     * @throws SQLException
     *             SQLの例外を投げる
     * @throws ClassNotFoundException
     *             クラスが見つからないときの例外を投げる
     */
    public static int registEmployee(EmployeeBean employeeBean)
        throws ClassNotFoundException, SQLException {
        int checkRow;

        Connection connection = null;
        PreparedStatement prepareStatement = null;

        connection = DBManager.getConnection();
        prepareStatement = connection.prepareStatement(SQL_INSERT);

        prepareStatement.setString(1, employeeBean.getEmpPass());
        prepareStatement.setString(2, employeeBean.getEmpName());
        prepareStatement.setInt(3, employeeBean.getGender());
        prepareStatement.setString(4, employeeBean.getAddress());
        prepareStatement.setString(5, employeeBean.getBirthday());
        prepareStatement.setInt(6, employeeBean.getAuthority());
        prepareStatement.setInt(7, employeeBean.getDeptBean().getDeptId());

        checkRow = prepareStatement.executeUpdate();

        return checkRow;
    }

    public static void deleteEmployee(int empId)
        throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement prepareStatement = null;

        connection = DBManager.getConnection();
        prepareStatement = connection.prepareStatement(SQL_DELETE);

        prepareStatement.setInt(1, empId);
        prepareStatement.executeUpdate();
    }
}
