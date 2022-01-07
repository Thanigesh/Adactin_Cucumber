package helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Reader {
	public static Properties p;

	public Reader() throws Exception {
		File f = new File(
				"C:\\Users\\thani\\eclipse-workspace\\Adactin\\src\\test\\java\\properties\\config.properties");
		FileInputStream is = new FileInputStream(f);
		p = new Properties();
		p.load(is);
	}

	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}

	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}

	public String getCc_num() {
		String ccnum = p.getProperty("cc_num");
		return ccnum;
	}

	public String getCc_type() {
		String cctype = p.getProperty("cc_type");
		return cctype;
	}

	public String getCc_expmt() {
		String expmt = p.getProperty("exp_mnt");
		return expmt;
	}

	public String getCc_expyr() {
		String expyr = p.getProperty("exp_yr");
		return expyr;
	}

	public String getCvv() {
		String cvv = p.getProperty("cvv");
		return cvv;
	}
}