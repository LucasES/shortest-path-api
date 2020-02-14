package br.com.shortestpathapi.service;

import br.com.shortestpathapi.model.Graph;
import br.com.shortestpathapi.model.Node;

import java.util.Optional;

/**
 * Interface responsável em centralizar todos os métodos para manipular a lógica
 * de negócio do algoritmo de Shortest Path
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
public interface IShortestPathService {

    /**
     * Este  método tem como objetivo realizar o calculo do menor caminho entre dois pontos.
     *
     * @param origem
     * @return Optional Graph
     */
    Optional<Graph> calculateShortestPathFromSource(String origem);
}
