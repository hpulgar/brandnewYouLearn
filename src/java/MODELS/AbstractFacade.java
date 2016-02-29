/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Felipe
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().merge(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    ////////////////////////////////////
    
//    public List <Usuario> cargaPerfileUser(int id)
//     {
//         EntityManager em2 = getEntityManager();
//         Query q = em2.createNamedQuery("Usuario.findByIdUsuario").setParameter("idUsuario", id);
//         return q.getResultList();
//         
//     }
//    public List<InscripcionCurso> sCursos()
//    {
//        EntityManager em2= getEntityManager();
//        Query q= em2.createNamedQuery("InscripcionCurso.findAll");
//        return q.getResultList();
//    }
//    
//    public List<Amigos> verAmigos()
//    {
//        EntityManager em2= getEntityManager();
//        Query q= em2.createNamedQuery("Amigos.findAll");
//        return q.getResultList();
//    }
//    
//     public void borrarMenu(Menu m)//metodo arreglado parar crear los destroy
//    {
//        EntityManager em2= getEntityManager();
//        Menu  b = em2.getReference(Menu.class, m.getIdMenu());
//               
//        em2.remove(b);
//    }
//    
//    public void borrarCiudad(Ciudad c)//metodo arreglado parar crear los destroy
//    {
//        EntityManager em2= getEntityManager();
//        Ciudad  b = em2.getReference(Ciudad.class, c.getIdCiudad());
//               
//        em2.remove(b);
//    }
//    
//    public void borrarArchivo(Archivo e)
//    {
//        EntityManager em2= getEntityManager();
//        Archivo  b = em2.getReference(Archivo.class,e.getIdArchivo());
//               
//        em2.remove(b);
//    }
//    
//    public void borrarCursoSubCategoria(CursoSubCat e)
//    {
//        EntityManager em2= getEntityManager();
//        CursoSubCat  b = em2.getReference(CursoSubCat.class,e.getIdSubcat());
//               
//        em2.remove(b);
//    }
//    public void borrarCursoCategoria(CursoCategoria e)
//    {
//        EntityManager em2= getEntityManager();
//        CursoCategoria  b = em2.getReference(CursoCategoria.class,e.getIdCat());
//               
//        em2.remove(b);
//    }
//     public void borrarCurso(Curso e)
//    {
//        EntityManager em2= getEntityManager();
//        Curso  b = em2.getReference(Curso.class,e.getIdCurso());
//               
//        em2.remove(b);
//    }
//     
//     public void borrarForoSubCategoria(ForoSubcategoria e)
//    {
//        EntityManager em2= getEntityManager();
//        ForoSubcategoria  b = em2.getReference(ForoSubcategoria.class,e.getIdSubcategoria());
//               
//        em2.remove(b);
//    }
//     
//    public void borrarForoPosteos(ForoPosteos e)
//    {
//        EntityManager em2= getEntityManager();
//        ForoPosteos  b = em2.getReference(ForoPosteos.class,e.getIdPost());
//               
//        em2.remove(b);
//    }
//    
//    public void borrarLogSubidas(LogSubidas e)
//    {
//        EntityManager em2= getEntityManager();
//        LogSubidas  b = em2.getReference(LogSubidas.class,e.getIdLog());
//               
//        em2.remove(b);
//    }
//    
//     public void borrarSS(InscripcionCurso e)
//    {
//        EntityManager em2= getEntityManager();
//        LogSubidas  b = em2.getReference(LogSubidas.class,e.getIdInsc());
//               
//        em2.remove(b);
//    }
}
