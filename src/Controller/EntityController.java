package Controller;

import Model.Categoria;
import Model.Hecho;
import Model.Lista;
import Model.Predicado;
import Model.Regla;
import Model.Sujeto;
import Model.Variablep;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public abstract class EntityController {
    // http://www.objectdb.com/java/jpa/getting/started

    public static final String PU = "prologPU";
    private static EntityManagerFactory entityManagerFactory;
    Properties props;

    public EntityManager getEntityManager() {
        try {
            return this.getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Revise los párametros de conexión a la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private EntityManagerFactory getEntityManagerFactory() {
        conf();
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PU, props);
        }
        return entityManagerFactory;
    }

    //----------------------------------------------------------------------------------------------
    public EntityManager getEntityManager2() throws Exception {
        try {
            this.getEntityManagerFactory2().close();
            return this.getEntityManagerFactory2().createEntityManager();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Revise los párametros de conexión a la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private EntityManagerFactory getEntityManagerFactory2() {
        conf();
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, props);
        return entityManagerFactory;
    }

    //----------------------------------------------------------------------------------------------
    protected List executeNamedQuery(String queryName, EntityManager em) {
        javax.persistence.Query query = em.createNamedQuery(queryName);
        List resultList = query.getResultList();
        return resultList;
    }

    protected List executeNamedQuery(String queryName) {
        EntityManager em = this.getEntityManager();
        List resultList = this.executeNamedQuery(queryName, em);
        em.close();
        return resultList;
    }

    protected void executeNamedQuery2(String queryName, EntityManager em) {
        javax.persistence.Query query = em.createNamedQuery(queryName);
        query.getSingleResult();
    }

    protected void executeNamedQuery2(String queryName) {
        EntityManager em = this.getEntityManager();
        this.executeNamedQuery2(queryName, em);
        em.close();
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

    protected void remove(Object entity) throws Exception {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.remove(entity); // delete entity
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void update(Object entity) throws Exception {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }

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

    protected void removeCategoria(Categoria entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Categoria entityx = em.find(Categoria.class, entity.getId());
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

    protected void removeLista(Lista entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Lista entityx = em.find(Lista.class, entity.getId());
            em.remove(entityx);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
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
    
    protected void borrarAllHechoExterno() {

        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("DELETE FROM Hecho h where h.externo = 1");
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

    protected void afectarPredicado(int idPredicado) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Predicado entityx = em.find(Predicado.class, idPredicado);
            entityx.setAfectado(1);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void desafectarPredicado(int idPredicado) throws Exception {
        System.out.println("id en desafectarPredicado: " + idPredicado);
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Predicado entityx = em.find(Predicado.class, idPredicado);
            entityx.setAfectado(0);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void desafectarPredicado(String predicadoPro) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Predicado p = new Predicado();
            Query q = (Query) em.createQuery("SELECT p FROM Predicado p WHERE p.pro LIKE ?1");
            q.setParameter(1, predicadoPro);
            p = (Predicado) q.getSingleResult();
            p = em.find(Predicado.class, p.getId());
            p.setAfectado(0);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void conf() {

        String url, user, base, password, driver, hibercacheprovider, hiberstrategygen;
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("conf.ini"));
            url = p.getProperty("Ruta");
            user = p.getProperty("Usuario");
            password = p.getProperty("Password");
            base = p.getProperty("Base");
            driver = p.getProperty("Driver");
            hibercacheprovider = p.getProperty("hibernate.cache.provider_class");
            hiberstrategygen = p.getProperty("hibernate.hbm2ddl.auto");

            //System.out.println(url + base + " - " + user + " - " + password + " - " + driver + " - " + hibercacheprovider + " - " + hiberstrategygen);
            props = new Properties();
            props.put("hibernate.connection.username", user);
            props.put("hibernate.connection.driver_class", driver);
            props.put("hibernate.connection.password", password);
            props.put("hibernate.connection.url", url + base);
            props.put("hibernate.cache.provider_class", hibercacheprovider);
            props.put("hibernate.hbm2ddl.auto", hiberstrategygen);

        } catch (Exception e) {
            System.out.println("Error EntityController: " + e);
        }
    }
}
