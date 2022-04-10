package CarBrands;

public abstract class CarClass {
	private String brandName;
	public String getBrandName() {return this.brandName;}
	public void setBrandName(String _brandName) {this.brandName=_brandName;}
	private int speed;
	public int getSpeed() {return speed;}
	public void setSpeed(int _speed) {this.speed = _speed;}
	private String sound;
	public String getSound() {return this.sound;}
	public void setSound(String _sound) {this.sound= _sound;}
	
	public void flex() {
		System.out.println("I own a "+ brandName+" it can drive at "+speed+" km/h");
	}
	public abstract void propietaryFunction();
	public void honk() {
		System.out.println(sound);
	}
	
	
	
}
