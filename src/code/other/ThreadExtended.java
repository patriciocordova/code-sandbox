package code.other;

public class ThreadExtended extends Thread {
	private String name;
	private SyncedObject myObj;

	public ThreadExtended(SyncedObject obj, String n) {
		name = n;
		myObj = obj;
	}

	public void run() {
		myObj.foo(name);
	}
}