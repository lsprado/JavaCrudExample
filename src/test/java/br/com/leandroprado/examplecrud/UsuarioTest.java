package br.com.leandroprado.examplecrud;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.leandroprado.examplecrud.dao.StudentDAO;
import br.com.leandroprado.examplecrud.entidade.Student;

public class UsuarioTest {

	public static void main( String[] args )
    {
        System.out.println( "INICIO" );
        
        Student u = new Student();
        u.setId(1);
        u.setLastName("lastName");
        u.setFirstName("firstName");
        u.setEnrollmateDate(new Date());
        
        StudentDAO uDAO = new StudentDAO();
        uDAO.cadastrar(u);
        
        Student res = uDAO.buscarPorId(2);
        System.out.println(res.getId() + " - " + res.getEnrollmateDate());
        
        List<Student> lista = uDAO.buscarTodos();
        
        for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Student usuario = (Student) iterator.next();
			System.out.println(usuario.getId() + " - " + usuario.getEnrollmateDate());
		}
        System.out.println( "FIM" );
    }

}
