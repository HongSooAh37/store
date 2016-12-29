package arabiannight.tistroy.com;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {

	public static void main(String[] args) {
		HashMap<String , Integer> map = new HashMap<String , Integer>();
		map.put("김태희", new Integer(90));
		map.put("전혜빈", new Integer(80));
		map.put("유인나", new Integer(100));
		map.put("아이유", new Integer(90));
		
		if(map.containsKey("유인나")){
			System.out.println("유인나 최고");
		}
		
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();
		
		while (it.hasNext()) {
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		
		Set<String> set2 = map.keySet();
		System.out.println("참가자 명단 : " + set2);
		
		Iterator<Integer> it2;
		Collection<Integer> values = map.values();
		it2 = values.iterator();
		
		int total = 0;
		
		while (it2.hasNext()) {
			Integer i = (Integer)it2.next();
			total += i.intValue();
		}
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
		
	}
}
