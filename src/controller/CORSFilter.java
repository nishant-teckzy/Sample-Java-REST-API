package controller;

import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class CORSFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public ContainerRequest filter(ContainerRequest creq) {
		// TODO Auto-generated method stub
	      creq.getRequestHeaders().add("Access-Control-Allow-Origin", "*");
	      creq.getRequestHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	      creq.getRequestHeaders().add("Access-Control-Allow-Credentials", "true");
	      creq.getRequestHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      creq.getRequestHeaders().add("Access-Control-Max-Age", "1209600");
		return creq;
	}

	@Override
	public ContainerResponse filter(ContainerRequest creq, ContainerResponse cres) {
		// TODO Auto-generated method stub
		cres.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
	      cres.getHttpHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	      cres.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
	      cres.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      cres.getHttpHeaders().add("Access-Control-Max-Age", "1209600");
		return cres;
	}

	

}
