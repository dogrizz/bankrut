package pl.dzmitrow.bankrut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dzmitrow.bankrut.model.Entry;
import pl.dzmitrow.bankrut.producer.EntryProducer;

import java.util.Collections;

@RestController
public class MyController {

    private final EntryProducer entryProducer;

    MyController(EntryProducer producer){
        this.entryProducer = producer;
    }

    @GetMapping("/hello")
    public String hello(){
        entryProducer.send(new Entry("Stuff","me", Collections.singletonList("other")));
        return "Hello";
    }

}