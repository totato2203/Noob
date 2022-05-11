package javaexp.z01_homework;

public class A0502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-02
//		[1단계:개념] 1. 배열의 속성들을 기술하고, 선언과 할당 방식을 기술하세요
		// 배열의 속성 : 데이터 유형, 배열의 크기, 배열 변수, 데이터
		// new 데이터유형[배열의 크기]; 초기값(0)으로 모든 배열의 구성요소를 할당.
		// {데이터1, 데이터2, 데이터3} : 선언과 직접적인 데이터 할당 한 번
		// new 데이터유형[] {데이터1, 데이터2, 데이터3} : 선언/할당 분리할 때
		
//		[1단계:개념] 2. 배열과 반복문의 관계를 기술하고, 학생 30명을 임의의 점수(0~100)로 배열에 할당/출력하세요.
		// 배열은 반복문을 통해 효과적으로 할당/활용할 수 있다.
		int[] student = new int [30];
		for(int idx = 0; idx < student.length; idx++) {
			System.out.println((idx + 1) + "번 학생의 점수 : " + (int)(Math.random() * 101));
		}
		
//		[1단계:응용] 3. 무지개 색상을 배열로 선언하고, 이 중에서 임의의 색상 3개를 출력하세요
		String[] rainbow = {"빨강", "주황", "노랑", "초록", "파랑", "남색", "보라"};
		// 임의로 나올 index만 지정되면 해당 index에 지정한 색상을 가지고 올 수 있다.
		// 0~6까지 index인데 임의값을 이 범위로 가져오면 rainbow[임의의 index번호]를 통해서 특정한 색상을 가지고 올 수 있다.
		// (int)(Math.random() * 경우의 수 + 시작수);
		// (int)(Math.random() * 7 + 0);
		for(int idx = 0; idx < 3; idx++) {
			System.out.println((idx + 1) + "번째 색상 : " + rainbow[(int)(Math.random()*7)]);
		};
		// 중복 제거 : 배열에서 알고리즘을 활용하여 처리하는데 이중 for문 temp 변수 활용하여 사용한다.
		//		ArrayList shuffle() : 중복없이 섞어주는 처리
		
//		[1단계:응용] 4. 1차원 배열로 회원의 이름 5명을 선언하고 할당 출력하세요
//		         2차원 배열로 위 회원이름에 추가하여 나이와 사는 곳을 만들어 할당하고 출력하세요
		String[] array01 = {"홍길동", "청길동", "고길동", "김철수", "안철수"};
		for(int idx = 0; idx < array01.length; idx++) {
			System.out.println(array01[idx]);
		}
		String[][] array02 = {
				{"홍길동", "10", "서울"},
				{"청길동", "20", "경기"},
				{"김길동", "30", "강원"},
				{"김철수", "40", "충북"},
				{"안철수", "50", "경남"}
				};
		for(int idx = 0; idx < array02.length; idx++) {
			System.out.println("사람의 idx : " + idx);
			for(int jdx = 0; jdx < array02[idx].length; jdx++) {
				System.out.println("\t" + jdx + " : " + array02[idx][jdx]);
			}
		}
		
//		[1단계:개념] 5. main(String args[])에서 args가 사용하는 방법과 내용을 기술하세요
		// 실행 시 외부에서 사용되는 데이터를 배열로 받아 할당할 때 사용되는 메서드.
		// 사용방법 : 먼저 ctrl + F11로 실행하고, 위 메뉴 Run -> Run Configurations... -> Arguments -> Program Arguments에
		//			배열에 들어갈 데이터를 입력하여 사용한다.
//		[1단계:개념] 6. args[]로 구매할 물건명 가격 갯수를 입력받아서 물건명과 총비용을 출력하세요.
		System.out.println("물건명 : " + args[0]);
		System.out.println("가격 : " + args[1]);
		System.out.println("개수 : " + args[2]);
		int price = Integer.parseInt(args[1]);
		int cnt = Integer.parseInt(args[2]);
		int tot = price * cnt;
		System.out.println("총비용 : " + tot);

	}

}
