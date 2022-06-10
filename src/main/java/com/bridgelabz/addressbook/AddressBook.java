package com.bridgelabz.addressbook;

public class AddressBook {
    public String firstName;
    public String lastName;
    public String state;
    public String city;
    public int zip;
    public long phoneNumber;
    public String email;
    public String address;


    public AddressBook(String firstName, String lastName, String state, String city, int zip, long phoneNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
