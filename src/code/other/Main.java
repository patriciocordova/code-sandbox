package code.other;

public class Main {

	public static void main(String[] args) {
		SyncedObject obj = new SyncedObject();
		ThreadExtended threadl = new ThreadExtended(obj, "1");
		ThreadExtended thread2 = new ThreadExtended(obj, "2");
		threadl.start();
		thread2.start();
	}
}
