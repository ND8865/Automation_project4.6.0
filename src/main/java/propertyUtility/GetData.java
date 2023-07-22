package propertyUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class GetData 
{


	public static String path = System.getProperty("user.dir") + "/testdata/URL_File";
	public static String path1 = System.getProperty("user.dir") + "/testdata/Credentials_File";
	// This method work for fatch the URL from URL_File.
	public static String geturl (String key) {
		String value = "";

		try {
			FileInputStream fis = new FileInputStream(path);
			Properties pro = new Properties();
			pro.load(fis);
			value = pro.getProperty(key);

		} catch (Exception e) {
			System.out.println("issue in the geturl" + e);
		}
		return value;
	}

	// This method work for fatch the credentials from credentials file.
	public static String getcred (String key) {
		String value = "";

		try {
			FileInputStream fis = new FileInputStream(path1);
			Properties pro = new Properties();
			pro.load(fis);
			value = pro.getProperty(key);

		} catch (Exception e) {
			System.out.println("issue in the getcred" + e);
		}
		return value;
	}












}
