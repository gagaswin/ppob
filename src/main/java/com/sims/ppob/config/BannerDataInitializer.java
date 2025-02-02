package com.sims.ppob.config;

import com.sims.ppob.models.entity.Banner;
import com.sims.ppob.repository.BannerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BannerDataInitializer {
  @Bean
  public CommandLineRunner initDataBanner(BannerRepository bannerRepository) {
    return args -> {
      if (bannerRepository.count() == 0) {
        bannerRepository.save(Banner.builder().title("Banner 1").imageUrl("1").description("Lorem ipsum dolor sit amet 1").build());
        bannerRepository.save(Banner.builder().title("Banner 2").imageUrl("2").description("Lorem ipsum dolor sit amet 2").build());
        bannerRepository.save(Banner.builder().title("Banner 3").imageUrl("3").description("Lorem ipsum dolor sit amet 3").build());
        bannerRepository.save(Banner.builder().title("Banner 4").imageUrl("4").description("Lorem ipsum dolor sit amet 4").build());
        bannerRepository.save(Banner.builder().title("Banner 5").imageUrl("1").description("Lorem ipsum dolor sit amet 5").build());
        bannerRepository.save(Banner.builder().title("Banner 6").imageUrl("1").description("Lorem ipsum dolor sit amet 6").build());
        System.out.println("Default banner initialized.");
      } else {
        System.out.println("Banner already exist in the database.");
      }
    };
  }
}
