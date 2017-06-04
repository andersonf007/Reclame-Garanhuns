
import controller.Controller;
import dao.ComentarioDao;
import entidade.ComentarioEntidade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Izaquias
 */
@ViewScoped

@ManagedBean
public class ComentarioBean implements Controller{

   private ComentarioEntidade comentario;
   private ComentarioDao dao;

   @PostConstruct
   public void iniciar(){
       comentario = new ComentarioEntidade();
       dao = new ComentarioDao();
   }

   public ComentarioBean() {
   
   }
    
   
    @Override
    public String salvar() {
        dao.inserir(comentario);
     return "";
    }

    @Override
    public String atualizar() {
        dao.alterar(comentario);
        return "";
    }

    @Override
    public String deletar() {
        dao.remover(comentario);
        return "";
    }

    @Override
    public ComentarioEntidade buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List listarTodos() {
        return dao.recuperarTodos();
    }

    public ComentarioEntidade getComentario() {
        return comentario;
    }

    public void setComentario(ComentarioEntidade comentario) {
        this.comentario = comentario;
    }

    public ComentarioDao getDao() {
        return dao;
    }

    public void setDao(ComentarioDao dao) {
        this.dao = dao;
    }
    
}
