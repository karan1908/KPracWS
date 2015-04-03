package com.ibm.contact.service;

import java.util.List;

import com.ibm.contact.form.Contact;
 
public interface ContactService {
     
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}