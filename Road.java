import java.util.Objects;

public class Road implements Comparable<Road>{
	private String roadName;
	private Town roadSource, roadDestination;
	private int weight;
	
	public Road(Town source, Town destination, int degrees, String name) {
		roadName = name;
		roadSource = source;
		roadDestination = destination;
		weight = degrees;
	}
	
	public Road(Town source, Town destination, String name) {
		roadName = name;
		roadSource = source;
		roadDestination = destination;
		weight = 1;
	}

	public boolean contains(Town town) {
		return ((town.getName().equalsIgnoreCase(roadSource.getName()))|| (town.getName().equalsIgnoreCase(roadDestination.getName())));
	}
	
	@Override
	public int compareTo(Road road) {
		return this.roadName.compareTo(road.roadName);
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    Road other = (Road) obj;
	    return this.weight == other.weight &&
	            this.roadName.equals(other.roadName) &&
	            ((this.roadSource.equals(other.roadSource) && this.roadDestination.equals(other.roadDestination)) ||
	             (this.roadSource.equals(other.roadDestination) && this.roadDestination.equals(other.roadSource)));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(roadName, weight, roadSource.hashCode() + roadDestination.hashCode());
	}
	
	public String getName() {
		return roadName;
	}
	public void setName(String name) {
		roadName = name;
	}
	public Town getDestination() {
		return roadDestination;
	}
	public void setDestination(Town destination) {
		roadDestination = destination;
	}
	public Town getSource() {
		return roadSource;
	}
	public void setSource(Town source) {
		roadSource = source;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int distance) {
		weight = distance;
	}
	public String toString() {
		String s = roadName + "," + roadSource.toString() +"," + roadDestination.toString() + "," + weight;
		return s;
	}
}
