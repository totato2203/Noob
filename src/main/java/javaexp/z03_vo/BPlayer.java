package javaexp.z03_vo;

public class BPlayer {
	private int num;
	private String name;
	private String birth;
	
	public BPlayer() {
		// TODO Auto-generated constructor stub
	}
	public BPlayer(int num, String name, String birth) {
		super();
		this.num = num;
		this.name = name;
		this.birth = birth;
	}
	public void show() {
		System.out.print(num + "\t");
		System.out.print(name + "\t");
		System.out.print(birth + "\n");
	}
	@Override
	public String toString() {
		return "BPlayer [num=" + num + ", name=" + name + ", birth=" + birth + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
}
