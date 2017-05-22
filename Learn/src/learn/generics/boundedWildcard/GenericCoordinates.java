package learn.generics.boundedWildcard;

public class GenericCoordinates<T extends TwoD> {

	T[] coordinates;
	
	public GenericCoordinates(T[] coordinates) {
		this.coordinates = coordinates;
	}
	
}
