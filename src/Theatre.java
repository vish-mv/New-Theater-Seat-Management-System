/*  Author: Visal Munasinghe Vitharana
    UOW ID: w1954048
    IIT ID: 20221302
    Start: 2023/2/18
    Program: Seat management System of the 'New Theatre' Company */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Theatre {
    public static Scanner output_check = new Scanner(System.in);    //Public scanner class for check user opinion in continue the program
    //In the Arrays 0 indicates a free seat, 1 indicates an occupied(sold) seat
    public static String[] row_1 = {"0", "0", "0", "0", "0", "0",    "0", "0", "0", "0", "0", "0"};  //Array that shows details about row one of the theatre
    public  static String[] row_2 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};  //Array that shows details about row two of the theatre
    public static   String[] row_3 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};  //Array that shows details about row three of the theatre
    public static ArrayList<Ticket> tickets = new ArrayList<>();    //Arraylist that contains all the information about sold tickets
    public static void main(String[] args) {                        //Main Method of the Program
        System.out.println("\nWelcome to the New Theatre");
        Scanner user_input = new Scanner(System.in);                //Scanner that used in main method
        while (true) {
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("Please select an option: ");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("\t0) Quit");
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            String user_choice;
            System.out.print("Enter option: ");
            user_choice = user_input.next();                        //User input for continue the program
            switch (user_choice) {
                case "0" -> System.out.println("Thank you");        //Print Greetings message before user exit the program
                case "1" -> buy_ticket();                           //Call the buy ticket method
                case "2" -> print_seating_area();                   //Call the print seating area method
                case "3" -> cancel_ticket();                        //Call the cancel ticket method
                case "4" -> show_available();                       //Call the show available method
                case "5" -> save();                                 //Call the save method
                case "6" -> load();                                 //Call the load method
                case "7" -> show_tickets_info();                    //Call the show tickets info method
                case "8" -> sort_tickets();                         //Call the sort tickets method
                default -> System.out.println("Incorrect Input Please check the Menu! ");   //Shows the default message if user input a wrong option
            }
            if(user_choice.equals("0")){
                break;                      //End the program if user entered 0 as input
            }

        }
    }

    public static void buy_ticket() { //Method that allows user to buy a ticket
        while (true) {
            Scanner user_input = new Scanner(System.in);            //Scanner that used to take inputs for but the ticket
            int row_num=0;                                          //Integer variable that contains the row number
            int seat_num=0;                                         //Integer variable that contains the seat number
            double ticket_price = 0;                                //Double variable that contains the price of the ticket
            String booking_checker = "0";                           //String Variable that contains if ticket booked successfully or not
            System.out.println();
            System.out.println("::::Personal Information::::");
            System.out.print("Name : ");
            String name = user_input.next();                        //Take users name and save it in String name variable
            System.out.print("Surname : ");
            String surname = user_input.next();                     //Take users surname and save it in String surname variable
            System.out.print("Email : ");
            String email = user_input.next();                       //Take users email and save it in String email variable
            Person person = new Person(name,surname,email);         //Create a person object that contains users name, surname and email via Person class
            System.out.println("\n::::Ticket Information::::");
            try {
                while(true){
                    user_input.nextLine();                          //Clear the user_input scanner
                    System.out.print("Enter the Row number you need to sit : ");
                    if(user_input.hasNextInt()) {                   //Check whether user entered an integer
                        row_num = user_input.nextInt();             //Take the row number from user and save it in row_num variable
                        if(row_num>0 && row_num<=3){                //Check whether row number is correct
                                break;
                        }
                        else{
                            System.out.println("Row Number is out of range(Select 1-3)");   //Error message for incorrect input
                            continue;
                        }
                    }
                    System.out.println("Invalid input (Hint: Input must be an integer). Please try again. Press Enter to continue");    //Error message for invalid data type of the input
                    user_input.nextLine();                          //Clear the user_input scanner
                }
                while(true){
                    user_input.nextLine();                          //Clear the user_input scanner
                    System.out.print("Enter the Seat number you need to sit : ");
                    if(user_input.hasNextInt()) {                   //Check whether user entered an integer
                        seat_num = user_input.nextInt();            //Take the seat number from user and save it in seat_num variable
                        if (row_num == 1 && seat_num <= 12) {       //Check whether seat belong to row 1 and is it a correct seat number
                            if (row_1[seat_num - 1].equals("0")) {  //Check that if the seat is not booked first
                                row_1[seat_num - 1] = "1";          //Change the array information as the seat booked
                                booking_checker = "1";              //Make the booking_checker variable 1
                                break;
                            }
                            else {
                                System.out.println("This seat is Already taken Please try another seat");   //Error message for already booked seat
                                continue;
                            }
                        }
                        else if (row_num == 2 && seat_num <= 16) {  //Check whether seat belong to row 2 and is it a correct seat number
                            if (row_2[seat_num - 1].equals("0")) {  //Check that if the seat is not booked first
                                row_2[seat_num - 1] = "1";          //Change the array information as the seat booked
                                booking_checker = "1";              //Make the booking_checker variable 1
                                break;
                            }
                            else {
                                System.out.println("This seat is Already taken Please try another seat");   //Error message for already booked seat
                                continue;
                            }
                        }
                        else if (row_num==3 && seat_num<=20) {      //Check whether seat belong to row 3 and is it a correct seat number
                            if (row_3[seat_num - 1].equals("0")) {  //Check that if the seat is not booked first
                                row_3[seat_num - 1] = "1";          //Change the array information as the seat booked
                                booking_checker = "1";              //Make the booking_checker variable 1
                                break;
                            }
                            else {
                                System.out.println("This seat is Already taken Please try another seat");   //Error message for already booked seat
                                continue;
                            }
                        }
                        else {
                            System.out.println("Seat Number is Out of range");  //Error message for incorrect seat number
                            continue;
                        }
                    }
                    user_input.nextLine();  //Clear the scanner
                    System.out.println("Invalid input (Hint: Input must be an integer). Please try again.Press Enter to continue"); //Error message for invalid data type of the input
                }
                while(true){
                    user_input.nextLine();  //Clear the scanner
                    System.out.print("Ticket Price : ");
                    if(user_input.hasNextDouble()) {   //Check the ticket price is a double
                        ticket_price = user_input.nextDouble(); //Take the price from the user and save it in ticket_price variable
                        break;
                    }
                    user_input.nextLine();
                    System.out.println("Invalid input (Hint: Input must be a number). Please try again. Press Enter to continue");  //Error message for invalid type input
                }
            } catch (Exception e){
                System.out.println("Error! (Hint: Seat or Row number or Price Must be Numbers or Seat Number is out of Range)");
            }
            if (booking_checker.equals("1")){   //Check whether booking process successful
                Ticket ticket = new Ticket(row_num,seat_num,ticket_price,person); // Make a ticket object that contains all the ticket details via Ticket class
                tickets.add(ticket);    //Add each ticket to the tickets arraylist
                System.out.println("\nSeat " + row_num + " - " + seat_num + " Successfully booked");  //Confirm the user that ticket is booked
            }
            System.out.println("\nDo you want to Book Another seat?");
            System.out.print("To Book A Seat Enter 'y' and  To Go back Enter any key : ");
            String user_continue_option = output_check.next();                 //check user opinion for continue the program
            if (!user_continue_option.equalsIgnoreCase("y")) {      //check user want to continue buying or not
                break;
            }
        }
    }

    public static void print_seating_area(){ //Method for print seating area of the theatre
        System.out.println("Theatre Seats:");
        System.out.println("Booked Seats :X     Available Seats:O\n");
        System.out.println("      ***********");
        System.out.println("      *  STAGE  *");
        System.out.println("      ***********");
        for(int seats =0 ;seats < row_1.length;seats++){    //Print seating area of the row 1
            switch (seats) {
                case 0:
                    System.out.print("    ");
                case 6 :
                    System.out.print(" ");
            }
            if (row_1[seats].equals("1")){
                System.out.print("X");
            } else{
                System.out.print("O");
            }
        }
        for(int seats =0 ;seats < row_2.length;seats++){    //Print seating area of the row 2
            switch (seats) {
                case 0:
                    System.out.print("\n  ");
                case 8 :
                    System.out.print(" ");
            }
            if (row_2[seats].equals("1")){
                System.out.print("X");
            } else{
                System.out.print("O");
            }
        }
        for(int seats =0 ;seats < row_3.length;seats++){    //Print seating area of the row 3
            switch (seats) {
                case 0:
                    System.out.print("\n");
                case 10 :
                    System.out.print(" ");
            }
            if (row_3[seats].equals("1")){
                System.out.print("X");
            } else{
                System.out.print("O");
            }
        }
        System.out.println();

    }
    public static void cancel_ticket(){ //Method for cancel a ticket that already booked

        while (true) {
            Scanner user_input = new Scanner(System.in);    //Scanner that used to take inputs from the user for cancel tickets
            int row_num ;   //Integer row number variable
            int seat_num;   //Integer seat number variable
            try {
                System.out.println();
                System.out.print("Enter the Row number of the seat you need to cancel : ");
                row_num = user_input.nextInt();                     //Take the row number from the user
                System.out.print("Enter the Seat number of the seat you need to cancel : ");
                seat_num = user_input.nextInt();                    //Take the seat number from the user
            }catch (Exception e){
                System.out.println("Input must be an Integer");     //Error message for invalid data type of input
                continue;
            }
            for (int i = 0; i < tickets.size(); i++) {              //Go through the arraylist for find the correct seat that need to be canceled
                Ticket ticket = tickets.get(i);                     //Take the tickets from the Arraylist
                if (ticket.getRow() == row_num && ticket.getSeat() == seat_num) {         //Check that if it is the correct ticket
                    tickets.remove(i);                              //Remove the ticket from the arraylist
                    if (row_num==1){
                        row_1[seat_num-1] = "0";                    //Remove the ticket from the row1
                    } else if (row_num==2){
                        row_2[seat_num-1] = "0";                    //Remove the ticket from the row2
                    } else if (row_num==3){
                        row_3[seat_num-1] = "0";                    //Remove the ticket from the row3
                    }
                    System.out.println("Ticket cancelled " + ticket.getPrice()+" $ Will be Refunded" );  //Confirm user about the cancellation
                    return;         //Return to main method
                }
            }
            System.out.println("Invalid Ticket! Check The Row and Seat Numbers");   //Error message for invalid tickets
            System.out.print("Do you want to Cancel Another booking?\nTo Cancel another Seat Enter 'y' and  To Go back Enter any key : ");
            String user_continue_option = output_check.next();      //check user opinion for continue the program
            if (!user_continue_option.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
    public static void show_available(){ //Method for show available seats o the user
        System.out.print("Seats available in row 1 : ");
        String row_1_data="";
        String row_2_data="";
        String row_3_data="";
        for(int seats =0 ;seats < row_1.length;seats++){        //Show available seats for row 1
            if (row_1[seats].equals("0")) {
                String seat_data =String.valueOf(seats+1);
                row_1_data=row_1_data.concat(seat_data+", ");
            }
        }
        System.out.print(row_1_data.substring(0,row_1_data.length()-2)+".");
        System.out.print("\nSeats available in row 2 : ");
        for(int seats =0 ;seats < row_2.length;seats++){        //Show available seats for row 2
            if (row_2[seats].equals("0")) {
                String seat_data =String.valueOf(seats+1);
                row_2_data=row_2_data.concat(seat_data+", ");
            }
        }
        System.out.print(row_2_data.substring(0,row_2_data.length()-2)+".");
        System.out.print("\nSeats available in row 3 : ");
        for(int seats =0 ;seats < row_3.length;seats++){        //Show available seats for row 3
            if (row_3[seats].equals("0")) {
                String seat_data =String.valueOf(seats+1);
                row_3_data=row_3_data.concat(seat_data+", ");
            }
        }
        System.out.print(row_3_data.substring(0,row_3_data.length()-2)+".");
        System.out.println();
    }
    public static void save(){ //Method for save data in a text file
        try{
            File file = new File("data_save.txt");      //Create a new file named data_save.txt
            String user_choice="";                              //Create an empty String variable named user_choice
            if(file.exists()) {                                 //Check whether file is exist already
                System.out.println("There is a save file already exist. Do you want to Overwrite it?");
                System.out.print("Enter 'y' for overwrite or Another key to go back : ");
                user_choice = output_check.next();              //Check user opinion to continue if file exist already
            }
            if(!file.exists() || user_choice.equals("y")){
                    FileWriter data_writer = new FileWriter(file);  //Create a new file writer names data_writer
                    for(String row_data :row_1){                    //Write data of the row 1 in the file
                        data_writer.write(row_data);
                    }
                    data_writer.write("\n");
                    for(String row_data :row_2){                    //Write data of the row 2 in the file
                        data_writer.write(row_data);
                    }
                    data_writer.write("\n");
                    for(String row_data :row_3){                    //Write data of the row 3 in the file
                        data_writer.write(row_data);
                    }
                    data_writer.close();                            //Close the file writer
                    System.out.println("Saved Successfully");       //Confirm user that save is successful
                }
        }
        catch (IOException e){
            System.out.println("Error Occurred!");              //Show error message if error occurred
        }
    }
    public static void load(){ //Method for load data that saved in a text file
        try {
            File file = new File("data_save.txt");      //Create a new file using data_save.txt
            System.out.println();
            Scanner file_reader = new Scanner(file);            //Create a Scanner that scans then file
            int line_count=1;                                   //Set line count variable to 1
            while(file_reader.hasNextLine()) {                  //Loop while text file has another line
                String row_data = file_reader.nextLine();       //Save the row data in a String called row_data
                System.out.print("Row "+ line_count +" : ");
                for (int i = 0; i < row_data.length(); i++) {   //Loop through the row_data string to separate the string to characters
                    char character = row_data.charAt(i);        //Save each character temporary to the character variable
                    String data = String.valueOf(character);    //Convert character in to String
                    if (line_count==1){                         //Save data in the array using the line count
                        row_1[i]=data;
                    } else if (line_count==2) {
                        row_2[i]=data;
                    } else if (line_count==3) {
                        row_3[i]=data;
                    }
                    System.out.print(data+" ");
                }
                System.out.println();
                line_count++;                                   //Increase the line count variable
            }
            System.out.println("Successfully Loaded");
        }
        catch (Exception e){
            System.out.println("Save file does not Exist. Please save again. ");        //Show error message if error occurred
        }
    }
    public static void show_tickets_info(){ //Method for print ticket details
        double total=0;                     //Set total value to 0
        for (Ticket ticket : tickets) {     //Loop through the arraylist
            ticket.print();                 //Call the print method in the Ticket class via arraylist data
            total= total+ ticket.getPrice();     //Increase the total
        }
        System.out.println("Total Price of Tickets : "+total+" $");     //Print the total
    }

    public static  ArrayList<Ticket> sorting_tickets(ArrayList<Ticket> tickets){ //Method for sort tickets by price
        ArrayList<Ticket> sortedTickets = new ArrayList<>(tickets);         //Create a new ArrayList to hold the sorted tickets and take tickets array list as its parameter
        for (int i = 0; i < sortedTickets.size() - 1; i++) {                //Loop through the sorted tickets to get a value
            for (int j = 0; j < sortedTickets.size() - i - 1; j++) {        //Loop thorough the sorted tickets again to check each price
                if (sortedTickets.get(j).getPrice() > sortedTickets.get(j + 1).getPrice()) { //Check that if the price for j th index is greater than J+1 th index
                    Ticket temp = sortedTickets.get(j);                     //Get sorted tickets jth value and save it in a temporary variable called temp
                    sortedTickets.set(j, sortedTickets.get(j + 1));         // Swap sortedTickets jth index and sortedTickets j+1 th index
                    sortedTickets.set(j + 1, temp);                         //Set Higher value (temp) to j+1 th index
                }
            }
        }
        return sortedTickets; // return the sorted ArrayList
    }
    public static void  sort_tickets(){ //Method for Print sorted ticket details
        ArrayList<Ticket> sortedTickets = sorting_tickets(tickets);         //Take the sorted tickets array
        for (Ticket sorted : sortedTickets){                                //Loop through sorted tickets array
            sorted.print();                                                 //Print all the data using print function in Ticket class
        }
    }
}