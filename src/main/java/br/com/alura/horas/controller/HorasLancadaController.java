package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.HoraLancadaDao;
import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class HorasLancadaController {

	private HoraLancadaDao horaLancadaDao;
	private Validator validator;
	private Result result;
	private UsuarioLogado logado;

	@Inject
	public HorasLancadaController(HoraLancadaDao horaLancadaDao, Validator validator, Result result, UsuarioLogado logado) {
		this.horaLancadaDao = horaLancadaDao;
		this.validator = validator;
		this.result = result;
		this.logado = logado;		
	}
	
	public HorasLancadaController(){}
	
	public void form(){}
	
	public void adiciona(@Valid HoraLancada horaLancada){
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(logado.getUsuario());
		horaLancadaDao.adiciona(horaLancada);
		result.redirectTo(this).lista();
	}
	
	public void lista(){
		result.include("horas", horaLancadaDao.lista());
	}
	
	public void relatorioHoras(){
		List<HoraLancada> horas = horaLancadaDao.horasDoUsuario(logado.getUsuario());
		//RelatorioDeHoras relatorio = new RelatorioDeHoras(horas);
		//result.include("relatorio", relatorio);
	}
}
