package javaexp.z01_homework;

import java.util.Scanner;

public class A0513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-13
//		[1단계:개념] 1. 예외 처리의 기본 형식과 처리 순서를 기본 예제에 의해 기술하세요.
		/*
		예외 처리 기본 형식 :
		try{
			예외가 일어날 가능성이 있는 코드
		}catch(Exception e){
			예외가 일어날 때, 처리할 블럭
		}finally{
			예외가 있든지 없든지 수행할 블럭
		}
		 */
		try {
			System.out.println(Integer.parseInt(args[0]));
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("예외(배열범위) : " + ae.getMessage());
			// 예외가 발생해서 "예외(배열범위) : Index 0 out of bounds for length"가 출력되었다.
			// 이후 args[0] = "이십오" 로 예외 해결
		}catch(NumberFormatException nfe) {
			System.out.println("예외(format) : " + nfe.getMessage());
			// 위 예외는 해결했으나 "이십오"는 숫자형 문자열이 아니기 때문에 다시 다른(NumberFormatException) 예외 발생
		}catch(Exception e) {
			System.out.println("기타 예외 : " + e.getMessage());
			// 위의 NumberFormatException에서 예외가 발생해서 기타 예외는 출력되지 않는다.
		}finally {
			System.out.println("이 문장은 예외가 발생한 경우, 발생하지 않은 경우 모두 출력된다.");
			// finally는 예외 발생 여부에 상관없이 출력된다.
		}
		System.out.println("예외 처리 완료!!");
		// 일반적인 예외(Exception)보다 특별한 예외들(ArrayIndexOutOfBoundsException, NumberFormatException, ...)을 먼저 처리하도록 한다.
		
//		[1단계:확인] 2. args를 통해서 나올 수 있는 예외를 아래에 하나씩 처리하세요
//		      1) args값을 입력하지 않았을 때.
//		      2) args값의 배열의 범위를 넘어설 때.
//		      3) args의 값 중에 숫자형 문자를 입력하여야 하는데 문자 자체를 입력했을 때.
		try {
			System.out.println(Integer.parseInt(args[3]));
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("예외1 : ArrayIndexOutOfBoundsException\n" + ae.getMessage()); // 1), 2)의 경우에 출력됨
		}catch(NumberFormatException nfe) {
			System.out.println("예외2 : NumberFormatException\n" + nfe.getMessage()); // 3)의 경우에 출력됨
		}
		
		
//		[1단계:개념] 3. 예외 처리의 계층별 처리란 무엇인지 기술하세요.
		// 다중의 예외를 처리할 때 일반적인 예외(Exception)보다
		// 특별한 예외들(ArrayIndexOutOfBoundsException, NumberFormatException, ...)을 먼저 처리하도록 하는 것이다.
		
//		[1단계:개념] 4. 예외의 위임처리하는 내용을 예제를 통해서 기술하세요.
		School sch = new School();
		try{
			sch.student01();
			sch.student02();
			sch.student03(); // NullPointerException 예외 발생
		}catch(NullPointerException npe) {
			System.out.println("학생 이름 누락"); // sc.student03();에서 출력
		}
		
//		[1단계:확인] 5. DBException이라는 사용자 정의 예외를 선언하고, Scanner를 통해서
//		      입력되는 값이  null이거나 공백문자일 때, 처리되게 하세요.
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("이름을 입력하세요(공백 입력 시 예외 발생) : ");
			String name = sc.nextLine();
			try {
				if(name == null || name == " " || name == "") {
					throw new DBException("공백을 입력하여 예외가 발생했습니다.");
				}else {
					System.out.println("입력한 이름 : " + name);
				}
			}catch(DBException dbe) {
				System.out.println(dbe.getMessage());
				break;
			}
		}
	}

}
class DBException extends Exception{
	public DBException() {}
	public DBException(String msg) {
		super("(사용자가 정의한 에러 메세지) : " + msg);
	}
	@Override
	public String getMessage() {
		return "(새로 정의된 에러 메세지 방식) : " + super.getMessage();
	}
}
class School{
	public void student01() throws NullPointerException {
		String name = "철수";
		System.out.println(name.toString());
	}
	public void student02() throws NullPointerException {
		String name = "영희";
		System.out.println(name.toString());
	}
	public void student03() throws NullPointerException{
		String name = null;
		System.out.println(name.toString());
	}
}