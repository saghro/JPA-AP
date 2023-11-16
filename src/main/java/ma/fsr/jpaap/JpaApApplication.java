package ma.fsr.jpaap;

import ma.fsr.jpaap.entities.Patient;
import ma.fsr.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
  @Autowired
  private PatientRepository patientRepository;
  public static void main(String[] args) {
    SpringApplication.run(JpaApApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    patientRepository.save(new Patient(null, "yuba",new Date() ,false ,233));
    patientRepository.save(new Patient(null, "sara",new Date() ,true ,453));
    patientRepository.save(new Patient(null, "brahim",new Date() ,true ,87));
    List<Patient> patients = patientRepository.findAll();
       patients.forEach(patient -> {
         System.out.println(patient.getId());
         System.out.println(patient.getNom());
         System.out.println(patient.getDateNaissance());
         System.out.println(patient.isMalade());
         System.out.println(patient.getScore());
       });
    System.out.println("**************************************");
       Patient p = patientRepository.findById(1L).orElse(null);
       if(p!=null){
         System.out.println(p.getNom());
         System.out.println(p.isMalade());
       }
  }
}
