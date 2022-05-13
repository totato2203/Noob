package javaexp.a10_exception;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 예외와 예외 클래스
		1. 오류의 종류
			1) 에러
				하드웨어의 잘못된 동작 또는 고장으로 인한 오류 에러가 발생되면 프로그램 종료
				정상 실행 상태로 돌아갈 수 없음
			2) 예외(exception)
				사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인한 오류
				예외가 발생되면 프로그램 종료
				예외 처리 추가하면 정상 실행 상태로 돌아갈 수 있음
		2. 예외의 종류
			1) 일반(컴파일 체크) 예외(EXCEPTION)
				예외 처리 코드 없으면 컴파일 오류 발생
			2) 실행 예외(RuntimeException)
				예외 처리 코드를 생략하더라도 컴파일이 되는 예외
				경험 따라 예외 처리 코드 작성 필요
		3. 예외 클래스
			1) 예외 클래스도 상속에 의해 계층적으로 처리할 수 있다.
				- 상위 클래스
				java.lang.Exception
					- 하위 클래스(컴파일 체크) 예외
						ClassNotFoundingException
						InterruptedException
					- 하위 클래스(실행 체크) 예외
						NullPointerException
						FormatException
						ArrayIndexOutOfBoundsException
			2) 활용도가 높은 예외들
				NullPointerException
					객체 참조가 없는 상태
					null 값 갖는 참조변수로 객체 접근 연산자 도트(.) 사용했을 때 발생
					String data = null;
					System.out.println(data.toString());
				ArrayIndexOutOfBoundsException
					배열에서 인덱스 범위 초과하여 사용할 경우 발생
					String arry[] = {"홍길동", "김길동"};
					System.out.println(arry[2]); // ArrayIndexOutOfBoundsException
						// arry[]의 index는 0, 1 밖에 없는데 arry[2]를 출력하려고 해서 에러 발생
		4. 예외처리 기본 코드
			1) 예외 발생 시 프로그램 종료를 막고, 정상 실행을 유지할 수 있도록 처리
				- 일반 예외 : 반드시 작성해야 컴파일 가능
					IO가 일어나는 경우, 메모리를 사용하는 경우, DB연동처리
				- 실행 예외 : 컴파일러가 체크해주지 않으면 개발자 경험에 의해 작성
					데이터 또는 프로세스 진행에 따라 발생하는 경우
			2) 기본 형식
				try{
					예외가 일어날 가능성이 있는 코드
				}catch(Exception e){
					예외가 일어날 때, 처리할 블럭
				}finally{
					예외가 있든지 없든지 수행할 블럭
				}
					
		 */
		
		System.out.println("프로세스1");
//		System.out.println(1/0); // 에러가 발생하면 더 이상 프로세스가 진행하지 않음
		System.out.println("프로세스2");
		try {
			System.out.println("프로세스3");
			System.out.println(1/0);
			// 예외가 발생하더라도 프로그램의 프로세스는 계속 유지할 수 있다.
			// 예외가 발생하는 시점에서 바로 catch 블럭으로 예외를 던진다.
			System.out.println("프로세스4");
			System.out.println("프로세스5");
		}catch(Exception e) {
			System.out.println("에러 처리");
			System.out.println(e.getMessage());
			System.out.println("프로세스6");
			System.out.println("프로세스7");
		}finally {
			System.out.println("프로세스8");
		}
		System.out.println("프로세스9");
		// ex) String name = null; System.out.println(name.toString());
		// 위 코드를 try{}catch 구문 없이 처리하고, 다시 try{} catch 구문으로 처리하여
		// 예외 프로세스가 어떻게 흘러가는지를 확인하세요
		System.out.println("프로세스10");
//		System.out.println(name.toString()); // 에러 발생
		try{
			String name = null;
			System.out.println(name.toString());
			System.out.println("프로세스11");
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("프로세스12");
		}finally {
			System.out.println("프로세스13");
		}
		System.out.println("프로세스14");
		System.out.println("프로세스15");
		
	/*
	1. 예외가 나올 수 있는 코드를 작성한다.
	2. 실행 후, console 창에 발생한 예외를 복사한다.
	3. catch(복사한 예외 내용){e.getMessage()}
	4. 기타 기본형식을 추가하여 완료한다.
	 */
		try {
			String arr[] = {"홍", "길", "동"};
			System.out.println(arr[3]);
		}catch(ArrayIndexOutOfBoundsException aob) {
			System.out.println("# 예외 발생 #");
			System.out.println(aob.getMessage());
		}finally {
			System.out.println("예외 내용 상관없이 수행");
		}
		System.out.println("프로그래밍 계속 진행..");
		// ex) System.out.println(Integer.parseInt("이십오"));
		// 위 코드로 발생하는 예외를 처리하고 처리한 결과를 수행하세요.
		try {
			System.out.println(Integer.parseInt("이십오"));
			// 숫자 형식의 문자열을 넣지 않아서 에러
		}catch(NumberFormatException nfe) {
			System.out.println("# 예외 발생 #");
			System.out.println(nfe.getMessage());
		}finally {
			System.out.println("예외 내용 상관없이 수행");
		}
		System.out.println("프로그래밍 계속 진행");
		
	}
}
