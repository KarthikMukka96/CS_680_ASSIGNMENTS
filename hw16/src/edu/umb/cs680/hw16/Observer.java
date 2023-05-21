package edu.umb.cs680.hw16;

@FunctionalInterface
public interface Observer<T> {

	public void update(Observable<T> sender, T event);
}
