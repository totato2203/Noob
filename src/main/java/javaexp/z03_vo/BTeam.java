package javaexp.z03_vo;

import java.util.ArrayList;

public class BTeam {
	private String tName;
	private ArrayList<BPlayer> plist;
	
	public BTeam() {
		plist = new ArrayList<BPlayer>();
	}
	
	public BTeam(String tName) {
		this.tName = tName;
		plist = new ArrayList<BPlayer>();
	}

	// 구성원 한 명씩 추가
	public void addPlayer(BPlayer bp) {
		System.out.println(bp.getName() + " 선수의 정보를 추가했습니다.");
		plist.add(bp); // 동적배열.add(객체) : 동적배열에 객체 추가 처리
	}
	public void showTeamList() {
		if(plist.size() == 0) {
			System.out.println(tName + " 팀에 선수가 없습니다.");
		}else {
			System.out.println("# " + tName + " 팀의 선수 정보 #");
			for(BPlayer bp : plist) {
				bp.show();
			}
		}
	}
	

	@Override
	public String toString() {
		return "BTeam [tName=" + tName + ", plist=" + plist + "]";
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public ArrayList<BPlayer> getPlist() {
		return plist;
	}

	public void setPlist(ArrayList<BPlayer> plist) {
		this.plist = plist;
	}
	
}

/*
BTeam : 팀명, ArrayList<BPlayer>
		 		public void addPlayer(BPlayer bp)
		 		public void showTeamList()
		 		팀명과 등록된 선수 정보 출력
 */