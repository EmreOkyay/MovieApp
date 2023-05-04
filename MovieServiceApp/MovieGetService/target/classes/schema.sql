-- japp1j22_moviesdb

create table if not exists movies (
    movie_id bigserial primary key,
    name varchar(256) not null,
    scene_date date not null,
    rating bigint not null default(0) check(rating >= 0),
    cost real not null,
    imdb float4 not null default(0.0)
);

create table if not exists directors (
    director_id bigserial primary key,
    first_name varchar(100) not null,
    middle_name varchar(100),
    family_name varchar(100) not null,
    birth_date date not null
);

create table if not exists movies_to_director (
    movies_to_director_id bigserial primary key,
    movie_id bigint references movies(movie_id),
    director_id bigint references directors(director_id)
);

truncate table movies_to_director restart identity cascade;
truncate table directors restart identity cascade;
truncate table movies restart identity cascade;

create or replace function get_directors_by_movie_id(mid bigint)
returns table (
    fullname varchar,
    birth_date date
)
as '
    begin

        return query select
                    case
                         when d.middle_name isnull then cast(d.first_name || $$ $$ || d.family_name as varchar(200))
                         else cast(d.first_name || $$ $$ || d.middle_name || $$ $$  || d.family_name as varchar(200))
                    end,
                    d.birth_date
                 from directors d inner join movies_to_director mtd on mtd.director_id = d.director_id
                 where mtd.movie_id = mid;
end
    '  language plpgsql;

create or replace function get_movies_by_director_id(id bigint)
returns table (
    name varchar(256),
    scene_date date,
    rating bigint,
    cost real,
    imdb float4
)
as '
    begin
        return query select
                m.name, m.scene_date, m.rating, m.cost, m.imdb
                 from movies m inner join movies_to_director mtd on mtd.movie_id = m.movie_id
                 where mtd.director_id = id;
end
    '  language plpgsql;

create or replace procedure sp_insert_director(bigint, varchar(100), varchar(100), varchar(100), date)
language plpgsql
as '
	begin
		insert into directors (director_id, first_name, middle_name, last_name, birth_date)
            values ($1, $2, $3, $4, $5);
    end
';