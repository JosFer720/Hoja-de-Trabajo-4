/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 * Clase que implementa la doubleerfaz {@link ICalculadora} proporcionando operaciones aritméticas básicas.
 */
public class Calculadora implements ICalculadora {

    /**
     * Realiza la operación de suma entre dos operandos.
     * @param op1 El primer operando.
     * @param op2 El segundo operando.
     * @return El resultado de la suma.
     */
    @Override
    public double sumar(double op1, double op2) {
        return op1 + op2;
    }

    /**
     * Realiza la operación de resta entre dos operandos.
     * @param op1 El primer operando.
     * @param op2 El segundo operando.
     * @return El resultado de la resta.
     */
    @Override
    public double restar(double op1, double op2) {
        return op1 - op2;
    }

    /**
     * Realiza la operación de multiplicación entre dos operandos.
     * @param op1 El primer operando.
     * @param op2 El segundo operando.
     * @return El resultado de la multiplicación.
     */
    @Override
    public double multiplicar(double op1, double op2) {
        return op1 * op2;
    }

    /**
     * Realiza la operación de división entre dos operandos.
     * @param op1 El numerador.
     * @param op2 El denominador.
     * @return El resultado de la división.
     * @throws ArithmeticException Si se doubleenta dividir por cero.
     */
    @Override
    public double dividir(double op1, double op2) throws ArithmeticException {
        if (op2 != 0) {
            return (double) op1 / op2;
        } else {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
    }
}