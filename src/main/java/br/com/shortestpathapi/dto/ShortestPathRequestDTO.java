package br.com.shortestpathapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * DTO responsável em mapear o payload da API de calculo da distância mínima.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 13/02/2020
 */
@Data
@Validated
public class ShortestPathRequestDTO {

    @NotEmpty(message = "O campo origem deve estar presente!")
    @ApiModelProperty(value = "Ponto de origem", dataType = "String", example = "A", required = true)
    @JsonProperty
    private String origem;

    @NotEmpty(message = "O campo destino deve estar presente!")
    @ApiModelProperty(value = "Ponto de destino", dataType = "String", example = "D", required = true)
    @JsonProperty
    private String destino;

    @NotEmpty(message = "O campo autonomia deve estar presente!")
    @ApiModelProperty(value = "Autonomia do caminhão (km/l)", dataType = "String", example = "10", required = true)
    @JsonProperty
    private String autonomia;

    @NotEmpty(message = "O campo valorLitro deve estar presente!")
    @ApiModelProperty(value = "Autonomia do caminhão (km/l)", dataType = "String", example = "2.50", required = true)
    @JsonProperty
    private String valorLitro;
}
