package aop1;

public class PersonProxy implements IPerson {
	private IPerson person;

	public void setPerson(IPerson person) {
		this.person = person;
	}

	public void doSomething() {
		System.out.println("문을 열고 집에 들어감");
		try {
			person.doSomething();
			System.out.println("불끄고 잔다");
		} catch (IllegalStateException e) {
			System.err.println("119에 신고한다");
		} finally {
			System.out.println("문을 열고 나온다");
		}
	}
}
