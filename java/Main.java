import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Ordenamiento de números aleatorios: Deberá crear un programa que sea capaz de generar N números aleatorios, siendo N
* un valor entero positivo ingresado por el usuario, almacenarlos en un arreglo y mostrar el contenido del arreglo.
*
* Luego su programa debe ser capaz de ordenar de menor a mayor, usando el método de la burbuja, y mostrar por consola
* el contenido del arreglo ordenado, además del tiempo que tardó en realizarse. De la misma manera se debe poder
* ordenar de mayor a menor, utilizando el método de la burbuja, debe mostrar por consola el contenido del arreglo
* ordenado, además del el tiempo que tardó en realizarse. Por último debe realizar los mismos dos ordenamientos
* utilizando los métodos de ordenamiento de la clase Arrays, mostrando lo mismo que en los pasos anteriores.
* */

/*
* Al ingresar N como numero pequeño, el tiempo de ejecucion del programa se suele aproximar a cero segundos.
* Se aconseja utilizar numeros grandes, sobre a 10000.
* */
public class Main {
    public static void main(String args[]) {
        int num = askNum();
        Integer vec[] = new Integer[num];
        fillVec(vec);
        System.out.println("Su arreglo es:");
        showVector(vec);
        System.out.println("El arreglo ordenado de menor a mayor por el metodo de la burbuja quedaria:");
        Integer vect[] = bubbleMinorMajor(vec);
        double start = System.currentTimeMillis();
        showVector(vect);
        double finish = System.currentTimeMillis();
        System.out.println("El tiempo demorado en ordenar su arreglo bajo este ordenamiento es: " + ((finish - start) / 1000));
        System.out.println("El arreglo ordenado de mayor a menor por el metodo de la burbuja quedaria:");
        Integer vecto[] = bubbleMajorMinor(vec);
        start = System.currentTimeMillis();
        showVector(vecto);
        finish = System.currentTimeMillis();
        System.out.println("El tiempo demorado en ordenar su arreglo bajo este ordenamiento es: " + ((finish - start) / 1000));
        System.out.println("El arreglo ordenado de menor a mayor por metodo de ordenamiento de Arrays es:");
        Integer vector[] = ArraySort(vec);
        start = System.currentTimeMillis();
        showVector(vector);
        finish = System.currentTimeMillis();
        System.out.println("El tiempo demorado en ordenar su arreglo bajo este ordenamiento es: " + ((finish - start) / 1000));
        System.out.println("El arreglo ordenado de mayor a menor por metodo de ordenamiento de Arrays es:");
        Integer[] vectorNew = ArraySortReverse(vec);
        start = System.currentTimeMillis();
        showVector(vectorNew);
        finish = System.currentTimeMillis();
        System.out.println("El tiempo demorado en ordenar su arreglo bajo este ordenamiento es: " + ((finish - start) / 1000));
    }

    /*
     * Metodo que se encarga de pedir al usuario un numero por pantalla y valida que este sea un numero y uno mayor a cero.
     * @return numero elegido por el usuario via pantalla.
     * */
    public static int askNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros que desee que tenga el arreglo");
        int numero;
        try {
            numero = sc.nextInt();
            if (numero < 0) {
                numero = askNum();
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo numeros enteros mayores a cero");
            numero = askNum();
        }
        return numero;
    }

    /*
     * Metodo que crea un vector con dimension dada por un usuario.
     * @param num es el numero elegido por el usuario previamente.
     * @return vec que es un vector de dimension num.
     * */
    public static int[] vec(int num) {
        int vec[] = new int[num];
        return vec;
    }

    /*
     * Metodo que rellena el vector con numeros aleatorios del 1 al 100.
     * @param vec que es un vector de tipo Integer para rellenar
     * */
    public static void fillVec(Integer vec[]) {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) (Math.random() * 100000) + 1;
        }
    }

    /*
     * Metodo que muestra el vector por pantalla.
     * @param vec que es un vector de tipo Integer para mostrar.
     * */
    public static void showVector(Integer vec[]) {
        for (int i = 0; i < vec.length; i++) {
            System.out.println("" + vec[i]);
        }
    }

    /*
     * Metodo de ordenamiento de la burbuja, menor a mayor.
     * @param vec que es un vector de tipo Integer para reordenar.
     * @return vec que es un vector de tipo Integer reordenado.
     * */
    public static Integer[] bubbleMinorMajor(Integer[] vec) {
        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = 0; j < vec.length - i - 1; j++) {
                if (vec[j + 1] < vec[j]) {
                    int aux = vec[j + 1];
                    vec[j + 1] = vec[j];
                    vec[j] = aux;
                }
            }
        }
        return vec;
    }

    /*
     * Metodo de ordenamiento de la burbuja, mayor a menor.
     * @param vec que es un vector de tipo Integer para reordenar.
     * @return vec que es un vector de tipo Integer reordenado.
     * */
    public static Integer[] bubbleMajorMinor(Integer vec[]) {
        int temp = 0;

        for (int i = 0; i < vec.length; i++) {
            for (int j = 1; j < (vec.length - i); j++) {

                if (vec[j - 1] < vec[j]) {
                    temp = vec[j - 1];
                    vec[j - 1] = vec[j];
                    vec[j] = temp;
                }
            }
        }
        return vec;
    }

    /*
     * Metodo de ordenamiento bajo la clase Arrays, de menor a mayor.
     * @param vec que es un vector de tipo Integer para reordenar.
     * @return vec que es un vector de tipo Integer reordenado.
     * */
    public static Integer[] ArraySort(Integer[] vec) {
        Arrays.sort(vec);
        return vec;
    }

    /*
     * Metodo de ordenamiento bajo la clase Arrays, de mayor a menor.
     * @param vec que es un vector de tipo Integer para reordenar.
     * @return vec que es un vector de tipo Integer reordenado.
     * */
    public static Integer[] ArraySortReverse(Integer[] vec) {
        Arrays.sort(vec, Collections.reverseOrder());
        return vec;
    }
}
