ALTER TABLE screenings
ADD COLUMN urgency varchar(10),
ADD CONSTRAINT urgency_check CHECK (urgency = ANY (ARRAY['ALTO', 'MEDIO', 'BAIXO']));