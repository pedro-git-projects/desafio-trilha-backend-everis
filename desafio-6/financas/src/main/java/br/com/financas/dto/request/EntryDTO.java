package br.com.financas.dto.request;

import br.com.financas.model.Entry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// Esta classe não se conectará ao banco de dados
@AllArgsConstructor
@NoArgsConstructor
public class EntryDTO {


    private String title;
    private String description;
    private String type;
    private String amount;
    private String date;
    private boolean paid;

    public Entry build() {
        return new Entry()
                .setAmount(this.amount)
                .setDate(this.date)
                .setDescription(this.description)
                .setTitle(this.title)
                .setType(this.type)
                .setPaid(this.paid);
    }

}
