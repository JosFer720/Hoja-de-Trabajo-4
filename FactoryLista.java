public class FactoryLista<T> {
    public static Lista<T> crearLista(String tipo) {
        switch (tipo) {
            case "simple":
                return new ListaSimple<>();
            case "doble":
                return new ListaDoble<>();
            default:
                throw new IllegalArgumentException("Tipo de lista no válido");
        }
    }
}
