package com.barbearia.services;

import com.barbearia.domains.Cliente;
import com.barbearia.domains.dtos.ClienteDTO;
import com.barbearia.repositories.ClienteRepository;
import com.barbearia.services.exceptions.DataIntegrityViolationException;
import com.barbearia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    //Retorna uma lista de Barbeiro
    public List<ClienteDTO> findAll(){
        return clienteRepo.findAll().stream()
                .map(obj -> new ClienteDTO(obj))
                .collect(Collectors.toList());
    }

    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Cliente Não Encontrado! ID: "+ id));
    }

    public  Cliente findByCpf(String cpf){
        Optional<Cliente> obj = clienteRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente Não Encontrado! CPF: "+ cpf));
    }

    public Cliente create (ClienteDTO dto){
        dto.setIdCliente(null);
        validaCliente(dto);
        Cliente obj = new Cliente(dto);
        return clienteRepo.save(obj);
    }

    private void validaCliente(ClienteDTO dto){
        Optional<Cliente> obj = clienteRepo.findByCpf(dto.getCpf());
        if (obj.isPresent() && obj.get().getIdCliente() != dto.getIdCliente()){
            throw new DataIntegrityViolationException("CPF já Cadastrado!");
        }
    }

    public Cliente update(Integer id, ClienteDTO objDto){
        objDto.setIdCliente(id);
        Cliente oldObj = findById(id);
        validaCliente(objDto);
        oldObj = new Cliente(objDto);
        return clienteRepo.save(oldObj);
    }

    public void delete(Integer id){
        Cliente obj = findById(id);
        clienteRepo.deleteById(id);
    }

}
