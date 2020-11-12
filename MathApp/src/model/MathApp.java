package model;

import java.util.ArrayList;

public class MathApp {

	//Relationships
	private ArrayList<IntegerSet> sets;
	
	//Attributes
	private int amount;
	
	//Builder
	public MathApp(){
	}
	
	//Getters and Setters
	public int getAmount(){
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}//End Getters and Setters
	
	
	public void addSet(String name) {
		if(sets.isEmpty()) {
			IntegerSet set = new IntegerSet(name);
			sets.add(set);
			System.out.println("El conjunto ha sido agregado");
			int amount = getAmount();
			amount++;
			setAmount(amount);
		}
		else {
			boolean found = false;
			for(int i=0; i<sets.size() && !found; i++) {
				IntegerSet findSet = sets.get(i);
				if(findSet.getName().equalsIgnoreCase(name)) {
					System.out.println("Ya existe un conjunto con el nombre: "+name);
					found = true;
				}
			}
			if(found = false) {
				IntegerSet set = new IntegerSet(name);
				sets.add(set);
				System.out.println("El conjunto ha sido agregado");
				int amount = getAmount();
				amount++;
				setAmount(amount);
			}
		}
	}
	
	public void removeSet(String name) {
		boolean found = false;
		for(int i=0; i<sets.size() && !found; i++) {
			IntegerSet findSet = sets.get(i);
			if(findSet.getName().equalsIgnoreCase(name)) {
				sets.remove(i);
				System.out.println("Se elimino el conjunto: "+name);
				found = true;
			}
		}
	}
	
	public void addElementToSet(String setName, int element) {
		if(sets.isEmpty()) {
			System.out.println("No hay conjuntos agregados");
		}
		else {
			boolean found = false;
			for(int i=0; i<sets.size() && !found; i++) {
				IntegerSet findSet = sets.get(i);
				if(findSet.getName().equalsIgnoreCase(setName)) {
					findSet.addElement(element);
					found = true;
				}
			}
			if(found = false) {
				System.out.println("El conjunto "+setName+" no existe");
			}
		}
	}
	
	public void removeElementFromSet(String setName, int element) {
		boolean found = false;
		for(int i=0; i<sets.size() && !found; i++) {
			IntegerSet findSet = sets.get(i);
			if(findSet.getName().equalsIgnoreCase(setName)) {
				findSet.removeElement(element);
				System.out.println("El elemento "+element+" fue eliminado del conjunto "+setName);
				found = true;
			}
		}
	}
	
	public void union(String name1, String name2, String newName) {
		boolean found1 = false, found2 = false;
		for(int i=0; i<sets.size() && !found1; i++) {
			IntegerSet findSet = sets.get(i);
			if(findSet.getName().equalsIgnoreCase(name1)) {
				found1 = true;
			}
		}
		if(found1==true) {
			for(int i=0; i<sets.size() && !found2; i++) {
				IntegerSet findSet = sets.get(i);
				if(findSet.getName().equalsIgnoreCase(name2)) {
					found2 = true;
				}
			}
			if(found2==true) {
				
			}
			else {
				System.out.println("El conjunto "+name2+" no se encontro");
			}
		}
		else {
			System.out.println("El conjunto "+name1+" no se encontro");
		}
		
		
		
	}
	
	public void intersection(String name1, String name2, String newName) {
		
		
	}
	
	public void difference(String name1, String name2, String newName) {
		
		
	}
	
	public void symmetricDifference(String name1, String name2, String newName) {
		
		
	}
	
	public String showInfoSet(String name) {
		
		return ;
	}
	
	public String showInfoSets() {
		
		return ;
	}
}
