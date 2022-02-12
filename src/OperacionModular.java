import com.sun.istack.internal.NotNull;

import java.util.Stack;

public class OperacionModular {
    private int base;
    private int exponente;
    private int modulo;

    public OperacionModular(int base, int exponente, int modulo) {
        this.base = base;
        this.exponente = exponente;
        this.modulo = modulo;
    }

    @NotNull
    // OJO! Si se lee el stack por pantalla parecerá que los números están en el orden inverso,
    // esto no es un problema porque los iremos desapilando uno a uno en orden desde el principio, por lo que estarán ordenados al obtenerlos
    private Stack<Boolean> toBinaryStack(int numero){
        int cociente, resto;
        Stack<Boolean> result = new Stack<>();
        do{
            cociente = numero/2;
            resto = numero%2;
            result.add(resto==1);
            numero = cociente;
        }while(cociente!=0);
        return result;
    }

    public int calcularMostrandoPasos(){
        Stack<Boolean> exponenteBinario = toBinaryStack(this.exponente);
        int resultadoIterativo = 1; // primer numero que ponemos en la operación

        int i=1;

        System.out.println("OPERACIÓN: "+base+"^"+exponente+" mod "+modulo);
        while(!exponenteBinario.empty()){
            boolean digitoBinario = exponenteBinario.pop();
            int numeroBinario = digitoBinario? 1 : 0;
            System.out.print("    [Paso "+i+"]\t");
            System.out.print(numeroBinario+"   ");
            System.out.printf("%10s", "("+resultadoIterativo+"^2) * ");
            System.out.printf("%-8s", (int)Math.pow(this.base, numeroBinario)+" ");
            System.out.print("mod "+this.modulo+" = ");
            int resultadoLocal = calculoLocal(numeroBinario, resultadoIterativo);
            System.out.println(resultadoLocal);
            resultadoIterativo = resultadoLocal;
            i++;
        }
        System.out.println("El resultado es: "+resultadoIterativo+"\n\n");
        return resultadoIterativo;
    }

    private int calculoLocal(int numeroBinario, int resultadoIterativo){
        return (int) (Math.pow(resultadoIterativo, 2) * Math.pow(this.base, numeroBinario) )%this.modulo;
    }


}
