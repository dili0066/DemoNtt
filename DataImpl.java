import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DataImpl {
	
	private static Connection con;
	private static  String url = "jdbc:mysql://localhost:3306/NttData";
	private static String username = "root";
	private static String password = "dili4400";
	
	private static String insert = "insert into employee(e_name,email,address,mobile) values(?,?,?,?)";
	private static String getAll = "select * from employee";
	private static String getOne = "select * from employee where e_id=?";
	private static String Update = "update employee set address=? where e_id=?";
	private static String delete = "delete from employee where e_id=?";
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet res;
	
	static {
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	private static int res1=0;
	private static ArrayList<Employee> employeeList=null;
	
	public static int insertEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the employee name:");
		String e_name = sc.next();
		System.out.println("enter the email of employee:");
		String email = sc.next();
		System.out.println("enter the address of employee:");
		String address = sc.next();
		System.out.println("enter the mobile number of employee:");
		String mobile = sc.next();
		
		try {
			
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, e_name);
			pstmt.setString(2, email);
			pstmt.setString(3, address);
			pstmt.setString(4, mobile);
			res1 = pstmt.executeUpdate();
			
			
			
		}
		catch(Exception e) {
			
		}
		return res1;
		
	}
	
	
	public static ArrayList<Employee> getAll() {
		
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(getAll);
			while(res.next()) {
				employeeList .add(new Employee(res.getInt("e_id"),res.getString("e_name"),res.getString("email"),res.getString("address"),res.getString("mobile")));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	}
	
	public static Employee getOne(int id) {
		
		try {
			pstmt = con.prepareStatement(getOne);
			pstmt.setInt(1, id);
			res = pstmt.executeQuery();
			while(res.next()) {
				employeeList.add(new Employee(res.getInt("e_id"),res.getString("e_name"),res.getString("email"),res.getString("address"),res.getString("mobile")));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList.get(0);
		
	}
	
	public static  int updateEmp(int id, String address) {
		try {
			pstmt = con.prepareStatement(Update);
			pstmt.setString(1, address);
			pstmt.setInt(2, id);
			res1 = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res1;
		
	}
	
	public static int deleteRecord(int id) {
		try {
			pstmt = con.prepareStatement(delete);
			
			
			pstmt.setInt(1, id);
			res1 = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res1;
		
	}

}
