package javaexp.z10_project;

import java.util.ArrayList;
import java.util.Scanner;


public class project02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 온라인 문의
		//	 1. 문의하기
		Ask ask01 = new Ask(
				"배송문의", "전장호", "010-1234-5678",
				"wkdgh1001@naver.com", "1q2w3e4r",
				"택배가 왤케 안 와요?");
		
		ArrayList<Ask> alist = new ArrayList<Ask>();
		alist.add(new Ask("배송문의", "전장호", "01012345678", "mailmail@gmail.com", "1q2w3e4r", "택배가 왤케 안 오나요?"));
		
		Ask ask02 = new Ask();
		ask02.insertData();
	}

}
class Ask{
	private String var;			// 문의 유형
	private String name;		// 이름
	private String phone;		// 전화번호
	private String email;		// 이메일
	private String password;	// 비밀번호
	private String contents;	// 내용
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
		Scanner sc = new Scanner(System.in);
		System.out.println("문의 유형을 선택하세요. (배송 / 수거 / 사고보상 / 이벤트)");
		var = sc.nextLine();
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		phone = sc.nextLine();
		email = sc.nextLine();
		password = sc.nextLine();
		contents = sc.nextLine();
		
		System.out.println(var + name + phone);
	}
}
