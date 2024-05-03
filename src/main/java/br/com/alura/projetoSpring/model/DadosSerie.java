package br.com.alura.projetoSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,//Passando Um array, ele entende que pode ser qualquer uma dessas palavras
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao){ //O JsonProperty faz a deszeriliação e seriliação do json com base na palavra
}
