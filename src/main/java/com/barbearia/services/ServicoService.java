package com.barbearia.services;

import com.barbearia.domains.Barbeiro;
import com.barbearia.domains.Cliente;
import com.barbearia.domains.Localidade;
import com.barbearia.domains.Servico;
import com.barbearia.domains.dtos.ServicoDTO;
import com.barbearia.repositories.BarbeiroRepository;
import com.barbearia.repositories.ClienteRepository;
import com.barbearia.repositories.LocalidadeRepository;
import com.barbearia.repositories.ServicoRepository;
import com.barbearia.services.exceptions.DataIntegrityViolationException;
import com.barbearia.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepo;

    @Autowired
    private BarbeiroRepository barbeiroRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private LocalidadeRepository localidadeRepo;



    public List<ServicoDTO> findAll(){
        return servicoRepo.findAll().stream()
                .map(obj -> new ServicoDTO(obj))
                .collect(Collectors.toList());
    }

    public Servico findById(Integer id){
        Optional<Servico> obj = servicoRepo.findById(id);
        return obj.orElse(null);
    }

    public Servico findByAgendamento(Integer idAgendamento){
        Optional<Servico> obj = servicoRepo.findByAgendamento(idAgendamento);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Agendamento Não Encontrado! AGENDAMENTO: "+ idAgendamento));
    }

    public Servico create (ServicoDTO dto){
        dto.setIdServico(null);
        validaServico(dto);
        Servico obj = new Servico(dto);
        return servicoRepo.save(obj);
    }

    private void validaServico(ServicoDTO dto){
        Optional<Servico> obj = servicoRepo.findByAgendamento(dto.getAgendamento());
        if (obj.isPresent() && obj.get().getIdServico() != dto.getIdServico()){
            throw new DataIntegrityViolationException("Agendamento já Cadastrado!");
        }

        Optional<Barbeiro> barbeiro = barbeiroRepo.findById(dto.getBarbeiro());
        if(!barbeiro.isPresent()){
            throw new DataIntegrityViolationException("Barbeiro - " + dto.getBarbeiro());
        }

        Optional<Cliente> cliente = clienteRepo.findById(dto.getCliente());
        if(!cliente.isPresent()){
            throw new DataIntegrityViolationException("Cliente - "+ dto.getCliente());
        }

        Optional<Localidade> localidade = localidadeRepo.findById(dto.getLocalidade());
        if(!cliente.isPresent()){
            throw new DataIntegrityViolationException("Lcaolidade - " + dto.getLocalidade());
        }
    }

    public Servico update(Integer id, ServicoDTO objDto){
        objDto.setIdServico(id);
        Servico oldObj = findById(id);
        validaServico(objDto);
        oldObj = new Servico(objDto);
        return servicoRepo.save(oldObj);
    }

    public void delete(Integer id){
        Servico obj = findById(id);
        servicoRepo.deleteById(id);
    }

}
