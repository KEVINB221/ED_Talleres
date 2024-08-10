import java.util.ArrayList;
import java.util.List;



public class Taller
{

    List <String> nombres = new ArrayList<>(); //Lista que almacena los nombres
    List <String> tareas = new ArrayList<>();  //Lista que almacena las tareas
    
    //Constructor de la clase Taller. Inicializa la lista de nombres con algunos nombres predeterminados.
    public Taller()
    {
        nombres.add("Kevin");
        nombres.add("Juan");
        nombres.add("Pablo");
        nombres.add("Maria");
        nombres.add("Juana");
    }

    /**
     * Imprime todos los nombres en la lista de nombres.
     */
    public void imprimirNombres() 
    {
        for (String elem : nombres) 
        {
            System.out.println(elem);
        }
    }

    /**
     * Busca un nombre en la lista de nombres.
     * @param nombreBuscar
     */
    public void buscarNombre(String nombreBuscar) 
    {
        for (String elem : nombres) 
        {
            if (elem.equalsIgnoreCase(nombreBuscar))
            {
                System.out.println("El nombre fue encontrado");
                break;
            }
            else
            {
                System.out.println("El nombre no fue encontrado");
            }
        }
    }

    /**
     * Agrega un nombre en la lista de nombres si no esá presente.
     * @param nombreAgregar
     */
    public void agregarNombre (String nombreAgregar)
    {
        boolean existe = false;
        
        for (String elem : nombres)
        {
            if (elem.equalsIgnoreCase(nombreAgregar))
            {
                existe = true;
                break;
            }
        }
        if (!existe) 
        {
            nombres.add(nombreAgregar);
        }
        imprimirNombres();
    }

    /**
     * Elimina un nombre en la lista de nombres.
     * 
     * @param nombreEliminar
     */
    public void eliminarNombre (String nombreEliminar)
    {
    
        if (nombres.contains(nombreEliminar))
            {
                nombres.remove(nombreEliminar);
                System.out.println("El nombre se eliminó correctamente");
            }
        else
            {
                System.out.println("El nombre no se eliminó correctamente");
            }
        

        imprimirNombres();
    }

    /**
     * Imprime todas las tareas en la lista de tareas.
     */
    public void imprimirTareas() 
    {
        for (String elem : tareas) 
        {
            System.out.println(elem);
        }
    }

    /**
     * Agrega una tarea a la lista de tareas si no está ya presente.
     * 
     * @param tareaAgregar
     */
    public void agregarTarea (String tareaAgregar)
    {
        boolean existe = false;
        
        for (String elem : tareas)
        {
            if (elem.equalsIgnoreCase(tareaAgregar))
            {
                existe = true;
                break;
            }
        }
        if (!existe) 
        {
            tareas.add(tareaAgregar);
        }
        imprimirTareas();
    }

    /**
     * Elimina una tarea de la lista de tareas.
     * 
     * @param tareaEliminar
     */
    public void eliminarTarea (String tareaEliminar)
    {
        
        
        if (tareas.contains(tareaEliminar))
            {
                tareas.remove(tareaEliminar);
                System.out.println("La tearea se eliminó correctamente");
            }
        else
            {
                System.out.println("La tarea no se eliminó correctamente");
            }
        

        imprimirTareas();
    }

}