package com.barbearia.resources;

import com.barbearia.domains.Barbeiro;
import com.barbearia.domains.dtos.BarbeiroDTO;
import com.barbearia.services.BarbeiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/barbeiro")
public class BarbeiroResource {

    @Autowired
    private BarbeiroService barbeiroService;

    @GetMapping // exemplo http://localhost:8080/barbeiro
    public ResponseEntity<List<BarbeiroDTO>> findAll(){
        return ResponseEntity.ok().body(barbeiroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BarbeiroDTO> findById(@PathVariable Integer id){
        Barbeiro obj = this.barbeiroService.findById(id);
        return ResponseEntity.ok().body(new BarbeiroDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<BarbeiroDTO> findById(@PathVariable String cpf){
        Barbeiro obj = this.barbeiroService.findByCpf(cpf);
        return ResponseEntity.ok().body(new BarbeiroDTO(obj));
    }


    @PostMapping
    public ResponseEntity<BarbeiroDTO> create(@Valid @RequestBody BarbeiroDTO dto){
        Barbeiro barbeiro = barbeiroService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(barbeiro.getIdBarbeiro()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BarbeiroDTO> update(@PathVariable Integer id, @Valid @RequestBody BarbeiroDTO objDto){
        Barbeiro Obj = barbeiroService.update(id, objDto);
        return ResponseEntity.ok().body(new BarbeiroDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BarbeiroDTO> delete(@PathVariable Integer id){
        barbeiroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
