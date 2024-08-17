public class Clase2 
{
    //* Analisis del resultado */
    /*
     * Si bien ambos algoritmos, tanto fibonacci1 y fibonacci2 tienen una complejidad temporal o(n).
     * En las pruebas, el tiempo de ejecución de fibonnaci2 tiende a ser menor al de fibonacci1 (por casi nada), 
     * esto se debe a que, en el bucle while no se realiza una operación de asignación extra, ya que, no r
     * equiere calcular el siguiente número de fibonacci utiizando tres variables en cada iteración.
     */
    public static int fibonacci1 (int iter)
    {
        int n_ant = 0; //o(1)
        int n_act = 1;  //o(1)
        int n_fibo = 1;  //o(1)

        for (int i= 0; i<iter; i++)  //o(n)
        {
            n_fibo = n_act + n_ant;  //o(1)
            n_ant = n_act;  //o(1)
            n_act = n_fibo;  //o(1)
        }

        return n_fibo;  //o(1)
    }
    //Complejidad temporal o(n)


    public static int fibonacci2(int iter)  
    {
        if (iter == 0)  //o(1)
        {
            return 0;
        }else if (iter==1)  //o(1)
        {
            return 1;
        }

        int n_ant = 0;  //o(1)
        int n_act = 1;  //o(1)
        int contador = 2;  //o(1)
        
        while(contador <= iter)  //o(n)
        {
            int temp = n_act;  //o(1)
            n_act = n_ant + n_act;  //o(1)
            n_ant = temp;  //o(1)
            contador ++;  //o(1)
        }

        return n_act;  //o(1)
        
    }
    //Complejidad temporal o(n)

    public static long medirTiempoEjecucion(Runnable algoritmo)
    {
        long inicio = System.nanoTime();
        algoritmo.run();
        long fin = System.nanoTime();
        return fin - inicio;
    }


    public static void main(String[] args) 
    {
        int n = 30;
        int repeticiones = 10;

        long tiempoTotalAlgoritmo1 = 0;
        long tiempoTotalAlgoritmo2 = 0;

        for (int i = 0; i<repeticiones; i++)
        {
            tiempoTotalAlgoritmo1 += medirTiempoEjecucion(()->fibonacci1(n));
        }
        long tiempoPromedioAlgoritmo1 = tiempoTotalAlgoritmo1 / repeticiones;

        for (int i = 0; i<repeticiones; i++)
        {
            tiempoTotalAlgoritmo2 += medirTiempoEjecucion(()->fibonacci2(n));
        }
        long tiempoPromedioAlgoritmo2 = tiempoTotalAlgoritmo2 / repeticiones;


        System.out.println("Tiempo promedio de ejecución algoritmo 1 (fibonacci 1)" + tiempoPromedioAlgoritmo1+ " nanosegundos");
        System.out.println("Tiempo promedio de ejecución algoritmo 2 (fibonacci 2)" + tiempoPromedioAlgoritmo2+ " nanosegundos");

    }
}


