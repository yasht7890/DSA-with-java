package Arrays;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

	@Override
	public int compare(Circle o1, Circle o2) {
		// TODO Auto-generated method stub
		return o1.getRadius() - o2.getRadius();
	}

}
