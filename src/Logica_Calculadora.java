import java.util.Stack;
//La lógica de con Jess

public class Logica_Calculadora {

    public double hacerOperaciones(String operaciones) {
        // Eliminar espacios en blanco
        operaciones = operaciones.replaceAll("\\s+", "");

        // Stack para almacenar números
        Stack<Double> numeros = new Stack<>();
        // Stack para almacenar operadores
        Stack<Character> operadores = new Stack<>();

        // Iterar sobre la cadena de operaciones
        for (int i = 0; i < operaciones.length(); i++) {
            char c = operaciones.charAt(i);
            // Si el carácter es un dígito, leer el número completo y agregarlo a la pila de números
            if (Character.isDigit(c) || c == '.') {
                StringBuilder numeroStr = new StringBuilder();
                while (i < operaciones.length() && (Character.isDigit(operaciones.charAt(i)) || operaciones.charAt(i) == '.')) {
                    numeroStr.append(operaciones.charAt(i));
                    i++;
                }
                i--; // Retroceder un índice
                numeros.push(Double.parseDouble(numeroStr.toString()));
            } else if (c == '(') {
                // Si es un paréntesis izquierdo, agregarlo a la pila de operadores
                operadores.push(c);
            } else if (c == ')') {
                // Si es un paréntesis derecho, realizar las operaciones dentro del paréntesis
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    realizarOperacion(numeros, operadores);
                }
                operadores.pop(); // Eliminar el paréntesis izquierdo
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Si es un operador, realizar operaciones de acuerdo a la prioridad
                while (!operadores.isEmpty() && obtenerPrioridad(operadores.peek()) >= obtenerPrioridad(c)) {
                    realizarOperacion(numeros, operadores);
                }
                operadores.push(c);
            } else if (c == '%') {
                // Si es un porcentaje, calcularlo y agregarlo a la pila de números
                double num = numeros.pop();
                double resultado = num / 100.0;
                numeros.push(resultado);
            } else if (c == '√') {
                // Si es una raíz cuadrada, calcularla y agregarla a la pila de números
                double num = numeros.pop();
                double resultado = Math.sqrt(num);
                numeros.push(resultado);
            } else if (c == '²') {
                // Si es un cuadrado, calcularlo y agregarlo a la pila de números
                double num = numeros.pop();
                double resultado = num * num;
                numeros.push(resultado);
            }

        }

        // Realizar operaciones restantes
        while (!operadores.isEmpty()) {
            realizarOperacion(numeros, operadores);
        }

        // El resultado final estará en la cima de la pila de números
        return numeros.pop();
    }

    private int obtenerPrioridad(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        }
        return 0; // Paréntesis
    }

    private void realizarOperacion(Stack<Double> numeros, Stack<Character> operadores) {
        char operador = operadores.pop();
        double num2 = numeros.pop();
        double num1 = numeros.pop();
        switch (operador) {
            case '+':
                numeros.push(num1 + num2);
                break;
            case '-':
                numeros.push(num1 - num2);
                break;
            case '*':
                numeros.push(num1 * num2);
                break;
            case '/':
                numeros.push(num1 / num2);
                break;
        }
    }
}
