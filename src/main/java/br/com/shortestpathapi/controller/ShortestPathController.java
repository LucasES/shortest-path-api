package br.com.shortestpathapi.controller;

import br.com.shortestpathapi.dto.ShortestPathRequestDTO;
import br.com.shortestpathapi.dto.ShortestPathResponseDTO;
import br.com.shortestpathapi.model.Graph;
import br.com.shortestpathapi.model.Node;
import br.com.shortestpathapi.service.IShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

/**
 * Controlador responsável em centralizar as API's REST para calculo da distância mínima.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 13/02/2020
 */
@RestController
public class ShortestPathController {

    @Autowired
    private IShortestPathService iShortestPath;

    @PostMapping(value = "/v1/distance")
    public ResponseEntity<ShortestPathResponseDTO> calculateShortestDistance(@RequestBody @Valid ShortestPathRequestDTO shortestPathRequestDTO) {

        Optional<Graph> optionalGraph = this.iShortestPath.calculateShortestPathFromSource(shortestPathRequestDTO.getOrigem());

        if(!optionalGraph.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Optional<ShortestPathResponseDTO> responseDTO = buildResponse(optionalGraph.get(), shortestPathRequestDTO.getDestino(), shortestPathRequestDTO.getAutonomia(), shortestPathRequestDTO.getValorLitro());

        if(!responseDTO.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(responseDTO.get());
    }

    /**
     * Método responsável em montar o objeto de resposta.
     *
     * @param graph
     * @param destino
     * @param autonomia
     * @param valorLitro
     * @return Optional ShortestPathResponseDTO
     */
    private Optional<ShortestPathResponseDTO> buildResponse(Graph graph, String destino, String autonomia, String valorLitro) {

        Optional<Node> optionalNode = graph.getNodes().stream().filter(n -> n.getName().equalsIgnoreCase(destino)).findFirst();

        if (!optionalNode.isPresent()) {
            return Optional.empty();
        }

        Node node = optionalNode.get();

        StringBuilder caminho = new StringBuilder();

        for (Node n : node.getShortestPath()) {
            caminho.append(" ").append(n.getName());
        }

        caminho.append(" ").append(node.getName());

        int autonomiaInt = Integer.parseInt(autonomia);
        float caminhoPercorrido = (float) node.getDistance() / autonomiaInt;
        float custoLitro = Float.parseFloat(valorLitro);

        float custoTotal = custoLitro * caminhoPercorrido;

        ShortestPathResponseDTO shortestPathResponseDTO = new ShortestPathResponseDTO();
        shortestPathResponseDTO.setRota(caminho.toString().trim());
        shortestPathResponseDTO.setCusto(String.valueOf(custoTotal));

        return Optional.of(shortestPathResponseDTO);
    }
}
