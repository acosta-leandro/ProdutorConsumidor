package produtorconsumidor;

import java.util.*;

// ESTRUTURA THREAD CONSUMIDORA
public class Consumidor extends Thread
{
  public Consumidor(Buffer b)
  {
    buffer = b;
  }
  
  public void run()
  {
    for (int i = 0; i < 50; i++) {  
      Date item;
      item = (Date)buffer.consome();
    }
  }
  
  private Buffer buffer;
  
}