/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 * Clase que representa un fabricante de estructuras de datos de cola.
 * @param <T> El tipo de elementos que contendrán las estructuras de datos de cola.
 */
public class FactoryArray<T> {
    
    /**
     * Crea una nueva estructura de datos de cola según el tipo especificado.
     * @param tipo El tipo de estructura de datos de cola a crear ("array" o "vector").
     * @return Una instancia de la estructura de datos de cola especificada.
     * @throws IllegalArgumentException Si el tipo de estructura especificado no es válido.
     */
    public IQueue<T> createStructure(String tipo) {
        switch (tipo) {
            case "array":
                return new ArrayListQueue<T>();
            case "vector":
                return new Vector<T>();
            default:
                throw new IllegalArgumentException("Tipo de estructura no válido");
        }
    }
}