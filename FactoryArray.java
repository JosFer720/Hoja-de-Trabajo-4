
public class FactoryArray<T> {
    
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
