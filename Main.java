import java.util.List;
import java.util.Scanner;

/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Marcelo Detlefsen, Jose Rivera, Fabián Prado
 * Creación: 01/03/2025
 * última modificación: 01/03/2025
 * File Name: Main.java
 * Descripción: Clase principal que utiliza el Lexer para:
 *   1) Determinar si la expresión LISP es correcta 
 *   2) Listar los elementos (tokens) generados
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder codeBuilder = new StringBuilder();

        System.out.println("\nIngrese la expresión LISP (puede usar varias líneas).");
        System.out.println("Al terminar de ingresarla, presione Enter en una línea vacía para finalizar:\n");

        // Leemos todas las lineas y vamos manejandolas una a una, en el momento que encontremos una vacia paramos
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break; // Se para el proceso
            }
            codeBuilder.append(line).append(" ");
        }

        System.out.println();
        String code = codeBuilder.toString();

        Lexer lexer = new Lexer();

        // Se verifica si la instancia de la expresion sea correcta 
        boolean balanced = lexer.isBalanced(code);

        if (!balanced) {
            System.out.println("La expresión: " + code + " es incorrecta.");
            scanner.close();
            return;
        }

        // Al estar correcta, tokenizamos la expresion de LISP
        List<Token> tokens = lexer.tokenize(code);


        // Imprimimos la lista de tokens
        System.out.print("Lista de elementos (tokens):");
        for (int i = 0; i < tokens.size(); i++) {
            System.out.print(tokens.get(i).getValue());
            // Si no es el ultimo le agregamos una coma para el siguiente
            if (i < tokens.size() - 1) {
                System.out.print(", ");
            }
        }

        scanner.close();
    }
}