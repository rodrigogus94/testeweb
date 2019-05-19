/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.aluno.Aluno;
import br.com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Rodri
 */
public class CadastroDAO {
    
    public void salvar(Aluno aluno){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.persist(aluno);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Aluno> listar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Aluno> lista = session.getNamedQuery("Aluno.findAll").list();
        session.close();
        return lista;
    }
}
