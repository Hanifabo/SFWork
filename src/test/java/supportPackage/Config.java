package supportPackage;

public interface Config {
	final String baseUrl = System.getProperty("baseUrl", "http://parabank.parasoft.com");
	final String host = System.getProperty("host","localhost");
	final  String browser = System.getProperty("browser", "firefox");
	final String browser_Version = System.getProperty("browser_Version", "35.0");
	final String platform = System.getProperty("platform", "windows 8");
	final String sauceuser = "hanifabo";
	final String sauceKey = "e6ad8357-452f-4088-8bbe-7eba55ae0e3e";
			

}
