package br.com.leandroprado.examplecrud;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.leandroprado.examplecrud.dao.UsuarioDAO;
import br.com.leandroprado.examplecrud.entidade.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "INICIO" );
        
        Usuario u = new Usuario();
        u.setId(1);
        u.setLastName("lastName");
        u.setFirstName("firstName");
        u.setEnrollmateDate(new Date());
        
        UsuarioDAO uDAO = new UsuarioDAO();
        uDAO.cadastrar(u);
        
        Usuario res = uDAO.buscarPorId(2);
        System.out.println(res.getId() + " - " + res.getEnrollmateDate());
        
        List<Usuario> lista = uDAO.buscarTodos();
        
        for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			System.out.println(usuario.getId() + " - " + usuario.getEnrollmateDate());
		}
        System.out.println( "FIM" );
    }
}
