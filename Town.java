
public class Town implements Comparable<Town> {
	private String townName;
	
	public Town(String name) {
		townName = name;
	}
	
	public Town(Town modelTown) {
		townName = modelTown.getName();
	}

	
	public int compareTo(Town o) {
		if(o.getName().equalsIgnoreCase(townName)) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(((Town) obj).getName().equalsIgnoreCase(townName) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getName() {
		return townName;
	}
	public int hashCode() {
		String name = townName.toLowerCase();
		int code = Math.abs(name.hashCode());
		return code;
	}
	public String toString() {
		return this.getName();
	}
}
