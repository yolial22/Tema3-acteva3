// En la clase Minero utilizaremos un Runnable para a traves del metodo run
// ir extrayendo stock de la mina, un entero bolsa en el que iremos almacenando el
// stock que cogimos de la mina, un tiempo de extracion entre la recoleccion, un nombre
// y el objeto Mina y los getters y setters.

public class Minero implements Runnable
{
	String nombre;
	
	int bolsa;
	
	int tiempoExtraccion = 1000;
	
	Mina mina;
	
	// El constructor Minero tendra como atributos el nombre el objeto Mina y la bolsa
	// al principio estara vacia, es decir, estara a 0.
	
	public Minero(String nombre, Mina mina) 
	{
		this.nombre = nombre;
		
		this.mina = mina;
		
		bolsa = 0;
	}
	
	// El metodo extraerRecurso lo que hara sera mientras en la mina haya stock, los mineros
	// lo iran extrayendo y guardandolo en la bolsa.

	public void extraerRecurso() 
	{
		while(mina.stock > 0) 
		{
			mina.stock -= 1;
						
			bolsa += 1;
				
			System.out.println(nombre + " ha extraido " + bolsa + " oro de la mina");
		}
		
		try 
		{
			Thread.sleep(tiempoExtraccion);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public int getBolsa() 
	{
		return bolsa;
	}

	public void setbolsa(int bolsa) 
	{
		this.bolsa = bolsa;
	}

	// El metodo run lo que hara sera a traves de los hilos que incluiremos
	// en la clase principal, iran accediendo a traves del .start(), a este metodo
	// y iran extryendo recursos de la mina.
	
	@Override
	public void run() 
	{
		extraerRecurso();
	}
}