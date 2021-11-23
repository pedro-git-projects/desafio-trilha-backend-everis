package br.com.financas.dto.entry;

import br.com.financas.entity.Category;
import br.com.financas.entity.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Entry Response DTO")
public class EntryResponseDTO {

    @ApiModelProperty(value = "id")
    private  Long id;

    @ApiModelProperty(value = "category")
    private Category categoryID;

    @ApiModelProperty(value = "title")
    private String title;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "type")
    private String type;

    @ApiModelProperty(value = "amount")
    private String amount;

    @ApiModelProperty(value = "date")
    private String date;

    @ApiModelProperty(value = "paid")
    private boolean paid;

    public EntryResponseDTO() {}

    public EntryResponseDTO(Long id, Category categoryID, String title, String description, String type, String amount, String date, boolean paid) {
        this.id = id;
        this.categoryID = categoryID;
        this.title = title;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public static EntryResponseDTO convertEntryDTO(Entry entry) {
        return new EntryResponseDTO(
                entry.getId(),
                entry.getCategoryID(),
                entry.getTitle(),
                entry.getDescription(),
                entry.getType(),
                entry.getAmount(),
                entry.getDate(),
                entry.isPaid()
        );
    }

}
