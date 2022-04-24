package com.mainstream.userapp.service;

import com.mainstream.userapp.exception.ClientNotFoundException;
import com.mainstream.userapp.exception.IDNumberNotValidException;
import com.mainstream.userapp.exception.IdentityNumberAlreadyTakenException;
import com.mainstream.userapp.exception.PhoneNumberAlreadyTakenException;
import com.mainstream.userapp.model.Client;
import com.mainstream.userapp.repository.ClientRepository;
import com.mainstream.userapp.service.utils.IDNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public boolean isIdNumberValid(String IdNumber) {
        if (IDNumberValidator.validate(IdNumber) == false) {
            return false;
        } else {
            return true;
        }
    }

    public ResponseEntity<Client> createClient(Client client) {

        if (checkDuplicateMobileNumber(client.getMobileNumber()) == true) {
            throw new PhoneNumberAlreadyTakenException("Mobile number: "
                    + client.getMobileNumber() + " already taken!!");
        }

        if (checkDuplicateId(client.getIdNumber()) == true) {
            throw new IdentityNumberAlreadyTakenException("Identity Number: "
                    + client.getIdNumber() + " already taken");
        }

        if (isIdNumberValid(client.getIdNumber()) == false) {
            throw new IDNumberNotValidException("Invalid ID number");
        }
        Client savedClient = clientRepository.save(client);

        return ResponseEntity.ok().body(savedClient);
    }


    public ResponseEntity<Client> updateClient(Long id, Client client) {
        Optional<Client> existingClient = clientRepository.findById(id);

        if (!existingClient.isPresent()) {
            throw new ClientNotFoundException("Client with id: " + id + " does not exist");
        }

        Client clientToBeUpdated = existingClient.get();

        clientToBeUpdated.setFirstName(client.getFirstName());
        clientToBeUpdated.setLastName(client.getLastName());
        clientToBeUpdated.setMobileNumber(client.getMobileNumber());
        clientToBeUpdated.setPhysicalAddress(client.getPhysicalAddress());

        this.clientRepository.save(clientToBeUpdated);
        return ResponseEntity.ok().body(clientToBeUpdated);
    }


    public Client findByIdNumber(String idNumber) {
        return clientRepository.findByIdNumber(idNumber);
    }

    public Client findByMobileNumber(String mobileNumber) {
        return clientRepository.findByMobileNumber(mobileNumber);
    }


    public boolean checkDuplicateId(String idNumber) {
        if (findByIdNumber(idNumber) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDuplicateMobileNumber(String mobileNumber) {
        if (findByMobileNumber(mobileNumber) != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Client> getByKeyword(String keyword) {
        List<Client> result = clientRepository.findByKeyword(keyword);
        return result;
    }


}
