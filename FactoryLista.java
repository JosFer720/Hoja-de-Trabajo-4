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