package serializationDeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class serializationAndDeserialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Test t1 = new Test();
		
		//Serialization
		
		 /*
		 * FileOutputStream allows us to write the file into somewhere in memory or database, 
		 *before writing into memory we need to convert our object into file, using ObjectOutputStream class
		 **/
		FileOutputStream fos = new FileOutputStream("test.txt");
		//convert object into file
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t1);
		
		//test.txt will contain data in binary format, bytecode
		
		//Deserialization
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Test t2 = (Test)ois.readObject();
		System.out.println(t2.i+" , "+t2.j);
	}

}


/* 
 * To serialize class object, class should implement Serializable interface
 * otherwise Serialization process will throw java.io.NonSerializableException
 */

class Test implements Serializable{
	int i=10, j=20;
}