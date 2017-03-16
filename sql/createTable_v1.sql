
/* Description of different root areas for which DEVOPS assessment is done e.g- continous delivery */
create table maturity_model(
id int not null AUTO_INCREMENT,
name varchar(255),
primary key(id)
);



/* Description of list of categories inside every root area(maturity model) for which assessment is done 
e.g- Continous Integration category inside continous delivery */


create table category(
id int not null AUTO_INCREMENT,
root_id int,
name varchar(255),
primary key(id),
foreign key(root_id) references  maturity_model(id)
);


/*Description of list of subcategories inside every category  for which assessment is done 
e.g- Dev Quality subcategory inside Continous Integration */ 


create table sub_category(
id int not null AUTO_INCREMENT,
category_id int,
sub_category_name text,
primary key(id),
foreign key(category_id) references category(id)
);

/* Description of different maturity levels of the sub_category, e.g. Repatable, Regressive etc */
create table  maturity_level(id int not null, 
level_name varchar(255), 
level_score int,
primary key(id)
);


/*Description of different clients whose projects are to be assessed */
create table client_details(
id int not null AUTO_INCREMENT,
name varchar(255),
primary key(id)
);

/* Description of different projects under various clients */
create table project_details(
id int not null AUTO_INCREMENT,
client_id int,
name varchar(255),
business_vertical varchar(255),
dev_team_size int,
qa_team_size int,
primary key(id),
foreign key(client_id) references client_details(id)
);


/* Description of options that are to be chosen to evaluate the maturity_level of a subcategory */
create table question(
id int not null AUTO_INCREMENT,
sub_category_id int,
maturity_criteria  longtext,
maturity_level_score int,
primary key(id),
foreign key(sub_category_id) references sub_category(id)
);

/*Description Pending */
create table tech_stack(
id int not null AUTO_INCREMENT,
project_id int,
presentation_tier varchar(255),
middle_tier varchar(255),
data_tier varchar(255),
integration_tier varchar(255),
primary key(id), foreign key(project_id) references project_details(id)
);



/* Description of the assessment that is done for a particular project for a respective client */
  create table assessment(
  project_id int(11), 
  test_id int not null AUTO_INCREMENT,
  test_date datetime,
  primary key(test_id),
foreign key(project_id) references project_details(id)
  );
  
 /* Describes the user comment for the respective subcategory for a given assessment */
create table user_comment(
  id  int not null AUTO_INCREMENT, 
  test_id int (11) ,
  sub_category_id int(11),
  user_comments text,
  primary key(id),
foreign key(test_id) references assessment(test_id),
foreign key(sub_category_id) references sub_category(id)
  );
  
  /* Describes the maturity level for the respective subcategory for a given assessment*/
	create table response_details(
  response_id  int not null AUTO_INCREMENT, 
  test_id int (11) ,
  sub_category_id int(11),
  maturity_level_id int(11),
  primary key(response_id),
foreign key(test_id) references assessment(test_id),
foreign key(sub_category_id) references sub_category(id),
foreign key (maturity_level_id) references  maturity_level(id)
  );
  
  /* Describes the maturity criteria choosen for the respective subcategory for a given assessment*/
  create table response_value(
  id  int not null AUTO_INCREMENT, 
  response_id int (11) ,
   question_id int(11),
  primary key(id),
foreign key(response_id) references response_details(response_id),
foreign key(question_id) references question(id)
  );
  













