package StudentManagementSystem;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class StdMgmt
{
    //main method
    public static void main(String[] args)
    {
        StdMgmt stdMgmt = new StdMgmt();

        int menuOption;
        // Loop till user opt to exit
        do {

            // Call getMenuOption to get user input
            menuOption = stdMgmt.getMenuOption();
            Scanner scanner = new Scanner(System.in);
            switch (menuOption){
                case 1:
                    stdMgmt.addUpdateStudent(AddUpdateEnum.Add);
                    break;
                case 2:
                    stdMgmt.addUpdateStudent(AddUpdateEnum.Update);
                    break;
                case 3:
                    stdMgmt.searchStudentdetail();
                    break;
                case 4:
                    stdMgmt.getAllStudent();
                    break;
                case 5:
                    stdMgmt.deleteStudent();
                    break;
                case 6:
                    System.out.println("6. Exited!!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (menuOption != 6);
    }

    // Method to display Menu Options and return user selection
    private int getMenuOption()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=============================== Student Management System ===============================\n\n");
        System.out.println("\n Student Management System Menu: \n");
        System.out.println("1. Create Student Detail: ");
        System.out.println("2. Update Student Detail: ");
        System.out.println("3. Search Student Detail: ");
        System.out.println("4. Get All Student Detail:");
        System.out.println("5. Delete Student Detail:");
        System.out.println("6. Exit: \n\n");

        // Prompting user for student details
        System.out.println("Choose an option : ");
        while (!scanner.hasNextInt())
        {
            System.out.print("Invalid input. Choose a valid option: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addUpdateStudent(AddUpdateEnum addUpdate)
    {
        Scanner scanner = new Scanner(System.in);
        // Prompting user for student details
        System.out.println("Enter student's Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.println("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter student's grade: ");
        String grade = scanner.nextLine();

        System.out.println("Enter student's Stream: ");
        String stream = scanner.nextLine();

        System.out.println("Enter student's class: ");
        String studClass = scanner.nextLine();

        StudentDetail studentDetail = new StudentDetail(rollNumber, name, grade, stream, studClass);

        String jsonBody = "{\"rollNumber\" : \"" + rollNumber + "\", \"name\" : \"" + name + "\", " +
                "\"grade\" : \"" + grade + "\" , \"stream\" : \"" + stream + "\", \"studeClass\" : \"" + studClass + "\" }";

        if (addUpdate == AddUpdateEnum.Add)
        {
            //  Call REST service to save student in database
            CallRestAPI("http://localhost:8080/api/student", "POST", jsonBody );

            System.out.println("Student added successfully!!");
            //Missing code
        }
        else if (addUpdate == AddUpdateEnum.Update)
        {
            //  Call REST service to update student in database
            CallRestAPI("http://localhost:8080/api/student", "PUT", jsonBody);

            System.out.println("Student Updated!! ");
        }

        //System.out.println(studentDetail);
    }

    //  Call REST service to search student details in database
    private void searchStudentdetail()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student Roll Number that you want to search: ");
        String rollNumber = scanner.nextLine();
        CallRestAPI("http://localhost:8080/api/student/" + rollNumber, "GET");
    }

    //  Call REST service to get all student's details from database
    private void getAllStudent()
    {
        CallRestAPI("http://localhost:8080/api/student" , "GET");
    }

    //  Call REST service to delete student in database
    private void deleteStudent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student Roll Number that you want to delete: ");
        String rollNumber = scanner.nextLine();
        CallRestAPI("http://localhost:8080/api/student/" + rollNumber, "DELETE");
    }

    // Calling Rest API : Two overloaded methods
    public void CallRestAPI(String apiEndPoint, String HttpMethod)
    {
        CallRestAPI(apiEndPoint, HttpMethod, "");
    }

    public void CallRestAPI(String apiEndPoint, String HttpMethod, String requestBody)
    {
        try {
            // Creating a URL object
            URL url = new URL(apiEndPoint);

            //Opening a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Setting the request method
            connection.setRequestMethod(HttpMethod);

            if(HttpMethod.equals("POST") || HttpMethod.equals("PUT") )
            {
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
                dos.writeBytes(requestBody);
            }

            // Retrieving the HTTP response code
            int responseCode = connection.getResponseCode();

            // Processing the response code
            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sbResponse = new StringBuilder();
                String inputLine;

                while ((inputLine = br.readLine()) != null)
                {
                    sbResponse.append(inputLine);
                }
                br.close();

                System.out.println("API Response: " + sbResponse.toString());
                System.out.println("Press Enter Key To Continue ... ");
                System.in.read();
            }
            else
            {
                System.out.println("API Call Failed. Response Code: " + responseCode);
            }
        }
        catch (Exception ex)
        {
           ex.printStackTrace();
        }
    }
}