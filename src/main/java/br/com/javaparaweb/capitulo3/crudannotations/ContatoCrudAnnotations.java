package br.com.javaparaweb.capitulo3.crudannotations;
import java.sql.Date;
import java.util.List;
import org.hibernate.*;
import br.com.javaparaweb.capitulo3.conexao.HibernateUtil;

public class ContatoCrudAnnotations {
  private Session session;
  
  public ContatoCrudAnnotations(Session session) {
	  this.session = session;
  }
  
  public void salvar(Contato contato) {
	  session.save(contato);
  }
  
  public void atualizar(Contato contato) {
	  session.update(contato);
  }
  
  public void excluir(Contato contato) {
	  session.delete(contato);
  }
  
  public List<Contato> listar(){
//	  this query is about the object Contato, not about the table contato.
	  Query query = session.createQuery("from Contato");
//	  running the query and returning the list of Objects Contato
	  return query.list();
  }
  
//  the same that getContact
  public Contato buscaContato(int valor) {
	  Query query = session.createQuery("from Contato where codigo =:parametro");
	  query.setInteger("parametro", valor);
//	  only return one value
	  return (Contato) query.uniqueResult();
  }
  

 public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    ContatoCrudAnnotations contatoCrud = new ContatoCrudAnnotations(session);
//    lets add a new contact
    Contato contato1 = new Contato();
    contato1.setNome("Ronalinho gaucho");
    contato1.setTelefone("(99) 3333-4444");
    contato1.setEmail("rnaldo.gaucho@javaparaweb.com.br");
    contato1.setDataCadastro(new Date(System.currentTimeMillis()));
    contato1.setObservacao("Novo cliente");
//    save it
    contatoCrud.salvar(contato1);
    
    contato1.setObservacao("Uma questao de update");
    contatoCrud.atualizar(contato1);
//    one more
    Contato contato2 = new Contato();
    contato2.setNome("Ronalinho gaucho");
    contato2.setTelefone("(99) 3333-4444");
    contato2.setEmail("rnaldo.gaucho@javaparaweb.com.br");
    contato2.setDataCadastro(new Date(System.currentTimeMillis()));
    contato2.setObservacao("Novo cliente");
//    save it
    contatoCrud.salvar(contato2);
//    show the account of registers :
    System.out.println("Total de registros cadastrados : " + contatoCrud.listar().size());
//    and now delete the item contato2 
    contatoCrud.excluir(contato2);
//    confirm the operations to database
    transaction.commit();
//    and now we show the account of registers again
    System.out.println("Total de registros cadastrados : " + contatoCrud.listar().size());
    
 }

  
}
