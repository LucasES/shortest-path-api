package br.com.shortestpathapi.model;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

@Data
public class Node {

    private String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

}
