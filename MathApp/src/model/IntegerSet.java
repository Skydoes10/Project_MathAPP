package model;

import java.util.ArrayList;

public class IntegerSet {
	
	//Attributes
	private String name;
	private int cardinality;
	private ArrayList<Integer> elements;
	
	//Builder
	public IntegerSet(String name){
		this.name = name;
		elements = new ArrayList<Integer>();
	}
	
	//Getters and Setters
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCardinality(){
		return cardinality;
	}
	
	public void setCardinality(int cardinality) {
		this.cardinality = cardinality;
	}
	
	public ArrayList<Integer> getElements(){
		return elements;
	}
	
	public void setElements(ArrayList<Integer> elements) {
		this.elements = elements;
	}//End Getters and Setters
	
	
	public void addElement(int element) {
		boolean empty = elements.isEmpty();
		if(empty == true) {
			elements.add(element);
			int cardinality = elements.size();
			setCardinality(cardinality);
		}
		else {
			boolean found = false;
			for(int i=0; i<elements.size() && !found; i++) {
				int findElement = elements.get(i);
				if(findElement == element) {
					found = true;
				}
			}
			if(found == false) {
				elements.add(element);
				int cardinality = elements.size();
				setCardinality(cardinality);
			}
		}
	}
	
	public void removeElement(int element) {
		boolean removed = false;
		for(int i=0; i<elements.size() && !removed; i++) {
			int findElement = elements.get(i);
			if(findElement == element) {
				elements.remove(i);
				removed = true;
			}
		}	
	}
	
	public IntegerSet union(IntegerSet set, String newName) {
		IntegerSet newSet = new IntegerSet(newName);
		for(int i=0; i<set.cardinality; i++) {
			if(!(elements.contains(set.elements.get(i)))) {
				newSet.elements.add(set.elements.get(i));
			}
			if(elements.contains(set.elements.get(i))) {
				newSet.elements.add(set.elements.get(i));
			}
			
		}
		for(int i=0; i<getCardinality(); i++) {
			if(!(set.elements.contains(elements.get(i)))) {
				newSet.elements.add(elements.get(i));
			}
		}
		return newSet;
	}
	
	public IntegerSet intersection(IntegerSet set, String newName) {
		IntegerSet newSet = new IntegerSet(newName);
		for(int i=0; i<set.getCardinality(); i++) {
			if(elements.contains(set.elements.get(i))) {
				newSet.elements.add(set.elements.get(i));
			}
		}
		return newSet;
	}
	
	public IntegerSet difference(IntegerSet set, String newName) {
		IntegerSet newSet = new IntegerSet(newName);
		for(int i=0; i<getCardinality(); i++) {
			if(!(set.elements.contains(elements.get(i)))) {
				newSet.elements.add(elements.get(i));
			}
		}
		return newSet;
	}
	
	public IntegerSet symmetricDifference(IntegerSet set, String newName) {
		IntegerSet newSet = new IntegerSet(newName);
		for(int i=0; i<set.cardinality; i++) {
			if(!(elements.contains(set.elements.get(i)))) {
				newSet.elements.add(set.elements.get(i));
			}
		}
		for(int i=0; i<getCardinality(); i++) {
			if(!(set.elements.contains(elements.get(i)))) {
				newSet.elements.add(elements.get(i));
			}
		}
		return newSet;
	}
	
	public String showContents() {
		String info = 	"\n******************************************************"+
						"\n Nombre del Conjunto: "+getName()+"\n Elementos: "+getElements()+
						"\n******************************************************";
		return info;
	}
}
