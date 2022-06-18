package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        char choice;
        IAddressBook addressBook = new AddressBook();

        do {
            System.out.println("Select your Option: \n1.Add new Contact \n2.Edit Contact");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    addressBook.addNewContact();
                    break;
                case 2:
                    addressBook.editData();
                    break;
            }

            System.out.println("Are you wish to continue:  Y?N");
            choice = sc.next().toUpperCase().charAt(0);
        } while (choice != 'N');

        System.out.println(addressBook);

    }
}
