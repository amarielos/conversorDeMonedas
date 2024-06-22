package com.alura.conversor.principal;

import com.alura.conversor.api.Api;
import com.alura.conversor.api.Cambio;

public class Calculos {

    private double getMonedaDouble(Cambio cambio, String op){
        switch (op) {
            case "USD":
                return cambio.USD();
            case "GTQ":
                return cambio.GTQ();
            case "BRL":
                return cambio.BRL();
            case "ARS":
                return cambio.ARS();
            case "COP":
                return cambio.COP();
        }
        return 0;
    }

    double getResultado(String moneda1, String moneda2, double cant1){
        double resultado, cambio;
        Api api = new Api();
        Cambio tasaCambio = api.getCambios(moneda1);
        cambio= this.getMonedaDouble(tasaCambio,moneda2);
        resultado = cant1*cambio;
        System.out.println("");
        System.out.printf("Tasa de cambio: %s 1 ==> %s %f%n",moneda1,moneda2,cambio);
        return resultado;
    }
}
