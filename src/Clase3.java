import java.util.Arrays;
public class Clase3 
{
    //Primer algoritmo:
    public void printFirstElement(int[] arr) 
    {
        if (arr.length > 0) //Complejidad temportal O(1) y complejidad espacial O(1)
        {
            System.out.println(arr[0]); //Complejidad temportal O(1) y complejidad espacial O(1)
        }
    }
    //Resultado Final #1: Complejidad temportal O(1) y complejidad espacial O(1)


    //Segundo algoritmo:
    public void printAllElements(int[] arr) 
    {
        for (int element : arr) //Complejidad temportal O(n) y complejidad espacial O(1)
        {
            System.out.println(element); //Complejidad temportal O(1) y complejidad espacial O(1)
        }
    }
    //Resultado Final #2: Complejidad temportal O(n) y complejidad espacial O(1)

    
    //Tercer algoritmo:
    public void printAllPairs(int[] arr) 
    {
        for (int i = 0; i < arr.length; i++) //Complejidad temportal O(n^2) y complejidad espacial O(1)
        {
            for (int j = 0; j < arr.length; j++) 
            {
                System.out.println(arr[i] + ", " + arr[j]); //Complejidad temportal O(1) y complejidad espacial O(1)
            }
        }
    }    
    //Resultado Final #3: Complejidad temportal O(n^2) y complejidad espacial O(1)


    //Cuarto algoritmo:
    public int binarySearch(int[] arr, int target) 
    {
        int low = 0; //Complejidad temportal O(1) y complejidad espacial O(1)
        int high = arr.length - 1; //Complejidad temportal O(1) y complejidad espacial O(1)
    
        while (low <= high) //Complejidad temportal O(n) y complejidad espacial O(1)
        {
            int mid = (low + high) / 2; //Complejidad temportal O(1) y complejidad espacial O(1)
            if (arr[mid] == target)  //Complejidad temportal O(1) y complejidad espacial O(1)
            {
                return mid; //Complejidad temportal O(1) y complejidad espacial O(1)
            } else if (arr[mid] < target)  //Complejidad temportal O(1) y complejidad espacial O(1)
            {
                low = mid + 1; //Complejidad temportal O(1) y complejidad espacial O(1)
            } else //Complejidad temportal O(1) y complejidad espacial O(1)
            {
                high = mid - 1; //Complejidad temportal O(1) y complejidad espacial O(1)
            }
        }
        return -1; //Complejidad temportal O(1) y complejidad espacial O(1)
    }
    //Resultado Final #4: Complejidad temportal O(n) y complejidad espacial O(1)



    //Quinto algoritmo:
    public int fibonacci(int n) 
    {
        if (n <= 1) //Complejidad temportal O(1) y complejidad espacial O(1)
        {
            return n; //Complejidad temportal O(1) y complejidad espacial O(1)
        } else 
        {
            return fibonacci(n - 1) + fibonacci(n - 2); //Complejidad temportal O(1) y complejidad espacial O(1)
        }
    }
    //Resultado Final #5: Complejidad temportal O(1) y complejidad espacial O(1)




    //Sexto algoritmo:
    
    public void sortAndPrint(int[] arr) 
    {
    Arrays.sort(arr); // Complejidad O(n log n)
    for (int element : arr) //Complejidad temportal O(n) y complejidad espacial O(1)
    {
        System.out.println(element); //Complejidad temportal O(1) y complejidad espacial O(1)
    }
    }
    //Resultado Final #6: Complejidad temportal O(n) y complejidad espacial O(1)




    //PARTE DOS DE LA ACTIVIDAD (OPTIMIZAR)
    public boolean hasDuplicate(int[] arr) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[i] == arr[j]) 
                {
                    return true;
                }
            }
        }
        return false;
    }
    

    public boolean hasDuplicateOptmizado(int[] arr) 
    {   
        Arrays.sort(arr);
        int i =0;

        while(i<arr.length -1 )
        {
            if (arr[i] == arr[i+1]) 
            {
                    return true;
            }
            i ++;
        }
       return false;
    }
    //Como se puede apreciar, la complejidad del algoritmo pasa de ser o(n^2) a ser, como máximo O(n), una mejora sustancial en su eficiencia
}
