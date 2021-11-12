import java.util.ArrayList;
import java.util.Scanner;

// La clase App lo que hara sera ejecutar todo el programa a trves de la clase main.

public class App 
{
	static Scanner teclado = new Scanner(System.in);
	
	// El metodo main lo que hara sera a traves de preguntar cuanto stock hay en la mina
	// recorremos un arraylist de minaros, que se iran añadiendo al arraylist
	// y que lo que hara sera que cada vez que un minero, ejecute el .start, extraera recursos
	// de la mina y al final se sumara el total de lo extraido por los mineros en la mina.
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// Un arraylist de mineros, del objeto Minero.
		
		ArrayList<Minero> mineros = new ArrayList<Minero>();
		
		// El stock lo que hara sera almacenar el stock que tenemos en la mina.
		
		int stock;
		
		System.out.println("¿Cuanto oro hay en la mina?");
		
		stock = Integer.parseInt(teclado.nextLine());
		
		// El objeto Mina que tendra como atributo, la cantidad de stock que hay en
		// la mina.
		
		Mina mina = new Mina(stock);
		
		// El thread lo que hara sera ejecutar los hilos.
		
		Thread t;
		
		// El total lo que hara sera almacenar el total de oro extraindo de la mina,
		// por los mineros.
		
		int total = 0;
		
		// Bucle que almacena en un arraylist los mineros.
		
		for(int i = 0; i <= 10; i++) 
		{
			Minero minero = new Minero("Minero " + i, mina);
			
			mineros.add(minero);
		}
		
		// Bucle que ejecuta el metodo run (extraerRecuros) de la clase Minero, a traves del .start.
		
		for(int i = 0; i <= 10; i++)
		{
			t = new Thread(mineros.get(i));
			
			t.setName("Minero " + i);
			
			t.start();
		}
		
		try 
		{
			Thread.sleep(1000);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		// Bucle que se ejecuta despues de que los mineros hayan recolectado
		// todo el oro de la mina y que a traves del System,
		// mostrara el total de lo recolectado en la mina.
		
		for(int i = 0; i <= 10; i++) 
		{
			total += mineros.get(i).bolsa;
		}
		
		System.out.println("Total extraido de la mina " + total + " de oro");
		System.out.println("Oro que hay en la mina " + mina.stock);
	}
}