package day06;
/*1. ����� ���� ���� �����
 * 1)  Exception�� ��ӹ޴´�.
 * 2) �����ڸ� ������ �ڿ� ������ �ȿ��� super("���ܸ޽���"); �� ��������� ȣ���Ѵ�
 *2. ����� ���� ���� ����ϱ�
 *   1) ���� ��ü�� ������ ���� throw�� �Բ� ����Ѵ�
 *  2) �޼ҵ� ����� throws�� �ش� ���ܸ� �����Ѵ�. 
 * */
public class NotSupportedNameException extends Exception{
   
   public NotSupportedNameException() {
      super("NotSupportedNameException");
   }
   public NotSupportedNameException(String msg) {
      super(msg);
   }

}