package br.com.finances.dto.response;

import br.com.finances.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Categoria response DTO")
public class CategoryResponseDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Description")
    private String description;

    public CategoryResponseDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static CategoryResponseDTO convertToCategoryDTO(Category category) {
        return new CategoryResponseDTO(category.getId(), category.getName(), category.getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
