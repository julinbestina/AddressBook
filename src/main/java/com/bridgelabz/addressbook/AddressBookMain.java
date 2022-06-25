package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        char userChoice;

        Map<String, IAddressBook> addressBooks = new HashMap<>();
        IAddressBook studentsAddressBook = new AddressBook();
        IAddressBook familyAddressBook = new AddressBook();
        IAddressBook officeAddressBook = new AddressBook();

        addressBooks.put("students", studentsAddressBook);
        addressBooks.put("family", familyAddressBook);
        addressBooks.put("office", officeAddressBook);

        do {
            System.out.println("Enter the AddressBook \n1.Students \n2.Family \n3.Office");
            String choice = sc.next().toLowerCase();
            System.out.println("Select your Option: \n1.Add new Contact \n2.Edit Contact \n3.Delete Contact \n4.Search Contact");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    addressBooks.get(choice).addNewContact();
                    break;
                case 2:
                    addressBooks.get(choice).editContact();
                    break;
                case 3:
                    addressBooks.get(choice).deleteContact();
                    break;
                case 4:
                    addressBooks.get(choice).searchContact();
                    break;
            }

            System.out.println("Are you wish to continue:  Y?N");
            userChoice = sc.next().toUpperCase().charAt(0);
        } while (userChoice != 'N');


        for (Map.Entry<String, IAddressBook> l : addressBooks.entrySet()) {
            System.out.println(l.getKey() + "-" + l.getValue());
        }

    }
}
