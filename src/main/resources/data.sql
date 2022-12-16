INSERT INTO wall_bracket (id, size, adjustable, name, price) VALUES (1001, '25X32', false, 'LG bracket', 32.23);
INSERT INTO wall_bracket (id, size, adjustable, name, price) VALUES (1002, '25X32/32X40', true, 'LG bracket', 32.23);
INSERT INTO wall_bracket (id, size, adjustable, name, price) VALUES (1003, '25X25', false, 'Philips bracket', 32.23);
INSERT INTO wall_bracket (id, size, adjustable, name, price) VALUES (1004, '25X32/32X40', true, 'Nikkei bracket', 32.23);
INSERT INTO wall_bracket (id, size, adjustable, name, price) VALUES (1005, '25X32', false, 'Nikkei bracket', 32.23);

INSERT INTO driver_profile (id, open) VALUES (1001, 'nog in te vullen');

INSERT INTO car (id, license_plate, model, brand) VALUES (1001, '6KKS73', 'Punto', 'Fiat');


INSERT INTO television (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1001, 'NH3216SMART', 'Nikkei', 'HD smart TV', 159, 32, 100, 'LED', 'HD ready',  true, true, false, false, false, false, 235885, 45896);
INSERT INTO television (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1002, '43PUS6504/12/L', 'Philips', '4K UHD LED Smart Tv', 379, 43, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 8569452, 5685489);
INSERT INTO television (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1003, '43PUS6504/12/M', 'Philips', '4K UHD LED Smart Tv', 379, 50, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 345549, 244486);
INSERT INTO television (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1004, '43PUS6504/12/S', 'Philips', '4K UHD LED Smart Tv', 379, 58, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 6548945, 4485741);
INSERT INTO television (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1005, 'OLED55C16LA', 'LG', 'LG OLED55C16LA', 989, 55, 100, 'OLED', 'ULTRA HD',  true, true, true, true, true, false, 50000, 20500);

INSERT INTO television_wall_bracket(television_id, wall_bracket_id) values (1005, 1001);
INSERT INTO television_wall_bracket(television_id, wall_bracket_id) values (1005, 1002);
INSERT INTO television_wall_bracket(television_id, wall_bracket_id) values (1002, 1003);
INSERT INTO television_wall_bracket(television_id, wall_bracket_id) values (1003, 1003);
INSERT INTO television_wall_bracket(television_id, wall_bracket_id) values (1004, 1003);
INSERT INTO television_wall_bracket(television_id, wall_bracket_id) values (1001, 1004);
INSERT INTO television_wall_bracket(television_id, wall_bracket_id) values (1001, 1005);


INSERT INTO users (username, password, firstname, lastname, phone_number, email, enabled, bio) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'Drik', 'vd Broek', 0693738772, 'user@test.nl', TRUE, 'De beste rijder ter wereld!');
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_DRIVER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_PASSENGER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_DRIVER');