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
		map.put("홍길동", 30);
		map.put("임꺽정", 40);
		
		if(map.containsKey("홍길동")){
			System.out.println("나이가 어리다");
		}
		
//		[HashMap에 포함된 key, value을 set에 담아 iterator에 set을 정보를 남는다]
//		* Iterator : 자바의 컬렉션 프레임웍에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화한 기법중에 하나이다.
//				   Iterator는 인터페이스이다.
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();

//		[HashMap에 있는 key,value값 출력]
//		* hasNext() : hasNext()의 의미는 Iterator가 보통 순방향으로 이동하는데, Iterator가 가리키는 데이터저장소의 현재 위치에서 이동할 항목이 있는지 체크합니다. 
//        즉, Iterator는 내부적으로 데이터저장소의 자신이 가리키고 있는 지점을 알고 있습니다.  
//        결국, 이동할 항목이 있다면 true을 리턴하고 그렇지 않으면 false을 리턴합니다.
		while(it.hasNext()){
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)it.next();
			System.out.println("이름 : " + e.getKey() + "나이 : " + e.getValue());
		}
//		[맵에 저장된 key값들을 가져와서 set에 만들어 데이터 저장]
		Set<String> set2 = map.keySet();
		System.out.println("명단 :" +set2);
		
//		[맵에 저장된 value 값을 collection<Integer> 형태로 얻어와서, iterator()로 담는다]
		Iterator<Integer> it2;
		Collection<Integer> values = map.values();
		it2 = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()){
			Integer i = (Integer)it2.next();
			total += i.intValue();
		}
//		[결과출력]
		System.out.print("합산 : " + total);
		System.out.print("나이 평균 : " + (float)total/set.size());
		System.out.print("형님 : " + Collections.max(values));
		System.out.print("아우 : " + Collections.min(values));
		
	}
}
