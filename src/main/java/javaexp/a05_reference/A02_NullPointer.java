package javaexp.a05_reference;

public class A02_NullPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# null
		1. 변수가 참조하는 객체가 없는 경우 초기값으로 사용 가능
			(stack)		[			]
						[	 heap	]
						[			]
			heap 영역에는 할당하지 않고 stack 영역에서 선언만 한 상태에서 객체를 초기화 시키는 것을 말한다.
			Person p = null;
			cf) 기본 데이터 유형을 일반적으로 해당 유형에 맞게 초기화 시킨다.
				int num01 = 0; double num02 = 0.0;
		2. 참조 타입의 변수에만 저장 가능하다.
		3. null로 초기화된 참조 변수는 스택 영역 생성
		4. 객체가 heap 영역에 생성되지 않는 가운데서 해당 구성요소를 메모리상 호출하면
			NullPointerException이 발생한다.
		 */
		Friend f = null; // 객체가 선언하고, heap 영역에 생성되지 않음.
		// 객체의 초기화로 객체를 선언하지 않을 때, null로 선언한다.
		System.out.println(f); // 객체는 선언이 되어 있지만 heap 영역에는 할당되지 않은 상황이라 null을 표시한다.
		// System.out.println(f.name); NullPointerException
		// NullPointerException : Pointer(주소값)이 Null(없는) Exception(에러/예외) 발생했습니다.
		//	ㄴ 객체가 가지고 있는 구성요소를 호출할 때 발생하는 예외
		f = new Friend();
		// 객체가 선언되고 객체를 생성하여 heap 영역에 메모리를 할당할 수 있다.
		Friend f1 = new Friend();
		System.out.println(f1);
		System.out.println(f1.name);
		System.out.println(f);
//		System.out.println(f.name);

	}

}
class Friend{
	String name = "친구1";
}