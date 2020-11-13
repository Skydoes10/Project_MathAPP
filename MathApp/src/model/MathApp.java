package model;

import java.util.ArrayList;

public class MathApp {

	//Relationships
	private ArrayList<IntegerSet> sets;
	
	//Attributes
	private int amount;
	
	//Builder
	public MathApp(){
		sets = new ArrayList<IntegerSet>();
	}
	
	//Getters and Setters
	public int getAmount(){
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}//End Getters and Setters
	
	public void addSet(String name) {
		IntegerSet set = new IntegerSet(name);
		sets.add(set);
		int amount = sets.size();
		setAmount(amount);
	}
	
	public void removeSet(String name) {
		boolean found = false;
		for(int i=0; i<sets.size() && !found; i++) {
			IntegerSet findSet = sets.get(i);
			if(findSet.getName().equalsIgnoreCase(name)) {
				sets.remove(i);
				int amount = sets.size();
				setAmount(amount);
				found = true;
			}
		}
	}
	
	public void addElementToSet(String setName, int element) {
		IntegerSet obj = findSet(setName);
		if(obj != null) {
			obj.addElement(element);
		}
	}
	
	public void removeElementFromSet(String setName, int element) {
		IntegerSet obj = findSet(setName);
		if(obj != null) {
			obj.removeElement(element);
		}
	}
	
	public void union(String name1, String name2, String newName) {
		IntegerSet obj1 = findSet(name1);
		IntegerSet obj2 = findSet(name2);
		IntegerSet newObj = obj1.union(obj2, newName);
		sets.add(newObj);
		int amount = sets.size();
		setAmount(amount);
		
	}
	
	public void intersection(String name1, String name2, String newName) {
		IntegerSet obj1 = findSet(name1);
		IntegerSet obj2 = findSet(name2);
		IntegerSet newObj = obj1.intersection(obj2, newName);
		sets.add(newObj);
		int amount = sets.size();
		setAmount(amount);
	}
	
	public void difference(String name1, String name2, String newName) {
		IntegerSet obj1 = findSet(name1);
		IntegerSet obj2 = findSet(name2);
		IntegerSet newObj = obj1.difference(obj2, newName);
		sets.add(newObj);
		int amount = sets.size();
		setAmount(amount);
	}
	
	public void symmetricDifference(String name1, String name2, String newName) {
		IntegerSet obj1 = findSet(name1);
		IntegerSet obj2 = findSet(name2);
		IntegerSet newObj = obj1.symmetricDifference(obj2, newName);
		sets.add(newObj);
		int amount = sets.size();
		setAmount(amount);
	}
	
	public String showInfoSet(String name) {
		String out = "Error, el conjunto "+name+" no existe";
		IntegerSet obj = findSet(name);
		if(obj != null) {
			out = obj.showContents();
		}
		return out;
	}
	
	public String showInfoSets() {
		String out = "";
		for(int i=0; i<sets.size(); i++) {
			IntegerSet set = sets.get(i);
			out += set.showContents();
		}
		return out;
	}
	
	public IntegerSet findSet(String name) {
		IntegerSet foundSet = null;
		boolean found = false;
		for(int i=0; i<sets.size() && !found; i++) {
			if(sets.get(i).getName().equalsIgnoreCase(name)) {
				foundSet = sets.get(i);
				found = true;
			}
		}
		return foundSet;
	}
	
	public String operationString(String name1, String name2, String newName, int option) {
		String message = "";
		IntegerSet obj1 = findSet(name1);
		IntegerSet obj2 = findSet(name2);
		if(obj1 == null) {
			message = "Error, el conjunto "+name1+" no existe";
		}
		else if(obj2 == null) {
			message = "Error, el conjunto "+name2+" no existe";
		}
		else if(obj1 != null && obj2 != null && option == 1) {
			union(name1, name2, newName);
			IntegerSet objUnion = findSet(newName);
			message = "Union realizada exitosamente "+objUnion.showContents();
		}
		else if(obj1 != null && obj2 != null && option == 2) {
			intersection(name1, name2, newName);
			IntegerSet objInter = findSet(newName);
			message = "Interseccion realizada exitosamente "+objInter.showContents();
		}
		else if(obj1 != null && obj2 != null && option == 3) {
			difference(name1, name2, newName);
			IntegerSet objDiffe = findSet(newName);
			message = "Diferencia realizada exitosamente "+objDiffe.showContents();
		}
		else if(obj1 != null && obj2 != null && option == 4) {
			symmetricDifference(name1, name2, newName);
			IntegerSet objSyDif = findSet(newName);
			message = "Diferencia simetrica realizada exitosamente "+objSyDif.showContents();	
		}
		return message;
	}
}
