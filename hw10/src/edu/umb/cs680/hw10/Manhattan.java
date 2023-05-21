package edu.umb.cs680.hw10;

import java.util.List;

public class Manhattan implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            return -1;
        }

        double distance = 0.0;
        for (int i = 0; i < p1.size(); i++) {
            distance += Math.abs(p1.get(i) - p2.get(i));
        }

        return distance;
    }
}
