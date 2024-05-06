package Emails;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class AddressBookTest {

    @Test
    public void test_addAddress_stringAddress() {
        AddressBook testAddressBook=new AddressBook();
        testAddressBook.addAddress("test","testEmail");
        Assert.assertTrue(testAddressBook.getMap().get("test").contains("testEmail"));
    }


    @Test
    public void test_getAddresses_valid() {
        AddressBook testAddressBook=new AddressBook();
        testAddressBook.addAddress("test","testEmail");
        Assert.assertTrue(Arrays.stream(testAddressBook.getAddresses("test")).toList().contains("testEmail"));
    }

    @Test
    public void test_getAddresses_incorrect() {
        AddressBook testAddressBook=new AddressBook();
        Assert.assertEquals(testAddressBook.getAddresses("test"), new String[0]);
    }

    @Test
    public void test_Equals_differentMaps() {
        AddressBook testAddressBook=new AddressBook();
        AddressBook differentAddressBook=new AddressBook();
        testAddressBook.addAddress("lol","awd");
        differentAddressBook.addAddress("ala","ala");
        Assert.assertEquals(testAddressBook,differentAddressBook);
    }

    @Test
    public void test_Equals_sameMaps() {
        AddressBook testAddressBook=new AddressBook();
        AddressBook differentAddressBook=new AddressBook();
        testAddressBook.addAddress("lol","awd");
        differentAddressBook.addAddress("lol","awd");
        Assert.assertEquals(testAddressBook,differentAddressBook);
    }



    @Test
    public void test_HashCode_sameMaps() {
        AddressBook testAddressBook=new AddressBook();
        AddressBook differentAddressBook=new AddressBook();
        testAddressBook.addAddress("lol","awd");
        differentAddressBook.addAddress("lol","awd");
        Assert.assertEquals(testAddressBook.hashCode(),differentAddressBook.hashCode());
    }

}