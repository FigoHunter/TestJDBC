package com.yuan.testJDBC;

import java.sql.ResultSet;  
import java.sql.SQLException; 

public class TestJDBC {
	static String sql = null;  
    static DB db1 = null;  
    static ResultSet ret = null;
	public static void main(String[] args) throws Exception
	{  
        sql = "select * from student";//SQL语句  
        db1 = new DB(sql);//创建DB对象 
        
        db1.showMetaData();
  
        try {  
            ret = db1.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                String uid = ret.getString(1);  
                String ufname = ret.getString(2);  
                String ulname = ret.getString(3);  
                String udate = ret.getString(4);  
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
            }//显示数据  
            ret.close();  
            db1.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
}
