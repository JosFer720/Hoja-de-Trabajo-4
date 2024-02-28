/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 * doubleerfaz que define operaciones básicas de una calculadora.
 */
public interface ICalculadora {

    /**
     * Realiza la operación de suma entre dos operandos.
     * @param op1 El primer operando.
     * @param op2 El segundo operando.
     * @return El resultado de la suma.
     */
    double sumar(double op1, double op2);

    /**
     * Realiza la operación de resta entre dos operandos.
     * @param op1 El primer operando.
     * @param op2 El segundo operando.
     * @return El resultado de la resta.
     */
    double restar(double op1, double op2);

    /**
     * Realiza la operación de multiplicación entre dos operandos.
     * @param op1 El primer operando.
     * @param op2 El segundo operando.
     * @return El resultado de la multiplicación.
     */
    double multiplicar(double op1, double op2);

    /**
     * Realiza la operación de división entre dos operandos.
     * @param op1 El numerador.
     * @param op2 El denominador.
     * @return El resultado de la división.
     * @throws ArithmeticException Si se doubleenta dividir por cero.
     */
    double dividir(double op1, double op2) throws ArithmeticException;
}