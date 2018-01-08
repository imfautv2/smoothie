package net.sf.f3270;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Initializer {
	
	public static String toolBaseLocation;
	public static String CodeBaseLocation;
	public static String hostname;
	public static int port;
	public static Boolean sheduleListioner;
	public static String emulatorPath;
	
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";

	public static boolean isProcessRunning(String serviceName) throws Exception {

	 Process p = Runtime.getRuntime().exec(TASKLIST);
	 BufferedReader reader = new BufferedReader(new InputStreamReader(
	   p.getInputStream()));
	 String line;
	 while ((line = reader.readLine()) != null) {
	  if (line.contains(serviceName)) {
	   return true;
	  }
	 }

	 return false;

	}
	
	public static void generateReportHtmlLoc(String reportPath){
		try{
			InputStream ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/index.html");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/index.html");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			//img
			File directory = new File(String.valueOf(reportPath+"/img"));
			if(!directory.exists()){
			    directory.mkdir();
			}
			
			File directoryf = new File(String.valueOf(reportPath+"/img/fav"));
			if(!directoryf.exists()){
				directoryf.mkdir();
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/arrow.svg");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/arrow.svg");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/arrow_down.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/arrow_down.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/arrow_up.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/arrow_up.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/android-chrome-192x192.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/android-chrome-192x192.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/android-chrome-512x512.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/android-chrome-512x512.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/apple-touch-icon.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/apple-touch-icon.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/browserconfig.xml");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/browserconfig.xml");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/favicon.ico");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/favicon.ico");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/favicon-16x16.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/favicon-16x16.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/favicon-32x32.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/favicon-32x32.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/manifest.json");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/manifest.json");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/mstile-150x150.png");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/mstile-150x150.png");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/img/fav/safari-pinned-tab.svg");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/img/fav/safari-pinned-tab.svg");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			
			//js
			directory = new File(String.valueOf(reportPath+"/js"));
			if(!directory.exists()){
			    directory.mkdir();
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/app.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/app.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/Chart.bundle.min.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/Chart.bundle.min.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/Chart.min.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/Chart.min.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/Chart.min.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/Chart.min.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/foundation.min.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/foundation.min.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/jquery.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/jquery.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/jquery.slimscroll.min.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/jquery.slimscroll.min.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/lity.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/lity.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/modernizr.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/modernizr.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/jquery.fullpage.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/jquery.fullpage.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/scrolloverflow.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/scrolloverflow.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/scrolloverflow.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/scrolloverflow.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/js/foundation.orbit.js");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/js/foundation.orbit.js");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			//js end
			
			//css
			directory = new File(String.valueOf(reportPath+"/css"));
			if(!directory.exists()){
			    directory.mkdir();
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/css/foundation.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/css/foundation.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/css/foundation.min.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/css/foundation.min.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/css/lity.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/css/lity.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/css/main.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/css/main.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/css/normalize.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/css/normalize.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/css/jquery.fullpage.min.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/css/jquery.fullpage.min.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			//css end
			
			//font
			directory = new File(String.valueOf(reportPath+"/fontawesome"));
			if(!directory.exists()){
			    directory.mkdir();
			}
			directory = new File(String.valueOf(reportPath+"/fontawesome/css"));
			if(!directory.exists()){
			    directory.mkdir();
			}
			directory = new File(String.valueOf(reportPath+"/fontawesome/fonts"));
			if(!directory.exists()){
			    directory.mkdir();
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/css/font-awesome.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/css/font-awesome.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/css/font-awesome.min.css");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/css/font-awesome.min.css");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/fonts/FontAwesome.otf");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/fonts/FontAwesome.otf");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/fonts/fontawesome-webfont.eot");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/fonts/fontawesome-webfont.eot");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/fonts/fontawesome-webfont.svg");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/fonts/fontawesome-webfont.svg");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/fonts/fontawesome-webfont.ttf");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/fonts/fontawesome-webfont.ttf");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/fonts/fontawesome-webfont.woff");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/fonts/fontawesome-webfont.woff");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/report/fontawesome/fonts/fontawesome-webfont.woff2");
			try (FileOutputStream fos = new FileOutputStream(reportPath+"/fontawesome/fonts/fontawesome-webfont.woff2");){
			    byte[] buf = new byte[2048];
			    int r;
			    while(-1 != (r = ddlStream.read(buf))) {
			        fos.write(buf, 0, r);
			    }
			}
			//font end
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	public static void init(){
		
		try {
			try{
				
				Runtime.getRuntime().exec(KILL + "s3270.exe");
				
			}
			catch(Exception e1){
				//
			}
			
			toolBaseLocation = System.getProperty("user.dir");
			if (!new File(toolBaseLocation + "/config.properties").exists()) {
				new File(toolBaseLocation + "/config.properties").createNewFile();
				CodeBaseLocation = "";
				hostname = "";
				port = 0;
			} else {
				config property = new config();
				CodeBaseLocation = property.getProperty("CodeBaseLocation");
				hostname = property.getProperty("host");
				port = Integer.parseInt((property.getProperty("port") != null
						&& !property.getProperty("port").trim().equalsIgnoreCase("") ? property.getProperty("port")
								: "0"));
			}

			String listion = new config().getProperty("sheduleListioner");
			if (listion == null || listion.trim().equalsIgnoreCase("")) {
				sheduleListioner = false;
			} else {
				sheduleListioner = Boolean.valueOf(listion);
			}

			Map<String, String> dict = new HashMap<String, String>();
			dict.put("toolBaseLocation", toolBaseLocation);
			new config().setProperty(dict);

			if (new config().getProperty("CodeBaseLocation") == null
					|| new config().getProperty("CodeBaseLocation").trim().equalsIgnoreCase("")) {
				dict = new HashMap<String, String>();
				dict.put("CodeBaseLocation", toolBaseLocation);
				new config().setProperty(dict);
			}

			if (!new File(toolBaseLocation + "/toolBackEnd.sqlite").exists()) {
				InputStream ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/toolBackEnd.sqlite");
				try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/toolBackEnd.sqlite");) {
					byte[] buf = new byte[2048];
					int r;
					while (-1 != (r = ddlStream.read(buf))) {
						fos.write(buf, 0, r);
					}
				}
			}

			// perform sqlTable createion if not present
			try {
				new slqLiteDB().insert(
						"create table if not exists \"bulkExecution\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"runPurpose\" TEXT, \"createdBy\" TEXT, \"runBy\" TEXT, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP)");
				new slqLiteDB().insert(
						"create table if not exists \"bulkExecutionFunctions\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"bulkExecutionId\" INTEGER, \"Project\" TEXT, \"CycleName\" TEXT, \"Scenario\" TEXT, \"functionName\" TEXT, \"Location\" TEXT, \"status\" INTEGER, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP, \"dataSet\" INTEGER)");
				new slqLiteDB().insert(
						"create table if not exists \"dataMap\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"reportId\" TEXT, \"functionId\" INTEGER, \"stepId\" INTEGER, \"Key\" TEXT, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP, \"Value\" TEXT)");
				new slqLiteDB().insert(
						"create table if not exists \"fieldMap\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"reportId\" TEXT, \"functionId\" INTEGER, \"stepId\" INTEGER, \"Key\" TEXT, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP, \"Value\" TEXT)");
				new slqLiteDB().insert(
						"create table if not exists \"function\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"reportId\" TEXT, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP, \"Project\" TEXT, \"CycleName\" TEXT, \"Scenario\" TEXT, \"functionName\" TEXT, \"Location\" TEXT, \"status\" TEXT)");
				new slqLiteDB().insert(
						"create table if not exists \"functionSteps\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"reportId\" TEXT, \"functionId\" INTEGER, \"Steps\" TEXT, \"Status\" TEXT, \"statusDesc\" TEXT, \"dateCreated\" TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
				new slqLiteDB().insert(
						"create table if not exists \"globalMap\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"reportId\" TEXT, \"functionId\" INTEGER, \"stepId\" INTEGER, \"Key\" TEXT, \"Value\" TEXT, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP)");
				new slqLiteDB().insert(
						"create table if not exists \"reportMaster\" (\"reportId\" TEXT, \"reportName\" TEXT, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP, \"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"reportPurpose\" TEXT)");
				new slqLiteDB().insert(
						"create table if not exists \"screenShots\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"reportId\" TEXT, \"functionId\" INTEGER, \"stepId\" INTEGER, \"Value\" TEXT, \"dateCreated\" DATE DEFAULT CURRENT_TIMESTAMP)");
			} catch (Exception e1) {
				// e1.printStackTrace();
			}

			File directory = new File(String.valueOf(toolBaseLocation + "/s3270"));
			if (!directory.exists()) {
				directory.mkdir();
			}
			directory = new File(String.valueOf(toolBaseLocation + "/s3270/cygwin"));
			if (!directory.exists()) {
				directory.mkdir();
			}
			directory = new File(String.valueOf(toolBaseLocation + "/screenShots"));
			if (!directory.exists()) {
				directory.mkdir();
			}
			directory = new File(String.valueOf(toolBaseLocation + "/queue"));
			if (!directory.exists()) {
				directory.mkdir();
			}

			InputStream ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/s3270/cygwin/s3270.exe");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/s3270/cygwin/s3270.exe");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/help/imfaut.pdf");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/imfaut.pdf");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/s3270/cygwin/cygwin1.dll");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/s3270/cygwin/cygwin1.dll");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/s3270/cygwin/cygssl-0.9.8.dll");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/s3270/cygwin/cygssl-0.9.8.dll");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/s3270/cygwin/cygcrypto-0.9.8.dll");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/s3270/cygwin/cygcrypto-0.9.8.dll");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			emulatorPath = toolBaseLocation + "/s3270/cygwin/s3270.exe";
			
			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/Global.xlsx");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/Global.xlsx");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/GlobalData.xlsx");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/GlobalData.xlsx");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/Script.txt");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/Script.txt");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

			ddlStream = Initializer.class.getClassLoader().getResourceAsStream("resource/Script.xlsx");
			try (FileOutputStream fos = new FileOutputStream(toolBaseLocation + "/Script.xlsx");) {
				byte[] buf = new byte[2048];
				int r;
				while (-1 != (r = ddlStream.read(buf))) {
					fos.write(buf, 0, r);
				}
			}

		} catch (Exception e1) {
			// e1.printStackTrace();
		}
		
	}
}
