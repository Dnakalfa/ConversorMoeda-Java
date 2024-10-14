package com.dnak.conversorMonetario.contrato;

import com.dnak.conversorMonetario.modelo.Moeda ;

public interface ConversorMoedaInterface {
    Moeda converter(int opcao, double valor);
}