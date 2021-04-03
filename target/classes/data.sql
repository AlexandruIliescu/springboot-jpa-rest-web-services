insert into users(id, age, country, email, username) values(1, 27, 'Romania', 'alex@gmail.com', 'Alex_23');
insert into users(id, age, country, email, username) values(2, 27, 'Romania', 'george99@gmail.com', 'George_124');
insert into users(id, age, country, email, username) values(3, 27, 'Romania', 'claudiu@gmail.com', 'Claudiu_303');

insert into artists(id, country, name) values(1, 'UK', 'Pink Floyd');
insert into artists(id, country, name) values(2, 'USA', 'Metallica');
insert into artists(id, country, name) values(3, 'UK', 'Coldplay');

insert into albums(id, genre, title, year, artist_id) values(1, 'rock', 'Something to think', 2017, 1);
insert into albums(id, genre, title, year, artist_id) values(2, 'rock', 'Last summer', 2018, 1);
insert into albums(id, genre, title, year, artist_id) values(3, 'rock', 'Go wild', 2019, 1);
insert into albums(id, genre, title, year, artist_id) values(4, 'rock', 'Ride the lightning', 1984, 2);
insert into albums(id, genre, title, year, artist_id) values(5, 'rock', 'Master of puppets', 1986, 2);
insert into albums(id, genre, title, year, artist_id) values(6, 'rock', 'Load', 1986, 2);
insert into albums(id, genre, title, year, artist_id) values(7, 'rock', 'Parachutes', 2000, 3);
insert into albums(id, genre, title, year, artist_id) values(8, 'rock', 'Everyday life', 2019, 3);
insert into albums(id, genre, title, year, artist_id) values(9, 'rock', 'Ghost stories', 2014, 3);

insert into songs(id, duration, title, album_id) values(1, 3.14, 'Magic winter', 1);
insert into songs(id, duration, title, album_id) values(2, 3.14, 'Go go', 1);
insert into songs(id, duration, title, album_id) values(3, 3.14, 'Where you are', 2);
insert into songs(id, duration, title, album_id) values(4, 3.14, 'This is something', 3);
insert into songs(id, duration, title, album_id) values(5, 2.34, 'You can do it', 3);
insert into songs(id, duration, title, album_id) values(6, 3.43, 'Nothing else matters', 4);
insert into songs(id, duration, title, album_id) values(7, 3.42, 'Fade to black', 4);
insert into songs(id, duration, title, album_id) values(8, 3.29, 'Battery', 5);
insert into songs(id, duration, title, album_id) values(9, 3.21, 'The unforgiven', 5);
insert into songs(id, duration, title, album_id) values(10, 4.11, 'Viva la vida', 6);
insert into songs(id, duration, title, album_id) values(11, 3.20, 'Paradise', 6);
insert into songs(id, duration, title, album_id) values(12, 3.02, 'Yellow', 7);
insert into songs(id, duration, title, album_id) values(13, 3.36, 'In my place', 7);
insert into songs(id, duration, title, album_id) values(14, 3.57, 'Magic', 8);
insert into songs(id, duration, title, album_id) values(15, 3.28, 'Winter', 9);

insert into playlists(id, name, user_id) values(1, 'Chillout vibes', 1);
insert into playlists(id, name, user_id) values(2, 'Road trip', 1);
insert into playlists(id, name, user_id) values(3, 'Rock', 1);
insert into playlists(id, name, user_id) values(4, 'Morning songs', 2);
insert into playlists(id, name, user_id) values(5, 'Outdoor', 2);
insert into playlists(id, name, user_id) values(6, 'Turn it loud', 2);
insert into playlists(id, name, user_id) values(7, 'Turn it loud', 3);
insert into playlists(id, name, user_id) values(8, 'Relax', 3);
insert into playlists(id, name, user_id) values(9, 'Summer', 3);

-- truncate table playlists_songs, albums, artists, playlists, songs, users