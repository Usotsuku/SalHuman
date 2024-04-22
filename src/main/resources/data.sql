INSERT INTO users (username, password, enabled) VALUES ('admin', '123', 1);
INSERT INTO users (username, password, enabled) VALUES ('manager', '123', 1);
INSERT INTO users (username, password, enabled) VALUES ('rh', '123', 1);
INSERT INTO users (username, password, enabled) VALUES ('employe', '123', 1);

insert into authorities(username, authority) values ("admin","ROLE_ADMIN")
insert into authorities(username, authority) values ("admin","ROLE_USER")
insert into authorities(username, authority) values ("rh","ROLE_RH")
insert into authorities(username, authority) values ("employe","ROLE_USER")
insert into authorities(username, authority) values ("manager","ROLE_MANAGER")