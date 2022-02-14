import java.util.*;

public class Main {
    public static void main(String[] args){
        Menus.imprimirMenuInicio();

        int valorPorTeclado;

        do{
            Menus.imprimirMenuOpciones();
            Scanner sc = new Scanner(System.in);
            valorPorTeclado = sc.nextInt();
            if(valorPorTeclado==0) System.out.println("Hasta luego!");
            else if(valorPorTeclado == 1){
                int base, exponente, modulo;

                System.out.print("\nBase: ");
                base = sc.nextInt();
                System.out.print("Exponente: ");
                exponente = sc.nextInt();
                System.out.print("Modulo: ");
                modulo = sc.nextInt();
                System.out.println();

                OperacionModular op = new OperacionModular(base, exponente, modulo);
                op.calcularMostrandoPasos();
            }
            else System.out.println("\nError. Esa opción no existe. Introduce de nuevo la opción.\n");
        }while(valorPorTeclado!=0);

    }




}
