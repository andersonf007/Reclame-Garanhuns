package hibernate;





import dao.UsuariosDao;
import entidade.PublicacaoEntidade;
import entidade.UsuarioEntidade;
//import java.time.Instant;
//import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TesteConexaoBD {
    
    static EntityManager manager;
    
     public static void main(String[] horaDoShow){
        
    
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
    
        UsuariosDao u2 = new UsuariosDao();
        UsuarioEntidade u = new UsuarioEntidade();
        
        PublicacaoEntidade pb = new PublicacaoEntidade();

        
        //Ao inserir, altere os valores para não ficar com valores repetidos  no BD! 
        

        
        ///////////////////////////
        //if(u.getId() == 1){
        u.setId(151);
        u.setNome("izafhgfhquias");
        u.setEmail("izqgfduias@gmail.com");
        u.setSenha("city2017");
        u.setCategoria("energia");
        u.setTipo("Orgão");
        //u.setId(52);
     
       ///////////////////////////
//        pb.setCategoria("Serviços Públicos");
//        pb.setDescricao("Falta de Iluminção pública.");
//        pb.setLocalidade("Rua Correntes");
//        //Date hoje = Date.from(Instant.now());
//        //pb.setData(hoje);
//        pb.getUsuario().add(u);
        //////////////////////
        
    
        
        manager.getTransaction().begin();
        
        u2.alterar(u);
        //u2.inserir(u);
        //manager.persist(u);
        
        //manager.persist(pb);
        
        manager.getTransaction().commit();
        manager.close();
    }
}
