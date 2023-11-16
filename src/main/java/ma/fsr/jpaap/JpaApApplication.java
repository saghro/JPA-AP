package ma.fsr.jpaap;

import ma.fsr.jpaap.entities.Patient;
import ma.fsr.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
    for (int i = 0; i <100 ; i++) {
      patientRepository.save(new Patient(null, "yuba",new Date() ,Math.random()>0.5?true:false ,(int)(Math.random()*100)));

    }

    Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,5));
    System.out.println("Total pages :" +patients.getTotalPages());
    System.out.println("Total element :" +patients.getTotalElements());
    System.out.println("num pages :" +patients.getNumber());
    List<Patient> content = patients.getContent();
    Page<Patient> byMalade = patientRepository.findByMalade( true,PageRequest.of(0,10));
    List<Patient> patientList = patientRepository.chercherPatient("%y%" ,30);
    byMalade.forEach(patient -> {
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
       p.setScore(8788);
       patientRepository.save(p);
       patientRepository.deleteById(2L);
  }
}
