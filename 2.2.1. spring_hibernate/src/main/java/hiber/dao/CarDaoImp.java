package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {
    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByCar(String parModel, int parSeries) {
        User user = (User) sessionFactory
                .getCurrentSession()
                .createQuery("from User where car.model=:parModel and car.series=:parSeries")
                .setParameter("parModel", parModel)
                .setParameter("parSeries", parSeries)
                .getSingleResult();
        return user;
    }
}