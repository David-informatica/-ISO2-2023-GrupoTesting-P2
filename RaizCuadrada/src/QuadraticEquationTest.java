

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.*;
import java.io.*;

public class QuadraticEquationTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private void provideInput(String data) {
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }
    
    @Test
    public void testPositiveDiscriminant() {
        provideInput("2\n1\n0\n");
        QuadraticEquation.main(new String[]{});

        String output = systemOutRule.getLog().trim();
        System.out.println("Output: " + output);

        assertTrue(output.contains("Las raices son reales y diferentes."));
        assertTrue(output.contains("Raiz 1 = 0.0"));
        assertTrue(output.contains("Raiz 2 = -0.5"));
    }

    @Test
    public void testOtherDiscriminant() {
        provideInput("1\n2\n3\n");
        QuadraticEquation.main(new String[]{});

        String output = systemOutRule.getLog().trim();

        assertTrue(output.contains("Las raices son complejas. No se pueden calcular en este programa."));
    }

    @Test
    public void testZeroCoefficients() {
        provideInput("1\n2\n1\n");
        QuadraticEquation.main(new String[]{});

        String output = systemOutRule.getLog().trim();

        assertTrue(output.contains("Las raices son reales e iguales."));
        assertTrue(output.contains("Raiz unica = -1.0"));
    }

}
