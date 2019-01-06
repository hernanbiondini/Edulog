package ControllerXML;

import Model.Hecho;
import Model.Predicado;
import Model.Regla;
import Model.Sujeto;
import Model.Variablep;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public abstract class EntityControllerXML {

    public static final String PU = "prologPU";
    private static EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        return this.getEntityManagerFactory().createEntityManager();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PU);
        }
        return entityManagerFactory;
    }

    protected void persist(Object entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        entity = em.merge(entity);
        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }

    }

    protected void persist(Object entity, EntityManager em) {
        em.persist(entity);
    }

    protected void removeSujeto(Sujeto entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Sujeto entityx = em.find(Sujeto.class, entity.getId());
            em.remove(entityx);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void removePredicado(Predicado entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Predicado entityx = em.find(Predicado.class, entity.getId());
            em.remove(entityx);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void removeVariablep(Variablep entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Variablep entityx = em.find(Variablep.class, entity.getId());
            em.remove(entityx);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void removerRegla(Regla entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Regla entityx = em.find(Regla.class, entity.getId());
            em.remove(entityx);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    protected List executeNamedQuery(String queryName) {
        EntityManager em = this.getEntityManager();
        List resultList = this.executeNamedQuery(queryName, em);
        em.close();
        return resultList;
    }

    protected void executeNamedQuery2(String queryName) {
        EntityManager em = this.getEntityManager();
//        List resultList = this.executeNamedQuery2(queryName, em);
        this.executeNamedQuery2(queryName, em);
        em.close();
    }

    protected void removeHecho(Hecho entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Hecho entityx = em.find(Hecho.class, entity.getId());
            em.remove(entityx);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected List executeNamedQuery(String queryName, EntityManager em) {
        javax.persistence.Query query = em.createNamedQuery(queryName);
        List resultList = query.getResultList();
        return resultList;
    }

    protected void executeNamedQuery2(String queryName, EntityManager em) {
        javax.persistence.Query query = em.createNamedQuery(queryName);
//        List resultList = query.getResultList();
        query.getSingleResult();
    }

    protected void borrarAllHecho() {

        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("DELETE FROM Hecho h");
            int deleteRecors = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }
    
     protected void borrarAllRegla() {

        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("DELETE FROM Regla h");
            int deleteRecors = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }
}
