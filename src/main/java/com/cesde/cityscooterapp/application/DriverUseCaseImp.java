package com.cesde.cityscooterapp.application;

import com.cesde.cityscooterapp.application.inpurport.DriverUseCase;
import com.cesde.cityscooterapp.application.outputports.DriverPersistencePort;
import com.cesde.cityscooterapp.domain.Driver;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DriverUseCaseImp implements DriverUseCase {

    private final DriverPersistencePort driverPersistencePort;

    public DriverUseCaseImp(DriverPersistencePort driverPersistencePort) {
        this.driverPersistencePort = driverPersistencePort;
    }

    @Override
    public Driver createrDriver(Driver driver) {
        return driverPersistencePort.saveDriver(driver);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return null; // Aquí luego mapearán su lógica de actualización
    }

    @Override
    public Optional<Driver> getDriverById(Integer id) { // Cambiado a Integer
        // Como el puerto ya devuelve un Optional<Driver>, lo retornamos directo.
        // No hace falta usar .stream() ni filtros redundantes aquí.
        return driverPersistencePort.findDriverById(id);
    }
}