package br.com.financas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryDTO {

    private  Long id;
    private String title;
    private String description;
    private String type;
    private String amount;
    private String date;
    private boolean paid;



}
