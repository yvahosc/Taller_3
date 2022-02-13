package Class;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author ASUS
 */
public class Lists 
    extends Songs 
        implements Interface.IMusic ,Comparable<Lists>, Comparator<Lists>  
{
    
    public ArrayList<Lists> arrayList = new ArrayList<>();

    public Lists(
            String title, 
            int identifier, 
            LocalDate date, 
            double duration, 
            String genre, 
            String cover, 
            String description) 
    {
        super(title, identifier, date, duration, genre, cover, description);
    }

    public Lists() {
    }

    public ArrayList<Lists> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Lists> arrayList) {
        this.arrayList = arrayList;
    } 
    /**
    * [este metodo calcula el numero de canciones que hay en una playlist
    *]
    *
    * @return el tamaño del arreglo
    * @throws Exception
    *
    * @author [Diego felipe , diegofelipem99@gmailcom.]
    *      
    * @since [1.0.0]*/
    @Override
    public int musicCounter() {
        return arrayList.size();  
    }  
      /**
    * [el objetivo de este metodo es enviar un mensaje con la informacion de
    * alguna cancion
    *]
    *
    * @return mensaje
    * @throws Exception
    *
    * @author [Diego felipe , diegofelipem99@gmailcom.]
    *      
    * @since [1.0.0]*/
    @Override
    public String message() {
        return "Song: " + getIdentifier() + " - Título: " + getTitle() + 
                " - Duración: " + getDuration() + " - Fecha: " + getDate();
    }
    /**
    * [El objetivo principal de este metodo es realizar una filtro
    *en un arraylist,en este caso por un genero musical
    * ]
    *
    * @param genre
    * @return ArrayList con todas las canciones que pertenecen a un genero
    * musical.
    * @throws Exception
    *
    * @author [Diego felipe , diegofelipem99@gmailcom.]
    *      
    * @since [1.0.0]*/
    @Override
    public ArrayList<Lists> toSearch(String genre) {
        ArrayList<Lists> search = new ArrayList<>();
        for (Lists lists : arrayList) {
            if(lists.getGenre().equalsIgnoreCase(genre)){
                search.add(lists);
            }
        }
        return search;
    }

    @Override
    public ArrayList<Lists> toSearch(int year) {
        ArrayList<Lists> search = new ArrayList<>();
        for (Lists lists : arrayList) {
            if(lists.date.getYear() == year){
                search.add(lists);
            }
        }
        return search;        
    }

   
    @Override
    public int compareTo(Lists o) {
        if (duration < o.duration) {
            return -1;
        } else if (duration > o.duration) {
            return 1;
        } else {
            return 0;
        } 
    }
    /**
    * [Este metodo es la implementacion de una interfaz la cual tiene como
    * objetivo ordenar las fechas de la siguiente manera:Descendente,Ascendente,
    * Orden inicial de las canciones.]
    *
    * @param Lists 
    * @return int con el orden que se el usuario selecciono
    * 
    * musical.
    * @throws Exception
    *
    * @author [Diego felipe , diegofelipem99@gmailcom.]
    *      
    * @since [1.0.0]*/
    @Override
    public int compare(Lists o1, Lists o2) {
    if (o1.date.isBefore(o2.date)) {
            return -1;
        } else if (o1.date.isAfter(o2.date)) {
            return 1;
        } else {
            return 0;
        }
    }  
}
