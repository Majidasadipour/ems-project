package com.emsproject.controllers;

import java.sql.Connection;
import java.util.Scanner;

import com.emsproject.daos.UserDao;
import com.emsproject.daos.UserDaoImp;
import com.emsproject.entities.Department;
import com.emsproject.entities.Employee;
import com.emsproject.entities.User;
import com.emsproject.services.AuthenticationService;
import com.emsproject.services.DepartmentService;
import com.emsproject.services.EmployeeService;
import com.emsproject.utilities.SQLConnection;

public class MainController {

	public static void main(String[] args) {
		
		// prepare application to interact with the database.
		Connection connection = SQLConnection.getConnection(); //database connection
		EmployeeService empService = new EmployeeService(connection);
		DepartmentService depService = new DepartmentService(connection);
		UserDao userDao = new UserDaoImp(connection);
        AuthenticationService authService = new AuthenticationService(connection);
    	Scanner sc = new Scanner(System.in);

		int choice;
		
		// front end show to the user
		do {
		System.out.println("\n---------------------------------------------------------------------"
				+ "        \n"
				+ "\\ \\      / / ____| |   / ___/ _ \\|  \\/  | ____| |_   _/ _ \\       \n"
				+ " \\ \\ /\\ / /|  _| | |  | |  | | | | |\\/| |  _|     | || | | |      \n"
				+ "  \\ V  V / | |___| |__| |__| |_| | |  | | |___    | || |_| |      \n"
				+ " __\\_/\\_/  |_____|_____\\____\\___/|_|  |_|_____|   |_| \\___/       \n"
				+ "|_   _| | | | ____|                                               \n"
				+ "  | | | |_| |  _|                                                 \n"
				+ "  | | |  _  | |___                                                \n"
				+ " _|_|_|_| |_|_____| _    _    ____ _____ __  __ _____ _   _ _____ "
				+ "\n"
				+ "|  \\/  |  / \\  | \\ | |  / \\  / ___| ____|  \\/  | ____| \\ | |_   _|\n"
				+ "| |\\/| | / _ \\ |  \\| | / _ \\| |  _|  _| | |\\/| |  _| |  \\| | | |  \n"
				+ "| |  | |/ ___ \\| |\\  |/ ___ \\ |_| | |___| |  | | |___| |\\  | | |  \n"
				+ "|_|__|_/_/___\\_\\_|_\\_/_/___\\_\\____|_____|_|  |_|_____|_| \\_| |_|  \n"
				+ "/ ___\\ \\ / / ___|_   _| ____|  \\/  |                              \n"
				+ "\\___ \\\\ V /\\___ \\ | | |  _| | |\\/| |                              \n"
				+ " ___) || |  ___) || | | |___| |  | |                              \n"
				+ "|____/ |_| |____/ |_| |_____|_|  |_|      "
				+ "  ");
		
		System.out.println("---------------------------------------------------------------------");
		
		
		// now create a simple login system with a menu for login, registration, and exiting.
		// use a while loop to repeatedly prompt the user for input until they successfully log in.
		boolean loggedIn = false;
        while (!loggedIn) {
        	System.out.println("\n Please choose an option: \n");
        	System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("---------\n");	
    		System.out.print("  Enter Your Choice: \n");
    		
            int option = sc.nextInt();

            switch (option) {
            // If authentication is successful, loggedIn is set to true, and a success message is displayed.
            // If authentication fails, an error message is displayed.

            case 1:
            	System.out.println("---------\n");
                System.out.print("Enter username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                String password = sc.next();

                if (authService.login(username, password)) {
                    loggedIn = true;
                    System.out.println(" *** Login successful *** ");
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
                break;
                
                //If the user chooses to register (option 2), the program prompts for a new username and password.
                //adds the new user to the database with: userDao.addUser(newUser).
                //A success message is displayed after registration
            case 2:
                System.out.print("Enter new username: ");
                String newUsername = sc.next();
                System.out.print("Enter new password: ");
                String newPassword = sc.next();
                
                User newUser = new User(newUsername, newPassword);
                
                userDao.addUser(newUser);
                System.out.println(" *** User registered successfully *** ");
                break;
                
                //If the user chooses to exit (option 3), the program prints an exiting message and terminates.
             case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    
                // If the user enters an invalid option, a default message is displayed, prompting the user to choose 1, 2.
                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
            }
        }

   
        // show menu with options for employee management, department management, and exiting the program.
        System.out.println("\n Please choose an option: \n");
		System.out.println(
					"1. Employee Management \n" +
					"2. Department Management \n" +
					"3. Exit \n"
					);
		System.out.println("---------\n");	
		System.out.print("  Enter Your Choice: ");
		
		choice = sc.nextInt();
		
		switch (choice) {
		
		// If the user chooses 1, the program enters a loop for employee-related actions.
			case  1: 
				int employeeOption;
				do { 
					 System.out.println("\n-------------------------------------\n");
					 System.out.println("Employee Management\n");
					 System.out.println("-------------------------------------\n");
                     System.out.println("Please choose an option: \n");
                     System.out.println("1. Add Employee");
                     System.out.println("2. View Employees");
                     System.out.println("3. Update Employee");
                     System.out.println("4. Remove Employee");
                     System.out.println("5. Back to Main Menu");
                     
                     System.out.println("---------\n");
                     System.out.print("  Enter Your Choice: \n");
                     System.out.println("---------\n");
                     
                     employeeOption = sc.nextInt();
                     
                     //If the user chooses suboption 1, program prompts for the employee's ID, name, position, and department ID.
                     switch (employeeOption) {
                     case 1:
                    	 System.out.print("Enter ID: ");
                    	 int id;
         				try {
         					id = Integer.parseInt(sc.next());
       			
         					System.out.print("Enter Name: ");
         					String name = sc.next();
         					
         					System.out.print("Enter Position: ");
         					String position = sc.next();
         					
         					//input strings into integers, so i should using Integer.parseInt().
         					System.out.print("Enter Departament ID: ");
         					int idD = Integer.parseInt(sc.next());
         					
         					
         				// see Tim' code.
         				Employee emp = new Employee();
         				emp.setId(id);
         				emp.setName(name);
         				emp.setPosition(position);
         				emp.setDepartmentId(idD);

         				empService.addEmployee(emp);
         				
         				} catch (Exception e) {
         					System.out.println("\n --- Invalid input for ID. Please enter a valid ID. ---");
         				}
         				break;
         				
                     case 2:
                         System.out.println("Viewing Employees...");
              
                         break;
                     case 3:
                         System.out.println("Updating Employee...");
                        
                         break;
                     case 4:
                         System.out.println("Removing Employee...");
                        
                         break;
                     case 5:
                         System.out.println("\n Returning to Main Menu...\n");
                         break;
                     default:
                         System.out.println("Invalid option selected.");
                 }
             } while (employeeOption != 5);
             break;
				
             //option 2, the program enters a loop for department management.
			case 2: 
				int departmentOption;
                do {
                	System.out.println("\n-------------------------------------\n");
                    System.out.println("Department Management\n");
                    System.out.println("-------------------------------------\n");
                    System.out.println("Please choose an option: \n");
                    System.out.println("1. Add Department");
                    System.out.println("2. View Departments");
                    System.out.println("3. Update Department");
                    System.out.println("4. Get Total Employees by Department ID");
                    System.out.println("5. Remove Department");
                    System.out.println("6. Back to Main Menu");
                    
                    System.out.println("---------\n");
                    System.out.print("  Enter Your Choice: ");

                    departmentOption = sc.nextInt();
                    
                    switch (departmentOption) {
                    case 1:
                      	 System.out.print("Enter ID: ");
                       	 int id;
            				try {
            					id = Integer.parseInt(sc.next());
          			
            					System.out.print("Enter Name: ");
            					String name = sc.next();
            						
            				Department dep = new Department();
            				dep.setId(id);
            				dep.setName(name);

            				depService.addDepartment(dep);
            				
            				} catch (Exception e) {
            					System.out.println("\n --- Invalid input for ID. Please enter a valid ID. ---");
            				}
            				break;
                    case 2:
                        System.out.println("Viewing Departments...");
                        
                        break;
                    case 3:
                        System.out.println("Updating Department...");
                       
                        break;
                    
                    case 4:
                    	int idD;
                    	System.out.print("\n---------\n");
                    	while (true) {
                    	System.out.print("  Enter Department ID for Total Employee: ");
                    	
                
                    	try { 
                    		idD = Integer.parseInt(sc.next());
                    		int totalEmp = depService.totalEmpCount(idD);
                    		System.out.print("\n---------\n");
                    		System.out.println("\n --- Total number of employees in department ID " + idD + ": " + totalEmp +  " ---\n");
                    	break;
                    	} catch(Exception ex) {
                    		System.out.println("\n --- Invalid input for ID. Please enter a valid ID. ---\n");
                    	}
                    	}
                    	break;
                    	
                    	
                    case 5:
                        System.out.println("Removing Department...");
                        
                        break;
             
                      
                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid option selected.");
                }
            } while (departmentOption != 6);
            break;
				
			 case 3:
                 System.out.println("Exiting...");
                 break;
			
			default: 
				System.out.println("Invalid option selected");
			}
		
        } while (choice != 3);
		
	
	}
		
		
		
			


}