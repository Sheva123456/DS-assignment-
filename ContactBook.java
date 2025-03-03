import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedList;

public class ContactBook {
    public static void main(String[] args) {
        LinkedList<Contacts> CList = new LinkedList<Contacts>();

        Scanner s = new Scanner(System.in);



        while (true) {
            System.out.println("Enter a command (A to add, P to print, D to delete, E to search email, S to search by name, Q to quit): ");
            String option = s.nextLine().toUpperCase();
            switch (option) {

                case "A":
                    System.out.println("Please enter name: ");
                    String name = s.nextLine();

                    System.out.println("Please enter phone number: ");
                    int number = s.nextInt();
                    s.nextLine();

                    System.out.println("Please enter email: ");
                    String email = s.nextLine();

                    Contacts c = new Contacts(name, number, email);
                    CList.add(c);


                    break;
                case "P":

                    if (CList.isEmpty()) {
                        System.out.println("There's nothing in the contact book!");
                    } else {
                        Iterator<Contacts> it = CList.iterator();
                        while (it.hasNext()) {
                            Contacts current = it.next();
                            System.out.println("|Name: " + current.getName() + "Phone number: " + current.getNumber() + " Email: " + current.getEmail() + "|");
                        }

                    }
                    break;

                case "D":
                    System.out.println("Type the name of the contact you would like to delete: ");
                    String DeleteName = s.nextLine();
                    Iterator<Contacts> it = CList.iterator();

                    while (it.hasNext()) {
                        Contacts current = it.next();
                        if (current.getName().equals(DeleteName) ){
                            it.remove();
                            System.out.println("guy deleted!");
                            break;
                        }
                    }

                    break;

                case "E":
                    System.out.println("Type the email of the contact you would like to search: ");
                    String search = s.nextLine();
                    Iterator<Contacts> s1 = CList.iterator();
                    boolean found = false;
                    while (s1.hasNext()) {

                        Contacts current = s1.next();
                        if (current.getEmail().equals(search) ){

                            System.out.println("guy found!, Name: " + current.getName() + "Number: " + current.getNumber() + " Email: " +current.getEmail());
                            found = true;
                            break;
                        }


                    }
                    if (found == false){
                        System.out.println("Guy not found!");
                    }
                    break;

                case "S":
                    System.out.println("Type the name of the contact you would like to search: ");
                    String nsearch = s.nextLine();
                    Iterator<Contacts> n1 = CList.iterator();
                    boolean nfound = false;
                    while (n1.hasNext()) {

                        Contacts current = n1.next();
                        if (current.getName().equals(nsearch  ) ){

                            System.out.println("guy found!, Name: " + current.getName() + "Number: " + current.getNumber() + " Email: " +current.getEmail());
                            nfound = true;
                            break;
                        }


                    }
                    if (nfound == false){
                        System.out.println("Guy not found!");
                    }
                    break;

                case "Q":
                    System.out.println("Exiting program.");
                    s.close();
                    return;

                default:
                    System.out.println("Invalid command. Try again.");

            }
        }


    }
}