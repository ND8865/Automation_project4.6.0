package property_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility_Code {

	public static String path = System.getProperty("user.dir") + "/testdata/Link_file";

	public static String getdatafromfile(String key) {
		String value = "";

		try {
			FileInputStream fis = new FileInputStream(path);
			Properties pro = new Properties();
			pro.load(fis);
			value = pro.getProperty(key);

		} catch (Exception e) {
			System.out.println("issue in the getfromfile" + e);
		}
		return value;
	}

}
