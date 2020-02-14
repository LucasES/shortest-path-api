package br.com.shortestpathapi.service;

import br.com.shortestpathapi.model.Graph;
import br.com.shortestpathapi.model.Node;

@FunctionalInterface
public interface IShortestPath {

    Graph shortestPath(Graph graph, Node source);
}
