package Util_durid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
//durid连接池工具类
public class Durid_Util {

    //定义变量DataSource
    private static DataSource ds;
    static {
        //properties路径
        InputStream inputStream = Durid_Util
                .class.getClassLoader().
                getResourceAsStream("Util_durid/durid.properties");
        Properties properties = new Properties();
        try {
            //将路径加载
            properties.load(inputStream);
            //获取DataSouece
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //4. 提供 从连接池中 获取连接对象Connection的方法
    public static Connection getCoon() throws SQLException {
        Connection coon = ds.getConnection();
        return coon;
    }
    // 3. 提供获得连接池对象的方法
    public static DataSource getDataSource(){
        return ds;
    }
    //释放
    public static void getClose(Connection coon, PreparedStatement ps, ResultSet rs) {
        if(coon != null){
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
