**********************************************************************
PROJET ANDROID BIO/SE : Application destinée aux enfants malades
**********************************************************************
Auteurs : Chloé ANDRIAMISEZA - Epiphanie OUEDRAOGO

Information générale : Cette partie du projet représente la partie IHM du projet (soucis avec le Git pour le côté base de données géré par Epiphanie) avec l'architecture de la base de données


Objectif : Cette application a été conçue pour permettre aux enfants malades de gérer leur quotidien médical

FONCTIONALITES : 
	Interface prendre un nouveau rendez-vous
	Interface programmer sa prise de médicaments
	Interface gérer ses contacts (membres de l'équipe médicale)

EXIGENCES
	Faciliter la navigation au sein de l'IHM : utilisations uniquements de fragments

TECHNOLOGIES UTILISEES 
	Java For Android 
	XML pour les ressources du projet


ARCHITECTURE IHM: 1 activité, 10 Fragments, 1 Navigation 
	Activité vide : fragment viewver host
	1 Fragment : menu principal
	3 Fragments : Listes pour redndez-vous, contacts, traitement
	3 Fragments : Création rendez vous, contact, traitement
BASE DE DONNEES
	6 classes différents : 3 Dao et 3 Model

EXTENSIONS ENSAGESS
	Connexion à la base de données : à terminer 
	Affichage en RecyclerView des listes : à corriger
	Amélioration de l'IHM



	