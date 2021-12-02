package br.com.finances.dto.request;

import br.com.finances.entity.Category;
import br.com.finances.entity.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
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


}
