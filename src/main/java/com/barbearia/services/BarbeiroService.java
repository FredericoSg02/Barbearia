package com.barbearia.services;

import com.barbearia.domains.Barbeiro;
import com.barbearia.domains.dtos.BarbeiroDTO;
import com.barbearia.repositories.BarbeiroRepository;
import com.barbearia.services.exceptions.DataIntegrityViolationException;
import com.barbearia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepo;
    //Retorna uma lista de BarbeiroDTO
    public List<BarbeiroDTO> findAll(){
        return barbeiroRepo.findAll().stream()
                .map(obj -> new BarbeiroDTO(obj))
                .collect(Collectors.toList());
    }

    public Barbeiro findById(Integer id){
        Optional<Barbeiro> obj = barbeiroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Barbeiro Não Encontrado! ID: "+ id));
    }

    public Barbeiro findByCpf(String cpf){
        Optional<Barbeiro> obj = barbeiroRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Barbeiro Não Encontrado! CPF: "+ cpf));
    }

    public Barbeiro create (BarbeiroDTO dto){
        dto.setIdBarbeiro(null);
        validaBarbeiro(dto);
        Barbeiro obj = new Barbeiro(dto);
        return barbeiroRepo.save(obj);
    }

    private void validaBarbeiro(BarbeiroDTO dto){
        Optional<Barbeiro> obj = barbeiroRepo.findByCpf(dto.getCpf());
        if (obj.isPresent() && obj.get().getIdBarbeiro() != dto.getIdBarbeiro()){
            throw new DataIntegrityViolationException("CPF já Cadastrado!");
        }
    }

    public Barbeiro update(Integer id, BarbeiroDTO objDto){
        objDto.setIdBarbeiro(id);
        Barbeiro oldObj = findById(id);
        validaBarbeiro(objDto);
        oldObj = new Barbeiro(objDto);
        return barbeiroRepo.save(oldObj);
    }

    public void delete(Integer id){
        Barbeiro obj = findById(id);
        barbeiroRepo.deleteById(id);
    }
}
