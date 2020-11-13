package ui;

import java.util.Scanner;
import model.MathApp;

public class Main {

	private Scanner sc;
	private MathApp mainMathApp;
	
	public Main(){
		sc = new Scanner(System.in);
		mainMathApp = new MathApp();
	}
	
	public static void main(String[] args) {
		Main objMain = new Main();
		objMain.menu();
	}
	
	public void menu(){
		boolean menu = true;
		int option;
		while(menu) {
			System.out.println("\n******************************************************" +
								"\nSeleccione una opcion para empezar:\n" + 
								"\n(1) Agregar un conjunto" + 
								"\n(2) Eliminar un conjunto" + 
								"\n(3) Agregar un elemento a un conjunto" + 
								"\n(4) Eliminar un elemento de un conjunto" + 
								"\n(5) Operaciones" + 
								"\n(6) Mostrar conjuntos" +
								"\n(0) Salir" +
								"\n******************************************************\n"
								);
		option = sc.nextInt();
		sc.nextLine();
		switch(option) {
			case 1: addSets();
				break;
			case 2: removeSets();
				break;
			case 3: addElement();
				break;
			case 4: removeElement();
				break;
			case 5: menu2();
				break;
			case 6: menu3();
				break;
			case 0: menu = false;
					System.out.println("\nBye!");
				break;
			default:
					System.out.println("\nError, opcion no valida");
		}
		}
	}
	
	public void menu2() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n*********************************************************" +
					"\nDigite la opcion deseada:" +
					"\n(1) Union de conjuntos"+
					"\n(2) Interseccion de conjuntos"+
					"\n(3) Diferencia de conjuntos"+ 
					"\n(4) Diferencia simetrica de conjuntos"+ 
					"\n(0) Volver" +
					"\n*********************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	operationsSets(option);
						menu = false;
					break;
				case 2:	operationsSets(option);
						menu = false;
					break;
				case 3:	operationsSets(option);
						menu = false;
					break;
				case 4:	operationsSets(option);
						menu = false;
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("\nOpcion no valida");
			}
		}
	}
	
	public void menu3() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n******************************************************" +
					"\nDigite la opcion deseada:" +
					"\n(1) Mostrar un conjunto especifico"+
					"\n(2) Mostrar todos los conjuntos"+
					"\n(0) Volver" +
					"\n******************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	showSet();
						menu = false;
					break;
				case 2:	showSets();
						menu = false;
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("\nOpcion no valida");
			}
		}
	}
	
	public void addSets() {
		String name;
		System.out.println("Digite el nombre del conjunto a agregar:");
		name = sc.nextLine();
		mainMathApp.addSet(name);
	}
	
	public void removeSets() {
		String name;
		System.out.println("Digite el nombre del conjunto a eliminar:");
		name = sc.nextLine();
		mainMathApp.removeSet(name);
	}
	
	public void addElement() {
		String setName;
		int element;
		System.out.println("Ingresa el nombre del conjunto:");
		setName = sc.nextLine();
		System.out.println("Ingresa el elemento entero a añadir:");
		element = sc.nextInt();
		sc.nextLine();
		mainMathApp.addElementToSet(setName, element);
	}
	
	public void removeElement() {
		String setName;
		int element;
		System.out.println("Ingresa el nombre del conjunto:");
		setName = sc.nextLine();
		System.out.println("Ingresa el elemento entero a eliminar:");
		element = sc.nextInt();
		sc.nextLine();
		mainMathApp.removeElementFromSet(setName, element);
	}
	
	public void operationsSets(int option) {
		String name1, name2, newName;
		System.out.println("Digite el nombre del primer conjunto:");
		name1 = sc.nextLine();
		System.out.println("Digite el nombre del segundo conjunto:");
		name2 = sc.nextLine();
		System.out.println("Digite el nombre del nuevo conjunto:");
		newName = sc.nextLine();
		System.out.println(mainMathApp.operationString(name1, name2, newName, option));
		}
	
	public void showSet() {
		String setName;
		System.out.println("Digite el nombre del conjunto que quiere buscar:");
		setName = sc.nextLine();
		System.out.println(mainMathApp.showInfoSet(setName));
	}
	
	public void showSets() {
		System.out.println(mainMathApp.showInfoSets());
	}
}
