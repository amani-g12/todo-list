import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList <String> tasks = new ArrayList<>();
        String contLoop = "y";


        do{


        //Initial Display
        System.out.println("====================\n     TO-DO LIST \n====================");
        System.out.println("1. View Tasks\n2. Add Task\n3. Remove Task\n4. Save and Exit\n");
        System.out.print("Choose an option: ");
        
        //Take in user input for option
        int option = input.nextInt();
        input.nextLine();


        switch (option){
            // View Tasks
            case 1:
                for (int i = 1; i < tasks.size(); i++){
                    System.out.println(i + ": " + tasks.get(i-1));
                }
                break;

            // Add Task
            case 2:
                System.out.print("Type out the task you would like to add: ");
                String newTask = input.nextLine();
                input.nextLine();

                tasks.add(newTask);
                break;

            // Remove Task
            case 3:
                System.out.println("Here is a list of all of the tasks in your to-do list: ");

                for (int i = 0; i < tasks.size(); i++){
                    System.out.println((i+1) + ": " + tasks.get(i));
                }

                System.out.print("What task number would you like to delete? ");
                int toDelete = input.nextInt();
                input.nextLine();

                //Check if it is within the bounds of the array

                if (toDelete >= 1 && toDelete <= tasks.size()){
                    tasks.remove(toDelete - 1);
                }
                else{
                    System.out.println("Invalid task number.");
                }
                break;


            case 4:
                System.out.println("Would you like to save and close your to-do list now? y/n");
                contLoop = input.next();
                break;
        }
    } while(contLoop.equalsIgnoreCase("y"));

        input.close();

    }

}