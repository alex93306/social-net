package org.mycompany.dao;

import org.mycompany.entity.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AppUserDaoImpl implements AppUserDao {

//    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public AppUser get(Long id) {
        return emf.createEntityManager().find(AppUser.class, id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        //todo: investigate long or object return
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(appUser);
       return appUser;
    }

    @Override
    public void update(AppUser appUser) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public AppUser findByUsername(String username) {
        Query namedQuery = emf.createEntityManager().createNamedQuery("from AppUser where username = :username");
        namedQuery.setParameter("username", username);

        return (AppUser) namedQuery.getSingleResult();
    }

    @Override
    public AppUser findByVerifyKey(String verifyKey) {
        return null;
    }
}
