import java.sql.*;
public class DBManager
{
	public static Connection con;
	public Statement st;
	
	public void loader(String driver)
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception e)
		{
			System.out.println("Exception in LoadDriver"+e.getMessage());
		}
	}
	
	public void getConnection()
	{
		try
		{
			con=DriverManager.getConnection("jdbc:postgresql:mandar","mandar","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Exception in getConnection"+e.getMessage());
		}
	}
	
	public int getMaxId()
	{
		int id=1;
		try
		{
			ResultSet rs = st.executeQuery("select max(s_id) from user");
			rs.next();
			id=rs.getInt(1);
			System.out.println(id);
			id=id+1;
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Exception in getMaxId"+e.getMessage());
		}
		return 0;
	}
	
	public ResultSet fetchQuery(String query)
	{
		ResultSet rs=null;
		try
		{
				rs = st.executeQuery(query);
				
		}catch(Exception e)
		{
			System.out.println("Exception in fetchQuery"+e.getMessage());
		}		
		return rs;
	}
	
	public void insertRecord(String query)
	{
		try
		{
				int rs = st.executeUpdate(query);
				if(rs>0)
					System.out.println("Inserted Successfully!!!!!!!!!!!");
		}catch(Exception e)
		{
			System.out.println("Exception in insertRecord"+e.getMessage());
		}	
	}
	
	public void deleteRecord(String query)
	{
		try
		{
				int rs = st.executeUpdate(query);
				if(rs>0)
					System.out.println("Deleted Successfully!!!!!!!!!!!");
		}catch(Exception e)
		{
			System.out.println("Exception in deleteRecord"+e.getMessage());
		}	

	}
	public void closeConnection()
	{
		try
		{
			con.close();
			st.close();
		}catch(Exception e)
		{
			System.out.println("Exception in closeConnection"+e.getMessage());
		}
	}
}
