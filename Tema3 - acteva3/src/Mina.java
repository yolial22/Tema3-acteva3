// En la clase Mina utilizaremos un atributo stock, un constructor Mina
// y los atributos getters y setters, para saber cuantos recursos podemos obtener de la mina. 

public class Mina 
{
	int stock;
	
	Mina(int stock) 
	{
		this.stock = stock;
	}

	public int getStock() 
	{
		return stock;
	}

	public void setStock(int stock) 
	{
		this.stock = stock;
	}
}