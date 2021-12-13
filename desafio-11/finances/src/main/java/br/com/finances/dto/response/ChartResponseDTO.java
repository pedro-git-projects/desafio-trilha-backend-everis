package br.com.finances.dto.response;

import br.com.finances.entity.Category;
import br.com.finances.entity.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartResponseDTO {
    private String entryAmount;
    private String categoryTitle;
    private String entryTitle;
    private String entryType;
    private long amountSum;

    public ChartResponseDTO(String entryAmount, String categoryTitle, String entryTitle, String entryType) {
        this.entryAmount = entryAmount;
        this.categoryTitle = categoryTitle;
        this.entryTitle = entryTitle;
        this.entryType = entryType;
    }

    public static ChartResponseDTO convertChartDTO(Entry entry, Category category) {
        return new ChartResponseDTO(
                entry.getAmount(),
                entry.getName(),
                category.getName(),
                entry.getType()
        );
    }
}
