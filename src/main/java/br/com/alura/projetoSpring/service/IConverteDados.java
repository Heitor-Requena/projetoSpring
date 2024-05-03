package br.com.alura.projetoSpring.service;

import br.com.alura.projetoSpring.model.DadosSerie;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe); //parametro de retorno generico T
}
