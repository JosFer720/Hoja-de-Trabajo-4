public class FactoryArray<T> {
    
    public ArrayStructure<T> createStructure(String tipo, int size) {
        switch (tipo) {
            case "array":
                return new Array1D<>(size);
            case "vector":
                return new Vector<>(size);
            default:
                throw new IllegalArgumentException("Tipo de estructura no válido");
        }
    }
}
