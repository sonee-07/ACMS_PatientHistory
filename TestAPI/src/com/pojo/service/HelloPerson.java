/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo.service;
import com.pojo.data.Person;
/**
 *
 * @author lenovo
 */
public class HelloPerson {
 
    Person person;
     public void setPerson(Person p)
     {
        this.person=p;
     }
     public Person getPerson(){
     
         return person;
     }
     public void sayHello()
     {
         System.out.println("hello"+person.getfName()+" "+person.getlName()+". The servie is running.");
     }
}
