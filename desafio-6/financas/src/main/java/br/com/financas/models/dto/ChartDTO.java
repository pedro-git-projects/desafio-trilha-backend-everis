package br.com.financas.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {
    private String entryAmount;
    private String categoryTitle;
    private String entryTitle;
    private String entryType;
    private long amountSum;
}
