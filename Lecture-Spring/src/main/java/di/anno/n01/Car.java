package di.anno.n01;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

	@Autowired
//	@Resource
	private Tire tire;		// 의존관계 발생
	
	public Car() {
		System.out.println("Car() 호출...");
	}
	
	// 생성자 주입
//	@Autowired
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	
	// 속성주입(Setter 주입)
//	@Autowired
//	@Resource
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) 호출...");
	}
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}











