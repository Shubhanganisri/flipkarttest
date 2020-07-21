package Testsecnarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFiles {

	public Properties getPropertyObject() {
		Properties prop = null;
		try {
			prop = new Properties();
			FileInputStream in = new FileInputStream("D:/SeleniumTesting/workspace/FlipkartTest/config.properties");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
