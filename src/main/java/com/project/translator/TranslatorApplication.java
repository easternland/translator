package com.project.translator;

import com.project.translator.controller.TranslatorController;
import com.translated.lara.translator.TranslateOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.translated.lara.Credentials;
import com.translated.lara.errors.LaraException;
import com.translated.lara.translator.TextResult;
import com.translated.lara.translator.Translator;

@EnableFeignClients
@SpringBootApplication
public class TranslatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslatorApplication.class, args);
	}
}
