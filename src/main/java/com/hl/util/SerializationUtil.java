package com.hl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author akatta <br>
 *         <b> Serialialize Class Serializes Data
 * 
 *         </b>
 * 
 */
public class SerializationUtil {

	/**
	 * Deserialize to Object from given file
	 * 
	 * @param fileName
	 * @return {@link Object}
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserialize(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	/**
	 * Serialize the given object and save it to file
	 * 
	 * @param Obj
	 *            - Object to Serialize
	 * @param fileName
	 * @throws IOException
	 */
	public static void serialize(Object obj, String fileName)
			throws IOException {
		File f = new File(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(obj);
		oos.close();
	}

}