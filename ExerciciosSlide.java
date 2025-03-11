import java.util.ArrayList;

public class ExerciciosSlide {

    /**
     * Calcula o fatorial de um número.
     * @param n o número para calcular o fatorial
     * @return o fatorial do número
     * @throws IllegalArgumentException se o número for negativo
     */
    public int ex1Fatorial(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Número negativo não possui fatorial");
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return n * ex1Fatorial(n - 1);
    }

    /**
     * Calcula o somatório de todos os inteiros do número dado até zero.
     * @param n o número inicial
     * @return o somatório de todos os inteiros de n até zero
     */
    public int ex2SomatorioParametroAtehNulo(int n) {
        if(n == 0) {
            return 0;
        }

        if (n > 0) {
            return n + ex2SomatorioParametroAtehNulo(n - 1);
        } else {
            return n + ex2SomatorioParametroAtehNulo(n + 1);
        }
    }

    /**
     * Calcula o enésimo número de Fibonacci.
     * @param n a posição na sequência de Fibonacci
     * @return o enésimo número de Fibonacci
     * @throws IllegalArgumentException se o número for negativo
     */
    public int ex3Fibonacci(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Número negativo não possui fibonacci");
        }

        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        return ex3Fibonacci(n - 1) + ex3Fibonacci(n - 2);
    }

    /**
     * Calcula o somatório de todos os inteiros entre dois números dados, inclusive.
     * @param a o primeiro número
     * @param b o segundo número
     * @return o somatório de todos os inteiros entre a e b
     */
    public int ex4SomatorioEntreNumeros(int a, int b) {
        if(a == b) {
            return a;
        }

        if (a < b) {
            return a + ex4SomatorioEntreNumeros(a + 1, b);
        } else {
            return a + ex4SomatorioEntreNumeros(a - 1, b);
        }    
    }

    /**
     * Verifica se uma string é um palíndromo.
     * @param str a string a ser verificada
     * @return true se a string for um palíndromo, false caso contrário
     */
    public boolean ex5EhPalindromo(String str) {
        if(str.length() == 0 || str.length() == 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return ex5EhPalindromo(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    } 

    /**
     * Converte um número natural para sua representação binária.
     * @param number o número a ser convertido
     * @return a representação binária do número
     * @throws IllegalArgumentException se o número for negativo
     */
    public String ex6ConverteBaseNaturalParaBinario(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Número negativo não possui representação binária natural"); 
        }

        if(number == 0) {
            return "0";
        }

        return ex6ConverteBaseNaturalParaBinario(number / 2) + (number % 2);
    }

    /**
     * Calcula o somatório de todos os inteiros em um ArrayList.
     * @param list o ArrayList de inteiros
     * @return o somatório de todos os inteiros na lista
     */
    public int ex7SomatorioNumerosArrayListInteiros(ArrayList<Integer> list) {
        if(list.isEmpty()) {
            return 0;
        }

        return list.remove(0) + ex7SomatorioNumerosArrayListInteiros(list);
    } 

    /**
     * Encontra o maior inteiro em um ArrayList.
     * @param list o ArrayList de inteiros
     * @return o maior inteiro na lista
     */
    public int ex8EncontraMaiorElementoArrayListInteiros(ArrayList<Integer> list) {
        if(list.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int maior = list.remove(0);
        int maiorRestante = ex8EncontraMaiorElementoArrayListInteiros(list);

        return maior > maiorRestante ? maior : maiorRestante;
    }

    /**
     * Verifica se uma substring existe dentro de uma string.
     * @param str a string a ser pesquisada
     * @param match a substring a ser procurada
     * @return true se a substring for encontrada, false caso contrário
     */
    public boolean ex9FindSubStrInsideString(String str, String match) {
        if(str.length() < match.length()) {
            return false;
        }

        if(str.substring(0, match.length()).equals(match)) {
            return true;
        }

        return ex9FindSubStrInsideString(str.substring(1), match);
    }

    /**
     * Conta o número de dígitos em um número.
     * @param n o número a ser contado os dígitos
     * @return o número de dígitos no número
     */
    public int ex10NroDigitosEmNumero(int n) {
        if(n == 0) {
            return 0;
        }

        return 1 + ex10NroDigitosEmNumero(n / 10);
    }

    /**
     * Gera todas as permutações de uma string.
     * @param str a string para gerar permutações
     * @return um ArrayList de todas as permutações da string
     */
    public ArrayList<String> ex11AllStringPermutationsDefinitionRec(String str) {
        ArrayList<String> result = new ArrayList<String>();
        ex11AllStringPermutationsAux("", str, result);
        return result;
    }

    /**
     * Método auxiliar para gerar permutações de uma string.
     * @param prefix o prefixo atual
     * @param str a string restante
     * @param result a lista para armazenar as permutações
     */
    private void ex11AllStringPermutationsAux(String prefix, String str, ArrayList<String> result) {
        int n = str.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                ex11AllStringPermutationsAux(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), result);
            }
        }
    }

    public static void main(String[] args) {
        ExerciciosSlide es = new ExerciciosSlide();

        // Teste ex1Fatorial
        System.out.println("Fatorial de 5: " + es.ex1Fatorial(5));

        // Teste ex2SomatorioParametroAtehNulo
        System.out.println("Somatório de 5 até 0: " + es.ex2SomatorioParametroAtehNulo(5));

        // Teste ex3Fibonacci
        System.out.println("Fibonacci de 5: " + es.ex3Fibonacci(5));

        // Teste ex4SomatorioEntreNumeros
        System.out.println("Somatório entre 3 e 6: " + es.ex4SomatorioEntreNumeros(3, 6));

        // Teste ex5EhPalindromo
        System.out.println("A palavra 'radar' é um palíndromo? " + es.ex5EhPalindromo("radar"));

        // Teste ex6ConverteBaseNaturalParaBinario
        System.out.println("Representação binária de 10: " + es.ex6ConverteBaseNaturalParaBinario(10));

        // Teste ex7SomatorioNumerosArrayListInteiros
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println("Somatório do ArrayList [1, 2, 3]: " + es.ex7SomatorioNumerosArrayListInteiros(list1));

        // Teste ex8EncontraMaiorElementoArrayListInteiros
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println("Maior elemento no ArrayList [1, 2, 3]: " + es.ex8EncontraMaiorElementoArrayListInteiros(list2));

        // Teste ex9FindSubStrInsideString
        System.out.println("A substring 'lo' está em 'hello'? " + es.ex9FindSubStrInsideString("hello", "lo"));

        // Teste ex10NroDigitosEmNumero
        System.out.println("Número de dígitos em 12345: " + es.ex10NroDigitosEmNumero(12345));

        // Teste ex11AllStringPermutationsDefinitionRec
        System.out.println("Todas as permutações de 'abc': " + es.ex11AllStringPermutationsDefinitionRec("abc"));
    }
}