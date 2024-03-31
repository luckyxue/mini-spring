package com.test.service;

import com.test.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OldUserService {
    public User getUserInfo(int userid) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User returnUser = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=CTT&amp;zeroDateTimeBehavior=convertToNull&amp;useSSL=false&amp;autoReconnect=true&amp;failOverReadOnly=false");
            stmt = con.prepareStatement("select name,birthday from users where id=?");
            stmt.setInt(1, userid);
            rs = stmt.executeQuery();

            if (rs.next()) {
                returnUser = new User();
                returnUser.setId(userid);
                returnUser.setName(rs.getString("name"));
                returnUser.setBirthday(new java.util.Date(rs.getDate("birthday").getTime()));
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {

            }
        }

        return returnUser;
    }
}
