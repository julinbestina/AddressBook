package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        AddressBookFile addressBookFile = new AddressBookFile();
        Map<String, IAddressBook> addressBooks = new HashMap<>();
        char userChoice;

        do {
            System.out.println("Enter the name of address book you want to create");
            IAddressBook addressBook = new AddressBook();
            String addressBookName = sc.next();
            addressBooks.put(addressBookName, addressBook);
            System.out.println("Are you wish create address book again:  Y?N");
            userChoice = sc.next().toUpperCase().charAt(0);
        } while (userChoice == 'Y');


        do {
            System.out.println("Select the AddressBook");

            for (Map.Entry<String, IAddressBook> entry : addressBooks.entrySet()) {
                System.out.println(entry.getKey());
            }

            String choice = sc.next();
            System.out.println("Select your Option: \n1.Add new Contact \n2.Edit Contact \n3.Delete Contact \n4.Search Contact " +
                    "\n5.Display AddressBook \n6.Sort Contact by Name \n7.Sort by City and State  \n8.Read from and Write in to File");
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
                case 5:
                    System.out.println(choice + "-" + addressBooks.get(choice));
                    break;
                case 6:
                    addressBooks.get(choice).sortContactByName();
                    break;
                case 7:
                    addressBooks.get(choice).sortContactByCityAndState();
                    break;
                case 8:
                    addressBookFile.writeAddressToFile(addressBooks);
                    addressBookFile.readAddressFromFile();
                    break;
            }

            System.out.println("Are you wish to continue:  Y?N");
            userChoice = sc.next().toUpperCase().charAt(0);
        } while (userChoice != 'N');


    }
}
