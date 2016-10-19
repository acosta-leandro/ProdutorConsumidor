package produtorconsumidor;

import java.util.*;

// ESTRUTURA THREAD PRODUTORA

public class Produtor extends Thread
{
  public Produtor(Buffer b)
  {
    buffer = b;
  }
  
  public void run()
  {
    for (int i = 0; i < 50; i++) {    
      Date item = new Date();
      buffer.produz(item);
    }
  }
  
  private Buffer buffer;
}