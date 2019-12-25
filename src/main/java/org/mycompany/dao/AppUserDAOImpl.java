package org.mycompany.dao;

import org.mycompany.entity.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AppUserDAOImpl implements AppUserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public AppUser find(Long id) {
        return em.find(AppUser.class, id);
    }

    @Override
    public AppUser findByEmail(String email) {
        Query query = em.createNamedQuery("findByEmail");
        return (AppUser) query.getSingleResult();
    }

    @Override
    public AppUser findByVerificationToken(String token) {
        Query query = em.createNamedQuery("findByEmailVerificationToken");
        return (AppUser) query.getSingleResult();
    }

    @Override
    public AppUser findByResetPasswordToken(String token) {
        Query query = em.createNamedQuery("findByResetPasswordToken");
        return (AppUser) query.getSingleResult();
    }

    @Override
    public AppUser save(AppUser appUser) {
        em.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser update(AppUser appUser) {
        //todo: replace it with save. Make saveOrUpdate. I can't come up way how to check if bean is new
        return em.merge(appUser);
    }
}
