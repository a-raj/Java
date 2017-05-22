package learn.generics.boundedWildcard;

public class TestBoundedWildCard {
	
	static void showXY(GenericCoordinates<?> genericCoordinates){
		System.out.println("X and Y coordinates are:");
		for(int i = 0; i < genericCoordinates.coordinates.length; i++){
			System.out.println(genericCoordinates.coordinates[i].x + " " +
								genericCoordinates.coordinates[i].y);
		}
		System.out.println();
	}
	
	static void showXYZ(GenericCoordinates<? extends ThreeD> genericCoordinates){
		System.out.println("X, Y and Z coordinates are:");
		for(int i = 0; i < genericCoordinates.coordinates.length; i++){
			System.out.println(genericCoordinates.coordinates[i].x + " " +
								genericCoordinates.coordinates[i].y + " " +
								genericCoordinates.coordinates[i].z);
		}
		System.out.println();
	}
	
	static void showAll(GenericCoordinates<? extends FourD> genericCoordinates){
		System.out.println("X, Y, Z and time coordinates are:");
		for(int i = 0; i < genericCoordinates.coordinates.length; i++){
			System.out.println(genericCoordinates.coordinates[i].x + " " +
					genericCoordinates.coordinates[i].y + " " + 
					genericCoordinates.coordinates[i].z + " " +
					genericCoordinates.coordinates[i].time);
		}
	}
	
	public static void main(String[] args) {
		TwoD twoDArray[] = {
				new TwoD(10,11),
				new TwoD(44,55),
				new TwoD(11,23)
		};
		
		ThreeD threeDArray[] = {
			new ThreeD(999, 888, 777),
			new ThreeD(909,880,777),
			new ThreeD(741,852,963)
		};
		
		FourD fourDArray[] = {
				new FourD(1,2,3,912),
				new FourD(11, 22, 33, 9321),
				new FourD(01, 02, 03, 9000)
		};
		GenericCoordinates<TwoD> genTwoD = new GenericCoordinates<>(twoDArray);
		showXY(genTwoD);
		
		GenericCoordinates<ThreeD> genThreeD = new GenericCoordinates<>(threeDArray);
		showXYZ(genThreeD);
		
		GenericCoordinates<FourD> genFourD = new GenericCoordinates<>(fourDArray);
		showAll(genFourD);
		
	}

}
