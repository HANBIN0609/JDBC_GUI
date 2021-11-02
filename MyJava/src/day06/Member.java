package day06;

public class Member {
	
	String name;
	int age;
	
	public Member() {
		this("아무개", 20);
	}
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 이름과 나이가 같으면 HashSet이 동일한 데이터로 간주하도록 hashCode(), equals() 메소드를
	// 오버라이드 하자
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			boolean bool = member.name.equals(this.name) && (member.age == this.age);
			return bool;
		} else {
			return false;
		}
	}
}
