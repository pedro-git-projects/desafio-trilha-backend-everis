package br.com.financas.dto.category;

import br.com.financas.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@ApiModel("Categoria Request DTO")
public class CategoryRequestDTO {

    @ApiModelProperty(value = "Title")
    @NotBlank(message = "Title")
    private String title;

    @ApiModelProperty(value = "Description")
    @NotBlank(message = "Description")
    private String description;

    public Category convertToEntity(Long id) {
        return new Category(id, title, description);
    }

    public Category convertToEntity() {
        return new Category(title, description);
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
