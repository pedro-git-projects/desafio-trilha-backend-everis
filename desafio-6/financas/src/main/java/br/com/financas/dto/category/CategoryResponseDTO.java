package br.com.financas.dto.category;

import br.com.financas.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Categoria response DTO")
public class CategoryResponseDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Title")
    private String title;

    @ApiModelProperty(value = "Description")
    private String description;

    public CategoryResponseDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static CategoryResponseDTO convertToCategoryDTO(Category category) {
        return new CategoryResponseDTO(category.getId(), category.getTitle(), category.getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
