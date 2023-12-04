import java.util.Scanner;

class InputOutputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readDouble(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada no valida. Introduce un numero valido.");
            scanner.next(); 
        }
        return scanner.nextDouble();
    }

    public static void display(String message) {
        System.out.println(message);
    }
}

class QuadraticEquation {
    public static void main(String[] args) {
        try {
            InputOutputHandler.display("Ingrese los coeficientes de la ecuación (ax^2 + bx + c = 0)");

            double a = InputOutputHandler.readDouble("Coeficiente a: ");
            double b = InputOutputHandler.readDouble("Coeficiente b: ");
            double c = InputOutputHandler.readDouble("Coeficiente c: ");

            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                InputOutputHandler.display("Las raices son reales y diferentes.");
                InputOutputHandler.display("Raiz 1 = " + root1);
                InputOutputHandler.display("Raiz 2 = " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                InputOutputHandler.display("Las raices son reales e iguales.");
                InputOutputHandler.display("Raiz unica = " + root);
            } else {
                throw new Exception("Las raices son complejas. No se pueden calcular en este programa.");
            }
        } catch (Exception e) {
            InputOutputHandler.display("Error: " + e.getMessage());
        }
    }
}