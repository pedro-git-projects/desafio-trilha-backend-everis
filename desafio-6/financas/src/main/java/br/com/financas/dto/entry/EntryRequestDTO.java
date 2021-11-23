package br.com.financas.dto.entry;


import br.com.financas.entity.Category;
import br.com.financas.entity.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel("Entry Request DTO")
public class EntryRequestDTO {

    @ApiModelProperty(value = "Title")
    @NotEmpty(message = "O título é um campo obrigatório")
    private String title;

    @ApiModelProperty(value = "Description")
    @NotEmpty(message = "A descrição é um campo obrigatório")
    private String description;

    @ApiModelProperty(value = "Type")
    @NotEmpty(message = "O tipo é um campo obrigatório")
    private String type;

    @ApiModelProperty(value = "Amount")
    @NotEmpty(message = "A quantidade é um campo obrigatório")
    @Digits(integer = 6, fraction = 2, message = "Preencha apenas com dígitos numéricos")
    private String amount;

    @ApiModelProperty(value = "Date")
    @NotEmpty(message = "A data é um campo obrigatório")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)" +
            "(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|" +
            "^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]" +
            "|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d" +
            "|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",
            message = "Insira a data em algum dos formatos: dd/mm/YYYY, dd-mm-YYYY, " +
                    "dd.mm.YYYY, dd mmm YYYY, dd-mmm-YYYY, dd/mmm/YYYY, dd.mmm.YYYY")
    private String date;

    @ApiModelProperty(value = "Paid")
    @NotNull
    private boolean paid;


    public Entry convertToEntity(Long idCategory) {
        return new Entry(title, description, type, amount, date, paid, new Category(idCategory));
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
}
