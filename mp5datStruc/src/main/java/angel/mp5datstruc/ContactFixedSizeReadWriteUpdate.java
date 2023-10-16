/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package angel.mp5datstruc;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 *
 * @author angelfigeralperezestevez
 */
public class ContactFixedSizeReadWriteUpdate {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException
    {
        try (
                RandomAccessFile contactsFile = new RandomAccessFile("1.dat", "rw");)
        {
            contactsFile.setLength(0);
            System.out.println("--------------WRITE and READ");
            ContactFixedSize p1 = new ContactFixedSize("Jones", "Lafayette LA");
            ContactFixedSize p2 = new ContactFixedSize("mary", "1 Main Street");
            ContactFixedSize p3 = new ContactFixedSize("Aris", "888 Rocks Street");
            contactsFile.writeUTF(p1.getName());
            contactsFile.writeUTF(p1.getAddress());
            contactsFile.writeUTF(p2.getName());
            contactsFile.writeUTF(p2.getAddress());
            contactsFile.writeUTF(p3.getName());
            contactsFile.writeUTF(p3.getAddress());
            contactsFile.seek(0);
            for (int i = 0; i < 3; ++i)
            {
                System.out.println(
                        contactsFile.readUTF() + "  " + contactsFile.readUTF());
            }
            System.out.println("\n------------------------ PRINT THE NUMBER OF BYTES THAT FOLLOW a UTF");
                //>extract how many bytes are used tos store the name of 1st contact
            contactsFile.seek(0);
            short _2firstBytesHaveTheNumberOfBytesThatFollow = (short) contactsFile.readChar();
            System.out.println("the name has bytes = " + _2firstBytesHaveTheNumberOfBytesThatFollow);
            System.out.println("\n------------------------ PRINT THE ADDRESS of 2nd Contact");
                
                  //>go to the address of 2nd contact and read it
            contactsFile.seek(0);
            contactsFile.seek(2 + ContactFixedSize.NAME_SIZE
                    + 2 + ContactFixedSize.ADDRESS_SIZE
                    + 2 + ContactFixedSize.NAME_SIZE);
            String readAddressOfSecondContact = contactsFile.readUTF();
            System.out.println(readAddressOfSecondContact);
            System.out.println("\n------------------------ UPDATE AND PRINT THE ADDRESS of 2nd Contact");
                    
                    //>go to the address of 2nd contact and modify it
                    
            ContactFixedSize p3Modified = new ContactFixedSize("Folegandros K", "New Orleans");

            contactsFile.seek(2 + ContactFixedSize.NAME_SIZE
                    + 2 + ContactFixedSize.ADDRESS_SIZE);
            contactsFile.writeUTF(p3Modified.getName());
            contactsFile.writeUTF(p3Modified.getAddress());
            //go to the name of 2nd contact and read it 
            contactsFile.seek(64);
            System.out.println(contactsFile.readUTF());
            System.out.println(contactsFile.readUTF());
            
                        //go to  3rd contact and read it 
            System.out.println("--------------Read the 3rd contact");
            System.out.println("read the 3rd contact");
            System.out.println("file size: " + contactsFile.length() );
            contactsFile.seek(128);          
            System.out.print(contactsFile.readUTF());
            System.out.println("    " + contactsFile.readUTF());
        }
    }
}

class ContactFixedSize implements Serializable
{
    static int NAME_SIZE = 20;
    static int ADDRESS_SIZE = 40;
    static int TOTAL_BYTES_OF_CONTACT = 20 + 40;
    String name;
    String address;

    /**
     *
     * @param name
     * @param address
     * @throws IllegalInputException parameter validation on sizes failed.
     */
    public ContactFixedSize(String name, String address)
    {
        if (name.length() > 20 || address.length() > 50)
        {
            throw new IllegalInputException("Illegal parameter length: "
                    + name.length() + " " + address.length());
        }
        this.name = name;
        for (int i = name.length(); i < ContactFixedSize.NAME_SIZE; ++i)
        {
            this.name += "*";
        }
        this.address = address;
        for (int i = address.length(); i < ContactFixedSize.ADDRESS_SIZE; ++i)
        {
            this.address += "*";
        }
       
    }

    public static int getNAME_SIZE()
    {
        return NAME_SIZE;
    }

    public static void setNAME_SIZE(int NAME_SIZE)
    {
        ContactFixedSize.NAME_SIZE = NAME_SIZE;
    }

    public static int getADDRESS_SIZE()
    {
        return ADDRESS_SIZE;
    }

    public static int getTOTAL_BYTES_OF_CONTACT()
    {
        return TOTAL_BYTES_OF_CONTACT;
    }

    public static void setTOTAL_BYTES_OF_CONTACT(int TOTAL_BYTES_OF_CONTACT)
    {
        ContactFixedSize.TOTAL_BYTES_OF_CONTACT = TOTAL_BYTES_OF_CONTACT;
    }

    public static void setADDRESS_SIZE(int ADDRESS_SIZE)
    {
        ContactFixedSize.ADDRESS_SIZE = ADDRESS_SIZE;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Person{" + "name=" + name + ", address=" + address + '}';
    }
    
}
