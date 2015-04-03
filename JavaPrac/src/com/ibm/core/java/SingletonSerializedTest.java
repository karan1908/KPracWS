package com.ibm.core.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
 
public class SingletonSerializedTest {
 
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "D:/temp.ser"));
        out.writeObject(instanceOne);
        out.close();
         
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "D:/temp.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        
        //deserailize from file to object
        ObjectInput inn = new ObjectInputStream(new FileInputStream(
                "D:/temp.ser"));
        SerializedSingleton instanceThree = (SerializedSingleton) inn.readObject();
        inn.close();
         
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
         
    }
 
}