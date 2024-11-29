package com.barbearia.services;

import com.barbearia.domains.Barbeiro;
import com.barbearia.domains.Cliente;
import com.barbearia.domains.Localidade;
import com.barbearia.domains.Servico;
import com.barbearia.domains.enums.Avaliacao;
import com.barbearia.domains.enums.Status;
import com.barbearia.repositories.BarbeiroRepository;
import com.barbearia.repositories.ClienteRepository;
import com.barbearia.repositories.LocalidadeRepository;
import com.barbearia.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DBService {
    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private BarbeiroRepository barbeiroRepo;

    @Autowired
    private LocalidadeRepository localidadeRepo;

    @Autowired
    private ServicoRepository servicoRepo;

    public void initDB(){
        Barbeiro barbeiro01 = new Barbeiro(null,"Mineiro du Corte","Fade","B001");
        Barbeiro barbeiro02 = new Barbeiro(null,"Paulista du Corte","Degrade","B002");

        barbeiroRepo.save(barbeiro01);
        barbeiroRepo.save(barbeiro02);

        Cliente cliente01 = new Cliente(null,"Lucas","11-11111-1111","lucas@gmail.com","111.111.111-11");
        Cliente cliente02 = new Cliente(null,"José","22-22222-2222","jose@gmail.com","222.222.222-22");
        Cliente cliente03 = new Cliente(null,"Emerson","33-33333-3333","emerson@gmail.com","333.333.333-33");
        Cliente cliente04 = new Cliente(null,"João","44-44444-4444","joao@gmail.com","444.444.444-44");

        clienteRepo.save(cliente01);
        clienteRepo.save(cliente02);
        clienteRepo.save(cliente03);
        clienteRepo.save(cliente04);

        Localidade localidade01 = new Localidade(null,"Local do Fade", "Rua do Fade","Fadecity");
        Localidade localidade02 = new Localidade(null,"Local da Régua", "Rua do Régua","Réguacity");

        localidadeRepo.save(localidade01);
        localidadeRepo.save(localidade02);

        Servico servico01 = new Servico(null,1000," - Corte Fade - " ,40, LocalDateTime.of(2024,11,18,14,0),barbeiro01,cliente01,localidade01, Status.DISPONIVEL, Avaliacao.BOM);
        Servico servico02 = new Servico(null,2000,"- Corte Fade - " ,40, LocalDateTime.of(2024,11,18,15,0),barbeiro01,cliente02,localidade01, Status.DISPONIVEL, Avaliacao.OTIMO);
        Servico servico03 = new Servico(null,3000, "- Corte Degrade - ",40, LocalDateTime.of(2024,11,18,16,0),barbeiro01,cliente03,localidade02, Status.DISPONIVEL, Avaliacao.RUIM);
        Servico servico04 = new Servico(null,4000, "- Corte Degrade - ",40, LocalDateTime.of(2024,11,18,17,0),barbeiro01,cliente04,localidade02, Status.DISPONIVEL, Avaliacao.PESSIMO);

        servicoRepo.save(servico01);
        servicoRepo.save(servico02);
        servicoRepo.save(servico03);
        servicoRepo.save(servico04);

    }

}