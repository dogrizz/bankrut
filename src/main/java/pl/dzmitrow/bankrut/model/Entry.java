package pl.dzmitrow.bankrut.model;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Value
public class Entry {

    private String description;
    private String owner;
    private List<String> tags;
    
}
