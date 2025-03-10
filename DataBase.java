
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
	
	

	private static int id;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Enter the operation to be performed:/n1.insert/n2.getAll/n3.getOne/n4.Update/n5.delete");
		String option = sc.next();
		switch(option) {
		case "insert":
			int ins = DataImpl.insertEmployee();
			if(ins>0) {
				System.out.println("Data stored Successfully");
			}
			else {
				System.out.println("Data stored Unsuccessfully");
			}
			
			break;
			
			
		case "getAll" :
			
			ArrayList<Employee> employeeList = DataImpl.getAll();
			for(Employee e: employeeList) {
				
				System.out.println(e);
				
			}
			break;
			
			
		case "getOne" :
			System.out.println("enter the employee id:");
			 id = sc.nextInt();
			 Employee emp = DataImpl.getOne(id);
			 System.out.print(emp);
			break;
			
		case "delete" :
			System.out.println("enter the employee id to deleted:");
			id = sc.nextInt();
			int del = DataImpl.deleteRecord(id);
			if(del>0) {
				System.out.print("successfully deleted the record");
			}
			else {
				System.out.print("failed to delete the record");
			}
			break;
			
		
		}
		
		

	}

}
