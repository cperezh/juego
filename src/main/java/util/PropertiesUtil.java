package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * Devuel las propiedades de un fichero de propiedades que se encuentra en la ruta <b>relativa</b>
	 * definida por el parametro <c>file</c>
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Properties loadProperties(String file) throws IOException {

		FileInputStream in;
		Properties properties;

		properties = new Properties();
		String path = Thread.currentThread().getContextClassLoader().getResource(file).getPath();
		in = new FileInputStream(path);
		properties.load(in);
		in.close();

		return properties;

	}
}
