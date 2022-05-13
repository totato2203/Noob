package javaexp.a10_exception;

public class A04_UserException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 사용자 정의 예외와 예외 발생
		1. 예외 발생시키기
		2. 기본 코드
			class 사용자정의예외클래스 extends Exception | RuntimeException{
				public 생성자(){
				
				}
				public void 재정의할메소드(){}
			}
		3. 예외의 처리
			try{
				throw new 사용자정의예외생성자()
			}catch(사용자정의예외클래스 e){
			
			}
		 */
		for(int cnt = 0; cnt <= 10; cnt++) {
			System.out.println("번호 : " + cnt);
			try {
				if(cnt == 5)
					throw new UserException("5일 때 예외 처리");
			}catch(UserException ue) {
				System.out.println(ue.getMessage());
				ue.showMsg();
			}
		}

		
	}
	
}
class UserException extends Exception{

	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		super("생성자매개변수 : " + message); // super는 Exception을 가리킨다.
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "사용자정의예외 : " + super.getMessage();
	}
	public void showMsg() {
		System.out.println("사용자 정의 예외 추가 기능메소드");
	}
	
}