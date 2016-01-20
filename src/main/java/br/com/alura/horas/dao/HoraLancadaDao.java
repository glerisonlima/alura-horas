package br.com.alura.horas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.modelos.Usuario;

public class HoraLancadaDao {

	private EntityManager em;
	
	@Inject
	public HoraLancadaDao(EntityManager em){
		this.em = em;		
	}
	
	public HoraLancadaDao() {}
	
	
	public void adiciona(HoraLancada horaLancada) {
		this.em.persist(horaLancada);
	}
	
	public List<HoraLancada> lista(){
		TypedQuery<HoraLancada> query = this.em.createQuery("select h1 from HoraLancada h1", HoraLancada.class);
		return query.getResultList();
	}
	
	public List<HoraLancada> horasDoUsuario(Usuario usuario){
		TypedQuery<HoraLancada> query = this.em.createQuery("select h from HoraLancada h where h.usuario = :usuario order by h.data", HoraLancada.class);
		query.setParameter("usuario", usuario);
		return query.getResultList();
	}

}
