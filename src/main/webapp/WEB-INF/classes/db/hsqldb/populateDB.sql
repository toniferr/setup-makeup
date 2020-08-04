/* Populate tables */
INSERT INTO users (id, username, password, enabled) VALUES(1, 'admin', '$2y$04$eBLa08KM6JrkA/xdNl8pIOmEyD/6G31rdPdPRYR4UKACN7Pt23af6', 1);
INSERT INTO users (id, username, password, enabled) VALUES(2, 'toni', '$2y$04$eBLa08KM6JrkA/xdNl8pIOmEyD/6G31rdPdPRYR4UKACN7Pt23af6', 1);
INSERT INTO users (id, username, password, enabled) VALUES(3, 'anxela', '$2y$04$eBLa08KM6JrkA/xdNl8pIOmEyD/6G31rdPdPRYR4UKACN7Pt23af6', 1);

INSERT INTO authorities (id, user_id, authority) VALUES(1, 1, 'ROLE_ADMIN');
INSERT INTO authorities (id, user_id, authority) VALUES(2, 1, 'ROLE_USUARIO');
INSERT INTO authorities (id, user_id, authority) VALUES(3, 2, 'ROLE_USUARIO');
INSERT INTO authorities (id, user_id, authority) VALUES(4, 3, 'ROLE_ADMIN');
INSERT INTO authorities (id, user_id, authority) VALUES(5, 3, 'ROLE_USUARIO');

/* Populate tables */
INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(1, 'Potingues de cara', null, 1);
INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(2, 'Potingues de cuerpo', null, 1);

INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(6, 'Potingues de cara', null, 2);
INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(7, 'Potingues de cuerpo', null, 2);

INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(9, 'Maquillaje', null, 3);
INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(10, 'Cuidado facial', null, 3);
INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(11, 'inspiracion', 9, 3);
INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(12, 'productos', 9, 3);
INSERT INTO categoria (id, nombre, padre_id, usuario_id) VALUES(14, 'bases', 12, 3);

/* Populate tables */
INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(1, 'Crema hidratante', null, null, 1);
INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(2, 'acetona', null, null, 2);
INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(3, 'pintauñas', null, null, 2);

INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(4, 'raya de ojos fluorescentes', null, null, 11);
INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(6, 'hidratante piel', null, null, 14);
INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(7, 'antimaquillaje hidratante', null, null, 14);
INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(8, 'exfoliantee', null, null, 10);
INSERT INTO miembro (id, nombre, foto, descripcion, categoria_id) VALUES(9, 'loreal', null, null, 10);