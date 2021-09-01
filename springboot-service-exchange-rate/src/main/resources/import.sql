INSERT INTO maestra_tipo_cambio (MONEDA_ORIGEN, MONEDA_DESTINO,TIPO_CAMBIO ,FECHA_CAMBIO) VALUES('USD', 'PER',4.08, NOW());
INSERT INTO maestra_tipo_cambio (MONEDA_ORIGEN, MONEDA_DESTINO,TIPO_CAMBIO ,FECHA_CAMBIO) VALUES('PER', 'USD',0.25, NOW());
INSERT INTO maestra_tipo_cambio (MONEDA_ORIGEN, MONEDA_DESTINO,TIPO_CAMBIO ,FECHA_CAMBIO) VALUES('EUR', 'PER',4.82, NOW());
INSERT INTO maestra_tipo_cambio (MONEDA_ORIGEN, MONEDA_DESTINO,TIPO_CAMBIO ,FECHA_CAMBIO) VALUES('PER', 'EUR',0.21, NOW());

INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('victor','$2a$10$VaxtnXXtgKYHhq9eZtiD.uEFKmDAV9DoLoZnHU4szGebycLmERtwW',1, 'Victor', 'Matos','msvictorkevin@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$TVpCkF5orFL659RYUtHMHOEFytPiUAT7dEU2YCCp5VxPKBytzVjre',1, 'Juan', 'Perez','juanperezadmin.ms@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);


