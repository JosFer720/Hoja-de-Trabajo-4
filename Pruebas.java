import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Pruebas {

    @Test
    public void testInfixToPostfix1() {
        assertEquals("23+4*56+*", InfixToPostfix.infixToPostfix("(2+3)*4*(5+6)"));
    }
    
    @Test
    public void testInfixToPostfix2() {
        assertEquals("78+910*/1112*1314+-", InfixToPostfix.infixToPostfix("(7+8)/(9*10)-(11*12+13+14)"));
    }
    
    @Test
    public void testInfixToPostfix3() {
        assertEquals("151617*1819*20/+", InfixToPostfix.infixToPostfix("15*16*17+18*19/20"));
    }
    
    @Test
    public void testInfixToPostfix4() {
        assertEquals("21222324+*-", InfixToPostfix.infixToPostfix("21-(22*23+24)"));
    }
    
    @Test
    public void testInfixToPostfix5() {
        assertEquals("2526*2728*29/3031*32-33+", InfixToPostfix.infixToPostfix("25*26/27*28-(29*30)+31-32"));
    }
}
