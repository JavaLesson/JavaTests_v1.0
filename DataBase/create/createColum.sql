create table javatests.test
(
	testId int not null auto_increment,
    name varchar(25) not null,
    data varchar(255) null,
    
    constraint pk_Test primary key (testId)
)