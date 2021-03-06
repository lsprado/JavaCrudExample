package br.com.leandroprado.examplecrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.leandroprado.examplecrud.entidade.Student;
import br.com.leandroprado.examplecrud.jdbc.ConexaoFactory;

public class StudentDAO {

	private Connection conn = ConexaoFactory.getConnection();
	
	public void salvar(Student usuario) {

		if (usuario.getId() > 0) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}
	
	public void cadastrar(Student u) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tbl_student (LastName, FirstMidName, EnrollmentDate) VALUES (?, ?, ?)";
		
		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			java.sql.Date sqlDate = new java.sql.Date(u.getEnrollmateDate().getTime());
			
			preparador.setString(1, u.getLastName()); 
			preparador.setString(2, u.getFirstName());
			preparador.setDate(3, sqlDate);

			// Executando o comando SQL no banco
			preparador.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Student u) {
		// TODO Auto-generated method stub
		String sql = "UPDATE [tbl_student] SET [LastName] = ? , [FirstMidName] = ? , [EnrollmentDate] = ? WHERE ID = ?";
		
		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			java.sql.Date sqlDate = new java.sql.Date(u.getEnrollmateDate().getTime());
			
			preparador.setString(1, u.getLastName()); 
			preparador.setString(2, u.getFirstName());
			preparador.setDate(3, sqlDate);
			preparador.setInt(4, u.getId());

			// Executando o comando SQL no banco
			preparador.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Student u) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM [tbl_student] WHERE ID = ?";
		
		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			preparador.setInt(1, u.getId());

			// Executando o comando SQL no banco
			preparador.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student buscarPorId(Integer id) {

		String sql = "SELECT * FROM tbl_student WHERE ID = ?";

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			// Posicionando o cursor no primeiro registro
			if (resultado.next()) {

				Student usuario = new Student();
				usuario.setId(resultado.getInt("ID"));
				usuario.setLastName(resultado.getString("LastName"));
				usuario.setFirstName(resultado.getString("FirstMidName"));
				usuario.setEnrollmateDate(resultado.getDate("EnrollmentDate"));
				return usuario;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Student> buscarTodos() {

		String sql = "SELECT * FROM tbl_student ORDER BY Id";
		List<Student> listaUsuario = new ArrayList<Student>();

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();

			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {

				Student usuario = new Student();
				usuario.setId(resultado.getInt("ID"));
				usuario.setLastName(resultado.getString("LastName"));
				usuario.setFirstName(resultado.getString("FirstMidName"));
				usuario.setEnrollmateDate(resultado.getDate("EnrollmentDate"));
				listaUsuario.add(usuario);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaUsuario;
	}
}
