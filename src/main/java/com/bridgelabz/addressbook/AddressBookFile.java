package com.bridgelabz.addressbook;


import java.io.*;
import java.util.Map;

public class AddressBookFile {
    public static final String ADDRESS_FILE = "./src/main/resources/AddressBook.txt";

    public void writeAddressToFile(Map<String, IAddressBook> addressBooks) {
        try {
            FileWriter fileWriter = new FileWriter(ADDRESS_FILE);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Map.Entry<String, IAddressBook> entry : addressBooks.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }

            writer.flush();
            writer.close();
            System.out.println("Address added to File");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readAddressFromFile() {
        try (FileReader fileReader = new FileReader(ADDRESS_FILE)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String address;

            while ((address = reader.readLine()) != null) {
                System.out.println(address);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}



