package com.zzupms.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory = null;
static {
	try {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		factory = builder.build(Resources.getResourceAsReader("mybatis-config.xml"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	public static SqlSession openSession(){
		SqlSession session = factory.openSession();
		return session;
		
	}
	public static void close(SqlSession session){
		if(session!=null)
			session.close();
	}
}
