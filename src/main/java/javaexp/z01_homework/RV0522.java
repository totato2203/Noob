package javaexp.z01_homework;

public class RV0522 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// a10_exception
		
		/*
		* 활용도가 높은 예외들
			1) NullPointerException
				객체 참조가 없는 상태
				null 값 갖는 참조변수로 객체 접근 연산자 도트(.) 사용했을 때 발생
				String data = null;
				System.out.println(data.toString());
			2) ArrayIndexOutOfBoundsException
				배열에서 인덱스 범위 초과하여 사용할 경우 발생
				String arry[] = {"홍길동", "김길동"};
				System.out.println(arry[2]); // ArrayIndexOutOfBoundsException
					// arry[]의 index는 0, 1 밖에 없는데 arry[2]를 출력하려고 해서 에러 발생
		 */
		
		String name = null;
		System.out.println("프로세스1");
		System.out.println("프로세스2");
		try {
			System.out.println("프로세스3");
			System.out.println("프로세스4");
			System.out.println(name.toString());
			System.out.println("프로세스5"); // 예외가 발생해서 catch(){}로 이동, 출력 안 됨.
			System.out.println("프로세스6");
		}catch(Exception e) {
			System.out.println("예외 발생 -> 예외 메세지 출력");
			System.out.println(e.getMessage());
			System.out.println("프로세스7"); // 예외 메세지 출력 후 이상없이 출력
			System.out.println("프로세스8");
		}finally {
			System.out.println("프로세스9"); // 예외 발생 여부와 상관없이 출력
			System.out.println("프로세스10");
		}
		System.out.println("프로세스11");
		
		System.out.println("-----");
		
		System.out.println("프로세스1");
		System.out.println("프로세스2");
		try {
			System.out.println("프로세스3");
			System.out.println("프로세스4");
			System.out.println(name.toString());
			System.out.println("프로세스5"); // 예외가 발생하면 해당 예외에 해당하는 catch(){}로 이동하고 이하는 출력 안 됨.
			System.out.println("프로세스6");
		}catch(NullPointerException npe) { // 특별한 예외 -> 일반적인 예외 순으로 처리되게 작성한다.
			System.out.println("NullPointerException 발생 -> 예외 메세지 출력");
			System.out.println(npe.getMessage());
			System.out.println("프로세스7"); // 예외 메세지 출력 후 이상 없이 출력
			System.out.println("프로세스8");
		}catch(Exception e) {
			System.out.println("예외 발생 -> 예외 메세지 출력");
			System.out.println(e.getMessage());
			System.out.println("프로세스9"); // 예외 메세지 출력 후 이상 없이 출력
			System.out.println("프로세스10");
		}finally {
			System.out.println("프로세스11");
		}
		System.out.println("프로세스12");
		
		Thrws con = new Thrws();
		
		try {
			con.callString1();
			con.callString2();
			con.callString3();
		}catch(NullPointerException npe) {
			System.out.println("예외 발생 : " + npe.getMessage());
		}
		
		
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
class UserException extends Exception{ // 사용자정의예외 선언

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

class Thrws{
	public void callString1() throws NullPointerException { 
		String name = null;
		System.out.println(name.toString());
	}
	public void callString2() throws NullPointerException {
		String name = null;
		System.out.println(name.toString());
	}
	public void callString3() throws NullPointerException {
		String name = null;
		System.out.println(name.toString());
	}
	// 예외를 메소드 단위의 해당 메소드 별로 코드를 처리하는 것이 아니라 메소드를 처리하는 곳에서 한꺼번에 처리한다.
}