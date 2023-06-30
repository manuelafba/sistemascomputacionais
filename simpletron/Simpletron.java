import java.util.Scanner;

public class Simpletron {
    public static final int READ = 10;
    public static final int WRITE = 11;
    public static final int LOAD = 20;
    public static final int STORE = 21;
    public static final int ADD = 30;
    public static final int SUBTRACT = 31;
    public static final int DIVIDE = 32;
    public static final int MULTIPLY = 33;
    public static final int BRANCH = 40;
    public static final int BRANCHNEG = 41;
    public static final int BRANCHZERO = 42;
    public static final int HALT = 43;

    public static void main(String[] args) {
        int[] mp = new int[100];
        int inst = 0;
        int end = 0;
        int r0 = 0;
        int i = 0;
        int codOp = 0;
        int operando = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bem vindo ao Simpletron em Java!                  ===");
        System.out.println("=== Por favor, digite seu programa, uma instrução     ===");
        System.out.println("=== (ou palavra de dados) de cada vez. Eu digitarei o ===");
        System.out.println("=== número da posição e um ponto de interrogação (?). ===");
        System.out.println("=== Então você digita a palavra para aquela posição   ===");
        System.out.println("=== Digite a sentinela -99999 para terminar a entrada ===");
        System.out.println("=== de seu programa                                   ===");

        while (inst != -99999) {
            System.out.print(end + "?: ");
            inst = scanner.nextInt();
            if (inst == -99999) {
                System.out.println("== Carga do programa completa       ==");
                System.out.println("== Iniciando a execução do programa ==");
            } else {
                mp[end] = inst;
            }
            end++;
        }

        while (i != 43) {
            codOp = mp[i] / 100;
            operando = mp[i] % 100;

            if (codOp == READ) {
                System.out.print("Digite um valor para a " + operando + "ª célula: ");
                mp[operando] = scanner.nextInt();
            }
            if (codOp == WRITE) {
                System.out.println(mp[operando]);
            }
            if (codOp == LOAD) {
                r0 = mp[operando];
            }
            if (codOp == STORE) {
                mp[operando] = r0;
            }
            if (codOp == ADD) {
                r0 += mp[operando];
            }
            if (codOp == SUBTRACT) {
                r0 -= mp[operando];
            }
            if (codOp == DIVIDE) {
                if (r0 != 0 && mp[operando] != 0) {
                    r0 /= mp[operando];
                } else {
                    System.out.println("ERRO! Divisão por zero!");
                }
            }
            if (codOp == MULTIPLY) {
                r0 *= mp[operando];
            }
            if (codOp == BRANCH) {
                    i = operando;
                    continue;
            }
            if (codOp == BRANCHZERO) {
                if (r0 == 0) {
                    i = operando;
                    continue;
                }
            }
            if (codOp == BRANCHNEG) {
                if (r0 < 0) {
                    i = operando;
                    continue;
                }
            }
            if (codOp == HALT) {
                break;
            }

            i++;
        }

        System.out.println("=== O programa terminou de forma normal ===");
        System.out.println();
        System.out.println("REGISTRADORES");
        System.out.println("R0: " + r0);
        System.out.println("Counter: " + i);
        System.out.println("RI: " + mp[i]);
        System.out.println("Código de operação: " + codOp);
        System.out.println("Operando: " + operando);
        System.out.println();

        System.out.println("==== MEMÓRIA ====");
        for (int j = 0; j < 100; j++) {
            String endereco = String.format("%02d", j);
            String conteudo = String.valueOf(mp[j]);
            System.out.println(endereco + " - " + conteudo);
        }
    }
}
