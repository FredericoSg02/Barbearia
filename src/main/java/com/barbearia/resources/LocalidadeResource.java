package com.barbearia.resources;


import com.barbearia.domains.Localidade;
import com.barbearia.domains.dtos.LocalidadeDTO;
import com.barbearia.services.LocalidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/localidade")
public class LocalidadeResource {
    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping
    public ResponseEntity<List<LocalidadeDTO>> findAll(){
        return ResponseEntity.ok().body(localidadeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocalidadeDTO> findById(@PathVariable Integer id){
        Localidade obj = this.localidadeService.findById(id);
        return ResponseEntity.ok().body(new LocalidadeDTO(obj));
    }



    @GetMapping(value = "/cidade/{cidade}")
    public ResponseEntity<LocalidadeDTO> findById(@PathVariable String cidade){
        Localidade obj = this.localidadeService.findByCidade(cidade);
        return ResponseEntity.ok().body(new LocalidadeDTO(obj));
    }


    @PostMapping
    public ResponseEntity<LocalidadeDTO> create(@Valid @RequestBody LocalidadeDTO dto){
        Localidade localidade = localidadeService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(localidade.getIdLocalidade()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LocalidadeDTO> update(@PathVariable Integer id, @Valid @RequestBody LocalidadeDTO objDto){
        Localidade Obj = localidadeService.update(id, objDto);
        return ResponseEntity.ok().body(new LocalidadeDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LocalidadeDTO> delete(@PathVariable Integer id){
        localidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
