package com.bridgelabz.addressbook;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import java.util.stream.Collectors;

public class AddressBook implements IAddressBook {
    Scanner sc = new Scanner(System.in);
    List<PersonDetails> personAddress = new ArrayList<>();

    public AddressBook() {
    }

    public void addNewContact() {

        System.out.println("Enter Your First Name: ");
        String firstName = sc.next();
        boolean isPresent = personAddress.stream().anyMatch(n -> n.getFirstName().equalsIgnoreCase(firstName));

        if (!isPresent) {
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
                System.out.println("Contact deleted");
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
        personAddress.stream().filter(n -> n.getCity().equalsIgnoreCase(city)).forEach(System.out::println);

        long count = personAddress.stream().filter(n -> n.getCity().equalsIgnoreCase(city)).count();
        System.out.println("No. of Persons in city " + city + ":" + count);
    }

    public void sortContactByName() {
        personAddress.stream().sorted((n1, n2) -> n1.getFirstName().compareTo(n2.getFirstName())).forEach(System.out::println);
    }

    public void sortContactByCityAndState() {
        personAddress.stream().sorted((n1, n2) -> n1.getCity().compareTo(n2.getCity())).forEach(System.out::println);
        personAddress.stream().sorted((n1, n2) -> n1.getState().compareTo(n2.getState())).forEach(System.out::println);
    }

    public void writeToJsonFile()  {
        try {

            FileWriter writer = new FileWriter("AddressBook.json");
            Gson gson = new Gson();
            String json = gson.toJson(personAddress);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromJsonFile() {
        try (Reader reader = Files.newBufferedReader(Paths.get("AddressBook.json"))) {
            Gson gson = new Gson();
            ArrayList<PersonDetails> contactList = new ArrayList<>(Arrays.asList(gson.fromJson(reader, PersonDetails[].class)));
            for (PersonDetails contact : contactList) {
                System.out.println("Firstname : " + contact.getFirstName());
                System.out.println("Lastname : " + contact.getLastName());
                System.out.println("Address : " + contact.getAddress());
                System.out.println("City : " + contact.getCity());
                System.out.println("State : " + contact.getState());
                System.out.println("Zip : " + contact.getZip());
                System.out.println("Phone number : " + contact.getPhoneNumber());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                personAddress + '}';
    }
}
