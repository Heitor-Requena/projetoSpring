package br.com.alura.projetoSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadas(@JsonAlias("Season") Integer temporada,
                              @JsonAlias("Episodes") List<DadosEpisodeo> episodeos) {
}
