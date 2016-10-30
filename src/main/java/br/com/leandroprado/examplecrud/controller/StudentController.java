package br.com.leandroprado.examplecrud.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leandroprado.examplecrud.dao.StudentDAO;
import br.com.leandroprado.examplecrud.entidade.Student;

@WebServlet("/StudentController.do")
public class StudentController extends HttpServlet {

	public StudentController(){
		System.out.println("StudentController..");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet...");
		
		resp.setContentType("text/html");

		String acao = req.getParameter("acao");
		
		if(acao != null)
		{
			System.out.println("acao: " + acao);
			
			if (acao.equals("excluir")) {
				
				String id = req.getParameter("id");
	
				if(id != null)
				{
					Student s = new Student();
					s.setId(Integer.parseInt(id));
	
					StudentDAO sDAO = new StudentDAO();
					sDAO.deletar(s);
	
					resp.sendRedirect("StudentController.do?acao=listar");
				}
	
			} else if (acao.equals("listar")) {
				
				StudentDAO sDAO = new StudentDAO();
	
				List<Student> lista = sDAO.buscarTodos();
				req.setAttribute("listStudent", lista);
	
				RequestDispatcher dispatcher = req.getRequestDispatcher("listStudent.jsp");
	
				dispatcher.forward(req, resp);
	
			}else if(acao.equals("alterar")){
	
				String id = req.getParameter("id");
	
				StudentDAO sDAO = new StudentDAO();
	
				Student s = sDAO.buscarPorId(Integer.parseInt(id));
	
				req.setAttribute("student", s);
	
				RequestDispatcher dispatcher = req.getRequestDispatcher("alterStudent.jsp")	;
	
				dispatcher.forward(req, resp);
	
			}
		}
		else
		{
			StudentDAO sDAO = new StudentDAO();
			
			List<Student> lista = sDAO.buscarTodos();
			req.setAttribute("lista", lista);

			RequestDispatcher dispatcher = req.getRequestDispatcher("listStudent.jsp");

			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost...");
		
		String id = req.getParameter("Id");
		String lastName = req.getParameter("LastName");
		String firstName = req.getParameter("FirstName");
		String enrollmentDate = req.getParameter("EnrollmentDate");

		Student s = new Student();

		if (id != null)
			s.setId(Integer.parseInt(id));

		s.setLastName(lastName);
		s.setFirstName(firstName);
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(enrollmentDate);
			s.setEnrollmateDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StudentDAO sDAO = new StudentDAO();
		sDAO.salvar(s);

		System.out.println("Castrado...");
		
		resp.getWriter().print("<h1>sucesso!</h1><a href='StudentController.do?acao=listar'>Voltar</a>");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy..");
		super.destroy();
	}

}
