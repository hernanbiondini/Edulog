package Controller;

import Model.Regla;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ReglaController extends EntityController {

    private static final String QUERY_GET_ALL_REGLA = "regla.all";
    private static final String QUERY_GET_ALL_REGLA2 = "regla2.all";
    private static final String QUERY_GET_ALL_REGLAPRO = "reglaPro.all";

    private static ReglaController reglaController;

    ReglaController() {
    }

    public static ReglaController getInstance() {
        if (reglaController == null) {
            reglaController = new ReglaController();
        }
        return reglaController;
    }

    public void guardar(Regla p) throws Exception {
        this.persist(p);
    }

    public void borrar(Regla p) throws Exception {
        this.removerRegla(p);
    }

    public List<Regla> getAllRegla() {
        return this.executeNamedQuery(QUERY_GET_ALL_REGLA);
    }

    public List<Regla> getAllRegla2() {
        return this.executeNamedQuery(QUERY_GET_ALL_REGLA2);
    }

    public List<Regla> getAllReglaPro() {
        return this.executeNamedQuery(QUERY_GET_ALL_REGLAPRO);
    }

    public List<Regla> getReglasManuales() {
        EntityManager em = this.getEntityManager();
        Query q = (Query) em.createQuery("SELECT c FROM Regla c WHERE c.nat = 'M'");
        List<Regla> al = q.getResultList();
        return al;
    }

    public void deletetAllRegla() {
        this.borrarAllRegla();
    }

    public Regla buscarRegla(Regla entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            Regla entityx = em.find(Regla.class, entity.getId());
            return entityx;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
