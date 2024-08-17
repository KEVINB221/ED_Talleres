public class Clase2 
{

    public int fibonacci1 (int iter)
    {
        int n_ant = 0;
        int n_act = 1;
        int n_fibo = 1;

        for (int i= 0; i<iter; i++)
        {
            n_fibo = n_act + n_ant;
            n_ant = n_act;
            n_act = n_fibo;
        }

        return n_fibo;
    }

    public int fibonacci2(int iter)
    {
        if (iter == 0)
        {
            return 0;
        }else if (iter==1)
        {
            return 1;
        }

        int n_ant = 0;
        int n_act = 1;
        int contador = 2;
        
        while(contador <= iter)
        {
            int temp = n_act;
            n_act = n_ant + n_act;
            n_ant = temp;
            contador ++;
        }

        return n_act;
        
    }

    public static long medirTiempoEjecucion(Runnable algoritmo)
    {
        long inicio = System.nanoTime();
        algoritmo.run();
        long fin = System.nanoTime();
        return fin - inicio;
    }


    public static void main(String[] args) 
    {
        
    }

