package com.gavs.springboot.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class EmployeeDAO {
    
    



   public Employee findEmployee(int id) {
        Employee em = new Employee();
        Connection cn = null;
        {
            
            int a = id;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// register
            
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productcart", "root", "admin");
            Statement st = cn.createStatement ();
            ResultSet rs = st.executeQuery("select * from employee where id = "+a);
            
            rs.next();
            
            em.setId(rs.getInt(1));
            em.setPosition(rs.getString(2));
            em.setName(rs.getString(3));
            
            
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return em;
    }
        
}
    public Employee deleteEmployee(int id) {
        Employee em = new Employee();
        Connection cn = null;
        {
            
            int a = id;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productcart", "root", "admin");
            PreparedStatement st = cn.prepareStatement("delete from employee where id = ?");
            st.setInt(1, a);
            int result = st.executeUpdate();
                    
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
        return em;
    
}
    public  Employee updateEmployee(String name,int id) {
    	
    	Employee em = new Employee();
		
		Connection cn = null;
		{
			String n = name;
			int a = id;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productcart", "root", "admin");
			PreparedStatement st = cn.prepareStatement("UPDATE employee SET name = ? WHERE id = ?");
			
			st.setString(1, n);
			st.setInt(2, a);
			
			
			
			int result = st.executeUpdate();
			System.out.println(result);
			Statement st1 = cn.createStatement ();
			ResultSet rs = st.executeQuery("select * from employee where id = "+a);
			

			rs.next();
			
			em.setId(rs.getInt(1));
			em.setName(rs.getString(2));		
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
		return em;
	
}



}