package br.com.finances.dto.request;

import br.com.finances.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("Categoria Request DTO")
@Data
public class CategoryRequestDTO {

    @ApiModelProperty(value = "Name")
    @NotBlank(message = "Name")
    private String name;

    @ApiModelProperty(value = "Description")
    @NotBlank(message = "Description")
    private String description;

    public Category convertToEntity(Long id) {
        return new Category(id, name, description);
    }

    public Category convertToEntity() {
        return new Category(name, description);
    }

}
