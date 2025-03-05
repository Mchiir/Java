package StudentAppJson;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public class GFG {
		public static void main(String[] args) {
			 Employee employee = getEmployee();
		        ObjectMapper mapper = new ObjectMapper();
		 
		        try {
		 
		            mapper.writeValue(
		                new File(
		                    "F:\\GIT-Push\\IdeaProjects-JAVA\\StudentAppMaven-v3-txt2\\JavaStudentJson\\Students.json"),
		                employee);
		 
		            String empJson
		                = mapper.writeValueAsString(employee);
		            System.out.println(
		                "The employee object in json format:"
		                + empJson);
		            System.out.println(
		                "Updating the dept of emp object");
		 
		            // Update deptName attribute of emp object
		            employee.setDeptName("Devops");
		            System.out.println(
		                "Deserializing updated emp json ");
		 
		            // Reading from updated json and deserializes it
		            // to emp object
		            Employee updatedEmp = mapper.readValue(
		                mapper.writeValueAsString(employee),
		                Employee.class);
		 
		            // Print and display the updated employee object
		            System.out.println("Updated emp object is "
		                               + updatedEmp.toString());
		        }
		  
		        // Catch block to handle exceptions
		 
		        // Catch block 1
		        // Handling JsonGenerationException
		        catch (JsonGenerationException e) {
		 
		            // Display the exception along with line number
		            // using printStackTrace() method
		            e.printStackTrace();
		        }
		 
		        // Catch block 2
		        // Handling JsonmappingException
		        catch (JsonMappingException e) {
		 
		            // Display the exception along with line number
		            // using printStackTrace() method
		            e.printStackTrace();
		        }
		 
		        // Catch block 3
		        // handling generic I/O exceptions
		        catch (IOException e) {
		 
		            // Display the exception along with line number
		            // using printStackTrace() method
		            e.printStackTrace();
		        }
		    }
		 
		    // Method 2
		    // To get the employees
		    private static Employee getEmployee()
		    {
		        // Creating an object of Employee class
		        Employee emp = new Employee();
		        emp.setId("E010890");
		        emp.setName("James");
		        emp.setDeptName("DBMS");
		        emp.setRating(5);
		        emp.setSalary(1000000.00);
		 
		        // Returning the employee
		        return emp;
		    }
		}
