package day06;
import java.util.*;
/*Member Ŭ������ ��ü : VO, DTO, ������ ��ü
 * ==> HashSet�� ����
 * 		"ȫ�浿", 22
 * 		"��浿", 23
 * 		"ȫ�浿", 23
 * 		"ȫ�浿", 22
 */
public class HashSetTest2 {

	public static void main(String[] args) {
		// Member ��ü 4�� �����ؼ� HashSet�� �����ϼ���
		Member mb1 = new Member();
		Member mb2 = new Member("ȫ�浿", 20);
		Member mb3 = new Member("ȫ�浿", 20);
		Member mb4 = new Member("ȫ�浿", 22);
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
		
		
		//HashSet�� ����� ȸ���� �̸�, ���̸� �Ѳ����� ����ϼ���
		for(Member user:hm) {
			System.out.println(user.name + " : " + user.age);
		}
	}

}
