package day06;
/*1. 사용자 정의 예외 만들기
 * 1)  Exception을 상속받는다.
 * 2) 생성자를 구성한 뒤에 생성자 안에서 super("예외메시지"); 를 명시적으로 호출한다
 *2. 사용자 정의 예외 사용하기
 *   1) 예외 객체를 생성할 때는 throw와 함께 사용한다
 *  2) 메소드 헤더에 throws로 해당 예외를 선언한다. 
 * */
public class NotSupportedNameException extends Exception{
   
   public NotSupportedNameException() {
      super("NotSupportedNameException");
   }
   public NotSupportedNameException(String msg) {
      super(msg);
   }

}