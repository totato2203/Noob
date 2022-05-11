package javaexp.a09_inherit;

public class A02_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 부모 생성자 호출 : super()
		1. 상속하는 클래스는 부모의 생성자를 반드시 호출하여야 한다.
			1) default 생성자는 기본적 default 생성자를 호출하기 때문에 선언하지 않더라도 에러가 없다.
				- 자바의 모든 클래스는 extends Object로 상속을 받아서 처리한다.
					그래서 default이기에 선언하지 않는다.
				class Father extends Object{}
				class Son extends Father{
					public Son(){
						super();
					}
				}
			2) 상위 클래스에 매개변수가 있는 생성자를 선언했을 때
				class Mother{
					String name;
					Mother(String name){
						this.name = name;
					}
				}
				class Daughter extends Mother{
					Daughter(String name){
						super(name); // 반드시 상위에 있는 생성자 호출
					}
				}
		 */
		Daughter01 d1 = new Daughter01("김희선");
		d1.call();

	}

}
class Mother01{
	String name;
	Mother01(String name){
		this.name = name;
	}
	void call() {
		System.out.println("이름 : " + name);
	}
}
class Daughter01 extends Mother01{
	/*
	Daughter01(){ super() }
	 */
	Daughter01(){
//		String name = "하이"; // 첫 라인에 다른 게 들어가면 에러
		super("하위매개값(이름)");
		// 반드시 생성자 첫 라인에 상위 클래스 선언하는 생성자의 매개변수에 맞는
		// super()로 상위 클래스의 생성자를 호출하여야 한다.
	}
	Daughter01(String name){
		super(name); // 이렇게 하면 private로 선언된 상위 필드도 접근하여 할당한다.
	}
}