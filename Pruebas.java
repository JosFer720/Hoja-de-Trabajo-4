import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

public class Pruebas {

    @Test
    public void testPushPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSumar() {
        ICalculadora calculadora = new Calculadora();
        double resultado = calculadora.sumar(2, 3);
        assertEquals(5, resultado, 0.0001);
    }

    @Test
    public void testIsEmpty() {
        Stack<Character> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push('A');
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    @Test
    public void testDivision() {
        ICalculadora calculadora = new Calculadora();
        double resultado = calculadora.dividir(2, 0);
        assertEquals(5, resultado, 0.0001);
    }
}
