package com.barbearia.resources;


import com.barbearia.domains.Servico;
import com.barbearia.domains.dtos.ServicoDTO;
import com.barbearia.services.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/servico")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> findAll(){
        return ResponseEntity.ok().body(servicoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> findById(@PathVariable Integer id){
        Servico obj = this.servicoService.findById(id);
        return ResponseEntity.ok().body(new ServicoDTO(obj));
    }


    @GetMapping(value = "/idAgendamento/{idAgendamento}")
    public ResponseEntity<ServicoDTO> findByAgendamento(@PathVariable Integer idAgendamento){
        Servico obj = this.servicoService.findByAgendamento(idAgendamento);
        return ResponseEntity.ok().body(new ServicoDTO(obj));
    }


    @PostMapping
    public ResponseEntity<ServicoDTO> create(@Valid @RequestBody ServicoDTO dto){
        Servico servico = servicoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(servico.getIdServico()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> update(@PathVariable Integer id, @Valid @RequestBody ServicoDTO objDto){
        Servico Obj = servicoService.update(id, objDto);
        return ResponseEntity.ok().body(new ServicoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> delete(@PathVariable Integer id){
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
