package diz10;

import org.springframework.stereotype.Component;

@Component
class KoreaTire implements Tire{
	public String getName() {
		return "국산 타이어";
	}
}
