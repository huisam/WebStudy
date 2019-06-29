package aop4;

import java.util.Random;

public class Girl implements IPerson {
	public String doSomething() throws Exception {
		System.out.println("드라마를 본다");
		Random ran = new Random();
		if(ran.nextBoolean()) {
			throw new Exception("불이야");
		}
		return "I'm a girl";
	}
}
