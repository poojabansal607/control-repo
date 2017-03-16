
create table root_area(
id int not null AUTO_INCREMENT,
name varchar(255),
primary key(id)
);

create table category(
id int not null AUTO_INCREMENT,
rootId int,
name varchar(255),
primary key(id),
foreign key(rootId) references root_area(id)
);

create table subcategory(
id int not null AUTO_INCREMENT,
categoryId int,
subCategoryName text,
primary key(id),
foreign key(categoryId) references category(id)
);

create table client_details(
id int not null AUTO_INCREMENT,
name varchar(255),
primary key(id)
);

create table project_details(
id int not null AUTO_INCREMENT,
clientId int,
name varchar(255),
businessVertical varchar(255),
devTeamSize int,
qaTeamsize int,
primary key(id),
foreign key(clientId) references client_details(id)
);

create table question(
id int not null AUTO_INCREMENT,
subCategoryId int,
questionName longtext,
rating_score int,
primary key(id),
foreign key(subCategoryId) references subcategory(id)
);


create table tech_stack(
id int not null AUTO_INCREMENT,
projectId int,
presentationTier varchar(255),
middleTier varchar(255),
dataTier varchar(255),
integrationTier varchar(255),
primary key(id)
);