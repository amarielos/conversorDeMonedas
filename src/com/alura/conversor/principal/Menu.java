package com.alura.conversor.principal;

import com.alura.conversor.api.Api;

import java.util.Scanner;

public class Menu {
    Api api = new Api();

    void llamarMenu(){
        System.out.println("""
                    ☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺
                    CONVERSOR DE MONEDAS
                    
                    1. Dólar
                    2. Quetzal Guatemalteco
                    3. Real Brasileño
                    4. Peso Argentino
                    5. Peso Colombiano
                    0. Salir
                    ☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺""");
    }

    String getMonedaString(int op) {
        switch (op) {
            case 1:
                return "USD";
            case 2:
                return "GTQ";
            case 3:
                return "BRL";
            case 4:
                return "ARS";
            case 5:
                return "COP";
        }
        return null;
    }

    public void llamarMenuPrincipal(){
        String moneda1, moneda2;
        Calculos resultado=new Calculos();
        double cant1, cant2;
        boolean salir=false;
        do {
            try {
                this.llamarMenu();
                Scanner entrada = new Scanner(System.in);
                System.out.print("Ingrese el número de la moneda inicial (o salir):");
                moneda1 = this.getMonedaString(entrada.nextInt());
                if (moneda1 != null) {
                    System.out.print("Ingrese el número de la moneda final (o salir):");
                    moneda2 = this.getMonedaString(entrada.nextInt());
                    if (moneda2 != null) {
                        System.out.print("Ingrese el monto a convertir:");
                        cant1 = entrada.nextDouble();
                        cant2 = resultado.getResultado(moneda1, moneda2, cant1);
                        System.out.printf("%s %.2f equivale a %s %.2f%n", moneda1, cant1, moneda2, cant2);
                    } else {
                        salir = true;
                    }
                } else {
                    salir = true;
                }
            }catch (Exception e){
                System.out.println("Ingrese datos válidos");
            }
        }while (!salir);
    }
}
