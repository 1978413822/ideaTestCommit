package Dao;

import Util_durid.Durid_Util;
import bean.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImp implements PersonDao {
    Connection coon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public boolean insertz(Person person) {
        try {
            coon = Durid_Util.getCoon();
            String sql = "insert into PERSON values (?,?,?)";
            ps = coon.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getEmail());
            ps.setInt(3, person.getPass());
            int rows = ps.executeUpdate();
            return ps.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean selectz(Person person) {
        try {
            coon = Durid_Util.getCoon();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatez(String oldpass, String newpass) {
        return false;
    }
}
