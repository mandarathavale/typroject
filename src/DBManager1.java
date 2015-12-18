//package DBManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.Statement;

public class DBManager1 
{
	public Connection con;
	public Statement st;
	
	public void loader()
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
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
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","mysql");
			con=DriverManager.getConnection("jdbc:postgresql:test","mandar","mandar");
			//DriverManager.get
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
			ResultSet rs = st.executeQuery("select max(id) from usertab1");
			rs.next();
			rs.getObject(1);
			id=rs.getInt(1);
			id=id+1;
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Exception in getMaxId"+e.getMessage());
		}
		return 0;
	}
	
	
	public int getMaxIdFile()
	{
		int id=1;
		try
		{
			ResultSet rs = st.executeQuery("select max(fileid) from filetab1");
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
		}
		catch(Exception e)
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
	
	

	public int updateRecord(String query)
	{
		try
		{
				int rs = st.executeUpdate(query);
				System.out.println(rs);
				if(rs>0)
				{
					//return 1;
					System.out.println("updated Successfully!!!!!!!!!!!");
					return 1;
				}
				
		}catch(Exception e)
		{
			System.out.println("Exception in insertRecord"+e.getMessage());
		}	
		return 0;
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
	
	public ResultSet getDataForTable()
	{
			ResultSet result = null;
			try
			{
				result=st.executeQuery("select * from book");
				return result;
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			return result;
	}
	
	public ResultSet getDataForTable1(String user_name)
	{
		String user=user_name;
			ResultSet result = null;
			try
			{
				result=st.executeQuery("select * from newspaper where uploaded_by='"+user+"'");
				return result;
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			return result;
	}
	public ResultSet getDataForTable2(String user_name)
	{
		String user=user_name;
			ResultSet result = null;
			try
			{
				result=st.executeQuery("select s_id,s_first_name,s_last_name from student where username='"+user+"'");
				return result;
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			return result;
	}
	
	public boolean delete1(int pkey)
	{
		PreparedStatement ps;
		try {
			ps = this.con.prepareStatement("delete from book where book_id=?;");
			System.out.println(pkey);
		ps.setInt(1,pkey);
		ps.executeUpdate();
		return true;
			} catch (SQLException ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
		}
		return false;
	}

	public boolean delete2(int pkey)
	{
		PreparedStatement ps;
		try 
		{
			ps = this.con.prepareStatement("delete from student where s_id=?;");
			System.out.println(pkey);
			ps.setInt(1,pkey);
			ps.executeUpdate();
			return true;
		} 
		catch (SQLException ae) 
		{
			ae.printStackTrace();
			
		}
		return false;
		
	}
	public boolean delete3(int pkey)
	{
		PreparedStatement ps;
		try {
			ps = this.con.prepareStatement("delete from newspaper where news_id=?;");
			System.out.println(pkey);
		ps.setInt(1,pkey);
		ps.executeUpdate();
		return true;
			} catch (SQLException ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
			
		}
		return false;
		
	}


	public void closeConnection()
	{
		try
		{
			con.close();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in closeConnection"+e.getMessage());
		}
	}

}
