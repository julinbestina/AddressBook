package com.bridgelabz.addressbook;


public interface IAddressBook {
    void addNewContact();

    void editContact();

    void deleteContact();

    void searchContact();

    void sortContactByName();

    void sortContactByCityAndState();

    void writeToJsonFile();

    void readFromJsonFile();


}
