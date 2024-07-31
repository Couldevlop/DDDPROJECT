# DDDPROJECT

Ce projet est une application directe de l'approche DDD

## ARCHITECTURE TECHNIQUE 

      com.openlab.edition
      │
      ├── domaine
      │   ├── model
      │   │   ├── Editeur.java
      │   │   ├── Contenu.java
      │   │   ├── Article.java
      │   │   ├── Status.java
      │   │   └── Auteur.java
      │   ├── service
      │   │   ├── EditeurProvider.java
      │   │   ├── ContenuProvider.java
      │   │   └── AuteurProvider.java
      │
      ├── application
      │   ├── EditeurService.java
      │   ├── ContenuService.java
      │   ├── AuteurService.java
      │   └── EditionService.java
      │
      ├── event
      │   ├── ContenuSubmittedEvent.java
      │   └── ContenuValidatedEvent.java
      |
      ├── infra
      │   ├── entities
      │   │   ├── EditeurEntity.java
      │   │   ├── ContenuEntity.java
          |   ├── CommentaireEntity.java
      │   │   └── ArticleEntity.java
      │   ├── repositories
      │   │   ├── JpaEditeurRepository.java
      │   │   ├── JpaContenuRepository.java
      |   |   ├── JpaCommentaireRepository.java
      │   │   └── JpaArticleRepository.java
      │   ├── adapters
      │   │   ├── EditeurRepositoryAdapter.java
      │   │   ├── ContenuRepositoryAdapter.java
      │   │   └── AuteurRepositoryAdapter.java
      │   ├── messaging
      │   │   ├── KafkaProducer.java
      │   │   └── KafkaConsumer.java
      │   └── email
      │       └── EmailService.java
      │
      ├── controllers(api)
      │   ├── EditeurController.java
      │   ├── ContenuController.java
      │   └── AuteurController.java
      │
      ├── dto
      │   ├── EditeurDTO.java
      │   ├── ContenuDTO.java
      │   ├── ArticleDTO.java
      │   └── AuteurDTO.java
      │
      │
      ├── mapper
      │   └── Mapper.java
      │
      └── SwaggerConfig.java

## CONFIGURATION DE KAFHA ##
### Via docker-compose ###

```version: '3.8'

networks:
  kafka_network:
    driver: bridge

services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    hostname: zookeeper
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
    ports:
      - "2181:2181"
    networks:
      - kafka_network

  kafka:
    image: confluentinc/cp-kafka:latest
    hostname: kafka
    container_name: kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
    depends_on:
      - zookeeper
    networks:
      - kafka_network

  kafdrop:
    image: obsidiandynamics/kafdrop
    hostname: kafdrop
    container_name: kafdrop
    ports:
      - "9000:9000"
    environment:
      KAFKA_BROKER_CONNECT: kafka:9092
      JVM_OPTS: -Xms32M -Xmx64M
    depends_on:
      - kafka
    networks:
      - kafka_network

----------------------------------------------------------------------------
# Commandes Docker
---------------------------------------------------------------------------

 1. Arrêtez les conteneurs existants :
    docker-compose down
    
2. Supprimez les volumes Docker (optionnel, pour une réinitialisation complète) :
    docker volume prune
    
3. Lancez les nouveaux conteneurs :
    docker-compose up -d
    
4. Examinez les logs des conteneurs pour obtenir plus de détails sur les erreurs éventuelles :
    #docker-compose logs kafka
    docker-compose logs kafdrop
    
5. Assurez-vous que le nom d'hôte kafka peut être résolu correctement au sein du réseau Docker. Vous pouvez vérifier les noms d'hôte et les adresses IP des conteneurs en utilisant :
docker network inspect kafka_network



