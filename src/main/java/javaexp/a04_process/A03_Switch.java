package javaexp.a04_process;

public class A03_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# switch문
		1. 변수나 연산식의 값에 따라 실행문을 선택할 때 사용한다.
		2. 기본형식
			switch(변수){
				case 값1:
					처리할 내용
					break;
				case 값2:
					처리할 내용
					break;
				case 값3:
					처리할 내용
					break;
				default:
					// 상단에 선언한 값이 아닌 경우.
			}
		 */
		int btnNum = 1; // 특정한 공간에 스위치버튼 클릭
		switch(btnNum) {
			case 1:
				System.out.println("A 구역에 불이 켜졌습니다.");
				break;
			case 2:
				System.out.println("B 구역에 불이 켜졌습니다.");
				break;
			case 3:
				System.out.println("C 구역에 불이 켜졌습니다.");
				break;
			default:
				System.out.println("해당 버튼은 지정된 버튼이 아닙니다.");
				
		}
		/*
		 ex) 주사위 번호를 변수로 선언해서 1, 3번은 빙고라고 출력,
		 	2, 4번은 행운의 번호 출력, 5, 6번은 gogo! 라고 출력,
		 	그 외는 주사위 번호가 아닙니다. 라고 출력 처리하세요.
		 */
		
		int diceNum = 1;
		switch(diceNum) {
		case 1: // break가 없는 경우 밑으로 프로세스가 진행된다.
		case 3:
			System.out.println("빙고!");
			break; // break 만나는 순간 중괄호 블럭을 벗어난다.
		case 2, 4:
			System.out.println("행운의 번호!");
			break;
		case 5, 6:
			System.out.println("gogo!");
			break;
		default:
			System.out.println("주사위 번호가 아닙니다.");
		}

	}

}
