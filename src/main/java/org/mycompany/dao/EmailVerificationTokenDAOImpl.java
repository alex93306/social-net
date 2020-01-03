package org.mycompany.dao;

import org.mycompany.entity.EmailVerificationToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//todo: transactional here or in service??
@Repository
@Transactional
public class EmailVerificationTokenDAOImpl implements EmailVerificationTokenDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EmailVerificationToken findByToken(String token) {
        String queryString = "select e from EmailVerificationToken e where e.token = :token order by e.created";
        TypedQuery<EmailVerificationToken> query = em.createQuery(queryString, EmailVerificationToken.class);
        List<EmailVerificationToken> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public EmailVerificationToken save(EmailVerificationToken emailVerificationToken) {
        return null;
    }
}
