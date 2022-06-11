package com.bridgelabz.addressbook;

public class AddressBook {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public int zip;
    public String email;
    public long phoneNumber;


    public AddressBook(String firstName, String lastName, String address, String city, String state, int zip, String email, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public AddressBook() {

    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
