package br.com.finances.dto.response;

import br.com.finances.entity.Category;
import br.com.finances.entity.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;


@ApiModel("Entry Response DTO")
@Data
public class EntryResponseDTO {

    @ApiModelProperty(value = "id")
    private  Long id;

    @ApiModelProperty(value = "category")
    private CategoryResponseDTO categoryID;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "type")
    private String type;

    @ApiModelProperty(value = "amount")
    private String amount;

    @ApiModelProperty(value = "date")
    private String date;

    @ApiModelProperty(value = "paid")
    private Boolean paid;

    public EntryResponseDTO() {}

    public EntryResponseDTO(Long id, CategoryResponseDTO categoryID, String name, String description, String type, String amount, String date, Boolean paid) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }

    public EntryResponseDTO(Long id, Category categoryID, String title, String description, String type, String amount, String date, Boolean paid) {
    }

    public static EntryResponseDTO convertEntryDTO(Entry entry) {
        return new EntryResponseDTO(
                entry.getId(),
                CategoryResponseDTO.convertToCategoryDTO(entry.getCategoryID()),
                entry.getName(),
                entry.getDescription(),
                entry.getType(),
                entry.getAmount(),
                entry.getDate(),
                entry.getPaid()
        );
    }

    public CategoryResponseDTO getCategoryID() {
        return categoryID;
    }

}