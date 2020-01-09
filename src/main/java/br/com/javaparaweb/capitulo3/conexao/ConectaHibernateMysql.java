package br.com.javaparaweb.capitulo3.conexao;
//import br.com.javaparaweb.capitulo3.conexao.*;
import org.hibernate.Session;

public class ConectaHibernateMysql {

	public static void main(String[] args) {
		Session sessao = null;
		sessao = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Conected  !!");
		sessao.close();
	}
}
