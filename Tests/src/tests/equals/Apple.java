package tests.equals;

/**
 * Created by admin on 26.01.2016.
 */
import java.util.HashMap;

public class Apple {
	private String color;

	public Apple(String color) {
		this.color = color;
	}

	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (!(obj instanceof Apple))
			return false;
		if (obj == this)
			return true;
		return this.color.equals(((Apple) obj).color);
	}

	public int hashCode() {
		return this.color.hashCode();
	}

	public static void main(String[] args) {
		Apple a1 = new Apple("green");
		System.out.println("a1.hashCode(): " + a1.hashCode());
		Apple a2 = new Apple("red");
		System.out.println("a2.hashCode(): " + a2.hashCode());

		//hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		Apple a3 = new Apple("green");
		System.out.println("a3.hashCode(): " + a3.hashCode());
		System.out.println(m.get(a3));
	}
}