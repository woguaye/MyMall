package com.poitest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.poitest.dao.PoiTestDao;

public class PoiTestDaoImpl implements PoiTestDao {

	@Override
	public String login(String password) {
		String username = "";
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			Connection conn = DriverManager
					.getConnection(
							"jdbc:mysql://192.168.0.155:3306/user?useSSL=true&useUnicode=true&characterEncoding=UTF-8",
							"root", "123456");
			// 创建连接状态
			// Statement st = conn.createStatement();
			String sql = "select * from user where PASSWORD =?";
			PreparedStatement pst = conn.prepareStatement(sql);
			// 设置sql中的参数
			pst.setString(1, password);
			// 对数据库进行操作,返回结果
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				username = rs.getString("USERNAME");
				System.out.println(username+"=======================");

			}
			// 关闭资源
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;
	}

}
