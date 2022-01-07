package helper;

public class Manager_Reader {
	private Manager_Reader() {
		
	}

	public static Manager_Reader getInstance() {
		Manager_Reader mr = new Manager_Reader();
		return mr;
	}

	public Reader getInstanceR() throws Throwable {
		Reader r = new Reader();
		return r;
	}
}