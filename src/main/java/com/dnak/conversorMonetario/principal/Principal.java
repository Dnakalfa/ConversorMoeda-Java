package com.dnak.conversorMonetario.principal;

import com.dnak.conversorMonetario.calculo.Conversor;
import com.dnak.conversorMonetario.modelo.Moeda;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha o tipo de conversão no menu:");
        System.out.println("1. Dólar para Real");
        System.out.println("2. Real para Dólar");
        System.out.println("3. Euro para Real");
        System.out.println("4. Real para Euro");
        System.out.println("5. Libra para Real");
        System.out.println("6. Real para Libra");
        System.out.print("DIGITE A OPÇÃO:  ");

        int opcao = scanner.nextInt();
        System.out.print("Digite o valor a ser convertido (apenas numeros): ");
        double valor = scanner.nextDouble();

        Moeda resultado = conversor.converter(opcao, valor);

        if (resultado != null) {
            System.out.println("Resultado da conversão" + resultado);
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}