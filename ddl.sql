CREATE TABLE public.t_league (
	id serial4 NOT NULL,
	name varchar NULL,
	CONSTRAINT t_league_pkey PRIMARY KEY (id)
);

CREATE TABLE public.t_team (
	id serial4 NOT NULL,
	league_id int4 NULL,
	"name" varchar NULL,
	nationality varchar NULL,
	score numeric NULL,
	CONSTRAINT t_team_pkey PRIMARY KEY (id)
);

ALTER TABLE public.t_team ADD CONSTRAINT t_team_league_id_fkey FOREIGN KEY (league_id) REFERENCES public.t_league(id);


-- public.t_games definition

-- Drop table

-- DROP TABLE public.t_games;

CREATE TABLE public.t_games (
	id serial4 NOT NULL,
	hostteam_id int4 NULL,
	opponent_id int4 NULL,
	winner_id int4 NULL,
	league_id int4 NULL,
	CONSTRAINT t_games_pkey PRIMARY KEY (id)
);


-- public.t_games foreign keys

ALTER TABLE public.t_games ADD CONSTRAINT t_games_fk FOREIGN KEY (league_id) REFERENCES public.t_league(id);
ALTER TABLE public.t_games ADD CONSTRAINT t_games_hostteam_id_fkey FOREIGN KEY (hostteam_id) REFERENCES public.t_team(id);
ALTER TABLE public.t_games ADD CONSTRAINT t_games_opponent_id_fkey FOREIGN KEY (opponent_id) REFERENCES public.t_team(id);
ALTER TABLE public.t_games ADD CONSTRAINT t_games_winner_id_fkey FOREIGN KEY (winner_id) REFERENCES public.t_team(id);