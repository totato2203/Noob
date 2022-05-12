package javaexp.a07_multiObj;

import java.util.ArrayList;

//해당 패키지 안에 있는 모든 클래스를 객체화하여 사용 가능
import javaexp.z03_vo.*;

public class A10_OneVsMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 1:다 관계 객체 처리
		1. 프로그래밍에서 1:다 관계의 내용은 자주 발생하는 프로그래밍 형태이다.
		2. 하나의 클래스 안에 여러 개의 다중 선언된 클래스를 호출하여 선언하고 할당하는 경우를 말한다.
			1) 다른 종류의 여러가지 객체가 할당되는 경우
				ex) 컴퓨터 안에 cpu, ram, hdd 등 여러가지 다른 종류의 내용들이 할당되어 사용되는 경우
			2) 같은 종류의 여러가지 객체가 할당되는 경우
				ex) 마트 안에 판매하는 여러 개의 물품을 구매하는 경우
					배열이나 동적 배열 ArrayList를 통해 처리
			3) 하나의 클래스 안에 같은 종류의 다중 클래스 선언과 호출, 다른 종류의 클래스 선언과 호출
		3. 위 내용은 하나씩 객체를 할당하는 메서드를 사용하는 경우와 한꺼번에 할당하는 경우가 있다.
			1) 마트에서 물건을 하나씩 담는 경우
				ex)
				class Mart{
					private ArrayList<Product> plist;
					public void buyOne(Product p){
						plist.add(p)
					}
				}
			2) 마트에서 세트로 물건을 바로 담는 경우
				class Mart{
					private ArrayList<Product> plist;
					public void buyAll(ArrayList<Product> plist){
						this.plist = plist;
					}
				}
		4. 담은 다중의 물건을 확인할 때, 반복문을 활용한다. 단, 이 때도 조건 처리를 통해
			해당 내용 메모리를 확인하거나, 담은 개수가 1 이상인 경우로 처리하는 경우가 많다.
				public void calcuProd(){
					System.out.println(name + "마트에서 구매한 물건 계산");
					if(plist != null && plist.size() > 0){
						for(Product p : plist){
							p.showInfo();
						}
					}
				}
		5. 구현 순서
			1) 다중으로 처리한 종속된 단위 객체를 위한 클래스 선언
			2) 해당 다중 객체를 포함할 클래스 선언
				- 필드 : 사용된 속성, ArrayList<단위객체>
				- 초기 생성자 설정 : 속성값 초기화, ArrayList<단위객체> 객체 생성
				- 다중의 데이터 처리할 입력 메서드 선언
				- 1:다 관계로 출력하거나 리턴할 객체 선언
		 */
		Mart m = new Mart("행복"); // ctrl + shift + o 
		m.calcu();
		m.addCart(new Product("사과", 3000, 2));
		m.addCart(new Product("바나나", 4000, 3));
		m.addCart(new Product("딸기", 12000, 3));
		m.calcu();

		/*
		ex) BPlayer : 번호, 이름, 생년월일	show() 단위정보
		 	BTeam : 팀명, ArrayList<BPlayer>
		 		public void addPlayer(BPlayer bp)
		 		public void showTeamList()
		 		팀명과 등록된 선수 정보 출력
		 1) package javaexp.z03_vo;에
		 	BPlayer 클래스 선언
		 	BTeam 클래스 선언
		 2) main() 호출 처리
		 		BTeam 객체 생성과 초기화
		 		BPlayer 단위객체 추가 처리(3명 정도 등록)
		 		전체리스트 출력메서드 호출
		 */
		
		BTeam t = new BTeam("한화");
		t.showTeamList();
		// BPlayer(int num, String name, String birth)
		ArrayList<BPlayer> blist = new ArrayList<BPlayer>();
		blist.add(new BPlayer());
		blist.add(new BPlayer());
		blist.add(new BPlayer());
		
		
		
		t.addPlayer(new BPlayer(1, "류현진", "881010"));
		t.addPlayer(new BPlayer(2, "야잘알", "850505"));
		t.addPlayer(new BPlayer(3, "야알못", "810707"));
		t.showTeamList();
	}

}
