package javaexp.z10_project;

public class project02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 온라인 문의
		//	 1. 문의하기
		

	}

}
class Ask{
	private String var = "";
	private String parcelno = "";
	private String name = "";
	private String phone = "";
	private String password = "";
	private String contents = "";
	public Ask() {}
	public Ask(String var, String parcelno, String name, String phone, String password, String contents) {
		this.var = var;
		this.parcelno = parcelno;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.contents = contents;
	}
}