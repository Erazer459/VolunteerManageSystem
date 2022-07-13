package main.Utils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JDBCUtils {
    private static DataSource dataSource = null;

    static {
        try {
            Properties p = new Properties();
            p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("properties/druid.properties"));
            DruidDataSourceFactory druidDataSourceFactory = new DruidDataSourceFactory();
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        // 代码的严谨性
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
