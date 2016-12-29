package lesson03.servlets;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class testHashMap {
	public void main(String[] args){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ȫ�浿", 30);
		map.put("�Ӳ���", 40);
		
		if(map.containsKey("ȫ�浿")){
			System.out.println("���̰� ���");
		}
		
//		[HashMap�� ���Ե� key, value�� set�� ��� iterator�� set�� ������ ���´�]
//		* Iterator : �ڹ��� �÷��� �����ӿ����� �÷��ǿ� ����Ǿ� �ִ� ��ҵ��� �о���� ����� ǥ��ȭ�� ����߿� �ϳ��̴�.
//				   Iterator�� �������̽��̴�.
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();

//		[HashMap�� �ִ� key,value�� ���]
//		* hasNext() : hasNext()�� �ǹ̴� Iterator�� ���� ���������� �̵��ϴµ�, Iterator�� ����Ű�� ������������� ���� ��ġ���� �̵��� �׸��� �ִ��� üũ�մϴ�. 
//        ��, Iterator�� ���������� ������������� �ڽ��� ����Ű�� �ִ� ������ �˰� �ֽ��ϴ�.  
//        �ᱹ, �̵��� �׸��� �ִٸ� true�� �����ϰ� �׷��� ������ false�� �����մϴ�.
		while(it.hasNext()){
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)it.next();
			System.out.println("�̸� : " + e.getKey() + "���� : " + e.getValue());
		}
//		[�ʿ� ����� key������ �����ͼ� set�� ����� ������ ����]
		Set<String> set2 = map.keySet();
		System.out.println("��� :" +set2);
		
//		[�ʿ� ����� value ���� collection<Integer> ���·� ���ͼ�, iterator()�� ��´�]
		Iterator<Integer> it2;
		Collection<Integer> values = map.values();
		it2 = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()){
			Integer i = (Integer)it2.next();
			total += i.intValue();
		}
//		[������]
		System.out.print("�ջ� : " + total);
		System.out.print("���� ��� : " + (float)total/set.size());
		System.out.print("���� : " + Collections.max(values));
		System.out.print("�ƿ� : " + Collections.min(values));
		
	}
}
