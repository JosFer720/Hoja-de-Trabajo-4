public class FactoryArray<T> {
    
    public ArrayStructure<T> createStructure(String tipo) {
        switch (tipo) {
            case "array":
                return new Array1D<T>();
            case "vector":
                return new Vector<T>();
                throw new IllegalArgumentException("Tipo de estructura no válido");
        }
    }
}
