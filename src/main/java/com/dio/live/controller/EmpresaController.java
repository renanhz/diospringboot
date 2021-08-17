package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.createEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaService.getAll();
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("empresaId") Long empresaId) throws Exception{
        return ResponseEntity.ok(
                empresaService.getEmpresaById(empresaId).orElseThrow(
                        () -> new NoSuchElementException("Empresa Not Found")
                ));
    }

    @PutMapping
    public Empresa updateEmpresa(Empresa empresa) {
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{empresaId}")
    public ResponseEntity deleteEmpresaById(@PathVariable("empresaId") Long empresaId) {
        try {
            empresaService.deleteEmpresaById(empresaId);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Empresa>) ResponseEntity.ok();
    }

}
