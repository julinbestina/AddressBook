package com.bridgelabz.addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook addressBook = new AddressBook("Julin Bestina", "A","Kerala", "Palakkad", 678557, 8086904736l,"julin.bestina@yahoo.com","Kozhippara");
        System.out.println(addressBook);
    }
}
