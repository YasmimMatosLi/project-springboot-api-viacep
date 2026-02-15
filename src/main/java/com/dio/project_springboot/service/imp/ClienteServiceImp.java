package com.dio.project_springboot.service.imp;

import com.dio.project_springboot.model.Cliente;
import com.dio.project_springboot.model.Endereco;
import com.dio.project_springboot.repositories.ClienteRepository;
import com.dio.project_springboot.repositories.EnderecoRepository;
import com.dio.project_springboot.service.ClienteService;
import com.dio.project_springboot.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    private void salvarPeloCep(Cliente cliente) {
        //verificar se o endereço do cliente existe viaCep
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //caso não exista integrar com o via cep e persistir o retorno
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        //vincular o cliente com o endereco - novo ou existente
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarPeloCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            salvarPeloCep(cliente);
        }

    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
