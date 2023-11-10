package com.programming.techie;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    public static void setupAll(){
        System.out.println("Should print before all tests");
    }
    @BeforeEach
    public void setup(){
        contactManager = new ContactManager();
    }
    @Test
    public void shouldCreateContact(){
        contactManager.addContact("John", "Smith", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("John") &&
                        contact.getLastName().equals("Smith") &&
                        contact.getPhoneNumber().equals("0123456789"))
                .findAny()
                .isPresent());
    }
    @Test
    @DisplayName("Should not create contact when first name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Smith", "0123456789");
        });
    }

    @Test
    @DisplayName("Should not create contact when last name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
           contactManager.addContact("John", null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should not create contact when phone number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", "Smith", null);
        });
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Should execute after each test");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("Should execute after all tests");
    }

}