package control.ioLocalStorage.ioType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import database.LocalStorage;

/**
 * Created by Reaktor on 13.12.2014.
 */
public class IODatFile {

	public LocalStorage input(String inputFileName) {
		try (ObjectInputStream inputStream = new ObjectInputStream(
				new FileInputStream(inputFileName))) {
			return (LocalStorage) inputStream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void output(LocalStorage localStorage, String outputFileName) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream(outputFileName))) {
			outputStream.writeObject(localStorage);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
