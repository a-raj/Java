package learn.collections;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {

		// HashSet not maintain order
		Set<String> hashSet = new HashSet<>();

		hashSet.add("A");
		hashSet.add("AA");
		hashSet.add("B");
		hashSet.add("CB");
		hashSet.add("F");
		hashSet.add("E");
		hashSet.add("H");
		hashSet.add("G");

		System.out.println("A".hashCode());
		System.out.println("B".hashCode());
		hashSet.forEach(System.out::println);

		// creating HashSet with capacity and fill ratio
		HashSet<Integer> hashSetWithFillRatio = new HashSet<Integer>(10, 0.5f);
		hashSetWithFillRatio.add(12);

		// LinkedHashSet Maintain insertion order, it extends HashSet
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("A");
		linkedHashSet.add("AA");
		linkedHashSet.add("B");
		linkedHashSet.add("CB");
		linkedHashSet.add("F");
		linkedHashSet.add("E");

		linkedHashSet.forEach(System.out::println);

		// TreeSet implements NavigableSet and it maintain the order in ascending order.
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("A");
		treeSet.add("AA");
		treeSet.add("CB");
		treeSet.add("BA");
		treeSet.add("B");
		treeSet.add("F");
		treeSet.add("E");
		System.out.println("TreeSet");
		treeSet.forEach(System.out::println);

		NavigableSet<String> treeSet2 = new TreeSet<>();

		
		/*
		 * An EnumSet will be used when you have the need for a variable to assume more
		 * than one Enum value at the same time. For instance, a font you write to
		 * screen with can be both bold and italic at the same time. An EnumSet will
		 * allow you to add the various values and to test whether one of those is
		 * actually set at any given time.
		 */
		EnumSet<FontStyle> currentFont;

		currentFont = EnumSet.of(FontStyle.Bold, FontStyle.Itallic);

		if (currentFont.contains(FontStyle.Itallic)) {
			System.out.println("Itallic Font Present");
		}

	}

	enum FontStyle {
		Bold, Itallic, Underline, StrikeThrough
	}

}
