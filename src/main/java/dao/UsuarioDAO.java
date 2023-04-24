package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;


public class UsuarioDAO {
	private String dbURL = "jdbc:mysql://localhost/shoeshappy";
	private String dbUser = "root";
	private String dbPassword = "1234";

	private static final String INSERIR_USUARIO = "INSERT INTO usuario" + " (nome, email, pais) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECIONAR_USUARIO = "SELECT codigo, nome, email, pais FROM usuario WHERE codigo = ?";
	private static final String SELECIONAR_USUARIOS = "SELECT * FROM usuario";
	private static final String DELETAR_USUARIO = "DELETE FROM usuario WHERE codigo = ?;";
	private static final String ATUALIZAR_USUARIO = "UPDATE usuario SET nome = ?, email = ? , pais = ? WHERE codigo = ?;";

	public UsuarioDAO() {
	}

	protected Connection getConnection() {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(dbURL, dbUser, dbPassword);
		} catch (SQLException erro) {
			erro.printStackTrace();
		} catch (ClassNotFoundException erro) {
			erro.printStackTrace();
		}
		return conexao;
	}

	public void inserirUsuario(Usuario usuario) throws SQLException {
		try (Connection conexao = getConnection();
				PreparedStatement executarComando = conexao.prepareStatement(INSERIR_USUARIO)) {
			executarComando.setString(1, usuario.getNome());
			executarComando.setString(2, usuario.getEmail());
			executarComando.setString(3, usuario.getPais());
			System.out.println(executarComando);
			executarComando.executeUpdate();
		} catch (SQLException erro) {
			printSQLException(erro);
		}
	}

	public Usuario selecionarUsuario(int codigo) {
		Usuario usuario = null;
		try (Connection conexao = getConnection();
				PreparedStatement executarComando = conexao.prepareStatement(SELECIONAR_USUARIO);) {
			executarComando.setInt(1, codigo);
			System.out.println(executarComando);
			ResultSet resultado = executarComando.executeQuery();
			while (resultado.next()) {
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String pais = resultado.getString("pais");
				usuario = new Usuario(codigo, nome, email, pais);
			}
		} catch (SQLException erro) {
			printSQLException(erro);
		}
		return usuario;
	}

	public List selecionarUsuarios() {
		List usuarios = new ArrayList<>();
		try (Connection conexao = getConnection();
				PreparedStatement executarComando = conexao.prepareStatement(SELECIONAR_USUARIOS);) {
			System.out.println(executarComando);
			ResultSet resultado = executarComando.executeQuery();
			while (resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String pais = resultado.getString("pais");
				usuarios.add(new Usuario(codigo, nome, email, pais));
			}
		} catch (SQLException erro) {
			printSQLException(erro);
		}
		return usuarios;
	}

	public boolean deletarUsuario(int codigo) throws SQLException {
		boolean registroDeletado;
		try (Connection conexao = getConnection();
				PreparedStatement executarComando = conexao.prepareStatement(DELETAR_USUARIO);) {
			executarComando.setInt(1, codigo);
			System.out.println(executarComando);
			registroDeletado = executarComando.executeUpdate() > 0;
		}
		return registroDeletado;
	}

	public boolean atualizarUsuario(Usuario usuario) throws SQLException {
		boolean registroAtualizado;
		try (Connection connection = getConnection();
				PreparedStatement executarComando = connection.prepareStatement(ATUALIZAR_USUARIO);) {
			executarComando.setString(1, usuario.getNome());
			executarComando.setString(2, usuario.getEmail());
			executarComando.setString(3, usuario.getPais());
			executarComando.setInt(4, usuario.getCodigo());
			registroAtualizado = executarComando.executeUpdate() > 0;
		}
		return registroAtualizado;
	}

	private void printSQLException(SQLException erro) {
		for (Throwable e : erro) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("Estado do SQL: " + ((SQLException) e).getSQLState());
				System.err.println("Código de erro: " + ((SQLException) e).getErrorCode());
				System.err.println("Mensagem: " + e.getMessage());
				Throwable causa = erro.getCause();
				while (causa != null) {
					System.out.println("Causa: " + causa);
					causa = causa.getCause();
				}
			}
		}
	}
}