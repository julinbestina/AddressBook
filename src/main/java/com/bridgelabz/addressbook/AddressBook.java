package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddressBook<E> implements IAddressBook {
    Scanner sc = new Scanner(System.in);
    PersonDetails personDetails = new PersonDetails();

    ArrayList<PersonDetails> address = new ArrayList<>(Arrays.asList((new PersonDetails("Julin Bestina", "A", "Kozhippara", "Palakkad", "Kerala", 678557, "julin.bestina@yahoo.com", 8086904736L)),
            new PersonDetails("Monisha", "A", "ADYAR", "Chennai", "TamilNadu", 600018, "monisha56@gmail.com", 9485623185L),
            new PersonDetails("Sham", "P", "Alathur", "Thrissur", "Kerala", 680741, "sham.158@gmail.com", 9847561235L)));

    public AddressBook() {
    }

    public void addNewContact() {

        System.out.println("Enter Your First Name: ");
        personDetails.setFirstName(sc.next());
        System.out.println("Enter Your Last Name: ");
        personDetails.setLastName(sc.next());
        System.out.println("Enter Your Address: ");
        personDetails.setAddress(sc.next());
        System.out.println("Enter Your City: ");
        personDetails.setCity(sc.next());
        System.out.println("Enter Your State: ");
        personDetails.setState(sc.next());
        System.out.println("Enter Your Zip code: ");
        personDetails.setZip(sc.nextInt());
        System.out.println("Enter Your Email Id: ");
        personDetails.setEmail(sc.next());
        System.out.println("Enter Your Mobile Number: ");
        personDetails.setPhoneNumber(sc.nextLong());
        address.add(personDetails);

    }

    public void editContact() {

        System.out.println("\nEnter First Name of person You want to edit :- ");
        String firstName = sc.next();
        String userChoice;

        for (int i = 0; i < address.size(); i++) {
            if (address.get(i).getFirstName().equals(firstName)) {
                do {
                    System.out.print("\nSelect option to edit----\n1.First_name \n2.Last_name \n3.Address \n4.City \n5.State \n6.Zip_code \n7.Phone_number \n8.Email :- ");
                    int ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.print("Enter new first name : ");
                            address.get(i).setFirstName(sc.next());
                            System.out.println("First name is updated.");
                            break;
                        case 2:
                            System.out.print("Enter new last name : ");
                            address.get(i).setLastName(sc.next());
                            System.out.println("Last name is updated.");
                            break;
                        case 3:
                            System.out.print("Enter new address :");
                            address.get(i).setAddress(sc.next());
                            System.out.println("Address is updated.");
                            break;
                        case 4:
                            System.out.print("Enter new city : ");
                            address.get(i).setCity(sc.next());
                            System.out.println("City is updated.");
                            break;
                        case 5:
                            System.out.print("Enter new state : ");
                            address.get(i).setState(sc.next());
                            System.out.println("State is updated.");
                            break;
                        case 6:
                            System.out.print("Enter new zip code : ");
                            address.get(i).setZip(sc.nextInt());
                            System.out.println("Zip code is updated.");
                            break;
                        case 7:
                            System.out.print("Enter new phone number : ");
                            address.get(i).setPhoneNumber(sc.nextLong());
                            System.out.println("Phone number is updated.");
                            break;
                        case 8:
                            System.out.print("Enter new email : ");
                            address.get(i).setEmail(sc.next());
                            System.out.println("Email is updated.");
                            break;
                    }
                    System.out.println("Are you wish to edit other Address fields: Y?N");
                    userChoice = sc.next();
                } while (userChoice.toUpperCase().equals("Y"));
                return;
            }
        }
        System.out.println("Please enter the correct first name");
    }

    @Override
    public void deleteContact() {
        System.out.println("\nEnter First Name of person You want to delete : ");
        String firstName = sc.next();
        for (int i = 0; i < address.size(); i++) {
            if (address.get(i).getFirstName().equals(firstName)) {
                address.remove(i);
            }
        }
    }


    @Override
    public String toString() {
        return "AddressBook{" +
                address + '}';
    }
}
