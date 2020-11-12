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
		boolean found = false;
		for(int i=0; i<elements.size() && !found; i++) {
			int findElement = elements.get(i);
			if(findElement == element) {
				System.out.println("El elemento "+element+" ya estaba en el conjunto "+getName());
				found = true;
			}
		}
		if(found == false) {
			elements.add(element);
			System.out.println("El elemento "+element+" fue agregado al conjunto "+getName());
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
		
		return ;
	}
	
	public IntegerSet difference(IntegerSet set, String newName) {
		
		return ;
	}
	
	public IntegerSet intersection(IntegerSet set, String newName) {
		
		return ;
	}
	
	public IntegerSet symmetricDifference(IntegerSet set, String newName) {
		
		return ;
	}
	
	public String showContents() {
		for(int i=0; i<elements.size(); i++) {
			
		}
		String info = 	"\n**********************************************************************"+
						"\n Nombre del Conjunto: "+getName()+"\nElementos: "+
						"\n**********************************************************************";
		return info;
	}
}
