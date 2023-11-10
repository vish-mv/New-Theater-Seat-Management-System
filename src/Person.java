public class Person {       //Person Class
    private  String name;     //Create a string variable named name
    private  String surname;  //Create a string variable named surname
    private  String email;    //Create a string variable named email
    public Person(String name, String surname, String email){   //Create a Constructor for person class with 3 String parameters
        this.name=name;             //equalize name parameter with name variable
        this.surname=surname;       //equalize surname parameter with surname variable
        this.email=email;           //equalize email parameter with email variable
    }
    public String getName(){       //Method for return the name
        return name;
    }
    public String getSurname(){       //Method for return the surname
        return surname;
    }
    public String  getEmail(){       //Method for return the email
        return email;
    }
}
