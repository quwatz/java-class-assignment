package BuilderClass;

public class BuilderCode {
	
	
	public static void main(String args[]) {
		Builder builder = new Builder().setBuilderFloat(6.3f).setBuilderInt(3).setBuilderString("bruh");
		System.out.println(builder.getBuilderFloat()+"-"+builder.getBuilderInt()+"-"+builder.getBuilderString() );
	}
}
