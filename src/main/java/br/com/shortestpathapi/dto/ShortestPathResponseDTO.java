package br.com.shortestpathapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO responsável em mapear o response da API de calculo da distância mínima.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 13/02/2020
 */
@Data
public class ShortestPathResponseDTO {

    @ApiModelProperty(value = "Rota final com menor custo", dataType = "String", example = "A B D")
    @JsonProperty
    private String rota;

    @ApiModelProperty(value = "Custo total da rota em R$", dataType = "String", example = "6.25")
    @JsonProperty
    private String custo;
}
