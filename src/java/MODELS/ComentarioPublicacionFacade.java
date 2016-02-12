/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import ENTITIES.ComentarioPublicacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class ComentarioPublicacionFacade extends AbstractFacade<ComentarioPublicacion> {
    @PersistenceContext(unitName = "youlearn2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioPublicacionFacade() {
        super(ComentarioPublicacion.class);
    }
    
}
