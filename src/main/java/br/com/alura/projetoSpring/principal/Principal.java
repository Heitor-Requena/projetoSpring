package br.com.alura.projetoSpring.principal;

import br.com.alura.projetoSpring.model.DadosEpisodeo;
import br.com.alura.projetoSpring.model.DadosSerie;
import br.com.alura.projetoSpring.model.DadosTemporadas;
import br.com.alura.projetoSpring.service.ConsumoAPI;
import br.com.alura.projetoSpring.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI api = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7235c83b";

    public void exibiMenu(){
        System.out.println("Digite o nome da série para a busca: ");
        var nomeSerie = leitura.nextLine();

        var json = api.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporadas> listaTemporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++){
            String url = ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY;
            json = api.obterDados(url);
            DadosTemporadas temporada = conversor.obterDados(json, DadosTemporadas.class);
            listaTemporadas.add(temporada);
        }

        listaTemporadas.forEach(System.out::println);

//        for (int i = 0; i < dados.totalTemporadas(); i++){
//            List<DadosEpisodeo> episodeosTemporada = listaTemporadas.get(i).episodeos();
//            for (int j = 0; j < episodeosTemporada.size(); j++){
//                System.out.println(episodeosTemporada.get(j).titulo());
//            }
//        }

        //ESSA LINHA FAZ A MESMA COISA QUE O FOR DE CIMA      È UMA FUNÇÂO LAMBDA
        listaTemporadas.forEach(t -> t.episodeos().forEach(e -> System.out.println(e.titulo())));
    }
}
