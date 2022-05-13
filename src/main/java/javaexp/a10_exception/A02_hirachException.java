package javaexp.a10_exception;

public class A02_hirachException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 예외 처리 순서
		1. 다중의 예외를 처리할 때 아래의 여러 예외 별로 catch를 통해 처리할 수 있다.
		2. 이와 같이 다중의 예외를 처리할 때에는 상속관계로 가장 하단에 있는
			예외부터 처리하고, 점점 상위에 있는 예외를 처리한다.
			try{
			
			}catch(최하위에 있는 예외){
			
			}catch(차상위에 있는 예외){
			
			}catch(최상위에 있는 예외){
			
			}
		 */
		// System.out.println(Integer.parseInt(args[0]));
		try {
			System.out.println(Integer.parseInt(args[0]));
		}catch(ArrayIndexOutOfBoundsException ae) { //args[0] = "이십오" 로 예외 해결
			System.out.println("예외(배열범위) : " + ae.getMessage());
		}catch(NumberFormatException nfe) { // "이십오"는 숫자형 문자열이 아니기 때문에 예외 발생
			System.out.println("예외(format) : " + nfe.getMessage());
		}catch(Exception e) {
			System.out.println("기타 예외 : " + e.getMessage());
		}
		System.out.println("예외 처리 완료!!");

	}

}
