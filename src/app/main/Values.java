package app.main;

public class Values {

	static String dname,uname;
	static int cid;

	public static int getCid() {
		return cid;
	}

	public static void setCid(int cid) {
		Values.cid = cid;
	}

	public static String getUname() {
		return uname;
	}

	public static void setUname(String uname) {
		Values.uname = uname;
	}

	public static String getDname() {
		return dname;
	}

	public static void setDname(String dname) {
		Values.dname = dname;
	}
}
