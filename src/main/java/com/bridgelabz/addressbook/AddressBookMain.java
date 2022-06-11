package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner sc = new Scanner(System.in);
        String userChoice;

        ArrayList<AddressBook> addressBook = new ArrayList<AddressBook>();

        AddressBook address1 = new AddressBook("Julin Bestina", "A", "Kozhippara", "Palakkad", "Kerala", 678557, "julin.bestina@yahoo.com", 8086904736L);
        AddressBook address2 = new AddressBook("Monisha", "A", "ADYAR", "Chennai", "TamilNadu", 600018, "monisha56@gmail.com", 9485623185L);
        AddressBook address3 = new AddressBook("Sham", "P", "Alathur", "Thrissur", "Kerala", 680741, "sham.158@gmail.com", 9847561235L);

        AddressBook address = new AddressBook();

        addressBook.add(address1);
        addressBook.add(address2);
        addressBook.add(address3);


        do {
            System.out.println("Enter Your First Name: ");
            address.firstName = sc.next();
            System.out.println("Enter Your Last Name: ");
            address.lastName = sc.next();
            System.out.println("Enter Your Address: ");
            address.address = sc.next();
            System.out.println("Enter Your City: ");
            address.city = sc.next();
            System.out.println("Enter Your State: ");
            address.state = sc.next();
            System.out.println("Enter Your Zip: ");
            address.zip = sc.nextInt();
            System.out.println("Enter Your Email Id: ");
            address.email = sc.next();
            System.out.println("Enter Your Mobile Number: ");
            address.phoneNumber = sc.nextLong();
            addressBook.add(address);
            System.out.println("Are you wish to add one more Address Y?N:");
            userChoice = sc.next();

        } while ((userChoice.toUpperCase()) == "Y");

        for (AddressBook l : addressBook) {
            System.out.println(l.toString());
        }

    }
}
