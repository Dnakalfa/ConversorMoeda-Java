package com.dnak.conversorMonetario.calculo;

import com.dnak.conversorMonetario.contrato.ConversorMoedaInterface ;
import com.dnak.conversorMonetario.modelo.Moeda ;
import com.dnak.conversorMonetario.api.ApiConversorRecord ;

public class Conversor implements ConversorMoedaInterface {

    @Override
    public Moeda converter(int opcao, double valor) {
        ApiConversorRecord api = new ApiConversorRecord();
        return switch (opcao) {
            case 1 -> new Moeda("Reais", api.getTaxa("USD-BRL") * valor);
            case 2 -> new Moeda("Dólares", api.getTaxa("BRL-USD") * valor);
            case 3 -> new Moeda("Reais", api.getTaxa("EUR-BRL") * valor);
            case 4 -> new Moeda("Euros", api.getTaxa("BRL-EUR") * valor);
            case 5 -> new Moeda("Reais", api.getTaxa("GBP-BRL") * valor);
            case 6 -> new Moeda("Libras", api.getTaxa("BRL-GBP") * valor);
            default -> null;
        };
    }
}
