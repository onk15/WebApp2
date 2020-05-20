package io.github.mat3e;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class LangRepository
{
    Optional<Lang> findById(Integer iD)
    {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.get(Lang.class,iD);
        transaction.commit();
        session.close();
        return Optional.ofNullable(result);
    }

}
