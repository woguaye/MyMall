package com.poitest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.poitest.dao.PoiTestDao;

public class PoiTestDaoImpl implements PoiTestDao {

	@Override
	public String login(String username) {
		String name = "";
		String sql = "select USERNAME from user where PASSWORD = ? ";
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.155:3306/user?useSSL=true&useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			//创建连接状态
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//此处有占位符号
			//设置sql中的参数
			prepareStatement.setString(1, "123456");
			//对数据库进行操作,返回结果
			ResultSet resultSet = prepareStatement.executeQuery();
			boolean next = resultSet.next();
			System.out.println(next);
			while(resultSet.next()) { //这里必须进行循环遍历,即使该结果集中只有一条数据
				name = resultSet.getString("USERNAME");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return name;
	}

}
