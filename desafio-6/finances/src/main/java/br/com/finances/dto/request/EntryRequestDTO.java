package br.com.finances.dto.request;

import br.com.finances.entity.Category;
import br.com.finances.entity.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Entry Request DTO")
public class EntryRequestDTO {

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Description")
    private String description;

    @ApiModelProperty(value = "Type")
    private String type;

    @ApiModelProperty(value = "Amount")
    private String amount;

    @ApiModelProperty(value = "Date")
    private String date;

    @ApiModelProperty(value = "Paid")
    private boolean paid;


    public Entry convertToEntity(Long codigoCategoria) {
        return new Entry(new Category(codigoCategoria), name, description, type, amount, date, paid);
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

}
