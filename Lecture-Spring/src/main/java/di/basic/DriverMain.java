package di.basic;

public class DriverMain {

	public static void main(String[] args) {
		
//		Tire tire = new HankookTire();
		Tire tire = new KumhoTire();
		
		// 1. 생성자 주입
		//Car car = new Car(tire); 
		
		Car car = new Car();
		car.setTire(tire);
		
		car.prnTireBrand();
	}
}
