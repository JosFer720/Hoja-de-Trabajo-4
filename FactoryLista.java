/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */
public class FactoryLista<T> {
    public IList<T> crearLista(String tipo) {
        switch (tipo) {
            case "simple":
                return new ListaSimple<T>();
            case "doble":
                return new ListaDoble<T>();
            default:
                throw new IllegalArgumentException("Tipo de lista no válido");
        }
    }
}