package br.com.caelum.interfaces;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Logica {
	abstract String execute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException;
}
