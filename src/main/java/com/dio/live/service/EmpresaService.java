package com.dio.live.service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getEmpresaById(Long empresaId) {
        return empresaRepository.findById(empresaId);
    }

    public Empresa updateEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresaById(Long empresaId) {
        empresaRepository.deleteById(empresaId);
    }
}
