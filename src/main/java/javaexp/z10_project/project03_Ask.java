package javaexp.z10_project;

import java.util.ArrayList;
import java.util.Scanner;


public class project02_Ask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 온라인 문의
		//	 1. 비회원 문의 등록 및 조회
		
		Ask ask01 = new Ask();
		ask01.insertData();	// 비회원 문의1 등록
		ask01.insertData();	// 비회원 문의2 등록
		ask01.insertData();	// 비회원 문의3 등록
		ask01.searchAsk();	// 비회원 문의 내역 조회
		ask01.searchAsk();	// 비회원 문의 내역 조회
		ask01.searchAsk();	// 비회원 문의 내역 조회
	}

}
class Ask{
	private String var;			// 문의 유형
	private String name;		// 이름
	private String phone;		// 전화번호
	private String email;		// 이메일
	private String password;	// 비밀번호
	private String contents;	// 내용
	ArrayList<Ask> alist = new ArrayList<Ask>();
	Scanner sc = new Scanner(System.in);
	public Ask() {}
	public Ask(String var, String name, String phone, String email, String password, String contents) {
		this.var = var;
		this.name = name;
		this.phone = phone;
		this.email = email;		
		this.password = password;
		this.contents = contents;
	}
	public void insertData() {
		System.out.println("문의 유형을 선택하세요. (배송 / 수거 / 사고보상 / 이벤트)");
		var = sc.nextLine();
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		System.out.println("전화번호를 입력하세요. ('-' 없이)");
		phone = sc.nextLine();
		System.out.println("이메일을 입력하세요.");
		email = sc.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		password = sc.nextLine();
		System.out.println("문의할 내용을 작성해주세요.");
		contents = sc.nextLine();
		
		alist.add(new Ask(var, name, phone, email, password, contents));
		
		System.out.println("문의 등록 완료!!\n");
	}
	public void searchAsk() {
		String name2;
		String phone2;
		String password2;
		
		System.out.println("이름을 입력하세요.");
		name2 = sc.nextLine();
		System.out.println("전화번호을 입력하세요. ('-' 없이)");
		phone2 = sc.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		password2 = sc.nextLine();
		int i = 0;
		for(int idx = 0; idx < alist.size(); idx++) {
			if(name2.equals(alist.get(idx).name)
			&& phone2.equals(alist.get(idx).phone)
			&& password2.equals(alist.get(idx).password)){
				System.out.println("\n# 문의 내역 #");
				System.out.println("문의 유형 : "  + alist.get(idx).var);
				System.out.println("이름 : " + alist.get(idx).name);
				System.out.println("전화번호 : " + alist.get(idx).phone);
				System.out.println("이메일 : " + alist.get(idx).email);
				System.out.println("비밀번호 : " + alist.get(idx).password);
				System.out.println("문의 내용 : " + alist.get(idx).contents);
				i = 1;
			}
		}
		if(i != 1) {
			System.out.println("입력하신 정보로 등록된 문의 내역이 없습니다.");
		}

	}
}
