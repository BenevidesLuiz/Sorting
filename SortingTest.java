package Program;

import java.util.Scanner;
import java.util.Locale;

public class SortingTest {
	 

	    public static void main(String[] args) {
	        double[] array = {64.5, 34.2, 25.1, 12.22, 22.1, 11.0, 90.8};

	        // Teste para Bubble Sort
	        System.out.println("Array original (Bubble Sort):");
	        printArray(array);

	        double[] bubbleArray = array.clone();
	        bubbleSort(bubbleArray); // Clonamos para preservar o array original

	        System.out.println("\nArray ordenado (Bubble Sort):");
	        printArray(bubbleArray);

	        System.out.println("\n====================\n");

	        // Teste para Insertion Sort
	        System.out.println("Array original (Insertion Sort):");
	        printArray(array);

	        double[] insertionArray = array.clone();
	        insertionSort(insertionArray); // Clonamos para preservar o array original

	        System.out.println("\nArray ordenado (Insertion Sort):");
	        printArray(insertionArray);

	        System.out.println("\n====================\n");

	        // Teste para Selection Sort
	        System.out.println("Array original (Selection Sort):");
	        printArray(array);

	        double[] selectionArray = array.clone();
	        selectionSort(selectionArray); // Clonamos para preservar o array original

	        System.out.println("\nArray ordenado (Selection Sort):");
	        printArray(selectionArray);
	        
	        System.out.println("\nArray original (QuickSort):");
	        printArray(array);

	        quickSort(array, 0, array.length - 1);

	        System.out.println("\nArray ordenado (QuickSort):");
	        printArray(array);
	        
	        System.out.println("\nArray original (Merge Sort):");
	        printArray(array);

	        mergeSort(array, 0, array.length - 1);

	        System.out.println("\nArray ordenado (Merge Sort):");
	        printArray(array);
	        
	        System.out.println("\nArray original (ShellSort):");
	        printArray(array);

	        shellSort(array);

	        System.out.println("\nArray ordenado (ShellSort):");
	        printArray(array);
	        
	    }
	    
	    //os 3 "Piores Algotitmos De Ordenação!"
	    
	    // Implementação do Bubble Sort
	    public static void bubbleSort(double[] arry) {
	        int size = arry.length;
	        boolean trocou;

	        do {
	            trocou = false;
	            for (int i = 0; i < size - 1; i++) {
	                if (arry[i] > arry[i + 1]) {
	                    double tmp = arry[i];
	                    arry[i] = arry[i + 1];
	                    arry[i + 1] = tmp;
	                    trocou = true;
	                }
	                System.out.printf("\nTrocando %.2f com %.2f", arry[i], arry[i + 1]);
	            }
	        } while (trocou);
	    }

	    // Implementação do Insertion Sort
	    public static void insertionSort(double[] arry) {
	        int size = arry.length;

	        for (int i = 1; i < size; i++) {
	            double key = arry[i];
	            int j = i - 1;

	            while (j >= 0 && arry[j] > key) {
	                System.out.printf("Movendo %.2f para a posição %d%n", arry[j], j + 1);
	                arry[j + 1] = arry[j];
	                j--;
	            }

	            arry[j + 1] = key;
	            System.out.printf("Inserindo %.2f na posição %d%n", key, j + 1);
	        }
	    }

	    // Implementação do Selection Sort
	    public static void selectionSort(double[] arry) {
	        int size = arry.length;

	        for (int i = 0; i < size - 1; i++) {
	            int minIndex = i;

	            for (int j = i + 1; j < size; j++) {
	                if (arry[j] < arry[minIndex]) {
	                    minIndex = j;
	                }
	            }

	            if (minIndex != i) {
	                double tmp = arry[i];
	                arry[i] = arry[minIndex];
	                arry[minIndex] = tmp;

	                System.out.printf("Trocando %.2f com %.2f%n", arry[minIndex], arry[i]);
	            }
	        }
	    }
	    
	    
	    //Os 3 "Melhores Algoritmos de Ordenacao"
	    
	    public static void quickSort(double[] arry, int esquerda, int direita) {
	        if (esquerda < direita) {
	            int pivo = particiona(arry, esquerda, direita);
	            quickSort(arry, esquerda, pivo - 1);
	            quickSort(arry, pivo + 1, direita);
	        }
	    }
	    
	    public static int particiona(double[] arry, int esquerda, int direita) {
	        double pivo = arry[direita]; 
	        int i = esquerda - 1; 

	        for (int j = esquerda; j < direita; j++) {
	            if (arry[j] <= pivo) {
	                i++;
	                double temp = arry[i];
	                arry[i] = arry[j];
	                arry[j] = temp;
	            }
	        }

	        double temp = arry[i + 1];
	        arry[i + 1] = arry[direita];
	        arry[direita] = temp;

	        return i + 1; 
	    }
	    
	    public static void mergeSort(double[] array, int esquerda, int direita) {
	        if (esquerda < direita) {
	            int meio = (esquerda + direita) / 2;

	            mergeSort(array, esquerda, meio);

	            mergeSort(array, meio + 1, direita);

	            merge(array, esquerda, meio, direita);
	        }
	    }

	    public static void merge(double[] array, int esquerda, int meio, int direita) {
	        int n1 = meio - esquerda + 1;
	        int n2 = direita - meio;

	        double[] esquerdaArray = new double[n1];
	        double[] direitaArray = new double[n2];

	        for (int i = 0; i < n1; i++)
	            esquerdaArray[i] = array[esquerda + i];
	        for (int j = 0; j < n2; j++)
	            direitaArray[j] = array[meio + 1 + j];

	        int i = 0, j = 0, k = esquerda;

	        while (i < n1 && j < n2) {
	            if (esquerdaArray[i] <= direitaArray[j]) {
	                array[k] = esquerdaArray[i];
	                i++;
	            } else {
	                array[k] = direitaArray[j];
	                j++;
	            }
	            k++;
	        }

	        while (i < n1) {
	            array[k] = esquerdaArray[i];
	            i++;
	            k++;
	        }

	        while (j < n2) {
	            array[k] = direitaArray[j];
	            j++;
	            k++;
	        }
	    }

	    public static void shellSort(double[] arry) {
	        int size = arry.length;
	        int gap = size / 2; 

	        while (gap > 0) {
	            for (int i = gap; i < size; i++) {
	                double tmp = arry[i];
	                int j = i;

	                while (j >= gap && arry[j - gap] > tmp) {
	                    arry[j] = arry[j - gap];
	                    j -= gap;
	                }

	                arry[j] = tmp;
	            }

	            gap /= 2; 
	        }
	    }

	    // Método para exibir o array
	    public static void printArray(double[] array) {
	        for (double num : array) {
	            System.out.printf("%.2f ", num);
	        }
	        System.out.println();
	    }
	}
	
	


