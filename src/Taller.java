import java.util.ArrayList;
import java.util.List;



public class Taller
{

    List <String> nombres = new ArrayList<>();
    List <String> tareas = new ArrayList<>();
    
    public Taller()
    {
        nombres.add("Kevin");
        nombres.add("Juan");
        nombres.add("Pablo");
        nombres.add("Maria");
        nombres.add("Juana");
    }

    public void imprimirNombres() 
    {
        for (String elem : nombres) 
        {
            System.out.println(elem);
        }
    }

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

    public void imprimirTareas() 
    {
        for (String elem : tareas) 
        {
            System.out.println(elem);
        }
    }

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