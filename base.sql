create sequence idEtudiant;

create sequence idAnneeEtude;

create sequence idCycle;

create sequence idMatiere;

create sequence idJour;

create table matiere
(
    idMatiere char(30) primary key default concat('M00',nextVal('idMatiere')),
    nomMatiere char(255)
);

create table anneeEtude
(
    idAnneeEtude char(30) primary key default concat('A00',nextVal('idAnneeEtude')),
    annee char(255)
);

create table etudiant
(
    idetudiant char(30) primary key default concat('E00',nextVal('idEtudiant')),
    nomEtudiant char(255),
    prenomEtudiant char(255),
    dateNaissance date,
    email char(255),
    mdp char(255),
    idAnneeEtude char(30),
    photoprofil text,
    foreign key(idAnneeEtude) references anneeEtude(idAnneeEtude)
);

create table cycle
(
    idCycle char(30) primary key default concat('C00',nextVal('idCycle')),
    idEtudiant char(30),
    duree int,
    foreign key(idetudiant) references etudiant(idetudiant)
);

create table jour
(
    idJour char(30) primary key default concat('J00',nextVal('idJour')),
    nomJour char(255)
);

create table note_etudiant_matiere
(
    idetudiant char(30),
    idMatiere char(30),
    note float,
    dateajout date default current_date,
    foreign key(idetudiant) references etudiant(idetudiant),
    foreign key(idMatiere) references matiere(idMatiere)
);

create table emploi_temps_manuelle
(
    idetudiant char(30),
    idJour char(30),
    heureDebut time,
    heureFin time,
    idMatiere char(30),
    etat int default 0,
    check (heureDebut<heureFin),
    check (heureFin>heureDebut),
    foreign key(idetudiant) references etudiant(idetudiant),
    foreign key (idJour) references jour(idJour),
    foreign key(idMatiere) references matiere(idMatiere)
);


create table emploi_temps_auto
(
    idetudiant char(30),
    idJour char(30),
    heureDebut time,
    heureFin time,
    idMatiere char(30),
    etat int default 0,
    check (heureDebut<heureFin),
    check (heureFin>heureDebut),
    foreign key(idetudiant) references etudiant(idetudiant),
    foreign key (idJour) references jour(idJour),
    foreign key(idMatiere) references matiere(idMatiere)
);


insert into matiere values(default,'Anglais'),(default,'Fracais'),(default,'Mathematique'),(default,'Physique'),(default,'Chimie');

insert into anneeEtude values(default,'Bacc'),(default,'Bacc+1');

insert into etudiant values(default,'Rakoto','Manitra','2003-04-18','manitrarakotoar@gmail.com','Manitra07!','A002',null);

insert into note_etudiant_matiere values('E001','M003','10.0',default);

insert into jour values(default,'Lundi'),(default,'Mardi'),(default,'Mercredi'),(default,'Jeudi'),(default,'Vendredi'),(default,'Samedi'),(default,'Dimanche');

insert into cycle values(default,'E001','50');