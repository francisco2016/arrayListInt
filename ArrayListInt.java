
/**
 * Write a description of class ArrayListInt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayListInt
{
    // instance variables - replace the example below with your own
    private int[] numeros;

    /**
     * Constructor for objects of class ArrayListInt
     */
    public ArrayListInt()
    {

        numeros = new int[0];
    }

    /**
     *  añade un elemento a la colección al final de la misma
     */
    public void add(int elemento){
        int[] array2 = numeros;//1º creamos array2, VL de tipo Arrays, que apunta al Arrays numeros
        numeros = new int[array2.length + 1];//2º numeros pasa a apuntar al Array2 con una posición más añadida.
        //3ºun bucle for para que de tantas iteraciones como elementos tiene array2.
        for (int count = 0; count < array2.length; count++){
            numeros[count] = array2[count];//pasamos los elementos de array2 a numeros.
        }
        numeros[array2.length] = elemento;// y termina añadiendo la última posición.
    }

    /**
     *  añade un elemento a la colección en la posición especificada por el parámetro index. Si el valor de index
     *  no es válido, entonces no hace nada. Los elementos a continuación del añadido se desplazan una posición.
     */
    public void add(int index, int elemento){
        if (index <= numeros.length && index >= 0)//1ºcomparo si el index pasado como parámetro es válido.
        {
            int[] local = numeros;   //2º VL para guardar el Arrays viejo.
            numeros = new int[local.length + 1]; //3º en el Arrays viejo, nuevo Arrays con una posición más.
            for (int cont = 0; cont < local.length; cont++)//4º un for para ir copiando los elementos en el Arrays viejo.
            {
                if (cont < index)
                {
                    numeros[cont] = local[cont];
                }
                else
                {
                    numeros[cont+1] = local[cont];
                }
            }
            numeros[index] = elemento;//5º después del for, guardo el elemento en la posición pasada como parámetro.
        }
    }

    /**
     *para vacíar la colección
     */ 
    public void clear(){
        numeros = new int[0];

    }

    /**
     *  devuelve true si la colección contiene ese elemento, false en cualquier otro caso.
     *  si el parámetro está en la colección devuelve true.
     */
    public boolean contains(int elemento){
        boolean contains = false; // 1º VL para guardar el valor.
        for(int index = 0; index < numeros.length; index ++){//2º recorrer la colección para ir comprobando.
            if(numeros[index] == elemento){//si la posición index del Arrays contiene el elemento, contains el true.
                contains = true;
            }
        }
        return contains;
    }

    /**
     * devuelve el elemento existente en la posición indicada. Si el valor de index no es
     * válido, entonces devuelve -1
     */
    public int get(int index)
    {
        int elemento = -1;//1º VL para guardar el valor a devolver.
        if(index < numeros.length && index >= 0)//2º comprobar si el valor pasado como parámetro el válido.
        {
            elemento = numeros[index];//pego el elemento en la colección.
        }
        return elemento;
    }

    /**
     *  reemplaza el elemento en la posición index con el valor de element. Si el índice 
     * no es válido, no hace nada.
     */
    public void set(int index, int element){
        if(index < numeros.length && index >= 0){//1º compruebo si el valor de index es válido
            numeros[index] = element; // si lo es, reemplazo el valor por el pasado como parámetro.
        }
    }

    /**
     *  devuelve el indice en el que aparece la primera ocurrencia del elemento especificado o -1 en caso de que la 
     *  colección no contenga el elemento especificado.
     */
    public int indexOf(int elemento){
        int index = -1;
        int cont = 0;
        while ((cont < numeros.length) && (index == -1)) {
            if (numeros[cont] == elemento) {
                index = cont;
            }
            cont++;
        }
        return index;
    }

    /**
     * devuelve true si la lista no contiene elementos
     */
    public boolean isEmpty(){
        return (numeros.length == 0); //si el tamaño de numeros es == 0;
        //cuando java ejecuta el return, devuelve automáticamente un valor; true si es cierto,
        // si la colección contiene 0 elementos o false si no lo es, si contiene algún elemento.
    }

    /**
     *   devuelve el número de elementos de la colección.
     */
    public int size(){
        return numeros.length;
    }

    /**
     * elimina de la colección el elemento que ocupa la posición especificada y devuelve dicho elemento.
     *  Si el valor de index no es válido, no hace nada y devuelve -1.
     */
    public int remove(int index){
        int eliminado = -1;//1º VL para guardar el valor a retornar. 
        if(index >= 0 && index < numeros.length){//2ºcomprobamos que el parámetro está dentro de los límites del Arrays
            //como al hacer el borrado, el Arrays se reduce, necesitamos otro Arrays y lo guardo en una VL.
            int[] nuevoArray = numeros;
            //luego el Array que tenía lo inicializo con una posición menos.
            numeros = new int[numeros.length -1];
            
            for(int i=0; i < index; i++){//en este 1º for copiamos los datos hasta el index en la posición i:
                numeros[i] = nuevoArray[i];
            }
            for (int i=index; i<numeros.length; i++){//en este 2º for copiamos los elementos que han quedado despues
                                                    // de que se han borrado, partimos del valor de idex, y se tiene 
                numeros[i] = nuevoArray[i +1];      // que incrementar hasta que llegue a la segunda posición.
            }                                       //en este caso copiamos los mismo que en el otro Array, pero en
            eliminado = nuevoArray[index];          //una casilla menos
        }                                           //finalmente cosigo el nº del eliminado.
        return eliminado;// 1º retornamos el valor.  
    }

    
}
 
