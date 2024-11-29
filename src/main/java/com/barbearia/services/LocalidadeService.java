package com.barbearia.services;

import com.barbearia.domains.Localidade;
import com.barbearia.domains.dtos.LocalidadeDTO;
import com.barbearia.repositories.LocalidadeRepository;
import com.barbearia.services.exceptions.DataIntegrityViolationException;
import com.barbearia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository localidadeRepo;

    public List<LocalidadeDTO> findAll(){
        return localidadeRepo.findAll().stream()
                .map(obj -> new LocalidadeDTO(obj))
                .collect(Collectors.toList());
    }

    public Localidade findById(Integer id){
        Optional<Localidade> obj = localidadeRepo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Cidade Não Encontrado! ID: "+ id));
    }

    public Localidade findByCidade(String cidade){
        Optional<Localidade> obj = localidadeRepo.findByCidade(cidade);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cidade Não Encontrado! CIDADE: "+ cidade));
    }

    public Localidade create (LocalidadeDTO dto){
        dto.setIdLocalidade(null);
        validaLocalidade(dto);
        Localidade obj = new Localidade(dto);
        return localidadeRepo.save(obj);
    }

    private void validaLocalidade(LocalidadeDTO dto){
        Optional<Localidade> obj = localidadeRepo.findByCidade(dto.getCidade());
        if (obj.isPresent() && obj.get().getIdLocalidade() != dto.getIdLocalidade()){
            throw new DataIntegrityViolationException("Cidade já Cadastrada!");
        }
    }

    public Localidade update(Integer id, LocalidadeDTO objDto){
        objDto.setIdLocalidade(id);
        Localidade oldObj = findById(id);
        validaLocalidade(objDto);
        oldObj = new Localidade(objDto);
        return localidadeRepo.save(oldObj);
    }

    public void delete(Integer id){
        Localidade obj = findById(id);
        localidadeRepo.deleteById(id);
    }

}
