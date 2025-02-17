SELECT * FROM ga.member;

INSERT INTO member (email, name, password, role, username) 
VALUES 
('billy@booklink.com', 'Billy Bompipi', '$2a$12$mPG0LpgqBp2DquVtU1aXEu4uALE1oiwIHnjxwA4E3o.1D13djlAdi', 'ROLE_USER', 'billy'),
('admin@booklink.com', 'Teddy', '$2a$12$mPG0LpgqBp2DquVtU1aXEu4uALE1oiwIHnjxwA4E3o.1D13djlAdi', 'ROLE_ADMIN', 'admin');