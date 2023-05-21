package edu.umb.cs680.hw10;

import java.util.List;

public class Euclidean implements DistanceMetric{
	public double distance(List<Double> p1, List<Double> p2) {

		// if size of p1 and p2 are not equal we will return -1;
		if (p1.size() != p2.size()) {
			return -1;
		}

		double sumOfSquared = 0.0;
		for(int i=0; i < p1.size(); i++) {
			sumOfSquared += Math.pow( p1.get(i)-p2.get(i), 2 );
		}
		return Math.sqrt(sumOfSquared);		
	}
}
