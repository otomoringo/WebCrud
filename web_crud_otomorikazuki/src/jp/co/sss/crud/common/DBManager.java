package jp.co.sss.crud.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author otomorikazuki データベースと接続するためのクラス
 */
public class DBManager {
    /**
     * @return コネクションを返す
     * @throws ClassNotFoundException
     *             クラスが見つからないときの例外を投げる
     * @throws SQLException
     *             SQLの例外を投げる
     */
    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "web_crud_user",
                "systemsss");
        return conn;
    }

    /**
     * @param conn
     *            コネクションを受け取る
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
