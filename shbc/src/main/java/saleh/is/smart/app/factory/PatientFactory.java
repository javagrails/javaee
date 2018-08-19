package saleh.is.smart.app.factory;

import saleh.is.smart.app.domain.Patient;

public class PatientFactory {
    public Patient createPatient(int id, String name) {
        System.out.println("Using factory class to create Patient");
        return new Patient(id, name);
    }

}
