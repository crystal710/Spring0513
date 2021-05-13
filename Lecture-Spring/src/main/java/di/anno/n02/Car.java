package di.anno.n02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {

//	@Autowired(required = false)
	private Tire tire;		// 의존관계 발생
	
	public Car() {
		System.out.println("Car() 호출...");
	}
	
	// 생성자 주입
	@Autowired
	public Car(@Qualifier("kumho") Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	
	// 속성주입(Setter 주입)
//	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) 호출...");
	}
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}











