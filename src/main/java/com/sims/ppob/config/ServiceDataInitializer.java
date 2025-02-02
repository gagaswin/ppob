package com.sims.ppob.config;

import com.sims.ppob.models.entity.ServiceSims;
import com.sims.ppob.repository.ServiceSimsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceDataInitializer {
  @Bean
  public CommandLineRunner initDataService(ServiceSimsRepository serviceSimsRepository) {
    return args -> {
      if (serviceSimsRepository.count() == 0) {
        serviceSimsRepository.save(ServiceSims.builder().code("PAJAK").name("Pajak PBB").icon("1").price(40000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("PLN").name("Listrik").icon("2").price(10000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("PDAM").name("PDAM Berlangganan").icon("3").price(40000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("PULSA").name("Pulsa").icon("4").price(40000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("PGN").name("PGN Berlangganan").icon("5").price(50000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("TV").name("TV Berlangganan").icon("7").price(50000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("PAKET_DATA").name("Paket data").icon("8").price(50000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("VOUCHER_GAME").name("Voucher game").icon("9").price(100000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("VOUCHER_MAKANAN").name("Voucher makanan").icon("10").price(100000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("QURBAN").name("Qurban").icon("11").price(200000L).build());
        serviceSimsRepository.save(ServiceSims.builder().code("Zakat").name("Zakat").icon("12").price(300000L).build());
        System.out.println("Default service initialized.");
      } else {
        System.out.println("Service already exist in the database.");
      }
    };
  }
}
