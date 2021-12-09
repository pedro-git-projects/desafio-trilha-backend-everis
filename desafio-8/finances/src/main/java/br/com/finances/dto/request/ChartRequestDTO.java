package br.com.finances.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartRequestDTO {
    private String entryAmount;
    private String categoryTitle;
    private String entryTitle;
    private String entryType;
    private long amountSum;
}
