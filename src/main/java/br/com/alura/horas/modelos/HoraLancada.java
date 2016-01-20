package br.com.alura.horas.modelos;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HoraLancada {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private String HoraInicial;
	
	private String HoraFinal;
	
	@ManyToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getHoraInicial() {
		return HoraInicial;
	}

	public void setHoraInicial(String horaInicial) {
		HoraInicial = horaInicial;
	}

	public String getHoraFinal() {
		return HoraFinal;
	}

	public void setHoraFinal(String horaFinal) {
		HoraFinal = horaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
