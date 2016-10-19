package produtorconsumidor;


//estrutura da classe buffer

public class Buffer
{
  public Buffer()
  {
    qtde = 0;
    entrada = 0;
    saida = 0;
    
    buffer = new Object[TAMANHO_BUFFER];
    
    mutex = new Semaforo(1);
    empty = new Semaforo(10);
    full = new Semaforo(0);    
  }
  
// metodo executado pelo produtor
  
  public void produz(Object item)
  {       
    empty.P();
    mutex.P();

    qtde ++;
    buffer[entrada] = item;

    System.out.println("PRODUTOR Libera posicao: " + entrada);
   // System.out.println("PRODUTOR Tamanho atual: "+qtde);
    entrada = ( entrada + 1 ) % TAMANHO_BUFFER;
    
    mutex.V();
    full.V();
  }
  
// metodo executado pelo consumidor
  
  public Object consome()
  {    
    full.P();
    mutex.P();
  
    
    qtde --;

    Object item = buffer[saida];
   System.out.println("CONSUMIDOR Consome posicao: " + saida);
  // System.out.println("saida: "+TAMANHO_BUFFER);
    saida = (saida + 1) % TAMANHO_BUFFER;    
    
    mutex.V();
    empty.V();
    
    return item;
  }
  
  private static final int TAMANHO_BUFFER = 10;
  private int qtde;
  private int entrada;
  private int saida;
  private Object[] buffer;
  
  private Semaforo mutex;
  private Semaforo empty;
  private Semaforo full;
  
  int contador = 0;
  
  
  
}