package petshopServet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import petshopServlet.entities.Tutor;
import petshopServlet.repositories.TutorRepository;

@WebServlet(value="/tutor")
public class TutorServlet extends HttpServlet {
	
	private final TutorRepository tutorRepository = new TutorRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		var tutores = tutorRepository.listarTutores();
		
		if (tutores.isEmpty()) {
			writer.print("Nenhum tutor cadastrado.");
	    } else {
	    	for (Tutor tutor : tutores) {
	    		writer.print("Id: " + tutor.getId() + ". " +
		    				"Nome: " + tutor.getNome() + ". " +
		    				"Pets: " + tutor.getPets() + "."
		    	);	
		    }	
	    }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		Tutor novoTutor = new Tutor();
		novoTutor.setNome(req.getParameter("nome"));
		novoTutor.setEmail(req.getParameter("e-mail"));
		tutorRepository.adicionarTutor(novoTutor);
		
		writer.print("Tutor adicionade com sucesso: " + novoTutor);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		var tutorAtualizar = tutorRepository.buscar(Integer.parseInt(req.getParameter("id")));
	    
		if (tutorAtualizar != null) {
	    	tutorAtualizar.setNome(req.getParameter("nome"));
	    	tutorAtualizar.setEmail(req.getParameter("e-mail"));
	    	writer.print("Informações atualizadas com sucesso. " + tutorAtualizar);
	    } else {
	    	writer.print("Tutor não encontrado.");
	    }
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		var tutorRemover = tutorRepository.buscar(Integer.parseInt(req.getParameter("id")));
		
		if (tutorRemover != null) {
			tutorRepository.removerTutor(tutorRemover);
			writer.print("Tutor excluído com sucesso.");
	    } else { 
	    	writer.print("Nenhum tutor encontrado.");
	    }
	}

}
