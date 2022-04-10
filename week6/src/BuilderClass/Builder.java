package BuilderClass;

public class Builder {
	private int builderInt;
	private float builderFloat;
	private String builderString;
	
	public Builder setBuilderInt(int a) {
		this.builderInt = a;
		return this;
	}
	public Builder setBuilderFloat(float f) {
		this.builderFloat = f;
		return this;
	}
	public Builder setBuilderString(String s) {
		this.builderString = s;
		return this;
	}
	public int getBuilderInt() {
		return this.builderInt;
	}
	public String getBuilderString() {
		return this.builderString;
	}
	public float getBuilderFloat() {
		return this.builderFloat;
	}
}
