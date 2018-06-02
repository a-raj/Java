package collections.maps;

import java.util.HashMap;

public class IdentityHashMapDemo {

	public static void main(String[] args) {
		/*
		 * IdentityHashMap as name suggests uses the equality operator(==) for comparing
		 * the keys. So when you put any Key Value pair in it the Key Object is compared
		 * using == operator.
		 */
		java.util.IdentityHashMap<String, Integer> identityHashMap = new java.util.IdentityHashMap<>();
		String s1 = "Key";
		String s2 = new String("Key");
		if (s1 != s2) {
			System.out.println("s1 != s2");
		}
		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2) return yes");
		}
		identityHashMap.put(s1, 123);
		identityHashMap.put(s2, 478);

		System.out.println(identityHashMap.size());
		identityHashMap.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});

		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put(s1, 123);
		hashMap.put(s2, 321);
		System.out.println(hashMap.size());
		hashMap.forEach((k, v) -> {
			System.out.println(k + " = " + v);
		});

	}
}
