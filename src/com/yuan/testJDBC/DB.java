package com.yuan.testJDBC;

import java.sql.Connection;  
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class DB {
	 public static final String url = "jdbc:mysql://127.0.0.1/movie";  
	 public static final String name = "com.mysql.jdbc.Driver";  
	 public static final String user = "root";  
	 public static final String password = "123456";  
	  
	 public Connection conn = null;  
	 public PreparedStatement pst = null;  
	  
	 public DB(String sql) {
		 try {  
			    Class.forName(name);//ָ����������  
	            conn = DriverManager.getConnection(url, user, password);//��ȡ����  
	            pst = conn.prepareStatement(sql);//׼��ִ�����  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	 public void close() {  
		 try {  
	            this.conn.close();  
	           // this.pst.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }
	 public void showMetaData() throws Exception
	 {
		 DatabaseMetaData dbmd = conn.getMetaData();        //������������ݿ��������Ϣ
	     System.out.println("JDBC��������"+dbmd.getDriverName()+"��"+dbmd.getDriverVersion()
	            +"\nJDBC URL��"+dbmd.getURL()+"\n���ݿ⣺"+dbmd.getDatabaseProductName()
	            +"���汾��"+dbmd.getDatabaseProductVersion()+"���û�����"+dbmd.getUserName()+"\n");
	 }

}
