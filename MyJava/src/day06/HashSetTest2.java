package day06;
import java.util.*;
/*Member 클래스의 객체 : VO, DTO, 도메인 객체
 * ==> HashSet에 저장
 * 		"홍길동", 22
 * 		"김길동", 23
 * 		"홍길동", 23
 * 		"홍길동", 22
 */
public class HashSetTest2 {

	public static void main(String[] args) {
		// Member 객체 4개 생성해서 HashSet에 저장하세요
		Member mb1 = new Member();
		Member mb2 = new Member("홍길동", 20);
		Member mb3 = new Member("홍길동", 20);
		Member mb4 = new Member("홍길동", 22);
		Set<Member> hm = new HashSet<>();
		hm.add(mb1);
		hm.add(mb2);
		hm.add(mb3);
		hm.add(mb4);
		System.out.println("hm.size() : " + hm.size());
		System.out.println(mb2.hashCode());
		System.out.println(mb3.hashCode());
		
		System.out.println("mb2.equals(mb3) : " + mb2.equals(mb3));
		System.out.println("mb2.equals(mb4) : " + mb2.equals(mb4));
		
		
		//HashSet에 저장된 회원의 이름, 나이를 한꺼번에 출력하세요
		for(Member user:hm) {
			System.out.println(user.name + " : " + user.age);
		}
	}

}
