package generics.boundedWildcard;
/**
 * This class holds an array of coordinates with upper bound {@link TwoD}
 * */
public class GenericCoordinates<T extends TwoD> {

	T[] coordinates;
	
	public GenericCoordinates(T[] coordinates) {
		this.coordinates = coordinates;
	}
	
}
