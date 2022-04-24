package com.mainstream.userapp.controller;

import com.mainstream.userapp.model.Client;
import com.mainstream.userapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
       return clientService.createClient(client);
    }

    @GetMapping(value = "/search")
    public List<Client> searchClient(@RequestParam(name = "keyword") String keyword){
        return clientService.getByKeyword(keyword);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Client>updateClient(@PathVariable("id") long id, @RequestBody Client client){
        return clientService.updateClient(id,client);
    }

}
