package javaexp.z03_vo;

import java.util.ArrayList;

public class Mart {
	private String name;

	private ArrayList<Product> plist; // ctrl + shift + o
	public Mart() {
		// 기본생성자를 통해 동적배열을 초기화
		plist = new ArrayList<Product>();
	}
	public Mart(String name) {
		this.name = name;
		plist = new ArrayList<Product>();
	}
	// 하나씩 물건담기
	public void addCart(Product prod) {
		System.out.println(prod.getName() + " 물건을 카드에 담았습니다.");
		plist.add(prod);
	}
	// 담긴 물건정보 출력 및 계산 처리
	public void calcu() {
		System.out.println(name + "마트에서 구매한 물건과 총계");
		if(plist.size()>0) {
			int tot = 0;
			for(Product prod : plist) {
				tot += prod.show();
			}
			System.out.println("총 비용 : " + tot + "원");
		}else {
			System.out.println("구매한 물건이 없습니다.");
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Product> getPlist() {
		return plist;
	}
	public void setPlist(ArrayList<Product> plist) {
		this.plist = plist;
	}
	
}
