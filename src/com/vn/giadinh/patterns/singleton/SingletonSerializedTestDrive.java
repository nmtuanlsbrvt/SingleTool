package com.vn.giadinh.patterns.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonSerializedTestDrive {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
 
        SerializedSingleton serializedSingleton1 = SerializedSingleton.getInstance();
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
 
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SingletonSerializedTest.txt"));
        out.writeObject(serializedSingleton1);
        out.writeObject(enumSingleton1);
        out.close();
 
        // Khử tuần tự hóa từ tệp này sang đối tượng khác
        ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonSerializedTest.txt"));
        SerializedSingleton serializedSingleton2 = (SerializedSingleton) in.readObject();
        EnumSingleton enumSingleton2 = (EnumSingleton) in.readObject();
        in.close();
        //Deserialize đối tượng của SerializedSingleton khác với đối tượng gốc. Tuy nhiên vấn đề này không xảy ra khi sử dụng enum. Và ta thấy 2 hashCode đầu tiên khác nhau.
        System.out.println("serializedSingleton1 hashCode=" + serializedSingleton1.hashCode());
        System.out.println("serializedSingleton2 hashCode=" + serializedSingleton2.hashCode());
        System.out.println("enumSingleton1 hashCode=" + enumSingleton1.hashCode());
        System.out.println("enumSingleton2 hashCode=" + enumSingleton2.hashCode());
    }
}
    
