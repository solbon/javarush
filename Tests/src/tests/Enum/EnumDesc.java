package tests.Enum;

/**
 * Created by admin on 09.11.2015.
 */
public class EnumDesc {
	public static void main(String[] args) {
		for (HelpFiles h : HelpFiles.values()) {
			System.out.println(h);
		}
	}
}

enum HelpFiles {
	PACKET_SCANNING("Instrukcja modu³u skanowania pakietów"),
	ORDERS_VIVUS("Instrukcja dla banku VIVUS");

	private String description;

	HelpFiles(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return getDescription();
	}
}