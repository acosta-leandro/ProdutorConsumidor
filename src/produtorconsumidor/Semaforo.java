package produtorconsumidor;

public class Semaforo {

    int recursosLivres = 0;

    public Semaforo(int valor) {
        recursosLivres = valor;
    }

    public synchronized void P() {
  while (recursosLivres < 0) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        recursosLivres--;
    }

    public synchronized void V() {
        recursosLivres++;
         if(recursosLivres <= 0)
          {
              notifyAll();
          }
        
    }

}
