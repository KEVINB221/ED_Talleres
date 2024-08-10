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
        //Bucle que recorre e imprime la lista de nombres
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
        //Bucle que recorre la lista de nombres
        for (String elem : nombres) 
        {
            //Compara el nombre de la lista con el ingresado por parámetro
            if (elem.equalsIgnoreCase(nombreBuscar))
            {
                System.out.println("El nombre fue encontrado");
                break; //Para si se encontró el nombre en la lista
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
        boolean existe = false; //condicional incilizado en falso
        
        //Bucle que recorre la lista nombres
        for (String elem : nombres)
        {
            //Compara el nombre en la lista con el ingresado por parámetro para actualizar el condicional
            if (elem.equalsIgnoreCase(nombreAgregar))
            {
                existe = true;
                break;
            }
        }
        if (!existe) 
        {
            //Agrega el nombre a la lista
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
        //Verifica si el nombre a eliminar se encuentra en la lista de nombres
        if (nombres.contains(nombreEliminar))
            {
                //Si se encuentra lo elimina
                nombres.remove(nombreEliminar);
                System.out.println("El nombre se eliminó correctamente");
            }
        else
            {
                System.out.println("El nombre no se eliminó correctamente");
            }
        
        //Imprime la lista con los cambios ya hechos
        imprimirNombres();
    }

    /**
     * Imprime todas las tareas en la lista de tareas.
     */
    public void imprimirTareas() 
    {
        //Bucle que recorre e imprime las tareas en la lista de tareas
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
        boolean existe = false; //Booleano inicializado en falso
        
        //Bucle que recorre la lista tareas
        for (String elem : tareas)
        {
            //Si la tarea existe en la lista, el booleano pasa a true
            if (elem.equalsIgnoreCase(tareaAgregar))
            {
                existe = true;
                break;
            }
        }
        if (!existe) 
        {
            //Agrega la nueva tarea
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
        
        //Verifica si la tarea ya existe en la lista
        if (tareas.contains(tareaEliminar))
            {
                //Elimina la tarea de la lista de tareas
                tareas.remove(tareaEliminar);
                System.out.println("La tearea se eliminó correctamente");
            }
        else
            {
                System.out.println("La tarea no se eliminó correctamente");
            }
        
        //Imprime la lista de tareas con los nuevos cambios
        imprimirTareas();
    }

}