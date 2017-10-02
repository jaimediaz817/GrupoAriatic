package co.ariatic.Portafolio;

import angularBeans.api.AngularBean;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;

@AngularBean
public class HelloAngularBeans {

	@Get
	@NGReturn(model = "message")
	public String sayHello(String name) {

		return "Hola " + name + " bienvenido a Portafolio !";

	}

}
