package package04_EstruturasRepetitivas.challenge;

import java.util.Locale;
import java.util.Scanner;

public class Atletas {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        int n;
        String nome = "", atletaMaisAlto = "";
        char sexo;
        double altura = 0.0, maiorAltura = 0.0;
        double peso, somaPeso = 0.0, mediaPeso = 0.0;
        double somaHomens = 0, porcHomens = 0.0;
        double somaMulheres = 0.0, somaAlturaMulheres = 0.0, mediaAlturaMulheres = 0.0;

        System.out.println();
        System.out.print("Qual a quantidade de atletas? ");
        n = scan.nextInt();
        while (n < 0) {
            System.out.print("Não permitido valor negativo. Digite um novo valor: ");
            n = scan.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("Digite os dados do atleta numero: " + i);
            System.out.print("Nome: ");
            scan.nextLine(); // Break Line pending
            nome = scan.nextLine();

            System.out.print("Sexo: ");
            sexo = scan.next().charAt(0);
            while (sexo != 'f' && sexo != 'F' && sexo != 'm' && sexo != 'M') {
                System.out.print("Digite (F/M) para o sexo: ");
                sexo = scan.next().charAt(0);
            }
            if (sexo == 'm' || sexo == 'M') {
                somaHomens += 1;
                porcHomens = somaHomens / n * 100;
            } else {
                somaMulheres += 1;
            }

            System.out.print("Altura: ");
            altura = scan.nextDouble();
            while (altura <= 0) {
                System.out.print("Digite um valor positivo para altura: ");
                altura = scan.nextDouble();
            }
            if (altura > maiorAltura) {
                maiorAltura = altura;
                atletaMaisAlto = nome;
            }

            if (sexo == 'f' || sexo == 'F') {
                somaAlturaMulheres += altura;
                mediaAlturaMulheres = somaAlturaMulheres / somaMulheres;
            }

            System.out.print("Peso: ");
            peso = scan.nextDouble();
            while (peso <= 0) {
                System.out.print("Digite um valor positivo para peso: ");
                peso = scan.nextDouble();
            }
            somaPeso += peso;
            mediaPeso = somaPeso / n;
        }

        System.out.println();
        System.out.println("RELATÓRIO:");
        System.out.printf("Peso médio dos atletas: %.2f%n", mediaPeso);
        System.out.println("Atleta mais alto: " + atletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f %% %n", porcHomens);

        if (somaMulheres > 0) {
            System.out.printf("Altura média das mulheres: %.2f%n", mediaAlturaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }
        System.out.println(nome);
        System.out.println();
        scan.close();
    }
}
