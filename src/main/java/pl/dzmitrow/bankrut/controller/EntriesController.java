package pl.dzmitrow.bankrut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dzmitrow.bankrut.model.Entry;
import pl.dzmitrow.bankrut.model.api.EntryDTO;
import pl.dzmitrow.bankrut.producer.EntryProducer;

import java.util.Collections;

@RestController("/entries")
public class EntriesController {

    private final EntryProducer entryProducer;

    EntriesController(EntryProducer producer) {
        this.entryProducer = producer;
    }

    @PostMapping(consumes = "application/json")
    public void createEntry(@RequestBody EntryDTO entry) {
        Entry entry2 = new Entry(entry.getDescription(), "mua", entry.getTags());
        entryProducer.send(entry2);
    }

    @GetMapping(produces = "application/json")
    public Entry getEntries() {
        return new Entry("Asd", "mua", Collections.singletonList("tag"));
    }

}