package LazySingleton;

public class LazyRegistry {
	private static LazyRegistry registrator;
	private String userName;
	private String passWord;
	public synchronized static LazyRegistry getInstange() {
		if (registrator == null)
		{
			registrator = new LazyRegistry();
		}
		return registrator;
	}
	private LazyRegistry() {}
	public void setUserName(String _userName) {
		this.userName = _userName;
	}
	public void setPassWord(String _passWord) {
		this.passWord = _passWord;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getPassWord() {
		return this.passWord;
	}

}
