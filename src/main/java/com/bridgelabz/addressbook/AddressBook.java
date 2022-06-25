package com.bridgelabz.addressbook;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook implements IAddressBook {
    Scanner sc = new Scanner(System.in);


    List<PersonDetails> personAddress = new ArrayList<>() {{
        add(new PersonDetails("Julin Bestina", "A", "Kozhippara", "Palakkad", "Kerala", 678557, "julin.bestina@yahoo.com", 8086904736L));
        add(new PersonDetails("Monisha", "A", "ADYAR", "Chennai", "TamilNadu", 600018, "monisha56@gmail.com", 9485623185L));
        add(new PersonDetails("Sham", "P", "Alathur", "Thrissur", "Kerala", 680741, "sham.158@gmail.com", 9847561235L));
    }};


    public AddressBook() {
    }

    public void addNewContact() {

        System.out.println("Enter Your First Name: ");
        String firstName = sc.next();
        boolean isPresent = personAddress.stream().findFirst().equals(firstName);

        if (isPresent) {
            System.out.println("Enter Your Last Name: ");
            String lastName = sc.next();
            System.out.println("Enter Your Address: ");
            String address = sc.next();
            System.out.println("Enter Your City: ");
            String city = sc.next();
            System.out.println("Enter Your State: ");
            String state = sc.next();
            System.out.println("Enter Your Zip code: ");
            Integer zip = sc.nextInt();
            System.out.println("Enter Your Email Id: ");
            String email = sc.next();
            System.out.println("Enter Your Mobile Number: ");
            Long phoneNumber = sc.nextLong();
            personAddress.add(new PersonDetails(firstName, lastName, address, city, state, zip, email, phoneNumber));
            System.out.println("\nContact added to Address Book");
            return;
        }

        System.out.println("Contact already added");
    }

    public void editContact() {

        System.out.println("\nEnter First Name of person You want to edit :- ");
        String firstName = sc.next();
        String userChoice;

        for (PersonDetails l : personAddress) {
            if (l.getFirstName().equalsIgnoreCase(firstName)) {
                do {
                    System.out.print("\nSelect option to edit----\n1.First_name \n2.Last_name \n3.Address \n4.City \n5.State \n6.Zip_code \n7.Phone_number \n8.Email :- ");
                    int ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.print("Enter new first name : ");
                            l.setFirstName(sc.next());
                            System.out.println("First name is updated.");
                            break;
                        case 2:
                            System.out.print("Enter new last name : ");
                            l.setLastName(sc.next());
                            System.out.println("Last name is updated.");
                            break;
                        case 3:
                            System.out.print("Enter new address :");
                            l.setAddress(sc.next());
                            System.out.println("Address is updated.");
                            break;
                        case 4:
                            System.out.print("Enter new city : ");
                            l.setCity(sc.next());
                            System.out.println("City is updated.");
                            break;
                        case 5:
                            System.out.print("Enter new state : ");
                            l.setState(sc.next());
                            System.out.println("State is updated.");
                            break;
                        case 6:
                            System.out.print("Enter new zip code : ");
                            l.setZip(sc.nextInt());
                            System.out.println("Zip code is updated.");
                            break;
                        case 7:
                            System.out.print("Enter new phone number : ");
                            l.setPhoneNumber(sc.nextLong());
                            System.out.println("Phone number is updated.");
                            break;
                        case 8:
                            System.out.print("Enter new email : ");
                            l.setEmail(sc.next());
                            System.out.println("Email is updated.");
                            break;
                    }
                    System.out.println("Are you wish to edit other Address fields: Y?N");
                    userChoice = sc.next();
                } while (userChoice.equalsIgnoreCase("Y"));
                return;
            }
        }
        System.out.println("Please enter the correct first name");
    }

    @Override
    public void deleteContact() {
        System.out.println("\nEnter First Name of person You want to delete : ");
        String firstName = sc.next();
        for (PersonDetails l : personAddress) {

            if (l.getFirstName().equalsIgnoreCase(firstName)) {
                personAddress.remove(l);
                return;
            }
        }
        System.out.println("Please enter the correct first name");
    }

    @Override
    public void searchContact() {
        Map<String, List<PersonDetails>> addressByState = personAddress.stream().collect(Collectors.groupingBy(PersonDetails::getState));
        System.out.println("State wise Address:\n" + addressByState);

        Map<String, List<PersonDetails>> addressByCity = personAddress.stream().collect(Collectors.groupingBy(PersonDetails::getCity));
        System.out.println("City wise Address:\n" + addressByCity);

        System.out.println("Enter the city:");
        String city = sc.next();
        personAddress.stream().filter(n -> n.getCity().equalsIgnoreCase(city)).forEach(n -> System.out.println(n));
        long count = personAddress.stream().filter(n -> n.getCity().equalsIgnoreCase(city)).count();
        System.out.println("No. of Persons in city " + city + ":" + count);
    }


    @Override
    public String toString() {
        return "AddressBook{" +
                personAddress + '}';
    }
}
