package br.com.shortestpathapi.controller;

import br.com.shortestpathapi.dto.ShortestPathRequestDTO;
import br.com.shortestpathapi.dto.ShortestPathResponseDTO;
import br.com.shortestpathapi.service.IShortestPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    private IShortestPath iShortestPath;

    @PostMapping(value = "/v1/distance")
    public ResponseEntity<ShortestPathResponseDTO> calculateShortestDistance(@RequestBody @Valid ShortestPathRequestDTO shortestPathRequestDTO) {

        System.out.println(shortestPathRequestDTO);

        return ResponseEntity.ok(new ShortestPathResponseDTO());
    }
}
