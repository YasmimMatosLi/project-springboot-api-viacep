package com.dio.project_springboot.repositories;

import com.dio.project_springboot.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
