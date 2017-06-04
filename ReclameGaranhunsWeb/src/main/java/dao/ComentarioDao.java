package dao;


import entidade.ComentarioEntidade;
import hibernate.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;

 


/**
 *
 * @author Izaquias
 */


public class ComentarioDao implements DaoGenerico<ComentarioEntidade>{
    private static EntityManager manager;

    public ComentarioDao() {
    }
    
    
    
    @Override
    public void inserir(ComentarioEntidade c) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        ComentarioDao.manager.getTransaction().begin();
        try {
            ComentarioDao.manager.persist(c);
            ComentarioDao.manager.getTransaction().commit();
            System.out.println("Comentário salvo com sucesso!");
        } catch (Exception e) {
            ComentarioDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer esta operação!");
        }
    }

    @Override
    public void alterar(ComentarioEntidade c) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        ComentarioDao.manager.getTransaction().begin();
        try {
            c = ComentarioDao.manager.find(ComentarioEntidade.class, c.getId());
            ComentarioDao.manager.merge(c);
            ComentarioDao.manager.getTransaction().commit();
            System.out.println("comentário alterado com sucesso!!");
        } catch (Exception e) {
            ComentarioDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer está operação!!");

        } finally {
            ComentarioDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

    }

    @Override
    public void remover(ComentarioEntidade c) {
    
    manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        ComentarioDao.manager.getTransaction().begin();
        try {
            c = ComentarioDao.manager.find(ComentarioEntidade.class, c.getId());
            ComentarioDao.manager.remove(c);
            ComentarioDao.manager.getTransaction().commit();
            System.out.println("Registro removido com sucesso!");
        } catch (Exception e) {
            ComentarioDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover este registro!");
        } finally {
            ComentarioDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public ComentarioEntidade recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        ComentarioDao.manager.getTransaction().begin();

        try {
            return (ComentarioEntidade) ComentarioDao.manager.find(ComentarioEntidade.class, id);
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
        } finally {
            ComentarioDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        return null;
    }

    @Override
    public List<ComentarioEntidade> recuperarTodos() {
           manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) ComentarioDao.manager.createQuery("select c from ComentarioEntidade c", ComentarioEntidade.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            ComentarioDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }
}  
    

