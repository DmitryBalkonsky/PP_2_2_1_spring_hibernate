package hiber.service;

import hiber.dao.CarDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {
    private final CarDao carDao;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByCar(String parModel, int parSeries) {
        return carDao.getUserByCar(parModel, parSeries);
    }
}