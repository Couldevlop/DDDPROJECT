package com.openlab.edition;

import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.application.EditionService;
import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.auteur.Skills;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.cours.model.Cours;
import com.openlab.edition.infras.config.EmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


//@RunWith(SpringRunner.class)
@SpringBootTest(classes = EditionApplicationTests.class)
class EditionApplicationTests {
	@Mock
	private ContenuProvider contenuProvider;
	@Mock
	private AuteurProvider auteurProvider;

	@Mock
	private CommentaireProvider commentaireProvider;

	@Mock
	private EmailService emailService;

	@Mock
	private KafkaTemplate <String, String> kafkaTemplate;

	@InjectMocks
	private EditionService editionService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("On register article, call contenuProvider")
	public void testCreateArticle(){
		// given

		Article article = new Article();
		article.setAuteur(new Auteur());
		article.setId(1L);
		article.setContent("ceci est un contenu");
		article.setDomaine("informatique");
		article.setTitle("DDD en action");

		//when
		editionService.createArticle(article);

		//then
		verify(contenuProvider, times(1)).save(article);
		verify(kafkaTemplate, times(1)).send(eq("contenu-a-etudier"),anyString());
	}

	@Test
	@DisplayName(" on register cours, call contenuProvider")
	public void testCreateCoursWithSkills(){
		//given
		Auteur auteur = new Auteur();
		auteur.setId(1L);
		auteur.setEmail("coulwao@gmail.com");
		auteur.setName("COULIBALY WAOPRON");


		auteur.setSkills(List.of(new Skills(1,"Physiques", ""),
				new Skills(2,"Mathématiques","")));

		Cours cours = new Cours();
		cours.setId(1L);
		cours.setSubject("Mathématiques");
		cours.setContent("c'est un contenu");
		cours.setDomaine("La santé");

		cours.setAuteur(auteur);

		//when
		editionService.createCours(cours);

		//then
		verify(contenuProvider, times(1)).save(cours);
		verify(kafkaTemplate, times(1)).send(eq("contenu-a-etudier"), anyString());
	}


	@Test
	@DisplayName("On register cours without skills, call contenuProvider")
	public void testCreateCoursWithoutSkills(){

		//given
		Auteur auteur = new Auteur();
		auteur.setSkills(List.of(new Skills(1, "Physique", "8 ans")));

		Cours cours = new Cours();
		cours.setAuteur(auteur);
		cours.setTitle("Un titre");
		cours.setStatus(Status.PUBLIE);
		cours.setSubject("Mathématiques");
		cours.setTitle("C'est titre");


		//when
		assertThrows(IllegalArgumentException.class, () ->{
			editionService.createCours(cours);
		});

		verify(contenuProvider, times(0)).save(cours);
		verify(kafkaTemplate, times(0)).send(anyString(),anyString());
	}

}
