CREATE TABLE tag(
	tag_name varchar(100) PRIMARY KEY
);
CREATE TABLE person 
(
	id integer PRIMARY KEY,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	job_title varchar(100) DEFAULT 'Неизвестно',
	user_comment TEXT
);
CREATE TABLE operation_type
(
	type_name varchar(20) PRIMARY KEY
);
CREATE TABLE operation
(
	id integer PRIMARY KEY,
	operation_date date	NOT NULL,
	operation_type_fk varchar(20) REFERENCES operation_type(type_name) NOT NULL,
	person_fk integer REFERENCES person(id) NOT NULL
);

CREATE TABLE item_state
(
	state_name varchar(20) PRIMARY key
);
CREATE TABLE item
(
	id integer PRIMARY KEY,
	item_name varchar(200) NOT NULL,
	article varchar(20),
	items_count integer NOT NULL DEFAULT '1' CHECK (items_count > 0),
	state_fk varchar(20) REFERENCES item_state(state_name) NOT NULL 
);
CREATE TABLE image
(
	id integer PRIMARY KEY,
	image_source varchar(200) NOT NULL,
	item_fk integer REFERENCES item(id) NOT null
);
CREATE TABLE item_tag
(
	id integer PRIMARY KEY,
	item_fk integer REFERENCES item(id) NOT NULL,
	tag_fk varchar(100) REFERENCES tag(tag_name) NOT null
);
CREATE TABLE item_operation
(
	id integer PRIMARY KEY,
	item integer REFERENCES item(id) NOT NULL,
	operation integer REFERENCES operation(id) NOT NULL
)


