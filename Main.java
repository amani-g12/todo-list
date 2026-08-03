import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)throws FileNotFoundException{

        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        String exitProgram = "n";

        loadTasksFromFile(tasks);


        do{


        //Initial Display
        System.out.println("====================\n     TO-DO LIST \n====================");
        System.out.println("1. View Tasks\n2. Add Task\n3. Remove Task\n4. Exit Program\n");
        System.out.print("Choose an option: ");
        
        //Take in user input for option
        int option = input.nextInt();
        input.nextLine();


        switch (option){
            // View Tasks
            case 1:
                viewTasks(tasks);
                break;

            // Add Task
            case 2:
                addTask(tasks,input);
                break;

            // Remove Task
            case 3:
                removeTask(tasks,input);
                break;


            case 4:
                exitProgram = getExitChoice(input);
                break;
        }


    } while(exitProgram.equalsIgnoreCase("n"));
        saveTasksToFile(tasks);
        input.close();

    }

    
    public static void viewTasks(ArrayList<String> tasks){
        
        if (tasks.isEmpty()){
                    System.out.println("No tasks found.\n\n");
                }

                else{
                    System.out.println("");
                    for (int i = 0; i < tasks.size(); i++){
                    System.out.println((i+1) + ". " + tasks.get(i));
                    }
                    System.out.println("\n");
                }
    }

    
    public static void addTask(ArrayList<String> tasks, Scanner input){
        
        System.out.print("\nType out the task you would like to add: ");
                String newTask = input.nextLine();

                tasks.add(newTask);

    }

    public static void removeTask(ArrayList<String> tasks, Scanner input){
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.\n");
            return;
        }

        
        System.out.println("\nHere is a list of all of the tasks in your to-do list: ");

                for (int i = 0; i < tasks.size(); i++){
                    System.out.println((i+1) + ": " + tasks.get(i));
                }

                System.out.print("\nWhat task number would you like to delete? ");
                int toDelete = input.nextInt();
                input.nextLine();

                //Check if it is within the bounds of the array

                if (toDelete >= 1 && toDelete <= tasks.size()){
                    tasks.remove(toDelete - 1);
                }
                else{
                    System.out.println("Invalid task number.\n\n");
                }

    }

    public static String getExitChoice(Scanner input){
        while (true){

                    System.out.println("Exit program? (y/n)");
                    String response = input.next();

                    if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n")){
                        return response;
                    }

                    System.out.println("\nInvalid input.\n");
                }

    }

    

    
    
    public static void saveTasksToFile(ArrayList <String> tasks) throws FileNotFoundException{
        File taskFile = new File ("tasks.txt");
        PrintWriter writer = new PrintWriter(taskFile);

        for (String task : tasks){
            writer.println(task);
        }

        writer.close();
    }

    public static void loadTasksFromFile(ArrayList<String> tasks) throws FileNotFoundException{
        File taskFile = new File ("tasks.txt");

        if(!taskFile.exists()){
            return;
        }


        Scanner fileReader = new Scanner (taskFile);

        while ( fileReader.hasNextLine()){
            String task = fileReader.nextLine();
            tasks.add(task);
        }

        fileReader.close();
    }

}