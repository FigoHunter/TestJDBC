package com.yuan.testJDBC;

import java.sql.ResultSet;  
import java.sql.SQLException; 

public class TestJDBC {
	static String sql = null;  
    static DB db1 = null;  
    static ResultSet ret = null;
	public static void main(String[] args) throws Exception
	{  
        sql = "select * from student";//SQL���  
        db1 = new DB(sql);//����DB���� 
        
        db1.showMetaData();
  
        try {  
            ret = db1.pst.executeQuery();//ִ����䣬�õ������  
            while (ret.next()) {  
                String uid = ret.getString(1);  
                String ufname = ret.getString(2);  
                String ulname = ret.getString(3);  
                String udate = ret.getString(4);  
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
            }//��ʾ����  
            ret.close();  
            db1.close();//�ر�����  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
}
