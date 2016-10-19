package produtorconsumidor;


import produtorconsumidor.Buffer;
import produtorconsumidor.Consumidor;
import produtorconsumidor.Produtor;



//Programa principal

public class ProdutorConsumidor
{
  public static void main(String args[])
  {
    Buffer buffer = new Buffer();
    
    Produtor produtor = new Produtor(buffer);
    Consumidor consumidor = new Consumidor(buffer);
    
    produtor.start();
    consumidor.start();
  }
}