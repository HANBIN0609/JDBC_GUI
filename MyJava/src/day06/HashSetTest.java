package day06;
/*- HashSet
 *  Set계열
 *   - 순서를 기억하지 않음
 *   - 데이터 중복을 허용하지 않음
 *   - 해시셋은 객체를 저장하기 전에 객체의 hashCode()를 호출해서
 *   해시코드를 얻어낸다. 그리고 이미 저장되어 있는 객체들의 해시코드와
 *   비교한다. 만약 동일한 해시코드가 있다면 다시 equals()메소드로
 *   두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고
 *   중복 저장을 하지 않는다.

 */
import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		//add() : 데이터저장
		set.add("Java");
		set.add("SQL");
		set.add("JDBC");
		set.add("JSP");
		//size() : 저장된 데이터 수
		System.out.println("set.size() : " + set.size());
		set.add("Java");
		System.out.println("set.size() 2: " + set.size());
		
		// iterator() 이용해서 set에 저장된 값을 한꺼번에 출력하기
		Iterator<String> setIt = set.iterator();
		while(setIt.hasNext()) {
			String it = setIt.next();
			System.out.println(it);
		}
		
		// remove(E e) : 삭제
		set.remove("JDBC");
		System.out.println("--------------------------");
		// for each 루프문 이용해서 출력해보기
		for(String s:set) {
			System.out.println(s);
		}
		System.out.println("**************************");
		set.clear(); // removeAll()
		System.out.println("set.Size3 : " + set.size());
		
		if(set.isEmpty()) System.out.println("비어 있어요");
	}

}
