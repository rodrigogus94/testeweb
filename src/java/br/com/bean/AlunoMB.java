/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.aluno.Aluno;
import br.com.dao.CadastroDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Rodri
 */

@ManagedBean
public class AlunoMB {
    
    private Aluno aluno;
    private List<Aluno> lista;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getLista() {
        return lista;
    }

    public void setLista(List<Aluno> lista) {
        this.lista = lista;
    }
    
    
    public void salvar(){
        CadastroDAO dao = new CadastroDAO();
        dao.salvar(aluno);
    
        inicializar();
    }
    @PostConstruct
    public void inicializar(){
        CadastroDAO dao = new CadastroDAO();
        lista = dao.listar();
        
        aluno = new Aluno();
    }
    
    
}
