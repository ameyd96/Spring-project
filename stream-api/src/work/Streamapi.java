package work;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamapi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//List<Integer> list1 = List.of(2, 34, 24, 5, 65, 12);
		List<Integer> list2 = Arrays.asList(2, 34, 24, 5, 65, 12);

		Stream<Integer> stream = list2.stream();
		List<Integer> newList=stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(newList);
		
		
		List<Integer> newList1=list2.stream().filter(i->i>10).collect(Collectors.toList());
		System.out.println(newList1);

	}

}
