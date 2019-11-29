package org.mycompany.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "findByToken", query = "select e from EmailVerificationToken e where e.token = :token")
})
public class EmailVerificationToken extends AbstractToken {
}
