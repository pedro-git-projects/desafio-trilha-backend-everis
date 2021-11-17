package br.com.financas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* this class will be used to flatten
* entries and categories into a single
* class
* */

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