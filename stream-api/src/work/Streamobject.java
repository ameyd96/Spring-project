package work;

import java.util.stream.Stream;

public class Streamobject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create stream object 1
		String name[] = {"dreak","lalit","om","goali","sidhu"};
		
		Stream<String> stream1=Stream.of(name);
		stream1.forEach(e->{
			System.out.println(e);
		});

		
		//stream object 2
		Stream<Object> stream2=Stream.builder().build();
	}

}
