package br.com.alura.horas.seguranca;

import javax.inject.Inject;

import br.com.alura.horas.controller.LoginController;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutorizacaoInterceptor {

	private Result result;
	private UsuarioLogado usuarioLogado;
	private ControllerMethod method;
	
	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result,
			ControllerMethod method) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
		
	}
	public AutorizacaoInterceptor() {}

	@Accepts
	public boolean accept(){
		return !method.containsAnnotation(Open.class);
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack){
		if (usuarioLogado.isLogado()){
			stack.next();
		}else{
			result.redirectTo(LoginController.class).form();
		}
	}
}
