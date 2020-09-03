package pl.dzmitrow.bankrut.model.api;

import lombok.Value;

import java.util.List;

@Value
public class EntryDTO {
    private String description;
    private List<String> tags;
}
