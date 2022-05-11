package javaexp.z02_util;

public class A05_ArgsExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// java A05_ArgsExp 학생명 국어 영어 수학
		// 위와 같이 학생명과 국어 영어 수학 점수를 입력 받아, 해당 정보를 출력하세요.
		// 학생명 : @@
		// 국어 : @@
		// 영어 : @@
		// 수학 : @@
		// 총점 : @@
		// 평균 : @@(소수점 이하 표기)
		
		System.out.println("학생명 : " + args[0]);
		System.out.println("국어 : " + args[1]);
		System.out.println("영어 : " + args[2]);
		System.out.println("수학 : " + args[3]);
		int kor = Integer.parseInt(args[1]);
		int eng = Integer.parseInt(args[2]);
		int math = Integer.parseInt(args[3]);
		int tot = kor + eng + math;
		double avg = tot / (double)3;
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);

	}

}
