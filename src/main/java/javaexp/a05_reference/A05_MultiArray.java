package javaexp.a05_reference;

public class A05_MultiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 다차원 배열
		1. 2차원 배열 이상의 배열
		2. 자바는 1차원 배열을 이용하여 2차원 이상의 배열을 구현할 수 있다.
			int[][] 배열명 = new int[크기1][크기2];
		ex) 다차원 배열을 이해하기 위한 비유
			기차 : 1호차, 2호차 ... 5호차
				1호차 안에 좌석 1~80번
				1호차 안 30번 좌석에 착석/예약
			학년 반 번 : 3차원
				int[][][] students = new int[3][5][30];
				students[0][0][20] = 30;
					students라는 배열에 최상위 항목의 1번째 데이터 안에
					차상위 항목 1번째 데이터 안에
					하위 항목 21번째 데이터에 30번을 할당.
		 */
		int[][] multiArry = new int[3][2];
		// cf) 기차로 비유하면 3개의 호차가 있고, 각 호차 안에 좌석 2개가 있는 경우
		System.out.println("상위 차원의 크기 : " + multiArry.length);
		System.out.println("하위 차원의 크기 : " + multiArry[0].length);
		
		// 배열명[바깥쪽상위데이터index][안쪽데이터index]
		multiArry[0][0] = 25;
		multiArry[0][1] = 55;
		multiArry[1][0] = 35;
		multiArry[1][1] = 45;
		multiArry[2][0] = 65;
		multiArry[2][1] = 75;
		for(int idx = 0; idx < multiArry.length; idx++) {
			for(int jdx = 0; jdx < multiArry[idx].length; jdx++) {
				System.out.println("행렬[" + idx + "][" + jdx + "] : " + multiArry[idx][jdx]);
			}
		}
		// ex)2차원 배열로 번호 별 국어/영어/수학 점수를 할당했을 때
		//		3명의 국어/영어/수학 점수를 출력하세요
		int[][] point = {
				{10, 20, 30}, // 첫 번째 학생의 국어, 영어, 수학 점수
				{40, 50, 60}, // 두 번째 학생의 국어, 영어, 수학 점수
				{70, 80, 90}  // 세 번째 학생의 국어, 영어, 수학 점수
				};
		for(int idx = 0; idx < point.length; idx++) {
			for(int jdx = 0; jdx < point[idx].length; jdx++) {
				System.out.println((idx + 1) + "번 학생의 " + (jdx + 1) + "번째 과목 점수 : " + point[idx][jdx]);
			}
		}

	}

}
