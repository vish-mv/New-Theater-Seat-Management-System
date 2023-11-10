public class Ticket {       //Person Class

    private int row;        //Create an integer variable named row
    private  int seat;       //Create an integer variable named seat
    private  double price;   //Create a double variable named price
    private  Person person;  //Create a variable named person via Person class
    public Ticket(int row,int seat, double price, Person person){   //Create a Constructor for Ticket class with 4 parameters
        this.row = row;         //equalize row parameter with row variable
        this.seat = seat;       //equalize seat parameter with seat variable
        this.price = price;     //equalize price parameter with price variable
        this.person = person;   //equalize person parameter with person variable
    }
    public void print(){        //Method for print all the ticket information
        System.out.println("Name : "+person.getName());
        System.out.println("Surname :"+person.getSurname());
        System.out.println("Email : "+person.getEmail());
        System.out.println("Row Number : "+row);
        System.out.println("Seat Number : "+seat);
        System.out.println("Price : "+price);
        System.out.println();

    }
    public double getPrice(){       //Method for return the price
        return price;
    }
    public double getRow(){       //Method for return the row
        return row;
    }
    public double getSeat(){       //Method for return the seat
        return seat;
    }
}
