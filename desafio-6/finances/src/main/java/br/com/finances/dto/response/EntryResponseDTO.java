package br.com.finances.dto.response;

import br.com.finances.entity.Category;
import br.com.finances.entity.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryResponseDTO getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryResponseDTO categoryID) {
        this.categoryID = categoryID;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}