package jsonpayload;

public class MethodChaining {

	public static MethodChaining method1()
	{
		System.out.println("method1");
		return new MethodChaining();
	}
	public MethodChaining method2()
	{
		System.out.println("method2");
		return this;
	}
	public MethodChaining method3()
	{
		System.out.println("method3");
		return this;
	}

}
